import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {

    TipoPrenda remera = new TipoPrenda("remera", Categoria.PARTE_SUPERIOR);
    TipoPrenda pantalon = new TipoPrenda("pantalón", Categoria.PARTE_INFERIOR);
    TipoPrenda zapatillas = new TipoPrenda("zapatillas", Categoria.CALZADO);
    TipoPrenda pulsera = new TipoPrenda("pulsera", Categoria.ACCESORIO);

    Prenda prendaSuperior = new Prenda(remera, "algodón", "azul", null, Trama.LISA, Formalidad.FORMAL, 80);
    Prenda prendaInferior = new Prenda(pantalon, "jean", "negro", null, Trama.LISA, Formalidad.FORMAL, 80);
    Prenda calzado = new Prenda(zapatillas, "cuero", "blanco", null, Trama.LISA, Formalidad.FORMAL,80);
    Prenda accesorio = new Prenda(pulsera, "acero", "plateado", null, Trama.LISA, Formalidad.INFORMAL,80);


    Guardarropas guardarropas = new Guardarropas();
    guardarropas.agregar(prendaSuperior);
    guardarropas.agregar(prendaInferior);
    guardarropas.agregar(calzado);
    guardarropas.agregar(accesorio);

    System.out.println("Cantidad de prendas en el guardarropas: " + guardarropas.getPrendas().size());



    Usuario juan = new Usuario(60, guardarropas);

    Map<String, Object> clima = new AccuWeatherAPI().getWeather("Buenos Aires, Argentina").get(0);
    Map<String, Object> temp = (Map<String, Object>) clima.get("Temperature");
    Double temperatura = ((Number) temp.get("Value")).doubleValue();
    System.out.println("🌡️ Temperatura según AccuWeather: " + temperatura + " " + temp.get("Unit"));


    AccuWeatherAPI api = new AccuWeatherAPI();
    ServicioMeteorologico servicio = new ServicioMeteorologico(api, Duration.ofMinutes(150));

    MotorSugerencias motorClima = new MotorClima(servicio, "Buenos Aires, Argentina");
    SugeridorDeAtuendos sugeridor = new SugeridorDeAtuendos(motorClima);

    List<Atuendo> sugerencias = sugeridor.sugerencias(juan.getGuardarropas(), juan);
    System.out.println("▶ Sugerencias según el clima:");
    sugerencias.forEach(System.out::println);





    SugeridorDeAtuendos sugeridorTotal = new SugeridorDeAtuendos(new MotorCombinacionesTotales());
    List<Atuendo> sugerenciasTotales = sugeridorTotal.sugerencias(juan.getGuardarropas(), juan);

    System.out.println("▶ Sugerencias con todas las combinaciones:");
    sugerenciasTotales.forEach(System.out::println);

    System.out.println("\n");


    SugeridorDeAtuendos sugeridorFiltrado = new SugeridorDeAtuendos(new MotorFiltroFormalidad());
    List<Atuendo> sugerenciasFiltradas = sugeridorFiltrado.sugerencias(juan.getGuardarropas(), juan);

    System.out.println("▶ Sugerencias con filtro de formalidad (mayores de 55):");
    sugerenciasFiltradas.forEach(System.out::println);


    System.out.println("Cantidad de prendas en el guardarropas del usuario: " +
        juan.getGuardarropas().getPrendas().size());
  }
}
