package main;

import java.time.LocalDate;

public class Inscripcion {
    private int id;
    private Usuario usuario;
    private Evento evento;
    private LocalDate fechaInscripcion;
    
    public Inscripcion(int id, Usuario usuario, Evento evento, LocalDate fechaInscripcion) {
        this.id = id;
        this.usuario = usuario;
        this.evento = evento;
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
}
