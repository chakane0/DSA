package Prmitives;
public class Parity { 
    public static void main(String[] args) {

        /*
            The parity of a binary word is 1 if the number of 1s in the word is odd; otherwise it is 0.
            For example the parity of 1011 is 1 and the parity of 1100 is 0.
            This is used to detect single but errors in data storage and communication
        */
        
    }

    // Time complexity: O(n)
    public static  short parity(long x) {
        short result = 0;
        while (x != 0) {

            // extract the least significant bit
            // XOR is an exclusive OR; a bitwise operator which compares 2 bits and returns 1 only when the bits are different
            // think of if as a light switch. If you flip it an even number of times, you end up back where u started
            // flip it an odd number of times, youre now in the opposite position
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }





    // this only loops once per set bit, O(k) where k = # of 1 bits
    // the idea comes from x & (x - 1) erases the lowest set bit of x

    // This is because when you subtrct 1 from a number, it flips the lowest 1 bit to 0, and flips all the 0's to 1
    // x =      00101100
    // x - 1 =  00101011

    // And then if we do this it will come back as the original x value
    //  00101100
    //& 00101011

    // time complexity: O(k)
    public static short parity2(long x) {
        short result = 0;

        while(x != 0) {
            result ^= 1;
            x &= (x-1);
        }
        return result;
    }




    /*
        Now when you have to perform a large amount of parity computations, we would need to process multiple bits at 
        a time and caching results in an array based lookup table.

        When computing the parity of a collection of bits, it does not matter how we group these bits as these would be associative.
        Therefore we can compute the parity of a 64-bit integer by grouping its bits into four
        non-overlapping 16 bit subwords, computing the parity of each subwords, and then computing the parity of these 4 subresults
    */

        public static short parity3(long x) {
            final int MASK_SIZE = 16;
            final int BIT_MASK = 0xFFFF;
            return (short) (precomputedParity[(int) ((x >>> (3 * MASK_SIZE)) & BIT_MASK)] ^
                            precomputedParity[(int) ((x >>> (2 * MASK_SIZE)) & BIT_MASK)] ^
                            precomputedParity[(int) ((x >>> MASK_SIZE) & BIT_MASK)] ^
                            precomputedParity[(int) (x & BIT_MASK)]);
        } 

}