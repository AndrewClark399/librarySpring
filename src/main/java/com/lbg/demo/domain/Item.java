package com.lbg.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private int edition;
	private String section;
	private boolean available;

	@ManyToOne
	private Person person;

	public Item() {
		super();
	}

//	public Item(String title, int edition, String section, boolean available) {
//		super();
//		this.id = ++count;
//		setTitle(title);
//		setEdition(edition);
//		setSection(section);
//		setAvailable(available);
//
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Id:" + getId() + ", Title: " + title + ", Edition: " + edition + ", Section: " + section
				+ ", Available: " + available;
	}

}
