import java.util.ArrayList;
import java.util.List;

public class Guardarropas {
  private List<Prenda> prendas = new ArrayList<>();

  public void agregar(Prenda prenda) {
    prendas.add(prenda);
  }

  public List<Prenda> prendasDe(Categoria categoria) {
    return prendas.stream()
        .filter(p -> p.getCategoria() == categoria)
        .toList();
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }
}
