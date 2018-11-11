package ba.unsa.etf.rpr.tutorijal03;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad.*;
import static org.junit.jupiter.api.Assertions.*;



class ImenikTest {
    private String osoba1 = "John Smith", osoba2 = "Meho Mehic", broj1 = "23 45-67-89", broj2 = "123-156", broj3 = "123-456";
    private static final int BROJZAHALOO = 64;

    @Test
    void dodaj() {
        Imenik imenik = new Imenik();
        imenik.dodaj(osoba1, new MedunarodniBroj("+1", broj1));
        imenik.dodaj("Hana Hanic", new FiksniBroj(SARAJEVO, broj2));
        imenik.dodaj(osoba2, new FiksniBroj(SARAJEVO, broj3));
        assertEquals("033/123-456", imenik.dajBroj(osoba2));
    }

    @Test
    void dodaj2() {
        Imenik imenik = new Imenik();
        imenik.dodaj(osoba1, new MedunarodniBroj("+1", broj1));
        imenik.dodaj("Hana Hanic", new FiksniBroj(SARAJEVO, broj2));
        imenik.dodaj(osoba2, new FiksniBroj(SARAJEVO, broj3));
        assertEquals(osoba2, imenik.dajIme(new FiksniBroj(SARAJEVO, broj3)));
    }

    @Test
    void naSlovo() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, broj2));
        imenik.dodaj("Pero Peric", new FiksniBroj(SARAJEVO, "123-656"));
        final int brojZaBHTelekom = 61;
        imenik.dodaj("Ivo Ivic", new MobilniBroj(brojZaBHTelekom, "321-645"));
        imenik.dodaj("Jozo Jozic", new MobilniBroj(BROJZAHALOO, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", broj1));
        assertEquals("1. Ivo Ivic - 061/321-645", imenik.naSlovo('I').trim());
    }

    @Test
    void izGrada() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(SARAJEVO, broj3));
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, broj2));
        imenik.dodaj(osoba2, new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(BROJZAHALOO, "987-654"));
        imenik.dodaj(osoba1, new MedunarodniBroj("+1", broj1));
        Set<String> set = imenik.izGrada(SARAJEVO);
        String result;
        StringBuilder sb = new StringBuilder();
        for (String ime : set) {
            sb.append(ime);
            sb.append(",");
        }
        result = sb.toString();
        assertEquals("Ivo Ivic,Meho Mehic,Sara Sarac,", result);
    }

    @Test
    void izGradaBrojevi() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(SARAJEVO, broj3));
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, broj2));
        imenik.dodaj(osoba2, new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(BROJZAHALOO, "987-654"));
        imenik.dodaj(osoba1, new MedunarodniBroj("+1", broj1));
        Set<TelefonskiBroj> set = imenik.izGradaBrojevi(SARAJEVO);
        String result;
        StringBuilder sb = new StringBuilder();
        for (TelefonskiBroj broj : set) {
            sb.append(broj.ispisi());
            sb.append(",");
        }
        result = sb.toString();
        assertEquals("033/123-156,033/123-456,033/123-656,", result);
    }
}