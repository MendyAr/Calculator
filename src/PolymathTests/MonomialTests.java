package PolymathTests;

import Polymath.Monomial;
import Polymath.Rational;
import Polymath.Integer;

import Polymath.Scalar;
import org.junit.*;

import javax.print.attribute.standard.NumberUp;

public class MonomialTests {
    private Monomial m;
    private Scalar s;

    @Test
    public void creation_with_Integer_success() {
        m = new Monomial(new Integer(-6), 4);
        Assert.assertEquals("Failed to construct properly", "-6x^4", m.toString());
        m = new Monomial(new Integer(6), 4);
        Assert.assertEquals("Failed to construct properly", "6x^4", m.toString());
        m = new Monomial(new Integer(1), 5);
        Assert.assertEquals("Failed to construct properly", "x^5", m.toString());
        m = new Monomial(new Integer(-1), 5);
        Assert.assertEquals("Failed to construct properly", "-x^5", m.toString());
        m = new Monomial(new Integer(0), 4);
        Assert.assertEquals("Failed to construct properly", "0", m.toString());
        m = new Monomial(new Integer(5), 0);
        Assert.assertEquals("Failed to construct properly", "5", m.toString());
        m = new Monomial(new Integer(-5), 0);
        Assert.assertEquals("Failed to construct properly", "-5", m.toString());
        m = new Monomial(new Integer(1), 0);
        Assert.assertEquals("Failed to construct properly", "1", m.toString());
        m = new Monomial(new Integer(-1), 0);
        Assert.assertEquals("Failed to construct properly", "-1", m.toString());
        m = new Monomial(new Integer(0), 0);
        Assert.assertEquals("Failed to construct properly", "0", m.toString());
    }

    @Test
    public void creation_with_Rational_success() {
        m = new Monomial(new Rational(-6, 1), 4);
        Assert.assertEquals("Failed to construct properly", "-6x^4", m.toString());
        m = new Monomial(new Rational(6, 1), 4);
        Assert.assertEquals("Failed to construct properly", "6x^4", m.toString());
        m = new Monomial(new Rational(-7, 5), 4);
        Assert.assertEquals("Failed to construct properly", "-7/5x^4", m.toString());
        m = new Monomial(new Rational(7, 5), 4);
        Assert.assertEquals("Failed to construct properly", "7/5x^4", m.toString());
        m = new Monomial(new Rational(1, 1),5);
        Assert.assertEquals("Failed to construct properly", "x^5", m.toString());
        m = new Monomial(new Rational(-1, 1),5);
        Assert.assertEquals("Failed to construct properly", "-x^5", m.toString());
        m = new Monomial(new Rational(0, 1),4);
        Assert.assertEquals("Failed to construct properly", "0", m.toString());
        m = new Monomial(new Rational(5, 2),0);
        Assert.assertEquals("Failed to construct properly", "5/2", m.toString());
        m = new Monomial(new Rational(-5, 2),0);
        Assert.assertEquals("Failed to construct properly", "-5/2", m.toString());
        m = new Monomial(new Rational(1, 1),0);
        Assert.assertEquals("Failed to construct properly", "1", m.toString());
        m = new Monomial(new Rational(-1, 1),0);
        Assert.assertEquals("Failed to construct properly", "-1", m.toString());
        m = new Monomial(new Rational(0, 1),0);
        Assert.assertEquals("Failed to construct properly", "0", m.toString());
    }

