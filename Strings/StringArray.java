import java.util.Arrays;
import java.util.Scanner;

public class StringArray{
    public static void main(String[] args) {
        String[] arr = new String[5];

        Scanner sc = new Scanner(System.in);

        arr = sc.nextLine().split(" ");
        sc.close();

        System.out.println(Arrays.toString(arr));
    }
}