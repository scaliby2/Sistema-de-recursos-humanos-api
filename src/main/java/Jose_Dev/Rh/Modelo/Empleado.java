package Jose_Dev.Rh.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // Indica que esta clase es una entidad y se mapeará a una tabla de la base de datos automáticamente
@Data // Genera automáticamente los métodos getters y setters, además de equals, hashCode y toString
@NoArgsConstructor // Genera un constructor sin argumentos automáticamente
@AllArgsConstructor // Genera un constructor con todos los argumentos automáticamente
@ToString // Genera el método toString automáticamente

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que el valor de la clave primaria será generado automáticamente con una estrategia de incremento (auto-incremental)
    Integer IdEmpleado; // Identificador único para cada empleado
    String Nombre; // Nombre del empleado
    String Departamento; // Departamento al que pertenece el empleado
    Double Sueldo; // Sueldo del empleado
}
