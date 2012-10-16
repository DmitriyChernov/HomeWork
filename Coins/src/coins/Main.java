/*
 * Chernov Dmitriy
 * 271 group
 */
package coins;

public class Main {

    public static void main(String[] args) 
    {
        int []c = {1,5,10,25,50};
        int n = 100;
        Combinations nc = new Combinations(c);
        System.out.println(nc.numberCombinations(0,n,c));
    }
}
