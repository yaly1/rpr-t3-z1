package ba.unsa.etf.rpr.tutorijal03;

import static ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad;

import java.util.HashMap;
//import java.util.Map;
import java.util.Set;

public class Imenik {

    private HashMap imenik = new HashMap<String, TelefonskiBroj>();

    void dodaj(String ime, TelefonskiBroj broj) { // jer se ove metode ne koriste van paketa nisam stavio modifikator "public"
        imenik.put(ime, broj);
    }

    String dajBroj(String ime) {
        TelefonskiBroj rez = (TelefonskiBroj) imenik.get(ime);
        return rez.ispisi();
    }

    String dajIme(TelefonskiBroj broj) {
        int rez = (int) imenik.get(broj);
        return null;
    }

    String naSlovo(char s) {
        return null;
    }

    Set<String> izGrada(Grad g) {
        return null;
    }

    Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        return null;
    }
}
