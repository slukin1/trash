package com.google.android.exoplayer2.extractor;

public final class SeekPoint {
    public static final SeekPoint START = new SeekPoint(0, 0);
    public final long position;
    public final long timeUs;

    public SeekPoint(long j11, long j12) {
        this.timeUs = j11;
        this.position = j12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekPoint.class != obj.getClass()) {
            return false;
        }
        SeekPoint seekPoint = (SeekPoint) obj;
        if (this.timeUs == seekPoint.timeUs && this.position == seekPoint.position) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.timeUs) * 31) + ((int) this.position);
    }

    public String toString() {
        long j11 = this.timeUs;
        long j12 = this.position;
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("[timeUs=");
        sb2.append(j11);
        sb2.append(", position=");
        sb2.append(j12);
        sb2.append("]");
        return sb2.toString();
    }
}
