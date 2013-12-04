package psi_generator_poissonovorozdeleni;

import java.util.ArrayList;

/**
 * 3.12.2013
 * @author michalblazek, CVUT KyR
 */
public class PSI_Generator_PoissonovoRozdeleni {
    public static void main(String[] args) {
        int pocetCyklu = 10000;
        double lambda = 50; //koeficient poissonova rozdeleni pro generator cisel
        ArrayList<Integer> s = new ArrayList(pocetCyklu); 
        
        // cyklus vytvoreni kolekce s cisly s poissonovym ozdelenim
        for(int i = 1; i<= pocetCyklu ; i++){
            int c = getPoisson(lambda);
            s.add(c);
           // System.out.println(i+". "+c);
        }
        
        // vypocet cetnosti jednotlivych cifer a serazeni kolekce
         ArrayList<NumberInArray> p = WriteCollectinStatus(s);
         SortArrayListbyNumber(p);
         
         System.out.println("Cislo [cetnost]");
         // ladici vypis do konzole
         for(int i = 0; i<p.size();i++){
             System.out.println(p.get(i).toString());
         }
    }

    public static int getPoisson(double l) {
        // generator nahodnych cisel s poisonovým rozdelenim
        double t = 0;
        for (int x = 0; true; x++) {
            t = t - Math.log(Math.random()) / l;
            if (t > 1.0) {
                return x;
            }
        }
    }
    
    public static ArrayList WriteCollectinStatus (ArrayList<Integer> l){
        // prochází kolekci vygenerovaných čísel a počítá výskyt jednotlivých čísel, ten pak vrací jako kolekci objektu o typu (cislo, cetnost)
        ArrayList<NumberInArray> ret = new ArrayList();
        for(int i = 0; i<l.size();i++){
           if(IsNumberInTheList(ret, l.get(i))!=null){
            IsNumberInTheList(ret, l.get(i)).improveSum();
        }else
               ret.add(new NumberInArray(l.get(i), 1));
        }
        
        return ret;
    }
    
    public static NumberInArray IsNumberInTheList(ArrayList<NumberInArray> l,int a){
       //Prohledává kolekci obsahující objekty o typu (cislo, pocet vyskytu) a hledá zda se zde zadané cislo nachazi ci nikoli.
       for(int i = 0; i<l.size();i++){
            if(l.get(i).compareNumber(a))
                return l.get(i);
        }
       return null;
    }
    
    public static void SortArrayListbyNumber (ArrayList<NumberInArray> l){
        //bubbel sort na seřazení kolekce od nejmenších čísel po největší
        for(int i = 1; i<l.size();i++){
            if (l.get(i-1).number>l.get(i).number){
                NumberInArray a = new NumberInArray(l.get(i-1).number, l.get(i-1).sum);
                l.get(i-1).setNumber(l.get(i).number);
                l.get(i-1).setSum(l.get(i).sum);
                l.get(i).setNumber(a.number);
                l.get(i).setSum(a.sum);
                i=0;
            }
        }
    }
}
