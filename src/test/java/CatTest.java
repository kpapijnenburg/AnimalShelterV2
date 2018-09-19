import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CatTest {
    private Cat cat;

    @Before
    public void TestInitialize(){
        this.cat = new Cat("Ms. Meow", Gender.Female, "Scratches couch");
    }

    @Test
    public void TestConstructor(){
        Assert.assertEquals("Ms. Meow", this.cat.name);
        Assert.assertEquals(Gender.Female, this.cat.gender);
        Assert.assertNull(this.cat.reservedBy);
        Assert.assertEquals("Scratches couch", this.cat.badHabits);
    }

    @Test
    public void TestReservation(){
        Assert.assertNull(this.cat.reservedBy);
        Assert.assertTrue(this.cat.reserve("John Doe"));
        Assert.assertNotNull(this.cat.reservedBy);
        Assert.assertEquals("John Doe", this.cat.reservedBy.name);
        Assert.assertFalse(this.cat.reserve("Jane Doe"));
    }

    @Test
    public void TestReservationTime(){
        // TODO: Implement this when interfaces have been explained.
        // We don't yet test the reserved time because it used the current
        // system clock to determine the result. Therefore we cannot check
        // if the values are the same, since two consecutive calls to
        // DateTime.Now are very likely to give different results. There is
        // a way to account for this, but the solution will use interfaces:
        // a concept that is not yet discussed in class. To be implemented.
    }

}
