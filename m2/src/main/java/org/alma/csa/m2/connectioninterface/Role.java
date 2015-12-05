package org.alma.csa.m2.connectioninterface;

/**
 * Created by Maxime on 16/11/2015.
 */
public class Role extends ConnectionPoint {

	private DirectionType direction = null;
	private Port port = null;
	

	public boolean setDirectionType(DirectionType direction) {
		if(this.direction == null) {
			this.direction = direction;
			return true;
		} else
			return false;

	}

	public DirectionType getDirectionType() {
		return direction;
	}

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		this.port = port;
	}
	
	
}
