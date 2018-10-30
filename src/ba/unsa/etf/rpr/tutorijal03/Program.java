package ba.unsa.etf.rpr.tutorijal03;

import static ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad.SARAJEVO;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Imenik imenik = new Imenik();
        Scanner ulaz = new Scanner(System.in);
        int n;
        for(;;) { // program
            System.out.println("\nBirajte:\n1-Dodavanje broja\n2-Trazenje broja\n3-Trazenje osobe\n4-Ucitavanje sve brojeve na slovo" +
                               "\n5-Ucitavanje sve imena iz grada\n6-Ucitavanje sve brojeve iz grada\n7-Zavrsi program");
            n = ulaz.nextInt();
            ulaz.nextLine();
            switch (n) {
                case 1: {
                    System.out.print("Unesite ime i prezime: ");
                    String ime = ulaz.nextLine();
                    System.out.print("Birajte: 1-Fiksni broj 2-Mobilni broj 3-Medunarodni broj: ");
                    int n1 = ulaz.nextInt();
                    switch (n1) {
                        case 1: {
                            System.out.print("Birajte grad: 1-TRAVNIK, 2-ORASJE, 3-ZENICA, 4-SARAJEVO, 5-LIVNO, 6-TUZLA," +
                                    " 7-MOSTAR, 8-BIHAC, 9-GORAZDE, 10-SIROKI_BRIJEG, 11-BRCKO: ");
                            int brojGrad = ulaz.nextInt();
                            ulaz.nextLine();
                            System.out.print("Unesite broj bez pozivnog broja: ");
                            String broj = ulaz.nextLine();
                            imenik.dodaj(ime, new FiksniBroj(FiksniBroj.Grad.izBrojUGrad(brojGrad), broj));
                            break;
                        }
                        case 2: {
                            System.out.print("Unesite broj za mobilnu mrezu(npr. 61,64,...): ");
                            int brojMobilneMreze = ulaz.nextInt();
                            ulaz.nextLine();
                            System.out.print("Unesite ostatak broja: ");
                            String broj = ulaz.nextLine();
                            imenik.dodaj(ime, new MobilniBroj(brojMobilneMreze, broj));
                            break;
                        }
                        case 3: {
                            System.out.print("Unesite broj za drzavu(npr. +387,+976,...): ");
                            String brojDrzave = ulaz.nextLine();
                            ulaz.nextLine();
                            System.out.print("Unesite ostatak broja: ");
                            String broj = ulaz.nextLine();
                            imenik.dodaj(ime, new MedunarodniBroj(brojDrzave, broj));
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("Unesite ime i prezime trazenog broja: ");
                    String ime = ulaz.nextLine();
                    System.out.println("Trazeni broj je: " + imenik.dajBroj(ime));
                    break;
                }
                case 3: {
                    System.out.print("Unesite broj trazene osobe: ");
                    String broj = ulaz.nextLine();
                    if(broj.charAt(1) == '3' || broj.charAt(1) == '4') {
                        if(broj.charAt(1) == '3')
                             System.out.println("Trazeni broj je: "
                                     + imenik.dajIme(new FiksniBroj(FiksniBroj.Grad.izBrojUGrad(broj.charAt(2) + 1 - 48), broj.substring(4))));
                        else System.out.println("Trazeni broj je: " + imenik.dajIme(new FiksniBroj(FiksniBroj.Grad.izBrojUGrad(11), broj.substring(4))));
                    }
                    else if(broj.charAt(1) == '6')
                        System.out.println("Trazeni broj je: " + imenik.dajIme(new MobilniBroj(60+broj.charAt(2) - 48, broj.substring(4))));
                    else if(broj.charAt(0) == '+') {
                            int i = 0;
                            String brojDrzave = "";
                            while(broj.charAt(i) != ' ') brojDrzave += broj.charAt(i++);
                            System.out.println("Trazeni broj je: " + imenik.dajIme(new MedunarodniBroj(brojDrzave, broj.substring(i+1))));
                        }
                    }
                    break;
                }
            if(n == 0) break;
        }

/*
String broj = "+99 123-123";int i = 0;
String pom = "";
        while(broj.charAt(i) != ' ') pom += broj.charAt(i++);
        //System.out.println(pom);
        MedunarodniBroj br = new MedunarodniBroj(pom, broj.substring(i+1));
        System.out.print(br.ispisi());
*/
/*
String s = "033/111-222";
System.out.print(s.charAt(2) + 1);
*/
/*
        //MedunarodniBroj test = ;
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        imenik.dodaj("Hana Hanic", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(SARAJEVO, "123-456"));
        System.out.print(imenik.dajBroj("Hana Hanic"));
        System.out.print(imenik.dajIme(new MedunarodniBroj("+1", "23 45-67-89")));
*//*
String s = "+087";

System.out.print(s.charAt(1) == 48);
*/
    }
}

/*
StringBuilder sb = new StringBuilder();
sb.append(broj.ispisi());
sb.append(",");
result = sb.toString();
*/