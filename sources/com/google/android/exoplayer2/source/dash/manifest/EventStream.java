package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;

public final class EventStream {
    public final EventMessage[] events;
    public final long[] presentationTimesUs;
    public final String schemeIdUri;
    public final long timescale;
    public final String value;

    public EventStream(String str, String str2, long j11, long[] jArr, EventMessage[] eventMessageArr) {
        this.schemeIdUri = str;
        this.value = str2;
        this.timescale = j11;
        this.presentationTimesUs = jArr;
        this.events = eventMessageArr;
    }

    public String id() {
        String str = this.schemeIdUri;
        String str2 = this.value;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append("/");
        sb2.append(str2);
        return sb2.toString();
    }
}
