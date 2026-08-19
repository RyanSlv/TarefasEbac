package br.com.ryans;

import br.com.ryans.DAO.ContratoDAOMock;
import br.com.ryans.DAO.ContratoDAO;
import br.com.ryans.DAO.IContratoDAO;
import br.com.ryans.Service.ContratoService;
import br.com.ryans.Service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDAO dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void EsperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDAO dao = new ContratoDAO();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void buscarContratoTest() {
        IContratoDAO dao = new ContratoDAOMock();
        IContratoService service = new ContratoService();

        int contratoID = 1;
        boolean excluido = service.excluirContrato(contratoID);

        Assert.assertTrue(excluido);
    }

    @Test
    public void atualizarContratoTest() {
        IContratoDAO dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);

        ContratoDAOMock contrato = new ContratoDAOMock();
        contrato.setValorTotal(100.0);

        service.atualizarContrato(contrato);

        Assert.assertEquals(100, contrato.getValorTotal(), 0.01);
    }
}
