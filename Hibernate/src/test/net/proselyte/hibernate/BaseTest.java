package net.proselyte.hibernate;
import net.proselyte.hibernate.annotations.User;
import org.testng.annotations.Test;
import org.testng.Assert;

@Test(groups = "init")
public class BaseTest {
    @Test
    public void correctVM () {
        System.out.println(555);

    }
    public void serverStartedOk () {}
}
