package com.company;

public class bitvec {
    private int size;
    private long[] bits;

    public bitvec(int size, boolean b) {
        this.size = size;
        final int WORDSIZE = (size + 63) / 64;
        this.bits = new long[WORDSIZE];
        long val = b ? 0xFFFFFFFFFFFFFFFFL : 0;
        for (int i = 0; i < WORDSIZE; i++) {
            bits[i] = val;
        }
    }

    public void set(int i) {
        bits[i / 64] |= 1L << (i % 64);
    }

    public void clear(int i) {
        bits[i / 64] &= ~(1L << (i % 64));
    }

    public boolean test(int i) {
        return (bits[i / 64] & (1L << (i % 64))) != 0;
    }
}

