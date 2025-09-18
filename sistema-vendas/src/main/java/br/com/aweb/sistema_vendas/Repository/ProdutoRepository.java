package br.com.aweb.sistema_vendas.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aweb.sistema_vendas.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
