package org.jmrtd;

import java.io.Serializable;
import net.sf.scuba.smartcards.APDUEvent;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ResponseAPDU;

public class WrappedAPDUEvent extends APDUEvent {
    private static final long serialVersionUID = 5958662425525890224L;
    private CommandAPDU plainTextCommandAPDU;
    private ResponseAPDU plainTextResponseAPDU;

    public WrappedAPDUEvent(Object obj, Serializable serializable, int i11, CommandAPDU commandAPDU, ResponseAPDU responseAPDU, CommandAPDU commandAPDU2, ResponseAPDU responseAPDU2) {
        super(obj, serializable, i11, commandAPDU2, responseAPDU2);
        this.plainTextCommandAPDU = commandAPDU;
        this.plainTextResponseAPDU = responseAPDU;
    }

    public CommandAPDU getPlainTextCommandAPDU() {
        return this.plainTextCommandAPDU;
    }

    public ResponseAPDU getPlainTextResponseAPDU() {
        return this.plainTextResponseAPDU;
    }
}
