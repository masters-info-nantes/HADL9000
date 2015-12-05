package org.alma.csa.m2.connectioninterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 16/11/2015.
 */
public class ConfigPort extends Port {
	
	List<Port> bindTo = new ArrayList<Port>();

	public List<Port> getBindTo() {
		return bindTo;
	}

	public void addBinding(Port p) {
		bindTo.add(p);
	}
	
	
}
