public class Triangle {
    private String name;
    private float sideA, sideB, sideC;
    private float area;

    public Triangle(String name, float sideA, float sideB, float sideC) {
        this.name = name;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    //Block with getters
    public void getResult(){
        System.out.println("[" + this.getName() + "]: " + this.getArea());
    }
    //Herons formula for finding the area of a triangle
    public float getArea() {
        float a = getSideA();
        float b = getSideB();
        float c = getSideC();
        float p = (a + b + c) / 2;
        return (float) Math.sqrt(p*(p - a) * (p - b) * (p - c) );
    }

    public String getName() {
        return name;
    }

    public float getSideA() {
        return sideA;
    }

    public float getSideB() {
        return sideB;
    }

    public float getSideC() {
        return sideC;
    }
}
