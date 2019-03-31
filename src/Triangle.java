public class Triangle {
    private Float a,b,c;
    private String type = "";

    public Triangle(Float a, Float b, Float c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    public void determine(){
        if (a.equals(b) && a.equals(c)) this.type = "equilateral" ;
        else if (a.equals(b) || a.equals(c) || b.equals(c)) this.type="isosceles";
        else this.type = "scalar";
    }

    public String getType() {
        determine();
        return type;
    }
}
