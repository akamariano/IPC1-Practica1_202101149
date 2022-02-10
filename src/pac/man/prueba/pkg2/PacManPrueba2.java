/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pac.man.prueba.pkg2;

/**
 *
 * @author Mariano Rack
 */
import java.util.Random;
import java.util.Scanner;


public class PacManPrueba2 {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) {
        // TODO code application logic here
      Lista historial = new Lista();
          
         int menu=0;
         int puntaje =0;
         int n=0,n2=0;
        String nom="";
        int edad=0;
        int alto, ancho,movimiento=0;
         while(menu!=3){
             String a="";
             System.out.println("**************");
        System.out.println("*1. Jugar    *");
        System.out.println("*2. Historial*");
        System.out.println("*3. Salir     *");
        System.out.println("**************");
             System.out.println("Ingrese el número de su opción");
              Scanner input = new Scanner(System.in);
             menu= input.nextInt();
              switch(menu)
        {
            case 1 -> {  
                System.out.println("Ingrese su nombre");
                nom = input.next();
                System.out.println("Ingrese su edad");
                Scanner ageentry = new Scanner(System.in);
                edad = ageentry.nextInt();
                System.out.println("Elija las Proporciones del tablero");
                System.out.println("NOTA: Tiene que tener un mínimo en las proporciones de ancho y alto de 8 x 8");
                alto=0;
                ancho =0;
                System.out.println("Ingrese el largo del tablero");
                Scanner altoentry = new Scanner(System.in);
                alto = altoentry.nextInt();
                System.out.println("Ingrese el alto del tablero");
                Scanner anchoentry = new Scanner(System.in);
                ancho = anchoentry.nextInt();
                while (ancho<8 || alto<8){
                    System.out.println("RECUERDA: El tablero tiene que tener un mínimo de 8 x 8");
                    System.out.println("Ingrese el largo del tablero de nuevo");
                    Scanner altoentry1 = new Scanner(System.in);
                    alto = altoentry1.nextInt();
                    //puse las variables de ancho y alto  al revés xD pero ya no lo cambie para no confundirme más
                    System.out.println("Ingrese el alto del tablero de nuevo");
                    Scanner anchoentry1 = new Scanner(System.in);
                    ancho = anchoentry1.nextInt();
                }
                System.out.println("el  largo es de" + " " + alto);
                System.out.println("el alto es de" + " " + ancho);
                
                System.out.println("                    ");
                System.out.println("                    ");
                System.out.println("                    ");
                System.out.println("                    ");
                ancho = ancho +2;
                alto = alto +2;
                
                n = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                n2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                int ndolar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                int ndolar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                int nhash = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                int nhash2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                int nar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                int nar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                    n = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                    n2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                    ndolar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                    ndolar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                    nhash = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                    nhash2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                    nar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                    nar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                }
                System.out.println("Su posición inicial es de: ["+n+" , "+n2+"]");
                String[][] matriz = new String[ancho][alto];
                for (int i = 0; i < ancho; i++) {
                    for (int j = 0; j < alto; j++) {
                        if(i==0 || i==(ancho-1)){
                            matriz[i][j]="*";
                        }
                        else if(j==0 || j==(alto-1)){
                            
                            matriz[i][j]="*";
                        }
                        else{
                            matriz[i][j]=" ";
                            
                            //Autor Mariano Rac
                            
                            matriz[n][n2]="V";
                            matriz[ndolar][ndolar2]="$";
                            matriz[nhash][nhash2]="#";
                            matriz[nar][nar2]="@";
                            
                            Random random = new Random();
                            String setOfCharacters ="*"+" "+" "+" "+" "+" "; //se puede ajustar la cantidad de paredes en este caso existe la probabilidad del 16.67% de que el tablero sean paredes ó "*"
                            int randomInt = random.nextInt(setOfCharacters.length());
                            char randomChar = setOfCharacters.charAt(randomInt);
                            matriz[i][j] = ""+randomChar;
                            //formulas para los espacios en blanco donde pasará pacman, fueron calculadas a mano, estéticamente si la altura es par se ve mejor con 2 espacios y si es impar se ve mejor con 3
                            if(ancho%2==0){
                                
                                matriz[(ancho/2)-1][0]=" ";
                                matriz[ancho/2][0]=" ";
                                
                                matriz[(ancho/2)-1][alto-1]=" ";
                                matriz[ancho/2][alto-1]=" ";
                                
                            }
                            else {
                                
                                matriz[(ancho+1)/2][0]=" ";
                                matriz[(ancho-1)/2][0]=" ";
                                matriz[((ancho-3)/2)][0]=" ";
                                matriz[(ancho+1)/2][alto-1]=" ";
                                matriz[(ancho-1)/2][alto-1]=" ";
                                matriz[((ancho-3)/2)][alto-1]=" ";
                            }
                        }
                    }
                }
                
                
                
                for (int i = 0; i < ancho; i++) {
                    for (int j = 0; j < alto; j++) {
                        
                        System.out.print(matriz[i][j]+" ");
                        
                    }
                    System.out.println(" ");
                    
                }
                System.out.println(" ");
                
                nom=nom;
                puntaje =10;
                movimiento=0;
                while(puntaje>0 && puntaje <100){
                    System.out.println("$ otorga 15 puntos  @ otorga 10 puntos  # quita 10 puntos");
                    System.out.println("Si tu puntaje es de 0 o menos pierdes:(");
                    System.out.println("Si alcanzas 100 puntos o más ganas :)");
                    System.out.println("INGRESE AWSD para moverse");
                    System.out.println("INGRESE M para cancelar");
                    Scanner aentry = new Scanner(System.in);
                    a = aentry.next();
                    if("M".equals(a)){
                        break;
                    }
                    if("A".equals(a)){
                        if("".equals(matriz[n][n2-1]) || " ".equals(matriz[n][n2-1]) || "  ".equals(matriz[n][n2-1])){
                            movimiento = movimiento +1;
                            System.out.println("Su puntaje es de: " + puntaje);
                            System.out.println("Lleva un total de: " + movimiento +" movimientos");
                            matriz[n][n2]=" ";
                            matriz[n][n2-1]="V";
                            n2=n2-1;
                            if(ancho%2==0){
                                if( "V".equals(matriz[(ancho/2)-1][0])){
                                    matriz[(ancho/2)-1][alto-2]="V";
                                    matriz[(ancho/2)-1][0]=" ";
                                    n=(ancho/2)-1;
                                    n2=alto-2;
                                    movimiento = movimiento +1;
                                    System.out.println("Su puntaje es de: " + puntaje);
                                    System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                }
                                else if( "V".equals(matriz[ancho/2][0]))
                                {
                                    
                                    matriz[ancho/2][alto-2]="V";
                                    matriz[ancho/2][0]=" ";
                                    n=ancho/2;
                                    n2=alto-2;
                                    movimiento = movimiento +1;
                                    System.out.println("Su puntaje es de: " + puntaje);
                                    System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                }
                            }
                            else if (ancho%2!=0)
                            {
                                if("V".equals(matriz[(ancho+1)/2][0])){
                                    matriz[(ancho+1)/2][alto-2]="V";
                                    n=(ancho+1)/2;
                                    n2=alto-2;
                                    matriz[(ancho+1)/2][0]=" ";
                                    movimiento = movimiento +1;
                                    System.out.println("Su puntaje es de: " + puntaje);
                                    System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                    
                                    
                                    
                                    
                                }
                                else if("V".equals(matriz[(ancho-1)/2][0])){
                                    matriz[(ancho-1)/2][alto-2]="V";
                                    n=(ancho-1)/2;
                                    n2=alto-2;
                                    matriz[(ancho-1)/2][0]=" ";
                                    movimiento = movimiento +1;
                                    System.out.println("Su puntaje es de: " + puntaje);
                                    System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                }
                                else if( "V".equals(matriz[((ancho-3)/2)][0])){
                                    matriz[((ancho-3)/2)][alto-2]="V";
                                    n=((ancho-3)/2);
                                    n2=alto-2;
                                    matriz[((ancho-3)/2)][0]=" ";
                                    movimiento = movimiento +1;
                                    System.out.println("Su puntaje es de: " + puntaje);
                                    System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                }
                                
                            }
                        }
                        
                        
                        if("*".equals(matriz[n][n2-1])){
                            matriz[n][n2]="V";
                            n=n;
                            n2=n2;
                            movimiento = movimiento +1;
                            System.out.println("Su puntaje es de: " + puntaje);
                            System.out.println("Lleva un total de: " + movimiento +" movimientos");
                        }
                        if("$".equals(matriz[n][n2-1])){
                            System.out.println("Has ganado 15 puntos");
                            puntaje = puntaje +15;
                            matriz[n][n2]=" ";
                            n=n;
                            n2=n2-1;
                            matriz[n][n2]="V";
                            System.out.println("Su puntaje es de: " + puntaje);
                            ndolar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                            ndolar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                            while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                                ndolar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                                ndolar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                                
                                movimiento = movimiento +1;
                                System.out.println("Su puntaje es de: " + puntaje);
                                System.out.println("Lleva un total de: " + movimiento +" movimientos");
                            }
                            matriz[ndolar][ndolar2]="$";
                        }
                        if("#".equals(matriz[n][n2-1])){
                            System.out.println("Has perdido 10 puntos");
                            puntaje = puntaje -10;
                            matriz[n][n2]=" ";
                            n=n;
                            n2=n2-1;
                            matriz[n][n2]="V";
                            System.out.println("Su puntaje es de: " + puntaje);
                            nhash = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                            nhash2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                            while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                                nhash = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                                nhash2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                                
                                movimiento = movimiento +1;
                                System.out.println("Su puntaje es de: " + puntaje);
                                System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                //Autor Mariano Rac
                            }
                            matriz[nhash][nhash2]="#";
                        }
                        
                        if("@".equals(matriz[n][n2-1])){
                            System.out.println("Has ganado 10 puntos");
                            puntaje = puntaje +10;
                            matriz[n][n2]=" ";
                            n=n;
                            n2=n2-1;
                            matriz[n][n2]="V";
                            System.out.println("Su puntaje es de: " + puntaje);
                            nar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                            nar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                            while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                                nar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                                nar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                                
                                movimiento = movimiento +1;
                                System.out.println("Su puntaje es de: " + puntaje);
                                System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                
                            }
                            matriz[nar][nar2]="@";
                        }
                        
                        
                        
                        for (int i = 0; i < ancho; i++) {
                            for (int j = 0; j < alto; j++) {
                                
                                System.out.print(matriz[i][j]+" ");
                                
                            }
                            System.out.println(" ");
                            
                        }
                        System.out.println(" ");
                        
                    }
                    if("D".equals(a)){
                        if("".equals(matriz[n][n2+1]) || " ".equals(matriz[n][n2+1]) || "  ".equals(matriz[n][n2+1])){
                            matriz[n][n2]=" ";
                            matriz[n][n2+1]="V";
                            n=n;
                            n2=n2+1;
                            movimiento = movimiento +1;
                            System.out.println("Su puntaje es de: " + puntaje);
                            System.out.println("Lleva un total de: " + movimiento +" movimientos");
                            if(ancho%2==0){
                                if( "V".equals(matriz[(ancho/2)-1][alto-1])){
                                    matriz[(ancho/2)-1][1]="V";
                                    n=(ancho/2)-1;
                                    n2=1;
                                    matriz[(ancho/2)-1][alto-1]=" ";
                                    movimiento = movimiento +1;
                                    System.out.println("Su puntaje es de: " + puntaje);
                                    System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                }
                                else if( "V".equals(matriz[ancho/2][alto-1]))
                                {
                                    
                                    matriz[ancho/2][1]="V";
                                    n=ancho/2;
                                    n2=1;
                                    matriz[ancho/2][alto-1]=" ";
                                    movimiento = movimiento +1;
                                    System.out.println("Su puntaje es de: " + puntaje);
                                    System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                }
                            }
                            else if(ancho%2!=0)
                            {
                                if("V".equals(matriz[(ancho+1)/2][alto-1])){
                                    matriz[(ancho+1)/2][1]="V";
                                    n=(ancho+1)/2;
                                    n2=1;
                                    matriz[(ancho+1)/2][alto-1]=" ";
                                    
                                    movimiento = movimiento +1;
                                    System.out.println("Su puntaje es de: " + puntaje);
                                    System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                    
                                    
                                    
                                }
                                else if("V".equals(matriz[(ancho-1)/2][alto-1])){
                                    matriz[(ancho-1)/2][1]="V";
                                    n=(ancho-1)/2;
                                    n2=1;
                                    matriz[(ancho-1)/2][alto-1]=" ";
                                    movimiento = movimiento +1;
                                    System.out.println("Su puntaje es de: " + puntaje);
                                    System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                }
                                else if( "V".equals(matriz[((ancho-3)/2)][alto-1])){
                                    matriz[((ancho-3)/2)][1]="V";
                                    n=((ancho-3)/2);
                                    n2=1;
                                    matriz[((ancho-3)/2)][alto-1]=" ";
                                    movimiento = movimiento +1;
                                    System.out.println("Su puntaje es de: " + puntaje);
                                    System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                }
                                
                            }
                        }
                        
                        
                        if("*".equals(matriz[n][n2+1])){
                            matriz[n][n2]="V";
                            n=n;
                            n2=n2;
                            movimiento = movimiento +1;
                            System.out.println("Su puntaje es de: " + puntaje);
                            System.out.println("Lleva un total de: " + movimiento +" movimientos");
                        }
                        if("$".equals(matriz[n][n2+1])){
                            System.out.println("Has ganado 15 puntos");
                            puntaje = puntaje +15;
                            matriz[n][n2]=" ";
                            n=n;
                            n2=n2+1;
                            matriz[n][n2]="V";
                            System.out.println("Su puntaje es de: " + puntaje);
                            ndolar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                            ndolar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                            while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                                ndolar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                                ndolar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                                
                                movimiento = movimiento +1;
                                System.out.println("Su puntaje es de: " + puntaje);
                                System.out.println("Lleva un total de: " + movimiento +" movimientos");
                                
                            }
                            matriz[ndolar][ndolar2]="$";
                        }
                        if("#".equals(matriz[n][n2+1])){
                            System.out.println("Has perdido 10 puntos");
                            puntaje = puntaje -10;
                            matriz[n][n2]=" ";
                            n=n;
                            n2=n2+1;
                            matriz[n][n2]="V";
                            System.out.println("Su puntaje es de: " + puntaje);
                            nhash = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                            nhash2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                            while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                                nhash = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                                nhash2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                                
                                movimiento = movimiento +1;
                                System.out.println("Su puntaje es de: " + puntaje);
                                System.out.println("Lleva un total de: " + movimiento +" movimientos");
                            }
                            matriz[nhash][nhash2]="#";
                        }
                        
                        if("@".equals(matriz[n][n2+1])){
                            System.out.println("Has ganado 10 puntos");
                            puntaje = puntaje +10;
                            matriz[n][n2]=" ";
                            n=n;
                            n2=n2+1;
                            matriz[n][n2]="V";
                            System.out.println("Su puntaje es de: " + puntaje);
                            nar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                            nar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                            while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                                nar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                                nar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                                
                                movimiento = movimiento +1;
                                System.out.println("Su puntaje es de: " + puntaje);
                                System.out.println("Lleva un total de: " + movimiento +" movimientos");
                            }
                            matriz[nar][nar2]="@";
                        }
                        
                        for (int i = 0; i < ancho; i++) {
                            for (int j = 0; j < alto; j++) {
                                
                                System.out.print(matriz[i][j]+" ");
                                
                            }
                            System.out.println(" ");
                            
                        }
                        System.out.println(" ");
                        
                        
                    }
                    if("W".equals(a)){
                        if("".equals(matriz[n-1][n2]) || " ".equals(matriz[n-1][n2]) || "  ".equals(matriz[n-1][n2])){
                            
                            System.out.println("Su puntaje es de: " + puntaje);
                            matriz[n][n2]=" ";
                            matriz[n-1][n2]="V";
                            n=n-1;
                            
                            movimiento = movimiento +1;
                            System.out.println("Su puntaje es de: " + puntaje);
                            System.out.println("Lleva un total de: " + movimiento +" movimientos");
                            
                        }
                        if("*".equals(matriz[n-1][n2])){
                            matriz[n][n2]="V";
                            n=n;n2=n2;
                            movimiento = movimiento +1;
                            System.out.println("Su puntaje es de: " + puntaje);
                            System.out.println("Lleva un total de: " + movimiento +" movimientos");
                        }
                        
                        if(matriz[n-1][n2]=="$"){
                            System.out.println("Has ganado 15 puntos");
                            puntaje = puntaje +15;
                            matriz[n][n2]=" ";
                            n=n-1; n2=n2;
                            matriz[n][n2]="V";
                            System.out.println("Su puntaje es de: " + puntaje);
                            ndolar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                            ndolar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                            while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                                ndolar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                                ndolar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                                movimiento = movimiento +1;
                                System.out.println("Su puntaje es de: " + puntaje);
                                System.out.println("Lleva un total de: " + movimiento +" movimientos");
                            }
                            matriz[ndolar][ndolar2]="$";
                        }
                        if("#".equals(matriz[n-1][n2])){
                            System.out.println("Has perdido 10 puntos");
                            puntaje = puntaje -10;
                            matriz[n][n2]=" ";
                            n=n-1; n2=n2;
                            matriz[n][n2]="V";
                            System.out.println("Su puntaje es de: " + puntaje);
                            //Autor Mariano Rac
                            nhash = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                            nhash2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                            while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                                nhash = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                                nhash2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                                movimiento = movimiento +1;
                                System.out.println("Su puntaje es de: " + puntaje);
                                System.out.println("Lleva un total de: " + movimiento +" movimientos");
                            }
                            matriz[nhash][nhash2]="#";
                        }
                        if("@".equals(matriz[n-1][n2])){
                            System.out.println("Has ganado 1o puntos");
                            puntaje = puntaje +10;
                            matriz[n][n2]=" ";
                            n=n-1; n2=n2;
                            matriz[n][n2]="V";
                            
                            nar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                            nar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                            while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                                nar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                                nar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                                movimiento = movimiento +1;
                                System.out.println("Su puntaje es de: " + puntaje);
                                System.out.println("Lleva un total de: " + movimiento +" movimientos");
                            }
                            matriz[nar][nar2]="@";
                        }
                        for (int i = 0; i < ancho; i++) {
                            for (int j = 0; j < alto; j++) {
                                
                                System.out.print(matriz[i][j]+" ");
                                
                            }
                            System.out.println(" ");
                            
                        }
                        System.out.println(" ");
                    }
                    if("S".equals(a)){
                        if("".equals(matriz[n+1][n2]) || " ".equals(matriz[n+1][n2]) || "  ".equals(matriz[n+1][n2])){
                            System.out.println("Su puntaje es de: " + puntaje);
                            matriz[n][n2]=" ";
                            matriz[n+1][n2]="V";
                            n=n+1;
                            movimiento = movimiento +1;
                            System.out.println("Su puntaje es de: " + puntaje);
                            System.out.println("Lleva un total de: " + movimiento +" movimientos");
                        }
                        if("*".equals(matriz[n+1][n2]) ||"*".equals(matriz[n+1][n2])  ){
                            matriz[n][n2]="V";
                            n=n;n2=n2;
                            System.out.println("Su puntaje es de: " + puntaje);
                            movimiento = movimiento +1;
                            System.out.println("Lleva un total de: " + movimiento +" movimientos");
                        }
                        if(matriz[n+1][n2]=="$"){
                            System.out.println("Has ganado 15 puntos");
                            puntaje = puntaje +15;
                            matriz[n][n2]=" ";
                            n=n+1; n2=n2;
                            matriz[n][n2]="V";
                            System.out.println("Su puntaje es de: " + puntaje);
                            ndolar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                            ndolar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                            while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                                ndolar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                                ndolar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                                movimiento = movimiento +1;
                                System.out.println("Su puntaje es de: " + puntaje);
                                System.out.println("Lleva un totall de: " + movimiento +" movimientos");
                            }
                            matriz[ndolar][ndolar2]="$";
                        }
                        if("#".equals(matriz[n+1][n2])){
                            System.out.println("Has perdido 10 puntos");
                            puntaje = puntaje -10;
                            matriz[n][n2]=" ";
                            n=n+1; n2=n2;
                            matriz[n][n2]="V";
                            System.out.println("Su puntaje es de: " + puntaje);
                            nhash = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                            nhash2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                            while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                                nhash = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                                nhash2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                                movimiento = movimiento +1;
                                System.out.println("Su puntaje es de: " + puntaje);
                                System.out.println("Lleva un totall de: " + movimiento +" movimientos");
                            }
                            matriz[nhash][nhash2]="#";
                        }
                        if("@".equals(matriz[n+1][n2])){
                            System.out.println("Has ganado 10 puntos");
                            System.out.println("Su puntaje es de: " + puntaje);
                            puntaje = puntaje +10;
                            matriz[n][n2]=" ";
                            n=n+1; n2=n2;
                            matriz[n][n2]="V";
                            System.out.println("Su puntaje es de: " + puntaje);
                            nar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                            nar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                            while(n==ndolar || n==nhash || n==nar || ndolar==nhash || nhash==nar || ndolar==nar){
                                nar = (int) (Math.random() * ((ancho-1) - 1)) + 1;
                                nar2 = (int) (Math.random() * ((alto-1) - 1)) + 1;
                                movimiento = movimiento +1;
                                System.out.println("Su puntaje es de: " + puntaje);
                                System.out.println("Lleva un totall de: " + movimiento +" movimientos");
                            }
                            matriz[nar][nar2]="@";
                        }
                        for (int i = 0; i < ancho; i++) {
                            for (int j = 0; j < alto; j++) {
                                
                                System.out.print(matriz[i][j]+" ");
                                
                            }
                            System.out.println(" ");
                            
                        }
                        System.out.println(" ");
                        
                    }
                    if("M".equals(a)){
                        
                        break;
                        
                    }
                    
                    if(puntaje >=100)
                    {
                        System.out.println("✰✰✰✰✰Felicidades " + nom +" "+" has ganado y has hecho un puntaje de: "+ puntaje+" y lo has logrado en: "  + movimiento + " movimientos "+"✰✰✰✰✰");
                    }
                    if(puntaje <=0)
                    {
                        System.out.println("Has perdido:((" );
                    }
                    
                    
                }
                movimiento = movimiento;
                Player dataplayers = new Player(nom,edad,puntaje,movimiento);
                if(historial.tamaño==0){
                    historial.addfirst(dataplayers);
                }
                else
                {
                    historial.addnext(dataplayers);
                }             }
        
            case 2 -> historial.print();
        case 3 -> {
            System.out.println("Gracias por jugar");
            System.exit(0);
              }
        default -> System.out.println("Su entrada no es válida");

}
         }
    }
    }
               