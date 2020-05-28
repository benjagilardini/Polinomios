/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import javapolinomios.Polynomial;

/**
 *
 * @author benjag
 */
public class TestList {

    public TestList() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void add() {
        int[] pol1 = {1, 1, 1, 1};
        int[] pol2 = {1, 1, 1,};
        Polynomial a = new Polynomial(pol1);
        Polynomial b = new Polynomial(pol2);
        Polynomial addResult = pol1.add(pol2);
        String res = addResult.toString();
        assertEquals("1*X^4+2*X^3+2*X+2*X", res);
    }
}
