package datatype;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void oneLessThanOther() {
        Person person1 = new Person("Ruchi", 30);
        Person person2 = new Person("Cenential", 100);

        assertEquals(person1.compareTo(person2),-1);
    }

    @Test
    public void oneGreaterThanOther() {
        Person person1 = new Person("Cenential", 100);
        Person person2 = new Person("Ruchi", 30);

        assertEquals(person1.compareTo(person2),1);
    }
}
