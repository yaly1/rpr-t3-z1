package ba.unsa.etf.rpr.tutorijal03;

public class MedunarodniBroj implements TelefonskiBroj {

    private String drzava, broj;

    MedunarodniBroj(String d, String b) {
        drzava = d;
        broj = b;
    }

    @Override
    public final String ispisi() {
        return drzava + " " + broj;
    }
}
