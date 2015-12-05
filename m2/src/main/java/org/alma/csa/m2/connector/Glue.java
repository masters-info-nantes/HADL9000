package org.alma.csa.m2.connector;

import java.util.ArrayList;
import java.util.List;

import org.alma.csa.m2.connectioninterface.ConnectionType;
import org.alma.csa.m2.connectioninterface.Port;

public class Glue {
	List<Port> portsRequired = new ArrayList<Port>();
	List<Port> portsProvided = new ArrayList<Port>();
	
	public List<Port> getPortsRequired() {
		return portsRequired;
	}

	public List<Port> getPortsProvided() {
		return portsProvided;
	}
	
	public boolean removePort(Port port) {
		if(port.getConnectionType() == ConnectionType.REQUIRED)
			return portsRequired.remove(port);
		else
			return portsProvided.remove(port);
	}
	
	public void addPorts(Port...ports) {
		for(Port p:ports) {
			switch(p.getConnectionType()) {
				case REQUIRED:
					this.portsRequired.add(p);
					break;
				case PROVIDED:
					this.portsProvided.add(p);
					break;
			}
		}
	}
	
	
}
