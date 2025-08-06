package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorPingSender implements MqttPingSender {
    private static final String CLASS_NAME = "ScheduledExecutorPingSender";
    /* access modifiers changed from: private */
    public static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    /* access modifiers changed from: private */
    public String clientid;
    /* access modifiers changed from: private */
    public ClientComms comms;
    private ScheduledExecutorService executorService;
    private ScheduledFuture scheduledFuture;

    public class PingRunnable extends TTask {
        private static final String methodName = "PingTask.run";

        private PingRunnable() {
        }

        public void TRun() {
            String name = Thread.currentThread().getName();
            Thread currentThread = Thread.currentThread();
            currentThread.setName("MQTT Ping: " + ScheduledExecutorPingSender.this.clientid);
            ScheduledExecutorPingSender.log.fine(ScheduledExecutorPingSender.CLASS_NAME, methodName, "660", new Object[]{new Long(System.currentTimeMillis())});
            ScheduledExecutorPingSender.this.comms.checkForActivity();
            Thread.currentThread().setName(name);
        }
    }

    public ScheduledExecutorPingSender(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService != null) {
            this.executorService = scheduledExecutorService;
            return;
        }
        throw new IllegalArgumentException("ExecutorService cannot be null.");
    }

    public void init(ClientComms clientComms) {
        if (clientComms != null) {
            this.comms = clientComms;
            this.clientid = clientComms.getClient().getClientId();
            return;
        }
        throw new IllegalArgumentException("ClientComms cannot be null.");
    }

    public void schedule(long j11) {
        this.scheduledFuture = this.executorService.schedule(new PingRunnable(), j11, TimeUnit.MILLISECONDS);
    }

    public void start() {
        log.fine(CLASS_NAME, "start", "659", new Object[]{this.clientid});
        schedule(this.comms.getKeepAlive());
    }

    public void stop() {
        log.fine(CLASS_NAME, "stop", "661", (Object[]) null);
        ScheduledFuture scheduledFuture2 = this.scheduledFuture;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
    }
}
