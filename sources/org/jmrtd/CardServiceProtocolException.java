package org.jmrtd;

import net.sf.scuba.smartcards.CardServiceException;

public class CardServiceProtocolException extends CardServiceException {
    private static final long serialVersionUID = 8527846223511524125L;
    private int step;

    public CardServiceProtocolException(String str, int i11) {
        super(str);
        this.step = i11;
    }

    public String getMessage() {
        return super.getMessage() + " (" + "step: " + this.step + ")";
    }

    public int getStep() {
        return this.step;
    }

    public CardServiceProtocolException(String str, int i11, Throwable th2) {
        super(str, th2);
        this.step = i11;
    }

    public CardServiceProtocolException(String str, int i11, int i12) {
        super(str, i12);
        this.step = i11;
    }

    public CardServiceProtocolException(String str, int i11, Throwable th2, int i12) {
        super(str, th2, i12);
        this.step = i11;
    }
}
