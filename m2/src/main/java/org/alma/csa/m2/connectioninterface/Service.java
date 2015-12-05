package org.alma.csa.m2.connectioninterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 16/11/2015.
 */
public class Service extends ConnectionInterface {
    private ConnectionType connectionType = null;
    private List<Port> ports = new ArrayList<Port>();

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
    
    public List<Port> getPorts() {
		return ports;
	}

	public void addPorts(Port port) {
		this.ports.add(port);
	}
}
