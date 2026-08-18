package br.com.ryans;

import org.junit.Assert;
import org.junit.Test;

public class TesteClienteTest {

    @Test
    public void testeClasseCliente() {
        TesteCliente cli = new TesteCliente();
        cli.adicionarNome("Ryan");
        cli.adicionarNome1("Ryan");

        Assert.assertEquals("Ryan", cli.getNome());
    }


}
