package org.alma.csa.m2.composite;

import java.util.ArrayList;
import java.util.List;

import org.alma.csa.m2.connectioninterface.ConfigPort;
import org.alma.csa.m2.connectioninterface.ConnectionType;
import org.alma.csa.m2.connectioninterface.Port;

/**
 * Created by Maxime on 16/11/2015.
 */
public class Configuration extends Composite {

    private List<Composite> composites = new ArrayList<Composite>();
    private List<ConfigPort> configPortsRequired = new ArrayList<ConfigPort>();
    private List<ConfigPort> configPortsProvided = new ArrayList<ConfigPort>();

    public List<Composite> getComposites() {
        return composites;
    }
    
    public List<ConfigPort> getConfigPortsRequired() {
		return configPortsRequired;
	}

	public List<ConfigPort> getConfigPortsProvided() {
		return configPortsProvided;
	}

    public void addComposite(Composite composite) {
        composites.add(composite);
    }

    public void removeComposite(Composite composite) {
        composites.remove(composite);
    }

    public boolean removeConfigPort(ConfigPort cPort) {
		if(cPort.getConnectionType() == ConnectionType.REQUIRED)
			return configPortsRequired.remove(cPort);
		else
			return configPortsProvided.remove(cPort);
	}
	
	public void addConfigPorts(ConfigPort... cPorts) {
		for(ConfigPort cp:cPorts) {
			switch(cp.getConnectionType()) {
				case REQUIRED:
					this.configPortsRequired.add(cp);
					break;
				case PROVIDED:
					this.configPortsProvided.add(cp);
					break;
			}
		}
	}

}
