package com.dk.engineeringseries.Modelss;

public class Contadores {
    public int contDev, contRedes = 0, contGeren = 0, contTestes = 0, contDados = 0;

    public int getContDev() {
        return contDev;
    }

    public Contadores(int contDev, int contRedes, int contGeren, int contTestes, int contDados) {
        this.contDev = contDev;
        this.contRedes = contRedes;
        this.contGeren = contGeren;
        this.contTestes = contTestes;
        this.contDados = contDados;
    }

    public void setContDev(int contDev) {
        this.contDev = contDev;
    }

    public int getContRedes() {
        return contRedes;
    }

    public void setContRedes(int contRedes) {
        this.contRedes = contRedes;
    }

    public int getContGeren() {
        return contGeren;
    }

    public void setContGeren(int contGeren) {
        this.contGeren = contGeren;
    }

    public int getContTestes() {
        return contTestes;
    }

    public void setContTestes(int contTestes) {
        this.contTestes = contTestes;
    }

    public int getContDados() {
        return contDados;
    }

    public void setContDados(int contDados) {
        this.contDados = contDados;
    }

    public void somarDev(){
        this.contDev = this.contDev + 1;
    }
}
