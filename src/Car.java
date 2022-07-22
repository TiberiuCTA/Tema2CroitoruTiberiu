public class Car extends Thread {

    private String licensePlate;

    private String direction;
    private Intersection intersection;

    public Car ( String licensePlate,String direction) {
        this.licensePlate = licensePlate;
        this.direction = direction;
    }

    public void setIntersection(Intersection intersection) {
        this.intersection = intersection;
        this.direction = direction;
    }



    public void run() {
        if (direction.equals("NS")){
            try {
                System.out.println("Car waiting to pass through direction Nord-South.");
                intersection.semNS.acquire();
                sleep(2000);
                System.out.println("Car passes through direction Nord-South.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (direction.equals("WE")) {
            try {
                System.out.println("Car waiting to pass through direction West-East.");
                intersection.semWE.acquire();
                sleep(2000);
                System.out.println("Car passes through direction West-East.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (intersection.getAvailablePermitsNS() == 0 &&
                intersection.getAvailablePermitsWE() == 0) {
            intersection.changeSem();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
