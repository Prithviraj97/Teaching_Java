package CS281;
public class WhileDemo {
    public static void main(String[] args) {
        // int i=0;
        // int v=1;
        // while(i<=6){
        //     System.out.println(i + " " + v);
        //     i = i+1;
        //     v = 2*v;
        // }

        //Nested While loop
        int i =1;
        while(i<10){
            int j=1;
            while(j<10){
                System.out.println(j);
                j +=1;
            }
            System.out.println(" ");
            i +=1;
        }
        System.out.println("Complete!");
    }
}
