package Polymath;

public class Monomial {

    //fields
    private int exponent;
    private Scalar coefficient;

    // getters
    public int getExponent() {
        return exponent;
    }

    // constructors
    public Monomial(Scalar coefficient, int exponent) {
        if (exponent < 0)
            throw new IllegalArgumentException("Exponent can't be negative");
        if (coefficient == null)
            throw new NullPointerException("Can't create a monomial with null scalar");

        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public Monomial(String coefficient, int exponent) {
        if (exponent < 0)
            throw new IllegalArgumentException("Exponent can't be negative");
        if (coefficient == null)
            throw new NullPointerException("Can't create a monomial with null scalar");

        this.exponent = exponent;
        // check if the string represents a rational number
        if (coefficient.indexOf('/') != -1) {
            String[] R = coefficient.split("/");
            try {
                this.coefficient = new Rational(java.lang.Integer.parseInt(R[0]), java.lang.Integer.parseInt(R[1]));
            } catch (Exception e) {
                throw new IllegalArgumentException("The string input isn't valid");
            }
        } else {
            try {
                this.coefficient = new Integer(java.lang.Integer.parseInt(coefficient.toString()));
            } catch (Exception e) {
                throw new IllegalArgumentException("The string input isn't valid");
            }
        }
    }

    // copy constructor
    public Monomial(Monomial m) {
        if (m == null)
            throw new NullPointerException("Can't copy null");

        this.exponent = m.exponent;
        this.coefficient = m.coefficient;
    }

    // methods

    public Monomial add(Monomial m) {
        if (m == null)
            throw new NullPointerException("Can't add null monomial");

        // we can't sum two monomial with different exponents into one monomial
        if (exponent != m.exponent)
            return null;
        return new Monomial(coefficient.add(m.coefficient), exponent);
    }

    public Monomial mult(Monomial m) {
        if (m == null)
            throw new NullPointerException("Can't multiply null monomial");
        return new Monomial(coefficient.mul(m.coefficient), exponent + m.exponent);
    }

    public Scalar evaluate(Scalar s) {
        if (s == null)
            throw new NullPointerException("Can't evaluate with null scalar");
        return coefficient.mul(s.power(exponent));
    }

    public Monomial derivative() {
        // in case where the exponent is 0 so the new monomial is 0,
        // monomial can't have -1 exponent thus return a new monomial with coefficient 0 and exponent 0.
        // this shouldn't change the behavior of the new Monomial since its coefficient is 0
        if (exponent == 0)
            return new Monomial(new Integer(0), 0);

        Scalar newCoefficient = coefficient.mulInteger(new Integer((exponent)));
        return new Monomial(newCoefficient, exponent - 1);
    }

    public int sign() {
        return coefficient.sign();
    }

    public String toString() {
        // 0*x^a -> "0"
        if (coefficient.sign() == 0)
            return "0";
        // a*x^0 -> "a"
        if (exponent == 0)
            return coefficient.toString();

        String output = coefficient.toString();
        // check if the scalar equals 1 and if so don't include its value,
        // but include the sign for negative numbers
        if (coefficient.sign() == -1)
            output = output.substring(1);
        if (output.equals("1"))
            output = "";
        if (coefficient.sign() == -1)
            output = "-" + output;
        output += "x";
        // a*x^1 -> "ax"
        if (exponent != 1)
            output += "^" + exponent;
        return output;
    }
}