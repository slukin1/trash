package net.sf.scuba.smartcards;

import java.util.EventObject;

public class CardEvent extends EventObject {
    public static final int INSERTED = 1;
    public static final int REMOVED = 0;
    private static final long serialVersionUID = -5645277246646615351L;
    private transient CardService service;
    private int type;

    public CardEvent(int i11, CardService cardService) {
        super(cardService);
        this.type = i11;
        this.service = cardService;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        CardEvent cardEvent = (CardEvent) obj;
        if (this.type != cardEvent.type || !this.service.equals(cardEvent.service)) {
            return false;
        }
        return true;
    }

    public CardService getService() {
        return this.service;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.service.hashCode() * 5) + (this.type * 7);
    }

    public String toString() {
        int i11 = this.type;
        if (i11 == 0) {
            return "Card removed from " + this.service;
        } else if (i11 == 1) {
            return "Card inserted in " + this.service;
        } else {
            throw new IllegalStateException("Unknown event type " + this.type);
        }
    }
}
