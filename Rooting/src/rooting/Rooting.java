/*Chernov Dmitriy
 * 271 group
 */
package rooting;
public class Rooting
{
    public static double sqrtGeron (double num, double eps)
    {
        int k = 0;
        double Xn,Xn1;
        double Abs = 1.0;
        Xn = 1.0;
        Xn1 = (Xn + num/Xn)/2;
        while (Abs > eps)
        {
            Xn1 = (Xn + num/Xn)/2;
            Abs = Math.abs(Xn-Xn1);
            Xn = Xn1;
            k++;
        }
        return Xn;
    };
}
