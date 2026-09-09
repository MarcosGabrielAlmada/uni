class Beta extends Alfa{
    protected int b;

    public Beta(){
      super();
      b = 10;}

    public String p(){
     return "p en Beta "+ b;}

    public String n(int p){
       return "n en Beta "+p*b;}
} 