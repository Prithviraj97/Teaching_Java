package CS281;

public class forloop {
    public static void main(String[] args) {
        // for(int i = 1; i<=10;i++){
        //     System.out.println("The value of i is: "+i);
        // }

        // int v = 1;
        // for(int i=0; i<=6; i++){
        //     System.out.println(i + " " + v);
        //     v = 2*v;
        // }
        //Nested for loop
        //outer loop
        for(int i =1; i<=4; i++)
        {
            System.out.println(i+ "\n");
            //inner loop
            for(int j=1; j<=5;j++){
                System.out.println(j+ " ");
            }
            System.out.println(" ");
        }
    }
}
