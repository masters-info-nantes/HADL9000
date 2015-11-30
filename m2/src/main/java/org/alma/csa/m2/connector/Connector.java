package org.alma.csa.m2.connector;

import java.util.ArrayList;
import java.util.List;

import org.alma.csa.m2.connectioninterface.ConnectionType;
import org.alma.csa.m2.connectioninterface.Role;
import org.alma.csa.m2.connectioninterface.DirectionType;
import org.alma.csa.m2.exceptions.HADLMinimumMultiplicityException;

public abstract class Connector {
	
	private List<Role> rolesFrom = new ArrayList<Role>();
	private List<Role> rolesTo = new ArrayList<Role>();

	public List<Role> getRolesFrom() {
		return rolesFrom;
	}

	public List<Role> getRolesTo() {
		return rolesTo;
	}

	public boolean removePort(Role role) {
		if(role.getDirectionType() == DirectionType.FROM)
			return rolesFrom.remove(role);
		else
			return rolesTo.remove(role);
	}
	
	public void addRoles(Role...roles) {
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
	}
}
