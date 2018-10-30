package ba.unsa.etf.rpr.tutorijal03;

import static ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad.SARAJEVO;

public class Program {

    public static void main(String[] args) {
	    //System.out.println("Cilj vježbe je atomic commits.");
        Imenik imenik = new Imenik();
        MedunarodniBroj test = new MedunarodniBroj("+1", "23 45-67-89");
        imenik.dodaj("John Smith", test);
        imenik.dodaj("Hana Hanic", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(SARAJEVO, "123-456"));
        System.out.print(imenik.dajIme(test));
    }
}

/*
StringBuilder sb = new StringBuilder();
sb.append(broj.ispisi());
sb.append(",");
result = sb.toString();
*/