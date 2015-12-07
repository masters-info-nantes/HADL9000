package org.alma.csa.m2.connectioninterface;

import java.util.Observable;
import java.util.Observer;

public class Attachement  extends Observable implements Observer{

	public void update(Observable arg0, Object arg1) {
		this.setChanged();
		this.notifyObservers(arg1);
		
	} 

}
