package Polymath;

public class Integer implements Scalar{

    // fields
    private int number;

    //getters

    public int getNumber(){
        return number;
    }

    // constructor

    public Integer(int number){
        this.number = number;
    }

    // copy constructor
    public Integer(Integer I){
        this.number = I.number;
    }

    //  methods

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
        return new Rational( ((s.getDenominator() * number) + s.getNumerator()), s.getDenominator() );
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

        boolean flip = false;
        if( exponent < 0 ) {
            flip = true;
            exponent *= -1;
        }
        int newNum = 1;
        while( exponent != 0 ) {
            newNum *= number;
            exponent --;
        }
        if ( flip )// in case the exponent was negative we have
            return new Rational(1, newNum);
        return new Integer( newNum );
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
