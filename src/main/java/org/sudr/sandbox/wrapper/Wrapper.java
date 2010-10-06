package org.sudr.sandbox.wrapper;

import org.apache.commons.lang.StringUtils;

public class Wrapper {

	private final int lineWidth;

	public Wrapper(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	public String wrap(String stringToWrap) {
		if (StringUtils.isBlank(stringToWrap)) {
			return StringUtils.EMPTY;
		}
		if (stringToWrap.length() <= lineWidth) {
			return stringToWrap;
		}
		int cutOff = stringToWrap.lastIndexOf(' ', Math.min(lineWidth, stringToWrap.length()));
		if (cutOff == -1) {
			cutOff = lineWidth;
		}
		return stringToWrap.substring(0,cutOff).trim() + "\n" + wrap(stringToWrap.substring(cutOff).trim());
	}

}
