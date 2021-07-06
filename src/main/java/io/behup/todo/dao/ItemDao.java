package io.behup.todo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import io.behup.todo.model.Item;

@Component
public interface ItemDao extends GenericDao<Item, Integer> {

	List<Item> findItemsActives();

	List<Item> findItemsCompleted();

}
