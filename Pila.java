import java.util.ArrayList;

/**
 * Clase de implementación una pila genérica.
 * @param <T> Tipo de elementos que tendra la pila.
 */
public class Pila<T> {
    private ArrayList<T> elementos;

    public Pila() {
        this.elementos = new ArrayList<>();
    }

    /**
     * Agrega un elemento a la cima de la pila.
     * @param elemento El elemento a agregar.
     */
    public void push(T elemento) {
        elementos.add(elemento);
    }

    /**
     * Elimina y devuelve el elemento de la cima de la pila.
     * @return El elemento eliminado.
     * @throws IllegalStateException Si la pila está vacía.
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        return elementos.remove(elementos.size() - 1);
    }

    /**
     * Devuelve el elemento de la cima sin eliminarlo.
     * @return El elemento en la cima.
     * @throws IllegalStateException Si la pila está vacía.
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        return elementos.get(elementos.size() - 1);
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return elementos.isEmpty();
    }
    
    /**
     * Devuelve una representación en cadena de la pila.
     * @return Una cadena que muestra los elementos de la pila.
     */
    @Override
    public String toString() {
        return elementos.toString();
    }

}
