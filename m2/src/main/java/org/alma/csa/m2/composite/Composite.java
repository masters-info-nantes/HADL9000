package org.alma.csa.m2.composite;

import org.alma.csa.m2.connectioninterface.Port;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 16/11/2015.
 */
public abstract class Composite<P extends Port> {
    private List<Property> properties = new ArrayList<Property>();

	public List<Property> getProperties() {
		return properties;
	}

	public void addProperties(Property p) {
		properties.add(p);
	}
    
    

}
