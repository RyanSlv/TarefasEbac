package br.com.ryans.teste;

import org.junit.Assert;
import org.junit.Test;

public class SegundoTest {

    @Test
    public void test2()  {
        String nome = "Ryan";
        Assert.assertEquals("Ryan", nome);
    }
}
