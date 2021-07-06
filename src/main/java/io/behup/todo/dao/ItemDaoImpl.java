package io.behup.todo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.behup.todo.model.Item;
import io.behup.todo.repository.ItemRepository;

@Service
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void saveOrUpdate(Item item) {
		this.itemRepository.save(item);
	}

	@Override
	public void delete(Item item) {
		this.itemRepository.delete(item);
	}

	@Override
	public Item findById(Integer id) {
		return null;
	}

	@Override
	public List<Item> findAll() {
		return this.itemRepository.findAll();
	}

	@Override
	public List<Item> findItemsActives() {
		return this.itemRepository.findItemsActives();

	}

	@Override
	public List<Item> findItemsCompleted() {
		return this.itemRepository.findItemsCompleted();

	}

	@Override
	public void deleteById(int id) {
		this.itemRepository.deleteById(id);
	}

}
