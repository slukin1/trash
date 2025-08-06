package com.tencent.android.tpns.mqtt.internal;

import com.sumsub.sns.internal.core.analytics.d;
import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.internal.wire.MqttAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnack;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSuback;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

public class Token {
    private static final String CLASS_NAME = "Token";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private IMqttActionListener callback = null;
    private IMqttAsyncClient client = null;
    private volatile boolean completed = false;
    private MqttException exception = null;
    private String key;
    public MqttMessage message = null;
    private int messageID = 0;
    private boolean notified = false;
    private boolean pendingComplete = false;
    private MqttWireMessage response = null;
    private Object responseLock = new Object();
    private boolean sent = false;
    private Object sentLock = new Object();
    private String[] topics = null;
    private Object userContext = null;

    public Token(String str) {
        log.setResourceName(str);
    }

    public boolean checkResult() throws MqttException {
        if (getException() == null) {
            return true;
        }
        throw getException();
    }

    public IMqttActionListener getActionCallback() {
        return this.callback;
    }

    public IMqttAsyncClient getClient() {
        return this.client;
    }

    public MqttException getException() {
        return this.exception;
    }

    public int[] getGrantedQos() {
        int[] iArr = new int[0];
        MqttWireMessage mqttWireMessage = this.response;
        return mqttWireMessage instanceof MqttSuback ? ((MqttSuback) mqttWireMessage).getGrantedQos() : iArr;
    }

    public String getKey() {
        return this.key;
    }

    public MqttMessage getMessage() {
        return this.message;
    }

    public int getMessageID() {
        return this.messageID;
    }

    public MqttWireMessage getResponse() {
        return this.response;
    }

    public boolean getSessionPresent() {
        MqttWireMessage mqttWireMessage = this.response;
        if (mqttWireMessage instanceof MqttConnack) {
            return ((MqttConnack) mqttWireMessage).getSessionPresent();
        }
        return false;
    }

    public String[] getTopics() {
        return this.topics;
    }

    public Object getUserContext() {
        return this.userContext;
    }

    public MqttWireMessage getWireMessage() {
        return this.response;
    }

    public boolean isComplete() {
        return this.completed;
    }

    public boolean isCompletePending() {
        return this.pendingComplete;
    }

    public boolean isInUse() {
        return getClient() != null && !isComplete();
    }

    public boolean isNotified() {
        return this.notified;
    }

    public void markComplete(MqttWireMessage mqttWireMessage, MqttException mqttException) {
        log.fine(CLASS_NAME, "markComplete", "404", new Object[]{getKey(), mqttWireMessage, mqttException});
        synchronized (this.responseLock) {
            if (mqttWireMessage instanceof MqttAck) {
                this.message = null;
            }
            this.pendingComplete = true;
            this.response = mqttWireMessage;
            this.exception = mqttException;
        }
    }

    public void notifyComplete() {
        log.fine(CLASS_NAME, "notifyComplete", "404", new Object[]{getKey(), this.response, this.exception});
        synchronized (this.responseLock) {
            if (this.exception != null || !this.pendingComplete) {
                this.pendingComplete = false;
            } else {
                this.completed = true;
                this.pendingComplete = false;
            }
            this.responseLock.notifyAll();
        }
        synchronized (this.sentLock) {
            this.sent = true;
            this.sentLock.notifyAll();
        }
    }

    public void notifySent() {
        log.fine(CLASS_NAME, "notifySent", "403", new Object[]{getKey()});
        synchronized (this.responseLock) {
            this.response = null;
            this.completed = false;
        }
        synchronized (this.sentLock) {
            this.sent = true;
            this.sentLock.notifyAll();
        }
    }

    public void reset() throws MqttException {
        if (!isInUse()) {
            log.fine(CLASS_NAME, "reset", "410", new Object[]{getKey()});
            this.client = null;
            this.completed = false;
            this.response = null;
            this.sent = false;
            this.exception = null;
            this.userContext = null;
            return;
        }
        throw new MqttException(32201);
    }

    public void setActionCallback(IMqttActionListener iMqttActionListener) {
        this.callback = iMqttActionListener;
    }

    public void setClient(IMqttAsyncClient iMqttAsyncClient) {
        this.client = iMqttAsyncClient;
    }

