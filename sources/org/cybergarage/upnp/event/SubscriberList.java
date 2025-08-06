package org.cybergarage.upnp.event;

import java.util.Vector;

public class SubscriberList extends Vector {
    public Subscriber getSubscriber(int i11) {
        Object obj;
        try {
            obj = get(i11);
        } catch (Exception unused) {
            obj = null;
        }
        return (Subscriber) obj;
    }
}
