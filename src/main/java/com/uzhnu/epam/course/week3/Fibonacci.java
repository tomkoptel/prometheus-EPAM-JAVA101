package com.uzhnu.epam.course.week3;

public class Fibonacci {
    public long getNumber(int position) {
        if (position == 1) return 1L;
        if (position == 2) return 1L;
        if (position <= 0) return -1L;
        if (position >= 93) return -1L;
        return fibTail(position, 0L, 1L);
    }

    private long fibTail(long n, long prev2, long prev1) {
        while (n != 1L) {
            long temp1 = n - 1L;
            long temp2 = prev1;
            prev1 += prev2;
            prev2 = temp2;
            n = temp1;
        }

        return prev1;
    }
}
