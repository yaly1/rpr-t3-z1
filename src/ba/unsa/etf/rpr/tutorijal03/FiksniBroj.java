package ba.unsa.etf.rpr.tutorijal03;

import java.util.Objects;

public class FiksniBroj implements TelefonskiBroj, Comparable {

    private Grad grad;
    private String broj;

    FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;
    }

    enum Grad {
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

    final Grad getGrad() {
        return grad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiksniBroj that = (FiksniBroj) o;
        return grad == that.grad &&
                Objects.equals(broj, that.broj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grad, broj);
    }

    @Override
    public int compareTo(Object o) {
        FiksniBroj drugiBroj = (FiksniBroj) o;
        return this.ispisi().compareTo(drugiBroj.ispisi());
    }

    @Override
    public String ispisi() {
        return this.grad.toString() + broj;
        /*switch (grad) {
            case TRAVNIK       : return "030/" + broj;
            case ORASJE        : return "031/" + broj;
            ...
        }*/
    }
}
