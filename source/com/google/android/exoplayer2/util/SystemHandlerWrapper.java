package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.util.HandlerWrapper;
import java.util.ArrayList;
import java.util.List;

final class SystemHandlerWrapper implements HandlerWrapper {
    private static final int MAX_POOL_SIZE = 50;
    private static final List<SystemMessage> messagePool = new ArrayList(50);
    private final Handler handler;

    public static final class SystemMessage implements HandlerWrapper.Message {
        private SystemHandlerWrapper handler;
        private Message message;

        private SystemMessage() {
        }

        private void recycle() {
            this.message = null;
            this.handler = null;
            SystemHandlerWrapper.recycleMessage(this);
        }

        public HandlerWrapper getTarget() {
            return (HandlerWrapper) Assertions.checkNotNull(this.handler);
        }

        public boolean sendAtFrontOfQueue(Handler handler2) {
            boolean sendMessageAtFrontOfQueue = handler2.sendMessageAtFrontOfQueue((Message) Assertions.checkNotNull(this.message));
            recycle();
            return sendMessageAtFrontOfQueue;
        }

        public void sendToTarget() {
            ((Message) Assertions.checkNotNull(this.message)).sendToTarget();
            recycle();
        }

        public SystemMessage setMessage(Message message2, SystemHandlerWrapper systemHandlerWrapper) {
            this.message = message2;
            this.handler = systemHandlerWrapper;
            return this;
        }
    }

    public SystemHandlerWrapper(Handler handler2) {
        this.handler = handler2;
    }

    private static SystemMessage obtainSystemMessage() {
        SystemMessage systemMessage;
        List<SystemMessage> list = messagePool;
        synchronized (list) {
            if (list.isEmpty()) {
                systemMessage = new SystemMessage();
            } else {
                systemMessage = list.remove(list.size() - 1);
            }
        }
        return systemMessage;
    }

    /* access modifiers changed from: private */
    public static void recycleMessage(SystemMessage systemMessage) {
        List<SystemMessage> list = messagePool;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(systemMessage);
            }
        }
    }

    public Looper getLooper() {
        return this.handler.getLooper();
    }

    public boolean hasMessages(int i11) {
        return this.handler.hasMessages(i11);
    }

    public HandlerWrapper.Message obtainMessage(int i11) {
        return obtainSystemMessage().setMessage(this.handler.obtainMessage(i11), this);
    }

    public boolean post(Runnable runnable) {
        return this.handler.post(runnable);
    }

    public boolean postAtFrontOfQueue(Runnable runnable) {
        return this.handler.postAtFrontOfQueue(runnable);
    }

    public boolean postDelayed(Runnable runnable, long j11) {
        return this.handler.postDelayed(runnable, j11);
    }

    public void removeCallbacksAndMessages(Object obj) {
        this.handler.removeCallbacksAndMessages(obj);
    }

    public void removeMessages(int i11) {
        this.handler.removeMessages(i11);
    }

    public boolean sendEmptyMessage(int i11) {
        return this.handler.sendEmptyMessage(i11);
    }

    public boolean sendEmptyMessageAtTime(int i11, long j11) {
        return this.handler.sendEmptyMessageAtTime(i11, j11);
    }

    public boolean sendEmptyMessageDelayed(int i11, int i12) {
        return this.handler.sendEmptyMessageDelayed(i11, (long) i12);
    }

    public boolean sendMessageAtFrontOfQueue(HandlerWrapper.Message message) {
        return ((SystemMessage) message).sendAtFrontOfQueue(this.handler);
    }

    public HandlerWrapper.Message obtainMessage(int i11, Object obj) {
        return obtainSystemMessage().setMessage(this.handler.obtainMessage(i11, obj), this);
    }

    public HandlerWrapper.Message obtainMessage(int i11, int i12, int i13) {
        return obtainSystemMessage().setMessage(this.handler.obtainMessage(i11, i12, i13), this);
    }

    public HandlerWrapper.Message obtainMessage(int i11, int i12, int i13, Object obj) {
        return obtainSystemMessage().setMessage(this.handler.obtainMessage(i11, i12, i13, obj), this);
    }
}
