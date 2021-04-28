package Polymath;

import java.util.ArrayList;

public class Polynomial {
    //fields
    private ArrayList<Monomial> monomials; //array of monomials where monomials.get(i) = Monomial with exponent i
    //also - degree of the polynomial p will be (p.monomials.size() - 1)

    //constructors
    public Polynomial(ArrayList<Monomial> monomials) {
        checkMonomials(monomials);
        this.monomials = new ArrayList<Monomial>(monomials); //copying the given list to ensure immutability of Polynomial
    }

    //copy constructor
    public Polynomial(Polynomial p) {
        monomials = new ArrayList<Monomial>(p.monomials);
    }

    //methods

    //adds p to the polynomial
    public Polynomial add(Polynomial p) {
        int size = Math.max(this.monomials.size(), p.monomials.size()); //size of the new Polynomial will be the size of the largest of the poynomials (and thus have the same degree)
        ArrayList<Monomial> monomials = new ArrayList<Monomial>(size);
        for (int i = 0; i < size; i++) { //iterating through the exponents
            if ((this.monomials.size() > i) && (p.monomials.size() > i)) //if both polynomials have monomial with exponent i
                monomials.add(this.monomials.get(i).add(p.monomials.get(i))); //we insert the addition
                //if not, one polynomial will and we'll insert the monomial as is
            else if (this.monomials.size() > i)
                monomials.add(this.monomials.get(i));
            else
                monomials.add(p.monomials.get(i));
        }
        return new Polynomial(monomials);
    }

    //multiplies p with the polynomial
    public Polynomial mul(Polynomial p) {
        //From https://en.wikipedia.org/wiki/Degree_of_a_polynomial
        //for Polynomials p, q - deg(p*q) = deg(p) + deg(q)
        ArrayList<Monomial> monomials = new ArrayList<Monomial>((this.monomials.size() - 1) + (p.monomials.size() - 1) + 1);
        for (Monomial thisMonom : this.monomials)
            for (Monomial pMonom : p.monomials) {
                Monomial multiplication = thisMonom.mult(pMonom);
                int exponent = multiplication.getExponent();
                if (monomials.size() <= exponent) //if we didn't add that exponent yes
                    monomials.add(multiplication); //just add it to the list
                else //if such exponent exists
                    monomials.set(exponent, monomials.get(exponent).add(multiplication)); //we need to add the monomials
            }
        return new Polynomial(monomials);
    }

    //evaluates the polynomial with s
    public Scalar evaluate(Scalar s) {
        Scalar result = new Integer(0);
        for (Monomial monom : monomials) //iterating through every monomial in the polynomial
            result = result.add(monom.evaluate(s)); //adding the evaluation of current monomial with s
        return result;
    }

    //derivates the polynomial
    public Polynomial derivative() {
        ArrayList<Monomial> monomials = new ArrayList<Monomial>(this.monomials.size() - 1);
        for (int i = 1; i < this.monomials.size(); i++) //derivating monomial with exponent 0 will return 0 so we can skip it
            monomials.add(this.monomials.get(i).derivative());
        return new Polynomial(monomials);
    }

    public String toString() {
        String str = "";
        for (Monomial monom : monomials)
            if (!monom.toString().equals("0"))
                if (str.length() != 0 && monom.toString().charAt(0) != '-')
                    str += "+" + monom.toString();
                else
                    str += monom.toString();
        if (str.length() == 0)
            str = "0";
        return str;
    }

    //static functions

    //checks legality of monomials
    public static void checkMonomials(ArrayList<Monomial> monomials) { //we expect monomials.get(i) = Monomial with exponent i
        if (monomials == null)
            throw new NullPointerException("Monomials can't be null");
        int i = 0;
        for (Monomial monom : monomials) {
            if (monom == null)
                throw new NullPointerException("Monomial at index - " + i + " is null");
            if (monom.getExponent() != i)
                throw new IllegalArgumentException("Monomial's exponent at index - " + i + " is not - " + i);
            i++;
        }
    }

    public static Polynomial build(String input) {
        input = input.trim().replaceAll(" +", " "); //cleaning input of all unwanted spaces
        ArrayList<Monomial> monomials = new ArrayList<Monomial>();
        int exponent = 0;
        for (String coef : input.split(" ")) {
            monomials.add(new Monomial(coef, exponent));
            exponent++;
        }
        return new Polynomial(monomials);
    }
}