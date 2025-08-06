package com.tencent.android.tpns.mqtt;

public class DisconnectedBufferOptions {
    public static final boolean DELETE_OLDEST_MESSAGES_DEFAULT = false;
    public static final boolean DISCONNECTED_BUFFER_ENABLED_DEFAULT = false;
    public static final int DISCONNECTED_BUFFER_SIZE_DEFAULT = 5000;
    public static final boolean PERSIST_DISCONNECTED_BUFFER_DEFAULT = false;
    private boolean bufferEnabled = false;
    private int bufferSize = 5000;
    private boolean deleteOldestMessages = false;
    private boolean persistBuffer = false;

    public int getBufferSize() {
        return this.bufferSize;
    }

    public boolean isBufferEnabled() {
        return this.bufferEnabled;
    }

    public boolean isDeleteOldestMessages() {
        return this.deleteOldestMessages;
    }

    public boolean isPersistBuffer() {
        return this.persistBuffer;
    }

    public void setBufferEnabled(boolean z11) {
        this.bufferEnabled = z11;
    }

    public void setBufferSize(int i11) {
        if (i11 >= 1) {
            this.bufferSize = i11;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setDeleteOldestMessages(boolean z11) {
        this.deleteOldestMessages = z11;
    }

    public void setPersistBuffer(boolean z11) {
        this.persistBuffer = z11;
    }
}
