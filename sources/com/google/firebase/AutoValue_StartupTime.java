package com.google.firebase;

final class AutoValue_StartupTime extends StartupTime {
    private final long elapsedRealtime;
    private final long epochMillis;
    private final long uptimeMillis;

    public AutoValue_StartupTime(long j11, long j12, long j13) {
        this.epochMillis = j11;
        this.elapsedRealtime = j12;
        this.uptimeMillis = j13;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StartupTime)) {
            return false;
        }
        StartupTime startupTime = (StartupTime) obj;
        if (this.epochMillis == startupTime.getEpochMillis() && this.elapsedRealtime == startupTime.getElapsedRealtime() && this.uptimeMillis == startupTime.getUptimeMillis()) {
            return true;
        }
        return false;
    }

    public long getElapsedRealtime() {
        return this.elapsedRealtime;
    }

    public long getEpochMillis() {
        return this.epochMillis;
    }

    public long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public int hashCode() {
        long j11 = this.epochMillis;
        long j12 = this.elapsedRealtime;
        long j13 = this.uptimeMillis;
        return ((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ ((int) ((j13 >>> 32) ^ j13));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.epochMillis + ", elapsedRealtime=" + this.elapsedRealtime + ", uptimeMillis=" + this.uptimeMillis + "}";
    }
}
