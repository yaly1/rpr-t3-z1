package ba.unsa.etf.rpr.tutorijal03;

import java.util.Objects;

public class FiksniBroj implements TelefonskiBroj, Comparable {

    public enum Grad {TRAVNIK, ORASJE, ZENICA, SARAJEVO, LIVNO, TUZLA, MOSTAR, BIHAC, GORAZDE, SIROKI_BRIJEG, BRCKO}

    private Grad grad;
    private String broj;

    FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;
    }

    Grad getGrad() {
        return grad;
    }

    @Override
    public int compareTo(Object o) {
        FiksniBroj drugiBroj = (FiksniBroj) o;
        return  (Integer.compare(this.vrijednostBroja(), drugiBroj.vrijednostBroja()));
    }

    private int vrijednostBroja() {
        int suma = 0;
        String pomocniString = this.ispisi();
        for(int i = 0; i < pomocniString.length(); i++) {
            if(Character.isDigit(pomocniString.charAt(i))) {
                suma += suma * 10 + pomocniString.charAt(i);
            }
        }
        return suma;
    }

    @Override
    public String ispisi() {
        switch (grad) {
            case TRAVNIK       : return "030/" + broj;
            case ORASJE        : return "031/" + broj;
            case ZENICA        : return "032/" + broj;
            case SARAJEVO      : return "033/" + broj;
            case LIVNO         : return "034/" + broj;
            case TUZLA         : return "035/" + broj;
            case MOSTAR        : return "036/" + broj;
            case BIHAC         : return "037/" + broj;
            case GORAZDE       : return "038/" + broj;
            case SIROKI_BRIJEG : return "039/" + broj;
            case BRCKO         : return "049/" + broj;
        }
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grad, broj);
    }
}


