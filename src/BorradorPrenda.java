public class BorradorPrenda {
  private TipoPrenda tipo;
  private String material;
  private String colorPrimario;
  private String colorSecundario;
  private Trama trama = Trama.LISA;// Por defecto
  private Formalidad formalidad;
  private double temperatura;
  public BorradorPrenda(TipoPrenda tipo) {
    this.tipo = tipo;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public void setColorPrimario(String color) {
    this.colorPrimario = color;
  }

  public void setColorSecundario(String color) {
    this.colorSecundario = color;
  }

  public void setTrama(Trama trama) {
    this.trama = trama;
  }

  public Prenda construirPrenda() {
    if (tipo == null || material == null || colorPrimario == null) {
      throw new IllegalStateException("Faltan datos obligatorios para construir la prenda.");
    }
    return new Prenda(tipo, material, colorPrimario, colorSecundario, trama, formalidad, temperatura);
  }
}
