import java.time.LocalDateTime;
import java.util.Map;

public class RespuestaAccuWeather {
    private Map<String, Object> estadoDelTiempo;
    private LocalDateTime expiracion;

    public RespuestaAccuWeather(Map<String, Object> estadoDelTiempo, LocalDateTime expiracion) {
        this.estadoDelTiempo = estadoDelTiempo;
        this.expiracion = expiracion;
    }

    public boolean expiro() {
        return LocalDateTime.now().isAfter(expiracion);
    }

    public Map<String, Object> getEstadoDelTiempo() {
        return estadoDelTiempo;
    }
}
