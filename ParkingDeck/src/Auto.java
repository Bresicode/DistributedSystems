import java.util.Random;

public class Auto implements Runnable{

    private Parkhaus parkhaus;
    private int autonummer;
    private int ankunftsverzoegerung;
    private int parkdauer;

    public Auto(Parkhaus parkhaus, int autonummer) {
        this.parkhaus = parkhaus;
        this.autonummer = autonummer;
        ankunftsverzoegerung = new Random().nextInt(2000);
        parkdauer = new Random().nextInt(5000);
    }

    @Override
    public void run() {
        try {
                    Thread.sleep(ankunftsverzoegerung);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println("Auto: " + autonummer + " ist angekommen.");
            parkhaus.freiePlaetzeReduzieren();
            System.out.println("Auto: " + autonummer + " ist eingefahren.");
            try {
                Thread.sleep(parkdauer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            parkhaus.freiePlaetzeErhoehen();
            System.out.println("Auto: " + autonummer + " ist ausgefahren.");
    }

}

