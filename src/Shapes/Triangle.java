package Shapes;

import java.util.ArrayList;

public class Triangle extends Polygon{
    private String type = "";

    public Triangle(ArrayList<Float> input) {
        super(input);
        determine();
    }

    private void determine(){
        Float a = getEdges().get(0);
        Float b = getEdges().get(1);
        Float c = getEdges().get(2);
        if (a.equals(b) && a.equals(c)) this.type = "equilateral" ;
        else if (a.equals(b) || a.equals(c) || b.equals(c)) this.type="isosceles";
        else this.type = "scalar";
    }

    public String getType() {
        if (this.type.equals("")) determine();
        return type;
    }
}
