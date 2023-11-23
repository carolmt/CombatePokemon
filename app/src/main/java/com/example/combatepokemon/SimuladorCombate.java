package com.example.combatepokemon;

import java.util.Random;

public class SimuladorCombate {
    public static class Pokemon {
        private String nombre;
        private int ataque;
        private int hp;
        private int defensa;
        private int ataqueEspecial;
        private int defensaEspecial;

        public Pokemon(String nombre, int ataque, int hp, int defensa, int ataqueEspecial, int defensaEspecial) {
            this.nombre = nombre;
            this.ataque = ataque;
            this.hp = hp;
            this.defensa = defensa;
            this.ataqueEspecial = ataqueEspecial;
            this.defensaEspecial = defensaEspecial;
        }

        public Pokemon(int ataque, int hp, int defensa, int ataqueEspecial, int defensaEspecial) {
            this.ataque = ataque;
            this.hp = hp;
            this.defensa = defensa;
            this.ataqueEspecial = ataqueEspecial;
            this.defensaEspecial = defensaEspecial;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getAtaque() {
            return ataque;
        }

        public void setAtaque(int ataque) {
            this.ataque = ataque;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getDefensa() {
            return defensa;
        }

        public void setDefensa(int defensa) {
            this.defensa = defensa;
        }

        public int getAtaqueEspecial() {
            return ataqueEspecial;
        }

        public void setAtaqueEspecial(int ataqueEspecial) {
            this.ataqueEspecial = ataqueEspecial;
        }

        public int getDefensaEspecial() {
            return defensaEspecial;
        }

        public void setDefensaEspecial(int defensaEspecial) {
            this.defensaEspecial = defensaEspecial;
        }
    }

    public int recibirAtaque(Pokemon p1, Pokemon p2) {
        int danyoRecibido = 0;
        int defensa ;
        int aleatorio;
        Random rnd = new Random();
        aleatorio=rnd.nextInt(100);

        try {

            if (aleatorio % 5 == 0) {
                danyoRecibido = p1.getAtaqueEspecial();
                Thread.sleep(1000);
                p2.setHp(p2.getHp()-danyoRecibido+p2.getDefensaEspecial());
                defensa = p2.getHp();
                return defensa;
            }
            else {
                danyoRecibido = p1.getAtaque();
                Thread.sleep(1000);   //hago que tarde 1 sec en hacer efecto el ataque.
                p2.setHp(p2.getHp()-danyoRecibido+p2.getDefensa()); //aquí modifico los puntos de salud.
                defensa = p2.getHp();
                return defensa;
            }
        } catch (InterruptedException e) {
        }
        defensa = p2.getHp();
        return defensa;
    }

}
