public abstract class Pessoa {

        private String nome;
        private String sobreNome;
        private String dataNascimento;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSobreNome() {
            return sobreNome;
        }

        public void setSobreNome(String sobreNome) {
            this.sobreNome = sobreNome;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public abstract void exibirDados();
}