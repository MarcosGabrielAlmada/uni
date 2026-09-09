public abstract class Personaje {
    protected int salud;
    protected int fuerza;

    public Personaje(int s, int f){
        salud = s;
        fuerza = f;
    }

    public int obtenerSalud(){
        return salud;
    }

    public int obtenerFuerza(){
        return fuerza;
    }

    public boolean equals(Personaje p){
        boolean eq = false;
        if(this == p){
            eq = true; //Esto pueden hacerlo o no.
        }
        else{
            if(getClass() == p.getClass()){
                eq = salud == p.obtenerSalud() && fuerza == p.obtenerFuerza();
            }
        }
    
        return eq;
    }

    public void recibirAtaque(int d){
        if (d>=salud)
            salud = 0;
        else
            salud-=d;
    }

    public void atacar(Personaje p){
        if(p.obtenerFuerza()<fuerza)
            p.recibirAtaque(fuerza);
    }
}
