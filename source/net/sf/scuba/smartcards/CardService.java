package net.sf.scuba.smartcards;

import com.sumsub.sns.internal.nfc.d;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CardService {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba");
    public static final int SESSION_STARTED_STATE = 1;
    public static final int SESSION_STOPPED_STATE = 0;
    private static final Map<String, String> objectToServiceMap;
    private Collection<APDUListener> apduListeners = new HashSet();
    public int state = 0;

    static {
        HashMap hashMap = new HashMap();
        objectToServiceMap = hashMap;
        hashMap.put("javax.smartcardio.CardTerminal", "net.sf.scuba.smartcards.TerminalCardService");
        hashMap.put("sun.security.smartcardio.TerminalImpl", "net.sf.scuba.smartcards.TerminalCardService");
        hashMap.put(d.f35146i, "net.sf.scuba.smartcards.IsoDepCardService");
    }

    public static CardService getInstance(Object obj) {
        if (obj != null) {
            String canonicalName = obj.getClass().getCanonicalName();
            for (Map.Entry next : objectToServiceMap.entrySet()) {
                try {
                    Class<?> cls = Class.forName((String) next.getKey());
                    String str = (String) next.getValue();
                    if (cls.isInstance(obj)) {
                        return (CardService) Class.forName(str).getConstructor(new Class[]{cls}).newInstance(new Object[]{obj});
                    }
                    continue;
                } catch (Exception e11) {
                    throw new IllegalArgumentException(e11);
                } catch (ClassNotFoundException e12) {
                    LOGGER.log(Level.FINEST, "Could not find class, trying next one", e12);
                }
            }
            throw new IllegalArgumentException("Could not find a CardService for object of class \"" + canonicalName + "\"");
        }
        throw new IllegalArgumentException();
    }

    public void addAPDUListener(APDUListener aPDUListener) {
        Collection<APDUListener> collection = this.apduListeners;
        if (collection != null && aPDUListener != null) {
            collection.add(aPDUListener);
        }
    }

    public abstract void close();

    public Collection<APDUListener> getAPDUListeners() {
        return Collections.unmodifiableCollection(this.apduListeners);
    }

    public abstract byte[] getATR() throws CardServiceException;

    public abstract boolean isConnectionLost(Exception exc);

    public boolean isExtendedAPDULengthSupported() {
        return false;
    }

    public abstract boolean isOpen();

    public void notifyExchangedAPDU(APDUEvent aPDUEvent) {
        Collection<APDUListener> collection = this.apduListeners;
        if (collection != null && !collection.isEmpty()) {
            for (APDUListener exchangedAPDU : this.apduListeners) {
                exchangedAPDU.exchangedAPDU(aPDUEvent);
            }
        }
    }

    public abstract void open() throws CardServiceException;

    public void removeAPDUListener(APDUListener aPDUListener) {
        Collection<APDUListener> collection = this.apduListeners;
        if (collection != null) {
            collection.remove(aPDUListener);
        }
    }

    public abstract ResponseAPDU transmit(CommandAPDU commandAPDU) throws CardServiceException;
}
