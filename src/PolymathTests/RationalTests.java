package PolymathTests;

import Polymath.Rational;
import Polymath.Scalar;

import org.junit.*;

public class RationalTests {
    private Scalar r;

    @Test(expected = IllegalArgumentException.class)
    void denominatorZero(){
        r = new Rational((int)(Math.random()*java.lang.Integer.MAX_VALUE), 0);
    }

    @Test
    void creation(){
        r = new Rational(5,10);
        Assert.assertEquals(r.toString(), "1/2");
        r = new Rational(-352, 20460);
        Assert.assertEquals(r.toString(), "-8/465");
        r = new Rational(1024, -512);
        Assert.assertEquals(r.toString(), "-2");
        r = new Rational(-613, -21);
        Assert.assertEquals(r.toString(), "205/7");
        r = new Rational(0, (int)(Math.random()* (java.lang.Integer.MAX_VALUE-1)) + 1);
        Assert.assertEquals(r.toString(), "0");
        r = new Rational(0, -1*((int)(Math.random()* (java.lang.Integer.MAX_VALUE -1)) + 1 ));
        Assert.assertEquals(r.toString(), "0");
    }

    @Test
    void sign(){
        r = new Rational(5,10);
        Assert.assertEquals(r.sign(), "1");
        r = new Rational(-352, 20460);
        Assert.assertEquals(r.sign(), "-1");
        r = new Rational(1024, -512);
        Assert.assertEquals(r.sign(), "-1");
        r = new Rational(-613, -21);
        Assert.assertEquals(r.sign(), "1");
        r = new Rational(0, (int)(Math.random()* (java.lang.Integer.MAX_VALUE-1)) + 1);
        Assert.assertEquals(r.sign(), "0");
        r = new Rational(0, -1*((int)(Math.random()* (java.lang.Integer.MAX_VALUE -1)) + 1 ));
        Assert.assertEquals(r.sign(), "0");

    }

    @Test
    void neg(){
        r = new Rational(5,10);
        r = r.neg();
        Assert.assertEquals(r.toString(), "-1/2");
        r = new Rational(-352, 20460);
        r = r.neg();
        Assert.assertEquals(r.toString(), "8/465");
        r = new Rational(1024, -512);
        r = r.neg();
        Assert.assertEquals(r.toString(), "2");
        r = new Rational(-613, -21);
        r = r.neg();
        Assert.assertEquals(r.toString(), "-205/7");
        r = new Rational(0, (int)(Math.random()* (java.lang.Integer.MAX_VALUE-1)) + 1);
        r = r.neg();
        Assert.assertEquals(r.toString(), "0");
        r = new Rational(0, -1*((int)(Math.random()* (java.lang.Integer.MAX_VALUE -1)) + 1 ));
        r = r.neg();
        Assert.assertEquals(r.toString(), "0");
    }
}
