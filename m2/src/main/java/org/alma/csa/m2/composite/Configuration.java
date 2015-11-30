package org.alma.csa.m2.composite;

import org.alma.csa.m2.connectioninterface.ConfigPort;
import org.alma.csa.m2.exceptions.HADLMinimumMultiplicityException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 16/11/2015.
 */
public class Configuration extends Composite {

    private List<Composite> composites = new ArrayList<Composite>();

    public List<Composite> getComposites() {
        return composites;
    }

    public void addComposite(Composite composite) {
        composites.add(composite);
    }

    public void removeComposite(Composite composite) {
        composites.remove(composite);
    }


}
