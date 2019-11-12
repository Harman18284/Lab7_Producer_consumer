import java.util.Scanner;

public class Producer implements Runnable{
    Fibonacci f;

    public Producer(Fibonacci f){
        this.f=f;
        Thread t = new Thread(this,"Producer");
        t.start();
    }
    public void run(){

        Scanner scan = new Scanner (System.in);
        Scanner scan1 = new Scanner (System.in);


        int i=0;
        while(true){
            System.out.println("Enter Number to get fibonacci number (-1 to exit)");
            int o = scan1.nextInt();
            if(o!=-1){
                f.put(o);
            }
            else{
                System.out.println("Exiting");
                System.exit(0);
            }
            System.out.println("Do you want to see the results? (Y/N) ");
            String op = scan.nextLine();
            if(op.equals("Y")){
                f.print(f.getQueue());
                f.getQueue().clear();
            }
            else if(op.equals("N")){

            }

//

        }

    }
}
