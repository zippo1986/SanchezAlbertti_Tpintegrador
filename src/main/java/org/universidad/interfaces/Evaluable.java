package org.universidad.interfaces;

import org.universidad.gestores.Evaluador;

public interface Evaluable {
    double ObtenerPuntaje();
    void realizarEvaluacion(Evaluador evaluador);
}
