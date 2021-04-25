package Polymath;

import java.util.Vector;

public class Polynomial {
    //fields
    private Monomial[] monomials; //array of monomials where monomials[i] = Monomial with exponent i
    //also - degree of the polynomial p will be (p.monomials.length - 1)

    //constructors
    public Polynomial(int numOfMonomials){
        if (numOfMonomials <= 0)
            numOfMonomials = 1;
        monomials = new Monomial[numOfMonomials];
        resetData();
    }

    public Polynomial(Monomial[] monomials){
        if (monomials == null)
            throw new NullPointerException("Monomials can't be null array");
        this.monomials = new Monomial[monomials.length];
        for (int i = 0; i < monomials.length; i++) {
            if (monomials[i].getExponent() != i)
                throw new IllegalArgumentException("For each monomial in the array monomials - monomial[i] has to be a monomial with exponent i");
            this.monomials[i] = new Monomial(monomials[i]);
        }
        if (this.monomials.length == 0)
            this.monomials = new Monomial[]{new Monomial(0,0)};
    }

    //copy constructor
    public Polynomial(Polynomial p){
        monomials = new Monomial[p.monomials.length];
        for (int i = 0 ; i < p.monomials.length ; i++) {
            monomials[i] = new Monomial(p.monomials[i]);
        }
    }

    //methods

    //resets all monomials to monomials with coefficient 0
    private void resetData(){
        for (int i = 0; i < monomials.length; i++) {
            monomials[i] = new Monomial(0,i);
        }
    }

    //adds monomial to the polynomial
    private void addMonomial(Monomial m){
        int i = m.getExponent(); //index of exponent
        monomials[i] = monomials[i].add(m);
    }

    //adds p to the polynomial
    public Polynomial add(Polynomial p){
        Polynomial addition = new Polynomial(Math.max(monomials.length, p.monomials.length));
        for (int i = 0 ; i < addition.monomials.length ; i++){ //iterating through the exponents
            //checking for each polynomial if it has an monomial with exponent i
            //adding the monomial if it does
            if (i < monomials.length)
                addition.addMonomial(monomials[i]);
            if (i < p.monomials.length)
                addition.addMonomial(p.monomials[i]);
        }
        return addition;
    }

    //multiplies p with the polynomial
    public Polynomial mul(Polynomial p){
        //From https://en.wikipedia.org/wiki/Degree_of_a_polynomial
        //for Polynomials p, q - deg(p*q) = deg(p) + deg(q)
        Polynomial multiplication = new Polynomial((monomials.length-1)+(p.monomials.length-1));
        for (Monomial thisMonom: monomials)
            for (Monomial pMonom: p.monomials)
                multiplication.addMonomial(thisMonom.mult(pMonom));
            return multiplication;
    }

    //evaluates the polynomial with s
    public Scalar evaluate(Scalar s){
        Scalar result = new Integer(0);
        for (Monomial monom: monomials) //iterating through every monomial in the polynomial
            result = result.add(monom.evaluate(s)); //adding the evaluation of current monomial with s
        return result;
    }

    //derivates the polynomial
    public Polynomial derivative(){
        Monomial[] monomials = new Monomial[this.monomials.length-1];
        for (int i = 1; i < this.monomials.length; i++) //derivating monomial with exponent 0 will return 0 so we can skip it
            monomials[i-1] = this.monomials[i].derivative();
        return new Polynomial(monomials);
    }

    public String toString(){
        String str = "";
        for (int i = 0; i < monomials.length; i++) {
            String monomial = monomials[i].toString();
            if (monomial.charAt(0) != '0')
                str += monomial + " ";
        }
        if (str.length() == 0)
            str = "0";
        return str.trim();
    }

    //static functions

    public static Polynomial build(String input){
        Monomial[] monomials = convertString(input.trim().replaceAll(" +", " "), 0); //cleaning input of all unwanted spaces before calling convertString
        return new Polynomial(monomials);
    }

    private static Monomial[] convertString(String str, int exponent){
        int index = str.indexOf(' '); //will tell us if we have multiple arguments or not
        if (index > 0) { //multiple arguments
            Monomial[] monomials = convertString(str.substring(index+1), exponent+1);
            monomials[exponent] = new Monomial(str.substring(0, index), exponent);
            return monomials;
        }
        //single argument
        Monomial[] monomials = new Monomial[exponent+1];
        monomials[exponent] = new Monomial(str, exponent);
        return monomials;
    }
}
