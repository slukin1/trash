package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import com.tencent.android.tpns.mqtt.MqttPingSender;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.internal.wire.MqttAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnack;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPingReq;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPingResp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubComp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubRec;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubRel;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSuback;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSubscribe;
import com.tencent.android.tpns.mqtt.internal.wire.MqttUnsubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttUnsubscribe;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.EOFException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

public class ClientState {
    private static final String CLASS_NAME = "ClientState";
    private static final int MAX_MSG_ID = 65535;
    private static final int MIN_MSG_ID = 1;
    private static final String PERSISTENCE_CONFIRMED_PREFIX = "sc-";
    private static final String PERSISTENCE_RECEIVED_PREFIX = "r-";
    private static final String PERSISTENCE_SENT_BUFFERED_PREFIX = "sb-";
    private static final String PERSISTENCE_SENT_PREFIX = "s-";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private int actualInFlight = 0;
    private CommsCallback callback = null;
    private boolean cleanSession;
    private ClientComms clientComms = null;
    private boolean connected = false;
    private int inFlightPubRels = 0;
    private Hashtable inUseMsgIds;
    private Hashtable inboundQoS2 = null;
    private long keepAlive;
    private long lastInboundActivity = 0;
    private long lastOutboundActivity = 0;
    private long lastPing = 0;
    private int maxInflight = 0;
    private int nextMsgId = 0;
    private Hashtable outboundQoS0 = null;
    private Hashtable outboundQoS1 = null;
    private Hashtable outboundQoS2 = null;
    private volatile Vector pendingFlows;
    private volatile Vector pendingMessages;
    private MqttClientPersistence persistence;
    private MqttWireMessage pingCommand;
    private int pingOutstanding = 0;
    private Object pingOutstandingLock = new Object();
    private MqttPingSender pingSender = null;
    private Object queueLock = new Object();
    private Object quiesceLock = new Object();
    private boolean quiescing = false;
    private CommsTokenStore tokenStore;

    public ClientState(MqttClientPersistence mqttClientPersistence, CommsTokenStore commsTokenStore, CommsCallback commsCallback, ClientComms clientComms2, MqttPingSender mqttPingSender) throws MqttException {
        Logger logger = log;
        logger.setResourceName(clientComms2.getClient().getClientId());
        logger.finer(CLASS_NAME, "<Init>", "");
        this.inUseMsgIds = new Hashtable();
        this.pendingFlows = new Vector();
        this.outboundQoS2 = new Hashtable();
        this.outboundQoS1 = new Hashtable();
        this.outboundQoS0 = new Hashtable();
        this.inboundQoS2 = new Hashtable();
        this.pingCommand = new MqttPingReq();
        this.inFlightPubRels = 0;
        this.actualInFlight = 0;
        this.persistence = mqttClientPersistence;
        this.callback = commsCallback;
        this.tokenStore = commsTokenStore;
        this.clientComms = clientComms2;
        this.pingSender = mqttPingSender;
        restoreState();
    }

    private void decrementInFlight() {
        synchronized (this.queueLock) {
            int i11 = this.actualInFlight - 1;
            this.actualInFlight = i11;
            log.fine(CLASS_NAME, "decrementInFlight", "646", new Object[]{new Integer(i11)});
            if (!checkQuiesceLock()) {
                this.queueLock.notifyAll();
            }
        }
    }

    private synchronized int getNextMessageId() throws MqttException {
        int i11;
        int i12 = this.nextMsgId;
        int i13 = 0;
        do {
            int i14 = this.nextMsgId + 1;
            this.nextMsgId = i14;
            if (i14 > 65535) {
                this.nextMsgId = 1;
            }
            i11 = this.nextMsgId;
            if (i11 == i12) {
                i13++;
                if (i13 == 2) {
                    throw ExceptionHelper.createMqttException(32001);
                }
            }
        } while (this.inUseMsgIds.containsKey(new Integer(i11)));
        Integer num = new Integer(this.nextMsgId);
        this.inUseMsgIds.put(num, num);
        return this.nextMsgId;
    }

    private String getReceivedPersistenceKey(MqttWireMessage mqttWireMessage) {
        return PERSISTENCE_RECEIVED_PREFIX + mqttWireMessage.getMessageId();
    }

    private String getSendBufferedPersistenceKey(MqttWireMessage mqttWireMessage) {
        return PERSISTENCE_SENT_BUFFERED_PREFIX + mqttWireMessage.getMessageId();
    }

    private String getSendConfirmPersistenceKey(MqttWireMessage mqttWireMessage) {
        return PERSISTENCE_CONFIRMED_PREFIX + mqttWireMessage.getMessageId();
    }

    private String getSendPersistenceKey(MqttWireMessage mqttWireMessage) {
        return PERSISTENCE_SENT_PREFIX + mqttWireMessage.getMessageId();
    }

    private void insertInOrder(Vector vector, MqttWireMessage mqttWireMessage) {
        int messageId = mqttWireMessage.getMessageId();
        for (int i11 = 0; i11 < vector.size(); i11++) {
            if (((MqttWireMessage) vector.elementAt(i11)).getMessageId() > messageId) {
                vector.insertElementAt(mqttWireMessage, i11);
                return;
            }
        }
        vector.addElement(mqttWireMessage);
    }

