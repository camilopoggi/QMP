import java.util.List;

public class Uniforme {
  private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda calzado;

  public Uniforme(Prenda superior, Prenda inferior, Prenda calzado) {
    this.prendaSuperior = superior;
    this.prendaInferior = inferior;
    this.calzado = calzado;
  }

  public static Uniforme fabricar(Sastre sastre) {
    return new Uniforme(
        sastre.fabricarParteSuperior(),
        sastre.fabricarParteInferior(),
        sastre.fabricarCalzado()
    );
  }

  public List<Prenda> prendas() {
    return List.of(prendaSuperior, prendaInferior, calzado);
  }
}
