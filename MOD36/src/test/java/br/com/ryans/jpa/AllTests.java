package br.com.ryans.jpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ClienteJpaDAOTest.class,ClienteJpaDAO2BancosTest.class,ClienteJpaDAO3BancosTest.class,ProdutoJpaDAOTest.class,VendaJpaDAOTest.class})
public class AllTests {

}