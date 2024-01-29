package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Person;
import com.lbg.demo.repos.PersonRepo;

@Service
public class PersonService {

	private PersonRepo repo;

	public PersonService(PersonRepo repo) {
		super();
		this.repo = repo;
	}

	public Person createPerson(Person newPerson) {
		return this.repo.save(newPerson);
	}

	public List<Person> showAll() {
		return this.repo.findAll();
	}

	public ResponseEntity<Person> showPerson(int id) {
		Optional<Person> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(found.get());
	}

	public ResponseEntity<Person> updatePerson(int id, Person newPerson) {
		Optional<Person> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Person existing = found.get();

		existing.setName(newPerson.getName());
		existing.setAge(newPerson.getAge());
		existing.setAddress(newPerson.getAddress());
		existing.setTel(newPerson.getTel());

		return ResponseEntity.ok(existing);
	}

	public boolean deletePerson(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
