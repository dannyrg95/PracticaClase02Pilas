package practicaclase02pilas;
//Elementos que se "Apilan"
//Caracteristicas
//Solo puedo COLOCAR elementos en la parte superior (Push)
//Solo puedo ELIMINAR elementos en la parte superior (Pop)
//Teoricamente solo tenemos acceso al elemento que esta arriba (Top)
//FIFO First In First Out

public class Main {

    public static void main(String[] args) {
        //Creo la Pila
        Pila miPila = new Pila();
        
        //Ingreso Valores
        miPila.push(5);
        miPila.push(89);
        miPila.push(100);
        miPila.push(677);
        miPila.push(980);
        
        //Imprimo la pila antes del Pop
        System.out.println("PILA Original");
        miPila.Listar();
        
        //Hago un Pop
        miPila.pop();
        
        //Imprimo la pila despues del Pop
        System.out.println("PILA despues de un Pop");
        miPila.Listar();
        
        //Elimino un elemento de la pila "89" e imprimo de nuevo la Pila
        miPila.popModificado(89);
        System.out.println("PILA despues de un Delete a la referencia 89");
        miPila.Listar();
        
        //Otro pero con el "111", el cual no existe
        miPila.popModificado(89);
        System.out.println("PILA despues de un Delete a la referencia 111 que no existe");
        miPila.Listar();
        
    }

}
