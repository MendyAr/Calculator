public class Rational implements Scalar {
    //fields
    private int numerator;
    private int denominator;

    //constructors
    public Rational(int numerator, int denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("Denominator can't be 0");
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
        this.numerator = rational.numerator;
        this.denominator = rational.denominator;
    }

    //methods
    public String toString() {
        String string = String.valueOf(numerator);
        if (denominator != 1)
            string += "/" + denominator;
        return string;
    }

    public Rational reduce() {
        return new Rational(this);
    }


    @Override
    public Scalar add(Scalar s) {
        int index = s.toString().indexOf('/'); //indicator if the scalar is an Integer or Rational ('/' would appear in a rational scalar only)
        if (index == -1) //the scalar is an Integer
            return addInteger(new Integer(java.lang.Integer.parseInt(s.toString()))); //calling the addition with an Integer
        //else calling the addition with a Rational
        return addRational(new Rational(java.lang.Integer.parseInt(s.toString().substring(0, index)), //parsing with the toString form of S using the index of the slash to find the numerator and denominator
                java.lang.Integer.parseInt(s.toString().substring(index + 1))));
    }

    @Override
    public Scalar mul(Scalar s) {
        int index = s.toString().indexOf('/'); //indicator if the scalar is an Integer or Rational ('/' would appear in a rational scalar only)
        if (index == -1) //the scalar is an Integer
            return mulInteger(new Integer(java.lang.Integer.parseInt(s.toString()))); //calling the addition with an Integer
        //else calling the addition with a Rational
        return mulRational(new Rational(java.lang.Integer.parseInt(s.toString().substring(0, index)), //parsing with the toString form of S using the index of the slash to find the numerator and denominator
                java.lang.Integer.parseInt(s.toString().substring(index + 1))));
    }

    @Override
    public Scalar addRational(Rational s) {
        int lcm = lcm(denominator, s.denominator);
        return new Rational((numerator * (lcm / denominator)) + (s.numerator * (lcm / s.denominator)), lcm);
    }

    @Override
    public Scalar addInteger(Integer s) {
        return new Rational(java.lang.Integer.parseInt(s.toString()) * denominator + numerator, denominator);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return new Rational(numerator * s.numerator, denominator * s.denominator);
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Rational(java.lang.Integer.parseInt(s.toString()) * numerator, denominator);
    }

    @Override
    public Scalar power(int exponent) {
        int sign = 1; //will tell us the sign of the exponent
        if (exponent < 0) {
            sign = -1;
            exponent *= -1; //switching to the absolute value of the exponent
        }
        int numeratorExp = 1;
        int denominatorExp = 1;
        while (exponent != 0){
            numeratorExp *= numerator;
            denominatorExp *= denominatorExp;
            exponent--;
        }
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