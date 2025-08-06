package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;

public class LogFileManager {
    private static final String LOGFILE_NAME = "userlog";
    public static final int MAX_LOG_SIZE = 65536;
    private static final NoopLogStore NOOP_LOG_STORE = new NoopLogStore();
    private FileLogStore currentLog;
    private final FileStore fileStore;

    public static final class NoopLogStore implements FileLogStore {
        private NoopLogStore() {
        }

        public void closeLogFile() {
        }

        public void deleteLogFile() {
        }

        public byte[] getLogAsBytes() {
            return null;
        }

        public String getLogAsString() {
            return null;
        }

        public void writeToLog(long j11, String str) {
        }
    }

    public LogFileManager(FileStore fileStore2) {
        this.fileStore = fileStore2;
        this.currentLog = NOOP_LOG_STORE;
    }

    private File getWorkingFileForSession(String str) {
        return this.fileStore.getSessionFile(str, LOGFILE_NAME);
    }

    public void clearLog() {
        this.currentLog.deleteLogFile();
    }

    public byte[] getBytesForLog() {
        return this.currentLog.getLogAsBytes();
    }

    public String getLogString() {
        return this.currentLog.getLogAsString();
    }

    public final void setCurrentSession(String str) {
        this.currentLog.closeLogFile();
        this.currentLog = NOOP_LOG_STORE;
        if (str != null) {
            setLogFile(getWorkingFileForSession(str), 65536);
        }
    }

    public void setLogFile(File file, int i11) {
        this.currentLog = new QueueFileLogStore(file, i11);
    }

    public void writeToLog(long j11, String str) {
        this.currentLog.writeToLog(j11, str);
    }

    public LogFileManager(FileStore fileStore2, String str) {
        this(fileStore2);
        setCurrentSession(str);
    }
}
