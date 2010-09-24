package org.sudr.sandbox.exception;

import java.io.IOException;

public class Parent {
	
	public void callMe() throws IOException {
	}

}

class Child extends Parent {
	
	@Override
	public void callMe() {
//		throw new Exception();
	}
	
}

