package ar.edu.utn.frba.dds.client;

import ar.edu.utn.frba.dds.config.WeatherApiProperties;
import ar.edu.utn.frba.dds.dominio.RegistroClimatico;
import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

public class WeatherApiClient {
  private final WeatherApiProperties properties;
  private final RestClient restClient;


  public WeatherApiClient(WeatherApiProperties properties) {
    this.properties = properties;
    this.restClient = RestClient.create();
  }

  public RegistroClimatico obtenerClimaActual() {
    String url = properties.getBaseUrl() + "/current.json"
        + "?key=" + properties.getKey()
        + "&q=" + properties.getLocation();

    Map<String, Object> response = restClient.get()
        .uri(url)
        .retrieve()
        .body(new ParameterizedTypeReference<Map<String, Object>>() {
        });

    if (response == null || response.get("current") == null) {
      throw new IllegalStateException("WeatherAPI no devolvió datos válidos");
    }


    Map<String, Object> location = (Map<String, Object>) response.get("location");
    Map<String, Object> current = (Map<String, Object>) response.get("current");
    Map<String, Object> condition = (Map<String, Object>) current.get("condition");

    double temperatura = ((Number) current.get("temp_c")).doubleValue();
    double humedad = ((Number) current.get("humidity")).doubleValue();
    String condicion = (String) condition.get("text");
    String ubicacion = (String) location.get("name");

    return new RegistroClimatico(
        LocalDateTime.now(), temperatura, humedad, condicion, ubicacion);
  }

}
