package net.sf.scuba.smartcards;

public interface APDUWrapper {
    String getType();

    ResponseAPDU unwrap(ResponseAPDU responseAPDU);

    CommandAPDU wrap(CommandAPDU commandAPDU);
}
