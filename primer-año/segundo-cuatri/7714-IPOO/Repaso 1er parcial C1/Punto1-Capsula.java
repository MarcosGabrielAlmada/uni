public class Capsula {
    //atributos de instancia:
    private int tripulacion;
    private char purezaOxigeno;

    //constructor:
    public Capsula(int trip, char pureza) {
        tripulacion = trip;
        purezaOxigeno = pureza;
    }

    //comandos:
    public void establecerTripulacion(int trip){
        tripulacion = trip;
    }

    public void establecerPurezaOxigeno(char po){
        purezaOxigeno = po;
    }

    public void copy(Capsula c){ 
        tripulacion = c.obtenerTripulacion();
        purezaOxigeno = c.obtenerPurezaOxigeno();
    }

    //consultas:
    public int obtenerTripulacion(){
        return tripulacion;
    }

    public char obtenerPurezaOxigeno(){
        return purezaOxigeno;
    }

    public Capsula clone(){
        return new Capsula(tripulacion, purezaOxigeno);
    }

    public boolean equals(Capsula c){
        return tripulacion == c.obtenerTripulacion() &&
               purezaOxigeno == c.obtenerPurezaOxigeno();
    }
}
 