package org.alma.csa.m2.connectioninterface;

import java.util.Observable;

/**
 * Created by Maxime on 16/11/2015.
 */
public abstract class ConnectionInterface extends Observable {


    private SynchronizationType synchronizationType = null;

    public SynchronizationType getSynchronizationType() {
        return synchronizationType;
    }

    public boolean setSynchronizationType(SynchronizationType synchronizationType) {
        if(synchronizationType == null) {
            this.synchronizationType = synchronizationType;
            return true;
        } else
            return false;
    }
}
