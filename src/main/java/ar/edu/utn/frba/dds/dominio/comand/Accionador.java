package ar.edu.utn.frba.dds.dominio.comand;

import ar.edu.utn.frba.dds.dominio.RegistroClimatico;
import ar.edu.utn.frba.dds.dominio.comand.acciones.Comando;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Accionador {
  private static final Logger log = LoggerFactory.getLogger(Accionador.class);

  private final List<Comando> comandos;

  public Accionador(List<Comando> comandos) {
    this.comandos = comandos;
  }

  public void accionar(RegistroClimatico registro) {
    for (Comando comando : comandos) {
      log.info("[ACCIONADOR] Ejecutando: {}", comando.descripcion());
      comando.accionar(registro);
    }
  }
}
