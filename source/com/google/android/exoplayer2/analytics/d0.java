package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;
import java.io.IOException;

public final /* synthetic */ class d0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65704a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f65705b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f65706c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ IOException f65707d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f65708e;

    public /* synthetic */ d0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
        this.f65704a = eventTime;
        this.f65705b = loadEventInfo;
        this.f65706c = mediaLoadData;
        this.f65707d = iOException;
        this.f65708e = z11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onLoadError(this.f65704a, this.f65705b, this.f65706c, this.f65707d, this.f65708e);
    }
}
