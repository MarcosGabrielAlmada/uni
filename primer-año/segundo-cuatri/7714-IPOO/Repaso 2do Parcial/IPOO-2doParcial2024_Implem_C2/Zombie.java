public class Zombie extends Personaje{
    protected int velocidad;
    protected boolean casco;

    public Zombie(int s, int f, int veloc, boolean c){
        super(s,f);
        velocidad = veloc;
        casco = c;
    }

    public int obtenerVelocidad(){
        return velocidad;
    }

    public boolean tieneCasco(){
        return casco;
    }

     
    public boolean equals(Personaje p){
        boolean eq = false;
        if(p != null){
            if(this == p){ //Esto puede estar o no
                eq = true;
            }
            else{
                if(getClass() == p.getClass()){
                    Zombie z = (Zombie) p;
                    eq = super.equals(p) && velocidad == z.obtenerVelocidad() && casco == z.tieneCasco();
                }
            } 
        }
        return eq;
    }

    public void recibirAtaque(int d){
        if(!casco)
            super.recibirAtaque(d);
        else
            salud -= d/2;

        if(salud<0){
            salud = 0;
        }
    }

    public void atacar(Personaje p){
        if(casco && velocidad>2)
            p.recibirAtaque(fuerza*2);
        else
            super.atacar(p);
    }
}
