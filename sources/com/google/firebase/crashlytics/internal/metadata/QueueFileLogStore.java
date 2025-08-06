package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.metadata.QueueFile;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

class QueueFileLogStore implements FileLogStore {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private QueueFile logFile;
    private final int maxLogSize;
    private final File workingFile;

    public static class LogBytes {
        public final byte[] bytes;
        public final int offset;

        public LogBytes(byte[] bArr, int i11) {
            this.bytes = bArr;
            this.offset = i11;
        }
    }

    public QueueFileLogStore(File file, int i11) {
        this.workingFile = file;
        this.maxLogSize = i11;
    }

    private void doWriteToLog(long j11, String str) {
        if (this.logFile != null) {
            if (str == null) {
                str = OptionsBridge.NULL_VALUE;
            }
            try {
                int i11 = this.maxLogSize / 4;
                if (str.length() > i11) {
                    str = "..." + str.substring(str.length() - i11);
                }
                this.logFile.add(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j11), str.replaceAll("\r", " ").replaceAll("\n", " ")}).getBytes(UTF_8));
                while (!this.logFile.isEmpty() && this.logFile.usedBytes() > this.maxLogSize) {
                    this.logFile.remove();
                }
            } catch (IOException e11) {
                Logger.getLogger().e("There was a problem writing to the Crashlytics log.", e11);
            }
        }
    }

    private LogBytes getLogBytes() {
        if (!this.workingFile.exists()) {
            return null;
        }
        openLogFile();
        QueueFile queueFile = this.logFile;
        if (queueFile == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[queueFile.usedBytes()];
        try {
            this.logFile.forEach(new QueueFile.ElementReader() {
                public void read(InputStream inputStream, int i11) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i11);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i11;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e11) {
            Logger.getLogger().e("A problem occurred while reading the Crashlytics log file.", e11);
        }
        return new LogBytes(bArr, iArr[0]);
    }

    private void openLogFile() {
        if (this.logFile == null) {
            try {
                this.logFile = new QueueFile(this.workingFile);
            } catch (IOException e11) {
                Logger logger = Logger.getLogger();
                logger.e("Could not open log file: " + this.workingFile, e11);
            }
        }
    }

    public void closeLogFile() {
        CommonUtils.closeOrLog(this.logFile, "There was a problem closing the Crashlytics log file.");
        this.logFile = null;
    }

    public void deleteLogFile() {
        closeLogFile();
        this.workingFile.delete();
    }

    public byte[] getLogAsBytes() {
        LogBytes logBytes = getLogBytes();
        if (logBytes == null) {
            return null;
        }
        int i11 = logBytes.offset;
        byte[] bArr = new byte[i11];
        System.arraycopy(logBytes.bytes, 0, bArr, 0, i11);
        return bArr;
    }

    public String getLogAsString() {
        byte[] logAsBytes = getLogAsBytes();
        if (logAsBytes != null) {
            return new String(logAsBytes, UTF_8);
        }
        return null;
    }

    public void writeToLog(long j11, String str) {
        openLogFile();
        doWriteToLog(j11, str);
    }
}
