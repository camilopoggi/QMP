import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MotorClima implements MotorSugerencias {
    private ServicioMeteorologico servicioMeteorologico;
    private String ciudad;

    public MotorClima(ServicioMeteorologico servicioMeteorologico, String ciudad) {
        this.servicioMeteorologico = servicioMeteorologico;
        this.ciudad = ciudad;
    }

    public List<Atuendo> sugerenciasPara(Guardarropas guardarropas, Usuario usuario) {
        Map<String, Object> clima = servicioMeteorologico.obtenerCondicionesClimaticas(ciudad);
        double temperatura = ((Number) ((Map<String, Object>) clima.get("Temperature")).get("Value")).doubleValue();


        List<Prenda> superiores = guardarropas.prendasDe(Categoria.PARTE_SUPERIOR)
                .stream().filter(p -> p.aptaParaTemperatura(temperatura)).toList();
        List<Prenda> inferiores = guardarropas.prendasDe(Categoria.PARTE_INFERIOR)
                .stream().filter(p -> p.aptaParaTemperatura(temperatura)).toList();
        List<Prenda> calzados = guardarropas.prendasDe(Categoria.CALZADO)
                .stream().filter(p -> p.aptaParaTemperatura(temperatura)).toList();
        List<Prenda> accesorios = guardarropas.prendasDe(Categoria.ACCESORIO)
                .stream().filter(p -> p.aptaParaTemperatura(temperatura)).toList();

        List<Atuendo> atuendos = new ArrayList<>();
        for (Prenda sup : superiores)
            for (Prenda inf : inferiores)
                for (Prenda calz : calzados)
                    for (Prenda acc : accesorios)
                        atuendos.add(new Atuendo(sup, inf, calz, acc));

        return atuendos;
    }
}
