public class Programa {

        public static void main(String args[]) {
            PessoaFis pessoaFis = new PessoaFis();
            pessoaFis.setCpf("228.238.564-02");
            pessoaFis.setNome("Ricardo");
            pessoaFis.setSobreNome("Silva");
            pessoaFis.setDataNascimento("01/03/1985");

            PessoaJuri pessoaJuri = new PessoaJuri();
            pessoaJuri.setCnpj("12.345.123/0001-99");
            pessoaJuri.setNome("Empresa RAS");
            pessoaJuri.setDataNascimento("01/02/2015");

            imprimir(pessoaFis);
            System.out.println("----------------------------");
            imprimir(pessoaJuri);

        }

    private static void imprimir(Pessoa pessoa) {
            pessoa.exibirDados();

    }
}
