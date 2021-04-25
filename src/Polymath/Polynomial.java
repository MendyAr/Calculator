package Polymath;

import java.util.Vector;

public class Polynomial {
    //fields
    private Monomial[] monomials; //array of monomials where monomials[i] = Monomial with exponent i

    //constructors
    public Polynomial(int numOfMonomials){
        monomials = new Monomial[numOfMonomials];
        resetData();
    }

    public Polynomial(Monomial[] monomials){
        this.monomials = monomials;
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

    public Polynomial add(Polynomial p){

    }

    public
}
