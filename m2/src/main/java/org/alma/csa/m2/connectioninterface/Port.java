package org.alma.csa.m2.connectioninterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 16/11/2015.
 */
public class Port extends ConnectionPoint {
    private ConnectionType connectionType = ConnectionType.REQUIRED;
    private Role role = null;
    private List<Service> services = new ArrayList<Service>();

    public boolean setConnectionType(ConnectionType connectionType) {
        if(this.connectionType == null) {
            this.connectionType = connectionType;
            return true;
        } else
            return false;

    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Service> getServices() {
		return services;
	}

	public void addServices(Service service) {
		this.services.add(service);
	}
	
	public void transfer(Object message){

        System.out.println("Port (" + this.getClass().getName() + ") forwards " + message);
        
        this.setChanged();
        this.notifyObservers(message);
    }
    
    
}
