package JPA;

import javax.persistence.*;
import java.util.List;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codigo;

    @ManyToOne
    private Cliente cliente;

    private String status;
    private double valorTotal;

    @OneToMany(mappedBy = "venda")
    private List<VendaProduto> vendaProdutos;

    // Getters e Setters

    public void adicionarProduto(Produto produto, int quantidade) {
        this.valorTotal += produto.getValor() * quantidade;
        // lógica para associar a venda com o produto
    }
}

