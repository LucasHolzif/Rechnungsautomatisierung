package de.lucas;

public class Kunde {

    private String name;
    private String leistung;
    private double betrag;
    private String datum;
    private int rechnungsnummer;

    public Kunde (String name,String leistung,double betrag,String datum,int rechnungsnummer){
        this.name = name;
        this.leistung = leistung;
        this.betrag = betrag;
        this.datum = datum;
        this.rechnungsnummer = rechnungsnummer;
    }

    public String getName(){
        return name;
    }
    public String getLeistung(){
        return leistung;
    }
    public double getBetrag(){
        return betrag;
    }
    public String getDatum(){
        return datum;
    }
    public int getRechnungsnummer(){
        return rechnungsnummer;
    }

    @Override
    public String toString(){
        return "Kundenname: "+ name + ", Leistung: " + leistung + ", Betrag: "+betrag+ ", Datum: "+ datum + ", Rechnungsnummer: "+ rechnungsnummer;
    }

}
