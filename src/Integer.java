public class Integer implements Scalar{

    private int number;

    public Integer(int number){
        this.number = number;
    }

    public Scalar add(Scalar s){
        if( s.toString().indexOf('/') == -1 ) {
            Integer Int = new Integer(java.lang.Integer.valueOf(s.toString()));
            return addInteger(Int);
        }
        else {
            String[] RationalNum = s.toString().split("/");
            Rational r = new Rational(java.lang.Integer.valueOf(RationalNum[0]), java.lang.Integer.valueOf(RationalNum[1]));
            return addRational(r);
        }
    }

    public Scalar mul(Scalar s){
        if( s.toString().indexOf('/') == -1 ) {
            Integer Int = new Integer(java.lang.Integer.valueOf(s.toString()));
            return mulInteger(Int);
        }
        else {
            String[] RationalNum = s.toString().split("/");
            Rational r = new Rational(java.lang.Integer.valueOf(RationalNum[0]), java.lang.Integer.valueOf(RationalNum[1]));
            return mulRational(r);
        }

    }

    public Scalar addInteger(Integer s) {
        Scalar sum = new Integer(number + s.number);
        return sum;
    }

    public Scalar addRational(Rational s){
        return s.add(this);
    }

    public Scalar mulInteger(Integer s){
        Scalar sum = new Integer(number * s.number);
        return sum;
    }

    public Scalar mulRational(Rational s){
        return s.mul(this);
    }

    public Scalar power(int exponent) {
        Scalar output;
        if (exponent == 0)
            output = new Integer(1);

        else if( exponent > 0 ){
            int newNum = 1;
            for( int i=0; i < exponent; i++ )
                newNum *= number;
            output = new Integer(newNum);
        }
        else{
            int newNum = 1;
            for( int i=0; i < exponent*(-1); i++ )
                newNum *= number;
            output = new Rational(1, newNum);
        }
        return output;
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
        number *= -1;
        return this;
    }

    public String toString(){
        return String.valueOf(number);
    }
}
