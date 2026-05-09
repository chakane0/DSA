package Prmitives;
public class CountBits {
    public static void main(String[] args) {
        short n = countBits(   10);
        System.out.println(n);
    }


    public static short countBits(int n) {
        short numBits = 0;
        while (n != 0) {

            // this checks wether the current last bit is a 1
            numBits += (n & 1);

            // shift to the next bit until n == 0
            n >>>= 1;
        }
        return numBits;
    }
    
}