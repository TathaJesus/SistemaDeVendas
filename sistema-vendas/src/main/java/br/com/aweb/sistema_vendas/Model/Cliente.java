package br.com.aweb.sistema_vendas.model;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    @Size(min = 11, max = 11, message = "CPF deve ter 11 dígitos")
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @NotBlank(message = "Número com DDD é obrigatório")
    @Column(nullable = false, length = 11)
    private String telefone;

    @NotBlank(message = "Logradouro é obrigatório")
    @Column(nullable = false, length = 50)
    private String logradouro;

    private String numero;
    @Column(length = 50)
    private String complemento;

    @NotBlank(message = "Bairro é obrigatório")
    @Column(nullable = false, length = 50)
    private String bairro;

    @NotBlank(message = "Cidade é obrigatório")
    @Column(nullable = false, length = 50)
    private String cidade;

    @NotBlank(message = "UF é obrigatório")
    @Size(min = 2, max = 2, message = "UF deve ter 2 caracteres")
    @Column(nullable = false, length = 2)
    private String uf;

    @NotBlank(message = "CEP é obrigatório")
    @Size(min = 8, max = 8, message = "CEP precisa ter 8 dígitos")
    @Column(nullable = false, length = 8)
    private String cep;


}
