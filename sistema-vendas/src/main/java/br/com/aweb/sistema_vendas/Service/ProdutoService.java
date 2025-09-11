package br.com.aweb.sistema_vendas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aweb.sistema_vendas.Entity.Produto;
import br.com.aweb.sistema_vendas.Repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

        // cadastrar/alterar produto
    public Produto createProduct(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listAll() {
        return produtoRepository.findAll();
    }

    public Produto findProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent())
            return produto.get();
        throw new RuntimeException("Produto não encontrado!");
    }
    
}
