package org.sudr.sandbox.hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class HashTableTest {

	public void test_add() {
		HashTable<Integer> ht = new HashTable<Integer>();
		ht.add(1);
		Assert.assertTrue(ht.contains(1));
	}
}