    private Vector reOrder(Vector vector) {
        Vector vector2 = new Vector();
        if (vector.size() == 0) {
            return vector2;
        }
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 < vector.size()) {
            int messageId = ((MqttWireMessage) vector.elementAt(i11)).getMessageId();
            int i15 = messageId - i12;
            if (i15 > i13) {
                i14 = i11;
                i13 = i15;
            }
            i11++;
            i12 = messageId;
        }
        if ((65535 - i12) + ((MqttWireMessage) vector.elementAt(0)).getMessageId() > i13) {
            i14 = 0;
        }
        for (int i16 = i14; i16 < vector.size(); i16++) {
            vector2.addElement(vector.elementAt(i16));
        }
        for (int i17 = 0; i17 < i14; i17++) {
            vector2.addElement(vector.elementAt(i17));
        }
        return vector2;
    }

    private synchronized void releaseMessageId(int i11) {
        this.inUseMsgIds.remove(new Integer(i11));
    }

    private void restoreInflightMessages() {
        this.pendingMessages = new Vector(this.maxInflight);
        this.pendingFlows = new Vector();
        Enumeration keys = this.outboundQoS2.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            MqttWireMessage mqttWireMessage = (MqttWireMessage) this.outboundQoS2.get(nextElement);
            if (mqttWireMessage instanceof MqttPublish) {
                log.fine(CLASS_NAME, "restoreInflightMessages", "610", new Object[]{nextElement});
                mqttWireMessage.setDuplicate(true);
                insertInOrder(this.pendingMessages, (MqttPublish) mqttWireMessage);
            } else if (mqttWireMessage instanceof MqttPubRel) {
                log.fine(CLASS_NAME, "restoreInflightMessages", "611", new Object[]{nextElement});
                insertInOrder(this.pendingFlows, (MqttPubRel) mqttWireMessage);
            }
        }
        Enumeration keys2 = this.outboundQoS1.keys();
        while (keys2.hasMoreElements()) {
            Object nextElement2 = keys2.nextElement();
            MqttPublish mqttPublish = (MqttPublish) this.outboundQoS1.get(nextElement2);
            mqttPublish.setDuplicate(true);
            log.fine(CLASS_NAME, "restoreInflightMessages", "612", new Object[]{nextElement2});
            insertInOrder(this.pendingMessages, mqttPublish);
        }
        Enumeration keys3 = this.outboundQoS0.keys();
        while (keys3.hasMoreElements()) {
            Object nextElement3 = keys3.nextElement();
            log.fine(CLASS_NAME, "restoreInflightMessages", "512", new Object[]{nextElement3});
            insertInOrder(this.pendingMessages, (MqttPublish) this.outboundQoS0.get(nextElement3));
        }
        this.pendingFlows = reOrder(this.pendingFlows);
        this.pendingMessages = reOrder(this.pendingMessages);
    }

    private MqttWireMessage restoreMessage(String str, MqttPersistable mqttPersistable) throws MqttException {
        MqttWireMessage mqttWireMessage;
        try {
            mqttWireMessage = MqttWireMessage.createWireMessage(mqttPersistable);
        } catch (Throwable th2) {
            TBaseLogger.e(CLASS_NAME, "restoreMessage", th2);
            if (th2.getCause() instanceof EOFException) {
                if (str != null) {
                    this.persistence.remove(str);
                }
                mqttWireMessage = null;
            } else {
                throw th2;
            }
        }
        log.fine(CLASS_NAME, "restoreMessage", "601", new Object[]{str, mqttWireMessage});
        return mqttWireMessage;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (r1.keepAlive <= 0) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        r3 = java.lang.System.currentTimeMillis();
        r8 = r1.pingOutstandingLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r9 = r1.pingOutstanding;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        if (r9 <= 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        r14 = r1.keepAlive;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        if ((r3 - r1.lastInboundActivity) >= (((long) 100) + r14)) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        r2.severe(CLASS_NAME, "checkForActivity", "619", new java.lang.Object[]{new java.lang.Long(r14), new java.lang.Long(r1.lastOutboundActivity), new java.lang.Long(r1.lastInboundActivity), new java.lang.Long(r3), new java.lang.Long(r1.lastPing)});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0086, code lost:
        throw com.tencent.android.tpns.mqtt.internal.ExceptionHelper.createMqttException(32000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0087, code lost:
        if (r9 != 0) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        r5 = r3 - r1.lastOutboundActivity;
        r14 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r7 = r1.keepAlive;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
        if (r5 >= (2 * r7)) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0098, code lost:
        r2.severe(CLASS_NAME, "checkForActivity", "642", new java.lang.Object[]{new java.lang.Long(r7), new java.lang.Long(r1.lastOutboundActivity), new java.lang.Long(r1.lastInboundActivity), new java.lang.Long(r3), new java.lang.Long(r1.lastPing)});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d6, code lost:
        throw com.tencent.android.tpns.mqtt.internal.ExceptionHelper.createMqttException(32002);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d7, code lost:
        r14 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d8, code lost:
        if (r9 != 0) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e6, code lost:
        if ((r3 - r1.lastInboundActivity) >= (r1.keepAlive - ((long) 100))) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f4, code lost:
        if ((r3 - r1.lastOutboundActivity) < (r1.keepAlive - ((long) 100))) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f6, code lost:
        r2.fine(CLASS_NAME, "checkForActivity", "620", new java.lang.Object[]{new java.lang.Long(r1.keepAlive), new java.lang.Long(r1.lastOutboundActivity), new java.lang.Long(r1.lastInboundActivity)});
        r3 = new com.tencent.android.tpns.mqtt.MqttToken(r1.clientComms.getClient().getClientId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x012f, code lost:
        if (r0 == null) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0131, code lost:
        r3.setActionCallback(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0134, code lost:
        r1.tokenStore.saveToken(r3, r1.pingCommand);
        r1.pendingFlows.insertElementAt(r1.pingCommand, 0);
        r4 = getKeepAlive();
        notifyQueueLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x014b, code lost:
        r2.fine(CLASS_NAME, "checkForActivity", "634", (java.lang.Object[]) null);
        r4 = java.lang.Math.max(1, getKeepAlive() - (r3 - r1.lastOutboundActivity));
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0164, code lost:
        monitor-exit(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0165, code lost:
        r2.fine(CLASS_NAME, "checkForActivity", "624", new java.lang.Object[]{new java.lang.Long(r4)});
        r0 = r1.pingSender;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x017b, code lost:
        if (r0 == null) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x017d, code lost:
        r0.schedule(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0182, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0183, code lost:
        r14 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        monitor-exit(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0185, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0186, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        getKeepAlive();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r1.connected == false) goto L_0x0188;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.android.tpns.mqtt.MqttToken checkForActivity(com.tencent.android.tpns.mqtt.IMqttActionListener r17) throws com.tencent.android.tpns.mqtt.MqttException {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            com.tencent.android.tpns.mqtt.logging.Logger r2 = log
            java.lang.String r3 = "ClientState"
            java.lang.String r4 = "checkForActivity"
            java.lang.String r5 = "616"
            r6 = 0
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r2.fine(r3, r4, r5, r7)
            java.lang.Object r3 = r1.quiesceLock
            monitor-enter(r3)
            boolean r4 = r1.quiescing     // Catch:{ all -> 0x018b }
            r5 = 0
            if (r4 == 0) goto L_0x001c
            monitor-exit(r3)     // Catch:{ all -> 0x018b }
            return r5
        L_0x001c:
            monitor-exit(r3)     // Catch:{ all -> 0x018b }
            r16.getKeepAlive()
            boolean r3 = r1.connected
            if (r3 == 0) goto L_0x0188
            long r3 = r1.keepAlive
            r7 = 0
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x0188
            long r3 = java.lang.System.currentTimeMillis()
            r7 = 100
            java.lang.Object r8 = r1.pingOutstandingLock
            monitor-enter(r8)
            int r9 = r1.pingOutstanding     // Catch:{ all -> 0x0182 }
            r10 = 4
            r11 = 5
            if (r9 <= 0) goto L_0x0087
            long r12 = r1.lastInboundActivity     // Catch:{ all -> 0x0182 }
            long r12 = r3 - r12
            long r14 = r1.keepAlive     // Catch:{ all -> 0x0182 }
            long r5 = (long) r7     // Catch:{ all -> 0x0182 }
            long r5 = r5 + r14
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0048
            goto L_0x0087
        L_0x0048:
            java.lang.String r0 = "ClientState"
            java.lang.String r5 = "checkForActivity"
            java.lang.String r6 = "619"
            java.lang.Object[] r7 = new java.lang.Object[r11]     // Catch:{ all -> 0x0182 }
            java.lang.Long r9 = new java.lang.Long     // Catch:{ all -> 0x0182 }
            r9.<init>(r14)     // Catch:{ all -> 0x0182 }
            r11 = 0
            r7[r11] = r9     // Catch:{ all -> 0x0182 }
            java.lang.Long r9 = new java.lang.Long     // Catch:{ all -> 0x0182 }
            long r11 = r1.lastOutboundActivity     // Catch:{ all -> 0x0182 }
            r9.<init>(r11)     // Catch:{ all -> 0x0182 }
            r11 = 1
            r7[r11] = r9     // Catch:{ all -> 0x0182 }
            java.lang.Long r9 = new java.lang.Long     // Catch:{ all -> 0x0182 }
            long r11 = r1.lastInboundActivity     // Catch:{ all -> 0x0182 }
            r9.<init>(r11)     // Catch:{ all -> 0x0182 }
            r11 = 2
            r7[r11] = r9     // Catch:{ all -> 0x0182 }
            java.lang.Long r9 = new java.lang.Long     // Catch:{ all -> 0x0182 }
            r9.<init>(r3)     // Catch:{ all -> 0x0182 }
            r3 = 3
            r7[r3] = r9     // Catch:{ all -> 0x0182 }
            java.lang.Long r3 = new java.lang.Long     // Catch:{ all -> 0x0182 }
            long r11 = r1.lastPing     // Catch:{ all -> 0x0182 }
            r3.<init>(r11)     // Catch:{ all -> 0x0182 }
            r7[r10] = r3     // Catch:{ all -> 0x0182 }
            r2.severe(r0, r5, r6, r7)     // Catch:{ all -> 0x0182 }
            r0 = 32000(0x7d00, float:4.4842E-41)
            com.tencent.android.tpns.mqtt.MqttException r0 = com.tencent.android.tpns.mqtt.internal.ExceptionHelper.createMqttException((int) r0)     // Catch:{ all -> 0x0182 }
            throw r0     // Catch:{ all -> 0x0182 }
        L_0x0087:
            if (r9 != 0) goto L_0x00d7
            long r5 = r1.lastOutboundActivity     // Catch:{ all -> 0x0182 }
            long r5 = r3 - r5
            r12 = 2
            r14 = r8
            long r7 = r1.keepAlive     // Catch:{ all -> 0x0186 }
            long r12 = r12 * r7
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 >= 0) goto L_0x0098
            goto L_0x00d8
        L_0x0098:
            java.lang.String r0 = "ClientState"
            java.lang.String r5 = "checkForActivity"
            java.lang.String r6 = "642"
            java.lang.Object[] r9 = new java.lang.Object[r11]     // Catch:{ all -> 0x0186 }
            java.lang.Long r11 = new java.lang.Long     // Catch:{ all -> 0x0186 }
            r11.<init>(r7)     // Catch:{ all -> 0x0186 }
            r7 = 0
            r9[r7] = r11     // Catch:{ all -> 0x0186 }
            java.lang.Long r7 = new java.lang.Long     // Catch:{ all -> 0x0186 }
            long r11 = r1.lastOutboundActivity     // Catch:{ all -> 0x0186 }
            r7.<init>(r11)     // Catch:{ all -> 0x0186 }
            r8 = 1
            r9[r8] = r7     // Catch:{ all -> 0x0186 }
            java.lang.Long r7 = new java.lang.Long     // Catch:{ all -> 0x0186 }
            long r11 = r1.lastInboundActivity     // Catch:{ all -> 0x0186 }
            r7.<init>(r11)     // Catch:{ all -> 0x0186 }
            r8 = 2
            r9[r8] = r7     // Catch:{ all -> 0x0186 }
            java.lang.Long r7 = new java.lang.Long     // Catch:{ all -> 0x0186 }
            r7.<init>(r3)     // Catch:{ all -> 0x0186 }
            r3 = 3
            r9[r3] = r7     // Catch:{ all -> 0x0186 }
            java.lang.Long r3 = new java.lang.Long     // Catch:{ all -> 0x0186 }
            long r7 = r1.lastPing     // Catch:{ all -> 0x0186 }
            r3.<init>(r7)     // Catch:{ all -> 0x0186 }
            r9[r10] = r3     // Catch:{ all -> 0x0186 }
            r2.severe(r0, r5, r6, r9)     // Catch:{ all -> 0x0186 }
            r0 = 32002(0x7d02, float:4.4844E-41)
            com.tencent.android.tpns.mqtt.MqttException r0 = com.tencent.android.tpns.mqtt.internal.ExceptionHelper.createMqttException((int) r0)     // Catch:{ all -> 0x0186 }
            throw r0     // Catch:{ all -> 0x0186 }
        L_0x00d7:
            r14 = r8
        L_0x00d8:
            if (r9 != 0) goto L_0x00e8
            long r5 = r1.lastInboundActivity     // Catch:{ all -> 0x0186 }
            long r5 = r3 - r5
            long r7 = r1.keepAlive     // Catch:{ all -> 0x0186 }
            r9 = 100
            long r10 = (long) r9     // Catch:{ all -> 0x0186 }
            long r7 = r7 - r10
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x00f6
        L_0x00e8:
            long r5 = r1.lastOutboundActivity     // Catch:{ all -> 0x0186 }
            long r5 = r3 - r5
            long r7 = r1.keepAlive     // Catch:{ all -> 0x0186 }
            r9 = 100
            long r9 = (long) r9     // Catch:{ all -> 0x0186 }
            long r7 = r7 - r9
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x014b
        L_0x00f6:
            java.lang.String r3 = "ClientState"
            java.lang.String r4 = "checkForActivity"
            java.lang.String r5 = "620"
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0186 }
            java.lang.Long r7 = new java.lang.Long     // Catch:{ all -> 0x0186 }
            long r8 = r1.keepAlive     // Catch:{ all -> 0x0186 }
            r7.<init>(r8)     // Catch:{ all -> 0x0186 }
            r8 = 0
            r6[r8] = r7     // Catch:{ all -> 0x0186 }
            java.lang.Long r7 = new java.lang.Long     // Catch:{ all -> 0x0186 }
            long r8 = r1.lastOutboundActivity     // Catch:{ all -> 0x0186 }
            r7.<init>(r8)     // Catch:{ all -> 0x0186 }
            r8 = 1
            r6[r8] = r7     // Catch:{ all -> 0x0186 }
            java.lang.Long r7 = new java.lang.Long     // Catch:{ all -> 0x0186 }
            long r8 = r1.lastInboundActivity     // Catch:{ all -> 0x0186 }
            r7.<init>(r8)     // Catch:{ all -> 0x0186 }
            r8 = 2
            r6[r8] = r7     // Catch:{ all -> 0x0186 }
            r2.fine(r3, r4, r5, r6)     // Catch:{ all -> 0x0186 }
            com.tencent.android.tpns.mqtt.MqttToken r3 = new com.tencent.android.tpns.mqtt.MqttToken     // Catch:{ all -> 0x0186 }
            com.tencent.android.tpns.mqtt.internal.ClientComms r4 = r1.clientComms     // Catch:{ all -> 0x0186 }
            com.tencent.android.tpns.mqtt.IMqttAsyncClient r4 = r4.getClient()     // Catch:{ all -> 0x0186 }
            java.lang.String r4 = r4.getClientId()     // Catch:{ all -> 0x0186 }
            r3.<init>(r4)     // Catch:{ all -> 0x0186 }
            if (r0 == 0) goto L_0x0134
            r3.setActionCallback(r0)     // Catch:{ all -> 0x0186 }
        L_0x0134:
            com.tencent.android.tpns.mqtt.internal.CommsTokenStore r0 = r1.tokenStore     // Catch:{ all -> 0x0186 }
            com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage r4 = r1.pingCommand     // Catch:{ all -> 0x0186 }
            r0.saveToken((com.tencent.android.tpns.mqtt.MqttToken) r3, (com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage) r4)     // Catch:{ all -> 0x0186 }
            java.util.Vector r0 = r1.pendingFlows     // Catch:{ all -> 0x0186 }
            com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage r4 = r1.pingCommand     // Catch:{ all -> 0x0186 }
            r5 = 0
            r0.insertElementAt(r4, r5)     // Catch:{ all -> 0x0186 }
            long r4 = r16.getKeepAlive()     // Catch:{ all -> 0x0186 }
            r16.notifyQueueLock()     // Catch:{ all -> 0x0186 }
            goto L_0x0164
        L_0x014b:
            java.lang.String r0 = "ClientState"
            java.lang.String r5 = "checkForActivity"
            java.lang.String r6 = "634"
            r7 = 0
            r2.fine(r0, r5, r6, r7)     // Catch:{ all -> 0x0186 }
            r5 = 1
            long r8 = r16.getKeepAlive()     // Catch:{ all -> 0x0186 }
            long r10 = r1.lastOutboundActivity     // Catch:{ all -> 0x0186 }
            long r3 = r3 - r10
            long r8 = r8 - r3
            long r4 = java.lang.Math.max(r5, r8)     // Catch:{ all -> 0x0186 }
            r3 = r7
        L_0x0164:
            monitor-exit(r14)     // Catch:{ all -> 0x0186 }
            java.lang.String r0 = "ClientState"
            java.lang.String r6 = "checkForActivity"
            java.lang.String r7 = "624"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.Long r9 = new java.lang.Long
            r9.<init>(r4)
            r10 = 0
            r8[r10] = r9
            r2.fine(r0, r6, r7, r8)
            com.tencent.android.tpns.mqtt.MqttPingSender r0 = r1.pingSender
            if (r0 == 0) goto L_0x0180
            r0.schedule(r4)
        L_0x0180:
            r5 = r3
            goto L_0x018a
        L_0x0182:
            r0 = move-exception
            r14 = r8
        L_0x0184:
            monitor-exit(r14)     // Catch:{ all -> 0x0186 }
            throw r0
        L_0x0186:
            r0 = move-exception
            goto L_0x0184
        L_0x0188:
            r7 = r5
            r5 = r7
        L_0x018a:
            return r5
        L_0x018b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x018b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.ClientState.checkForActivity(com.tencent.android.tpns.mqtt.IMqttActionListener):com.tencent.android.tpns.mqtt.MqttToken");
    }

    public boolean checkQuiesceLock() {
        int count = this.tokenStore.count();
        if (!this.quiescing || count != 0 || this.pendingFlows.size() != 0 || !this.callback.isQuiesced()) {
            return false;
        }
        synchronized (this.quiesceLock) {
            this.quiesceLock.notifyAll();
        }
        return true;
    }

    public void clearState() throws MqttException {
        log.fine(CLASS_NAME, "clearState", ">");
        this.persistence.clear();
        this.inUseMsgIds.clear();
        this.pendingMessages.clear();
        this.pendingFlows.clear();
        this.outboundQoS2.clear();
        this.outboundQoS1.clear();
        this.outboundQoS0.clear();
        this.inboundQoS2.clear();
        this.tokenStore.clear();
    }

    public void close() {
        this.inUseMsgIds.clear();
        if (this.pendingMessages != null) {
            this.pendingMessages.clear();
        }
        this.pendingFlows.clear();
        this.outboundQoS2.clear();
        this.outboundQoS1.clear();
        this.outboundQoS0.clear();
        this.inboundQoS2.clear();
        this.tokenStore.clear();
        this.inUseMsgIds = null;
        this.pendingMessages = null;
        this.pendingFlows = null;
        this.outboundQoS2 = null;
        this.outboundQoS1 = null;
        this.outboundQoS0 = null;
        this.inboundQoS2 = null;
        this.tokenStore = null;
        this.callback = null;
        this.clientComms = null;
        this.persistence = null;
        this.pingCommand = null;
    }

    public void connected() {
        log.fine(CLASS_NAME, "connected", "631");
        this.connected = true;
        MqttPingSender mqttPingSender = this.pingSender;
        if (mqttPingSender != null) {
            mqttPingSender.start();
        }
    }

    public void deliveryComplete(MqttPublish mqttPublish) throws MqttPersistenceException {
        log.fine(CLASS_NAME, "deliveryComplete", "641", new Object[]{new Integer(mqttPublish.getMessageId())});
        this.persistence.remove(getReceivedPersistenceKey((MqttWireMessage) mqttPublish));
        this.inboundQoS2.remove(new Integer(mqttPublish.getMessageId()));
    }

    public void disconnected(MqttException mqttException) {
        log.fine(CLASS_NAME, "disconnected", "633", new Object[]{mqttException});
        this.connected = false;
        try {
            if (this.cleanSession) {
                clearState();
            }
            this.pendingMessages.clear();
            this.pendingFlows.clear();
            synchronized (this.pingOutstandingLock) {
                this.pingOutstanding = 0;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|5|(2:13|14)|15|16|(3:25|(4:27|(1:29)|30|46)(2:31|(1:47)(2:33|(2:35|48)(2:36|49)))|42)(3:22|23|24)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage get() throws com.tencent.android.tpns.mqtt.MqttException {
        /*
            r11 = this;
            java.lang.Object r0 = r11.queueLock
            monitor-enter(r0)
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r2 != 0) goto L_0x00da
            java.util.Vector r3 = r11.pendingMessages     // Catch:{ all -> 0x00dc }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x0017
            java.util.Vector r3 = r11.pendingFlows     // Catch:{ all -> 0x00dc }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00dc }
            if (r3 != 0) goto L_0x0025
        L_0x0017:
            java.util.Vector r3 = r11.pendingFlows     // Catch:{ all -> 0x00dc }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x003e
            int r3 = r11.actualInFlight     // Catch:{ all -> 0x00dc }
            int r4 = r11.maxInflight     // Catch:{ all -> 0x00dc }
            if (r3 < r4) goto L_0x003e
        L_0x0025:
            com.tencent.android.tpns.mqtt.logging.Logger r3 = log     // Catch:{ InterruptedException -> 0x003e }
            java.lang.String r4 = "ClientState"
            java.lang.String r5 = "get"
            java.lang.String r6 = "644"
            r3.fine(r4, r5, r6)     // Catch:{ InterruptedException -> 0x003e }
            java.lang.Object r4 = r11.queueLock     // Catch:{ InterruptedException -> 0x003e }
            r4.wait()     // Catch:{ InterruptedException -> 0x003e }
            java.lang.String r4 = "ClientState"
            java.lang.String r5 = "get"
            java.lang.String r6 = "647"
            r3.fine(r4, r5, r6)     // Catch:{ InterruptedException -> 0x003e }
        L_0x003e:
            boolean r3 = r11.connected     // Catch:{ all -> 0x00dc }
            r4 = 0
            if (r3 != 0) goto L_0x0064
            java.util.Vector r3 = r11.pendingFlows     // Catch:{ all -> 0x00dc }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00dc }
            if (r3 != 0) goto L_0x0057
            java.util.Vector r3 = r11.pendingFlows     // Catch:{ all -> 0x00dc }
            java.lang.Object r3 = r3.elementAt(r4)     // Catch:{ all -> 0x00dc }
            com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage r3 = (com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage) r3     // Catch:{ all -> 0x00dc }
            boolean r3 = r3 instanceof com.tencent.android.tpns.mqtt.internal.wire.MqttConnect     // Catch:{ all -> 0x00dc }
            if (r3 != 0) goto L_0x0064
        L_0x0057:
            com.tencent.android.tpns.mqtt.logging.Logger r2 = log     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = "ClientState"
            java.lang.String r4 = "get"
            java.lang.String r5 = "621"
            r2.fine(r3, r4, r5)     // Catch:{ all -> 0x00dc }
            monitor-exit(r0)     // Catch:{ all -> 0x00dc }
            return r1
        L_0x0064:
            java.util.Vector r3 = r11.pendingFlows     // Catch:{ all -> 0x00dc }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00dc }
            r5 = 1
            if (r3 != 0) goto L_0x0097
            java.util.Vector r2 = r11.pendingFlows     // Catch:{ all -> 0x00dc }
            java.lang.Object r2 = r2.remove(r4)     // Catch:{ all -> 0x00dc }
            com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage r2 = (com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage) r2     // Catch:{ all -> 0x00dc }
            boolean r3 = r2 instanceof com.tencent.android.tpns.mqtt.internal.wire.MqttPubRel     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x0092
            int r3 = r11.inFlightPubRels     // Catch:{ all -> 0x00dc }
            int r3 = r3 + r5
            r11.inFlightPubRels = r3     // Catch:{ all -> 0x00dc }
            com.tencent.android.tpns.mqtt.logging.Logger r6 = log     // Catch:{ all -> 0x00dc }
            java.lang.String r7 = "ClientState"
            java.lang.String r8 = "get"
            java.lang.String r9 = "617"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00dc }
            java.lang.Integer r10 = new java.lang.Integer     // Catch:{ all -> 0x00dc }
            r10.<init>(r3)     // Catch:{ all -> 0x00dc }
            r5[r4] = r10     // Catch:{ all -> 0x00dc }
            r6.fine(r7, r8, r9, r5)     // Catch:{ all -> 0x00dc }
        L_0x0092:
            r11.checkQuiesceLock()     // Catch:{ all -> 0x00dc }
            goto L_0x0005
        L_0x0097:
            java.util.Vector r3 = r11.pendingMessages     // Catch:{ all -> 0x00dc }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00dc }
            if (r3 != 0) goto L_0x0005
            int r3 = r11.actualInFlight     // Catch:{ all -> 0x00dc }
            int r6 = r11.maxInflight     // Catch:{ all -> 0x00dc }
            if (r3 >= r6) goto L_0x00cd
            java.util.Vector r2 = r11.pendingMessages     // Catch:{ all -> 0x00dc }
            java.lang.Object r2 = r2.elementAt(r4)     // Catch:{ all -> 0x00dc }
            com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage r2 = (com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage) r2     // Catch:{ all -> 0x00dc }
            java.util.Vector r3 = r11.pendingMessages     // Catch:{ all -> 0x00dc }
            r3.removeElementAt(r4)     // Catch:{ all -> 0x00dc }
            int r3 = r11.actualInFlight     // Catch:{ all -> 0x00dc }
            int r3 = r3 + r5
            r11.actualInFlight = r3     // Catch:{ all -> 0x00dc }
            com.tencent.android.tpns.mqtt.logging.Logger r6 = log     // Catch:{ all -> 0x00dc }
            java.lang.String r7 = "ClientState"
            java.lang.String r8 = "get"
            java.lang.String r9 = "623"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00dc }
            java.lang.Integer r10 = new java.lang.Integer     // Catch:{ all -> 0x00dc }
            r10.<init>(r3)     // Catch:{ all -> 0x00dc }
            r5[r4] = r10     // Catch:{ all -> 0x00dc }
            r6.fine(r7, r8, r9, r5)     // Catch:{ all -> 0x00dc }
            goto L_0x0005
        L_0x00cd:
            com.tencent.android.tpns.mqtt.logging.Logger r3 = log     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "ClientState"
            java.lang.String r5 = "get"
            java.lang.String r6 = "622"
            r3.fine(r4, r5, r6)     // Catch:{ all -> 0x00dc }
            goto L_0x0005
        L_0x00da:
            monitor-exit(r0)     // Catch:{ all -> 0x00dc }
            return r2
        L_0x00dc:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00dc }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.ClientState.get():com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage");
    }

    public int getActualInFlight() {
        return this.actualInFlight;
    }

    public boolean getCleanSession() {
        return this.cleanSession;
    }

    public Properties getDebug() {
        Properties properties = new Properties();
        properties.put("In use msgids", this.inUseMsgIds);
        properties.put("pendingMessages", this.pendingMessages);
        properties.put("pendingFlows", this.pendingFlows);
        properties.put("maxInflight", new Integer(this.maxInflight));
        properties.put("nextMsgID", new Integer(this.nextMsgId));
        properties.put("actualInFlight", new Integer(this.actualInFlight));
        properties.put("inFlightPubRels", new Integer(this.inFlightPubRels));
        properties.put("quiescing", Boolean.valueOf(this.quiescing));
        properties.put("pingoutstanding", new Integer(this.pingOutstanding));
        properties.put("lastOutboundActivity", new Long(this.lastOutboundActivity));
        properties.put("lastInboundActivity", new Long(this.lastInboundActivity));
        properties.put("outboundQoS2", this.outboundQoS2);
        properties.put("outboundQoS1", this.outboundQoS1);
        properties.put("outboundQoS0", this.outboundQoS0);
        properties.put("inboundQoS2", this.inboundQoS2);
        properties.put("tokens", this.tokenStore);
        return properties;
    }

    public long getKeepAlive() {
        return this.keepAlive;
    }

    public int getMaxInFlight() {
        return this.maxInflight;
    }

    public void notifyComplete(MqttToken mqttToken) throws MqttException {
        MqttWireMessage wireMessage = mqttToken.internalTok.getWireMessage();
        if (wireMessage != null && (wireMessage instanceof MqttAck)) {
            Logger logger = log;
            logger.fine(CLASS_NAME, "notifyComplete", "629", new Object[]{new Integer(wireMessage.getMessageId()), mqttToken, wireMessage});
            MqttAck mqttAck = (MqttAck) wireMessage;
            if (mqttAck instanceof MqttPubAck) {
                this.persistence.remove(getSendPersistenceKey(wireMessage));
                this.persistence.remove(getSendBufferedPersistenceKey(wireMessage));
                this.outboundQoS1.remove(new Integer(mqttAck.getMessageId()));
                decrementInFlight();
                releaseMessageId(wireMessage.getMessageId());
                this.tokenStore.removeToken(wireMessage);
                logger.fine(CLASS_NAME, "notifyComplete", "650", new Object[]{new Integer(mqttAck.getMessageId())});
            } else if (mqttAck instanceof MqttPubComp) {
                this.persistence.remove(getSendPersistenceKey(wireMessage));
                this.persistence.remove(getSendConfirmPersistenceKey(wireMessage));
                this.persistence.remove(getSendBufferedPersistenceKey(wireMessage));
                this.outboundQoS2.remove(new Integer(mqttAck.getMessageId()));
                this.inFlightPubRels--;
                decrementInFlight();
                releaseMessageId(wireMessage.getMessageId());
                this.tokenStore.removeToken(wireMessage);
                logger.fine(CLASS_NAME, "notifyComplete", "645", new Object[]{new Integer(mqttAck.getMessageId()), new Integer(this.inFlightPubRels)});
            }
            checkQuiesceLock();
        }
    }

    public void notifyQueueLock() {
        synchronized (this.queueLock) {
            log.fine(CLASS_NAME, "notifyQueueLock", "638");
            this.queueLock.notifyAll();
        }
    }

    public void notifyReceivedAck(MqttAck mqttAck) throws MqttException {
        this.lastInboundActivity = System.currentTimeMillis();
        Logger logger = log;
        logger.fine(CLASS_NAME, "notifyReceivedAck", "627", new Object[]{new Integer(mqttAck.getMessageId()), mqttAck});
        MqttToken token = this.tokenStore.getToken((MqttWireMessage) mqttAck);
        if (token == null) {
            logger.fine(CLASS_NAME, "notifyReceivedAck", "662", new Object[]{new Integer(mqttAck.getMessageId())});
        } else if (mqttAck instanceof MqttPubRec) {
            logger.fine(CLASS_NAME, "notifyReceivedAck", "663", new Object[]{new Integer(mqttAck.getMessageId())});
            send(new MqttPubRel((MqttPubRec) mqttAck), token);
        } else if ((mqttAck instanceof MqttPubAck) || (mqttAck instanceof MqttPubComp)) {
            notifyResult(mqttAck, token, (MqttException) null);
        } else if (mqttAck instanceof MqttPingResp) {
            logger.fine(CLASS_NAME, "notifyReceivedAck", "664", new Object[]{new Integer(mqttAck.getMessageId())});
            synchronized (this.pingOutstandingLock) {
                this.pingOutstanding = Math.max(0, this.pingOutstanding - 1);
                notifyResult(mqttAck, token, (MqttException) null);
                if (this.pingOutstanding == 0) {
                    this.tokenStore.removeToken((MqttWireMessage) mqttAck);
                }
            }
        } else if (mqttAck instanceof MqttConnack) {
            logger.fine(CLASS_NAME, "notifyReceivedAck", "665", new Object[]{new Integer(mqttAck.getMessageId())});
            MqttConnack mqttConnack = (MqttConnack) mqttAck;
            int returnCode = mqttConnack.getReturnCode();
            if (returnCode == 0) {
                synchronized (this.queueLock) {
                    if (this.cleanSession) {
                        clearState();
                        this.tokenStore.saveToken(token, (MqttWireMessage) mqttAck);
                    }
                    this.inFlightPubRels = 0;
                    this.actualInFlight = 0;
                    restoreInflightMessages();
                    connected();
                }
                this.clientComms.connectComplete(mqttConnack, (MqttException) null);
                notifyResult(mqttAck, token, (MqttException) null);
                this.tokenStore.removeToken((MqttWireMessage) mqttAck);
                synchronized (this.queueLock) {
                    this.queueLock.notifyAll();
                }
            } else {
                throw ExceptionHelper.createMqttException(returnCode);
            }
        } else {
            logger.fine(CLASS_NAME, "notifyReceivedAck", "666", new Object[]{new Integer(mqttAck.getMessageId())});
            notifyResult(mqttAck, token, (MqttException) null);
            releaseMessageId(mqttAck.getMessageId());
            this.tokenStore.removeToken((MqttWireMessage) mqttAck);
        }
        checkQuiesceLock();
    }

    public void notifyReceivedBytes(int i11) {
        if (i11 > 0) {
            this.lastInboundActivity = System.currentTimeMillis();
        }
        log.fine(CLASS_NAME, "notifyReceivedBytes", "630", new Object[]{new Integer(i11)});
    }

    public void notifyReceivedMsg(MqttWireMessage mqttWireMessage) throws MqttException {
        TBaseLogger.d(CLASS_NAME, "action - notifyReceivedMsg:" + mqttWireMessage.toString());
        this.lastInboundActivity = System.currentTimeMillis();
        log.fine(CLASS_NAME, "notifyReceivedMsg", "651", new Object[]{new Integer(mqttWireMessage.getMessageId()), mqttWireMessage});
        if (this.quiescing) {
            return;
        }
        if (mqttWireMessage instanceof MqttPublish) {
            MqttPublish mqttPublish = (MqttPublish) mqttWireMessage;
            int qos = mqttPublish.getMessage().getQos();
            if (qos == 0 || qos == 1) {
                CommsCallback commsCallback = this.callback;
                if (commsCallback != null) {
                    commsCallback.messageArrived(mqttPublish);
                }
            } else if (qos == 2) {
                this.persistence.put(getReceivedPersistenceKey(mqttWireMessage), mqttPublish);
                this.inboundQoS2.put(new Integer(mqttPublish.getMessageId()), mqttPublish);
                send(new MqttPubRec(mqttPublish), (MqttToken) null);
            }
        } else if (mqttWireMessage instanceof MqttPubRel) {
            MqttPublish mqttPublish2 = (MqttPublish) this.inboundQoS2.get(new Integer(mqttWireMessage.getMessageId()));
            if (mqttPublish2 != null) {
                CommsCallback commsCallback2 = this.callback;
                if (commsCallback2 != null) {
                    commsCallback2.messageArrived(mqttPublish2);
                    return;
                }
                return;
            }
            send(new MqttPubComp(mqttWireMessage.getMessageId()), (MqttToken) null);
        }
    }

    public void notifyResult(MqttWireMessage mqttWireMessage, MqttToken mqttToken, MqttException mqttException) {
        TBaseLogger.d(CLASS_NAME, "action:notifyResult");
        mqttToken.internalTok.markComplete(mqttWireMessage, mqttException);
        mqttToken.internalTok.notifyComplete();
        if (mqttWireMessage != null && (mqttWireMessage instanceof MqttAck) && !(mqttWireMessage instanceof MqttPubRec)) {
            log.fine(CLASS_NAME, "notifyResult", "648", new Object[]{mqttToken.internalTok.getKey(), mqttWireMessage, mqttException});
            this.callback.asyncOperationComplete(mqttToken);
        }
        if (mqttWireMessage == null) {
            log.fine(CLASS_NAME, "notifyResult", "649", new Object[]{mqttToken.internalTok.getKey(), mqttException});
            this.callback.asyncOperationComplete(mqttToken);
        }
    }

    public void notifySent(MqttWireMessage mqttWireMessage) {
        TBaseLogger.d(CLASS_NAME, "action - notifySent");
        this.lastOutboundActivity = System.currentTimeMillis();
        log.fine(CLASS_NAME, "notifySent", "625", new Object[]{mqttWireMessage.getKey()});
        MqttToken token = this.tokenStore.getToken(mqttWireMessage);
        token.internalTok.notifySent();
        if (mqttWireMessage instanceof MqttPingReq) {
            synchronized (this.pingOutstandingLock) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.pingOutstandingLock) {
                    this.lastPing = currentTimeMillis;
                    this.pingOutstanding++;
                }
            }
        } else if ((mqttWireMessage instanceof MqttPublish) && ((MqttPublish) mqttWireMessage).getMessage().getQos() == 0) {
            token.internalTok.markComplete((MqttWireMessage) null, (MqttException) null);
            this.callback.asyncOperationComplete(token);
            decrementInFlight();
            releaseMessageId(mqttWireMessage.getMessageId());
            this.tokenStore.removeToken(mqttWireMessage);
            checkQuiesceLock();
        }
    }

    public void notifySentBytes(int i11) {
        if (i11 > 0) {
            this.lastOutboundActivity = System.currentTimeMillis();
        }
        log.fine(CLASS_NAME, "notifySentBytes", "643", new Object[]{new Integer(i11)});
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:1|2|3|4|5|6|7|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void persistBufferedMessage(com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage r7) {
        /*
            r6 = this;
            java.lang.String r0 = "persistBufferedMessage"
            java.lang.String r1 = "ClientState"
            r6.getSendBufferedPersistenceKey(r7)
            int r2 = r6.getNextMessageId()     // Catch:{ all -> 0x0050 }
            r7.setMessageId(r2)     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = r6.getSendBufferedPersistenceKey(r7)     // Catch:{ all -> 0x0050 }
            com.tencent.android.tpns.mqtt.MqttClientPersistence r3 = r6.persistence     // Catch:{ all -> 0x001b }
            r4 = r7
            com.tencent.android.tpns.mqtt.internal.wire.MqttPublish r4 = (com.tencent.android.tpns.mqtt.internal.wire.MqttPublish) r4     // Catch:{ all -> 0x001b }
            r3.put(r2, r4)     // Catch:{ all -> 0x001b }
            goto L_0x0042
        L_0x001b:
            com.tencent.android.tpns.mqtt.logging.Logger r3 = log     // Catch:{ all -> 0x0050 }
            java.lang.String r4 = "515"
            r3.fine(r1, r0, r4)     // Catch:{ all -> 0x0050 }
            com.tencent.android.tpns.mqtt.MqttClientPersistence r3 = r6.persistence     // Catch:{ all -> 0x0050 }
            com.tencent.android.tpns.mqtt.internal.ClientComms r4 = r6.clientComms     // Catch:{ all -> 0x0050 }
            com.tencent.android.tpns.mqtt.IMqttAsyncClient r4 = r4.getClient()     // Catch:{ all -> 0x0050 }
            java.lang.String r4 = r4.getClientId()     // Catch:{ all -> 0x0050 }
            com.tencent.android.tpns.mqtt.internal.ClientComms r5 = r6.clientComms     // Catch:{ all -> 0x0050 }
            com.tencent.android.tpns.mqtt.IMqttAsyncClient r5 = r5.getClient()     // Catch:{ all -> 0x0050 }
            java.lang.String r5 = r5.getServerURI()     // Catch:{ all -> 0x0050 }
            r3.open(r4, r5)     // Catch:{ all -> 0x0050 }
            com.tencent.android.tpns.mqtt.MqttClientPersistence r3 = r6.persistence     // Catch:{ all -> 0x0050 }
            com.tencent.android.tpns.mqtt.internal.wire.MqttPublish r7 = (com.tencent.android.tpns.mqtt.internal.wire.MqttPublish) r7     // Catch:{ all -> 0x0050 }
            r3.put(r2, r7)     // Catch:{ all -> 0x0050 }
        L_0x0042:
            com.tencent.android.tpns.mqtt.logging.Logger r7 = log     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = "513"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0050 }
            r5 = 0
            r4[r5] = r2     // Catch:{ all -> 0x0050 }
            r7.fine(r1, r0, r3, r4)     // Catch:{ all -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r7 = move-exception
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.e(r1, r0, r7)
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.ClientState.persistBufferedMessage(com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage):void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public void quiesce(long r9) {
        /*
            r8 = this;
            r0 = 0
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0074
            com.tencent.android.tpns.mqtt.logging.Logger r0 = log
            java.lang.String r1 = "ClientState"
            java.lang.String r2 = "quiesce"
            java.lang.String r3 = "637"
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            java.lang.Long r6 = new java.lang.Long
            r6.<init>(r9)
            r7 = 0
            r5[r7] = r6
            r0.fine(r1, r2, r3, r5)
            java.lang.Object r0 = r8.queueLock
            monitor-enter(r0)
            r8.quiescing = r4     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            com.tencent.android.tpns.mqtt.internal.CommsCallback r0 = r8.callback
            r0.quiesce()
            r8.notifyQueueLock()
            java.lang.Object r1 = r8.quiesceLock
            monitor-enter(r1)
            com.tencent.android.tpns.mqtt.internal.CommsTokenStore r0 = r8.tokenStore     // Catch:{ InterruptedException -> 0x004d }
            int r0 = r0.count()     // Catch:{ InterruptedException -> 0x004d }
            if (r0 > 0) goto L_0x0045
            java.util.Vector r0 = r8.pendingFlows     // Catch:{ InterruptedException -> 0x004d }
            int r0 = r0.size()     // Catch:{ InterruptedException -> 0x004d }
            if (r0 > 0) goto L_0x0045
            com.tencent.android.tpns.mqtt.internal.CommsCallback r0 = r8.callback     // Catch:{ InterruptedException -> 0x004d }
            boolean r0 = r0.isQuiesced()     // Catch:{ InterruptedException -> 0x004d }
            if (r0 != 0) goto L_0x004d
        L_0x0045:
            java.lang.Object r0 = r8.quiesceLock     // Catch:{ InterruptedException -> 0x004d }
            r0.wait(r9)     // Catch:{ InterruptedException -> 0x004d }
            goto L_0x004d
        L_0x004b:
            r9 = move-exception
            goto L_0x006f
        L_0x004d:
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            java.lang.Object r9 = r8.queueLock
            monitor-enter(r9)
            java.util.Vector r10 = r8.pendingMessages     // Catch:{ all -> 0x006c }
            r10.clear()     // Catch:{ all -> 0x006c }
            java.util.Vector r10 = r8.pendingFlows     // Catch:{ all -> 0x006c }
            r10.clear()     // Catch:{ all -> 0x006c }
            r8.quiescing = r7     // Catch:{ all -> 0x006c }
            r8.actualInFlight = r7     // Catch:{ all -> 0x006c }
            monitor-exit(r9)     // Catch:{ all -> 0x006c }
            com.tencent.android.tpns.mqtt.logging.Logger r9 = log
            java.lang.String r10 = "ClientState"
            java.lang.String r0 = "quiesce"
            java.lang.String r1 = "640"
            r9.fine(r10, r0, r1)
            goto L_0x0074
        L_0x006c:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x006c }
            throw r10
        L_0x006f:
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            throw r9
        L_0x0071:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            throw r9
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.ClientState.quiesce(long):void");
    }

    public Vector resolveOldTokens(MqttException mqttException) {
        log.fine(CLASS_NAME, "resolveOldTokens", "632", new Object[]{mqttException});
        if (mqttException == null) {
            mqttException = new MqttException(32102);
        }
        Vector outstandingTokens = this.tokenStore.getOutstandingTokens();
        Enumeration elements = outstandingTokens.elements();
        while (elements.hasMoreElements()) {
            MqttToken mqttToken = (MqttToken) elements.nextElement();
            synchronized (mqttToken) {
                if (!mqttToken.isComplete() && !mqttToken.internalTok.isCompletePending() && mqttToken.getException() == null) {
                    mqttToken.internalTok.setException(mqttException);
                }
            }
            if (!(mqttToken instanceof MqttDeliveryToken)) {
                this.tokenStore.removeToken(mqttToken.internalTok.getKey());
            }
        }
        return outstandingTokens;
    }

    public void restoreState() throws MqttException {
        Enumeration keys = this.persistence.keys();
        int i11 = this.nextMsgId;
        Vector vector = new Vector();
        log.fine(CLASS_NAME, "restoreState", "600");
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            MqttWireMessage restoreMessage = restoreMessage(str, this.persistence.get(str));
            if (restoreMessage != null) {
                if (str.startsWith(PERSISTENCE_RECEIVED_PREFIX)) {
                    log.fine(CLASS_NAME, "restoreState", "604", new Object[]{str, restoreMessage});
                    this.inboundQoS2.put(new Integer(restoreMessage.getMessageId()), restoreMessage);
                } else if (str.startsWith(PERSISTENCE_SENT_PREFIX)) {
                    MqttPublish mqttPublish = (MqttPublish) restoreMessage;
                    i11 = Math.max(mqttPublish.getMessageId(), i11);
                    if (this.persistence.containsKey(getSendConfirmPersistenceKey(mqttPublish))) {
                        MqttPubRel mqttPubRel = (MqttPubRel) restoreMessage(str, this.persistence.get(getSendConfirmPersistenceKey(mqttPublish)));
                        if (mqttPubRel != null) {
                            log.fine(CLASS_NAME, "restoreState", "605", new Object[]{str, restoreMessage});
                            this.outboundQoS2.put(new Integer(mqttPubRel.getMessageId()), mqttPubRel);
                        } else {
                            log.fine(CLASS_NAME, "restoreState", "606", new Object[]{str, restoreMessage});
                        }
                    } else {
                        mqttPublish.setDuplicate(true);
                        if (mqttPublish.getMessage().getQos() == 2) {
                            log.fine(CLASS_NAME, "restoreState", "607", new Object[]{str, restoreMessage});
                            this.outboundQoS2.put(new Integer(mqttPublish.getMessageId()), mqttPublish);
                        } else {
                            log.fine(CLASS_NAME, "restoreState", "608", new Object[]{str, restoreMessage});
                            this.outboundQoS1.put(new Integer(mqttPublish.getMessageId()), mqttPublish);
                        }
                    }
                    this.tokenStore.restoreToken(mqttPublish).internalTok.setClient(this.clientComms.getClient());
                    this.inUseMsgIds.put(new Integer(mqttPublish.getMessageId()), new Integer(mqttPublish.getMessageId()));
                } else if (str.startsWith(PERSISTENCE_SENT_BUFFERED_PREFIX)) {
                    MqttPublish mqttPublish2 = (MqttPublish) restoreMessage;
                    i11 = Math.max(mqttPublish2.getMessageId(), i11);
                    if (mqttPublish2.getMessage().getQos() == 2) {
                        log.fine(CLASS_NAME, "restoreState", "607", new Object[]{str, restoreMessage});
                        this.outboundQoS2.put(new Integer(mqttPublish2.getMessageId()), mqttPublish2);
                    } else if (mqttPublish2.getMessage().getQos() == 1) {
                        log.fine(CLASS_NAME, "restoreState", "608", new Object[]{str, restoreMessage});
                        this.outboundQoS1.put(new Integer(mqttPublish2.getMessageId()), mqttPublish2);
                    } else {
                        log.fine(CLASS_NAME, "restoreState", "511", new Object[]{str, restoreMessage});
                        this.outboundQoS0.put(new Integer(mqttPublish2.getMessageId()), mqttPublish2);
                        this.persistence.remove(str);
                    }
                    this.tokenStore.restoreToken(mqttPublish2).internalTok.setClient(this.clientComms.getClient());
                    this.inUseMsgIds.put(new Integer(mqttPublish2.getMessageId()), new Integer(mqttPublish2.getMessageId()));
                } else if (str.startsWith(PERSISTENCE_CONFIRMED_PREFIX) && !this.persistence.containsKey(getSendPersistenceKey((MqttPubRel) restoreMessage))) {
                    vector.addElement(str);
                }
            }
        }
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            String str2 = (String) elements.nextElement();
            log.fine(CLASS_NAME, "restoreState", "609", new Object[]{str2});
            this.persistence.remove(str2);
        }
        this.nextMsgId = i11;
    }

    public void send(MqttWireMessage mqttWireMessage, MqttToken mqttToken) throws MqttException {
        if (mqttWireMessage.isMessageIdRequired() && mqttWireMessage.getMessageId() == 0) {
            if ((mqttWireMessage instanceof MqttPublish) && ((MqttPublish) mqttWireMessage).getMessage().getQos() != 0) {
                mqttWireMessage.setMessageId(getNextMessageId());
            } else if ((mqttWireMessage instanceof MqttPubAck) || (mqttWireMessage instanceof MqttPubRec) || (mqttWireMessage instanceof MqttPubRel) || (mqttWireMessage instanceof MqttPubComp) || (mqttWireMessage instanceof MqttSubscribe) || (mqttWireMessage instanceof MqttSuback) || (mqttWireMessage instanceof MqttUnsubscribe) || (mqttWireMessage instanceof MqttUnsubAck)) {
                mqttWireMessage.setMessageId(getNextMessageId());
            }
        }
        if (mqttToken != null) {
            try {
                mqttToken.internalTok.setMessageID(mqttWireMessage.getMessageId());
            } catch (Throwable unused) {
                throw new MqttException(32201);
            }
        }
        if (mqttWireMessage instanceof MqttPublish) {
            synchronized (this.queueLock) {
                int i11 = this.actualInFlight;
                if (i11 < this.maxInflight) {
                    MqttMessage message = ((MqttPublish) mqttWireMessage).getMessage();
                    log.fine(CLASS_NAME, "send", "628", new Object[]{new Integer(mqttWireMessage.getMessageId()), new Integer(message.getQos()), mqttWireMessage});
                    int qos = message.getQos();
                    if (qos == 1) {
                        this.outboundQoS1.put(new Integer(mqttWireMessage.getMessageId()), mqttWireMessage);
                        this.persistence.put(getSendPersistenceKey(mqttWireMessage), (MqttPublish) mqttWireMessage);
                    } else if (qos == 2) {
                        this.outboundQoS2.put(new Integer(mqttWireMessage.getMessageId()), mqttWireMessage);
                        this.persistence.put(getSendPersistenceKey(mqttWireMessage), (MqttPublish) mqttWireMessage);
                    }
                    this.tokenStore.saveToken(mqttToken, mqttWireMessage);
                    this.pendingMessages.addElement(mqttWireMessage);
                    this.queueLock.notifyAll();
                } else {
                    log.fine(CLASS_NAME, "send", "613", new Object[]{new Integer(i11)});
                    throw new MqttException(32202);
                }
            }
            return;
        }
        log.fine(CLASS_NAME, "send", "615", new Object[]{new Integer(mqttWireMessage.getMessageId()), mqttWireMessage});
        if (mqttWireMessage instanceof MqttConnect) {
            synchronized (this.queueLock) {
                this.tokenStore.saveToken(mqttToken, mqttWireMessage);
                this.pendingFlows.insertElementAt(mqttWireMessage, 0);
                this.queueLock.notifyAll();
            }
            return;
        }
        if (mqttWireMessage instanceof MqttPingReq) {
            this.pingCommand = mqttWireMessage;
        } else if (mqttWireMessage instanceof MqttPubRel) {
            this.outboundQoS2.put(new Integer(mqttWireMessage.getMessageId()), mqttWireMessage);
            this.persistence.put(getSendConfirmPersistenceKey(mqttWireMessage), (MqttPubRel) mqttWireMessage);
        } else if (mqttWireMessage instanceof MqttPubComp) {
            this.persistence.remove(getReceivedPersistenceKey(mqttWireMessage));
        }
        synchronized (this.queueLock) {
            if (!(mqttWireMessage instanceof MqttAck)) {
                this.tokenStore.saveToken(mqttToken, mqttWireMessage);
            }
            this.pendingFlows.addElement(mqttWireMessage);
            this.queueLock.notifyAll();
        }
    }

    public void setCleanSession(boolean z11) {
        this.cleanSession = z11;
    }

    public void setKeepAliveInterval(long j11) {
        this.keepAlive = j11;
    }

    public void setKeepAliveSecs(long j11) {
        this.keepAlive = j11 * 1000;
    }

    public void setMaxInflight(int i11) {
        this.maxInflight = i11;
        this.pendingMessages = new Vector(this.maxInflight);
    }

    public void unPersistBufferedMessage(MqttWireMessage mqttWireMessage) {
        try {
            log.fine(CLASS_NAME, "unPersistBufferedMessage", "517", new Object[]{mqttWireMessage.getKey()});
            this.persistence.remove(getSendBufferedPersistenceKey(mqttWireMessage));
        } catch (Throwable th2) {
            TBaseLogger.e(CLASS_NAME, "unPersistBufferedMessage", th2);
        }
    }

    public void undo(MqttPublish mqttPublish) throws MqttPersistenceException {
        synchronized (this.queueLock) {
            log.fine(CLASS_NAME, "undo", "618", new Object[]{new Integer(mqttPublish.getMessageId()), new Integer(mqttPublish.getMessage().getQos())});
            if (mqttPublish.getMessage().getQos() == 1) {
                this.outboundQoS1.remove(new Integer(mqttPublish.getMessageId()));
            } else {
                this.outboundQoS2.remove(new Integer(mqttPublish.getMessageId()));
            }
            this.pendingMessages.removeElement(mqttPublish);
            this.persistence.remove(getSendPersistenceKey(mqttPublish));
            this.tokenStore.removeToken((MqttWireMessage) mqttPublish);
            if (mqttPublish.getMessage().getQos() > 0) {
                releaseMessageId(mqttPublish.getMessageId());
                mqttPublish.setMessageId(0);
            }
            checkQuiesceLock();
        }
    }

    private String getReceivedPersistenceKey(int i11) {
        return PERSISTENCE_RECEIVED_PREFIX + i11;
    }

    public void deliveryComplete(int i11) throws MqttPersistenceException {
        log.fine(CLASS_NAME, "deliveryComplete", "641", new Object[]{new Integer(i11)});
        this.persistence.remove(getReceivedPersistenceKey(i11));
        this.inboundQoS2.remove(new Integer(i11));
    }
}
