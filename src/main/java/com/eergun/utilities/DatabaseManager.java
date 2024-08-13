package com.eergun.utilities;

import com.eergun.entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DatabaseManager<T extends BaseEntity> implements ICRUD<T>{
	protected ArrayList<T> veriListesi;
	
	
	{
		veriListesi = new ArrayList<>();
	}
	@Override
	public T save(T t) {
		if (veriListesi.add(t)) {
			return t;
		} else {
			return null;
		}
	}
	
	@Override
	public List<T> saveAll(List<T> t) {
		if (veriListesi.addAll(t)) {
			return t;
		} else {
			return null;
		}
	}
	
	@Override
	public Optional<T> update(T t) {
		int index = veriListesi.indexOf(t);
		if (index == -1){
			return Optional.empty();
		}
		else {
			return Optional.of(veriListesi.set(index, t));
		}
	}
	
	@Override
	public List<T> findAll() {
		return veriListesi;
	}
	
	@Override
	public Optional<T> findByID(String id) {
		for (T entity : veriListesi ){
			if(entity.getId().equals(id) ){
				return Optional.of(entity);
			}
		}
		return Optional.empty();
	}
	
	@Override
	public boolean deleteByID(String id) {
		Optional<T> entityById = findByID(id);
		if (entityById.isEmpty()) return false;
		return veriListesi.remove(entityById.get());
		
	}
}