    @Test
    public void creation_with_string_Integer_success() {
        m = new Monomial("-6", 4);
        Assert.assertEquals("Failed to construct properly with string", "-6x^4", m.toString());
        m = new Monomial("6", 4);
        Assert.assertEquals("Failed to construct properly with string", "6x^4", m.toString());
        m = new Monomial("-7", 4);
        Assert.assertEquals("Failed to construct properly with string", "-7x^4", m.toString());
        m = new Monomial("7", 4);
        Assert.assertEquals("Failed to construct properly with string", "7x^4", m.toString());
        m = new Monomial("1",5);
        Assert.assertEquals("Failed to construct properly with string", "x^5", m.toString());
        m = new Monomial("-1",5);
        Assert.assertEquals("Failed to construct properly with string", "-x^5", m.toString());
        m = new Monomial("0", 4);
        Assert.assertEquals("Failed to construct properly with string", "0", m.toString());
        m = new Monomial("5", 0);
        Assert.assertEquals("Failed to construct properly with string", "5", m.toString());
        m = new Monomial("-5", 0);
        Assert.assertEquals("Failed to construct properly with string", "-5", m.toString());
        m = new Monomial("1", 0);
        Assert.assertEquals("Failed to construct properly with string", "1", m.toString());
        m = new Monomial("-1", 0);
        Assert.assertEquals("Failed to construct properly with string", "-1", m.toString());
        m = new Monomial("0", 0);
        Assert.assertEquals("Failed to construct properly with string", "0", m.toString());
    }

    @Test
    public void creation_with_string_Rational_success() {
        m = new Monomial("-6/1", 4);
        Assert.assertEquals("Failed to construct properly with string", "-6x^4", m.toString());
        m = new Monomial("6/1", 4);
        Assert.assertEquals("Failed to construct properly with string", "6x^4", m.toString());
        m = new Monomial("-7/5", 4);
        Assert.assertEquals("Failed to construct properly with string", "-7/5x^4", m.toString());
        m = new Monomial("7/5", 4);
        Assert.assertEquals("Failed to construct properly with string", "7/5x^4", m.toString());
        m = new Monomial("1/1",5);
        Assert.assertEquals("Failed to construct properly with string", "x^5", m.toString());
        m = new Monomial("-1/1",5);
        Assert.assertEquals("Failed to construct properly with string", "-x^5", m.toString());
        m = new Monomial("0/1", 4);
        Assert.assertEquals("Failed to construct properly with string", "0", m.toString());
        m = new Monomial("5/2", 0);
        Assert.assertEquals("Failed to construct properly with string", "5/2", m.toString());
        m = new Monomial("-5/2", 0);
        Assert.assertEquals("Failed to construct properly with string", "-5/2", m.toString());
        m = new Monomial("1/1", 0);
        Assert.assertEquals("Failed to construct properly with string", "1", m.toString());
        m = new Monomial("-1/1", 0);
        Assert.assertEquals("Failed to construct properly with string", "-1", m.toString());
        m = new Monomial("0/1", 0);
        Assert.assertEquals("Failed to construct properly with string", "0", m.toString());
    }

    @Test( expected = IllegalArgumentException.class)
    public void creation_with_negative_exponent_fail() {
        m = new Monomial(new Integer(1), -1);
    }
    @Test( expected = NullPointerException.class)
    public void creation_with_null_scalar_fail() {
        s = null;
        m = new Monomial(s, 1);
    }
    @Test( expected = IllegalArgumentException.class)
    public void creation_with_string_negative_exponent_fail() {
        m = new Monomial("1", -1);
    }
    @Test( expected = NullPointerException.class)
    public void creation_with_empty_string_fail() {
        String nullString = null;
        m = new Monomial(nullString, 1);
    }
    @Test( expected = IllegalArgumentException.class)
    public void creation_with_invalid_string_fail1() {
        m = new Monomial("", 1);
    }
    @Test( expected = IllegalArgumentException.class)
    public void creation_with_invalid_string_fail2() {
        m = new Monomial("/", 1);
    }
    @Test( expected = IllegalArgumentException.class)
    public void creation_with_invalid_string_fail3() {
        m = new Monomial("/12", 1);
    }
    @Test( expected = IllegalArgumentException.class)
    public void creation_with_invalid_string_fail4(){
        m = new Monomial("12/", 1);
    }
    @Test( expected = IllegalArgumentException.class)
    public void creation_with_invalid_string_fail5() {
        m = new Monomial("1//2", 1);
    }
    @Test( expected = IllegalArgumentException.class)
    public void creation_with_invalid_string_fail6() {
        m = new Monomial("!", 1);
    }
    @Test( expected = IllegalArgumentException.class)
    public void creation_with_invalid_string_fail7() {
        m = new Monomial("4564!21", 1);
    }
    @Test( expected = IllegalArgumentException.class)
    public void creation_with_invalid_string_fail8() {
        m = new Monomial("--5", 1);
    }

