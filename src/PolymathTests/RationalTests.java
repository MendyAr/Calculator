package PolymathTests;

import Polymath.Rational;

import org.junit.Assert;
import org.junit.Test;

public class RationalTests {
    private Rational r;

    @Test(expected = IllegalArgumentException.class)
    void testDenominatorZero(){
        r = new Rational((int)(Math.random()*Integer.MAX_VALUE), 0);
    }
}
