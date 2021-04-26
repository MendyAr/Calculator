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
        // create a new copy of the scalar and use it instead to prevent pointer complications
        if( coefficient.toString().indexOf('/') == -1 )
            this.coefficient = new Integer(java.lang.Integer.parseInt(coefficient.toString()));
        else {
            String[] RationalNum = coefficient.toString().split("/");
            this.coefficient = new Rational(java.lang.Integer.parseInt(RationalNum[0]), java.lang.Integer.parseInt(RationalNum[1]));
        }
    }

    // copy constructor
    public Monomial( Monomial m ){
        this.exponent =  exponent;
        // create a new copy of the scalar and use it instead to prevent pointer complications
        if( m.coefficient.toString().indexOf('/') == -1 )
            this.coefficient = new Integer(java.lang.Integer.parseInt(m.coefficient.toString()));
        else {
            String[] RationalNum = m.coefficient.toString().split("/");
            this.coefficient = new Rational(java.lang.Integer.parseInt(RationalNum[0]), java.lang.Integer.parseInt(RationalNum[1]));
        }
    }

    // methods
    public Monomial add(Monomial m){
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
        int newExponent = exponent - 1;
        return new Monomial(newCoefficient, newExponent);
    }

    public int sign(){
        return coefficient.sign();
    }

    public String toString(){
        // a*x^0 -> a
        if( exponent == 0 )
            return coefficient.toString();

        // check if the scalar is 1 and if so don't include '1',
        // only the '-' sign for a negative number
        String scalarStr = "";
        if( coefficient.toString().equals("1") | coefficient.toString().equals("1/1") ) {
            if (coefficient.sign() < 0)
                scalarStr += "-";
        }
        else
            scalarStr += coefficient.toString();



    }
}
