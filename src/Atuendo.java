import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Atuendo {
  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;
  private Prenda accesorio;

  public boolean aptaParaTemperatura(double temperatura) {
    return Stream.of(parteSuperior, parteInferior, calzado, accesorio)
            .filter(Objects::nonNull)
            .allMatch(prenda -> prenda.aptaParaTemperatura(temperatura));
  }

  public Atuendo(Prenda sup, Prenda inf, Prenda calzado, Prenda accesorio) {
    this.parteSuperior = sup;
    this.parteInferior = inf;
    this.calzado = calzado;
    this.accesorio = accesorio;
  }

  @Override
  public String toString() {
    return "Atuendo:\n" +
            "  Superior: " + parteSuperior + "\n" +
            "  Inferior: " + parteInferior + "\n" +
            "  Calzado: " + calzado + "\n" +
            "  Accesorio: " + (accesorio != null ? accesorio : "Ninguno") + "\n";
  }


  public List<Prenda> prendas() {
    return List.of(parteSuperior, parteInferior, calzado);
  }
}
