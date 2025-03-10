package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> lstjugadores = new ArrayList<>();
        RuletaRusa juego = new RuletaRusa();
        Scanner teclado = new Scanner(System.in);

        // Pedir los nombres de los jugadores
        System.out.println("Escribe los nombres de los jugadores y para terminar escribe 'jugar'");
        String nombreJugador;
        while (true) {
            nombreJugador = teclado.nextLine();
            if (nombreJugador.equalsIgnoreCase("jugar")) {
                break;
            }
            lstjugadores.add(nombreJugador);
        }
        System.out.println("Los jugadores son: " + lstjugadores);
        System.out.println("¡El juego comienza!");

        // Iniciar el juego por turnos
        int turno = 0;
        boolean juegoActivo = true;

        while (juegoActivo) {
            String jugadorActual = lstjugadores.get(turno % lstjugadores.size());  // Turno de un jugador
            System.out.println("\nTurno de: " + jugadorActual);

            // Esperar que el jugador presione Enter para disparar
            System.out.println(jugadorActual + ", presiona Enter para disparar...");
            teclado.nextLine();

            // Disparo del jugador
            boolean resultado = juego.disparar();

            if (resultado) {
                System.out.println("¡BANG! " + jugadorActual + " ha perdido.");
                System.out.print("¿Quieres jugar de nuevo? (si/no): ");
                String respuesta = teclado.nextLine();
                if (respuesta.equalsIgnoreCase("si")) {
                    juego.reiniciarJuego();  // Reiniciar el juego
                    System.out.println("Juego reiniciado. ¡Buena suerte!");
                    turno = 0;  // Reiniciar el contador de turnos
                    lstjugadores.clear();  // Limpiar la lista de jugadores para reiniciar
                    System.out.println("Escribe los nombres de los jugadores y para terminar escribe 'jugar'");
                    while (true) {
                        nombreJugador = teclado.nextLine();
                        if (nombreJugador.equalsIgnoreCase("jugar")) {
                            break;
                        }
                        lstjugadores.add(nombreJugador);
                    }
                    System.out.println("Los jugadores son: " + lstjugadores);
                    System.out.println("¡El juego comienza de nuevo!");
                } else {
                    System.out.println("Gracias por jugar, ¡hasta la próxima!");
                    juegoActivo = false;  // Terminar el juego
                }
            } else {
                System.out.println("¡Disparo fallido! La bala no estaba en esta posición.");
            }

            // Avanzar al siguiente turno
            turno++;
        }

        teclado.close();
    }
}
