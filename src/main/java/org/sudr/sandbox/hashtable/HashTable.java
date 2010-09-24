package org.sudr.sandbox.hashtable;

import java.lang.reflect.Array;

public class HashTable<T> {

	private T[] table = (T[]) new Array[10];

	public void add(T value) {
		table[hash(value)] = value;
	}

	public boolean contains(T value) {
		return table[hash(value)] != null;
	}

	private int hash(T value) {
		return value.hashCode();
	}

	public T get(int index) {
		return table[index];
	}
	
	public void display() {
		for (int i = 0; i < table.length; i++) {
			System.out.println(table[i]);
		}
	}
 }
