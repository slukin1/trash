package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.protocol.module.Console;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ResponseHandlingInputStream extends FilterInputStream {
    private static final int BUFFER_SIZE = 1024;
    public static final String TAG = "ResponseHandlingInputStream";
    private boolean mClosed;
    private final CountingOutputStream mDecompressedCounter;
    private boolean mEofSeen;
    private long mLastDecompressedCount = 0;
    private final ChromePeerManager mNetworkPeerManager;
    private final OutputStream mOutputStream;
    private final String mRequestId;
    private final ResponseHandler mResponseHandler;
    private byte[] mSkipBuffer;

    public ResponseHandlingInputStream(InputStream inputStream, String str, OutputStream outputStream, CountingOutputStream countingOutputStream, ChromePeerManager chromePeerManager, ResponseHandler responseHandler) {
        super(inputStream);
        this.mRequestId = str;
        this.mOutputStream = outputStream;
        this.mDecompressedCounter = countingOutputStream;
        this.mNetworkPeerManager = chromePeerManager;
        this.mResponseHandler = responseHandler;
        this.mClosed = false;
    }

    private synchronized int checkEOF(int i11) {
        if (i11 == -1) {
            closeOutputStreamQuietly();
            this.mResponseHandler.onEOF();
            this.mEofSeen = true;
        }
        return i11;
    }

    private synchronized void closeOutputStreamQuietly() {
        if (!this.mClosed) {
            try {
                this.mOutputStream.close();
                reportDecodedSizeIfApplicable();
            } catch (IOException e11) {
                try {
                    ChromePeerManager chromePeerManager = this.mNetworkPeerManager;
                    Console.MessageLevel messageLevel = Console.MessageLevel.ERROR;
                    Console.MessageSource messageSource = Console.MessageSource.NETWORK;
                    CLog.writeToConsole(chromePeerManager, messageLevel, messageSource, "Could not close the output stream" + e11);
                } catch (Throwable th2) {
                    this.mClosed = true;
                    throw th2;
                }
            }
            this.mClosed = true;
        }
    }

    private byte[] getSkipBufferLocked() {
        if (this.mSkipBuffer == null) {
            this.mSkipBuffer = new byte[1024];
        }
        return this.mSkipBuffer;
    }

    private IOException handleIOException(IOException iOException) {
        this.mResponseHandler.onError(iOException);
        return iOException;
    }

    private void handleIOExceptionWritingToStream(IOException iOException) {
        ChromePeerManager chromePeerManager = this.mNetworkPeerManager;
        Console.MessageLevel messageLevel = Console.MessageLevel.ERROR;
        Console.MessageSource messageSource = Console.MessageSource.NETWORK;
        CLog.writeToConsole(chromePeerManager, messageLevel, messageSource, "Could not write response body to the stream " + iOException);
        closeOutputStreamQuietly();
    }

    private void reportDecodedSizeIfApplicable() {
        CountingOutputStream countingOutputStream = this.mDecompressedCounter;
        if (countingOutputStream != null) {
            long count = countingOutputStream.getCount();
            this.mResponseHandler.onReadDecoded((int) (count - this.mLastDecompressedCount));
            this.mLastDecompressedCount = count;
        }
    }

    private synchronized void writeToOutputStream(int i11) {
        if (!this.mClosed) {
            try {
                this.mOutputStream.write(i11);
                reportDecodedSizeIfApplicable();
            } catch (IOException e11) {
                handleIOExceptionWritingToStream(e11);
            }
        } else {
            return;
        }
        return;
    }

    public void close() throws IOException {
        long j11;
        try {
            if (!this.mEofSeen) {
                byte[] bArr = new byte[1024];
                j11 = 0;
                while (true) {
                    int read = read(bArr);
                    if (read == -1) {
                        break;
                    }
                    j11 += (long) read;
                }
            } else {
                j11 = 0;
            }
            if (j11 > 0) {
                CLog.writeToConsole(this.mNetworkPeerManager, Console.MessageLevel.ERROR, Console.MessageSource.NETWORK, "There were " + String.valueOf(j11) + " bytes that were not consumed while processing request " + this.mRequestId);
            }
        } finally {
            super.close();
            closeOutputStreamQuietly();
        }
    }

    public void mark(int i11) {
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        try {
            int checkEOF = checkEOF(this.in.read());
            if (checkEOF != -1) {
                this.mResponseHandler.onRead(1);
                writeToOutputStream(checkEOF);
            }
            return checkEOF;
        } catch (IOException e11) {
            throw handleIOException(e11);
        }
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException("Mark not supported");
    }

    public synchronized long skip(long j11) throws IOException {
        long j12;
        byte[] skipBufferLocked = getSkipBufferLocked();
        j12 = 0;
        while (j12 < j11) {
            int read = read(skipBufferLocked, 0, (int) Math.min((long) skipBufferLocked.length, j11 - j12));
            if (read == -1) {
                break;
            }
            j12 += (long) read;
        }
        return j12;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        try {
            int checkEOF = checkEOF(this.in.read(bArr, i11, i12));
            if (checkEOF != -1) {
                this.mResponseHandler.onRead(checkEOF);
                writeToOutputStream(bArr, i11, checkEOF);
            }
            return checkEOF;
        } catch (IOException e11) {
            throw handleIOException(e11);
        }
    }

    private synchronized void writeToOutputStream(byte[] bArr, int i11, int i12) {
        if (!this.mClosed) {
            try {
                this.mOutputStream.write(bArr, i11, i12);
                reportDecodedSizeIfApplicable();
            } catch (IOException e11) {
                handleIOExceptionWritingToStream(e11);
            }
        } else {
            return;
        }
        return;
    }
}
