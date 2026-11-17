public class Cargo {

    private String nome;
    private String setor;

    public Cargo(String nome, String setor) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do cargo inválido");
        }
        if (setor == null || setor.isEmpty()) {
            throw new IllegalArgumentException("Setor inválido");
        }
        this.nome = nome;
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public String getSetor() {
        return setor;
    }
}