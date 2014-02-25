package edu.lmu.cs.wutup.ws.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class EventTest {

    User sam = new User(25, "sam@example.com");

    @Test
    public void fieldsSetByConstructorCanBeRead() {
        Event e = new Event(3, "Pool Party", "Party at Brous House", sam);
        assertThat(e.getId(), is(3));
        assertThat(e.getName(), is("Pool Party"));
        assertThat(e.getDescription(), is("Party at Brous House"));
        assertThat(e.getCreator(), is(sam));
    }

    @Test
    public void fieldsSetBySettersCanBeRead() {
        Event e = new Event();
        e.setId(5);
        e.setName("Programming Contest");
        e.setDescription("Student Programming Contest");
        e.setCreator(sam);
        assertThat(e.getId(), is(5));
        assertThat(e.getName(), is("Programming Contest"));
        assertThat(e.getDescription(), is("Student Programming Contest"));
        assertThat(e.getCreator(), is(sam));
    }

    @Test
    public void toStringProducesExpectedString() {
        Event e = new Event(3, "Pool Party", null, null);
        String expected = "Event{id=3, name=Pool Party, description=null, creator=null}";
        Event e1 = new Event(3, "Pool Party", "Party at Brous House", null);
        String expected1 = "Event{id=3, name=Pool Party, description=Party at Brous House, " + "creator=null}";
        System.out.println(e);
        assertEquals(expected, e.toString());
        assertEquals(expected1, e1.toString());
    }

    @Test
    public void equalsUsesIdOnly() {
        assertThat(new Event(7, "Pool Party"), equalTo(new Event(7, "Pool Party")));
        assertThat(new Event(7, "Pool Party"), not(equalTo(new Event(17, "Pool Party"))));
        assertThat(new Event(7, "Pool Party"), equalTo(new Event(7, "Target Practice")));
        assertFalse(new Event(7, "Pool Party").equals("some string"));
        assertFalse(new Event(7, "Pool Party").equals(null));
    }

}
