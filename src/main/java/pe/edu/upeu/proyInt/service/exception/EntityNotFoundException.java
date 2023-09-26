package pe.edu.upeu.proyInt.service.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String mensaje){
        super(mensaje);
    }
}
