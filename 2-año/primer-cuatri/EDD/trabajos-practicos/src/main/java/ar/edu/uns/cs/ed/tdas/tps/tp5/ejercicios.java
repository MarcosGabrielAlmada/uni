package ar.edu.uns.cs.ed.tdas.tps.tp5;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.Entry;

public class ejercicios {
	// Escriba  un  método  que  reciba  dos  mapeos  M1  y  M2  de  enteros  en  enteros  (números  de  libreta  -  nota materia)  que  devuelva  una  PositionList<Pair<Integer,Integer>>  L  con  aquellos elementos E1 de M1 y E2 de M2  que  coincidan  en  la  clave,  pero  tengan  un  valor  diferente.  Por  ejemplo,  si  E1=  (LU:  29303,  Nota:  8) pertenece a M1 y E2= (LU:29303, Nota: 7) pertenece a M2, entonces E1 y E2 deben estar en L.  Puede usar la clase java.util.Pair de Java.
	// public PositionList<Pair<Integer,Integer>> ejercicio1b(Map<Integer, Integer> M1, Map<Integer, Integer> M2) {
	// 	return null;
	// }


	// Escriba un método que, dados dos mapeos M1 y M2, determine si todas las claves de M1 están contenidas en M2.
	public boolean ejercicio1b(Map<Integer, Integer> M1, Map<Integer, Integer> M2) {
		for (Integer clave : M1.keys()) {           // O(n) - itera n veces
			if (M2.get(clave) == null) {            // O(1) - búsqueda directa en hash
				return false;
			}
		}
		return true;

		// T(n,m) = c1 + T_M2.keys(n) + n(c2 + T_M2.keys(m) + m(c3 + c4 + c5) + c6 + c7) <= c8 + T_M2.keys(n) + n(c9 + T_M2.keys(m) + m(c10)) 
	}



	// Escriba  un  método cuya signatura sea: public Dictionary<K,V> acomodar (Dictionary<K,V>   d) que reciba un diccionario  d,  y  que  retorne  un  nuevo  diccionario  igual  a  d  pero  sin  claves  repetidas.  De  esta  manera,  el diccionario resultante de este procedimiento no tendrá entradas con claves iguales. Utilice un mapeo auxiliar para resolver este ejercicio. 
	// Por  ejemplo:  Si  d  = {(1,a), (2,b), (3,a), (2,c), (1,d), (4,b)}, entonces el diccionario resultante es dRes = {(1,d), (2,c), (3,a) (4,b)}.


	// Escriba  un  método  tal  que  reciba  una  PositionList<Character>  y  retorne  un mapeo cuyas claves sean cada uno de los caracteres que aparecen en la lista y el valor la cantidad de veces que aparecen los caracteres en la lista. Por ejemplo: Si l = <a, b, a, c, d, b>, entonces el mapeo resultante es mRes = {(a,2), (b,2), (c,1) (d,1)}. 
}
