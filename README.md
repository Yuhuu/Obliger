Obliger
=======
BYSYKKEL

Oppgaven er en omarbeidet utgave av en tidligere gitt eksamensoppgave.
Alle klassene i oppgaven skal tilsammen utgjøre et kjørbart program.

Du har fått i oppdrag å være med på å lage et nytt datasystem for Oslo Bysykkel. Som du kanskje har sett har Oslo Bysykkel sykkelstativer på forskjellige steder rundt om i Oslo der personer med gyldig sykkelkort kan leie én sykkel ad gangen i inntil 3 timer. Dette systemet består av flere moduler og din oppgave blir å programmere den modulen som registrerer leie og innlevering av en sykkel. Modulen består av de syv klassene Sykkel, Stativ, Utleiested, Person, PersonRegister, SykkelByen, og BySykkelSystem.

Det er et felles krav for alle klassene som inngår i oppgaven at alle datafelter skal ha privat aksess, med unntak av konstanter som bør være public og static. Der det ikke er spesifikt angitt hva datatypen skal være, må du selv velge en passende datatype.

Den gang oppgaven ble gitt ble tidspunktene representert som objekter av typen Date, som ligger i pakken java.util. Instruksjonen

    Date nå = new Date();
oppretter et Date-objekt som representerer tidspunktet for når instruksjonen blir utført. Dersom vi har to Date-objekter tid1 og tid2, så vil instruksjonen


    long varighet = tid2.getTime() - tid1.getTime();

gi tidsavstanden i antall millisekund mellom de to tidspunktene. (Det er 3 600 000 millisekund i en time.)

Klassen DateFormat, som ligger i pakken java.text, kan brukes til å formatere Date-objekter for utskrift. Dersom for eksempel Date-objektet tidspunkt ble opprettet den 21. november 2011 klokka 09.18, vil instruksjonene

    DateFormat df = DateFormat.getInstance();
    String utskrift = df.format( tidspunkt );
gi tekststrengen "21.11.11 09:18".

Dere står forøvrig fritt til selv å bestemme hvordan dere velger å representere tidspunktene.



OPPGAVE 1

Klassen Sykkel skal representere en sykkel i programmet. Klassen skal ha en konstant MAXTID som representerer maksimalt antall timer sykkelen kan leies og som skal settes til 3 timer. Hver sykkel skal ha et unikt heltallig id-nummer. Dette skal genereres automatisk hver gang et sykkel-objekt opprettes. (Hvordan du kan gjøre det kan du lese om i kapittel 8, Eksempel: Automatisk generering av medlemsnumre.) Foruten nødvendige datafelt skal klassen ha en konstruktør og en get-metode for id-nummeret.

a) Programmer klassen Sykkel.


OPPGAVE 2

For å kunne leie en bysykkel må syklisten være registrert i Bysykkel-systemet. Objekter av klassen Person skal representere syklistene i programmet. Klassen Person skal ha følgende datafelt:

navn
Navnet på syklisten.
idNr
Hver person skal ha et unikt id-nummer av type heltall og dette skal genereres automatisk hver gang et person-objekt opprettes.
(Hvordan du kan gjøre det kan du lese om i kapittel 8, Eksempel: Automatisk generering av medlemsnumre.)
sykkel
Objekt som representer sykkelen som personen leier. Når personen ikke leier noen sykkel skal dette feltet være null.
merknad
Tekstvariabel for å lagre anmerkninger om f.eks mislighold av leieavtalen. Hvis personen ikke har noen anmerkninger skal dette feltet vært null.
startTid
Objekt som representer starttidspunktet for leie av sykkelen. Når personen ikke leier noen sykkel skal dette feltet være null.
nesteNr
Datafelt som skal brukes til å generere unike id-nummer


Nedenfor ser du en skisse av klassen. 
Din oppgave er å erstatte all pseudokode med java-instruksjoner.

import java.util.Date;
import java.text.DateFormat;

public class Person
{
   < datafelt >

   < konstruktør >

   < get-metoder for sykkel og idNr >


   public boolean godkjent()
   {
     < Metoden skal returnere true hvis personen ikke allerede leier
       en sykkel og ikke har noen merknader. Ellers false. >
   }

