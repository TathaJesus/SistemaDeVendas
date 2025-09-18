package br.com.aweb.sistema_vendas.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.aweb.sistema_vendas.Model.Produto;
import br.com.aweb.sistema_vendas.Service.ProdutoService;
import jakarta.validation.Valid;





@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //Listar Produtos
    @GetMapping
    public ModelAndView list() {
        return new ModelAndView("produto/list", Map.of("produtos", 
        produtoService.listarTodos()));
    }

    // Formulário de Cadastro
    @GetMapping("/novo")
    public ModelAndView create() {
        return new ModelAndView("produto/form", Map.of("produto", new Produto()));
    }

    // Salvar Produto
    @PostMapping("/novo")
    public String create(@Valid Produto produto, BindingResult result) {
        if (result.hasErrors()) {
            return "produto/form";
        }
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }
    
    // Formulário de Edição
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        
        return new ModelAndView("produto/form", Map.of("produto", new Produto()));
    }

    // Salvar Produto
    @PostMapping("/novo")
    public String create(@Valid Produto produto, BindingResult result) {
        if (result.hasErrors()) {
            return "produto/form";
        }
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }
    
    


    //Deletar Produto
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        produtoService.findProduto(id);
        if (produto.isPresent())
            return new ModelAndView("produto/delete", Map.of("produto", ()));
    }
}
