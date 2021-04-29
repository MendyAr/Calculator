package PolymathTests;

import Polymath.Integer;
import Polymath.Scalar;

import org.junit.*;

public class IntegerTests {
    private Scalar i;

    @Test
    public void init_normalInput_Success(){
        int integer = ((int)(Math.random()*(java.lang.Integer.MAX_VALUE))) + 1;
        i = new Integer(integer);
        Assert.assertEquals("Integer wasn't constructed properly", String.valueOf(integer), i.toString());
        i = new Integer(0);
        Assert.assertEquals("Integer wasn't constructed properly", "0", i.toString());
        integer = -(((int)(Math.random()*(java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        Assert.assertEquals("Integer wasn't constructed properly", String.valueOf(integer), i.toString());
    }

    @Test(expected = NullPointerException.class)
    public void init_copy_Fail(){
        Integer n = null;
        i = new Integer(n);
        Assert.fail("Construction of Integer from null argument should result in an exception");
    }

    @Test
    public void init_copy_Success(){
        int integer = ((int)(Math.random()*(java.lang.Integer.MAX_VALUE))) + 1;
        Integer n = new Integer(integer);
        i = new Integer(n);
        Assert.assertEquals("Integer wasn't copied properly", n.toString(), i.toString());
        n = new Integer(0);
        i = new Integer(n);
        Assert.assertEquals("Integer wasn't copied properly", n.toString(), i.toString());
        integer = -(((int)(Math.random()*(java.lang.Integer.MAX_VALUE))) + 1);
        n = new Integer(integer);
        i = new Integer(n);
        Assert.assertEquals("Integer wasn't copied properly", n.toString(), i.toString());
    }

    @Test
    public void sign_Success(){
        int integer = ((int)(Math.random()*(java.lang.Integer.MAX_VALUE))) + 1;
        i = new Integer(integer);
        Assert.assertEquals("Bad assessment of sign of " + integer, 1, i.sign());
        i = new Integer(0);
        Assert.assertEquals("Bad assessment of sign of 0", 0, i.sign());
        integer = -(((int)(Math.random()*(java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        Assert.assertEquals("Bad assessment of sign of " + integer, -1, i.sign());
    }

    @Test
    public void neg_Success(){
        int integer = ((int)(Math.random()*(java.lang.Integer.MAX_VALUE))) + 1;
        i = new Integer(integer);
        i = i.neg();
        Assert.assertEquals("Integer wasn't negated properly", String.valueOf(-integer), i.toString());
        i = new Integer(0);
        i = i.neg();
        Assert.assertEquals("Integer wasn't negated properly", String.valueOf(-0), i.toString());
        integer = -(((int)(Math.random()*(java.lang.Integer.MAX_VALUE))) + 1);
        i = new Integer(integer);
        i = i.neg();
        Assert.assertEquals("Integer wasn't negated properly", String.valueOf(-integer), i.toString());
    }
}
