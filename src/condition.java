public class condition {
    public static void main(String[] args) {
        int sales = 50000;
        final int bonus;

        if (sales > 10000){
            bonus = 500;
            System.out.println("Bonus:"+bonus);

        }
        else if(sales > 5000){
            bonus = 250;
        }
    }
}