    public void setException(MqttException mqttException) {
        synchronized (this.responseLock) {
            this.exception = mqttException;
        }
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(MqttMessage mqttMessage) {
        this.message = mqttMessage;
    }

    public void setMessageID(int i11) {
        this.messageID = i11;
    }

    public void setNotified(boolean z11) {
        this.notified = z11;
    }

    public void setTopics(String[] strArr) {
        this.topics = strArr;
    }

    public void setUserContext(Object obj) {
        this.userContext = obj;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(getKey());
        stringBuffer.append(" ,topics=");
        if (getTopics() != null) {
            for (String append : getTopics()) {
                stringBuffer.append(append);
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(" ,usercontext=");
        stringBuffer.append(getUserContext());
        stringBuffer.append(" ,isComplete=");
        stringBuffer.append(isComplete());
        stringBuffer.append(" ,isNotified=");
        stringBuffer.append(isNotified());
        stringBuffer.append(" ,exception=");
        stringBuffer.append(getException());
        stringBuffer.append(" ,actioncallback=");
        stringBuffer.append(getActionCallback());
        return stringBuffer.toString();
    }

    public void waitForCompletion() throws MqttException {
        waitForCompletion(-1);
    }

    public MqttWireMessage waitForResponse() throws MqttException {
        return waitForResponse(-1);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|(4:12|13|34|32)(1:33)) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r1 != false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r1 = r8.exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r1 != null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        throw com.tencent.android.tpns.mqtt.internal.ExceptionHelper.createMqttException(6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x000b */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x000b A[LOOP:0: B:9:0x000b->B:32:0x000b, LOOP_START, SYNTHETIC, Splitter:B:9:0x000b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void waitUntilSent() throws com.tencent.android.tpns.mqtt.MqttException {
        /*
            r8 = this;
            java.lang.Object r0 = r8.sentLock
            monitor-enter(r0)
            java.lang.Object r1 = r8.responseLock     // Catch:{ all -> 0x003d }
            monitor-enter(r1)     // Catch:{ all -> 0x003d }
            com.tencent.android.tpns.mqtt.MqttException r2 = r8.exception     // Catch:{ all -> 0x003a }
            if (r2 != 0) goto L_0x0039
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
        L_0x000b:
            boolean r1 = r8.sent     // Catch:{ all -> 0x003d }
            if (r1 != 0) goto L_0x002a
            com.tencent.android.tpns.mqtt.logging.Logger r1 = log     // Catch:{ InterruptedException -> 0x000b }
            java.lang.String r2 = "Token"
            java.lang.String r3 = "waitUntilSent"
            java.lang.String r4 = "409"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ InterruptedException -> 0x000b }
            r6 = 0
            java.lang.String r7 = r8.getKey()     // Catch:{ InterruptedException -> 0x000b }
            r5[r6] = r7     // Catch:{ InterruptedException -> 0x000b }
            r1.fine(r2, r3, r4, r5)     // Catch:{ InterruptedException -> 0x000b }
            java.lang.Object r1 = r8.sentLock     // Catch:{ InterruptedException -> 0x000b }
            r1.wait()     // Catch:{ InterruptedException -> 0x000b }
            goto L_0x000b
        L_0x002a:
            if (r1 != 0) goto L_0x0037
            com.tencent.android.tpns.mqtt.MqttException r1 = r8.exception     // Catch:{ all -> 0x003d }
            if (r1 != 0) goto L_0x0036
            r1 = 6
            com.tencent.android.tpns.mqtt.MqttException r1 = com.tencent.android.tpns.mqtt.internal.ExceptionHelper.createMqttException((int) r1)     // Catch:{ all -> 0x003d }
            throw r1     // Catch:{ all -> 0x003d }
        L_0x0036:
            throw r1     // Catch:{ all -> 0x003d }
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            return
        L_0x0039:
            throw r2     // Catch:{ all -> 0x003a }
        L_0x003a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            throw r2     // Catch:{ all -> 0x003d }
        L_0x003d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.Token.waitUntilSent():void");
    }

    public void waitForCompletion(long j11) throws MqttException {
        log.fine(CLASS_NAME, "waitForCompletion", "407", new Object[]{getKey(), new Long(j11), this});
        if (waitForResponse(j11) != null || this.completed) {
            checkResult();
            return;
        }
        TBaseLogger.e(CLASS_NAME, "waitForCompletion timeout");
        MqttException mqttException = new MqttException(32000);
        this.exception = mqttException;
        throw mqttException;
    }

    public MqttWireMessage waitForResponse(long j11) throws MqttException {
        long j12 = j11;
        synchronized (this.responseLock) {
            Logger logger = log;
            Object[] objArr = new Object[7];
            objArr[0] = getKey();
            objArr[1] = new Long(j12);
            objArr[2] = new Boolean(this.sent);
            objArr[3] = new Boolean(this.completed);
            MqttException mqttException = this.exception;
            objArr[4] = mqttException == null ? d.f31895b : "true";
            objArr[5] = this.response;
            objArr[6] = this;
            logger.fine(CLASS_NAME, "waitForResponse", "400", objArr, mqttException);
            while (true) {
                if (this.completed) {
                    break;
                }
                if (this.exception == null) {
                    try {
                        log.fine(CLASS_NAME, "waitForResponse", "408", new Object[]{getKey(), new Long(j12)});
                        if (j12 <= 0) {
                            this.responseLock.wait();
                        } else {
                            this.responseLock.wait(j12);
                        }
                    } catch (InterruptedException e11) {
                        this.exception = new MqttException((Throwable) e11);
                    }
                }
                if (!this.completed) {
                    MqttException mqttException2 = this.exception;
                    if (mqttException2 != null) {
                        log.fine(CLASS_NAME, "waitForResponse", "401", (Object[]) null, mqttException2);
                        throw this.exception;
                    } else if (j12 > 0) {
                        break;
                    }
                }
            }
        }
        log.fine(CLASS_NAME, "waitForResponse", "402", new Object[]{getKey(), this.response});
        return this.response;
    }
}
