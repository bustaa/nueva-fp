package main.java.com.indra.eventossostenibles;

import java.util.ArrayList;
import java.util.List;

class Organizador {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private List<Evento> eventosOrganizados = new ArrayList<>();

    public Organizador(int id, String nombre, String email, String telefono) {
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

    public List<Evento> getEventosOrganizados() {
        return eventosOrganizados;
    }

    public void agregarEvento(Evento evento) {
        if (evento != null && !eventosOrganizados.contains(evento)) {
            eventosOrganizados.add(evento);
        }
    }

    public void eliminarEvento(Evento evento) {
        if (evento != null && eventosOrganizados.contains(evento)) {
            eventosOrganizados.remove(evento);
        }
    }
}