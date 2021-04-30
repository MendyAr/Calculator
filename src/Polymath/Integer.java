package Polymath;

public class Integer implements Scalar {

    // fields
    private int number;

    //getters

    public int getNumber() {
        return number;
    }

    // constructor

    public Integer(int number) {
        this.number = number;
    }

    // copy constructor
    public Integer(Integer I) {
        if (I == null)
            throw new NullPointerException("Can't copy null");
        this.number = I.number;
    }

    //  methods

    public Scalar add(Scalar s) {
        if (s == null)
            throw new NullPointerException("Can't add with null");
        return s.addInteger(this);
    }

    public Scalar mul(Scalar s) {
        if (s == null)
            throw new NullPointerException("Can't multiply by null");
        return s.mulInteger(this);
    }

    public Scalar addInteger(Integer s) {
        if (s == null)
            throw new NullPointerException("Can't add with null");
        return new Integer(number + s.number);
    }

    public Scalar addRational(Rational s) {
        if (s == null)
            throw new NullPointerException("Can't add with null");
        return new Rational(((s.getDenominator() * number) + s.getNumerator()), s.getDenominator());
    }

    public Scalar mulInteger(Integer s) {
        if (s == null)
            throw new NullPointerException("Can't multiply by null");
        return new Integer(number * s.number);
    }

    public Scalar mulRational(Rational s) {
        if (s == null)
            throw new NullPointerException("Can't multiply by null");
        return new Rational(s.getNumerator() * number, s.getDenominator());
    }

    public Scalar power(int exponent) {
        if (exponent == 0)
            return new Integer(1);
        // 0^a =   0     , when a >= 0
        //     = invalid , when a <  0,
        // in the last case exception will be thrown when the method try to create a new rational
        if (number == 0 & (exponent < 0))
            return new Integer(0);

        boolean flip = false;
        if (exponent < 0) {
            flip = true;
            exponent *= -1;
        }
        int newNum = 1;
        while (exponent != 0) {
            newNum *= number;
            exponent--;
        }
        if (flip)// in case the exponent was negative we have
            return new Rational(1, newNum);
        return new Integer(newNum);
    }

    public int sign() {
        if (number > 0)
            return 1;
        else if (number < 0)
            return -1;
        else
            return 0;
    }

    public Scalar neg() {
        return new Integer(-1 * number);
    }

    public String toString() {
        return String.valueOf(number);
    }
}