    @Test
    public void creation_with_copy_constructor_success() {
        m = new Monomial("2", 3);
        m = new Monomial(m);
        Assert.assertEquals("Failed to construct properly with copy constructor", "2x^3", m.toString());
        m = new Monomial("0", 2);
        m = new Monomial(m);
        Assert.assertEquals("Failed to construct properly with copy constructor", "0", m.toString());
        m = new Monomial("5", 0);
        m = new Monomial(m);
        Assert.assertEquals("Failed to construct properly with copy constructor", "5", m.toString());
    }

    @Test( expected = NullPointerException.class)
    public void creation_with_copy_constructor_null_fail() {
        m = new Monomial(null);
    }

    @Test
    public void adding_with_Integer_coefficients_success() {
        m = new Monomial("-3", 2);
        m = m.mult(new Monomial("7", 2));
        Assert.assertEquals("Failed to add properly", "-21x^4", m.toString());
        m = new Monomial("5", 0);
        m = m.mult(new Monomial("3", 0));
        Assert.assertEquals("Failed to add properly", "15", m.toString());
        m = new Monomial("-2", 1);
        m = m.mult(new Monomial("-4", 1));
        Assert.assertEquals("Failed to add properly", "8x^2", m.toString());
        m = new Monomial("-2", 3);
        m = m.mult(new Monomial("-4", 3));
        Assert.assertEquals("Failed to add properly", "8x^6", m.toString());
        m = new Monomial("0", 2);
        m = m.mult(new Monomial("-4", 2));
        Assert.assertEquals("Failed to add properly", "0", m.toString());
        m = new Monomial("-4", 2);
        m = m.mult(new Monomial("0", 2));
        Assert.assertEquals("Failed to add properly", "0", m.toString());
        m = new Monomial("0", 2);
        m = m.mult(new Monomial("0", 2));
        Assert.assertEquals("Failed to add properly", "0", m.toString());
    }

    @Test
    public void adding_with_Rational_coefficients_success() {
        m = new Monomial("-3/2", 2);
        m = m.add(new Monomial("3/1", 2));
        Assert.assertEquals("Failed to add properly", "3/2x^2", m.toString());
        m = new Monomial("3/1", 0);
        m = m.add(new Monomial("3/2", 0));
        Assert.assertEquals("Failed to add properly", "9/2", m.toString());
        m = new Monomial("-2/5", 1);
        m = m.add(new Monomial("-4/5", 1));
        Assert.assertEquals("Failed to add properly", "-6/5x", m.toString());
        m = new Monomial("-2/5", 3);
        m = m.add(new Monomial("-4/5", 3));
        Assert.assertEquals("Failed to add properly", "-6/5x^3", m.toString());
        m = new Monomial("0/2", 2);
        m = m.add(new Monomial("-4/3", 2));
        Assert.assertEquals("Failed to add properly", "-4/3x^2", m.toString());
        m = new Monomial("-4/2", 2);
        m = m.add(new Monomial("0/6", 2));
        Assert.assertEquals("Failed to add properly", "-2x^2", m.toString());
        m = new Monomial("0/1", 2);
        m = m.add(new Monomial("0/1", 2));
        Assert.assertEquals("Failed to add properly", "0", m.toString());
    }

