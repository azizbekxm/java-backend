package com.epam.jmp.camta.race;

class Counter {

    private long count = 0;

    long add(long value) {
        return this.count += value;
    }
}
