package com.epam.jmp.camta.forkjoin;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class SumOfSquaresTaskTest {

    private static final double[] ARRAY = new double[100_000_000];

    @BeforeClass
    public static void setUp() {
        Random random = new Random();
        for (int i = 0; i < ARRAY.length; i++) {
            ARRAY[i] = random.nextDouble();
        }
    }

    @Test
    public void testForkJoinSumOfSquares() {
        ForkJoinPool pool = new ForkJoinPool();
        SumOfSquaresTask task = new SumOfSquaresTask(ARRAY, 0, ARRAY.length, null);
        pool.invoke(task);
        System.out.println(task.getResult());
    }

    @Test
    public void testLinearSumOfSquares() {
        double sum = 0;
        for (double v : ARRAY) {
            sum += v * v;
        }
        System.out.println(sum);
    }
}