    @Test
    public void adding_with_Rational_and_Integer_coefficients_success() {
        m = new Monomial("-3/2", 2);
        m = m.add(new Monomial("3", 2));
        Assert.assertEquals("Failed to add properly", "3/2x^2", m.toString());
        m = new Monomial("3", 0);
        m = m.add(new Monomial("3/2", 0));
        Assert.assertEquals("Failed to add properly", "9/2", m.toString());
        m = new Monomial("-2", 1);
        m = m.add(new Monomial("-4/5", 1));
        Assert.assertEquals("Failed to add properly", "-14/5x", m.toString());
        m = new Monomial("-2/5", 3);
        m = m.add(new Monomial("-4", 3));
        Assert.assertEquals("Failed to add properly", "-22/5x^3", m.toString());
        m = new Monomial("0/2", 2);
        m = m.add(new Monomial("-4", 2));
        Assert.assertEquals("Failed to add properly", "-4x^2", m.toString());
        m = new Monomial("-4/2", 2);
        m = m.add(new Monomial("0", 2));
        Assert.assertEquals("Failed to add properly", "-2x^2", m.toString());
        m = new Monomial("0", 2);
        m = m.add(new Monomial("0/1", 2));
        Assert.assertEquals("Failed to add properly", "0", m.toString());
    }

    @Test
    public void try_adding_with_different_exponents_and_return_null_success() {
        m = new Monomial("-3", 2);
        m = m.add(new Monomial("9/7", 7));
        Assert.assertNull("Failed to return null when adding monomials with different exponent", m);
        m = new Monomial("3", 0);
        m = m.add(new Monomial("6", 1));
        Assert.assertNull("Failed to return null when adding monomials with different exponent", m);
    }

    @Test(expected = NullPointerException.class)
    public void adding_with_null_fail() {
        m = new Monomial("1", 1);
        m = m.add(null);
    }


    @Test
    public void multiplying_with_Integer_coefficients_success() {
        m = new Monomial("-3", 2);
        m = m.mult(new Monomial("7", 4));
        Assert.assertEquals("Failed to multiply properly", "-21x^6", m.toString());
        m = new Monomial("5", 0);
        m = m.mult(new Monomial("3", 0));
        Assert.assertEquals("Failed to multiply properly", "15", m.toString());
        m = new Monomial("-2", 2);
        m = m.mult(new Monomial("-4", 0));
        Assert.assertEquals("Failed to multiply properly", "8x^2", m.toString());
        m = new Monomial("-2", 5);
        m = m.mult(new Monomial("-4", 1));
        Assert.assertEquals("Failed to multiply properly", "8x^6", m.toString());
        m = new Monomial("0", 2);
        m = m.mult(new Monomial("-4", 6));
        Assert.assertEquals("Failed to multiply properly", "0", m.toString());
        m = new Monomial("-4", 2);
        m = m.mult(new Monomial("0", 2));
        Assert.assertEquals("Failed to multiply properly", "0", m.toString());
        m = new Monomial("0", 2);
        m = m.mult(new Monomial("0", 2));
        Assert.assertEquals("Failed to multiply properly", "0", m.toString());
    }

    @Test
    public void multiplying_with_Rational_coefficients_success() {
        m = new Monomial("-3/2", 3);
        m = m.mult(new Monomial("3/1", 1));
        Assert.assertEquals("Failed to multiply properly", "-9/2x^4", m.toString());
        m = new Monomial("3/1", 0);
        m = m.mult(new Monomial("3/2", 0));
        Assert.assertEquals("Failed to multiply properly", "9/2", m.toString());
        m = new Monomial("-2/5", 1);
        m = m.mult(new Monomial("-4/5", 1));
        Assert.assertEquals("Failed to multiply properly", "8/25x^2", m.toString());
        m = new Monomial("-2/5", 3);
        m = m.mult(new Monomial("-4/5", 3));
        Assert.assertEquals("Failed to multiply properly", "8/25x^6", m.toString());
        m = new Monomial("0/2", 2);
        m = m.mult(new Monomial("-4/3", 2));
        Assert.assertEquals("Failed to multiply properly", "0", m.toString());
        m = new Monomial("-4/2", 2);
        m = m.mult(new Monomial("0/6", 2));
        Assert.assertEquals("Failed to multiply properly", "0", m.toString());
        m = new Monomial("0/1", 2);
        m = m.mult(new Monomial("0/1", 2));
        Assert.assertEquals("Failed to multiply properly", "0", m.toString());
    }

