package Polymath;

public class Integer implements Scalar{

    // fields
    private int number;

    // constructor
    public Integer(int number){
        this.number = number;
    }
    // copy constructor
    public Integer(Integer I){
        this.number = I.number;
    }

    //  methods

    public int getNumber(){
        return number;
    }

    public Scalar add(Scalar s){
        return s.addInteger(this);
    }

    public Scalar mul(Scalar s){
        return s.mulInteger(this);
    }

    public Scalar addInteger(Integer s) {
        return new Integer(number + s.number);
    }

    public Scalar addRational(Rational s){
        return new Rational( s.getDenominator() * number + s.getNumerator(), s.getDenominator() );
    }

    public Scalar mulInteger(Integer s){
        return new Integer(number * s.number);
    }

    public Scalar mulRational(Rational s){
        return new Rational( s.getNumerator() * number, s.getDenominator());
    }

    public Scalar power(int exponent) {
        if ( exponent == 0)
            return new Integer(1);
        if ( number == 0 )
            return new Integer(0);

        int sign = 1;
        if( exponent < 0 )
            sign = -1;
        int newNum = 1;
        while( exponent != 0 ) {
            newNum *= number;
            exponent -= sign;
        }
        if ( sign == 1 )
            return new Integer( newNum );
        // in case the exponent was negative we have
        return new Rational(1, newNum);
    }

    public int sign(){
        if( number > 0 )
            return 1;
        else if( number < 0 )
            return -1;
        else
            return 0;
    }

    public Scalar neg() {
        return new Integer(-1*number);
    }

    public String toString(){
        return String.valueOf(number);
    }
}
