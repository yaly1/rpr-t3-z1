package ba.unsa.etf.rpr.tutorijal03;

import java.util.Objects;

public class MobilniBroj implements TelefonskiBroj {

    private int mobilnaMreza;
    private String broj;

    MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return "0" + mobilnaMreza + "/" + broj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobilnaMreza, broj);
    }
}
