public class Integer implements Scalar{

    // field
    private int number;

    // constructor
    public Integer(int number){
        this.number = number;
    }
    // copy constructor
    public Integer(Integer I){
        this.number = I.number;
    }

    // methods
    public Scalar add(Scalar s){
        if( s.toString().indexOf('/') == -1 ) {
            Integer Int = new Integer(java.lang.Integer.parseInt(s.toString()));
            return addInteger(Int);
        }
        else {
            String[] RationalNum = s.toString().split("/");
            Rational r = new Rational(java.lang.Integer.parseInt(RationalNum[0]), java.lang.Integer.parseInt(RationalNum[1]));
            return addRational(r);
        }
    }

    public Scalar mul(Scalar s){
        if( s.toString().indexOf('/') == -1 ) {
            Integer Int = new Integer(java.lang.Integer.parseInt(s.toString()));
            return mulInteger(Int);
        }
        else {
            String[] RationalNum = s.toString().split("/");
            Rational r = new Rational(java.lang.Integer.parseInt(RationalNum[0]), java.lang.Integer.parseInt(RationalNum[1]));
            return mulRational(r);
        }

    }

    public Scalar addInteger(Integer s) {
        return new Integer(number + s.number);
    }

    public Scalar addRational(Rational s){
        return s.addInteger(this);
    }

    public Scalar mulInteger(Integer s){
        return new Integer(number * s.number);
    }

    public Scalar mulRational(Rational s){
        return s.mulInteger(this);
    }

    public Scalar power(int exponent) {
        if (exponent == 0)
            return new Integer(1);

        int sign = 1;
        if( exponent < 0 )
            sign = -1;
        int newNum = 1;
        while( exponent != 0 ) {
            newNum *= number;
            exponent -= sign;
        }
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
        return new Integer(-1*number );
    }

    public String toString(){
        return String.valueOf(number);
    }
}
