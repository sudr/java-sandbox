package org.sudr.sandbox.exception;

public class TryCatchFinally {

	public static void main(String[] args) {

		System.out.println(TryCatchFinally.callMe());

	}

	private static int callMe() {
		try {
			if (true) {
				throw new Exception("Exception");
			}
		} catch (Exception e) {
			return 1000;
		} finally {
			return 2000;
		}
	}

}
