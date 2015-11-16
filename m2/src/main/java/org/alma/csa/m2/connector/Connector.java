package org.alma.csa.m2.connector;

import java.util.ArrayList;
import java.util.List;

import org.alma.csa.m2.connectioninterface.Role;
import org.alma.csa.m2.connectioninterface.DirectionType;
import org.alma.csa.m2.exceptions.HADLMinimumMultiplicityException;

public abstract class Connector {
	
	private List<Role> roles = new ArrayList<Role>();
	
	public Connector(Role...roles) throws Exception {
		boolean fromMin = false, toMin = false;
		for(Role r:roles) {
			this.roles.add(r);
			switch(r.direction) {
				case FROM: fromMin=true;break;
				case TO: toMin=true;break;
			}
		}
		if(!fromMin||!toMin) {
			throw new HADLMinimumMultiplicityException("roles");
		}
	}
}
