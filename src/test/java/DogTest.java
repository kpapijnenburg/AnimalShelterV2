import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class DogTest {

    private Dog dog;

    @Before
    public void testInitialize(){
        this.dog = new Dog("Sgt. Woof", Gender.Male);
    }

    @Test
    public void testConstructor(){
        Assert.assertEquals("Sgt. Woof", this.dog.name);
        Assert.assertEquals(Gender.Male, this.dog.gender);
        Assert.assertNull(this.dog.reservedBy);
        Assert.assertEquals(new Date(), this.dog.lastWalk);
        Assert.assertFalse(this.dog.needsWalk);
    }

    @Test
    public void testReservation(){
        Assert.assertNull(this.dog.reservedBy);
        Assert.assertTrue(this.dog.reserve("John Doe"));
        Assert.assertNotNull(this.dog.reservedBy);
        Assert.assertEquals("John Doe", this.dog.reservedBy.name);
        Assert.assertFalse(this.dog.reserve("Jane Doe"));
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
