import java.util.List;

public class SugeridorDeAtuendos {
  private MotorSugerencias motor;

  public SugeridorDeAtuendos(MotorSugerencias motor) {
    this.motor = motor;
  }

  public void setMotor(MotorSugerencias nuevoMotor) {
    this.motor = nuevoMotor;
  }

  public List<Atuendo> sugerencias(Guardarropas g, Usuario u) {
    return motor.sugerenciasPara(g, u);
  }
}