   public void setMerknad(Date t, String m)
   {
     < Metoden skal ut fra parametrene t og m lagre en tekst i datafeltet for
       merknader. I teksten skal tidspunktet formateres  slik det er beskrevet
       i oppgavens innledning. >
   }

   public boolean leiSykkel(Sykkel s)
   {
     < Hvis personen er godkjent, jfr. metoden godkjent(), skal metoden
       registrere at personen leier sykkelen s. Starttidspunktet for leietiden
       skal også registreres og skal være det samme som tidspunktet for når
       denne metoden blir kalt. Metoden skal så returnere true.
       Hvis personen ikke er godkjent, får vedkommende ikke leie sykkelen s
       og metoden skal returnere false. >
   }

   public int leietid(Date sluttTid)
   {
     < Metoden skal returnere antall påbegynte timer fra starttidspunktet for
       leien til sluttidspunktet angitt av parameteren sluttTid. >
   }

   public void leverInn()
   {
     < Metoden skal registrere innleveringstidpunktet (som vil  være det samme
       som tidspunktet for når denne metoden blir kalt). Videre skal leietiden
       beregnes. Hvis den lovlige leietiden er overskredet, skal det settes en
       merknad på personen. Denne skal inneholde innleveringstidspunktet og det
       antall timer leietiden er overskredet med. Uansett skal det registreres
       at personen ikke lenger leier sykkelen. >
   }

   public String toString()
   {
     < Metoden skal returnere en tekst som inneholder personens navn og idNr.
       Hvis personen leier en sykkel, skal sykkelens idNr tas med i teksten.
       Hvis personen har en merknad, skal denne også tas med i teksten. >
   }

} // end of class Person 
OPPGAVE 3

Alle personene (syklistene) er lagret i et personregister. 
Nedenfor ser du klassen som representerer dette registeret i programmet.
Din oppgave er å erstatte all pseudokode med java-instruksjoner.

public class PersonRegister
{
   private Person[] personer;


   public PersonRegister(int antall)
   {
     personer = new Person[antall];
     opprettPersonregister();
   }

   public  void opprettPersonregister()
   {
     < Her skal du opprette konkrete Person-objekter og sette dem inn
       i arrayen, f.eks 10 stykker. Du vil trenge dem for å kunne teste
       ut programmet. >
   }

   public Person finnPerson(int personId)
   {
     < Metoden skal lete etter en person (et person-objekt) med idNr lik
       parameteren personId. Hvis personen finnes i registeret, skal person-
       objektet returneres fra metoden. I motsatt fall skal metoden returnere
       null. NB! Vi kjenner ikke til antall person-objekter i arrayen og vet
       heller ikke om disse ligger etter hverandre. >
   }

   public Person finnSykkelBruker(int sykkelId)
   {
     < Metoden skal lete etter en person (et person-objekt) som leier en sykkel
       med idNr lik parameteren sykkelId. Hvis en slik person finnes i registeret,
       skal person-objektet returneres fra metoden. I motsatt fall skal metoden
       returnere null. NB! Vi kjenner ikke til antall person-objekter i arrayen
       og heller ikke om disse ligger etter hverandre. >
   }

} // end of class PersonRegister 
OPPGAVE 4

Når syklene ikke er utleid er de plassert i stativer på forskjellige steder i byen.
Hvert stativ er representert ved et objekt av klassen Stativ som du ser en skisse av under. 
Din oppgave er å erstatte all pseudokode med java-instruksjoner.

public class Stativ
{
   private Sykkel[] stativ;

   public Stativ(int antallSykler)
   {
     stativ = new Sykkel[antallSykler];
     fyllStativet();
   }

   public void fyllStativet()
   {
     < Her skal du opprette konkrete Sykkel-objekter og sette dem inn
       i arrayen. Et passende antall vil være halvparten av hva det er plass til. >
   }

