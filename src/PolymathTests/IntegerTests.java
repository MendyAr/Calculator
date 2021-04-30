package PolymathTests;

import Polymath.Integer;
import Polymath.Rational;
import Polymath.Scalar;

import org.junit.*;

public class IntegerTests {
    private static int gcd(int a, int b) {
        //making sure to work with positive numbers
        a = Math.abs(a);
        b = Math.abs(b);

        //making sure a>=b
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        //finding GCD using Euclid's algorithm
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    private Scalar i;

    @Test

    public void init_positiveInput_Success() {
        int integer = ((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1;
        i = new Integer(integer);
        Assert.assertEquals("Integer wasn't constructed properly", String.valueOf(integer), i.toString());
        integer = ((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1;
        i = new Integer(integer);
        Assert.assertEquals("Integer wasn't constructed properly", String.valueOf(integer), i.toString());
        integer = ((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1;
        i = new Integer(integer);
        Assert.assertEquals("Integer wasn't constructed properly", String.valueOf(integer), i.toString());
    }

    @Test
    public void init_zeroInput_Success() {
        i = new Integer(0);
        Assert.assertEquals("Integer wasn't constructed properly", "0", i.toString());
    }

    @Test
    public void init_negativeInput_Success() {
        int integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        Assert.assertEquals("Integer wasn't constructed properly", String.valueOf(integer), i.toString());
        integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        Assert.assertEquals("Integer wasn't constructed properly", String.valueOf(integer), i.toString());
        integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        Assert.assertEquals("Integer wasn't constructed properly", String.valueOf(integer), i.toString());
    }

    @Test(expected = NullPointerException.class)
    public void init_copy_Fail() {
        Integer n = null;
        i = new Integer(n);
        Assert.fail("Construction of Integer from null argument should result in an exception");
    }

    @Test
    public void init_copyPositive_Success() {
        int integer = ((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1;
        Integer n = new Integer(integer);
        i = new Integer(n);
        Assert.assertEquals("Integer wasn't copied properly", n.toString(), i.toString());
        integer = ((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1;
        n = new Integer(integer);
        i = new Integer(n);
        Assert.assertEquals("Integer wasn't copied properly", n.toString(), i.toString());
        integer = ((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1;
        n = new Integer(integer);
        i = new Integer(n);
        Assert.assertEquals("Integer wasn't copied properly", n.toString(), i.toString());
    }

    @Test
    public void init_copyZero_Success() {
        Integer n = new Integer(0);
        i = new Integer(n);
        Assert.assertEquals("Integer wasn't copied properly", n.toString(), i.toString());
    }

    @Test
    public void init_copyNegative_Success() {
        int integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        Integer n = new Integer(integer);
        i = new Integer(n);
        Assert.assertEquals("Integer wasn't copied properly", n.toString(), i.toString());
        integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        n = new Integer(integer);
        i = new Integer(n);
        Assert.assertEquals("Integer wasn't copied properly", n.toString(), i.toString());
        integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        n = new Integer(integer);
        i = new Integer(n);
        Assert.assertEquals("Integer wasn't copied properly", n.toString(), i.toString());
    }

    @Test
    public void sign_positive_Success() {
        int integer = ((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1;
        i = new Integer(integer);
        Assert.assertEquals("Bad assessment of sign of " + integer, 1, i.sign());
        integer = ((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1;
        i = new Integer(integer);
        Assert.assertEquals("Bad assessment of sign of " + integer, 1, i.sign());
        integer = ((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1;
        i = new Integer(integer);
        Assert.assertEquals("Bad assessment of sign of " + integer, 1, i.sign());
    }

    @Test
    public void sign_zero_Success() {
        i = new Integer(0);
        Assert.assertEquals("Bad assessment of sign of 0", 0, i.sign());
    }

    @Test
    public void sign_negative_Success() {
        int integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        Assert.assertEquals("Bad assessment of sign of " + integer, -1, i.sign());
        integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        Assert.assertEquals("Bad assessment of sign of " + integer, -1, i.sign());
        integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        Assert.assertEquals("Bad assessment of sign of " + integer, -1, i.sign());
    }

    @Test
    public void neg_positive_Success() {
        int integer = ((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1;
        i = new Integer(integer);
        i = i.neg();
        Assert.assertEquals("Integer wasn't negated properly", String.valueOf(-integer), i.toString());
        integer = ((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1;
        i = new Integer(integer);
        i = i.neg();
        Assert.assertEquals("Integer wasn't negated properly", String.valueOf(-integer), i.toString());
        integer = ((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1;
        i = new Integer(integer);
        i = i.neg();
        Assert.assertEquals("Integer wasn't negated properly", String.valueOf(-integer), i.toString());
        integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        i = i.neg();
        Assert.assertEquals("Integer wasn't negated properly", String.valueOf(-integer), i.toString());
    }

    @Test
    public void neg_zero_Success() {
        i = new Integer(0);
        i = i.neg();
        Assert.assertEquals("Integer wasn't negated properly", String.valueOf(-0), i.toString());
    }

    @Test
    public void neg_negative_Success() {
        int integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        i = i.neg();
        Assert.assertEquals("Integer wasn't negated properly", String.valueOf(-integer), i.toString());
        integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        i = i.neg();
        Assert.assertEquals("Integer wasn't negated properly", String.valueOf(-integer), i.toString());
        integer = -(((int) (Math.random() * (java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        i = i.neg();
        Assert.assertEquals("Integer wasn't negated properly", String.valueOf(-integer), i.toString());
    }

    @Test(expected = NullPointerException.class)
    public void addInteger_null_Fail() {
        int integer = (int) (Math.random() * 1000000000) - 500000000;
        i = new Integer(integer);
        i = i.addInteger(null);
        Assert.fail("When trying to add with null a NullPointerException should be thrown");
    }

    @Test
    public void addInteger_PositiveToPositive_Success() {
        int integer = (int) (Math.random() * 1000000000) + 1;
        i = new Integer(integer);
        int integer2 = (int) (Math.random() * 1000000000) + 1;
        Integer n = new Integer(integer2);
        Scalar addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer = (int) (Math.random() * 1000000000) + 1;
        i = new Integer(integer);
        integer2 = (int) (Math.random() * 1000000000) + 1;
        n = new Integer(integer2);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer = (int) (Math.random() * 1000000000) + 1;
        i = new Integer(integer);
        integer2 = (int) (Math.random() * 1000000000) + 1;
        n = new Integer(integer2);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
    }

    @Test
    public void addInteger_PositiveToZero_Success() {
        int integer = (int) (Math.random() * 1000000000) + 1;
        i = new Integer(integer);
        int integer2 = 0;
        Integer n = new Integer(integer2);
        Scalar addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer = (int) (Math.random() * 1000000000) + 1;
        i = new Integer(integer);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer = (int) (Math.random() * 1000000000) + 1;
        i = new Integer(integer);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
    }

    @Test
    public void addInteger_PositiveToNegative_Success() {
        int integer = (int) (Math.random() * 1000000000) + 1;
        i = new Integer(integer);
        int integer2 = -((int) (Math.random() * 1000000000) + 1);
        Integer n = new Integer(integer2);
        Scalar addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer = (int) (Math.random() * 1000000000) + 1;
        i = new Integer(integer);
        integer2 = -((int) (Math.random() * 1000000000) + 1);
        n = new Integer(integer2);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer = (int) (Math.random() * 1000000000) + 1;
        i = new Integer(integer);
        integer2 = -((int) (Math.random() * 1000000000) + 1);
        n = new Integer(integer2);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
    }

    @Test
    public void addInteger_ZeroToPositive_Success() {
        int integer = 0;
        i = new Integer(integer);
        int integer2 = (int) (Math.random() * 1000000000) + 1;
        Integer n = new Integer(integer2);
        Scalar addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer2 = (int) (Math.random() * 1000000000) + 1;
        n = new Integer(integer2);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer2 = (int) (Math.random() * 1000000000) + 1;
        n = new Integer(integer2);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
    }

    @Test
    public void addInteger_ZeroToZero_Success() {
        int integer = 0;
        i = new Integer(integer);
        int integer2 = 0;
        Integer n = new Integer(integer2);
        Scalar addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
    }

    @Test
    public void addInteger_ZeroToNegative_Success() {
        int integer = 0;
        i = new Integer(integer);
        int integer2 = -((int) (Math.random() * 1000000000) + 1);
        Integer n = new Integer(integer2);
        Scalar addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer2 = -((int) (Math.random() * 1000000000) + 1);
        n = new Integer(integer2);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer2 = -((int) (Math.random() * 1000000000) + 1);
        n = new Integer(integer2);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
    }

    @Test
    public void addInteger_NegativeToPositive_Success() {
        int integer = -((int) (Math.random() * 1000000000) + 1);
        i = new Integer(integer);
        int integer2 = (int) (Math.random() * 1000000000) + 1;
        Integer n = new Integer(integer2);
        Scalar addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer = -((int) (Math.random() * 1000000000) + 1);
        i = new Integer(integer);
        integer2 = (int) (Math.random() * 1000000000) + 1;
        n = new Integer(integer2);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer = -((int) (Math.random() * 1000000000) + 1);
        i = new Integer(integer);
        integer2 = (int) (Math.random() * 1000000000) + 1;
        n = new Integer(integer2);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
    }

    @Test
    public void addInteger_NegativeToZero_Success() {
        int integer = -((int) (Math.random() * 1000000000) + 1);
        i = new Integer(integer);
        int integer2 = 0;
        Integer n = new Integer(integer2);
        Scalar addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer = -((int) (Math.random() * 1000000000) + 1);
        i = new Integer(integer);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer = -((int) (Math.random() * 1000000000) + 1);
        i = new Integer(integer);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
    }

    @Test
    public void addInteger_NegativeToNegative_Success() {
        int integer = -((int) (Math.random() * 1000000000) + 1);
        i = new Integer(integer);
        int integer2 = -((int) (Math.random() * 1000000000) + 1);
        Integer n = new Integer(integer2);
        Scalar addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer = -((int) (Math.random() * 1000000000) + 1);
        i = new Integer(integer);
        integer2 = -((int) (Math.random() * 1000000000) + 1);
        n = new Integer(integer2);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
        integer = -((int) (Math.random() * 1000000000) + 1);
        i = new Integer(integer);
        integer2 = -((int) (Math.random() * 1000000000) + 1);
        n = new Integer(integer2);
        addition = i.addInteger(n);
        Assert.assertEquals("Didn't add integers properly", String.valueOf(integer + integer2), addition.toString());
    }

    @Test(expected = NullPointerException.class)
    public void mulInteger_null_Fail() {
        int integer = (int) (Math.random() * 1000000000) - 500000000;
        i = new Integer(integer);
        i = i.mulInteger(null);
        Assert.fail("When trying to add with null a NullPointerException should be thrown");
    }

    @Test
    public void mulInteger_PositiveToPositive_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int integer2 = (int) (Math.random() * 100) + 1;
        Integer n = new Integer(integer2);
        Scalar multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(integer * integer2), multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        integer2 = (int) (Math.random() * 100) + 1;
        n = new Integer(integer2);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(integer * integer2), multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        integer2 = (int) (Math.random() * 100) + 1;
        n = new Integer(integer2);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(integer * integer2), multiplication.toString());
    }

    @Test
    public void mulInteger_PositiveToZero_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int integer2 = 0;
        Integer n = new Integer(integer2);
        Scalar multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulInteger_PositiveToNegative_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int integer2 = -((int) (Math.random() * 100) + 1);
        Integer n = new Integer(integer2);
        Scalar multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(integer * integer2), multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        integer2 = -((int) (Math.random() * 100) + 1);
        n = new Integer(integer2);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(integer * integer2), multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        integer2 = -((int) (Math.random() * 100) + 1);
        n = new Integer(integer2);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(integer * integer2), multiplication.toString());
    }

    @Test
    public void mulInteger_ZeroToPositive_Success() {
        int integer = 0;
        i = new Integer(integer);
        int integer2 = (int) (Math.random() * 100) + 1;
        Integer n = new Integer(integer2);
        Scalar multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
        integer2 = (int) (Math.random() * 100) + 1;
        n = new Integer(integer2);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
        integer2 = (int) (Math.random() * 100) + 1;
        n = new Integer(integer2);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulInteger_ZeroToZero_Success() {
        int integer = 0;
        i = new Integer(integer);
        int integer2 = 0;
        Integer n = new Integer(integer2);
        Scalar multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulInteger_ZeroToNegative_Success() {
        int integer = 0;
        i = new Integer(integer);
        int integer2 = -((int) (Math.random() * 100) + 1);
        Integer n = new Integer(integer2);
        Scalar multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
        integer2 = -((int) (Math.random() * 100) + 1);
        n = new Integer(integer2);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
        integer2 = -((int) (Math.random() * 100) + 1);
        n = new Integer(integer2);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulInteger_NegativeToPositive_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int integer2 = (int) (Math.random() * 100) + 1;
        Integer n = new Integer(integer2);
        Scalar multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(integer * integer2), multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        integer2 = (int) (Math.random() * 100) + 1;
        n = new Integer(integer2);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(integer * integer2), multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        integer2 = (int) (Math.random() * 100) + 1;
        n = new Integer(integer2);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(integer * integer2), multiplication.toString());
    }

    @Test
    public void mulInteger_NegativeToZero_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int integer2 = 0;
        Integer n = new Integer(integer2);
        Scalar multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulInteger_NegativeToNegative_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int integer2 = -((int) (Math.random() * 100) + 1);
        Integer n = new Integer(integer2);
        Scalar multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(integer * integer2), multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        integer2 = -((int) (Math.random() * 100) + 1);
        n = new Integer(integer2);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(integer * integer2), multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        integer2 = -((int) (Math.random() * 100) + 1);
        n = new Integer(integer2);
        multiplication = i.mulInteger(n);
        Assert.assertEquals("Didn't multiply integers properly", String.valueOf(integer * integer2), multiplication.toString());
    }

    @Test(expected = NullPointerException.class)
    public void addRational_null_Fail() {
        int integer = (int) (Math.random() * 1000000000) - 500000000;
        i = new Integer(integer);
        i = i.addRational(null);
        Assert.fail("When trying to add with null a NullPointerException should be thrown");
    }

    @Test
    public void addRational_PositiveToPositive_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int numerator = (int) (Math.random() * 100) + 1;
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        int gcd = gcd(integer * denominator + numerator, denominator);
        String expectedNumerator = String.valueOf((integer * denominator + numerator) / gcd);
        String expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf((integer * denominator + numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf((integer * denominator + numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
    }

    @Test
    public void addRational_PositiveToPositive2_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int numerator = -((int) (Math.random() * 100) + 1);
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        int gcd = gcd(integer * denominator + numerator, denominator);
        String expectedNumerator = String.valueOf(-((integer * denominator + numerator) / gcd));
        String expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * denominator + numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * denominator + numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
    }

    @Test
    public void addRational_PositiveToZero_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int numerator = 0;
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(integer), addition.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(integer), addition.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(integer), addition.toString());
    }

    @Test
    public void addRational_PositiveToZero2_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int numerator = 0;
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(integer), addition.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(integer), addition.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(integer), addition.toString());
    }

    @Test
    public void addRational_PositiveToNegative_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int numerator = -((int) (Math.random() * 100) + 1);
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        int gcd = gcd(integer * denominator + numerator, denominator);
        String expectedNumerator = String.valueOf((integer * denominator + numerator) / gcd);
        String expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf((integer * denominator + numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf((integer * denominator + numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
    }

    @Test
    public void addRational_PositiveToNegative2_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int numerator = (int) (Math.random() * 100) + 1;
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        int gcd = gcd(integer * denominator + numerator, denominator);
        String expectedNumerator = String.valueOf(-((integer * denominator + numerator) / gcd));
        String expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * denominator + numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * denominator + numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
    }

    @Test
    public void addRational_ZeroToPositive_Success() {
        int integer = 0;
        i = new Integer(integer);
        int numerator = (int) (Math.random() * 100) + 1;
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        int gcd = gcd(numerator, denominator);
        String expectedNumerator = String.valueOf((numerator) / gcd);
        String expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        numerator = (int) (Math.random() * 100) + 1;
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(numerator, denominator);
        expectedNumerator = String.valueOf((numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        numerator = (int) (Math.random() * 100) + 1;
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(numerator, denominator);
        expectedNumerator = String.valueOf((numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
    }

    @Test
    public void addRational_ZeroToPositive2_Success() {
        int integer = 0;
        i = new Integer(integer);
        int numerator = -((int) (Math.random() * 100) + 1);
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        int gcd = gcd(numerator, denominator);
        String expectedNumerator = String.valueOf(-((numerator) / gcd));
        String expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(numerator, denominator);
        expectedNumerator = String.valueOf(-((numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(numerator, denominator);
        expectedNumerator = String.valueOf(-((numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
    }

    @Test
    public void addRational_ZeroToZero_Success() {
        int integer = 0;
        i = new Integer(integer);
        int numerator = 0;
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(0), addition.toString());
    }

    @Test
    public void addRational_ZeroToZero2_Success() {
        int integer = 0;
        i = new Integer(integer);
        int numerator = 0;
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(0), addition.toString());
    }

    @Test
    public void addRational_ZeroToNegative_Success() {
        int integer = 0;
        i = new Integer(integer);
        int numerator = -((int) (Math.random() * 100) + 1);
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        int gcd = gcd(numerator, denominator);
        String expectedNumerator = String.valueOf((numerator) / gcd);
        String expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(numerator, denominator);
        expectedNumerator = String.valueOf((numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(numerator, denominator);
        expectedNumerator = String.valueOf((numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
    }

    @Test
    public void addRational_ZeroToNegative2_Success() {
        int integer = 0;
        i = new Integer(integer);
        int numerator = (int) (Math.random() * 100) + 1;
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        int gcd = gcd(numerator, denominator);
        String expectedNumerator = String.valueOf(-((numerator) / gcd));
        String expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        numerator = (int) (Math.random() * 100) + 1;
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(numerator, denominator);
        expectedNumerator = String.valueOf(-((numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        numerator = (int) (Math.random() * 100) + 1;
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(numerator, denominator);
        expectedNumerator = String.valueOf(-((numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
    }

    @Test
    public void addRational_NegativeToPositive_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int numerator = (int) (Math.random() * 100) + 1;
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        int gcd = gcd(integer * denominator + numerator, denominator);
        String expectedNumerator = String.valueOf((integer * denominator + numerator) / gcd);
        String expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf((integer * denominator + numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf((integer * denominator + numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
    }

    @Test
    public void addRational_NegativeToPositive2_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int numerator = -((int) (Math.random() * 100) + 1);
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        int gcd = gcd(integer * denominator + numerator, denominator);
        String expectedNumerator = String.valueOf(-((integer * denominator + numerator) / gcd));
        String expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * denominator + numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * denominator + numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
    }

    @Test
    public void addRational_NegativeToZero_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int numerator = 0;
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(integer), addition.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(integer), addition.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(integer), addition.toString());
    }

    @Test
    public void addRational_NegativeToZero2_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int numerator = 0;
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(integer), addition.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(integer), addition.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        Assert.assertEquals("Didn't add integer to rational properly", String.valueOf(integer), addition.toString());
    }

    @Test
    public void addRational_NegativeToNegative_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int numerator = -((int) (Math.random() * 100) + 1);
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        int gcd = gcd(integer * denominator + numerator, denominator);
        String expectedNumerator = String.valueOf((integer * denominator + numerator) / gcd);
        String expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf((integer * denominator + numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf((integer * denominator + numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
    }

    @Test
    public void addRational_NegativeToNegative2_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int numerator = (int) (Math.random() * 100) + 1;
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar addition = i.addRational(r);
        int gcd = gcd(integer * denominator + numerator, denominator);
        String expectedNumerator = String.valueOf(-((integer * denominator + numerator) / gcd));
        String expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * denominator + numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        addition = i.addRational(r);
        gcd = gcd(integer * denominator + numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * denominator + numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator, addition.toString());
        else
            Assert.assertEquals("Didn't add integer to rational properly", expectedNumerator + "/" + expectedDenominator, addition.toString());
    }

    @Test(expected = NullPointerException.class)
    public void mulRational_null_Fail() {
        int integer = (int) (Math.random() * 1000000000) - 500000000;
        i = new Integer(integer);
        i = i.mulRational(null);
        Assert.fail("When trying to multiply with null a NullPointerException should be thrown");
    }

    @Test
    public void mulRational_PositiveToPositive_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int numerator = (int) (Math.random() * 100) + 1;
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        int gcd = gcd(integer * numerator, denominator);
        String expectedNumerator = String.valueOf((integer * numerator) / gcd);
        String expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf((integer * numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf((integer * numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
    }

    @Test
    public void mulRational_PositiveToPositive2_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int numerator = -((int) (Math.random() * 100) + 1);
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        int gcd = gcd(integer * numerator, denominator);
        String expectedNumerator = String.valueOf(-((integer * numerator) / gcd));
        String expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
    }

    @Test
    public void mulRational_PositiveToZero_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int numerator = 0;
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulRational_PositiveToZero2_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int numerator = 0;
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulRational_PositiveToNegative_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int numerator = -((int) (Math.random() * 100) + 1);
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        int gcd = gcd(integer * numerator, denominator);
        String expectedNumerator = String.valueOf((integer * numerator) / gcd);
        String expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf((integer * numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf((integer * numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
    }

    @Test
    public void mulRational_PositiveToNegative2_Success() {
        int integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        int numerator = (int) (Math.random() * 100) + 1;
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        int gcd = gcd(integer * numerator, denominator);
        String expectedNumerator = String.valueOf(-((integer * numerator) / gcd));
        String expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = (int) (Math.random() * 100) + 1;
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
    }

    @Test
    public void mulRational_ZeroToPositive_Success() {
        int integer = 0;
        i = new Integer(integer);
        int numerator = (int) (Math.random() * 100) + 1;
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        numerator = (int) (Math.random() * 100) + 1;
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        numerator = (int) (Math.random() * 100) + 1;
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulRational_ZeroToPositive2_Success() {
        int integer = 0;
        i = new Integer(integer);
        int numerator = -((int) (Math.random() * 100) + 1);
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulRational_ZeroToZero_Success() {
        int integer = 0;
        i = new Integer(integer);
        int numerator = 0;
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulRational_ZeroToZero2_Success() {
        int integer = 0;
        i = new Integer(integer);
        int numerator = 0;
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulRational_ZeroToNegative_Success() {
        int integer = 0;
        i = new Integer(integer);
        int numerator = -((int) (Math.random() * 100) + 1);
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulRational_ZeroToNegative2_Success() {
        int integer = 0;
        i = new Integer(integer);
        int numerator = (int) (Math.random() * 100) + 1;
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        numerator = (int) (Math.random() * 100) + 1;
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        numerator = (int) (Math.random() * 100) + 1;
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulRational_NegativeToPositive_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int numerator = (int) (Math.random() * 100) + 1;
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        int gcd = gcd(integer * numerator, denominator);
        String expectedNumerator = String.valueOf((integer * numerator) / gcd);
        String expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf((integer * numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf((integer * numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
    }

    @Test
    public void mulRational_NegativeToPositive2_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int numerator = -((int) (Math.random() * 100) + 1);
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        int gcd = gcd(integer * numerator, denominator);
        String expectedNumerator = String.valueOf(-((integer * numerator) / gcd));
        String expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
    }

    @Test
    public void mulRational_NegativeToZero_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int numerator = 0;
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulRational_NegativeToZero2_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int numerator = 0;
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        Assert.assertEquals("Didn't multiply integer to rational properly", String.valueOf(0), multiplication.toString());
    }

    @Test
    public void mulRational_NegativeToNegative_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int numerator = -((int) (Math.random() * 100) + 1);
        int denominator = (int) (Math.random() * 100) + 1;
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        int gcd = gcd(integer * numerator, denominator);
        String expectedNumerator = String.valueOf((integer * numerator) / gcd);
        String expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf((integer * numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = -((int) (Math.random() * 100) + 1);
        denominator = (int) (Math.random() * 100) + 1;
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf((integer * numerator) / gcd);
        expectedDenominator = String.valueOf(denominator / gcd);
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
    }

    @Test
    public void mulRational_NegativeToNegative2_Success() {
        int integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        int numerator = (int) (Math.random() * 100) + 1;
        int denominator = -((int) (Math.random() * 100) + 1);
        Rational r = new Rational(numerator, denominator);
        Scalar multiplication = i.mulRational(r);
        int gcd = gcd(integer * numerator, denominator);
        String expectedNumerator = String.valueOf(-((integer * numerator) / gcd));
        String expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
        integer = -((int) (Math.random() * 100) + 1);
        i = new Integer(integer);
        numerator = (int) (Math.random() * 100) + 1;
        denominator = -((int) (Math.random() * 100) + 1);
        r = new Rational(numerator, denominator);
        multiplication = i.mulRational(r);
        gcd = gcd(integer * numerator, denominator);
        expectedNumerator = String.valueOf(-((integer * numerator) / gcd));
        expectedDenominator = String.valueOf(-(denominator / gcd));
        if (expectedDenominator.equals("1"))
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator, multiplication.toString());
        else
            Assert.assertEquals("Didn't multiply integer to rational properly", expectedNumerator + "/" + expectedDenominator, multiplication.toString());
    }

    @Test(expected = NullPointerException.class)
    public void add_null_Fail() {
        int integer = (int) (Math.random() * 1000000000) - 500000000;
        i = new Integer(integer);
        i = i.add(null);
        Assert.fail("When trying to add with null a NullPointerException should be thrown");
    }

    @Test
    public void add_Integer_Success() {
        i = new Integer(5);
        Integer n = new Integer(1);
        Scalar addition = i.add(n);
        Assert.assertTrue("Addition of two integers should return an Integer", addition instanceof Integer);
    }

    @Test
    public void add_Rational_Success() {
        i = new Integer(5);
        Rational r = new Rational(1, 2);
        Scalar addition = i.add(r);
        Assert.assertTrue("Addition of an integer with a rational should return a Rational", addition instanceof Rational);
    }

    @Test(expected = NullPointerException.class)
    public void mul_null_Fail() {
        int integer = (int) (Math.random() * 1000000000) - 500000000;
        i = new Integer(integer);
        i = i.mul(null);
        Assert.fail("When trying to multiply with null a NullPointerException should be thrown");
    }

    @Test
    public void mul_Integer_Success() {
        i = new Integer(5);
        Integer n = new Integer(1);
        Scalar multiplication = i.mul(n);
        Assert.assertTrue("Multiplication of two integers should return an Integer", multiplication instanceof Integer);
    }

    @Test
    public void mul_Rational_Success() {
        i = new Integer(5);
        Rational r = new Rational(1, 2);
        Scalar multiplication = i.mul(r);
        Assert.assertTrue("Multiplication of an integer with a rational should return a Rational", multiplication instanceof Rational);
    }

    @Test
    public void power_PositiveToPositive_Success() {
        int integer = (int) (Math.random() * 10) + 1;
        i = new Integer((integer));
        int power = (int) (Math.random() * 8) + 1;
        Scalar exponent = i.power(power);
        int expectedExponent = 1;
        while (power != 0) {
            expectedExponent *= integer;
            power--;
        }
        Assert.assertEquals("Didn't power integer correctly", String.valueOf(expectedExponent), exponent.toString());
        integer = (int) (Math.random() * 10) + 1;
        i = new Integer((integer));
        power = (int) (Math.random() * 8) + 1;
        exponent = i.power(power);
        expectedExponent = 1;
        while (power != 0) {
            expectedExponent *= integer;
            power--;
        }
        Assert.assertEquals("Didn't power integer correctly", String.valueOf(expectedExponent), exponent.toString());
        integer = (int) (Math.random() * 10) + 1;
        i = new Integer((integer));
        power = (int) (Math.random() * 8) + 1;
        exponent = i.power(power);
        expectedExponent = 1;
        while (power != 0) {
            expectedExponent *= integer;
            power--;
        }
        Assert.assertEquals("Didn't power integer correctly", String.valueOf(expectedExponent), exponent.toString());
    }

    @Test
    public void power_PositiveToZero_Success() {
        int integer = (int) (Math.random() * 10) + 1;
        i = new Integer((integer));
        Scalar exponent = i.power(0);
        Assert.assertEquals("Anything to the power of 0 is 1", String.valueOf(1), exponent.toString());
        integer = (int) (Math.random() * 10) + 1;
        i = new Integer((integer));
        exponent = i.power(0);
        Assert.assertEquals("Anything to the power of 0 is 1", String.valueOf(1), exponent.toString());
        integer = (int) (Math.random() * 10) + 1;
        i = new Integer((integer));
        exponent = i.power(0);
        Assert.assertEquals("Anything to the power of 0 is 1", String.valueOf(1), exponent.toString());
    }

    @Test
    public void power_PositiveToNegative_Success() {
        int integer = (int) (Math.random() * 10) + 1;
        i = new Integer((integer));
        int power = -((int) (Math.random() * 8) + 1);
        Scalar exponent = i.power(power);
        int expectedExponent = 1;
        while (power != 0) {
            expectedExponent *= integer;
            power++;
        }
        if (expectedExponent == 1)
            Assert.assertEquals("Didn't power integer correctly", String.valueOf(1), exponent.toString());
        else
            Assert.assertEquals("Didn't power integer correctly", String.valueOf(1) + "/" + String.valueOf(expectedExponent), exponent.toString());
        integer = (int) (Math.random() * 10) + 1;
        i = new Integer((integer));
        power = -((int) (Math.random() * 8) + 1);
        exponent = i.power(power);
        expectedExponent = 1;
        while (power != 0) {
            expectedExponent *= integer;
            power++;
        }
        if (expectedExponent == 1)
            Assert.assertEquals("Didn't power integer correctly", String.valueOf(1), exponent.toString());
        else
            Assert.assertEquals("Didn't power integer correctly", String.valueOf(1) + "/" + String.valueOf(expectedExponent), exponent.toString());
        integer = (int) (Math.random() * 10) + 1;
        i = new Integer((integer));
        power = -((int) (Math.random() * 8) + 1);
        exponent = i.power(power);
        expectedExponent = 1;
        while (power != 0) {
            expectedExponent *= integer;
            power++;
        }
        if (expectedExponent == 1)
            Assert.assertEquals("Didn't power integer correctly", String.valueOf(1), exponent.toString());
        else
            Assert.assertEquals("Didn't power integer correctly", String.valueOf(1) + "/" + String.valueOf(expectedExponent), exponent.toString());
    }

    @Test
    public void power_ZeroToPositive_Success() {
        i = new Integer(0);
        int power = (int) (Math.random() * 1000000) + 1;
        Scalar exponent = i.power(power);
        Assert.assertEquals("Zero to any positive power should be 0", String.valueOf(0), exponent.toString());
        power = (int) (Math.random() * 1000000);
        exponent = i.power(power);
        Assert.assertEquals("Zero to any non-negative power should be 0", String.valueOf(0), exponent.toString());
        power = (int) (Math.random() * 1000000);
        exponent = i.power(power);
        Assert.assertEquals("Zero to any non-negative power should be 0", String.valueOf(0), exponent.toString());
    }

    @Test
    public void power_ZeroToZero_Success() {
        i = new Integer(0);
        Scalar exponent = i.power(0);
        Assert.assertEquals("Anything to the power of 0 should be 1", String.valueOf(1), exponent.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void power_ZeroToNegative_Success() {
        i = new Integer(0);
        int power = -((int) (Math.random() * 1000000) + 1);
        Scalar exponent = i.power(power);
        Assert.fail("Zero to any negative power should throw an ArithmeticException");
    }

    @Test
    public void power_NegativeToPositive() {
        int integer = -((int) (Math.random() * 10) + 1);
        i = new Integer((integer));
        int power = (int) (Math.random() * 8) + 1;
        Scalar exponent = i.power(power);
        int expectedExponent = 1;
        while (power != 0) {
            expectedExponent *= integer;
            power--;
        }
        Assert.assertEquals("Didn't power integer correctly", String.valueOf(expectedExponent), exponent.toString());
        integer = -((int) (Math.random() * 10) + 1);
        i = new Integer((integer));
        power = (int) (Math.random() * 8) + 1;
        exponent = i.power(power);
        expectedExponent = 1;
        while (power != 0) {
            expectedExponent *= integer;
            power--;
        }
        Assert.assertEquals("Didn't power integer correctly", String.valueOf(expectedExponent), exponent.toString());
        integer = -((int) (Math.random() * 10) + 1);
        i = new Integer((integer));
        power = (int) (Math.random() * 8) + 1;
        exponent = i.power(power);
        expectedExponent = 1;
        while (power != 0) {
            expectedExponent *= integer;
            power--;
        }
        Assert.assertEquals("Didn't power integer correctly", String.valueOf(expectedExponent), exponent.toString());
    }

    @Test
    public void power_NegativeToZero_Success() {
        int integer = -((int) (Math.random() * 10) + 1);
        i = new Integer((integer));
        Scalar exponent = i.power(0);
        Assert.assertEquals("Anything to the power of 0 is 1", String.valueOf(1), exponent.toString());
        integer = -((int) (Math.random() * 10) + 1);
        i = new Integer((integer));
        exponent = i.power(0);
        Assert.assertEquals("Anything to the power of 0 is 1", String.valueOf(1), exponent.toString());
        integer = -((int) (Math.random() * 10) + 1);
        i = new Integer((integer));
        exponent = i.power(0);
        Assert.assertEquals("Anything to the power of 0 is 1", String.valueOf(1), exponent.toString());
    }

    @Test
    public void power_NegativeToNegative_Success() {
        int integer = -((int) (Math.random() * 10) + 1);
        i = new Integer((integer));
        int power = -((int) (Math.random() * 8) + 1);
        Scalar exponent = i.power(power);
        int expectedExponent = 1;
        while (power != 0) {
            expectedExponent *= integer;
            power++;
        }
        if (expectedExponent > 0) {
            if (expectedExponent == 1)
                Assert.assertEquals("Didn't power integer correctly", String.valueOf(1), exponent.toString());
            else
                Assert.assertEquals("Didn't power integer correctly", String.valueOf(1) + "/" + String.valueOf(expectedExponent), exponent.toString());
        } else {
            if (expectedExponent == -1)
                Assert.assertEquals("Didn't power integer correctly", String.valueOf(-1), exponent.toString());
            else
                Assert.assertEquals("Didn't power integer correctly", String.valueOf(-1) + "/" + String.valueOf(-expectedExponent), exponent.toString());
        }
        integer = -((int) (Math.random() * 10) + 1);
        i = new Integer((integer));
        power = -((int) (Math.random() * 8) + 1);
        exponent = i.power(power);
        expectedExponent = 1;
        while (power != 0) {
            expectedExponent *= integer;
            power++;
        }
        integer = -((int) (Math.random() * 10) + 1);
        i = new Integer((integer));
        power = -((int) (Math.random() * 8) + 1);
        exponent = i.power(power);
        expectedExponent = 1;
        while (power != 0) {
            expectedExponent *= integer;
            power++;
        }
    }
}