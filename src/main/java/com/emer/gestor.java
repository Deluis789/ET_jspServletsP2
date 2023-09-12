
package com.emer;

public class gestor {
    private int id;
    private String tarea;
    private boolean estado;

    
    public gestor() {
        this.id=0;
        this.tarea="";
        this.estado=false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
