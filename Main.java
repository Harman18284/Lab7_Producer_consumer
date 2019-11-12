import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Enter the number of Consumer threads to be generated..");
        Scanner scan = new Scanner(System.in);
        int no_of_threads = scan.nextInt();
        ArrayList<Thread> consumer_threads = new ArrayList<Thread>();


        Fibonacci q = new Fibonacci();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);

        for(int i=0;i<no_of_threads;i++){
            consumer_threads.add(new Thread(c,"Consumer" + i));
        }
        for(int j=0;j<consumer_threads.size();j++){
            consumer_threads.get(j).start();
        }
        for(int k=0;k<consumer_threads.size();k++){
            consumer_threads.get(k).join();
        }

    }
}