    @Test
    public void multiplying_with_Rational_and_Integer_coefficients_success() {
        m = new Monomial("-3/2", 2);
        m = m.mult(new Monomial("3", 1));
        Assert.assertEquals("Failed to multiply properly", "-9/2x^3", m.toString());
        m = new Monomial("3", 0);
        m = m.mult(new Monomial("3/2", 0));
        Assert.assertEquals("Failed to multiply properly", "9/2", m.toString());
        m = new Monomial("-2", 1);
        m = m.mult(new Monomial("-4/5", 5));
        Assert.assertEquals("Failed to multiply properly", "8/5x^6", m.toString());
        m = new Monomial("-2/5", 3);
        m = m.mult(new Monomial("-4", 7));
        Assert.assertEquals("Failed to multiply properly", "8/5x^10", m.toString());
        m = new Monomial("0/2", 2);
        m = m.mult(new Monomial("-4", 0));
        Assert.assertEquals("Failed to multiply properly", "0", m.toString());
        m = new Monomial("-4/2", 2);
        m = m.mult(new Monomial("0", 1));
        Assert.assertEquals("Failed to multiply properly", "0", m.toString());
        m = new Monomial("0", 2);
        m = m.mult(new Monomial("0/1", 2));
        Assert.assertEquals("Failed to multiply properly", "0", m.toString());
    }

    @Test(expected = NullPointerException.class)
    public void multiplying_with_null_fail() {
        m = new Monomial("1", 1);
        m = m.mult(null);
    }


    @Test
    public void evaluate() {
        m = new Monomial("2/3", 2);
        s = m.evaluate(new Integer(3));
        Assert.assertEquals("Failed to evaluate properly", "6", s.toString());
        m = new Monomial("2/3", 2);
        s = m.evaluate(new Integer(-3));
        Assert.assertEquals("Failed to evaluate properly", "6", s.toString());
        m = new Monomial("2/3", 3);
        s = m.evaluate(new Integer(2));
        Assert.assertEquals("Failed to evaluate properly", "16/3", s.toString());
        m = new Monomial("2/3", 3);
        s = m.evaluate(new Integer(-2));
        Assert.assertEquals("Failed to evaluate properly", "-16/3", s.toString());
        m = new Monomial("2/5", 2);
        s = m.evaluate(new Rational(3, 2));
        Assert.assertEquals("Failed to evaluate properly", "9/10", s.toString());
        m = new Monomial("2/3", 2);
        s = m.evaluate(new Rational(-3, 2));
        Assert.assertEquals("Failed to evaluate properly", "3/2", s.toString());
        m = new Monomial("2/3", 3);
        s = m.evaluate(new Rational(2, 3));
        Assert.assertEquals("Failed to evaluate properly", "16/81", s.toString());
        m = new Monomial("2/3", 3);
        s = m.evaluate(new Rational(-2, 3));
        Assert.assertEquals("Failed to evaluate properly", "-16/81", s.toString());
    }

