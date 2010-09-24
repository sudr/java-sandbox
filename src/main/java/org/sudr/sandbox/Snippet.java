package org.sudr.sandbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Snippet {
	public static void main(String[] args) {

		final List<String> list = new ArrayList() {
			{
				add("Hello");
			}
		};
		final Iterator<String> iterator = list.iterator();
		System.out.println(iterator.next());
		list.add("World");
		// FIXME : work here while I'm sunbathing
		System.out.println(iterator.next());
	}
}
