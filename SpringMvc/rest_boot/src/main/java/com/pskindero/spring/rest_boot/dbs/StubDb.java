package com.pskindero.spring.rest_boot.dbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.pskindero.spring.rest_boot.api.Identifable;

@Component
public class StubDb<T extends Identifable> {
	
	private Map<Long, T> db;
	
	public StubDb() {
		this.db = new HashMap<Long, T>();
	}

	public T add(T b) {
		return db.put(b.getId(), b);
	}
	
	@SuppressWarnings("unchecked")
	public void add(T... args) {
		for (T arg : args) {
			add(arg);
		}
	}
	
	public T get(long id) {
		return db.get(id);
	}
	
	public List<T> getAll() {
		return new ArrayList<T>(db.values());
	}
	
	public boolean contains(long id) {
		return db.containsKey(id);
	}
	
	public T remove(long id) {
		return db.remove(id);
	}
}
