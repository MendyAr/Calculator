package PolymathTests;
import java.util.ArrayList;
import Polymath.*;

import Polymath.Integer;
import org.junit.*;

public class PolynomialTests {
    private ArrayList<Monomial> monomials;
    private Polynomial p, p2;
    private Scalar s;

    @Test
    public void creating_with_arrayList_success() {
        monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(3), 0));
        monomials.add(new Monomial(new Rational(-2, 7), 1));
        monomials.add(new Monomial(new Integer(0), 2));
        monomials.add(new Monomial(new Rational(5, 6), 3));
        monomials.add(new Monomial(new Integer(5), 4));
        p = new Polynomial(monomials);
        Assert.assertEquals("Failed to construct properly with arrayList", "3-2/7x+5/6x^3+5x^4", p.toString());
        monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(0), 0));
        monomials.add(new Monomial(new Rational(0, 7), 1));
        monomials.add(new Monomial(new Integer(0), 2));
        monomials.add(new Monomial(new Rational(0, 6), 3));
        monomials.add(new Monomial(new Integer(0), 4));
        p = new Polynomial(monomials);
        Assert.assertEquals("Failed to construct properly with arrayList", "0", p.toString());
        monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(-1), 0));
        monomials.add(new Monomial(new Rational(-1, 7), 1));
        monomials.add(new Monomial(new Integer(-1), 2));
        monomials.add(new Monomial(new Rational(-1, 6), 3));
        monomials.add(new Monomial(new Integer(-1), 4));
        p = new Polynomial(monomials);
        Assert.assertEquals("Failed to construct properly with arrayList", "-1-1/7x-x^2-1/6x^3-x^4", p.toString());
        monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(-5), 0));
        monomials.add(new Monomial(new Rational(0, 7), 1));
        monomials.add(new Monomial(new Integer(0), 2));
        monomials.add(new Monomial(new Rational(0, 6), 3));
        monomials.add(new Monomial(new Integer(0), 4));
        p = new Polynomial(monomials);
        Assert.assertEquals("Failed to construct properly with arrayList", "-5", p.toString());
    }
    @Test
    public void creating_with_empty_arrayList_success() {
        monomials = new ArrayList<>();
        p = new Polynomial(monomials);
        Assert.assertEquals("Failed to construct properly with arrayList", "0", p.toString());
    }

    @Test
    public void creating_with_string_success() {
        p = Polynomial.build("1/2 3 -5/5 0 -3/8 0 8");
        Assert.assertEquals("Failed to construct properly with string","1/2+3x-x^2-3/8x^4+8x^6", p.toString());
        p = Polynomial.build("1    2   3  4 5 67");
        Assert.assertEquals("Failed to construct properly with string","1+2x+3x^2+4x^3+5x^4+67x^5", p.toString());
        p = Polynomial.build("5/7+3+0+-5/5+6");
        Assert.assertEquals("Failed to construct properly with string","5/7+3x-x^3+6x^4", p.toString());
        p = Polynomial.build("0+0+0");
        Assert.assertEquals("Failed to construct properly with string","0", p.toString());
        p = Polynomial.build("    0     ");
        Assert.assertEquals("Failed to construct properly with string","0", p.toString());
        p = Polynomial.build("    5/6     ");
        Assert.assertEquals("Failed to construct properly with string","5/6", p.toString());
    }

    @Test
    public void creating_with_empty_string_success() {
        p = Polynomial.build("");
        Assert.assertEquals("Failed to construct properly", "0", p.toString());
    }

    @Test
    public void creating_with_copy_constructor_arrayList_success() {
        monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(3), 0));
        monomials.add(new Monomial(new Rational(-2, 7), 1));
        monomials.add(new Monomial(new Integer(0), 2));
        monomials.add(new Monomial(new Rational(5, 6), 3));
        monomials.add(new Monomial(new Integer(5), 4));
        p = new Polynomial(monomials);
        p = new Polynomial(p);
        Assert.assertEquals("Failed to construct properly with arrayList", "3-2/7x+5/6x^3+5x^4", p.toString());
        monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(0), 0));
        p = new Polynomial(monomials);
        p = new Polynomial(p);
        Assert.assertEquals("Failed to construct properly with arrayList", "0", p.toString());
        monomials = new ArrayList<>();
        p = new Polynomial(monomials);
        p = new Polynomial(p);
        Assert.assertEquals("Failed to construct properly with arrayList", "0", p.toString());
    }

    @Test
    public void creating_with_copy_constructor_string_success() {
        p = Polynomial.build("1/2 3 -5/5 0 -3/8 0 8");
        p = new Polynomial(p);
        Assert.assertEquals("Failed to construct properly with string", "1/2+3x-x^2-3/8x^4+8x^6", p.toString());
        p = Polynomial.build("0");
        p = new Polynomial(p);
        Assert.assertEquals("Failed to construct properly with string","0", p.toString());
        p = Polynomial.build("");
        p = new Polynomial(p);
        Assert.assertEquals("Failed to construct properly with string","0", p.toString());
    }

    /*
    @Test(expected = IllegalArgumentException.class)
    public void creating_with_invalid_string1_fail(){
        p = Polynomial.build("!1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void creating_with_invalid_string2_fail(){
        p = Polynomial.build("0r");
    }

    @Test(expected = IllegalArgumentException.class)
    public void creating_with_invalid_string3_fail(){
        p = Polynomial.build("g");
    }

    @Test(expected = IllegalArgumentException.class)
    public void creating_with_invalid_string4_fail(){
        p = Polynomial.build("5g5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void creating_with_invalid_string5_fail(){
        p = Polynomial.build("--5");
    }
    */

    @Test(expected = NullPointerException.class)
    public void create_with_null_object_fail(){
        monomials = null;
        p = new Polynomial(monomials);
    }

    @Test(expected = NullPointerException.class)
    public void create_with_array_containing_null_monomial_fail(){
        monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(3), 0));
        monomials.add(null);
        p = new Polynomial(monomials);
    }

    @Test(expected = NullPointerException.class)
    public void create_with_array_containing_one_null_element_fail(){
        monomials = new ArrayList<>();
        monomials.add(null);
        p = new Polynomial(monomials);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_with_monomial_that_his_exponent_do_not_match_his_index_1_fail(){
        monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(3), 1));
        p = new Polynomial(monomials);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_with_monomial_that_his_exponent_do_not_match_his_index_2_fail(){
        monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(3), 0));
        monomials.add(new Monomial(new Integer(4), 1));
        monomials.add(new Monomial(new Integer(5), 3));
        p = new Polynomial(monomials);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_with_monomial_that_his_exponent_do_not_match_his_index_3_fail(){
        monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(3), 0));
        monomials.add(new Monomial(new Integer(4), 1));
        monomials.add(new Monomial(new Integer(5), 2));
        monomials.add(new Monomial(new Integer(5), 1));
        p = new Polynomial(monomials);
    }

    @Test
    public void adding_polynomial_success() {
        p = Polynomial.build("1");
        p = p.add(Polynomial.build("0 1"));
        Assert.assertEquals("Failed to add properly", "1+x", p.toString());
        p = Polynomial.build("1/3 0 2");
        p = p.add(Polynomial.build("-1/2 1"));
        Assert.assertEquals("Failed to add properly","-1/6+x+2x^2", p.toString());
        p = Polynomial.build("1/3 0 2 5 -4/4");
        p = p.add(Polynomial.build("-1/2 1 3/4 -5 1"));
        Assert.assertEquals("Failed to add properly", "-1/6+x+11/4x^2", p.toString());
        p = Polynomial.build("0 0 0 8 0");
        p = p.add(Polynomial.build("0 0 0 -8 0"));
        Assert.assertEquals("Failed to add properly", "0", p.toString());
        p = Polynomial.build("0");
        p = p.add(Polynomial.build("0"));
        Assert.assertEquals("Failed to add properly", "0", p.toString());
    }

    @Test
    public void adding_after_creating_polynomial_with_empty_arrayList_or_string_success(){
        monomials = new ArrayList<>();
        p = new Polynomial(monomials);
        ArrayList<Monomial> monomials2 = new ArrayList<>();
        p2 = new Polynomial(monomials2);
        p = p.add(p2);
        Assert.assertEquals("Failed to add properly", "0", p.toString());
        p = Polynomial.build("0 3");
        p = p.add(Polynomial.build(""));
        Assert.assertEquals("Failed to add properly", "3x", p.toString());
        monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(0), 0));
        monomials.add(new Monomial(new Integer(3), 1));
        p = new Polynomial(monomials);
        p = p.add(Polynomial.build(""));
        Assert.assertEquals("Failed to add properly", "3x", p.toString());
        p = Polynomial.build("");
        p = p.add(Polynomial.build(""));
        Assert.assertEquals("Failed to add properly", "0", p.toString());
    }

    @Test
    public void multiplying_polynomial_success(){
        p = Polynomial.build("1");
        p = p.mul(Polynomial.build("1"));
        Assert.assertEquals("Failed to multiply properly", "1", p.toString());
        p = Polynomial.build("0 0 0 1");
        p = p.mul(Polynomial.build("0 0 0 1"));
        Assert.assertEquals("Failed to multiply properly", "x^6", p.toString());
        p = Polynomial.build("1/2 0 -2 3/5 0 6");
        p = p.mul(Polynomial.build("1/3 0 0 0 -3/5"));
        Assert.assertEquals("Failed to multiply properly", "1/6-2/3x^2+1/5x^3-3/10x^4+2x^5+6/5x^6-9/25x^7-18/5x^9", p.toString());
        p = Polynomial.build("1/3 0 2 5 -1/4");
        p = p.mul(Polynomial.build("1"));
        Assert.assertEquals("Failed to multiply properly", "1/3+2x^2+5x^3-1/4x^4", p.toString());
        p = Polynomial.build("5 0 0 2");
        p = p.mul(Polynomial.build("0"));
        Assert.assertEquals("Failed to multiply properly", "0", p.toString());
        p = Polynomial.build("0");
        p = p.mul(Polynomial.build("0"));
        Assert.assertEquals("Failed to multiply properly", "0", p.toString());
    }

    @Test
    public void multiplying_after_creating_polynomial_with_empty_arrayList_or_string_success(){
        monomials = new ArrayList<>();
        p = new Polynomial(monomials);
        ArrayList<Monomial> monomials2 = new ArrayList<>();
        p2 = new Polynomial(monomials2);
        p = p.mul(p2);
        Assert.assertEquals("Failed to multiply properly", "0", p.toString());
        p = Polynomial.build("1");
        p = p.mul(Polynomial.build(""));
        Assert.assertEquals("Failed to multiply properly", "0", p.toString());
        monomials = new ArrayList<>();
        monomials.add(new Monomial(new Integer(1), 0));
        p = new Polynomial(monomials);
        p = p.mul(Polynomial.build(""));
        Assert.assertEquals("Failed to multiply properly", "0", p.toString());
        p = Polynomial.build("");
        p = p.mul(Polynomial.build(""));
        Assert.assertEquals("Failed to multiply properly", "0", p.toString());
    }

    @Test(expected = NullPointerException.class)
    public void adding_null_fail(){
        p = Polynomial.build("1");
        p.add(null);
    }

    @Test(expected = NullPointerException.class)
    public void multiply_with_null_fail(){
        p = Polynomial.build("1");
        p.mul(null);
    }

    @Test
    public void evaluate(){
        p = Polynomial.build("1/2 0 -2 3/5 0 6");
        s = p.evaluate(new Rational(4,5));
        Assert.assertEquals("Failed to evaluate properly", "9333/6250", p.toString());
        p = Polynomial.build("0 1 1 2 5/7");
        s = p.evaluate(new Integer(0));
        Assert.assertEquals("Failed to evaluate properly", "0", p.toString());
        p = Polynomial.build("4 1 1 1 5/7");
        s = p.evaluate(new Integer(0));
        Assert.assertEquals("Failed to evaluate properly", "4", p.toString());
        p = Polynomial.build("3/7 0 0 2");
        s = p.evaluate(new Rational(0,5));
        Assert.assertEquals("Failed to evaluate properly", "3/7", p.toString());
        p = Polynomial.build("1/5 1 -2 0 2/3");
        s = p.evaluate(new Integer(1));
        Assert.assertEquals("Failed to evaluate properly", "-2/15", p.toString());
        p = Polynomial.build("1 1 1 1 1 1");
        s = p.evaluate(new Rational(-1, 1));
        Assert.assertEquals("Failed to evaluate properly", "0", p.toString());
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_with_null_fail(){
        p = Polynomial.build("1");
        p.evaluate(null);
    }

    @Test
    public void derivative(){
        p = Polynomial.build("0 0 0 0 5/1");
        p = p.derivative();
        Assert.assertEquals("Failed to derive properly", "20x^3", p.toString());
        p = Polynomial.build("-2/3 0 -2 2/3 -5 8/7");
        p = p.derivative();
        Assert.assertEquals("Failed to derive properly", "-4x+2x^2-20x^3+40/7x^4", p.toString());
        p = Polynomial.build("8/9");
        p = p.derivative();
        Assert.assertEquals("Failed to derive properly", "0", p.toString());
        p = Polynomial.build("0");
        p = p.derivative();
        Assert.assertEquals("Failed to derive properly", "0", p.toString());
        p = Polynomial.build("0 0 3 0 0");
        p = p.derivative();
        Assert.assertEquals("Failed to derive properly", "6x", p.toString());
    }

}
