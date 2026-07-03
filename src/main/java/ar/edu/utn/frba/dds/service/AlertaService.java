package ar.edu.utn.frba.dds.service;

import ar.edu.utn.frba.dds.dominio.ReceptorDeTemperatura;
import ar.edu.utn.frba.dds.dominio.RegistroClimatico;
import ar.edu.utn.frba.dds.repository.RegistroClimaticoRepository;
import org.springframework.scheduling.annotation.Scheduled;

public class AlertaService {
  private static final long UN_MINUTO_MS = 60 * 1000;

  private final RegistroClimaticoRepository repository;
  private final ReceptorDeTemperatura receptorDeTemperatura;

  public AlertaService(RegistroClimaticoRepository repository,
                       ReceptorDeTemperatura receptorDeTemperatura) {
    this.repository = repository;
    this.receptorDeTemperatura = receptorDeTemperatura;
  }

  @Scheduled(fixedRate = UN_MINUTO_MS)
  public void analizarClima() {
    RegistroClimatico ultimo = repository.obtenerUltimo();
    receptorDeTemperatura.evaluar(ultimo);
  }
}
