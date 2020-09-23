import java.util.Scanner;

public class Main {

    public static void main(String... args){

        Scanner scanner = new Scanner(System.in);
        String opcion = "";
        int cuentaJugador = 0;
        int cuentaCasa = 0;

        while(!opcion.equals("Q")){
            System.out.println("Presione enter para generar un número");
            opcion = scanner.nextLine().toUpperCase();

            if(opcion.equals("X")){
                definirGanador(cuentaJugador, cuentaCasa);
                cuentaJugador = 0;
            } else if(opcion.equals("")){
                cuentaJugador = aumentarCuentaJugador(cuentaJugador);
            } else if(!opcion.equals("Q")){
                System.out.println("Opcion no valida");
            }
        }
        System.out.println("¡Hasta pronto!");
    }

    public static int generarNumeroAleatorio(int min, int max){
        return (int) (Math.round(Math.random()*(max-1) + min));
    }

    public static void definirGanador(int cuentaDelJugador, int cuentaCasa){

        cuentaCasa = generarNumeroAleatorio(1, 21);
        if(cuentaCasa > cuentaDelJugador){
            System.out.println("Ha ganado la casa con un valor de " + cuentaCasa + " vs " + cuentaDelJugador);
        } else if(cuentaCasa == cuentaDelJugador){
            System.out.println("¡EMPATE!");
        } else {
            System.out.println("Ha ganado el jugador con un valor de " + cuentaDelJugador + " vs " + cuentaCasa);
        }
    }

    public static int aumentarCuentaJugador(Integer cuentaJugador) {

        cuentaJugador += generarNumeroAleatorio(1, 10);
        if(cuentaJugador > 21){
            System.out.println("Usted ha perdido con " + cuentaJugador + " y el juego se ha reiniciado");
            cuentaJugador = 0;
        } else {
            System.out.println("La cuentaJugador está en " + cuentaJugador);
        }

        return cuentaJugador;
    }
}
