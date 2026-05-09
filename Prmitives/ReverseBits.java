package Prmitives;

public class ReverseBits {
    /*
        Write a program that takes a 64-bit unsigned integer and 
        returns the 64-bit unsigned integer consisting of the bits of the input in reverse order
        For example if the input is 1110000000000001, the output should be 1000000000000111

        The brute force approach will assume we only need to perform this operation once.
        We would iterate through the 32 LSB of the input, and swap each with the corresponding most significant bit

        However if we need to reverse the bits repeadetly, we need to look closely at the structure of the input, 
        leaning towards using a cache system. 

        Let the input consist of the 4 15 bit integers: y3, y2, y1, y0 with y3 holding the MSB. 
        Then the 16 LSB in the reverse come from y3. For example, if y3 is 11100000000000001 then the 16 LSBs of the result are
        1000000000000111.

        So similar to computing parity, a fast way to reverse bits for a 16-bit integer when were 
        performing many reverses is to build an array based lookup table A, such that for every 
        16 bit integer y, A[y] holds the bit reversal of y. We can then form the reverse of y1, 
        followed by the reverse of y2, followed by the reserve of y3

        This approach can be illustrated by using 8 bit integers and 2-bit lookup table keys. 
        rev = <(00), (10), (01), (11)>
        If the input is (10010011), its reverse is rev(11), rev(00), rev(01), rev(10) where we will get (11001001)



    */

    public static void main(String[] args) {
        System.out.println(10 >>> 1);
    }

    public static long reverseBits(long x) {
        final int MASK_SIZE = 16;
        final int BIT_MASK = 0xFFFF;
        return precomputedReverse[(int)(x & BIT_MASK)] << (3 * MASK_SIZE) |
        << (2 * MASK_SIZE) |
        precomputedReverse[(int) ((x >>> (2 * MASK_SIZE)) & BIT_MASK)] << MASK_SIZE |
        precomputedReverse[(int) ((x >>> (3 * MASK_SIZE)) & BIT_MASK)];
    }
}
