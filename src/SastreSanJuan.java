public class SastreSanJuan implements Sastre {
  public Prenda fabricarParteSuperior() {
    BorradorPrenda borrador = new BorradorPrenda(TipoPrenda.CHOMBA);
    borrador.setMaterial("piqué");
    borrador.setColorPrimario("verde");
    return borrador.construirPrenda();
  }

  public Prenda fabricarParteInferior() {
    BorradorPrenda borrador = new BorradorPrenda(TipoPrenda.PANTALON);
    borrador.setMaterial("acetato");
    borrador.setColorPrimario("gris");
    return borrador.construirPrenda();
  }

  public Prenda fabricarCalzado() {
    BorradorPrenda borrador = new BorradorPrenda(TipoPrenda.ZAPATILLAS);
    borrador.setMaterial("cuero");
    borrador.setColorPrimario("blanco");
    return borrador.construirPrenda();
  }
}
