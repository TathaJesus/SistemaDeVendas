package br.com.aweb.sistema_vendas.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aweb.sistema_vendas.Entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
