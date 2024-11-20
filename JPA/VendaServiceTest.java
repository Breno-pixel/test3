package JPA;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class VendaServiceTest {
    private VendaService vendaService;
    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("vendasPU");
        em = emf.createEntityManager();
        vendaService = new VendaService();
    }

    @Test
    public void testCriarVenda() {
        Cliente cliente = new Cliente();
        cliente.setNome("Rodrigo");
        em.persist(cliente);

        Produto produto = new Produto();
        produto.setCodigo("A1001");
        produto.setDescricao("Produto 1");
        produto.setValor(10.0);
        em.persist(produto);

        vendaService.iniciarVenda("V1001", cliente);
        Venda venda = em.createQuery("SELECT v FROM Venda v WHERE v.codigo = 'V1001'", Venda.class).getSingleResult();
        assertNotNull(venda);
        assertEquals("INICIADA", venda.getStatus());
    }

    @AfterEach
    public void tearDown() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Venda").executeUpdate();
        em.createQuery("DELETE FROM Produto").executeUpdate();
        em.createQuery("DELETE FROM Cliente").executeUpdate();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

