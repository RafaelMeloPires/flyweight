import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {

    @Test
    void deveCompartilharMesmoCargo() {
        Empresa empresa = new Empresa();
        empresa.contratarFuncionario("Rafael", "Desenvolvedor", "TI");
        empresa.contratarFuncionario("Ana", "Desenvolvedor", "TI");

        Cargo cargo1 = empresa.getFuncionarios().get(0).getCargo();
        Cargo cargo2 = empresa.getFuncionarios().get(1).getCargo();

        assertSame(cargo1, cargo2);
    }

    @Test
    void deveCriarApenasUmCargoParaFuncionariosIguais() {
        int totalAntes = CargoFactory.getTotalCargos();

        Empresa empresa = new Empresa();
        empresa.contratarFuncionario("Carlos", "Analista", "Financeiro");
        empresa.contratarFuncionario("Maria", "Analista", "Financeiro");
        empresa.contratarFuncionario("João", "Analista", "Financeiro");

        assertEquals(totalAntes + 1, CargoFactory.getTotalCargos());
    }

    @Test
    void deveListarFuncionarios() {
        Empresa empresa = new Empresa();
        empresa.contratarFuncionario("Pedro", "Gerente", "RH");
        empresa.contratarFuncionario("Julia", "Gerente", "RH");

        assertEquals(Arrays.asList(
                "Funcionário: Pedro - Cargo: Gerente - Setor: RH",
                "Funcionário: Julia - Cargo: Gerente - Setor: RH"
        ), empresa.listarFuncionarios());
    }

    @Test
    void deveRetornarExcecaoEmpresaSemFuncionarios() {
        try {
            Empresa empresa = new Empresa();
            empresa.listarFuncionarios();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Empresa sem funcionários", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoNomeFuncionarioVazio() {
        try {
            Empresa empresa = new Empresa();
            empresa.contratarFuncionario("", "Estagiário", "TI");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome do funcionário inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoNomeCargoVazio() {
        try {
            Empresa empresa = new Empresa();
            empresa.contratarFuncionario("Lucas", "", "TI");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome do cargo inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoSetorVazio() {
        try {
            Empresa empresa = new Empresa();
            empresa.contratarFuncionario("Lucas", "Suporte", "");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Setor inválido", e.getMessage());
        }
    }
}