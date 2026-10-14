
//    **
//    **  Realiza operações aritméticas básicas com números inteiros.
//    **

    public class Calculadora {

//    **
//    ** Soma dois números inteiros.
//    ** @param a primeiro número.
//    ** @param b segundo número.
//    ** @return soma dos números.
//    **

    private int adicionar(int a, int b) {
        return a + b;
    }

//    **
//    ** Subtrai o segundo número do primeiro.
//    ** @param a primeiro número.
//    ** @param b número a subtrair.
//    ** @return diferença entre os números.
//    **
    private int subtrair(int a, int b) {
        return a - b;
    }

//    **
//    ** Multiplica dois números inteiros.
//    ** @param a primeiro fator.
//    ** @param b segundo fator.
//    ** @return produto dos números.
//    **

    private int multiplicar(int a, int b) {
        return a * b;
    }

//    **
//    ** Dividir dois números inteiros, truncando o resultado em direção a zero.
//    ** @param a dividendo.
//    ** @param b divisor.
//    ** @return quociente inteiro da divisão.
//    ** @throws ArithmeticException se o divisor for zero.
//    **

    private int dividir(int a, int b) {
        return a / b;
    }
}
