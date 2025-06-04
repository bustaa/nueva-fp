package main;

public class Ubicacion {
    private String tipo;
    private String direccion;
    private String enlaceOnline;

    public Ubicacion(String direccion) {
        this.tipo = "presencial";
        this.direccion = direccion;
        this.enlaceOnline = null;
    }

    public Ubicacion(boolean esOnline, String enlaceOnline) {
        this.tipo = "online";
        this.direccion = null;
        this.enlaceOnline = enlaceOnline;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEnlaceOnline() {
        return enlaceOnline;
    }
}
