package ar.edu.utn.frba.dds.dominio;

import java.time.LocalDateTime;

public record RegistroClimatico(LocalDateTime fechaHora, double temperatura,
                                double humedad, String condicion, String ubicacion) {

  public boolean esCondicionCritica() {
    return temperatura > 35.0 && humedad > 60.0;
  }

}
