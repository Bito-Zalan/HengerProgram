package hu.szamalk;

import java.util.ArrayList;
import java.util.List;

public class HengerProgram {

    private List<MertaniHenger> hengerek;

    public static void main(String[] args) {
        new HengerProgram().run();
    }
    public void run(){
        int db = MertaniHenger.getHengerDarab();
        System.out.printf("hengerek (%ddb):\n",db);
        for (MertaniHenger henger : this.lista()){
            System.out.println(henger);
        }
        System.out.println("Hengerek átlagtérfogata: " + this.atlagTerfogat());
        System.out.println("Csöves súlya: " + this.csovekSulya());
    }

    public HengerProgram(){
        hengerek = new ArrayList<>();
        hengerek.add(new MertaniHenger(1,1));
        hengerek.add(new TomorHenger(1,1));
        hengerek.add(new LyukasHenger(1,1,.5));
        hengerek.add(new LyukasHenger(1,1,.1));

    }
    public double atlagTerfogat(){
        double ossz = 0;
        for (MertaniHenger henger : hengerek){
            ossz += henger.terfogat();
        }
        return ossz / MertaniHenger.getHengerDarab();
    }

    public double csovekSulya(){
        double ossz = 0;
        for (MertaniHenger henger : hengerek){
            if(henger instanceof LyukasHenger) {
                ossz += ((LyukasHenger) henger).suly();
            }
        }
        return ossz;

    }
    private List<MertaniHenger> lista(){
        return hengerek;
    }

}