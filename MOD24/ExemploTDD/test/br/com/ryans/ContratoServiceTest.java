package br.com.ryans;

import br.com.ryans.Service.ContratoService;
import br.com.ryans.Service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoService service = new ContratoService();
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

}
