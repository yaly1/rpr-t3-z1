package ba.unsa.etf.rpr.tutorijal03;

import static ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad;

import java.util.*;

public class Imenik {

    private Map imenik = new HashMap<String, TelefonskiBroj>();

    final void dodaj(String ime, TelefonskiBroj broj) { // jer se ove metode ne koriste van paketa nisam stavio modifikator "public"
        imenik.put(ime, broj);
    }

    final String dajBroj(String ime) {
        TelefonskiBroj rez = (TelefonskiBroj) imenik.get(ime);
        return rez.ispisi();
    }

    final String dajIme(TelefonskiBroj broj) {
        Set set = imenik.entrySet();
        Iterator iterator = set.iterator();
        //for(Map.entry i : mapa)
        while (iterator.hasNext()) {
            HashMap.Entry hashMapEntry = (HashMap.Entry) iterator.next();
            TelefonskiBroj pomocniBroj = (TelefonskiBroj) hashMapEntry.getValue();
            if ((broj.ispisi().equals(pomocniBroj.ispisi()))) {
                return (String) hashMapEntry.getKey();
            }
        }
        return null;
    }

    final String naSlovo(char s) {
        String rezultat = "";
        Set set = imenik.entrySet();
        Iterator iterator = set.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            HashMap.Entry hashMapEntry = (HashMap.Entry) iterator.next();
            String pomocniKljuc = (String) hashMapEntry.getKey();
            if (pomocniKljuc.charAt(0) == s) {
                TelefonskiBroj pomocnaVarijabla = (TelefonskiBroj) hashMapEntry.getValue();
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append(". ");
                sb.append(hashMapEntry.getKey());
                sb.append(" - ");
                sb.append(pomocnaVarijabla.ispisi());
                sb.append("\n");
                rezultat = sb.toString();
                i++;
            }
        }
        return rezultat;
    }

    final Set<String> izGrada(Grad g) {
        Set<String> rezultat = new HashSet<>();
        Set set = imenik.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            HashMap.Entry hashMapEntry = (HashMap.Entry) iterator.next();
            if (hashMapEntry.getValue() instanceof FiksniBroj) {
                FiksniBroj pomocnaVarijabla = (FiksniBroj) hashMapEntry.getValue();
                if (pomocnaVarijabla.getGrad() == g) {
                    String pomocniKljuc = (String) hashMapEntry.getKey();
                    rezultat.add(pomocniKljuc);
                }
            }
        }
        return rezultat;
    }

    final Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        Set<TelefonskiBroj> rezultat = new TreeSet<>();
        Set set = imenik.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            HashMap.Entry hashMapEntry = (HashMap.Entry) iterator.next();
            if (hashMapEntry.getValue() instanceof FiksniBroj) {
                FiksniBroj pomocnaVarijabla = (FiksniBroj) hashMapEntry.getValue();
                if (pomocnaVarijabla.getGrad() == g) {
                    rezultat.add(pomocnaVarijabla);
                }
            }
        }
        return rezultat;
    }
}
