package Jose_Dev.Rh.Controllador;

import Jose_Dev.Rh.Excepciones.RecursoNoEncontradoExcep;
import Jose_Dev.Rh.Modelo.Empleado;
import Jose_Dev.Rh.Servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
// @RequestMapping: Los endpoints estarán disponibles bajo la URL base: http://localhost:8080/rh-app/
@RequestMapping("rh-app")
// @CrossOrigin: Permite solicitudes CORS (Cross-Origin Resource Sharing) desde http://localhost:3001
@CrossOrigin(value = "http://localhost:3001")
public class EmpleadoControllador {
    private static final Logger logger =
            LoggerFactory.getLogger(EmpleadoControllador.class);

    @Autowired
    private IEmpleadoServicio empleadoServicio; // Inyección de dependencias del servicio de empleados

    // http://localhost:8080/rh-app/empleados
    @GetMapping("/empleados") // Mapeo del endpoint para obtener la lista de empleados
    public List<Empleado> obtenerEmpleados() {
        var empleados = empleadoServicio.listarEmpleados(); // Llama al servicio para listar empleados
        empleados.forEach(empleado -> logger.info(empleado.toString())); // Registra cada empleado
        return empleados; // Retorna la lista de empleados
    }
    @PostMapping("/agregar")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado) {
        logger.info("Empleado a agregar"+ empleado);
        return empleadoServicio.GuardarEmpleado(empleado);
    }
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado>
    obtenerEmpleado(@PathVariable Integer id) {
      Empleado empleado =  empleadoServicio.BuscarEmpleadoId(id);
      if(empleado == null) {
          throw new RecursoNoEncontradoExcep("No se encontro el Id" +id );
      }
      return ResponseEntity.ok(empleado);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleadoActualizar) {
        Empleado empleado = empleadoServicio.BuscarEmpleadoId(id);
        if (empleado == null) {
            throw new RecursoNoEncontradoExcep("El id no se encontró: " + id);
        }

        empleado.setNombre(empleadoActualizar.getNombre());
        empleado.setDepartamento(empleadoActualizar.getDepartamento());
        empleado.setSueldo(empleadoActualizar.getSueldo());

        empleadoServicio.GuardarEmpleado(empleado);  // Asegúrate de que este método esté implementado
        return ResponseEntity.ok(empleado);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable Integer id) {
        Empleado empleado = empleadoServicio.BuscarEmpleadoId(id);
        if (empleado == null) {
            throw new RecursoNoEncontradoExcep("El id no se encontrado: " + id);
        }

        // Elimina el empleado
        empleadoServicio.EliminarEmpleado(empleado);

        // Respuesta indicando que se ha eliminado con éxito
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado con éxito", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
