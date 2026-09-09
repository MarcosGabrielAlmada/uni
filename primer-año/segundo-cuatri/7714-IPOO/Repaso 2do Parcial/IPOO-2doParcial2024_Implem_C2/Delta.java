class Delta extends Beta{
    protected int c;

    public Delta (int n){
      super();
      c = n;}

    public String m(){
     String s = super.m();
     return "m en Delta "+c+" "+s;}

     public String n(){
        return "n en Delta "+c*b;}    
}