package org.alma.csa.m2.connectioninterface;

/**
 * Created by Maxime on 16/11/2015.
 */
public class Role extends ConnectionPoint {

	public DirectionType direction = null;

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
}
