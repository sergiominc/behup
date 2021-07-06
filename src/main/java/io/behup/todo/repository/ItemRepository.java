package io.behup.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.behup.todo.model.Item;

// unico repository do projeto
public interface ItemRepository extends JpaRepository<Item, Integer> {

	@Query(value = "SELECT * FROM item i WHERE i.status = false", nativeQuery = true)
	List<Item> findItemsActives();

	@Query(value = "SELECT * FROM item i WHERE i.status = true", nativeQuery = true)
	List<Item> findItemsCompleted();

}
