import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciRecursivoTest {

    @Test
    public void deveRetornarZeroParaZero() {
        assertEquals(0, FibonacciRecursivo.fibonacci(0));
    }

    @Test
    public void deveRetornarUmParaUm() {
        assertEquals(1, FibonacciRecursivo.fibonacci(1));
    }

    @Test
    public void deveCalcularFibonacciDeCinco() {
        assertEquals(5, FibonacciRecursivo.fibonacci(5));
    }

    @Test
    public void deveCalcularFibonacciDeDez() {
        assertEquals(55, FibonacciRecursivo.fibonacci(10));
    }

    @Test
    public void deveCalcularFibonacciDeQuinze() {
        assertEquals(610, FibonacciRecursivo.fibonacci(15));
    }
}
