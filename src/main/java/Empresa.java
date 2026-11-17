import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public void contratarFuncionario(String nome, String nomeCargo, String setor) {
        Funcionario funcionario = new Funcionario(nome, nomeCargo, setor);
        this.funcionarios.add(funcionario);
    }

    public List<String> listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Empresa sem funcionários");
        }
        List<String> saida = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            saida.add(funcionario.exibir());
        }
        return saida;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}