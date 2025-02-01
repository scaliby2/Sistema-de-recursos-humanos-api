package Jose_Dev.Rh.Servicio;

import Jose_Dev.Rh.Modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado> listarEmpleados();
    public Empleado BuscarEmpleadoId(int Id);

    public Empleado GuardarEmpleado(Empleado empleado);

    public void EliminarEmpleado(Empleado empleado);
}
