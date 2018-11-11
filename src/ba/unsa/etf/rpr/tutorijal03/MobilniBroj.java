package ba.unsa.etf.rpr.tutorijal03;

public class MobilniBroj implements TelefonskiBroj {

    private int mobilnaMreza;
    private String broj;

    MobilniBroj(int mm, String b) {
        mobilnaMreza = mm;
        broj = b;
    }

    @Override
    public final String ispisi() {
        return "0" + mobilnaMreza + "/" + broj;
    }
}
