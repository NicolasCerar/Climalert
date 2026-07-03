package ar.edu.utn.frba.dds.dominio.comand.acciones;

import ar.edu.utn.frba.dds.dominio.RegistroClimatico;

public interface Comando {
  void accionar(RegistroClimatico registro);

  String descripcion();
}
