package br.com.ryans.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class AllTests {

    @RunWith(Suite.class)
    @Suite.SuiteClasses({ PrimeiroTest.class, SegundoTest.class})
    public class AllTests {

    }
}
