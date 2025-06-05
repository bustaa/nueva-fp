package main.java.com.indra.eventossostenibles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Evento {
    private int id;
    private String nombre;
    private LocalDate fecha;
    private int duracion;
    private Ubicacion ubicacion;
    private Categoria categoria;
    private Organizador organizador;
    private List<Usuario> participantes = new ArrayList<>();

    public Evento(int id, String nombre, LocalDate fecha, int duracion, Ubicacion ubicacion, Categoria categoria, Organizador organizador) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.organizador = organizador;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public void registrarParticipante(Usuario nuevoPart) {
        if (nuevoPart != null && !participantes.contains(nuevoPart)) {
            participantes.add(nuevoPart);
        }
    }

    public void eliminarParticipante(Usuario part) {
        if (part != null && participantes.contains(part)) {
            participantes.remove(part);
        }
    }
}