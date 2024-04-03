
package com.emergentes.te_calificaciones;

public class Calificaciones {
    private int id;
    private String nombre;
    private int P1;
    private int P2;
    private int EF;
    private int nota;

    public Calificaciones() {
        
        this.id = 0;
        this.nombre = "";
        this.P1 = 0;
        this.P2 = 0;
        this.EF = 0;
        this.nota = P1 + P2 + EF;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getP1() {
        return P1;
    }

    public void setP1(int P1) {
        this.P1 = P1;
    }

    public int getP2() {
        return P2;
    }

    public void setP2(int P2) {
        this.P2 = P2;
    }

    public int getEF() {
        return EF;
    }

    public void setEF(int EF) {
        this.EF = EF;
    }

    public int getNota() {
        nota = P1 + P2 + EF;
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
   //public void NotaTotal(int total){
     //   total = this.getP1() + this.getP2() + this.getEF();
        
    //}
    
    
}
