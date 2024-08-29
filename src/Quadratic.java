public class Quadratic {
    public static void main(String[] args) {
        double b = Double.parseDouble("42");
        double c = Double.parseDouble("28");

        double discriminant = b*b - 4.0*c;
        double d = Math.sqrt(discriminant);
        double root1 = (-b+d)/2.0;
        double root2 = (-b-d)/2.0;

        System.out.println(root1);
        System.out.println(root2);
    }
}