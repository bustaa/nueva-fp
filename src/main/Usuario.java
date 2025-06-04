package main;

import java.util.ArrayList;
import java.util.List;

class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private List<Evento> eventosInscritos = new ArrayList<>();

    public Usuario(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Evento> getEventosInscritos() {
        return eventosInscritos;
    }

    public void inscribirseEvento(Evento e) {
        if (e != null && !eventosInscritos.contains(e)) {
            eventosInscritos.add(e);
        }
    }

    public void cancelarInscripcion(Evento e) {
        if (e != null && eventosInscritos.contains(e)) {
            eventosInscritos.remove(e);
        }
    }
}