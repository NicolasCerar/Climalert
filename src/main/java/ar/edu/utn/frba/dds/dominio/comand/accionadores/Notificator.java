package ar.edu.utn.frba.dds.dominio.comand.accionadores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Notificator {
  private static final Logger log = LoggerFactory.getLogger(Notificator.class);

  public void enviarMail(String[] destinatarios, String cuerpo) {
    log.info("[NOTIFICADOR] Para: {}", String.join(", ", destinatarios));
    log.info("[NOTIFICADOR] Cuerpo:\n{}", cuerpo);
  }
}
