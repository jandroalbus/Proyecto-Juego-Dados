import java.util.Scanner;
import java.util.Random;

public class JuegoDadosMetodos {
   
  //DECLARACIÓN DE VARIABLES GLOBALES
  public static Scanner lector = new Scanner(System.in);
  public static final int DELAY = 1500, MIN = 1, MAX = 6;
  
  public static int puntosPlayer = 0, porrasPlayer = 0, puntosCPU = 0, porrasCPU = 0;
  public static boolean plantado = false;
  
  //INICIAMOS EL PROGRAMA
  public static void main(String[] args){
    int opcion;
    do{
      printMenu();
      opcion = Integer.parseInt(lector.nextLine());
      if(opcion == 1){
	      resetJuego();
        do{
          puntosPlayer = lanzarDado("Player", puntosPlayer);
          if(puntosPlayer < 11) {
            plantado = plantarte();
            if(plantado) {
                plantado = false;
                //Ahora la CPU intenta igualar o mejorar el resultado del jugador
                while(puntosCPU < puntosPlayer) {
                    puntosCPU = lanzarDado("CPU", puntosCPU);
                }
                if(puntosCPU > 11) {
                  System.out.println("CPU se ha pasado. Porra para Player!!");
                  resetRonda("Player");
		            }
		
                else if(puntosCPU > puntosPlayer) { // Gana CPU
                    if(puntosCPU == 11) {
                      porrasCPU = once(porrasCPU, "CPU");
                    } else {
                        System.out.println("CPU ha mejorado tu puntuación. Porra para CPU!!");
                        porrasCPU++;
                    }
                    puntosCPU = 0;
                    puntosPlayer = 0;
                } else { // Empate
                    System.out.println("Empate!! Porra para los dos");
		                resetRonda("Empate");
		                puntuacion();
                }
              }
            } else if (puntosPlayer == 11) {                  
              //Al obtener 11 el jugador suma automáticamente 2 porras
              porrasPlayer = once(porrasPlayer, "PLAYER");
              } else {
              //El jugador se ha pasado
              System.out.println("Ohh!! Te has pasado");
              System.out.println("Porra para la CPU"); 

		          resetRonda("CPU");
            }
          puntuacion();
        }while(porrasPlayer < 5 && porrasCPU < 5);
      }
    }while(opcion != 0);
    System.out.println("Hasta pronto!!");
  }
  
  /**
  METODOS UTILIZADOS
  */
  
  //MUESTRA EL MENU PRINCIPAL
  public static void printMenu(){
    System.out.println("*************************");
    System.out.println("***JUEGO DE DADOS ONCE***");
    System.out.println("1. Nueva partida");
    System.out.println("0. Salir");
    System.out.println("\n Elige una opcion...");
  }
  
  ///LANZA DADO ALEATORIAMENTE - PARAMETRO = QUIEN TIRA
  public static int lanzarDado(String turno, int puntos) {

    int tirada = 0;
    
    System.out.println(turno + " lanza el dado al aire ...");
    delay();

    tirada = aleatorio(MIN, MAX);

    System.out.println("\n*****");               
    System.out.println("* " + tirada + " *");               
    System.out.println("*****");               
    puntos += tirada;
    System.out.println("\nLa puntuación actual es " + puntos);
    return puntos;
  }   

  //DEVUELVE ALEATORIO INTEGER
  public static int aleatorio(int min, int max) {
		
    Random r = new Random();
    return r.nextInt(max - min +1 ) + min;
		
  }
  
  //DEVUELVE DECISION DE PLANTARSE - BOOLEANO
  public static boolean plantarte() {
    char plantarse = ' ';
    System.out.print("¿Deseas plantarte con " + puntosPlayer +" puntos? (s/n): ");
    plantarse = lector.nextLine().charAt(0);

    return plantado =  plantarse == 's' || plantarse == 'S';

  }  
  
  //SI LA PUNTUACION ES ONCE SE SUMARAN DOS PORRAS AL USUARIO
  public static int once(int porras, String turno) {

    System.out.println("\n$$$$$$$$$$$$$$$$");
    System.out.println("$$$$ ¡ONCE! $$$$");
    System.out.println("$$$$$$$$$$$$$$$$");
    System.out.println("\nDoble porra para " + turno + "\n");	
    
    return porras += 2;
  }
  // DELAY MILLISEC
  public static void delay(){
    try {
      Thread.sleep(DELAY);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
	    
	    
	public static void resetJuego(){
    puntosCPU = 0;
    puntosPlayer = 0;
    porrasCPU = 0;
    porrasPlayer = 0;
  }

  public static void puntuacion(){
    System.out.println("\n**********************");
    System.out.println("* " + porrasPlayer + " PLAYER  -  CPU " + porrasCPU + " *");
    System.out.println("**********************");
  }

  public static void resetRonda(String ganador){
    puntosCPU = 0;
    puntosPlayer = 0;
    if(ganador.equalsIgnoreCase("CPU")){
        porrasCPU++;
    }else if(ganador.equalsIgnoreCase("Player")){
        porrasPlayer++;
    }else{
        porrasPlayer++;
        porrasCPU++;
    }
  }
}
