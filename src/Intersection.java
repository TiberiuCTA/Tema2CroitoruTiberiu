

import java.util.concurrent.Semaphore;

public class Intersection {
    Semaphore semNS;
    Semaphore semWE;
    private int permitsNS;
    private int permitsWE;
    private boolean passNS;

    public Intersection() {
        permitsNS = 2;
        permitsWE = 1;
        semNS = new Semaphore(permitsNS);
        semWE = new Semaphore(permitsWE);
        passNS = true;
        try {
            semWE.acquire(permitsWE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getAvailablePermitsNS () {
        return semNS.availablePermits();
    }

    public int getAvailablePermitsWE () {
        return semWE.availablePermits();
    }

    public void changeSem (){
        if (passNS) {
            semWE.release(permitsWE);
            passNS = false;
        } else {
            semNS.release(permitsNS);
            passNS = true;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                "Orange attention........Red");
    }
}
