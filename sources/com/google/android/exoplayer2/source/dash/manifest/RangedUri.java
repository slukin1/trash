package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.UriUtil;

public final class RangedUri {
    private int hashCode;
    public final long length;
    private final String referenceUri;
    public final long start;

    public RangedUri(String str, long j11, long j12) {
        this.referenceUri = str == null ? "" : str;
        this.start = j11;
        this.length = j12;
    }

    public RangedUri attemptMerge(RangedUri rangedUri, String str) {
        String resolveUriString = resolveUriString(str);
        if (rangedUri != null && resolveUriString.equals(rangedUri.resolveUriString(str))) {
            long j11 = this.length;
            long j12 = -1;
            if (j11 != -1) {
                long j13 = this.start;
                if (j13 + j11 == rangedUri.start) {
                    long j14 = rangedUri.length;
                    if (j14 != -1) {
                        j12 = j11 + j14;
                    }
                    return new RangedUri(resolveUriString, j13, j12);
                }
            }
            long j15 = rangedUri.length;
            if (j15 != -1) {
                long j16 = rangedUri.start;
                if (j16 + j15 == this.start) {
                    if (j11 != -1) {
                        j12 = j15 + j11;
                    }
                    return new RangedUri(resolveUriString, j16, j12);
                }
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RangedUri.class != obj.getClass()) {
            return false;
        }
        RangedUri rangedUri = (RangedUri) obj;
        if (this.start == rangedUri.start && this.length == rangedUri.length && this.referenceUri.equals(rangedUri.referenceUri)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((527 + ((int) this.start)) * 31) + ((int) this.length)) * 31) + this.referenceUri.hashCode();
        }
        return this.hashCode;
    }

    public Uri resolveUri(String str) {
        return UriUtil.resolveToUri(str, this.referenceUri);
    }

    public String resolveUriString(String str) {
        return UriUtil.resolve(str, this.referenceUri);
    }

    public String toString() {
        String str = this.referenceUri;
        long j11 = this.start;
        long j12 = this.length;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 81);
        sb2.append("RangedUri(referenceUri=");
        sb2.append(str);
        sb2.append(", start=");
        sb2.append(j11);
        sb2.append(", length=");
        sb2.append(j12);
        sb2.append(")");
        return sb2.toString();
    }
}
