package practicaclase02pilas;
//Nodo es un objeto que tiene atributos y comportamientos
//Atributo # 1 valor (Puede ser un String, Entero, Double, Short, Byte, Objeto)
//Atributo # 2 siguiente (Para enlazar los nodos, Primer nodo apunta a Null y el resto al nodo que tenga abajo)
//Un nodo se guarda en otro nodo, sobre la misma variable que la esta declarando
//

public class Nodo {
    private int valor;
    private Nodo siguiente;
    
    //Constructor para inicializar

    public Nodo() {
        this.valor = 0;
        this.siguiente = null; //Primer nodo siempre apunta a Nulo
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
        
}
