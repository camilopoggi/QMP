public class Usuario {
  private int edad;
  private Guardarropas guardarropas;

  public Usuario(int edad, Guardarropas guardarropas) {
    this.edad = edad;
    this.guardarropas = guardarropas;
  }

  public int getEdad() { return edad; }
  public Guardarropas getGuardarropas() { return guardarropas; }
}
