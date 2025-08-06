package com.zopim.android.sdk.api;

import com.xiaomi.mipush.sdk.Constants;
import com.zendesk.logger.Logger;
import java.io.File;
import java.util.Map;
import mz.b;

public enum FileTransfers {
    INSTANCE;
    
    private static final String LOG_TAG = "FileTransfers";
    public Map<String, Info> transfers;

    public static class Info {
        public File file;
        public Status status;

        public Info() {
            this.status = Status.UNKNOWN;
        }
    }

    public enum Status {
        UNKNOWN,
        SCHEDULED,
        STARTED,
        COMPLETED,
        FAILED
    }

    private String createUniqueName(File file) {
        String replace = (file.getName() != null ? file.getName() : "").replace(" ", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        short s11 = 0;
        do {
            try {
                if (!this.transfers.containsKey(replace)) {
                    break;
                }
                String a11 = b.a(file.getName());
                String str = file.getName().split(a11)[0];
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                s11 = (short) (s11 + 1);
                sb2.append(s11);
                sb2.append(a11);
                replace = sb2.toString();
            } catch (IndexOutOfBoundsException unused) {
                Logger.l(LOG_TAG, "Error generating unique file name. Will use the actual file name.", new Object[0]);
                return null;
            }
        } while (s11 < Short.MAX_VALUE);
        return replace;
    }

    private Map.Entry<String, Info> findTransfer(File file) {
        if (file == null) {
            return null;
        }
        for (Map.Entry<String, Info> next : this.transfers.entrySet()) {
            Info value = next.getValue();
            if (value != null && file.equals(value.file)) {
                return next;
            }
        }
        return null;
    }

    public String add(File file) {
        if (file == null || file.getName() == null) {
            Logger.l(LOG_TAG, "File validation failed. Can not add file to scheduled set.", new Object[0]);
            return "";
        }
        Map.Entry<String, Info> findTransfer = findTransfer(file);
        if (findTransfer != null) {
            findTransfer.getValue().status = Status.SCHEDULED;
            return findTransfer.getKey();
        }
        String createUniqueName = createUniqueName(file);
        Info info = new Info();
        info.file = file;
        info.status = Status.SCHEDULED;
        INSTANCE.transfers.put(createUniqueName, info);
        return createUniqueName;
    }

    public Info find(File file) {
        if (file == null) {
            return null;
        }
        for (Info next : this.transfers.values()) {
            if (file.equals(next.file)) {
                return next;
            }
        }
        return null;
    }

    public File findFile(String str) {
        if (str == null) {
            Logger.l(LOG_TAG, "File name must not be null. Can not find file.", new Object[0]);
            return null;
        }
        Info info = this.transfers.get(str);
        if (info != null) {
            return info.file;
        }
        return null;
    }
}
