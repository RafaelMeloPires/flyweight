import java.util.HashMap;
import java.util.Map;

public class CargoFactory {

    private static Map<String, Cargo> cargos = new HashMap<>();

    public static Cargo getCargo(String nome, String setor) {
        Cargo cargo = cargos.get(nome);
        if (cargo == null) {
            cargo = new Cargo(nome, setor);
            cargos.put(nome, cargo);
        }
        return cargo;
    }

    public static int getTotalCargos() {
        return cargos.size();
    }
}