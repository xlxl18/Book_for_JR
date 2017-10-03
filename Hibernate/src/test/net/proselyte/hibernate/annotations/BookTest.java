package net.proselyte.hibernate.annotations;
import net.proselyte.hibernate.annotations.Book;
import org.testng.annotations.Test;
import org.testng.Assert;

@Test (dependsOnGroups = {"init"}, alwaysRun = true)  // группа зависимости + мягкая зависмость
public class BookTest {

    private Book book2 = new Book("Iola","who are you?","I", "978-82-995326-9-3",2015, false );

    @Test
    public void testGetAndSet() throws Exception {
        Book book = new Book();

        book.setTitle("Iola");
        book.setDescription("who are you?");
        book.setAuthor("I");
        book.setIsbn("978-82-995326-9-3");
        book.setPrintYear(2015);
        book.setReadAlready(false);
        Assert.assertEquals(book.getTitle(), book2.getTitle());
        Assert.assertEquals(book.getId(), book2.getId());
        Assert.assertEquals(book.getAuthor(), book2.getAuthor());
        Assert.assertEquals(book.getDescription(), book2.getDescription());
        Assert.assertEquals(book.getIsbn(), book2.getIsbn());
        Assert.assertEquals(book.getPrintYear(), book2.getPrintYear());
        Assert.assertEquals(book.isReadAlready(), book2.isReadAlready());
        Assert.assertFalse(book2.equals(book));
    }
}
