package com.epam.jmp.camta.forkjoin;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

import static com.epam.jmp.camta.forkjoin.FibonacciTask.fibLoop;
import static com.epam.jmp.camta.forkjoin.FibonacciTask.fibRecur;
import static org.junit.Assert.assertEquals;

public class FibonacciTaskTest {

    @Test
    public void testLargeFibForkJoin() {
        assertEquals(1134903170L, new ForkJoinPool().invoke(new FibonacciTask(45)).longValue());
    }

    @Test
    public void testMiddleFibRecur() {
        assertEquals(832040, fibRecur(30));
    }

    @Test
    @Ignore
    public void testLargeFibRecur() {
        assertEquals(12586269025L, fibRecur(50));
    }

    @Test
    public void testMiddleFibLoop() {
        assertEquals(832040, fibLoop(30));
    }

    @Test
    public void testLargeFibLoop() {
        assertEquals(12586269025L, fibLoop(50));
    }
}