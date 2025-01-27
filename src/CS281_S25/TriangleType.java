package CS281_S25;

public class TriangleType {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        int c = 5;
        if(a <=0 || b <=0 || c <=0){
            System.out.println("Invalid Triangle");
            return;
        }
        if (a == b && b == c) {
            System.out.println("Equilateral Triangle");
        } else if (a == b || b == c || a == c) {
            System.out.println("Isosceles Triangle");
        } else {
            System.out.println("Scalene Triangle");
        }
    }
}
