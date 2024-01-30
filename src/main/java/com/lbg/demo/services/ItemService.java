package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Item;
import com.lbg.demo.repos.ItemRepo;

@Service
public class ItemService {

	private ItemRepo repo;

	public ItemService(ItemRepo repo) {
		super();
		this.repo = repo;
	}

	public Item createItem(Item newItem) {
		return this.repo.save(newItem);
	}

	public List<Item> showItems() {
		return this.repo.findAll();
	}

	public ResponseEntity<Item> showItem(int id) {
		Optional<Item> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(found.get());
	}

	public ResponseEntity<Item> updateItem(int id, Item newItem) {
		Optional<Item> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Item existing = found.get();

		if (newItem.getTitle() != null) {
			existing.setTitle(newItem.getTitle());
		}
		if (newItem.getEdition() != 0) {
			existing.setEdition(newItem.getEdition());
		}
		if (newItem.getSection() != null) {
			existing.setSection(newItem.getSection());
		}
		if (newItem.isAvailable() != false) {
			existing.setAvailable(newItem.isAvailable());
			existing.setPerson(newItem.getPerson());
		}
		Item body = this.repo.save(existing);
		return ResponseEntity.ok(body);

	}

	public boolean deleteItem(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}
}
