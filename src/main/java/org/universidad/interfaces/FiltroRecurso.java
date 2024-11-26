package org.universidad.interfaces;

import org.universidad.recursos.RecursoAcademico;

@FunctionalInterface
public interface FiltroRecurso {
    boolean evaluar(RecursoAcademico recurso);
}
