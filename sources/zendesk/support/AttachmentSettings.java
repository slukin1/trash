package zendesk.support;

class AttachmentSettings {
    private static AttachmentSettings DEFAULT = new AttachmentSettings(false, 0);
    private boolean enabled;
    private long maxAttachmentSize;

    public AttachmentSettings(boolean z11, long j11) {
        this.enabled = z11;
        this.maxAttachmentSize = j11;
    }

    public static AttachmentSettings defaultSettings() {
        return DEFAULT;
    }

    public long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public AttachmentSettings() {
    }
}
