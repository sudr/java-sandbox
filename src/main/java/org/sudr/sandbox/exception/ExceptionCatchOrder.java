package org.sudr.sandbox.exception;

public class ExceptionCatchOrder {

	public class Exception3 extends Exception {

	}

	public class Exception2 extends Exception {

	}

	public class Exception1 extends Exception {

	}

	public void methodToDoSomething() {

		try {
			callMe();
		} catch (Exception1 e1) {
			// handle Exception.
		} catch (Exception2 e2) {
			// handle Exception.
		} catch (Exception3 e3) {
			// handle Exception.
		}

	}

	private void callMe() throws Exception1, Exception2, Exception3 {
		if (true) {
			throw new Exception1();
		}
		if (true) {
			throw new Exception2();
		}
		throw new Exception3();
	}

}
