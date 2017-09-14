package net.proselyte.hibernate;
import net.proselyte.hibernate.annotations.User;
import org.testng.annotations.Test;
import org.testng.Assert;

@Test (dependsOnGroups = {"init. *"})
public class UserTest {
    java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0");
    private User user = new User("Zaza",55,((byte) 1), timestamp );

    @Test
    public void testGetAndSet() throws Exception {
        User user2 = new User();

        user2.setName("Zaza");
        user2.setAge(55);
        user2.setIsAdmin((byte) 1);
        user2.setDate(timestamp);
        Assert.assertEquals(user.getName(), user2.getName());
        Assert.assertEquals(user.getAge(), user2.getAge());
        Assert.assertEquals(user.getDate(), user2.getDate());
        Assert.assertEquals(user.getIsAdmin(), user2.getIsAdmin());
        Assert.assertFalse(user2.equals(user));
    }
}
