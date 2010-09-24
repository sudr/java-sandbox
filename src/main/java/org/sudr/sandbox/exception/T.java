package org.sudr.sandbox.exception;

class T {

	private static T staticT = null;

	public static void main(String[] args) {
		try {
			T t = new T();
		} catch (Exception ex) {
			System.out.println(null == staticT);
		}
	}

	public T() throws Exception {
		staticT = this;
		throw new Exception("Exception");
	}

}
