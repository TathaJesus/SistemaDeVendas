package br.com.aweb.sistema_vendas.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome é obrigatório.")
    @Column(length = 100, nullable = false)
    private String nome;
    @NotBlank(message = "Descrição é obrigatória.")
    @Column(length = 255, nullable = false)
    private String descricao;
    @Positive(message = "O preço deve ser maior que zero.")
    @NotNull(message = "O preço é obrigatório.")
    @Column(nullable = false)
    private Double preco;
    @NotNull(message = "Quantidade é obrigatória.")
    @PositiveOrZero(message = "O estoque deve ser maior ou igual a zero")
    @Column(nullable = false)
    private Integer quantidadeEmEstoque;
}
