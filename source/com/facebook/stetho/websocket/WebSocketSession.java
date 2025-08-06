package com.facebook.stetho.websocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class WebSocketSession implements SimpleSession {
    /* access modifiers changed from: private */
    public final SimpleEndpoint mEndpoint;
    private final WriteCallback mErrorForwardingWriteCallback = new WriteCallback() {
        public void onFailure(IOException iOException) {
            WebSocketSession.this.signalError(iOException);
        }

        public void onSuccess() {
        }
    };
    private AtomicBoolean mIsOpen = new AtomicBoolean(false);
    private final ReadCallback mReadCallback = new ReadCallback() {
        private void handleBinaryFrame(byte[] bArr, int i11) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, bArr, i11);
        }

        private void handleClose(byte[] bArr, int i11) {
            String str;
            byte b11;
            if (i11 >= 2) {
                b11 = ((bArr[0] & 255) << 8) | (bArr[1] & 255);
                str = i11 > 2 ? new String(bArr, 2, i11 - 2) : null;
            } else {
                b11 = 1006;
                str = "Unparseable close frame";
            }
            if (!WebSocketSession.this.mSentClose) {
                WebSocketSession.this.sendClose(1000, "Received close frame");
            }
            WebSocketSession.this.markAndSignalClosed(b11, str);
        }

        private void handlePing(byte[] bArr, int i11) {
            WebSocketSession.this.doWrite(FrameHelper.createPongFrame(bArr, i11));
        }

        private void handlePong(byte[] bArr, int i11) {
        }

        private void handleTextFrame(byte[] bArr, int i11) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, new String(bArr, 0, i11));
        }

        public void onCompleteFrame(byte b11, byte[] bArr, int i11) {
            if (b11 == 1) {
                handleTextFrame(bArr, i11);
            } else if (b11 != 2) {
                switch (b11) {
                    case 8:
                        handleClose(bArr, i11);
                        return;
                    case 9:
                        handlePing(bArr, i11);
                        return;
                    case 10:
                        handlePong(bArr, i11);
                        return;
                    default:
                        WebSocketSession webSocketSession = WebSocketSession.this;
                        webSocketSession.signalError(new IOException("Unsupported frame opcode=" + b11));
                        return;
                }
            } else {
                handleBinaryFrame(bArr, i11);
            }
        }
    };
    private final ReadHandler mReadHandler;
    /* access modifiers changed from: private */
    public volatile boolean mSentClose;
    private final WriteHandler mWriteHandler;

    public WebSocketSession(InputStream inputStream, OutputStream outputStream, SimpleEndpoint simpleEndpoint) {
        this.mReadHandler = new ReadHandler(inputStream, simpleEndpoint);
        this.mWriteHandler = new WriteHandler(outputStream);
        this.mEndpoint = simpleEndpoint;
    }

    /* access modifiers changed from: private */
    public void doWrite(Frame frame) {
        if (!signalErrorIfNotOpen()) {
            this.mWriteHandler.write(frame, this.mErrorForwardingWriteCallback);
        }
    }

    /* access modifiers changed from: private */
    public void sendClose(int i11, String str) {
        doWrite(FrameHelper.createCloseFrame(i11, str));
        markSentClose();
    }

    /* access modifiers changed from: private */
    public void signalError(IOException iOException) {
        this.mEndpoint.onError(this, iOException);
    }

    private boolean signalErrorIfNotOpen() {
        if (isOpen()) {
            return false;
        }
        signalError(new IOException("Session is closed"));
        return true;
    }

    public void close(int i11, String str) {
        sendClose(i11, str);
        markAndSignalClosed(i11, str);
    }

    public void handle() throws IOException {
        markAndSignalOpen();
        try {
            this.mReadHandler.readLoop(this.mReadCallback);
        } catch (EOFException unused) {
            markAndSignalClosed(1011, "EOF while reading");
        } catch (IOException e11) {
            markAndSignalClosed(1006, (String) null);
            throw e11;
        }
    }

    public boolean isOpen() {
        return this.mIsOpen.get();
    }

    public void markAndSignalClosed(int i11, String str) {
        if (this.mIsOpen.getAndSet(false)) {
            this.mEndpoint.onClose(this, i11, str);
        }
    }

    public void markAndSignalOpen() {
        if (!this.mIsOpen.getAndSet(true)) {
            this.mEndpoint.onOpen(this);
        }
    }

    public void markSentClose() {
        this.mSentClose = true;
    }

    public void sendBinary(byte[] bArr) {
        doWrite(FrameHelper.createBinaryFrame(bArr));
    }

    public void sendText(String str) {
        doWrite(FrameHelper.createTextFrame(str));
    }
}
