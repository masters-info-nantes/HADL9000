package org.alma.csa.m2.connector;

import org.alma.csa.m2.connectioninterface.Role;

public class SimpleConnector extends Connector {

	private Glue glue = null;

	public Glue getGlue() {
		return glue;
	}

	public void setGlue(Glue glue) {
		this.glue = glue;
	}
	
	

}
