package JPA;

import javax.persistence.*;

@Entity
public class VendaProduto {
    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private int quantidade;

    // Getters e Setters
}
