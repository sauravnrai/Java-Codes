import java.util.Scanner;


/*
 Input
1 2 3
4 5 6
7 8 9 
 */

public class Array2d {

    public static void main(String[] args) {
        
        int[][] arr = new int[3][3];

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<3; i++){
            for(int j=0; j < 3; j++){

                arr[i][j] = sc.nextInt(); // Takes input 

            }
        }

        sc.close();

        // For each array to print the array
        for(int[] num: arr){
            for(int temp: num){
                System.out.print(temp + " ");
            }
            System.out.println();
        }
    }
    
}
