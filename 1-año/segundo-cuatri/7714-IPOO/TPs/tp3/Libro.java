

public class Libro
{
    //atributos de instancia
    
    private String nombre;
    private String autor;
    private String editorial;
    private char categoria;
    
    
    //constructor
    public Libro(String n, String a, String e, char c)
    {
      nombre=n;
      autor=a;
      editorial=e;
      categoria=c;
    }

    //comandos
    
    public void establacerNombre(String p){ nombre=p;}
    
    public void establecerAutor(String p){ autor=p;}
    
    public void establecerEditorial(String p){editorial=p;}
    
    public void establecerCategoria(char p){categoria=p;}
    
    //consultas
    public String obtenerNombre(){return nombre;}
    
    public String obtenerAutor(){return autor;}
    
    public String obtenerEditorial(){return editorial;}
    
    public char obtenerCategoria(){return categoria;}
    
    public String toString(){return "nombre: "+ nombre+ " autor: "+autor+" editorial: "+editorial+" categoria: "+categoria;} 
}