    @Test
    public void evaluate_with_one(){
        m = new Monomial("2/3", 2);
        s = m.evaluate(new Integer(1));
        Assert.assertEquals("Failed to evaluate properly", "2/3", s.toString());
        m = new Monomial("2/3", 2);
        s = m.evaluate(new Integer(-1));
        Assert.assertEquals("Failed to evaluate properly", "2/3", s.toString());
        m = new Monomial("2/3", 3);
        s = m.evaluate(new Rational(1, 1));
        Assert.assertEquals("Failed to evaluate properly", "2/3", s.toString());
        m = new Monomial("2/3", 3);
        s = m.evaluate(new Integer(-1));
        Assert.assertEquals("Failed to evaluate properly", "-2/3", s.toString());
        m = new Monomial("3", 1);
        s = m.evaluate(new Integer(1));
        Assert.assertEquals("Failed to evaluate properly", "3", s.toString());
        m = new Monomial("2/3", 0);
        s = m.evaluate(new Rational(1, 1));
        Assert.assertEquals("Failed to evaluate properly", "2/3", s.toString());
        m = new Monomial("7/4", 2);
        s = m.evaluate(new Integer(2));
        Assert.assertEquals("Failed to evaluate properly", "7", s.toString());
        m = new Monomial("2/3", 1);
        s = m.evaluate(new Rational(5, 6));
        Assert.assertEquals("Failed to evaluate properly", "5/9", s.toString());
        m = new Monomial("2/3", 0);
        s = m.evaluate(new Integer(1));
        Assert.assertEquals("Failed to evaluate properly", "2/3", s.toString());
    }

    @Test
    public void evaluate_with_zero(){
        m = new Monomial("2/3", 1);
        s = m.evaluate(new Integer(0));
        Assert.assertEquals("Failed to evaluate properly", "0", s.toString());
        m = new Monomial("2/3", 2);
        s = m.evaluate(new Rational(0, 1));
        Assert.assertEquals("Failed to evaluate properly", "0", s.toString());
        m = new Monomial("2/3", 0);
        s = m.evaluate(new Integer(0));
        Assert.assertEquals("Failed to evaluate properly", "2/3", s.toString());
        m = new Monomial("-2/3", 0);
        s = m.evaluate(new Integer(0));
        Assert.assertEquals("Failed to evaluate properly", "-2/3", s.toString());
    }


    @Test(expected = NullPointerException.class)
    public void evaluate_with_null_fail() {
        m = new Monomial("1", 1);
        s = null;
        m.evaluate(null);
    }

    @Test
    public void derivative_success() {
        m = new Monomial("-1/2", 0);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "0", m.toString());
        m = new Monomial("0", 0);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "0", m.toString());
        m = new Monomial("8", 0);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "0", m.toString());
        m = new Monomial("3/4", 1);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "3/4", m.toString());
        m = new Monomial("0", 1);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "0", m.toString());
        m = new Monomial("-8", 1);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "-8", m.toString());
        m = new Monomial("3/4", 2);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "3/2x", m.toString());
        m = new Monomial("0", 2);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "0", m.toString());
        m = new Monomial("-8", 2);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "-16x", m.toString());
        m = new Monomial("7/9", 3);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "7/3x^2", m.toString());
        m = new Monomial("0", 3);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "0", m.toString());
        m = new Monomial("-5", 3);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "-15x^2", m.toString());
        m = new Monomial("900/50", 50);
        m = m.derivative();
        Assert.assertEquals( "Failed to derive properly", "900x^49", m.toString());
    }

    @Test
    public void sign_success(){
        m = new Monomial("5/10", 0);
        Assert.assertEquals( "incorrect sign was returned", 1, m.sign());
        m = new Monomial("-352/20460", 1);
        Assert.assertEquals("incorrect sign was returned", -1, m.sign());
        m = new Monomial("1024/-512", 2);
        Assert.assertEquals("incorrect sign was returned", -1, m.sign());
        m = new Monomial("-613/-21", 3);
        Assert.assertEquals("incorrect sign was returned", 1, m.sign());
        m = new Monomial("5", 4);
        Assert.assertEquals("incorrect sign was returned", 1, m.sign());
        m = new Monomial("-5", 5);
        Assert.assertEquals("incorrect sign was returned", -1, m.sign());
        m = new Monomial("0", 6);
        Assert.assertEquals("incorrect sign was returned", 0, m.sign());
        m = new Monomial("0/45", 7);
        Assert.assertEquals("incorrect sign was returned", 0, m.sign());
    }

}
