package Polymath;

public class Monomial {

    //fields
    private int exponent;
    private Scalar coefficient;

    // constructor
    public Monomial( Scalar coefficient, int exponent ){
        if( exponent < 0 )
            throw new IllegalArgumentException("Exponent can't be negative");
        this.exponent =  exponent;
        // create a new clone of the scalar and use it instead to prevent pointer complications
        this.coefficient = coefficient.clone();
    }

    public Monomial( String coefficient, int exponent ){
        if( exponent < 0 )
            throw new IllegalArgumentException("Exponent can't be negative");
        this.exponent =  exponent;
        // check the sign of the string
        int sign = 1;
        if( coefficient.charAt(0) == '-' ) {
            sign = -1;
            coefficient = coefficient.substring(1);
        }
        // check if the string represents a rational number
        int slashIndex = coefficient.indexOf('/');
        // it's not valid for the '/' character to be at the beginning or end of the string
        if( slashIndex == 0 | slashIndex == coefficient.length() - 1 )
            throw new IllegalArgumentException("The string input isn't valid");
        else if( slashIndex != -1){
            // validate that the other characters are numbers
            String[] R = coefficient.split("/");
            if( R[0].matches("/d+") &  R[1].matches("/d+"))
                this.coefficient = new Rational( java.lang.Integer.parseInt(R[0]) * sign, java.lang.Integer.parseInt(R[1]));
            else
                throw new IllegalArgumentException("The string input isn't valid");
        }
        // check if the string represents an integer
        if( coefficient.matches("/d+") )
            this.coefficient = new Integer(java.lang.Integer.parseInt(coefficient) * sign );
        else
            throw new IllegalArgumentException("The string input isn't valid");
    }

    // copy constructor
    public Monomial( Monomial m ){
        this.exponent =  m.exponent;
        this.coefficient = m.coefficient.clone();
    }

    // methods
    public int getExponent(){
        return exponent;
    }

    public Monomial add(Monomial m){
        // we can't sum two monomial with different exponents into one monomial
        if( exponent != m.exponent )
            return null;
        return new Monomial( coefficient.add(m.coefficient), exponent );
    }

    public Monomial mult(Monomial m){
        return new Monomial( coefficient.mul(m.coefficient), exponent+m.exponent );
    }

    public Scalar evaluate(Scalar s){
        return coefficient.mul(s.power(exponent));
    }

    Monomial derivative(){
        // in case where the exponent is 0 so the new monomial is 0,
        // monomial can't have -1 exponent thus return a new monomial with coefficient 0 and exponent 0.
        // this shouldn't change the behavior of the new Monomial since its coefficient is 0
        if( exponent == 0 )
            return new Monomial(new Integer(0), 0);

        Scalar newCoefficient = coefficient.mulInteger(new Integer((exponent)));
        return new Monomial(newCoefficient, exponent - 1);
    }

    public int sign(){
        return coefficient.sign();
    }

    public String toString(){
        // 0*x^a -> "0"
        if(  coefficient.sign() == 0 )
            return "0";
        // a*x^0 -> "a"
        if( exponent == 0 )
            return coefficient.toString();

        String outputExponent = "x^";
        // a*x^1 -> "ax"
        if( exponent != 1 )
            outputExponent += exponent;

        String outputCoeff = coefficient.toString();
        // check if the scalar equals 1 and if so don't include its value,
        // but include the sign for negative numbers
        if( coefficient.sign() < 0 )
            outputCoeff = outputCoeff.substring(1);
        if( outputCoeff.equals("1") | outputCoeff.equals("1/1") )
            outputCoeff = "";
        if( coefficient.sign() < 0 )
            outputCoeff = "-" + outputCoeff;

        return outputCoeff + outputExponent;
    }
}
