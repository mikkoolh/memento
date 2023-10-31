import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int MAX = 1000, VIIVE = 0, THREADS = 5;

    public static void main(String[] args) {
        List<Pelaaja> pelaajat = new ArrayList<>();

        for (int i = 0; i < THREADS; i++){
            pelaajat.add(i, new Pelaaja());
            pelaajat.get(i).start();
        }

        try {
            for (Pelaaja pelaaja : pelaajat){
                pelaaja.join();
            }
        } catch (InterruptedException e) {}

        for (Pelaaja pelaaja : pelaajat){
            pelaaja.kerroTulos();
        }
    }
}