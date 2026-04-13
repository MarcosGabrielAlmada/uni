public class Jardin {
    private static final int cantFilas = 5;
    private Personaje [][] g;

    public Jardin(int cantCols){
        g = new Personaje[cantFilas][cantCols];
    }

    public void establecerPersonaje(int f, int c, Personaje p){
        g[f][c] = p;
    }

    public Personaje obtenenerPersonaje(int f, int c){
        Personaje p = null;
        if(f>=0 && c>=0 && f<g.length && c<g[0].length){
            p = g[f][c];
        }
        return p;
    }

    public int primerFilaConNconFuerzaF(int n, int f){
        int nroFila = -1;
        int contN = 0;
        for(int i = 0; i<g.length && nroFila<0; i++){
            contN = 0;
            for(int j = 0; j<g[0].length && contN<n; j++){
                if(g[i][j]!=null && g[i][j].obtenerFuerza()==f){
                    contN++;
                }
            }
            if(contN>=n){ //Aca tbm puede decir contN==n (porque nunca llega a ser mayor)
                nroFila = i;
            }
        }
        return nroFila;
    }

    public TablaPersonajes personajesEquiv(Personaje p){
        TablaPersonajes tp = null;
        if(p!=null){
            tp = new TablaPersonajes(g.length*g[0].length);
            for(int i = 0; i<g.length; i++){
                for(int j = 0; j<g[0].length; j++){
                    if(g[i][j]!=null && g[i][j].equals(p)){
                        tp.agregarPersonaje(g[i][j]);
                    }
                }
            }
        }
        return tp;
    }

    public boolean hayFilasConVivosFuertes(int n, int f){
        int contF = 0;
        int contC = 0;

        for(int i = 0; i<g.length && contF<=n; i++){
            contC = 0;
            for (int j = 0; j<g[0].length && contC<1; j++){
                if(g[i][j]!=null && g[i][j].obtenerSalud()>0 && g[i][j].obtenerFuerza()>f){
                    contC++; 
                }
            }
            if(contC>=1){//Aca tbm puede decir contC==1 (porque nunca llega a ser mayor)
                contF++;
            }
        }
        return contF==n;
    }
}
