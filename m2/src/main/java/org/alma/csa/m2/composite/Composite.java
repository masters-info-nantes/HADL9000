package org.alma.csa.m2.composite;

import org.alma.csa.m2.connectioninterface.ConnectionType;
import org.alma.csa.m2.connectioninterface.Port;
import org.alma.csa.m2.connectioninterface.Role;
import org.alma.csa.m2.exceptions.HADLMinimumMultiplicityException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 16/11/2015.
 */
public abstract class Composite<P extends Port> {
    private List<P> portsRequired = new ArrayList<P>();
    private List<P> portsProvided = new ArrayList<P>();
    private List<P> ports = new ArrayList<P>();

    public Composite() {
    }

    public List<P> getPorts() {
        return ports;
    }

    public List<P> getPortsRequired() {
        return portsRequired;
    }

    public List<P> getPortsProvided() {
        return portsProvided;
    }

    public boolean removePort(P port) {
        if(port.getConnectionType() == ConnectionType.REQUIRED)
            return portsRequired.remove(port);
        else
            return portsProvided.remove(port);
    }

    public void addPort(P... ports) {
        for(P p:ports) {
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
