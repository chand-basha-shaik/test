package com.example.CRUD.contoller;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUD.entity.Data;
import com.example.CRUD.repository.Repointerface;

@RestController
public class Control {
	
	@Autowired
	Repointerface repo;
	
	@PostMapping("/savedata")
	public Data savedata(@RequestBody Data d1)
	{
		return repo.save(d1);
		
	}
	
	@GetMapping("/findAlldata")
	public List<Data> finddata(@RequestBody Data d2)
	{
		return repo.findAll();
		
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Data> findbyid(@PathVariable Integer id)
	{
		return repo.findById(id);
		
	}
	
	@PutMapping("/Updatingdata/{id}")
	public Data update(@RequestBody Data d3,@PathVariable Integer id)
	{
		Data entity=repo.findById(id).get();
		entity.setPass(d3.getPass());
		repo.save(entity);
		return entity;
		
	}
	
	@DeleteMapping("/Deletingdata/{id}")
	public int delete(@PathVariable Integer id)
	{
		repo.deleteById(id);
		return id;
		
	}

}
