package Assignment9;

public class Main {
    public static void main(String[] args) {
        MyThread mt = new MyThread();

        mt.start();
        System.out.println("\nThread Name: "+mt.getName());

        mt.setName("Manan Thread");
        System.out.println("New Thread Name: "+mt.getName());

        System.out.println("\nThread Alive Status: "+mt.isAlive());

        System.out.println("Thread is in sleep for 1 second");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread Alive Status: "+mt.isAlive());

        try {
            mt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nThread has quit running.");

    }
}
