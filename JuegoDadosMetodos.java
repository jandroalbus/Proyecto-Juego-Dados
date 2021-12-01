import java.util.Scanner;
import java.util.Random;

public class JuegoDadosMetodos {
   
  //DECLARACIÓN DE VARIABLES GLOBALES
  public static Scanner lector = new Scanner(System.in);
  public static final int DELAY = 500, MIN = 1, MAX = 6;
  
  public static int tiradaPlayer, puntosPlayer = 0, porrasPlayer = 0, tiradaCPU, puntosCPU = 0, porrasCPU = 0;
  public static boolean plantado = false;
  
  public char plantarse;
  
  //INICIAMOS EL PROGRAMA
  public static void main(String[] args) throws InterruptedException {
      int opcion;
      do{
        printMenu();
        opcion = Integer.parseInt(lector.nextLine());
      }while(opcion != 0);
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
    try {
      Thread.sleep(DELAY);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    tirada = aleatorio(MIN, MAX);

    System.out.println("\n*****");               
    System.out.println("* " + tirada + " *");               
    System.out.println("*****");                
         
    System.out.println("\nLa puntuación actual es " + puntos);

    return puntos += tirada;  
    
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
  public static int once(int porras) {

    System.out.println("\n$$$$$$$$$$$$$$$$");
    System.out.println("$$$$ ¡ONCE! $$$$");
    System.out.println("$$$$$$$$$$$$$$$$");
    System.out.println("\nDoble porra para CPU\n");	
    
    return porras += 2;
    
    //EL JUGADOR SE PASA DE 11
     public static int excesoPuntos (int puntosCPU, int puntosPlayer)
     return poprrasCPU += 1;
     return puntos
     if (puntosPlayer > 11){
     System.out.println("Ohh!! Te has pasado");
     System.out.println("Porra para la CPU");  
     }
     
	     
	     
	     
	     
                  //El jugador se ha pasado
                  System.out.println("Ohh!! Te has pasado");
                  System.out.println("Porra para la CPU");                  
                  porrasCPU += 1;
                  puntosCPU = 0;
                  puntosPlayer = 0;
                  System.out.println("\n**********************");
                  System.out.println("* " + porrasPlayer + " PLAYER  -  CPU " +porrasCPU + " *");
                  System.out.println("**********************");
                  System.out.print("\nPulsa intro para continuar...");
                  lector.nextLine();
               }


  }
  
}
