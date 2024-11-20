package JPA;

import javax.persistence.*;

public class VendaService {
    private EntityManagerFactory emf;
    private EntityManager em;

    public VendaService() {
        emf = Persistence.createEntityManagerFactory("vendasPU");
        em = emf.createEntityManager();
    }

    public void iniciarVenda(String codigo, Cliente cliente) {
        em.getTransaction().begin();
        Venda venda = new Venda();
        venda.setCodigo(codigo);
        venda.setCliente(cliente);
        venda.setStatus("INICIADA");
        venda.setValorTotal(0);
        em.persist(venda);
        em.getTransaction().commit();
    }

    public void adicionarProdutoVenda(Venda venda, Produto produto, int quantidade) {
        em.getTransaction().begin();
        venda.adicionarProduto(produto, quantidade);
        em.merge(venda);
        em.getTransaction().commit();
    }

    public void finalizarVenda(Venda venda) {
        em.getTransaction().begin();
        venda.setStatus("FINALIZADA");
        em.merge(venda);
        em.getTransaction().commit();
    }

    public void cancelarVenda(Venda venda) {
        em.getTransaction().begin();
        venda.setStatus("CANCELADA");
        em.merge(venda);
        em.getTransaction().commit();
    }

    public void fechar() {
        em.close();
        emf.close();
    }
}

