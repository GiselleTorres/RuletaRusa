package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuletaRusa {
    private  List<Integer> tambor;
    private int bala;
    private int posicionActual;
    private Random random;

    public RuletaRusa() {
        //Inicializo las camaras y le pongo las 5 popsiciones
        tambor = new ArrayList<>();
        for (int i=0; i<6 ; i++){
            tambor.add(i);
        }
        //Asigna de forma aleatoria la posición de la bala dentro de la lista.
        random=new Random();
        bala=random.nextInt(tambor.size());

        //Inicializa el generador aleatorio
        posicionActual= random.nextInt(tambor.size());
    }

    public RuletaRusa(List<Integer> tambor, int bala, int posicionActual, Random random) {
        this.tambor = tambor;
        this.bala = bala;
        this.posicionActual = posicionActual;
        this.random = random;
    }

    public int getBala() {
        return bala;
    }

    public void setBala(int bala) {
        this.bala = bala;
    }

    public List<Integer> getTambor() {
        return tambor;
    }

    public void setTambor(List<Integer> tambor) {
        this.tambor = tambor;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public boolean disparar() {
        if (posicionActual == bala) {
            return true;
        } else {
            posicionActual = (posicionActual + 1)% tambor.size();
            return false;
        }
    }

    public void reiniciarJuego(){
        //Inicializo las camaras y le pongo las 5 popsiciones
        tambor = new ArrayList<>();
        for (int i=0; i<6 ; i++){
            tambor.add(i);
        }
        //Asigna de forma aleatoria la posición de la bala dentro de la lista.
        random=new Random();
        bala=random.nextInt(tambor.size());

        //Inicializa el generador aleatorio
        posicionActual= random.nextInt(tambor.size());
    }
}
