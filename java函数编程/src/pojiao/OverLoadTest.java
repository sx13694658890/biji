package src.pojiao;

public class OverLoadTest implements DrawTest {
    public static int add(int a,int b){
        return a+b;
    }
    public static double add(double a, double b){
        return a+b;
    }

    @Override
    public void draw() {
        // TODO
    }
}
