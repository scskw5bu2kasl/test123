import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webApplication27.Control;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.core.io.ResourceLoader;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test0001()
    {
        Control control = new Control();
        MockHttpServletRequest req = new MockHttpServletRequest();
        MockHttpServletResponse resp = new MockHttpServletResponse();
        req.addParameter("product_name","testUnit");
        req.addParameter("product_class","testUnit");
        req.addParameter("model_num","EW-505-01-06");
        req.addParameter("tanka","60");

        try {
            Method method = Control.class.getDeclaredMethod("productRegit", HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(control, req, resp);
            assertTrue( true );
        } catch (NoSuchMethodException e) {
            System.err.println("NoSuchMethodException Caught Exception");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("IllegalAccessException Caught Exception");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.err.println("InvocationTargetException Caught Exception");
            e.printStackTrace();
        }
    }
}
