package br.com.ryans;

import br.com.ryans.DAO.ClienteDAO;
import br.com.ryans.DAO.ClienteDAOMock;
import br.com.ryans.Service.ClienteService;
import org.junit.Assert;
import org.junit.Test;

public class ClienteServiceTest {

    @Test
    public void salvarTest() {
        ClienteDAOMock mockDAO = new ClienteDAOMock();
        ClienteService service = new ClienteService(mockDAO);
        String retorno  = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {
        ClienteDAO mockDAO = new ClienteDAO();
        ClienteService service = new ClienteService(mockDAO);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }
}

