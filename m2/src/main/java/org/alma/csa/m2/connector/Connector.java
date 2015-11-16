package org.alma.csa.m2.connector;

import java.util.ArrayList;
import java.util.List;

import org.alma.csa.m2.connectioninterface.Role;
import org.alma.csa.m2.connectioninterface.DirectionType;
import org.alma.csa.m2.exceptions.HADLMinimumMultiplicityException;

public abstract class Connector {
	
	private List<Role> rolesFrom = new ArrayList<Role>();
	private List<Role> rolesTo = new ArrayList<Role>();
	
	public Connector(Role...roles) throws Exception {
		for(Role r:roles) {
			switch(r.direction) {
				case FROM:
					this.rolesFrom.add(r);
					break;
				case TO:
					this.rolesTo.add(r);
					break;
			}
		}
		if(rolesFrom.isEmpty() || rolesTo.isEmpty()) {
			throw new HADLMinimumMultiplicityException("roles");
		}
	}
}
