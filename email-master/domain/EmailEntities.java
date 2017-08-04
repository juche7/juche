package com.smartxp.commons.email.domain;

public class EmailEntities<T> {
	
	private T object;

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public EmailEntities(T object) {
		super();
		this.object = object;
	}
}
