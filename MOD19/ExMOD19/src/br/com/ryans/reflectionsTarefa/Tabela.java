package br.com.ryans.reflectionsTarefa;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import br.com.ryans.tarefaMOD18.TabelaComAnotacao;
import br.com.ryans.tarefaMOD18.TabelaAnotacao;

public class Tabela {
    public static void main(String[] args) {


        TabelaComAnotacao tabCA = new TabelaComAnotacao();
        Class<?> tab1 = tabCA.getClass();
        System.out.println(tab1);


        System.out.println("");

        Field[] fields = tab1.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] fieldAnnotations = field.getAnnotations();

            for (Annotation instanceOf; TabelaAnotacao;) {

                TabelaAnotacao tabelaAnotacao = (TabelaAnotacao) Annotation;

                System.out.println("Tipo: " + tabelaAnotacao.value());

                for (String marca : tabelaAnotacao()) {
                    System.out.println("Marca: " + marca);
                }

                System.out.println("Potência: " + TabelaAnotacao.potencia() + " HP");
                System.out.println("");
            }
        }
    }

}


