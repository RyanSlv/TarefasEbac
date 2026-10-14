import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

        private int executar(String nome, int a, int b) throws Exception {
            Method metodo = Calculadora.class.getDeclaredMethod(nome, int.class, int.class);
            metodo.setAccessible(true);

            try {
                return (int) metodo.invoke(calculadora, a, b);
            }   catch (InvocationTargetException e) {
                if (e.getCause() instanceof RuntimeException) {
                    throw (RuntimeException) e.getCause();
                }
                throw e;
            }
        }

        @Test
        public void deveAdicionar() throws Exception {
            assertEquals(5, executar("adicionar", 2, 3));
        }

        @Test
        public void deveSubtrair() throws Exception {
            assertEquals(-1, executar("subtrair", 2, 3));
        }

        @Test
        public void deveMultiplicar() throws Exception {
            assertEquals(6, executar("multiplicar", 2, 3));
        }

        @Test
        public void deveDividir() throws Exception {
            assertEquals(2, executar("dividir", 8, 4));
        }

        @Test
        public void deveTruncarDivisaoNaoExata() throws Exception {
            assertEquals(3, executar("dividir", 7, 2));
        }

        @Test
        public void deveDividirNumeroNegativo() throws Exception {
            assertEquals(-3, executar("dividir", -7, 2));
        }

        @Test
        public void deveDividirPorNumeroNegativo() throws Exception {
            assertEquals(-3, executar("dividir", 7, -2));
        }
        @Test
        public void deveDividirDoisNumerosNegativos() throws Exception {
            assertEquals(3, executar("dividir", -7, -2));
        }

        @Test
        public void deveDividirZeroPorNumeroDiferenteDeZero() throws Exception {
            assertEquals(0, executar("dividir", 0, 5));
        }

        @Test
        public void deveLancarExcecaoAoDividirPorZero() {
            assertThrows(ArithmeticException.class, () -> executar("dividir", 10, 0));
        }

        @Test
        public void deveLancarExcecaoAoDividirZeroPorZero() {
            assertThrows(ArithmeticException.class, () -> executar("dividir", 0, 0));
        }
}
