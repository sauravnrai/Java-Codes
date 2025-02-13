import java.util.ArrayList;

public class Arraylist2d {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        // initialize 3 empty 1d arraylist i.e rows
        for(int i=0; i<3; i++){
            arr.add(new ArrayList<>());
        }

        System.out.println(arr.size());

        // populate the arraylists 3 x 3
        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<arr.size(); j++){
                arr.get(i).add(i+j); // adds element
            }
        }

        System.out.println(arr);
        
    }
    
}
