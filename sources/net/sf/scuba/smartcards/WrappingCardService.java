package net.sf.scuba.smartcards;

public class WrappingCardService extends CardService {
    private boolean enabled;
    private CardService service;
    private APDUWrapper wrapper;

    public WrappingCardService(CardService cardService, APDUWrapper aPDUWrapper) {
        this.service = cardService;
        this.wrapper = aPDUWrapper;
    }

    public void close() {
        this.service.close();
    }

    public void disable() {
        this.enabled = false;
    }

    public void enable() {
        this.enabled = true;
    }

    public byte[] getATR() throws CardServiceException {
        return this.service.getATR();
    }

    public boolean isConnectionLost(Exception exc) {
        return this.service.isConnectionLost(exc);
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isOpen() {
        return this.service.isOpen();
    }

    public void open() throws CardServiceException {
        this.service.open();
    }

    public ResponseAPDU transmit(CommandAPDU commandAPDU) throws CardServiceException {
        if (!isEnabled()) {
            return this.service.transmit(commandAPDU);
        }
        return this.wrapper.unwrap(this.service.transmit(this.wrapper.wrap(commandAPDU)));
    }
}
