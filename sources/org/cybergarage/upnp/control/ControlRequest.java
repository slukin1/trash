package org.cybergarage.upnp.control;

import org.cybergarage.soap.SOAPRequest;

public class ControlRequest extends SOAPRequest {
    public boolean X0() {
        return V0("urn:schemas-upnp-org:control-1-0#QueryStateVariable");
    }
}
