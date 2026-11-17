public class Funcionario {

    private String nome;
    private Cargo cargo;

    public Funcionario(String nome, String nomeCargo, String setor) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionário inválido");
        }
        this.nome = nome;
        this.cargo = CargoFactory.getCargo(nomeCargo, setor);
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String exibir() {
        return "Funcionário: " + nome + " - Cargo: " + cargo.getNome() + " - Setor: " + cargo.getSetor();
    }
}