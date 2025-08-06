package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;

public interface SeekMap {

    public static final class SeekPoints {
        public final SeekPoint first;
        public final SeekPoint second;

        public SeekPoints(SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SeekPoints.class != obj.getClass()) {
                return false;
            }
            SeekPoints seekPoints = (SeekPoints) obj;
            if (!this.first.equals(seekPoints.first) || !this.second.equals(seekPoints.second)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            String str;
            String valueOf = String.valueOf(this.first);
            if (this.first.equals(this.second)) {
                str = "";
            } else {
                String valueOf2 = String.valueOf(this.second);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 2);
                sb2.append(", ");
                sb2.append(valueOf2);
                str = sb2.toString();
            }
            StringBuilder sb3 = new StringBuilder(valueOf.length() + 2 + String.valueOf(str).length());
            sb3.append("[");
            sb3.append(valueOf);
            sb3.append(str);
            sb3.append("]");
            return sb3.toString();
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.first = (SeekPoint) Assertions.checkNotNull(seekPoint);
            this.second = (SeekPoint) Assertions.checkNotNull(seekPoint2);
        }
    }

    public static class Unseekable implements SeekMap {
        private final long durationUs;
        private final SeekPoints startSeekPoints;

        public Unseekable(long j11) {
            this(j11, 0);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public SeekPoints getSeekPoints(long j11) {
            return this.startSeekPoints;
        }

        public boolean isSeekable() {
            return false;
        }

        public Unseekable(long j11, long j12) {
            this.durationUs = j11;
            this.startSeekPoints = new SeekPoints(j12 == 0 ? SeekPoint.START : new SeekPoint(0, j12));
        }
    }

    long getDurationUs();

    SeekPoints getSeekPoints(long j11);

    boolean isSeekable();
}
