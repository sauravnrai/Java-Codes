import java.util.Scanner;

class Fibonacci
{

public static void main(String args[]){
    int num;
    Scanner sc = new Scanner(System.in);
    num = sc.nextInt();
  System.out.println(fibo(num));
}

public static int fibo(int n){

    if(n < 2)
    {
        return n;
    }
    else
    {
        return fibo(n-2) + fibo(n-1);
    }

}


}