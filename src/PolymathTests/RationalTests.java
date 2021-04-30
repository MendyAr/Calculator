package PolymathTests;

import Polymath.Integer;
import Polymath.Rational;
import Polymath.Scalar;

import org.junit.*;

public class RationalTests {
    private Scalar r;

    @Test
    public void creation_success(){
        r = new Rational(5,10);
        Assert.assertEquals("Rational didn't construct properly", "1/2", r.toString());
        r = new Rational(-352, 20460);
        Assert.assertEquals("Rational didn't construct properly", "-8/465", r.toString());
        r = new Rational(1024, -512);
        Assert.assertEquals("Rational didn't construct properly", "-2", r.toString());
        r = new Rational(-615, -21);
        Assert.assertEquals("Rational didn't construct properly", "205/7", r.toString());
        r = new Rational(50, 50);
        Assert.assertEquals("Rational didn't construct properly", "1", r.toString());
        r = new Rational(0, (int)(Math.random()* (java.lang.Integer.MAX_VALUE-1)) + 1);
        Assert.assertEquals("Rational didn't construct properly", "0", r.toString());
        r = new Rational(0, -1*((int)(Math.random()* (java.lang.Integer.MAX_VALUE -1)) + 1 ));
        Assert.assertEquals("Rational didn't construct properly", "0", r.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void create_with_denominator_zero_fail(){
        r = new Rational((int)(Math.random()*java.lang.Integer.MAX_VALUE), 0);
    }

    @Test(expected = NullPointerException.class)
    public void create_copy_of_null_fail(){
        r = new Rational(null);
    }

    @Test
    public void sign_success(){
        r = new Rational(5,10);
        Assert.assertEquals( "incorrect sign was returned", 1, r.sign());
        r = new Rational(-352, 20460);
        Assert.assertEquals("incorrect sign was returned", -1, r.sign());
        r = new Rational(1024, -512);
        Assert.assertEquals("incorrect sign was returned", -1, r.sign());
        r = new Rational(-613, -21);
        Assert.assertEquals("incorrect sign was returned", 1, r.sign());
        r = new Rational(0, (int)(Math.random()* (java.lang.Integer.MAX_VALUE-1)) + 1);
        Assert.assertEquals("incorrect sign was returned", 0, r.sign());
        r = new Rational(0, -1*((int)(Math.random()* (java.lang.Integer.MAX_VALUE -1)) + 1 ));
        Assert.assertEquals("incorrect sign was returned", 0, r.sign());
    }

    @Test
    public void neg_success(){
        r = new Rational(5,10);
        r = r.neg();
        Assert.assertEquals("Failed to negate properly","-1/2", r.toString());
        r = new Rational(-352, 20460);
        r = r.neg();
        Assert.assertEquals("Failed to negate properly","8/465", r.toString());
        r = new Rational(1024, -512);
        r = r.neg();
        Assert.assertEquals("Failed to negate properly","2", r.toString());
        r = new Rational(-613, -21);
        r = r.neg();
        Assert.assertEquals("Failed to negate properly","-613/21", r.toString());
        r = new Rational(0, (int)(Math.random()* (java.lang.Integer.MAX_VALUE-1)) + 1);
        r = r.neg();
        Assert.assertEquals("Failed to negate properly","0", r.toString());
        r = new Rational(0, -1*((int)(Math.random()* (java.lang.Integer.MAX_VALUE -1)) + 1 ));
        r = r.neg();
        Assert.assertEquals("Failed to negate properly","0", r.toString());
    }

    @Test
    public void add_Integer_success() {
        r = new Rational(-3, 2);
        r = r.add(new Integer(14));
        Assert.assertEquals("Failed to add Integer properly", "25/2", r.toString());
        r = new Rational(-5, -5);
        r = r.add(new Integer(-8));
        Assert.assertEquals("Failed to add Integer properly", "-7", r.toString());
        r = new Rational(-5, 7);
        r = r.add(new Integer(-2));
        Assert.assertEquals( "Failed to add Integer properly", "-19/7", r.toString());
        r = new Rational(5, 7);
        r = r.add(new Integer(2));
        Assert.assertEquals( "Failed to add Integer properly", "19/7", r.toString());
        r = new Rational(5, 7);
        r = r.add(new Integer(-2));
        Assert.assertEquals( "Failed to add Integer properly", "-9/7", r.toString());
    }

    @Test
    public void add_Integer_zero_success() {
        r = new Rational(0, 5);
        r = r.add(new Integer(4));
        Assert.assertEquals("Failed adding to zero properly", "4", r.toString());
        r = new Rational(0, -1);
        r = r.add(new Integer(0));
        Assert.assertEquals("Failed adding to zero properly", "0", r.toString());
    }

    @Test
    public void add_Rational_success() {
        r = new Rational(3, 5);
        r = r.add(new Rational(4, 7));
        Assert.assertEquals("Failed to add Rational properly", "41/35", r.toString());
        r = new Rational(9, 5);
        r = r.add(new Rational(9, -5));
        Assert.assertEquals("Failed to add Rational properly","0", r.toString());
        r = new Rational(4, 3);
        r = r.add(new Rational(-2, 3));
        Assert.assertEquals("Failed to add Rational properly", "2/3", r.toString());
        r = new Rational(-4, 3);
        r = r.add(new Rational(2, 3));
        Assert.assertEquals("Failed to add Rational properly", "-2/3", r.toString());
        r = new Rational(-4, 3);
        r = r.add(new Rational(-2, 3));
        Assert.assertEquals("Failed to add Rational properly", "-2", r.toString());
    }

    @Test
    public void add_Rational_zero_success() {
        r = new Rational(0, 5);
        r = r.add(new Rational(0, -7));
        Assert.assertEquals("Failed adding to zero properly", "0", r.toString());
        r = new Rational(0, 5);
        r = r.add(new Rational(1, -7));
        Assert.assertEquals("Failed adding to zero properly", "-1/7", r.toString());
        r = new Rational(1, 7);
        r = r.add(new Rational(0, 1));
        Assert.assertEquals("Failed adding to zero properly", "1/7", r.toString());
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
        Assert.assertEquals("Failed to mul Integer properly","-21",  r.toString());
        r = new Rational(1, 2);
        r = r.mul(new Integer(-8));
        Assert.assertEquals("Failed to mul Integer properly","-4",  r.toString());
        r = new Rational(-5, 7);
        r = r.mul(new Integer(-2));
        Assert.assertEquals("Failed to mul Integer properly", "10/7",  r.toString());
        r = new Rational(5, 7);
        r = r.mul(new Integer(2));
        Assert.assertEquals("Failed to mul Integer properly", "10/7",  r.toString());
    }

    @Test
    public void mul_Integer_zero_success(){
        r = new Rational(0, 5);
        r = r.mul(new Integer(4));
        Assert.assertEquals("Failed multiplying with zero properly", "0",  r.toString());
        r = new Rational(5, -3);
        r = r.mul(new Integer(0));
        Assert.assertEquals("Failed multiplying with zero properly", "0",  r.toString());
        r = new Rational(0, -1);
        r = r.mul(new Integer(0));
        Assert.assertEquals("Failed multiplying with zero properly", "0", r.toString());
    }

    @Test
    public void mul_Rational_success(){
        r = new Rational(-9, 5);
        r = r.mul(new Rational(9, 5));
        Assert.assertEquals("Failed to mul Rational properly","-81/25", r.toString());
        r = new Rational(3, 5);
        r = r.mul(new Rational(1, 6));
        Assert.assertEquals("Failed to mul Rational properly","1/10", r.toString());
        r = new Rational(-5, -5);
        r = r.mul(new Rational(-6, 6));
        Assert.assertEquals("Failed to mul Rational properly","-1", r.toString());
        r = new Rational(-5, 3);
        r = r.mul(new Rational(-4, 1));
        Assert.assertEquals("Failed to mul Rational properly","20/3", r.toString());
    }

    @Test
    public void mul_Rational_zero_success(){
        r = new Rational(0, 5);
        r = r.mul(new Rational(0, -7));
        Assert.assertEquals("Failed multiplying with zero properly", "0", r.toString());
        r = new Rational(3, 5);
        r = r.mul(new Rational(0, 7));
        Assert.assertEquals("Failed multiplying with zero properly", "0", r.toString());
        r = new Rational(0, 5);
        r = r.mul(new Rational(3, 7));
        Assert.assertEquals("Failed multiplying with zero properly", "0", r.toString());
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
    public void power_of_zero_success() {
        r = new Rational(-5, 2);
        r = r.power(0);
        Assert.assertEquals("Failed with raising to the power of zero properly", "1", r.toString());
        r = new Rational(5, 2);
        r = r.power(0);
        Assert.assertEquals("Failed with raising to the power of zero properly", "1", r.toString());
        r = new Rational(0, 2);
        r = r.power(0);
        Assert.assertEquals("Failed with raising to the power of zero properly", "1", r.toString());
    }

    @Test
    public void power_positive_success() {
        r = new Rational(0, 2);
        r = r.power(1);
        Assert.assertEquals("Failed with raising to a positive power properly", "0", r.toString());
        r = new Rational(5, 2);
        r = r.power(1);
        Assert.assertEquals("Failed with raising to a positive power properly", "5/2", r.toString());
        r = new Rational(-7, 5);
        r = r.power(3);
        Assert.assertEquals("Failed with raising to a positive power properly", "-343/125", r.toString());
        r = new Rational(-7, 5);
        r = r.power(4);
        Assert.assertEquals("Failed with raising to a positive power properly", "2401/625", r.toString());
    }

    @Test
    public void power_negative_success() {
        r = new Rational(-3, 7);
        r = r.power(-4);
        Assert.assertEquals("Failed with raising to a negative power properly", "2401/81", r.toString());
        r = new Rational(-3, 7);
        r = r.power(-3);
        Assert.assertEquals("Failed with raising to a negative power properly", "-343/27", r.toString());
        r = new Rational(1, 1);
        r = r.power(-1);
        Assert.assertEquals("Failed with raising to a negative power properly", "1", r.toString());
        r = new Rational(-1, 1);
        r = r.power(-1);
        Assert.assertEquals("Failed with raising to a negative power properly", "-1", r.toString());
        r = new Rational(5, 2);
        r = r.power(-1);
        Assert.assertEquals("Failed with raising to a negative power properly", "2/5", r.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void negative_power_on_zero_fail() {
        r = new Rational(0, 1);
        r.power(-1);
    }

}
