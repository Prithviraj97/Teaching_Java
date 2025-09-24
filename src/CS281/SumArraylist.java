package CS281;
import java.util.ArrayList;
public class SumArraylist {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> numbers = new java.util.ArrayList<>();
        for(int i=0; i<3; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=1; j<=3; j++){
                temp.add((i+1)*(j+1));
                numbers.add((i+1)*(j+1));
            }            list.add(temp);
        }
        // System.out.println(list);  
        //define another 2d arraylist 
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        for(int i=0; i<3; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=1; j<=3; j++){
                temp.add((i+1)*(j+2));
            }            list2.add(temp);
        }

        //calculate the sum of two 2d arraylist
        ArrayList<ArrayList<Integer>> sumList = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<list.get(i).size(); j++){
                temp.add(list.get(i).get(j) + list2.get(i).get(j));
            }
            sumList.add(temp);
        }
        System.out.println("Sum of two 2D ArrayLists: " + sumList);
    }
}
