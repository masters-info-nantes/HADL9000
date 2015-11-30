package org.alma.csa.m2.connectioninterface;

/**
 * Created by Maxime on 16/11/2015.
 */
public class Service extends ConnectionInterface {
    private ConnectionType connectionType = null;

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
}
