import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Lista2 {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite os nomes e o gênero (Ex: João-M, Ana-F); ");

        String resposta = s.nextLine();
        String[] genero;
        genero = sepnomes(resposta, ",");
        
        verGenero(genero);

        s.close();

    }

    private static void verGenero(String[] genero) {
        Map<String, Integer> generoMas = new TreeMap<>();
        Map<String, Integer> generoFem = new TreeMap<>();
        String a;
        for (int i = 0; i< genero.length; i++){
            String f = genero[i].trim();
            if (f.contains("-M")){
                a = f.replace("-M", "");
                generoMas.put(a, i);
            }else if (f.endsWith("-F")){
                a = f.replace("-F","");
                generoFem.put(a, i);
            }

         }

        imprimir(generoMas, generoFem);
    }

    private static void imprimir(Map<String, Integer> generoMas, Map<String, Integer> generoFem) {
        System.out.println("Grupo Masculino:");
        generoMas.keySet().stream().forEach(System.out::println);
        System.out.println("\n");
        System.out.println("Grupo Feminino:");
        generoFem.keySet().stream().forEach(System.out::println);
    }

    private static String[] sepnomes(String n, String separador) {
        String[] vetNome = n.split(separador);
        return vetNome;

    }

}
