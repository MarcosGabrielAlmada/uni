public void removeNode(Position<E> p) throws InvalidPositionException{
	if(size==0)
		throw new InvalidPositionException("No se puede eliminar de un arbol vacio");
	
	TNodo<E> n= checkPosition(p);
	try {
		if(n==root)// el nodo que se pretende eliminar es la raiz
			if(root.getHijos().size()==1)//la raiz tiene un solo hijo
			{
				Position<TNodo<E>> rN=root.getHijos().first();
				rN.element().setPadre(null);
				root.getHijos().remove(rN);
				root= rN.element();
			}
			else
				if (size==1)//el arbol tiene un unico nodo 
					root=null;
				else// se quiere eliminar la raiz pero no es posible por la estructura del arbol
					  throw new InvalidPositionException("Solo se puede eliminar la raiz si es el unico elemento o si tiene un solo hijo");
		else// Se quiere eliminar un nodo interno o un nodo hoja.
		{ 
			TNodo<E> padre=n.padre();
			PositionList<TNodo<E>> hPadre=padre.getHijos(); //hijos del padre (hermanos de n)
			PositionList<TNodo<E>> hN=n.getHijos();//hijos de n
				
			//buscar a n dentro de los hijos del padre
				Position<TNodo<E>>posDeN;
				Position<TNodo<E>> cursor= hPadre.first();
				while(cursor.element()!=n && cursor!=null){
					if (cursor==hPadre.last())
						cursor=null;
					else
						cursor= hPadre.next(cursor);}
				if(cursor!=null)	
					posDeN= cursor;
				else
					throw new InvalidPositionException("La estructura no corresponde a un arbol valido");
				
			//si n tiene hijos, se recorren e insertan ordenados en el lugar del padre
				
			while(!hN.isEmpty())
			{
				Position<TNodo<E>> hijoN=hN.first();
				hPadre.addBefore(posDeN,hijoN.element());
				hijoN.element().setPadre(padre);
				hN.remove(hijoN);
			}
			//eliminamos a n de la lista
			hPadre.remove(posDeN);
		}
		//decrementamos el tamaño de la estructura
		size--;
		} catch (EmptyListException | BoundaryViolationException e) {
			throw new InvalidPositionException("La estructura no corresponde a un arbol valido");
		}
		}
