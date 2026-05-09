package Prmitives;

public class SwapBits {

    /*
        x & (x - 1) --> clears the lowest set bit in x
        x & ~(x - 1) --> extracts the lowest set bit in x

        a 64 bit integer can be viewed as an array of 64 bits, 
        with the bit at 0 correspondng to the LSB, and the bit at index 63 corresponding to the MSB

        Write code that takes as input a 64-bit integer and swaps bits at indicies i and j
    */
    public static void main(String[] args) {}


    // Time complexity: O(1)
    public static long swapBits(long x, int i, int j) {

        // extract ith and jth bits and see if they differ
        if( ( (x >>> 1) & 1) != ((x >>> 1) & 1)) {
            // here the ith and jth bits will differ. we swap them by flipping their values
            // select the bits to flip with bitMask. Since x^1 = 0 when x = 1 and 1 when x = 0, we can perform thje flip XOR
            long bitMask = (1L << i ) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }
}