   public String leiUt(Person s)
   {
     < Metoden skal registrere at personen representert ved parameteren s
       leier en sykkel under følgende tre forutsetninger:
       - Personen har ingen merknader.
       - Personen leier ingen sykkel fra før.
       - Det er en ledig sykkel i stativet.
       Hvis alle betingelsene er oppfylt, skal sykkelen fjernes fra stativet og
       leie av sykkelen skal registreres på personen. Metoden skal så returnere
       en tekst med informasjon om hvilken sykkel som skal brukes, for eksempel:
       "Ta sykkel på plass 1". Husk at plassene går fra 1 og oppover. Hvis leie
       av sykkel ikke lar seg gjøre skal metoden returnere en tekst med
       informasjon om hva det skyldes. >
   }

   public String leverInn(Person s )
   {
     < Metoden skal sørge for at sykkelen som personen, representert ved
       parameteren s,leier blir "satt tilbake i stativet", under forutsetning
       av at det er plass i stativet. Videre må det registreres at personen nå
       ikke lenger leier sykkelen. Hvis det er plass skal metoden returnere en
       tekst som angir hvor sykkelen skal plasseres, for eksempel:
       "Sett sykkelen på plass 12".I motsatt fall skal det returneres en tekst
       som ber syklisten levere sykkelen et annet sted. >
   }

}// end of class Sykkel 


OPPGAVE 5

    

Over ser du eksempler på displayer som finnes på sykkelstativene på de forskjellige utleiestedene i byen.
Hvert diplay er av et objekt av klassen Utleiested som du ser en skisse av under.
Din oppgave er å erstatte all pseudokode med java-instruksjoner.


< import-setninger >

public class Utleiested  < Nødvendig kode for en vindusklasse/lytteklasse >
{
   private Stativ stativet;
   private JTextField  personIdFelt, sykkelIdFelt;
   private JTextArea display;
   private JButton ut, inn ;
   private PersonRegister personer;

   public Utleiested(String navn, int antall, PersonRegister p)
   {
     super("BYSYKKEL " + navn);
     personer = p;
     stativet = new Stativ(antall);
     < Oppretter skjermkomponentene >
     < Knytter knappene til lytteobjektet >
     Container c = getContentPane();
     setLayout(new FlowLayout());
     < Legger skjermkomponentene ut på vinduet >
     setSize(200, 200);
     setVisible(true);
     setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

   public void leiUt()
   {
     < Metoden skal leie ut en sykkel til personen med det id-nummer som er
       skrevet inn i tekstfeltet for dette. Hvis personen er registrert og er
       godkjent for utleie, skal det skrives ut i tekstområdet hvilken sykkel
       vedkommende skal ta. I motsatt fall skal det skrives ut en passende
       feilmelding. Denne skal inneholde årsaken til at peronen ikke fikk leie
       sykkelen. >
   }

   public void leverInn()
   {
     < Metoden skal registrere at en sykkel leveres inn. Hvis sykkelen er
       registrert utleid skal innleveringen registreres på personen som har
       leid sykkelen og det må registreres at sykkelen settes tilbake i stativet.
       I tekstområdet skal det skrives hvor sykkelen skal plasseres. Hvis
       sykkelens id-nummer er ukjent, skal det gis beskjed om det. >
   }

   public void actionPerformed(ActionEvent e )
   {
     < Metoden skal sørge for at leiUt() kalles når det klikkes på knappen
       "Leie", og at leverInn() kalles når det klikkes på  knappen "Levere" >
   }

}// end of class Utleiested 
For å få et kjørbart program må du legge følgende klasse til programmet:

public class SykkelByen
{
   private Utleiested[] steder;
   private PersonRegister register;

   public SykkelByen(int antall, PersonRegister r)
   {
     register = r;
     steder = new Utleiested[antall];
     opprettSykkelSteder();
   }


   public void opprettSykkelSteder()
   {
     steder[0] = new Utleiested("Holbergs plass", 20, register);
     steder[1] = new Utleiested("Majorstua", 20, register);
     steder[2] = new Utleiested("Nasjonalteateret", 20, register);
     steder[3] = new Utleiested("Egertorvet", 20, register);
   }

   public static void main(String[] args)
   {
     PersonRegister register = new PersonRegister(10);

     new SykkelByen(10, register);
   }
}




