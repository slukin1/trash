package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.HashMap;
import java.util.Map;

public enum TransferState {
    WAITING,
    IN_PROGRESS,
    PAUSED,
    RESUMED_WAITING,
    COMPLETED,
    CANCELED,
    FAILED,
    WAITING_FOR_NETWORK,
    PART_COMPLETED,
    PENDING_CANCEL,
    PENDING_PAUSE,
    PENDING_NETWORK_DISCONNECT,
    UNKNOWN;
    
    private static final Log LOGGER = null;
    private static final Map<String, TransferState> MAP = null;

    /* access modifiers changed from: public */
    static {
        int i11;
        MAP = new HashMap();
        for (TransferState transferState : values()) {
            MAP.put(transferState.toString(), transferState);
        }
        LOGGER = LogFactory.b(TransferState.class);
    }

    public static TransferState getState(String str) {
        Map<String, TransferState> map = MAP;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        Log log = LOGGER;
        log.c("Unknown state " + str + " transfer will be have state set to UNKNOWN.");
        return UNKNOWN;
    }

    public static boolean isFinalState(TransferState transferState) {
        return COMPLETED.equals(transferState) || FAILED.equals(transferState) || CANCELED.equals(transferState);
    }
}
