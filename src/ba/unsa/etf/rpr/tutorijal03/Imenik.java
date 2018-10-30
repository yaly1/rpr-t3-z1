package ba.unsa.etf.rpr.tutorijal03;

import static ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad;

import java.util.HashMap;
//import java.util.Map;
import java.util.HashSet;
import java.util.Iterator;
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
        Set set = imenik.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            HashMap.Entry hashMapEntry = (HashMap.Entry)iterator.next();
            if(hashMapEntry.getValue() == broj) return (String) hashMapEntry.getKey();
        }
        return null;
    }

    String naSlovo(char s) {
        String rezultat = "";
        Set set = imenik.entrySet();
        Iterator iterator = set.iterator();
        int i = 1;
        while(iterator.hasNext()) {
            HashMap.Entry hashMapEntry = (HashMap.Entry) iterator.next();
            String pomocniKljuc = (String) hashMapEntry.getKey();
            if(pomocniKljuc.charAt(0) == s) {
                TelefonskiBroj pomocnaVarijabla = (TelefonskiBroj) hashMapEntry.getValue();
                rezultat += i + ". " + hashMapEntry.getKey() + " - " + pomocnaVarijabla.ispisi() + "\n";
                i++;
            }
        }
        return rezultat;
    }

    Set<String> izGrada(Grad g) {
        Set<String> rezultat = new HashSet<>();
        Set set = imenik.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            HashMap.Entry hashMapEntry = (HashMap.Entry) iterator.next();
            if(hashMapEntry.getValue() instanceof FiksniBroj) {
                FiksniBroj pomocnaVarijabla = (FiksniBroj) hashMapEntry.getValue();
                if (pomocnaVarijabla.getGrad() == g) {
                    String pomocniKljuc = (String) hashMapEntry.getKey();
                    rezultat.add(pomocniKljuc);
                }
            }
        }
        return rezultat;
    }

    Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        return null;
    }
}
