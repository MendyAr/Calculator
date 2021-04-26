package PolymathTests;

import Polymath.*;

import org.junit.*;

public class RationalTests {
    private Rational r;

    @Test(expected = IllegalArgumentException.class)
    void testDenominatorZero(){
        r = new Rational((int)(Math.random()*Integer.MAX_VALUE), 0);
    }
}
