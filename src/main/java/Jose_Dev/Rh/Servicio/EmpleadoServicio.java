package Jose_Dev.Rh.Servicio;

import Jose_Dev.Rh.Modelo.Empleado;
import Jose_Dev.Rh.Repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServicio implements IEmpleadoServicio {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado BuscarEmpleadoId(int idEmpleado) {
         Empleado empleado = empleadoRepositorio.findById(idEmpleado).orElse(null) ;
         return empleado;
    }

    @Override
    public Empleado GuardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

   @Override
    public void EliminarEmpleado (Empleado empleado){
        empleadoRepositorio.delete(empleado);
   }
}
