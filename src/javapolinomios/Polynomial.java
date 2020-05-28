package javapolinomios;

import java.util.NoSuchElementException;
import java.util.Random;

public class Polynomial {

    public int dimension;
    public int constante;
    public Nodo raiz;

    public Polynomial(int[] coeficientes) {
        for (int coeficiente : coeficientes) {
            insert(coeficiente);
        }
    }

    public Polynomial() {
        Random rand = new Random();
        constante = rand.nextInt(20);
        Nodo nodo_cons = new Nodo(constante);
        nodo_cons.siguiente = raiz;
        raiz = nodo_cons;
        nodo_cons.exponente = 0;
        dimension++;
    }

    public void add(Polynomial poli) {
        int puntero1 = 0;
        int puntero2 = poli.size() - 1;
        int tam = dimension;
        Nodo raiznodo = raiz;
        if (tam >= poli.size()) {
            for (int i = 0; i < tam; i++) {
                if (poli.getExponente(puntero1) == raiznodo.exponente) {
                    raiznodo.coeficiente += poli.getCoeficiente(puntero1);
                    puntero1++;
                }
                raiznodo = raiznodo.siguiente;
                if (poli.size() - puntero1 == 0) {
                    break;
                }
            }
        } else {
            for (int i = 0; i < poli.size(); i++) {
                if (poli.getExponente(puntero1) != raiznodo.exponente) {
                    insert(poli.getCoeficiente(puntero2 - tam));
                    puntero2--;
                    puntero2++;
                    continue;
                } else {
                    raiznodo.coeficiente += poli.getCoeficiente(puntero1);
                    puntero2++;
                }

                if (raiznodo.exponente == 0) {
                    break;
                }
                raiznodo = raiznodo.siguiente;
            }
        }
    }

    public final void insert(int x) {
        Nodo nodo = new Nodo(x);
        nodo.siguiente = raiz;
        raiz = nodo;
        dimension++;
        nodo.exponente = dimension - 1;
    }

    public void checkPos(int posicion) {
        if (posicion < 0 || posicion >= dimension) {
            throw new NoSuchElementException();
        }
    }

    public int getCoeficiente(int pos) {
        checkPos(pos);
        Nodo raiznodo = raiz;
        for (int i = 0; i < pos; i++) {
            raiznodo = raiznodo.siguiente;
        }
        return raiznodo.coeficiente;
    }

    public void setCoeficiente(int x, int pos) {
        checkPos(pos);
        Nodo raiznodo = raiz;
        for (int i = 0; i < pos; i++) {
            raiznodo = raiznodo.siguiente;
        }
    }

    public int getExponente(int pos) {
        checkPos(pos);
        Nodo raiznodo = raiz;
        for (int i = 0; i < pos; i++) {
            raiznodo = raiznodo.siguiente;
        }
        return raiznodo.exponente;
    }

    public int size() {
        return dimension;
    }
    
    String values(){
        String x = "X";
        String y = "Y";
        return x;
    }
    
    public String toString() {
        StringBuilder partes_funcion = new StringBuilder("P("+values()+") = ");
        Nodo raiznodo = raiz;       
        while (dimension == 0) {
            continue;
        }
        if (raiznodo == null) {
            partes_funcion.append(constante);
            return partes_funcion.toString();
        }
        for (int i = 0; i < dimension; i++) {
            if (raiznodo.coeficiente != 0) {
                if (raiznodo.coeficiente < 0) {
                    partes_funcion.append("(");
                    partes_funcion.append(raiznodo.coeficiente);
                    partes_funcion.append(")");
                } else {
                    partes_funcion.append(raiznodo.coeficiente);
                }
                if (raiznodo.exponente != 0) {
                    partes_funcion.append("x^");
                    partes_funcion.append(raiznodo.exponente);
                }
                if (dimension - i > 1) {
                    partes_funcion.append("+");
                }
            }
            raiznodo = raiznodo.siguiente;
        }
        return partes_funcion.toString();
    }
}
