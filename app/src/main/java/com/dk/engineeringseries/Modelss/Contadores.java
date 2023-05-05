package com.dk.engineeringseries.Modelss;

public class Contadores {
    public int contDev, contRedes, contGeren, contTestes, contDados;

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

    public int somarDev(){
        return this.contDev++;
    }


}
