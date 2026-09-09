public class TablaPersonajes {
    private Personaje [] t;

    public TablaPersonajes(int max){
        t = new Personaje[max];
    }

    public boolean agregarPersonaje(Personaje p){
        boolean pude = false;
        if(p!=null){
            for(int i = 0; i<t.length && !pude; i++){
                if(t[i]==null){
                    t[i] = p;
                    pude = true;
                }
            }
        }
        return pude;
    }

    public void eliminarMasDebil(){

        int menorFuerza = -1;
        int pos = -1;
        /*También puede ser que hayan buscado el primero ligado, inicializado pos y menosFuerza con
         * esos valores y luego recorrido desde esa pos hacia delante.
         */
        for(int i = 0; i<t.length; i++){ 
            if(t[i]!=null && (t[i].obtenerFuerza()<menorFuerza) || (menorFuerza == -1)){
                menorFuerza = t[i].obtenerFuerza();
                pos = i;
            }
        }
        if(pos>-1){
            t[pos] = null;
        }
    }

    public Personaje obtenerPersonaje(int pos){
        Personaje p = null;

        if(pos>=0 && pos<t.length)
            p = t[pos];
        return p;
    }

}
