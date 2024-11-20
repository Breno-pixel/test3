@Entity
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String localizacao;
    private boolean tanqueCheio;

    public String toString() {
        return "Marca: " + marca + ", Localização: " + localizacao + ", Tanque Cheio: " + (tanqueCheio ? "Sim" : "Não");
    }
}
