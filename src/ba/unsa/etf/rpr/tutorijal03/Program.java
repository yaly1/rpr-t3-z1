package ba.unsa.etf.rpr.tutorijal03;

import java.util.Scanner;
import java.util.Set;

public class Program {

    private Program() {
    }

    public static void main(String[] args) {

        Imenik imenik = new Imenik();
        Scanner ulaz = new Scanner(System.in);
        int n = 1;
        while (n != 0) { // program, pretpostavimo da ce korisnik unijeti tacni brojevi
            System.out.println("\nBirajte:\n1-Dodavanje broja\n2-Trazenje broja\n3-Trazenje osobe\n4-Ucitavanje sve brojeve na slovo" +
                    "\n5-Ucitavanje sve imena iz grada\n6-Ucitavanje sve brojeve iz grada\n0-Zavrsi program");
            n = ulaz.nextInt();
            ulaz.nextLine();
            switch (n) {
                case 1: {
                    System.out.print("Unesite ime i prezime: ");
                    String ime = ulaz.nextLine();
                    System.out.print("Birajte: 1-Fiksni broj 2-Mobilni broj 3-Medunarodni broj: ");
                    int n1 = ulaz.nextInt();
                    ulaz.nextLine();
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
                    if (broj.charAt(1) == '3' || broj.charAt(1) == '4') {
                        if (broj.charAt(1) == '3') {
                            System.out.println("Trazena osoba za fiksni broj je: "
                                    + imenik.dajIme(new FiksniBroj(FiksniBroj.Grad.izBrojUGrad(broj.charAt(2) + 1 - 48), broj.substring(4))));
                        } else {
                            System.out.println("Trazena osoba za fiksni broj je: " + imenik.dajIme(new FiksniBroj(FiksniBroj.Grad.izBrojUGrad(11), broj.substring(4))));
                        }
                    } else if (broj.charAt(1) == '6') {
                        System.out.println("Trazena osoba za mobilni broj je: " + imenik.dajIme(new MobilniBroj(60 + broj.charAt(2) - 48, broj.substring(4))));
                    } else if (broj.charAt(0) == '+') {
                        int i = 0;
                        String brojDrzave = "";
                        StringBuilder sb = new StringBuilder();
                        while (broj.charAt(i) != ' ') {
                            sb.append(broj.charAt(i++));
                        }
                        //brojDrzave += broj.charAt(i++);
                        brojDrzave = sb.toString();
                        System.out.println("Trazena osoba za medunarodni broj je: " + imenik.dajIme(new MedunarodniBroj(brojDrzave, broj.substring(i + 1))));
                    }
                    break;
                }
                case 4: {
                    System.out.print("Unesite slovo: ");
                    char slovo = ulaz.nextLine().charAt(0);
                    String lista = imenik.naSlovo(slovo);
                    System.out.print(lista);
                }
                case 5: {
                    System.out.print("Birajte grad: 1-TRAVNIK, 2-ORASJE, 3-ZENICA, 4-SARAJEVO, 5-LIVNO, 6-TUZLA," +
                            " 7-MOSTAR, 8-BIHAC, 9-GORAZDE, 10-SIROKI_BRIJEG, 11-BRCKO: ");
                    int brojGrad = ulaz.nextInt();
                    Set<String> lista = imenik.izGrada(FiksniBroj.Grad.izBrojUGrad(brojGrad));
                    /*Iterator it = lista.iterator();
                    while (it.hasNext()) {
                        String ime = (String) it.next();
                        System.out.println(ime);
                    }*/
                    for (String ime : lista) {
                        System.out.println(ime);
                    }
                    break;
                }
                case 6: {
                    System.out.print("Birajte grad: 1-TRAVNIK, 2-ORASJE, 3-ZENICA, 4-SARAJEVO, 5-LIVNO, 6-TUZLA," +
                            " 7-MOSTAR, 8-BIHAC, 9-GORAZDE, 10-SIROKI_BRIJEG, 11-BRCKO: ");
                    int brojGrad = ulaz.nextInt();
                    Set<TelefonskiBroj> lista = imenik.izGradaBrojevi(FiksniBroj.Grad.izBrojUGrad(brojGrad));
                    for (TelefonskiBroj broj : lista) {
                        System.out.println(broj.ispisi());
                    }
                }
            }
        }
    }
}
