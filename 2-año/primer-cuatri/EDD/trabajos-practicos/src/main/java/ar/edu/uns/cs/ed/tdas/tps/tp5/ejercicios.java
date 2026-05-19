package ar.edu.uns.cs.ed.tdas.tps.tp5;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.tdadiccionario.Dictionary;

public class Ejercicios {
	// ------------------ EJERCICIO 1 ------------------

	// a. Escriba  un  método  que  reciba  dos  mapeos  M1  y  M2  de  enteros  en  enteros  (números  de  libreta  -  nota materia)  que  devuelva  una  PositionList<Pair<Integer,Integer>>  L  con  aquellos elementos E1 de M1 y E2 de M2  que  coincidan  en  la  clave,  pero  tengan  un  valor  diferente.  Por  ejemplo,  si  E1=  (LU:  29303,  Nota:  8) pertenece a M1 y E2= (LU:29303, Nota: 7) pertenece a M2, entonces E1 y E2 deben estar en L.  Puede usar la clase java.util.Pair de Java.
	// public PositionList<Pair<Integer,Integer>> ejercicio1b(Map<Integer, Integer> M1, Map<Integer, Integer> M2) {
	// 	return null;
	// }

	// b. Escriba un método que, dados dos mapeos M1 y M2, determine si todas las claves de M1 están contenidas en M2.
	public boolean ejercicio1b(Map<Integer, Integer> M1, Map<Integer, Integer> M2) {
		if (M1 == null) // c1
			return true; // c2
		if (M2 == null) // c3   // si llega aca, significa que M1 no es null, por lo tanto M1 != null no puede estar contenido en M2 == null
			return false; // c4

		for (Integer clave : M1.keys()) { // c5 + T_M1.keys(n) = c5 + n 
			if (M2.get(clave) == null) { // c6 + T_M2.get(1) = c6 + c_get
				return false; // c7
			}
		}
		return true; // c8

		// T(n) = c1 + c3 + c5 + T_M1.keys(n) + n * (c6 + T_M2.get(1)) + c8
		//      = c1 + c3 + c5 + n + n * (c6 + c_get) + c8
		//      = c1 + c3 + c5 + c8 + n + n*c6 + n*c_get
		//      = const + n * (1 + c6 + c_get)
		//      = O(n) donde n = |M1|
	}

	// c. Escriba  un  método cuya signatura sea: public Dictionary<K,V> acomodar (Dictionary<K,V>   d) que reciba un diccionario  d,  y  que  retorne  un  nuevo  diccionario  igual  a  d  pero  sin  claves  repetidas.  De  esta  manera,  el diccionario resultante de este procedimiento no tendrá entradas con claves iguales. Utilice un mapeo auxiliar para resolver este ejercicio. 
	// Por  ejemplo:  Si  d  = {(1,a), (2,b), (3,a), (2,c), (1,d), (4,b)}, entonces el diccionario resultante es dRes = {(1,d), (2,c), (3,a) (4,b)}.
	public <K,V> Dictionary<K,V> acomodar (Dictionary<K,V>   d) {
		if (d == null) // c1
			return null; // c2

		Dictionary<K,V> dRes = new Diccionario<>(); // c3
		for (Entry<K,V> e : d.entries()) { // c4 + T_d.entries(n) = c4 + n
			if (dRes.find(e.getKey()) != null) // c12
				dRes.remove(dRes.find(e.getKey())); // c5 + c6 + c7 = c8  // en el ejemplo se ve que se obtienen las ultimas coincidencias
			dRes.insert(e.getKey( ), e.getValue()); // c9 + T_e.getKey(1) + T_e.getValue(1) = c10
		}
		return dRes; // c11

		// T(n) = c1 + c3 + c4 + T_d.entries(n) + c12 + n * (c5 + c6 + c7 + c9 + T_e.getKey(1) + T_e.getValue(1)) + c11
		//      = const + n + n * (c8 + c10)
		//      = const + n * (1 + c13)
		//      = O(n) donde n = |d|
	}

	// d. Escriba  un  método  tal  que  reciba  una  PositionList<Character>  y  retorne  un mapeo cuyas claves sean cada uno de los caracteres que aparecen en la lista y el valor la cantidad de veces que aparecen los caracteres en la lista.
	// Por ejemplo: Si l = <a, b, a, c, d, b>, entonces el mapeo resultante es mRes = {(a,2), (b,2), (c,1) (d,1)}. 

	public Map<Character,Integer> ejercicio1d(PositionList<Character> p) {
		if (p == null)
			return null;
		
		Map<Character,Integer> map = new HashMap<>();
		for (Character c : p) {
			if (map.get(c) == null) { // es la primer letra
				map.put(c, 1);
			} else { // sino sumar 1
				map.put(c, (map.get(c) + 1));
			}
		}
		return map;
	}



	// ------------------ EJERCICIO 4 ------------------
	// a.  Utilizando las implementaciones dadas en los ejercicios 2 y 3, utilice el entorno de programación para probar las soluciones propuestas a los problemas presentados en el ejercicio 1.
	// b.  Calcule,  para  cada  inciso  del  ejercicio  1,  el  tiempo  de  ejecución  e  indique  su  orden. Indique  en lenguaje natural las estructuras subyacentes utilizadas.


	// ------------------ EJERCICIO 5 ------------------
	// a.  Agregue  una  operación a la clase Diccionario<K,V> programada en el ejercicio 3 con la siguiente signatura: Iterable<Entry<K,V>> eliminarTodas(K  c,V  v)  throws  InvalidKeyException.  Este  método  debe  eliminar  del diccionario  todas  aquellas  entradas  con  clave  c  y  valor  v.  Retorna  un  iterable  con  todas  las  entradas eliminadas.	
	// b.  Calcule  el  orden  del  tiempo  de  ejecución  de  su  solución.  Indique  en  lenguaje  natural  las  estructuras subyacentes utilizadas.

}
