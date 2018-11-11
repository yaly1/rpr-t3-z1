package ba.unsa.etf.rpr.tutorijal03;

public class MobilniBroj implements TelefonskiBroj {

    private int mobilnaMreza;
    private String broj;

    MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    @Override
    final public String ispisi() {
        return "0" + mobilnaMreza + "/" + broj;
    }
}
