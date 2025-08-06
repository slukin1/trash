package com.google.android.exoplayer2;

public final class RendererConfiguration {
    public static final RendererConfiguration DEFAULT = new RendererConfiguration(false);
    public final boolean tunneling;

    public RendererConfiguration(boolean z11) {
        this.tunneling = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RendererConfiguration.class != obj.getClass()) {
            return false;
        }
        if (this.tunneling == ((RendererConfiguration) obj).tunneling) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.tunneling ^ true ? 1 : 0;
    }
}
