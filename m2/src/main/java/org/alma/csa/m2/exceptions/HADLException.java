package org.alma.csa.m2.exceptions;

public abstract class HADLException extends Exception {

	private static final long serialVersionUID = 1L;

	public HADLException(String message){
		super(message);
	}
}
