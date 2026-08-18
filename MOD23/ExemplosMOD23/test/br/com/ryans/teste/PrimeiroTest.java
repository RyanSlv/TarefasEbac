package br.com.ryans.teste;

import org.junit.Assert;
import org.junit.Test;

public class PrimeiroTest {

@Test
    public void test() {
    String nome = "Ryan";
    Assert.assertEquals("Ryan", nome);
}

@Test
    public void testNotEquals() {
    String nome = "Ryan";
    Assert.assertNotEquals("Ryan1", nome);
}

}