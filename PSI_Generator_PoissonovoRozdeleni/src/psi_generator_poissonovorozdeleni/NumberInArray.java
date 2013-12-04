/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psi_generator_poissonovorozdeleni;

/**
 *
 * @author michalblazek
 */
public class NumberInArray {
    int number;
    int sum;

    public NumberInArray(int number, int sum) {
        this.number = number;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return number+" ["+sum+"]";
    }
    
    public void improveSum(){
        this.sum++;
    } 
    
    public boolean compareNumber(int b){
        if (this.number==b){
            return true;
        }else {
            return false;
        }
        
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
    
    
}
