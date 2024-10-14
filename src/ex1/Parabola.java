package ex1;

public class Parabola {
    private final int a;
    private final int b;
    private final int c;
    public Parabola(int a, int b, int c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }


    public String Varf() {
        return "(" + (-b/(2*a)) + "," + (-b*b/(4*a)+c) + ")";
    }
}
