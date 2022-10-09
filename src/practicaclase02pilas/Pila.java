//La Pila va a necesitar del atributo (Cima) porque necesito saber cual es el Top (El ultimo Nodo)
//Tambien necesito saber cual es la cantidad de nodos que tiene mi pila (Atributo largo)
//
package practicaclase02pilas;

public class Pila {

    private Nodo cima; //Cima es de tipo nodo ya que estoy almacenando el ultimo nodo en ser almacenado (Objeto de tipo nodo en variable nodo)
    private int largo;

    public Pila() {
        this.cima = null; //Los objetos siempre se inicializan en Nulo
        this.largo = 0;
    }

    //Primer metodo para la pila, se llama vacia, para validar si la pila esta vacia o no.
    public boolean vacia() {
        return cima == null; // Es cima igual a Nulo? True/False
    }

    //Segundo metodo para la pila es tamaño, que me devuelve el tamaño de mi pila
    public int tamano() {
        return largo;
    }

    //Metodo Push: A el le voy a pasar el valor del nodo que se va a agregar a la pila.
    public void push(int valor) {
        //Creo un nuevo Nodo
        Nodo newNodo = new Nodo();
        //Le doy el valor a mi nodo
        newNodo.setValor(valor);

        //Si esta vacia? 
        if (this.vacia()) { //Entonces
            this.cima = newNodo; //Agarro el nodo y lo asigno como cima, aqui ya tendria una pila porque hay una variable que apunte a Cima
        } else { //De lo contrario?
            newNodo.setSiguiente(this.cima); //Voy a referenciar el nodo que va a estar debajo de mi
            this.cima = newNodo; //Como el nodo de abajo ya no va a ser la Cima, necesito hacer la referencia al nuevo nodo que acabo de crear
        }
        //Contador del largo del nodo, por cada nodo que agrego le sumo 1
        this.largo++;
    }

    //Metodo Pop: Borra el objeto que este en la cima de la pila.
    public void pop() {
        //Reviso si esta vacia? De lo contrario no tiene sentido, valido si la cima esta en Null
        if (!vacia()) { //Se lee, si NO ! esta vacia, entonces? Extraiga el Nodo
            //Para Java la pila se cuenta de la Cima, hacia abajo
            this.cima = this.cima.getSiguiente(); //Le decimos a la Cima, que ya no es la cima, sino va a ser el nodo que esta abajo

            //Decrementa el contador del largo del nodo, por cada nodo que quito le resto 1
            this.largo--;
        }
    }

    //Metodo buscar: Lo uso para validar si un nodo existe o no existe? Los nodos tienen valores, en teoria no pueden haber dos nodos con el mismo valor, ya que son como su ID
    //Le paso el Valor o ID del nodo y luego recorro los nodos para ver cual es el True, si no lo encuentra es un False
    public boolean search(int reference) {
        //No puedo utilizar la Cima para ir recorriendo, ya que al momento de mover la cima, borro los nodos
        //Para desplazar, necesito una Cima Auxiliar/Temporal
        //Creo una copia de la pila, para asignar Aux a Cima
        Nodo aux = cima;
        //Badera para verificar si existe el elemento a buscar
        boolean exist = false;
        //Recorrer la pila hasta llegar a encontrar el nodo o llegar al final de la pila
        while (exist != true && aux != null) { //Mientras Existe sea != diferente a True y la cima auxiliar sea != diferente a nula, significa que ya llegue al final

            if (reference == aux.getValor()) { //Compara si el valor del nodo es igual al de la referencia
                exist = true; //Cambia el valor de la bandera
            } else { //De lo contrario?
                aux = aux.getSiguiente();//Avanza al siguiente Nodo
            }
        }
        return exist; //Retorna el valor de la bandera
    }

    //Metodo Pop Modificado: Borra un Nodo que este abajo sin perder el resto
    public void popModificado(int reference) {
        //Consulta si el valor existe en la pila
        if (search(reference)) {
            //Crea una pila auxiliar/temporal para guardar los valores que se vayan desapilando de la fila original
            Nodo aux = null; // Null para inicializarlo
            //Recorre la pila hasta llegar al nodo que tenga el valor igual que el de reference
            while (reference != cima.getValor()) { //Mientras que la referencia sea diferente a la cima.getValor *Si agrego .getValor nuevamente, llamo al valor y luego al objeto
                //Creo un Nodo Temporal y le doy el valor que esta en la cima para agregarlo a la cima temporal
                Nodo temp = new Nodo();
                //Ingreso el valor al Nodo temporal
                temp.setValor(cima.getValor()); //Le doy el valor de la cima de ese momento
                //Consulto si la pila no ha sido inicializada 
                if (aux == null) { //Si el auxiliar en Nulo? Entonces
                    aux = temp; //Inicializo la pila auxiliar
                } else { //De lo contrario, si ya hay elementos, los agrego al start.
                    temp.setSiguiente(aux); //Lo mismo que hicimos en el Push
                    aux = temp;
                }
                pop(); //Elimina el Nodo del tope de la pila hasta llegar al nodo que se quiere 

            }
            pop(); //Elimina el Nodo que coincide con el que estamos buscando
            //Regresa los valores de la pila auxiliar a la pila original
            //==============  ENSAMBLO DE NUEVO LA PILA ORIGINAL ==============
            while (aux != null) { //*Siempre que recorro va un While (Mientras el auxiliar sea diferente de nulo)
                //Utilizo el metodo Push para regresar los elementos a la pila original
                push(aux.getValor());
                //Avanza al siguiente nodo de la pila auxiliar
                aux = aux.getSiguiente();
            }
            //=================================================================
        } else {
            System.out.println("El nodo indicado no existe.");
        }

    }

    //Metodo Listar, para imprimir la pila
    public void Listar() {
        Nodo aux = cima;//Creo una copia de la pila
        while (aux != null) { //Me detengo cuando la variable auxiliar sea igual a Nulo, mientras sea diferente voy a seguir moviendo en la pila
            //Imprimo el valor que tenga el Nodo
            System.out.println("|\t" + aux.getValor() + "\t|");
            System.out.println("------------------");
            //Muevo el auxiliar a .getSiguiente
            aux = aux.getSiguiente();
        }
    }
}
