package br.com.aweb.sistema_vendas.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aweb.sistema_vendas.Model.Produto;
import br.com.aweb.sistema_vendas.Repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //CREATE
    @Transactional
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    //READ
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    //UPDATE
    @Transactional
    public Produto atualizar(Long id, Produto produtoAtualizado){
        var optionalProduto = buscarPorId(id);
        if (!optionalProduto.isPresent())
            throw new IllegalArgumentException("Produto não encontrado!");

        var produtoExistente = optionalProduto.get();
        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setDescricao(produtoAtualizado.getDescricao());
        produtoExistente.setPreco(produtoAtualizado.getPreco());
        produtoExistente.setQuantidadeEmEstoque(produtoAtualizado.getQuantidadeEmEstoque());

        return produtoRepository.save(produtoExistente);
    }

    //DELETE
    @Transactional
    public void excluir(Long id) {
        
    }

    //public Produto findProduto(Long id) {
    //    Optional<Produto> produto = produtoRepository.findById(id);
    //    if (produto.isPresent())
    //       return produto.get();
    //    throw new RuntimeException("Produto não encontrado!");
    //}
    


}
