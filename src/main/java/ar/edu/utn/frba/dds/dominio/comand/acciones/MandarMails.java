package ar.edu.utn.frba.dds.dominio.comand.acciones;

import ar.edu.utn.frba.dds.dominio.RegistroClimatico;
import ar.edu.utn.frba.dds.dominio.comand.accionadores.Notificator;

public class MandarMails implements Comando {

  private final String[] destinatarios = {
      "admin@clima.com",
      "emergencias@clima.com",
      "meteorologia@clima.com"
  };
  private final Notificator notificador;

  public MandarMails(Notificator notificador) {
    this.notificador = notificador;
  }


  @Override
  public void accionar(RegistroClimatico registro) {
    notificador.enviarMail(destinatarios, this.construirCuerpo(registro));
  }

  private String construirCuerpo(RegistroClimatico registro) {
    return "Se detectó una condición climática crítica:"
        + "Ubicación: " + registro.ubicacion()
        + "Fecha y hora: " + registro.fechaHora()
        + "Temperatura: " + registro.temperatura()
        + "Humedad: " + registro.humedad()
        + "Condición: " + registro.condicion();
  }

  @Override
  public String descripcion() {
    return "Envío de mail de alerta a " + destinatarios.length + " destinatarios";
  }

}

