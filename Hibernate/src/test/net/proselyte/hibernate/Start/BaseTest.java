package net.proselyte.hibernate.Start;
import net.proselyte.hibernate.annotations.User;
import org.testng.annotations.Test;
import org.testng.Assert;

@Test(groups = "init")
public class BaseTest {
    @Test
    public void correctVM () {
        System.out.println("Start class BaseTest");

    }
    public void serverStartedOk () {}
}
