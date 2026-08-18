import br.com.ryans.Pessoa;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PessoaTest {

    @Test
    public void testMulheres() {
        Pessoa pessoa = new Pessoa();
        List<Pessoa> lista = pessoa.nomesPessoas();

        boolean somenteMulheres = lista.stream()
                .allMatch(p -> p.getGenero().equals("Feminino"));

        Assert.assertFalse(somenteMulheres);
    }

}