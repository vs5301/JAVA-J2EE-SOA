package com.auribises.collections;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapAPI {

	public static void main(String[] args) {
		
//		Map<Integer, String> map = new HashMap<Integer, String>();
		
//		HashMap<Integer, String> map = new HashMap<Integer, String>();
//		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		
//		Hashtable -> THREAD-SAFE i.e. synchronized
//		No null key and null value supported
		Hashtable<Integer, String> map = new Hashtable<Integer, String>();
		
//		Key Value pair -> 101, "John" -> Entry
		map.put(101, "John");
		map.put(111, "Jennie");
		map.put(543, "Jim");
		map.put(212, "Jack");
		map.put(191, "Joe");
		map.put(911, "Jennie");	// Keys must be unique, values may be duplicated
		
//		We can add null Key and null values
//		map.put(null, "Kia");	// Treemap won't support null keys but will support null values
//		map.put(777, null);
		
//		map will support 1 null key, but we can have multiple null values
		
		System.out.println(map);
		System.out.println(map.size());
		
//		Not a new key insertion
		map.put(111, "Fionna");	// Update the key 111 with new value
		
		String name = map.get(543);
		System.out.println("Name is: "+name);
		
		if (map.containsKey(111)) {
			System.out.println("111 key is in the Map");
		}
		
		if (map.containsValue("Joe")) {
			System.out.println("Joe is in the Map");
		}
		
		Set<Integer> keys = map.keySet();
		System.out.println(keys);
		
		Iterator<Integer> itr = keys.iterator();
		while (itr.hasNext()) {
			Integer key = (Integer) itr.next();
			String value = map.get(key);
			
			System.out.println(key+"\t"+value);			
		}
		
		System.out.println("~~~~~~~~~~~~~~");
		
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		Iterator<Entry<Integer, String>> entryItr = entrySet.iterator();
		
		while (entryItr.hasNext()) {
			Entry<Integer, String> entry = entryItr.next();
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}

	}

}
