package br.com.aweb.sistema_vendas.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.aweb.sistema_vendas.model.Role;
import br.com.aweb.sistema_vendas.model.User;
import br.com.aweb.sistema_vendas.repository.UserRepository;
import br.com.aweb.sistema_vendas.repository.RoleRepository;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder encoder) {
        return args -> {

            Role adminRole = roleRepo.findByNome(Role.RoleName.ADMIN)
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setNome(Role.RoleName.ADMIN);
                    return roleRepo.save(role);
                });

            roleRepo.findByNome(Role.RoleName.USER)
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setNome(Role.RoleName.USER);
                    return roleRepo.save(role);
                });

            if (userRepo.findByUsername("admin").isEmpty()) {
                
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("12345")); 
                admin.setRoles(Set.of(adminRole));
                
                User savedUser = userRepo.save(admin);
                System.out.println("   Username: " + savedUser.getUsername());
                System.out.println("   Password: 12345 (codificada)");
                System.out.println("   Roles: " + savedUser.getRoles().size());
            } else {
                System.out.println("Usuário admin já existe");
            }
        };
    }
}