/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pac.man.prueba.pkg2;

/**
 *
 * @author Mariano Rack
 */
public class Player {
    
    private String nombre;
    private int edad;
    private int punteo;
    private int movimientos;
    public Player next;

    public Player(String nombre, int edad, int punteo, int movi) {
        this.nombre = nombre;
        this.edad = edad;
        this.next = this;
        this.punteo = punteo;
        this.movimientos = movi;
    }
    
    public void printdata(){
        System.out.println("------------------------------");
        System.out.println("Nombre: "+nombre);
        System.out.println("Edad: "+edad);
        System.out.println("Punteo: "+punteo);
        System.out.println("Movimientos: "+movimientos);
        System.out.println("------------------------------");
    }

    public Player getNext() {
        return next;
    }

    public void setNext(Player next) {
        this.next = next;
    }
}
