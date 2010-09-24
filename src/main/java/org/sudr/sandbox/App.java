package org.sudr.sandbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {
	public static void main(String[] args) {
		final List<String> list = new ArrayList() {
			{
				add("Hello");
			}
		};
		final Iterator<String> iterator = list.iterator();
		System.out.println(iterator.next());
		list.add("World");
		
		System.out.println(iterator.next());
	}
}
