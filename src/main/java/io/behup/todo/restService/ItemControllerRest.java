package io.behup.todo.restService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.behup.todo.dao.ItemDao;
import io.behup.todo.model.Item;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "*")
public class ItemControllerRest {

	@Autowired
	private ItemDao itemDao;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Item> findAll() {
		List<Item> items = new ArrayList<Item>();
		items = itemDao.findAll();
		return items;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void createOrUpdate(@RequestBody Item item) {
		itemDao.saveOrUpdate(item);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable("id") int id) {
		itemDao.deleteById(id);
	}

}
