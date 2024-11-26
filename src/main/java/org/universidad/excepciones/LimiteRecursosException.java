package org.universidad.excepciones;

public class LimiteRecursosException extends Exception {
    public LimiteRecursosException(String mensaje) {
        super(mensaje);
    }
}
