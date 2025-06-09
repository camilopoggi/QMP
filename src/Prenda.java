public class Prenda {
  private TipoPrenda tipo;
  private String material;
  private String colorPrimario;
  private String colorSecundario;
  private Trama trama;
  private Formalidad formalidad;
  private double temperaturaMaxima;

  public Prenda(TipoPrenda tipo, String material, String colorPrimario, String colorSecundario, Trama trama, Formalidad formalidad,
                double temperaturaMaxima) {
    this.tipo = tipo;
    this.material = material;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
    this.trama = trama == null ? Trama.LISA : trama;
    this.formalidad = formalidad;
    this.temperaturaMaxima = temperaturaMaxima;
  }

  public boolean aptaParaTemperatura(Double temperatura) {
    return temperatura <= temperaturaMaxima;
  }



  @Override
  public String toString() {
    return "Prenda{" +
        "tipo='" + tipo + '\'' +
        ", categoría=" + tipo.categoria() +
        ", material='" + material + '\'' +
        ", colorPrimario='" + colorPrimario + '\'' +
        (colorSecundario != null ? ", colorSecundario='" + colorSecundario + '\'' : "") +
        ", trama=" + trama +
        ", formalidad=" + formalidad +
        '}';
  }


  public TipoPrenda tipo() { return tipo; }
  public String material() { return material; }
  public String colorPrimario() { return colorPrimario; }
  public String colorSecundario() { return colorSecundario; }
  public Trama trama() { return trama; }
  public Categoria getCategoria() { return tipo.categoria(); }
  public Formalidad getFormalidad() { return formalidad; }
}
