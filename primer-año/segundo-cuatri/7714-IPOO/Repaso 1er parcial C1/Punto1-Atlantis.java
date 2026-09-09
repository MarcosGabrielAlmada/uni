public class Atlantis {
    //atributos de clase:
    private static final int capacidad_Tanque = 50000;

    //atributos de instancia:
    private int combustible;
    private boolean enOrbita;
    private Capsula cap;

    //constructor:
    public Atlantis(Capsula cap){
        this.cap = cap;
        combustible = capacidad_Tanque;
        enOrbita = false;
    }

    //comandos:
    public void colocarSacarDeOrbita(){
        enOrbita = !enOrbita;
    }

    public void copy(Atlantis a){
        combustible = a.obtenerCombustible();
        enOrbita = a.obtenerEnOrbita();
        cap.copy(a.obtenerCapsula());
    }

    public void establecerCombustible(int comb){
        combustible = comb;
    } 

    //consultas:
    public int obtenerCombustible(){
        return combustible;
    }

    public boolean obtenerEnOrbita(){
        return enOrbita;
    }

    public Capsula obtenerCapsula(){
        return cap;
    }

    public boolean puedeDespegar(){
        return !enOrbita && cap.obtenerPurezaOxigeno() == 'e';
    }

    public Atlantis clone(){
        Atlantis clonacion = new Atlantis(cap.clone()); 
        clonacion.establecerCombustible(combustible);
        if(enOrbita){
            clonacion.colocarSacarDeOrbita();
        }
        return clonacion;
    }

    public boolean equals(Atlantis a){
        return combustible == a.obtenerCombustible() &&
               enOrbita == a.obtenerEnOrbita() &&
               cap == a.obtenerCapsula();
    }

    public Atlantis coheteConMasTripulacion(Atlantis a){
        Atlantis resultado = null;
        if(cap.obtenerTripulacion() > a.obtenerCapsula().obtenerTripulacion()){
            resultado = this;
        }
        else if(cap.obtenerTripulacion() < a.obtenerCapsula().obtenerTripulacion()){
            resultado = a;
        }
        return resultado;
    }
}
