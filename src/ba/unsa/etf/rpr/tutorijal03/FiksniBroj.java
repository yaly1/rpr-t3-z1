package ba.unsa.etf.rpr.tutorijal03;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {

    public enum Grad {TRAVNIK, ORASJE, ZENICA, SARAJEVO, LIVNO, TUZLA, MOSTAR, BIHAC, GORAZDE, SIROKI_BRIJEG, BRCKO}

    private Grad grad;
    private String broj;

    FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;
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


