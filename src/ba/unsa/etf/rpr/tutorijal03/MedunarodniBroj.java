package ba.unsa.etf.rpr.tutorijal03;

import java.util.Objects;

public class MedunarodniBroj implements TelefonskiBroj {

    private String drzava, broj;

    MedunarodniBroj(String drzava, String broj) {
        this.drzava = drzava;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return drzava + " " + broj;
    }

    public String getDrzava() {
        return drzava;
    }

    @Override
    public int hashCode() {
        return Objects.hash(drzava, broj);
    }
}
