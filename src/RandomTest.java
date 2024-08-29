import java.util.Random;
public class RandomTest{
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextFloat());
        System.out.println(random.nextInt(50));
        System.out.println(random.nextInt(50)+1);

    }
}