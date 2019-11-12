public class Consumer implements Runnable {
    Fibonacci f;

    public Consumer(Fibonacci f) throws InterruptedException{
        this.f=f;
    }
    public void run(){
        while(true){
            f.get();
//            try{
//                Thread.sleep(1000);
//            }
//            catch(Exception e){}
        }
    }
}
