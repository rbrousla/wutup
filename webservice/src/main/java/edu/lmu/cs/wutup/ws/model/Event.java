package edu.lmu.cs.wutup.ws.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

@XmlRootElement(name = "event")
public class Event {

	private Integer id;
	private String name;
	private String description;
	private User owner;
	private List<User> attendees = new ArrayList<User>();
	private List<EventOccurrence> eventOccurrence = new ArrayList<EventOccurrence>();
	private List<Category> category = new ArrayList<Category>();

	public Event() {
		// No-arg constructor required for annotations
	}

	public Event(Integer id, String name, String description, User owner,
			List<User> attendees, List<EventOccurrence> eventOccurrence,
			List<Category> category) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.owner = owner;
		this.attendees = attendees;
		this.eventOccurrence = eventOccurrence;
		this.category = category;
	}

	public Event(Integer id, String name) {
		this(id, name, null, null, null, null, null);
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "id")
	public int getId() {
		return this.id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@XmlElement(name = "name")
	public String getName() {
		return this.name;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setOwner(final User owner) {
		this.owner = owner;
	}

	@XmlElement(name = "owner")
	public User getOwner() {
		return this.owner;
	}

	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}

	@XmlElement(name = "attendees")
	public List<User> getAttendees() {
		return attendees;
	}

	public void setEventOccurrence(List<EventOccurrence> eventOccurrence) {
		this.eventOccurrence = eventOccurrence;
	}

	@XmlElement(name = "eventOccurrence")
	public List<EventOccurrence> getEventOccurrence() {
		return eventOccurrence;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	@XmlElement(name = "category")
	public List<Category> getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", this.id)
				.add("name", this.name).add("description", this.description)
				.add("owner", this.owner).add("attendees", this.attendees)
				.add("eventOccurrence", this.eventOccurrence)
				.add("category", this.category).toString();
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		if (obj instanceof Event) {
			Event e = Event.class.cast(obj);
			result = Objects.equal(id, e.id)
					&& Objects.equal(e.name, this.name);
		}

		return result;
	}
}