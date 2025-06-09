import java.util.ArrayList;
import java.util.List;

public class MotorCombinacionesTotales implements MotorSugerencias {
  public List<Atuendo> sugerenciasPara(Guardarropas guardarropas, Usuario usuario) {
    List<Prenda> superiores = guardarropas.prendasDe(Categoria.PARTE_SUPERIOR);
    List<Prenda> inferiores = guardarropas.prendasDe(Categoria.PARTE_INFERIOR);
    List<Prenda> calzados = guardarropas.prendasDe(Categoria.CALZADO);
    List<Prenda> accesorios = new ArrayList<>(guardarropas.prendasDe(Categoria.ACCESORIO));
    accesorios.add(null);

    List<Atuendo> atuendos = new ArrayList<>();

    if (superiores.isEmpty() || inferiores.isEmpty() || calzados.isEmpty()) {
      return List.of();
    }

    for (Prenda sup : superiores)
      for (Prenda inf : inferiores)
        for (Prenda calz : calzados)
          for (Prenda acces : accesorios)
            atuendos.add(new Atuendo(sup, inf, calz, acces));

    return atuendos;
  }
}
