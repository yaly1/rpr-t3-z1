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
            final int jedan = 1, dva = 2, tri = 3, cetiri = 4, pet = 5, sest = 6, sedam = 7, osam = 8, devet = 9, deset = 10, jedanaest = 11;
            switch (redniBroj) {
                case jedan:
                    return TRAVNIK;
                case dva:
                    return ORASJE;
                case tri:
                    return ZENICA;
                case cetiri:
                    return SARAJEVO;
                case pet:
                    return LIVNO;
                case sest:
                    return TUZLA;
                case sedam:
                    return MOSTAR;
                case osam:
                    return BIHAC;
                case devet:
                    return GORAZDE;
                case deset:
                    return SIROKI_BRIJEG;
                case jedanaest:
                    return BRCKO;
            }
            return null;
        }
    }

    final Grad getGrad() {
        return grad;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiksniBroj that = (FiksniBroj) o;
        return grad == that.grad &&
                Objects.equals(broj, that.broj);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(grad, broj);
    }

    @Override
    public final int compareTo(Object o) {
        FiksniBroj drugiBroj = (FiksniBroj) o;
        return this.ispisi().compareTo(drugiBroj.ispisi());
    }

    @Override
    public final String ispisi() {
        return this.grad.toString() + broj;
        /*switch (grad) {
            case TRAVNIK       : return "030/" + broj;
            case ORASJE        : return "031/" + broj;
            ...
        }*/
    }
}
