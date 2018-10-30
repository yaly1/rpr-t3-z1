package ba.unsa.etf.rpr.tutorijal03;

import java.util.Objects;

public class FiksniBroj implements TelefonskiBroj, Comparable {

    public enum Grad {
        TRAVNIK("030/"), ORASJE("031/"), ZENICA("032/"), SARAJEVO("033/"), LIVNO("034/"), TUZLA("035/"),
        MOSTAR("036/"), BIHAC("037/"), GORAZDE("038/"), SIROKI_BRIJEG("039/"), BRCKO("049/");

        private final String pozivni;

        Grad(String pozivni) {
            this.pozivni = pozivni;
        }

        @Override
        public String toString() {
            return pozivni;
        }

        public static Grad izBrojUGrad(int redniBroj) {
            switch (redniBroj) {
                case 1: return TRAVNIK;
                case 2: return ORASJE;
                case 3: return ZENICA;
                case 4: return SARAJEVO;
                case 5: return LIVNO;
                case 6: return TUZLA;
                case 7: return MOSTAR;
                case 8: return BIHAC;
                case 9: return GORAZDE;
                case 10: return SIROKI_BRIJEG;
                case 11: return BRCKO;
            }
            return null;
        }
    }

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
        return this.grad.toString() + broj;
        /*
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
        }*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(grad, broj);
    }
}


