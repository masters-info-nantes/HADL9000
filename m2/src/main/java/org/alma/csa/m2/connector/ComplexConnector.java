package org.alma.csa.m2.connector;

import java.util.ArrayList;
import java.util.List;

import org.alma.csa.m2.composite.Composite;

public class ComplexConnector extends Connector {

	private List<Composite> components = new ArrayList<Composite>();

	public List<Composite> getComponents() {
		return components;
	}

	public void addComponent(Composite c) {
		this.components.add(c);
	}
	
	

}
