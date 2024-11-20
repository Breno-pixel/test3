@Service
public class VendaService {

    @Autowired
    private CarroRepository carroRepo;

    @Autowired
    private ContratoRepository contratoRepo;

    public void realizarVenda(Carro carro, Contrato contrato) {
        carro.associarContrato(contrato);
        carroRepo.save(carro);  // Persistir o carro e o contrato no banco
        contratoRepo.save(contrato);
        System.out.println("Venda realizada com sucesso!");
    }
}

