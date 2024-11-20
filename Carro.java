@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;

    @OneToOne(cascade = CascadeType.ALL)
    private Contrato contrato;

    public void exibirInformacoes() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Contrato: " + contrato);
    }

    public void associarContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
