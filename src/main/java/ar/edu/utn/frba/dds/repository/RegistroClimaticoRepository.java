package ar.edu.utn.frba.dds.repository;

import ar.edu.utn.frba.dds.dominio.RegistroClimatico;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RegistroClimaticoRepository {
  private final List<RegistroClimatico> registros = new CopyOnWriteArrayList<>();

  public void guardar(RegistroClimatico registro) {
    registros.add(registro);
  }

  public List<RegistroClimatico> obtenerTodos() {
    return Collections.unmodifiableList(registros);
  }

  public RegistroClimatico obtenerUltimo() {
    if (registros.isEmpty()) {
      return null;
    }
    return registros.get(registros.size() - 1);
  }
}
