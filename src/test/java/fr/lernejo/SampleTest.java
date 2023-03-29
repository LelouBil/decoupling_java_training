package fr.lernejo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    @Test
    void op() {
        var sample = new Sample();
        assertEquals(3,sample.op(Sample.Operation.ADD,1,2));
        assertEquals(2,sample.op(Sample.Operation.MULT,1,2));
    }

    @Test
    void fact() {
        var sample = new Sample();
        assertEquals(1,sample.fact(0));
        assertEquals(1,sample.fact(1));
        assertEquals(2,sample.fact(2));
        assertEquals(6,sample.fact(3));

        assertThrows(IllegalArgumentException.class,() -> sample.fact(-1));
    }
}
