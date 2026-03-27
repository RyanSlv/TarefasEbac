public class PessoaJuri extends Pessoa {

        private String cnpj;
        private String nome;
        private String dataNascimento;


        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }


    @Override
    public void exibirDados() {
        System.out.println("Pessoa Jurídica: ");
        System.out.println("Nome: " + getNome());
        System.out.println("Data de abertura: " + getDataNascimento());
        System.out.println("CPF: " + getCnpj());
    }
}
