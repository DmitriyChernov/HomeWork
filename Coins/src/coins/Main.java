/*
 * Chernov Dmitriy
 * 271 group
 */
package coins;

public class Main {

    public static void main(String[] args) 
    {
        int []c = {1,2,5,10,25,50};
        int n = 100;
        Combinations nc = new Combinations();
        System.out.println(nc.numberCombinations(n,c));
    }
}
