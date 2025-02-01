package Jose_Dev.Rh.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus (value = HttpStatus.NOT_FOUND)

public class RecursoNoEncontradoExcep extends RuntimeException{

    public RecursoNoEncontradoExcep(String mensaje) {
        super(mensaje);
    }


}
