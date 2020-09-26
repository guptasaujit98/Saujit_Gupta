package com.testForSpringBoot.Starter.error;

public enum CustomErrorMsg {

	_CustomMsg("Caught the exception");

	private final String msg;

	private CustomErrorMsg(String msg) {
		this.msg = msg;
	}

	public String val() {
		return msg;
	}

}
