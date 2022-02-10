/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pac.man.prueba.pkg2;



/**
 *
 * @author Mariano Rack
 */
public class Lista {
    public int tamaño;
    private Player espacio;

    public Lista() {
        tamaño = 0;
        espacio = null;
    }
    
    public void addfirst(Player pl){
        this.espacio = pl;
        tamaño++;
    }
    
    public void addnext(Player pl){
        Player nextp = this.espacio;
        for(int i=0; i<tamaño; i++){
            nextp = nextp.getNext();
        }
        nextp.setNext(pl);
        tamaño++;
    }
    
    public void print(){
        System.out.println("----------Historial----------\n");
        if(tamaño == 0){
            System.out.println("OJO HISTORIAL VACÍO, NO SE HA JUGADO NINGUNA PARTIDA");
        }else {
            Player nextp = this.espacio;
            nextp.printdata();
            for(int i=1; i<tamaño; i++){
                nextp = nextp.getNext();
                nextp.printdata();
            } 
        }     
    }
}
