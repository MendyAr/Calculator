package Polymath;

public class Monomial {

    private int exponent;
    private Scalar coefficient;


    public Monomial( Scalar coefficient, int exponent ){
        if( exponent < 0 )
        this.exponent =  exponent;
        if( coefficient.toString().indexOf('/') == -1 )
            this.coefficient = new Integer(java.lang.Integer.parseInt(coefficient.toString()));
        else {
            String[] RationalNum = coefficient.toString().split("/");
            this.coefficient = new Rational(java.lang.Integer.parseInt(RationalNum[0]), java.lang.Integer.parseInt(RationalNum[1]));
        }
    }

    public Monomial( Monomial m ){
        this.exponent =  exponent;
        if( m.coefficient.toString().indexOf('/') == -1 )
            this.coefficient = new Integer(java.lang.Integer.parseInt(m.coefficient.toString()));
        else {
            String[] RationalNum = m.coefficient.toString().split("/");
            this.coefficient = new Rational(java.lang.Integer.parseInt(RationalNum[0]), java.lang.Integer.parseInt(RationalNum[1]));
        }
    }


    public Monomial add(Monomial m){
        if( exponent != m.exponent )
            return null;
        return new Monomial( coefficient.add(m.coefficient), exponent );
    }

    Monomial mult(Monomial m){
        return new Monomial( coefficient.mul(m.coefficient), exponent+m.exponent );
    }

    Scalar evaluate(Scalar s){
        return coefficient.mul(s.power(exponent));
    }

    Monomial derivative(){

    }
    /* returns a new Monomial which is the derivative of the current monomial
– int sign() returns 1 for a positive coefficient, -1 for negative one,
    and 0 for zero.*/
    String toString(){

    } // returns a string that represents the Monomial
}
