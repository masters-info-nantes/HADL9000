package org.alma.csa.m2.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Maxime on 16/11/2015.
 */
public abstract class Composite extends Observable{
    private List<Property> properties = new ArrayList<Property>();

	public List<Property> getProperties() {
		return properties;
	}

	public void addProperties(Property p) {
		properties.add(p);
	}
    
    

}
