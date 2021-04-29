package PolymathTests;

import Polymath.Integer;
import Polymath.Rational;
import Polymath.Scalar;

import org.junit.*;

public class RationalTests {
    private Scalar r;

    @Test(expected = ArithmeticException.class)
    public void create_with_denominator_zero_fail(){
        r = new Rational((int)(Math.random()*java.lang.Integer.MAX_VALUE), 0);
    }

    @Test
    public void creation_success(){
        r = new Rational(5,10);
        Assert.assertEquals(r.toString(), "1/2");
        r = new Rational(-352, 20460);
        Assert.assertEquals(r.toString(), "-8/465");
        r = new Rational(1024, -512);
        Assert.assertEquals(r.toString(), "-2");
        r = new Rational(-615, -21);
        Assert.assertEquals(r.toString(), "205/7");
        r = new Rational(0, (int)(Math.random()* (java.lang.Integer.MAX_VALUE-1)) + 1);
        Assert.assertEquals(r.toString(), "0");
        r = new Rational(0, -1*((int)(Math.random()* (java.lang.Integer.MAX_VALUE -1)) + 1 ));
        Assert.assertEquals(r.toString(), "0");
    }

    @Test
    public void sign_success(){
        r = new Rational(5,10);
        Assert.assertEquals(r.sign(), 1);
        r = new Rational(-352, 20460);
        Assert.assertEquals(r.sign(), -1);
        r = new Rational(1024, -512);
        Assert.assertEquals(r.sign(), -1);
        r = new Rational(-613, -21);
        Assert.assertEquals(r.sign(), 1);
        r = new Rational(0, (int)(Math.random()* (java.lang.Integer.MAX_VALUE-1)) + 1);
        Assert.assertEquals(r.sign(), 0);
        r = new Rational(0, -1*((int)(Math.random()* (java.lang.Integer.MAX_VALUE -1)) + 1 ));
        Assert.assertEquals(r.sign(), 0);

    }

    @Test
    public void neg_success(){
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
        Assert.assertEquals(r.toString(), "-613/21");
        r = new Rational(0, (int)(Math.random()* (java.lang.Integer.MAX_VALUE-1)) + 1);
        r = r.neg();
        Assert.assertEquals(r.toString(), "0");
        r = new Rational(0, -1*((int)(Math.random()* (java.lang.Integer.MAX_VALUE -1)) + 1 ));
        r = r.neg();
        Assert.assertEquals(r.toString(), "0");
    }

    @Test
    public void add_Integer_success() {
        r = new Rational(-3, 2);
        r = r.add(new Integer(14));
        Assert.assertEquals(r.toString(), "25/2");
        r = new Rational(-5, -5);
        r = r.add(new Integer(-8));
        Assert.assertEquals(r.toString(), "-7");
        r = new Rational(-5, 7);
        r = r.add(new Integer(-2));
        Assert.assertEquals(r.toString(), "-19/7");
    }

    @Test
    public void add_Integer_zero_success() {
        r = new Rational(0, 5);
        r = r.add(new Integer(4));
        Assert.assertEquals(r.toString(), "4");
        r = new Rational(0, -1);
        r = r.add(new Integer(0));
        Assert.assertEquals(r.toString(), "0");
    }

    @Test
    public void add_Rational_success() {
        r = new Rational(3, 5);
        r = r.add(new Rational(4, 7));
        Assert.assertEquals(r.toString(), "41/35");
        r = new Rational(9, 5);
        r = r.add(new Rational(9, -5));
        Assert.assertEquals(r.toString(), "0");
        r = new Rational(4, 3);
        r = r.add(new Rational(-2, 3));
        Assert.assertEquals(r.toString(), "2/3");
    }

    @Test
    public void add_Rational_zero_success() {
        r = new Rational(0, 5);
        r = r.add(new Rational(0, -7));
        Assert.assertEquals(r.toString(), "0");
    }

