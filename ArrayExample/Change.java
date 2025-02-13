

public class Change {

    public static void main(String[] args) {
        int[] arr = new int[1];
        arr[0] = 10;
        System.out.println("Before: " + arr[0]);
        changeValue(arr);
                System.out.println("After: " + arr[0]);
            }
        
            private static void changeValue(int[] arr) {

                arr[0] = arr[0]*10;
            }
    
}
