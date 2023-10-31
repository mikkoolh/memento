import java.util.Random;

public class Pelaaja extends Thread{
    private Arvuuttaja arvuuttaja = new Arvuuttaja();
    private Random random = new Random();
    private Arvuuttaja.Memento memento;
    private String nimi;
    private int laskuri, arvaus;

    public void run() {
        nimi = Thread.currentThread().getName();
        memento = arvuuttaja.liityPeliin();

        if (julistaLiittyminen()){
            while (!arvaa()){
                hidasta();
                System.out.println(nimi + " arvaus(" + arvaus + ") nro." + ++laskuri + " väärin.");
            }
            System.out.println(nimi + " arvaus(" + arvaus + ") nro." + ++laskuri + " OIKEIN!");
        }
    }
    private boolean julistaLiittyminen(){
        if (memento != null){
            System.out.println(Thread.currentThread().getName() + " liittyi peliin");
            return true;
        }
        return false;
    }
    private boolean arvaa(){
        arvaus = random.nextInt(Main.ARVAUS_MAX + 1);
        return arvuuttaja.arvaa(memento, arvaus);
    }
    private void hidasta(){
        try {
            Thread.sleep(Main.VIIVE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void kerroTulos(){
        arvuuttaja.kerroLopputulos(nimi, memento, arvaus, laskuri);
    }
}