    @Test(expected = NullPointerException.class)
    public void add_null_fail() {
        r = new Rational(2, 5);
        r = r.add(null);
    }

    @Test(expected = NullPointerException.class)
    public void addInteger_null_fail() {
        r = new Rational(2, 5);
        r = r.addInteger(null);
    }
    @Test(expected = NullPointerException.class)
    public void addRational_null_fail() {
        r = new Rational(2, 5);
        r = r.addRational(null);
    }

    @Test
    public void mul_Integer_success() {
        r = new Rational(-3, 2);
        r = r.mul(new Integer(14));
        Assert.assertEquals(r.toString(), "-21");
        r = new Rational(0, 5);
        r = r.mul(new Integer(4));
        Assert.assertEquals(r.toString(), "0");
        r = new Rational(5, -3);
        r = r.mul(new Integer(0));
        Assert.assertEquals(r.toString(), "0");
        r = new Rational(0, -1);
        r = r.mul(new Integer(0));
        Assert.assertEquals(r.toString(), "0");
        r = new Rational(-5, -5);
        r = r.mul(new Integer(-8));
        Assert.assertEquals(r.toString(), "-8");
        r = new Rational(-5, 7);
        r = r.mul(new Integer(1));
        Assert.assertEquals(r.toString(), "-5/7");
    }

    @Test
    public void mul_Rational_success(){
        r = new Rational(0, 5);
        r = r.mul(new Rational(0, -7));
        Assert.assertEquals(r.toString(), "0");
        r = new Rational(9, 5);
        r = r.mul(new Rational(9, -5));
        Assert.assertEquals(r.toString(), "-81/25");
        r = new Rational(3, 5);
        r = r.mul(new Rational(1, 6));
        Assert.assertEquals(r.toString(), "1/10");
        r = new Rational(3, 5);
        r = r.mul(new Rational(0, 7));
        Assert.assertEquals(r.toString(), "0");
        r = new Rational(-5, -5);
        r = r.mul(new Rational(-6, 6));
        Assert.assertEquals(r.toString(), "-1");
    }

    @Test(expected = NullPointerException.class)
    public void mul_null_fail(){
        r = new Rational(2, 5);
        r = r.mul(null);
    }

    @Test(expected = NullPointerException.class)
    public void mulInteger_null_fail(){
        r = new Rational(2, 5);
        r = r.mulInteger(null);
    }

    @Test(expected = NullPointerException.class)
    public void mulRational_null_fail(){
        r = new Rational(2, 5);
        r = r.mulRational(null);
    }

    @Test
    public void power() {
        r = new Rational(-3, 7);
        r = r.power(-4);
        Assert.assertEquals(r.toString(), "2401/81");
        r = new Rational(-3, 7);
        r = r.power(-3);
        Assert.assertEquals(r.toString(), "-343/27");
        r = new Rational(1, 1);
        r = r.power(-1);
        Assert.assertEquals(r.toString(), "1");
        r = new Rational(5, 2);
        r = r.power(-1);
        Assert.assertEquals(r.toString(), "2/5");
        r = new Rational(5, 2);
        r = r.power(0);
        Assert.assertEquals(r.toString(), "1");
        r = new Rational(0, 2);
        r = r.power(0);
        Assert.assertEquals(r.toString(), "1");
        r = new Rational(0, 2);
        r = r.power(1);
        Assert.assertEquals(r.toString(), "0");
        r = new Rational(5, 2);
        r = r.power(1);
        Assert.assertEquals(r.toString(), "5/2");
        r = new Rational(-7, 5);
        r = r.power(3);
        Assert.assertEquals(r.toString(), "-343/125");
        r = new Rational(-7, 5);
        r = r.power(4);
        Assert.assertEquals(r.toString(), "2401/625");
    }

    @Test(expected = ArithmeticException.class)
    public void negative_power_on_zero_fail() {
        r = new Rational(0, 5);
        r.power(-1);
    }

}
