package org.alma.csa.m2.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.alma.csa.m2.connectioninterface.ConnectionType;
import org.alma.csa.m2.connectioninterface.Port;
import org.alma.csa.m2.connectioninterface.Service;

/**
 * Created by Maxime on 16/11/2015.
 */
public class Component extends Composite implements Observer {
	
	List<Service> servicesRequired = new ArrayList<Service>();
	List<Service> servicesProvided = new ArrayList<Service>();
	List<Port> portsRequired = new ArrayList<Port>();
	List<Port> portsProvided = new ArrayList<Port>();
	
	public List<Service> getServicesRequired() {
		return servicesRequired;
	}

	public List<Service> getServicesProvided() {
		return servicesProvided;
	}
	
	public List<Port> getPortsRequired() {
		return portsRequired;
	}

	public List<Port> getPortsProvided() {
		return portsProvided;
	}

	public boolean removeService(Service service) {
		if(service.getConnectionType() == ConnectionType.REQUIRED)
			return servicesRequired.remove(service);
		else
			return servicesProvided.remove(service);
	}
	
	public void addServices(Service...services) {
		for(Service s:services) {
			switch(s.getConnectionType()) {
				case REQUIRED:
					this.servicesRequired.add(s);
					break;
				case PROVIDED:
					this.servicesProvided.add(s);
					break;
			}
		}
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

	public void update(Observable arg0, Object arg1) {
		System.out.println("[" + this.getClass().getName() + ". update]: " + arg1.toString());
		
		this.setChanged();
        this.notifyObservers(arg1);
		
	}
	
}
