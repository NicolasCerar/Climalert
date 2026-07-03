package ar.edu.utn.frba.dds.config;

import ar.edu.utn.frba.dds.dominio.ReceptorDeTemperatura;
import ar.edu.utn.frba.dds.dominio.comand.Accionador;
import ar.edu.utn.frba.dds.dominio.comand.accionadores.Notificator;
import ar.edu.utn.frba.dds.dominio.comand.acciones.Comando;
import ar.edu.utn.frba.dds.dominio.comand.acciones.MandarMails;
import java.util.List;
import org.springframework.context.annotation.Bean;


public class ClimateConfig {

  @Bean
  public ReceptorDeTemperatura receptorTemperatura(Notificator notificador) {
    List<Comando> comandos = List.of(new MandarMails(notificador));
    Accionador accionador = new Accionador(comandos);
    return new ReceptorDeTemperatura(accionador);
  }
}
