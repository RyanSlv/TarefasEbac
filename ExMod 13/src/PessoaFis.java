public class PessoaFis extends Pessoa {


        private String cpf;

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

    @Override
    public void exibirDados() {
            System.out.println("Pessoa física: ");
            System.out.println("Nome: " + getNome() + " " + getSobreNome());
            System.out.println("Data de nascimento: " + getDataNascimento());
            System.out.println("CPF: " + getCpf());
    }
}
