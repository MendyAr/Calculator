package Polymath;

public class Rational implements Scalar {

    //fields

    private int numerator;
    private int denominator;

    //getters

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }


    //constructors

    public Rational(int numerator, int denominator) {
        if (denominator == 0)
            throw new ArithmeticException("Denominator can't be 0");
        //making sure the Rational number is already at its simplest form:

        if (denominator < 0) { //we want to use the absolute value of the given denominator as our denominator
            numerator *= -1; //so if the given denominator is a negative number we can multiply the numerator by -1 instead
            denominator *= -1; //switching denominator to its absolute value
        }
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    //copy constructor
    public Rational(Rational rational) {
        if (rational == null)
            throw new NullPointerException("Can't copy null");
        this.numerator = rational.numerator;
        this.denominator = rational.denominator;
    }

    //methods

    @Override
    public String toString() {
        String string = String.valueOf(numerator);
        if (denominator != 1) //will omit the denominator if it is 1
            string += "/" + denominator;
        return string;
    }

    public Rational reduce() {
        return new Rational(this);
    }


    @Override
    public Scalar add(Scalar s) {
        if (s == null)
            throw new NullPointerException("Can't add with null");
        //since we don't know the type of s but we know the type of this we will call s.addRational
        return s.addRational(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        if (s == null)
            throw new NullPointerException("Can't multiply by null");
        //since we don't know the type of s but we know the type of this we will call s.mulRational
        return s.mulRational(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        if (s == null)
            throw new NullPointerException("Can't add with null");
        int lcm = lcm(denominator, s.denominator);
        return new Rational((numerator * (lcm / denominator)) + (s.numerator * (lcm / s.denominator)), lcm);
    }

    @Override
    public Scalar addInteger(Integer s) {
        if (s == null)
            throw new NullPointerException("Can't add with null");
        return new Rational((s.getNumber() * denominator) + numerator, denominator);
    }

    @Override
    public Scalar mulRational(Rational s) {
        if (s == null)
            throw new NullPointerException("Can't multiply by null");
        return new Rational(numerator * s.numerator, denominator * s.denominator);
    }

    @Override
    public Scalar mulInteger(Integer s) {
        if (s == null)
            throw new NullPointerException("Can't multiply by null");
        return new Rational(s.getNumber() * numerator, denominator);
    }

    @Override
    public Scalar power(int exponent) {
        if (exponent == 0) //for every number x, x^0 = 1
            return new Integer(1);
        if (numerator == 0) //for every exponent a!=0, 0^a = 0
            return new Integer(0);

        boolean flip = false; //will tell us if we will need to flip the numerator and denominator
        if (exponent < 0) {
            flip = true;
            exponent *= -1; //switching to the absolute value of the exponent
        }
        int numeratorExp = 1;
        int denominatorExp = 1;
        while (exponent != 0) {
            numeratorExp *= numerator;
            denominatorExp *= denominator;
            exponent--;
        }
        if (flip)
            return new Rational(denominatorExp, numeratorExp);
        return new Rational(numeratorExp, denominatorExp);
    }

    @Override
    public int sign() {
        //since the Rational object is in it's simplest form the numerator will tell its sign
        if (numerator == 0) //a rational number will be 0 iff the numerator is 0
            return 0;
        if (numerator < 0)
            return -1;
        return 1;
    }

    @Override
    public Scalar neg() {
        return new Rational(-numerator, denominator);
    }

    //static functions

    //returns the greatest common divisor of integers a and b
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

    //returns the least common multiple of integers a and b
    private static int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return (a / gcd) * b;
    }
}