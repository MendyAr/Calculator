package PolymathTests;

import Polymath.Integer;
import Polymath.Scalar;

import org.junit.*;

public class IntegerTests {
    private Scalar i;

    @Test
    void creation(){
        i = new Integer(6);
        Assert.assertEquals(i.toString(), "6");
        i = new Integer(0);
        Assert.assertEquals(i.toString(), "0");
        i = new Integer(-613);
        Assert.assertEquals(i.toString(), "-613");
    }

    @Test
    void sign(){
        i = new Integer(6);
        Assert.assertEquals(i.sign(), 1);
        i = new Integer(0);
        Assert.assertEquals(i.toString(), 0);
        i = new Integer(-613);
        Assert.assertEquals(i.toString(), -1);
    }

    @Test
    void neg(){
        i = new Integer(6);
        i = i.neg();
        Assert.assertEquals(i.toString(), "-6");
        i = new Integer(0);
        i = i.neg();
        Assert.assertEquals(i.toString(), "0");
        i = new Integer(-613);
        i = i.neg();
        Assert.assertEquals(i.toString(), "613");
    }
}
