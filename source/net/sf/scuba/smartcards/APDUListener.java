package net.sf.scuba.smartcards;

import java.util.EventListener;

public interface APDUListener extends EventListener {
    void exchangedAPDU(APDUEvent aPDUEvent);
}
