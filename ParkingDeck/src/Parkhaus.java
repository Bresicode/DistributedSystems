public class Parkhaus{

    private int freiePlaetze;

    public Parkhaus(int parkPlaezte, int freiePlaetze) {
        this.freiePlaetze = freiePlaetze;
    }

    public int getFreiePlaetze() {
        return freiePlaetze;
    }

    public synchronized void freiePlaetzeReduzieren(){
        while(freiePlaetze == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        freiePlaetze--;
    }
    public synchronized void freiePlaetzeErhoehen(){
            freiePlaetze++;
            notify();
    }
    public static void main(String[] args) {
        Parkhaus parkhaus = new Parkhaus(10, 10);

        for (int i = 0; i < 20; i++){
            Auto auto = new Auto(parkhaus, i);
            Thread thread = new Thread(auto);
            thread.start();
        }
    }
}
