package PolymathTests;
import java.util.ArrayList;
import Polymath.*;

import Polymath.Integer;
import org.junit.*;

public class PolynomialTests {
    private Polynomial p, p2;
    private Scalar s;

    @Test(expected = NullPointerException.class)
    public void nullArrayList(){
        ArrayList<Monomial> monomials = null;
        p = new Polynomial(monomials);
    }

    @Test(expected = NullPointerException.class)
    public void nullElement(){
        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(3), 0));
        monomials.add(null);
        p = new Polynomial(monomials);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidMonomialPositioning(){
        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(3), 0));
        monomials.add(new Monomial(new Integer(4), 1));
        monomials.add(new Monomial(new Integer(5), 3));
        p = new Polynomial(monomials);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creationWithInvalidString(){
        p = Polynomial.build("!1");
    }

    @Test
    public void creation(){
        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(3), 0));
        monomials.add(new Monomial(new Integer(4), 1));
        monomials.add(new Monomial(new Integer(0), 2));
        monomials.add(new Monomial(new Integer(5), 3));
        p = new Polynomial(monomials);
        Assert.assertEquals(p.toString(), "3+4x+5x^3");
        ArrayList<Monomial> monomials3 = new ArrayList<>();
        p = new Polynomial(monomials3);
        Assert.assertEquals(p.toString(), "0");
        p = Polynomial.build("1/2 3 -5/5 0 -3/8 0 8");
        Assert.assertEquals(p.toString(), "1/2+3x-x^2-3/8x^4+8x^6");
        p = Polynomial.build("1    2   3  4 5 67");
        Assert.assertEquals(p.toString(), "1+2x+3x^2+4x^3+5x^4+67x^5");
        p = Polynomial.build("5/7 3 0 -5/5 6");
        Assert.assertEquals(p.toString(), "5/7+3x-x^3+6x^4");
        p = Polynomial.build("0 0 0");
        Assert.assertEquals(p.toString(), "0");
        // copy constructor
        p2 = new Polynomial(p);
        Assert.assertEquals(p2.toString(), p.toString());
    }


    @Test
    public void add() {
        p = Polynomial.build("1/3 0 2");
        p = p.add(Polynomial.build("-1/2 1"));
        Assert.assertEquals(p.toString(), "-1/6+x+2x^2");
        p = Polynomial.build("1/3 0 2 5 -4/4");
        p = p.add(Polynomial.build("-1/2 1 3/4 -5 1"));
        Assert.assertEquals(p.toString(), "-1/6+x+11/4x^2");
        p = Polynomial.build("0 0 0 8 0");
        p = p.add(Polynomial.build("0 0 0 -8 0"));
        Assert.assertEquals(p.toString(), "0");
    }

    @Test
    public void mul() {
        p = Polynomial.build("1/2 0 -2 3/5 0 6");
        p = p.mul(Polynomial.build("1/3 0 0 0 -3/5"));
        Assert.assertEquals(p.toString(), "1/6-2/3x^2+1/5x^3-3/10x^4+2x^5+6/5x^6-9/25x^7-18/5x^9");
        p = Polynomial.build("1/3 0 2 5 -1/4");
        p = p.mul(Polynomial.build("1"));
        Assert.assertEquals(p.toString(), "1/3+2x^2+5x^3-1/4x^4");
        p = Polynomial.build("5 0 0 2");
        p = p.mul(Polynomial.build("0"));
        Assert.assertEquals(p.toString(), "0");
    }

    @Test
    public void evaluate(){
        p = Polynomial.build("1/2 0 -2 3/5 0 6");
        s = p.evaluate(new Rational(4,5));
        Assert.assertEquals(s.toString(), "9333/6250");
        p = Polynomial.build("0 5 6/8 0 5/7");
        s = p.evaluate(new Integer(0));
        Assert.assertEquals(s.toString(), "0");
        p = Polynomial.build("3/7 0 0 2");
        s = p.evaluate(new Rational(0,5));
        Assert.assertEquals(s.toString(), "3/7");
        p = Polynomial.build("1/5 1 -2 0 2/3");
        s = p.evaluate(new Integer(1));
        Assert.assertEquals(s.toString(), "-2/15");
    }

    @Test
    public void derivative(){
        p = Polynomial.build("-2/3 0 -2 2/3 -5 8/7");
        p = p.derivative();
        Assert.assertEquals(p.toString(), "-4x+2x^2-20x^3+40/7x^4");
        p = Polynomial.build("8/9");
        p = p.derivative();
        Assert.assertEquals(p.toString(), "0");
        p = Polynomial.build("0");
        p = p.derivative();
        Assert.assertEquals(p.toString(), "0");
    }

}
