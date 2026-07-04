package ar.edu.utn.frba.dds.dominio;

import ar.edu.utn.frba.dds.dominio.comand.Accionador;

public class ReceptorDeTemperatura {

  private final Accionador accionador;

  public ReceptorDeTemperatura(Accionador accionador) {
    this.accionador = accionador;
  }

  public void evaluar(RegistroClimatico registro) {
    if (registro != null && registro.esCondicionCritica()) {
      accionador.accionar(registro);
    }
  }

}
