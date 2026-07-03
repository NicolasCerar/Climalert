package ar.edu.utn.frba.dds.service;

import ar.edu.utn.frba.dds.client.WeatherApiClient;
import ar.edu.utn.frba.dds.dominio.RegistroClimatico;
import ar.edu.utn.frba.dds.repository.RegistroClimaticoRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ClimaSchedulerService {

  private static final long CINCO_MINUTOS_MS = 5 * 60 * 1000;

  private final WeatherApiClient weatherApiClient;
  private final RegistroClimaticoRepository repository;

  public ClimaSchedulerService(WeatherApiClient weatherApiClient,
                               RegistroClimaticoRepository repository) {
    this.weatherApiClient = weatherApiClient;
    this.repository = repository;
  }

  @Scheduled(fixedRate = CINCO_MINUTOS_MS)
  public void actualizarClima() {
    RegistroClimatico registro = weatherApiClient.obtenerClimaActual();
    repository.guardar(registro);
  }
}

