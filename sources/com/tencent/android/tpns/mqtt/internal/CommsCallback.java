package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttMessageListener;
import com.tencent.android.tpns.mqtt.MqttCallback;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubComp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class CommsCallback extends TTask {
    private static final String CLASS_NAME = "CommsCallback";
    private static final int INBOUND_QUEUE_SIZE = 10;
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private Future callbackFuture;
    private Thread callbackThread;
    private Hashtable callbacks;
    private ClientComms clientComms;
    private ClientState clientState;
    private Vector completeQueue;
    private Object lifecycle = new Object();
    private boolean manualAcks = false;
    private Vector messageQueue;
    private MqttCallback mqttCallback;
    private boolean quiescing = false;
    private MqttCallbackExtended reconnectInternalCallback;
    public boolean running = false;
    private final Semaphore runningSemaphore = new Semaphore(1);
    private Object spaceAvailable = new Object();
    private String threadName;
    private Object workAvailable = new Object();

    public CommsCallback(ClientComms clientComms2) {
        this.clientComms = clientComms2;
        this.messageQueue = new Vector(10);
        this.completeQueue = new Vector(10);
        this.callbacks = new Hashtable();
        log.setResourceName(clientComms2.getClient().getClientId());
    }

    private void handleActionComplete(MqttToken mqttToken) throws MqttException {
        synchronized (mqttToken) {
            log.fine(CLASS_NAME, "handleActionComplete", "705", new Object[]{mqttToken.internalTok.getKey()});
            if (mqttToken.isComplete()) {
                this.clientState.notifyComplete(mqttToken);
            }
            mqttToken.internalTok.notifyComplete();
            if (!mqttToken.internalTok.isNotified()) {
                if (this.mqttCallback != null && (mqttToken instanceof MqttDeliveryToken) && mqttToken.isComplete()) {
                    this.mqttCallback.deliveryComplete((MqttDeliveryToken) mqttToken);
                }
                fireActionEvent(mqttToken);
            }
            if (mqttToken.isComplete() && ((mqttToken instanceof MqttDeliveryToken) || (mqttToken.getActionCallback() instanceof IMqttActionListener))) {
                mqttToken.internalTok.setNotified(true);
            }
        }
    }

    private void handleMessage(MqttPublish mqttPublish) throws MqttException, Exception {
        String topicName = mqttPublish.getTopicName();
        log.fine(CLASS_NAME, "handleMessage", "713", new Object[]{new Integer(mqttPublish.getMessageId()), topicName});
        deliverMessage(topicName, mqttPublish.getMessageId(), mqttPublish.getMessage());
        if (this.manualAcks) {
            return;
        }
        if (mqttPublish.getMessage().getQos() == 1) {
            this.clientComms.internalSend(new MqttPubAck(mqttPublish), new MqttToken(this.clientComms.getClient().getClientId()));
        } else if (mqttPublish.getMessage().getQos() == 2) {
            this.clientComms.deliveryComplete(mqttPublish);
            MqttPubComp mqttPubComp = new MqttPubComp(mqttPublish);
            ClientComms clientComms2 = this.clientComms;
            clientComms2.internalSend(mqttPubComp, new MqttToken(clientComms2.getClient().getClientId()));
        }
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void TRun() {
        /*
            r7 = this;
            java.lang.String r0 = "CommsCallback"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "run loop callback thread:"
            r1.append(r2)
            java.lang.String r2 = r7.threadName
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.d(r0, r1)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r7.callbackThread = r0
            java.lang.String r1 = r7.threadName
            r0.setName(r1)
            r0 = 0
            java.util.concurrent.Semaphore r1 = r7.runningSemaphore     // Catch:{ InterruptedException -> 0x011f }
            r1.acquire()     // Catch:{ InterruptedException -> 0x011f }
        L_0x0029:
            boolean r1 = r7.running
            if (r1 == 0) goto L_0x011e
            r1 = 0
            java.lang.Object r2 = r7.workAvailable     // Catch:{ InterruptedException -> 0x005d }
            monitor-enter(r2)     // Catch:{ InterruptedException -> 0x005d }
            boolean r3 = r7.running     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0055
            java.util.Vector r3 = r7.messageQueue     // Catch:{ all -> 0x0057 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0055
            java.util.Vector r3 = r7.completeQueue     // Catch:{ all -> 0x0057 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0055
            com.tencent.android.tpns.mqtt.logging.Logger r3 = log     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "CommsCallback"
            java.lang.String r5 = "run"
            java.lang.String r6 = "704"
            r3.fine(r4, r5, r6)     // Catch:{ all -> 0x0057 }
            java.lang.Object r3 = r7.workAvailable     // Catch:{ all -> 0x0057 }
            r3.wait()     // Catch:{ all -> 0x0057 }
        L_0x0055:
            monitor-exit(r2)     // Catch:{ all -> 0x0057 }
            goto L_0x005d
        L_0x0057:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0057 }
            throw r3     // Catch:{ InterruptedException -> 0x005d }
        L_0x005a:
            r2 = move-exception
            goto L_0x00cf
        L_0x005d:
            boolean r2 = r7.running     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x00a8
            java.util.Vector r2 = r7.completeQueue     // Catch:{ all -> 0x005a }
            monitor-enter(r2)     // Catch:{ all -> 0x005a }
            java.util.Vector r3 = r7.completeQueue     // Catch:{ all -> 0x00a5 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00a5 }
            if (r3 != 0) goto L_0x007a
            java.util.Vector r3 = r7.completeQueue     // Catch:{ all -> 0x00a5 }
            java.lang.Object r3 = r3.elementAt(r0)     // Catch:{ all -> 0x00a5 }
            com.tencent.android.tpns.mqtt.MqttToken r3 = (com.tencent.android.tpns.mqtt.MqttToken) r3     // Catch:{ all -> 0x00a5 }
            java.util.Vector r4 = r7.completeQueue     // Catch:{ all -> 0x00a5 }
            r4.removeElementAt(r0)     // Catch:{ all -> 0x00a5 }
            goto L_0x007b
        L_0x007a:
            r3 = r1
        L_0x007b:
            monitor-exit(r2)     // Catch:{ all -> 0x00a5 }
            if (r3 == 0) goto L_0x0081
            r7.handleActionComplete(r3)     // Catch:{ all -> 0x005a }
        L_0x0081:
            java.util.Vector r2 = r7.messageQueue     // Catch:{ all -> 0x005a }
            monitor-enter(r2)     // Catch:{ all -> 0x005a }
            java.util.Vector r3 = r7.messageQueue     // Catch:{ all -> 0x00a2 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00a2 }
            if (r3 != 0) goto L_0x009a
            java.util.Vector r3 = r7.messageQueue     // Catch:{ all -> 0x00a2 }
            java.lang.Object r3 = r3.elementAt(r0)     // Catch:{ all -> 0x00a2 }
            com.tencent.android.tpns.mqtt.internal.wire.MqttPublish r3 = (com.tencent.android.tpns.mqtt.internal.wire.MqttPublish) r3     // Catch:{ all -> 0x00a2 }
            java.util.Vector r4 = r7.messageQueue     // Catch:{ all -> 0x00a2 }
            r4.removeElementAt(r0)     // Catch:{ all -> 0x00a2 }
            goto L_0x009b
        L_0x009a:
            r3 = r1
        L_0x009b:
            monitor-exit(r2)     // Catch:{ all -> 0x00a2 }
            if (r3 == 0) goto L_0x00a8
            r7.handleMessage(r3)     // Catch:{ all -> 0x005a }
            goto L_0x00a8
        L_0x00a2:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00a2 }
            throw r3     // Catch:{ all -> 0x005a }
        L_0x00a5:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00a5 }
            throw r3     // Catch:{ all -> 0x005a }
        L_0x00a8:
            boolean r2 = r7.quiescing     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x00b1
            com.tencent.android.tpns.mqtt.internal.ClientState r2 = r7.clientState     // Catch:{ all -> 0x005a }
            r2.checkQuiesceLock()     // Catch:{ all -> 0x005a }
        L_0x00b1:
            java.util.concurrent.Semaphore r1 = r7.runningSemaphore
            r1.release()
            java.lang.Object r2 = r7.spaceAvailable
            monitor-enter(r2)
            com.tencent.android.tpns.mqtt.logging.Logger r1 = log     // Catch:{ all -> 0x00cc }
            java.lang.String r3 = "CommsCallback"
            java.lang.String r4 = "run"
            java.lang.String r5 = "706"
            r1.fine(r3, r4, r5)     // Catch:{ all -> 0x00cc }
            java.lang.Object r1 = r7.spaceAvailable     // Catch:{ all -> 0x00cc }
            r1.notifyAll()     // Catch:{ all -> 0x00cc }
            monitor-exit(r2)     // Catch:{ all -> 0x00cc }
            goto L_0x0029
        L_0x00cc:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00cc }
            throw r0
        L_0x00cf:
            java.lang.String r3 = "CommsCallback"
            java.lang.String r4 = "run"
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.e(r3, r4, r2)     // Catch:{ all -> 0x0100 }
            r7.running = r0     // Catch:{ all -> 0x0100 }
            com.tencent.android.tpns.mqtt.internal.ClientComms r3 = r7.clientComms     // Catch:{ all -> 0x0100 }
            com.tencent.android.tpns.mqtt.MqttException r4 = new com.tencent.android.tpns.mqtt.MqttException     // Catch:{ all -> 0x0100 }
            r4.<init>((java.lang.Throwable) r2)     // Catch:{ all -> 0x0100 }
            r3.shutdownConnection(r1, r4)     // Catch:{ all -> 0x0100 }
            java.util.concurrent.Semaphore r1 = r7.runningSemaphore
            r1.release()
            java.lang.Object r1 = r7.spaceAvailable
            monitor-enter(r1)
            com.tencent.android.tpns.mqtt.logging.Logger r2 = log     // Catch:{ all -> 0x00fd }
            java.lang.String r3 = "CommsCallback"
            java.lang.String r4 = "run"
            java.lang.String r5 = "706"
            r2.fine(r3, r4, r5)     // Catch:{ all -> 0x00fd }
            java.lang.Object r2 = r7.spaceAvailable     // Catch:{ all -> 0x00fd }
            r2.notifyAll()     // Catch:{ all -> 0x00fd }
            monitor-exit(r1)     // Catch:{ all -> 0x00fd }
            goto L_0x0029
        L_0x00fd:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00fd }
            throw r0
        L_0x0100:
            r0 = move-exception
            java.util.concurrent.Semaphore r1 = r7.runningSemaphore
            r1.release()
            java.lang.Object r1 = r7.spaceAvailable
            monitor-enter(r1)
            com.tencent.android.tpns.mqtt.logging.Logger r2 = log     // Catch:{ all -> 0x011b }
            java.lang.String r3 = "CommsCallback"
            java.lang.String r4 = "run"
            java.lang.String r5 = "706"
            r2.fine(r3, r4, r5)     // Catch:{ all -> 0x011b }
            java.lang.Object r2 = r7.spaceAvailable     // Catch:{ all -> 0x011b }
            r2.notifyAll()     // Catch:{ all -> 0x011b }
            monitor-exit(r1)     // Catch:{ all -> 0x011b }
            throw r0
        L_0x011b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x011b }
            throw r0
        L_0x011e:
            return
        L_0x011f:
            r7.running = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.CommsCallback.TRun():void");
    }

    public void asyncOperationComplete(MqttToken mqttToken) {
        if (this.running) {
            this.completeQueue.addElement(mqttToken);
            synchronized (this.workAvailable) {
                log.fine(CLASS_NAME, "asyncOperationComplete", "715", new Object[]{mqttToken.internalTok.getKey()});
                this.workAvailable.notifyAll();
            }
            return;
        }
        try {
            handleActionComplete(mqttToken);
        } catch (Throwable th2) {
            TBaseLogger.e(CLASS_NAME, "asyncOperationComplete", th2);
            this.clientComms.shutdownConnection((MqttToken) null, new MqttException(th2));
        }
    }

    public void connectionLost(MqttException mqttException) {
        try {
            if (!(this.mqttCallback == null || mqttException == null)) {
                log.fine(CLASS_NAME, "connectionLost", "708", new Object[]{mqttException});
                this.mqttCallback.connectionLost(mqttException);
            }
            MqttCallbackExtended mqttCallbackExtended = this.reconnectInternalCallback;
            if (mqttCallbackExtended != null && mqttException != null) {
                mqttCallbackExtended.connectionLost(mqttException);
            }
        } catch (Throwable th2) {
            TBaseLogger.e(CLASS_NAME, "connectionLost", th2);
        }
    }

    public boolean deliverMessage(String str, int i11, MqttMessage mqttMessage) throws Exception {
        Enumeration keys = this.callbacks.keys();
        boolean z11 = false;
        while (keys.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            if (MqttTopic.isMatched(str2, str)) {
                mqttMessage.setId(i11);
                ((IMqttMessageListener) this.callbacks.get(str2)).messageArrived(str, mqttMessage);
                z11 = true;
            }
        }
        if (this.mqttCallback == null || z11) {
            return z11;
        }
        mqttMessage.setId(i11);
        this.mqttCallback.messageArrived(str, mqttMessage);
        return true;
    }

    public void fireActionEvent(MqttToken mqttToken) {
        IMqttActionListener actionCallback;
        if (mqttToken != null && (actionCallback = mqttToken.getActionCallback()) != null) {
            if (mqttToken.getException() == null) {
                log.fine(CLASS_NAME, "fireActionEvent", "716", new Object[]{mqttToken.internalTok.getKey()});
                actionCallback.onSuccess(mqttToken);
                return;
            }
            log.fine(CLASS_NAME, "fireActionEvent", "716", new Object[]{mqttToken.internalTok.getKey()});
            actionCallback.onFailure(mqttToken, mqttToken.getException());
        }
    }

    public Thread getThread() {
        return this.callbackThread;
    }

    public boolean isQuiesced() {
        return this.quiescing && this.completeQueue.size() == 0 && this.messageQueue.size() == 0;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000f */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x000f A[LOOP:0: B:6:0x000f->B:33:0x000f, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void messageArrived(com.tencent.android.tpns.mqtt.internal.wire.MqttPublish r6) {
        /*
            r5 = this;
            com.tencent.android.tpns.mqtt.MqttCallback r0 = r5.mqttCallback
            if (r0 != 0) goto L_0x000c
            java.util.Hashtable r0 = r5.callbacks
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0056
        L_0x000c:
            java.lang.Object r0 = r5.spaceAvailable
            monitor-enter(r0)
        L_0x000f:
            boolean r1 = r5.running     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0034
            boolean r1 = r5.quiescing     // Catch:{ all -> 0x0057 }
            if (r1 != 0) goto L_0x0034
            java.util.Vector r1 = r5.messageQueue     // Catch:{ all -> 0x0057 }
            int r1 = r1.size()     // Catch:{ all -> 0x0057 }
            r2 = 10
            if (r1 < r2) goto L_0x0034
            com.tencent.android.tpns.mqtt.logging.Logger r1 = log     // Catch:{ InterruptedException -> 0x000f }
            java.lang.String r2 = "CommsCallback"
            java.lang.String r3 = "messageArrived"
            java.lang.String r4 = "709"
            r1.fine(r2, r3, r4)     // Catch:{ InterruptedException -> 0x000f }
            java.lang.Object r1 = r5.spaceAvailable     // Catch:{ InterruptedException -> 0x000f }
            r2 = 200(0xc8, double:9.9E-322)
            r1.wait(r2)     // Catch:{ InterruptedException -> 0x000f }
            goto L_0x000f
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            boolean r0 = r5.quiescing
            if (r0 != 0) goto L_0x0056
            java.util.Vector r0 = r5.messageQueue
            r0.addElement(r6)
            java.lang.Object r6 = r5.workAvailable
            monitor-enter(r6)
            com.tencent.android.tpns.mqtt.logging.Logger r0 = log     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = "CommsCallback"
            java.lang.String r2 = "messageArrived"
            java.lang.String r3 = "710"
            r0.fine(r1, r2, r3)     // Catch:{ all -> 0x0053 }
            java.lang.Object r0 = r5.workAvailable     // Catch:{ all -> 0x0053 }
            r0.notifyAll()     // Catch:{ all -> 0x0053 }
            monitor-exit(r6)     // Catch:{ all -> 0x0053 }
            goto L_0x0056
        L_0x0053:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0053 }
            throw r0
        L_0x0056:
            return
        L_0x0057:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.CommsCallback.messageArrived(com.tencent.android.tpns.mqtt.internal.wire.MqttPublish):void");
    }

    public void messageArrivedComplete(int i11, int i12) throws MqttException {
        if (i12 == 1) {
            this.clientComms.internalSend(new MqttPubAck(i11), new MqttToken(this.clientComms.getClient().getClientId()));
        } else if (i12 == 2) {
            this.clientComms.deliveryComplete(i11);
            MqttPubComp mqttPubComp = new MqttPubComp(i11);
            ClientComms clientComms2 = this.clientComms;
            clientComms2.internalSend(mqttPubComp, new MqttToken(clientComms2.getClient().getClientId()));
        }
    }

    public void quiesce() {
        this.quiescing = true;
        synchronized (this.spaceAvailable) {
            log.fine(CLASS_NAME, "quiesce", "711");
            this.spaceAvailable.notifyAll();
        }
    }

    public void removeMessageListener(String str) {
        this.callbacks.remove(str);
    }

    public void removeMessageListeners() {
        this.callbacks.clear();
    }

    public void setCallback(MqttCallback mqttCallback2) {
        this.mqttCallback = mqttCallback2;
    }

    public void setClientState(ClientState clientState2) {
        this.clientState = clientState2;
    }

    public void setManualAcks(boolean z11) {
        this.manualAcks = z11;
    }

    public void setMessageListener(String str, IMqttMessageListener iMqttMessageListener) {
        this.callbacks.put(str, iMqttMessageListener);
    }

    public void setReconnectCallback(MqttCallbackExtended mqttCallbackExtended) {
        this.reconnectInternalCallback = mqttCallbackExtended;
    }

    public void start(String str, ExecutorService executorService) {
        this.threadName = str;
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.messageQueue.clear();
                this.completeQueue.clear();
                this.running = true;
                this.quiescing = false;
                this.callbackFuture = executorService.submit(this);
            }
        }
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void stop() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lifecycle
            monitor-enter(r0)
            java.util.concurrent.Future r1 = r6.callbackFuture     // Catch:{ all -> 0x0063 }
            if (r1 == 0) goto L_0x000b
            r2 = 1
            r1.cancel(r2)     // Catch:{ all -> 0x0063 }
        L_0x000b:
            boolean r1 = r6.running     // Catch:{ all -> 0x0063 }
            if (r1 == 0) goto L_0x0053
            com.tencent.android.tpns.mqtt.logging.Logger r1 = log     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = "CommsCallback"
            java.lang.String r3 = "stop"
            java.lang.String r4 = "700"
            r1.fine(r2, r3, r4)     // Catch:{ all -> 0x0063 }
            r2 = 0
            r6.running = r2     // Catch:{ all -> 0x0063 }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0063 }
            java.lang.Thread r3 = r6.callbackThread     // Catch:{ all -> 0x0063 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0063 }
            if (r2 != 0) goto L_0x0053
            java.lang.Object r2 = r6.workAvailable     // Catch:{ InterruptedException -> 0x0050, all -> 0x0049 }
            monitor-enter(r2)     // Catch:{ InterruptedException -> 0x0050, all -> 0x0049 }
            java.lang.String r3 = "CommsCallback"
            java.lang.String r4 = "stop"
            java.lang.String r5 = "701"
            r1.fine(r3, r4, r5)     // Catch:{ all -> 0x0046 }
            java.lang.Object r1 = r6.workAvailable     // Catch:{ all -> 0x0046 }
            r1.notifyAll()     // Catch:{ all -> 0x0046 }
            monitor-exit(r2)     // Catch:{ all -> 0x0046 }
            java.util.concurrent.Semaphore r1 = r6.runningSemaphore     // Catch:{ InterruptedException -> 0x0050, all -> 0x0049 }
            r1.acquire()     // Catch:{ InterruptedException -> 0x0050, all -> 0x0049 }
            java.util.concurrent.Semaphore r1 = r6.runningSemaphore     // Catch:{ all -> 0x0063 }
        L_0x0042:
            r1.release()     // Catch:{ all -> 0x0063 }
            goto L_0x0053
        L_0x0046:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0046 }
            throw r1     // Catch:{ InterruptedException -> 0x0050, all -> 0x0049 }
        L_0x0049:
            r1 = move-exception
            java.util.concurrent.Semaphore r2 = r6.runningSemaphore     // Catch:{ all -> 0x0063 }
            r2.release()     // Catch:{ all -> 0x0063 }
            throw r1     // Catch:{ all -> 0x0063 }
        L_0x0050:
            java.util.concurrent.Semaphore r1 = r6.runningSemaphore     // Catch:{ all -> 0x0063 }
            goto L_0x0042
        L_0x0053:
            r1 = 0
            r6.callbackThread = r1     // Catch:{ all -> 0x0063 }
            com.tencent.android.tpns.mqtt.logging.Logger r1 = log     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = "CommsCallback"
            java.lang.String r3 = "stop"
            java.lang.String r4 = "703"
            r1.fine(r2, r3, r4)     // Catch:{ all -> 0x0063 }
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return
        L_0x0063:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.CommsCallback.stop():void");
    }
}
