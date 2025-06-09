public class TipoPrenda {
  private String nombre;
  private Categoria categoria;

  public TipoPrenda(String nombre, Categoria categoria) {
    this.nombre = nombre;
    this.categoria = categoria;
  }

  public Categoria categoria() {
    return categoria;
  }

  @Override
  public String toString() {
    return nombre;
  }


  public static final TipoPrenda CHOMBA = new TipoPrenda("chomba", Categoria.PARTE_SUPERIOR);
  public static final TipoPrenda PANTALON = new TipoPrenda("pantalón", Categoria.PARTE_INFERIOR);
  public static final TipoPrenda ZAPATILLAS = new TipoPrenda("zapatillas", Categoria.CALZADO);
}
