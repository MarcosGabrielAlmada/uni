package ar.edu.uns.cs.ed.tdas.tps.tp6;

import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;

public class Ejercicios {
	// ------------------ EJERCICIO 1 ------------------
	// a.  Programe el TDA Árbol respetando la interfaz Tree<E> provista por la cátedra. El árbol general deberá contar  con  una  estructura  de  colección  de  hijos  y  referencia al padre, donde los rótulos de los nodos son de tipo  genérico E. Para implementar la colección de hijos de un nodo utilice la clase lista programada en el TP N° 4.
	// b.  Corra el correspondiente test JUnit para verificar la correctitud de su implementación.
	// c.  Calcule  el  orden  del  tiempo  de  ejecución  de  cada  una  de  las  operaciones  de  la  clase  árbol.  Justifique adecuadamente. // TODO
	
	// ------------------ EJERCICIO 2 ------------------
	// a.  Agregue un método a la clase arbol definida anteriormente cuya signatura sea:  public void eliminarUltimoHijo(Position<E> p) Este método deberá eliminar del árbol receptor del mensaje a la posición p siempre que p sea el último hijo (de  izq  a  der)  de  su  padre.  La  raíz  no  se  considera  último  hijo,  en  este  caso  el  método  deberá  lanzar InvalidOperationException.  Si  la  posición  p  es  inválida  el  método  deberá  lanzar InvalidPositionException.
	// b.  Calcule el tiempo de ejecución de su solución e indique su orden.
	
	// ------------------ EJERCICIO  3 ------------------
	// Programe  un  método  con  la  siguiente  signatura:  public  Map<Character,  Integer> cantidadRepeticiones(Tree<Character> t).  Este  método  deberá  retornar  un  mapeo  con  cada uno de los caracteres del árbol y la cantidad de veces que aparece cada carácter en el árbol. Resuelva este problema utilizando un recorrido en preorden.
	
	// ------------------ EJERCICIO  4 ------------------
	// Dado  un  árbol  a  de  Strings  y  un  String  s,  programe  un  método  tal  que  retorne  un  Iterable  con  las posiciones  del  árbol  en  las  que  aparece  el  String  s.  Para  resolver  este  problema  implemente  un  recorrido  en postorden.
	
	// ------------------ EJERCICIO 5 ------------------
	// a.  Escriba un método tal que dado un árbol genérico a y un elemento e, elimine de a todas las apariciones de e. Compare los elementos por equivalencia. El método debe retornar la cantidad de eliminaciones realizadas.
	// b.  Calcule el tiempo de ejecución de su solución e indique su orden.
	
	// ------------------ EJERCICIO 6 ------------------
	// a.  Dado un árbol de enteros a y un entero n, escriba un método que determine si n pertenece al árbol a. Para resolver este método utilice el iterador del árbol.
	// b.  Calcule el tiempo de ejecución de su solución e indique su orden. 
}
