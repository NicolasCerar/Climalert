package ar.edu.utn.frba.dds.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties(prefix = "weatherapi")
public class WeatherApiProperties {

  private String baseUrl;
  private String key;
  private String location;

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}