import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MotorFiltroFormalidad implements MotorSugerencias {
  public List<Atuendo> sugerenciasPara(Guardarropas guardarropas, Usuario usuario) {
    boolean filtrarInformal = usuario.getEdad() > 55;

    Predicate<Prenda> filtro = prenda ->
            !filtrarInformal || prenda.getFormalidad() != Formalidad.INFORMAL;

    List<Prenda> superiores = guardarropas.prendasDe(Categoria.PARTE_SUPERIOR)
            .stream().filter(filtro).toList();
    List<Prenda> inferiores = guardarropas.prendasDe(Categoria.PARTE_INFERIOR)
            .stream().filter(filtro).toList();
    List<Prenda> calzados = guardarropas.prendasDe(Categoria.CALZADO)
            .stream().filter(filtro).toList();
    List<Prenda> accesoriosFiltrados = guardarropas.prendasDe(Categoria.ACCESORIO)
            .stream().filter(filtro).toList();


    List<Prenda> accesorios = new ArrayList<>(accesoriosFiltrados);
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

