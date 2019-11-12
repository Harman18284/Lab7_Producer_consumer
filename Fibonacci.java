import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci implements Observer{

    private volatile boolean flag=false;
    private int result, n;

    public HashMap<Integer, Integer> getQueue() {
        return queue;
    }

    public void setQueue(HashMap<Integer, Integer> queue) {
        this.queue = queue;
    }

    private HashMap<Integer, Integer> queue = new HashMap<Integer, Integer>();

    @Override
    public int fib(int n) {
        if(n<2) return n;
        else return fib(n-1) + fib(n-2);
    }

    public synchronized void put(int n){
        while(flag){
            try {
                wait();
            }
            catch(InterruptedException e){}
        }
//        System.out.println("Put = " + n);
        this.n=n;
        flag=true;
        notify();
    }

    public synchronized void get(){
        while(!flag){
            try {
                wait();
            }
            catch(Exception e){}
        }
        result=fib(n);
        if(queue.containsKey(n)){
            System.out.println("fibonacci for entered number already exists.");
        }
        else{
            queue.put(n,result);
        }

//        System.out.println("Value stored");
//        System.out.println("Get = " + result);
        flag=false;
        notify();
    }

    @Override
    public void print(Map<Integer, Integer> map)
    {
        if (map.isEmpty()) {
            System.out.println("map is empty");
        }
        else {
            System.out.println(map);
        }
    }

}
