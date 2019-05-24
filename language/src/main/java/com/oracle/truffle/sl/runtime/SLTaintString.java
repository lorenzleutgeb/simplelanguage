package com.oracle.truffle.sl.runtime;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.interop.TruffleObject;

public class SLTaintString implements TruffleObject, Comparable<SLTaintString> {
	private final String value;

	public SLTaintString(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	@TruffleBoundary
	public int compareTo(SLTaintString other) {
		return value.compareTo(other.value);
	}

	@Override
	@TruffleBoundary
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		SLTaintString that = (SLTaintString) o;

		return value != null ? value.equals(that.value) : that.value == null;

	}

	@Override
	public int hashCode() {
		return value != null ? value.hashCode() : 0;
	}
}
