import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ServicioMeteorologico {
    private AccuWeatherAPI api;
    private Duration periodoDeValidez;
    private Map<String, RespuestaAccuWeather> ultimasRespuestas;

    public ServicioMeteorologico(AccuWeatherAPI api, Duration periodoDeValidez) {
        this.api = api;
        this.periodoDeValidez = periodoDeValidez;
        this.ultimasRespuestas = new HashMap<>();
    }

    public Map<String, Object> obtenerCondicionesClimaticas(String direccion) {
        if (!ultimasRespuestas.containsKey(direccion)
                || ultimasRespuestas.get(direccion).expiro()) {
            Map<String, Object> estadoDelTiempo = consultarApi(direccion);
            ultimasRespuestas.put(direccion,
                    new RespuestaAccuWeather(estadoDelTiempo, proximaExpiracion()));
        }
        return ultimasRespuestas.get(direccion).getEstadoDelTiempo();
    }

    private LocalDateTime proximaExpiracion() {
        return LocalDateTime.now().plus(this.periodoDeValidez);
    }

    private Map<String, Object> consultarApi(String direccion) {
        return api.getWeather(direccion).get(0);
    }
}
