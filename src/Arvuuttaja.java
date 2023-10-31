import java.util.Random;

public class Arvuuttaja {
    private Random random = new Random();
    public Memento liityPeliin() {
        return new Memento(random.nextInt(Main.ARVAUS_MAX + 1));
    }
    public boolean arvaa(Memento memento, int arvaus){
        return memento.getArvaus() == arvaus;
    }

    public void kerroLopputulos(String nimi, Memento memento, int arvaus, int kerrat){
        System.out.println(nimi + " arvasi " + kerrat + ". kerralla numeron " + arvaus+ ", joka vastasi Mementon numeroa " + memento.getArvaus());
    }
    public static class Memento {
        private final int arvaus;
        public Memento(int arvaus) {
            this.arvaus = arvaus;
        }
        private int getArvaus() {
            return arvaus;
        }
    }
}
