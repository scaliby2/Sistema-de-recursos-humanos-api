package Jose_Dev.Rh.Repositorio;

import Jose_Dev.Rh.Modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio de acceso a datos para la entidad Empleado
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {

    // Los métodos básicos de CRUD (Create, Read, Update, Delete) ya están disponibles
    // automáticamente gracias a la herencia de JpaRepository, no necesitas implementarlos.

}
