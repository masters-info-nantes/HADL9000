package org.alma.csa.m2.connector;

import java.util.ArrayList;
import java.util.List;

import org.alma.csa.m2.connectioninterface.ConnectionType;
import org.alma.csa.m2.connectioninterface.InternalRole;
import org.alma.csa.m2.connectioninterface.Role;
import org.alma.csa.m2.connectioninterface.DirectionType;
import org.alma.csa.m2.exceptions.HADLMinimumMultiplicityException;

public abstract class Connector {
	
	private List<Role> rolesFrom = new ArrayList<Role>();
	private List<Role> rolesTo = new ArrayList<Role>();
	
	private List<InternalRole> internalRolesFrom = new ArrayList<InternalRole>();
	private List<InternalRole> internalRolesTo = new ArrayList<InternalRole>();

	public List<Role> getRolesFrom() {
		return rolesFrom;
	}

	public List<Role> getRolesTo() {
		return rolesTo;
	}

	public List<InternalRole> getInternalRolesFrom() {
		return internalRolesFrom;
	}

	public List<InternalRole> getInternalRolesTo() {
		return internalRolesTo;
	}

	public boolean removeRole(Role role) {
		if(role.getDirectionType() == DirectionType.FROM)
			return rolesFrom.remove(role);
		else
			return rolesTo.remove(role);
	}
	
	public boolean removeInternalRole(InternalRole role) {
		if(role.getDirectionType() == DirectionType.FROM)
			return internalRolesFrom.remove(role);
		else
			return internalRolesTo.remove(role);
	}
	
	public void addRoles(Role...roles) {
		for(Role r:roles) {
			switch(r.getDirectionType()) {
				case FROM:
					this.rolesFrom.add(r);
					break;
				case TO:
					this.rolesTo.add(r);
					break;
			}
		}
	}
	
	public void addInternalRoles(InternalRole...roles) {
		for(InternalRole r:roles) {
			switch(r.getDirectionType()) {
				case FROM:
					this.internalRolesFrom.add(r);
					break;
				case TO:
					this.internalRolesTo.add(r);
					break;
			}
		}
	}
}
