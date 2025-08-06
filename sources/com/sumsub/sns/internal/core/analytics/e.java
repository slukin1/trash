package com.sumsub.sns.internal.core.analytics;

import com.sumsub.sns.core.data.model.SNSTrackEvents;
import d10.l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class e implements h, n, i, g, a, j, l {

    /* renamed from: d  reason: collision with root package name */
    public static final a f31896d = new a((r) null);

    /* renamed from: e  reason: collision with root package name */
    public static final SimpleDateFormat f31897e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f31898f = "Analytics";

    /* renamed from: a  reason: collision with root package name */
    public final long f31899a;

    /* renamed from: b  reason: collision with root package name */
    public final List<m> f31900b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, ? extends Object> f31901c;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends Lambda implements l<m, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f31902a = new b();

        public b() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(m mVar) {
            return mVar.getText();
        }
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        f31897e = simpleDateFormat;
    }

    public e(long j11) {
        this.f31899a = j11;
    }

    public i a() {
        return this;
    }

    public j a(SdkEvent sdkEvent) {
        this.f31900b.add(sdkEvent);
        return this;
    }

    public j b() {
        this.f31900b.add(NavigationAction.Open);
        return this;
    }

    public l c() {
        this.f31901c = com.sumsub.sns.internal.ff.a.f34215a.c();
        return this;
    }

    public j d() {
        this.f31900b.add(ActionState.Failed);
        return this;
    }

    public j e() {
        this.f31900b.add(ActionState.Completed);
        return this;
    }

    public j f() {
        this.f31900b.add(ControlAction.Checked);
        return this;
    }

    public j g() {
        this.f31900b.add(ControlAction.Clicked);
        return this;
    }

    public j h() {
        this.f31900b.add(ControlAction.Changed);
        return this;
    }

    public j i() {
        this.f31900b.add(ControlAction.Expanded);
        return this;
    }

    public j j() {
        this.f31900b.add(NavigationAction.Appear);
        return this;
    }

    public j k() {
        this.f31900b.add(ControlAction.Collapsed);
        return this;
    }

    public j l() {
        this.f31900b.add(ActionState.Started);
        return this;
    }

    public j m() {
        this.f31900b.add(NavigationAction.Cancel);
        return this;
    }

    public j n() {
        this.f31900b.add(ControlAction.Unchecked);
        return this;
    }

    public j o() {
        this.f31900b.add(NavigationAction.Close);
        return this;
    }

    public final SNSTrackEvents p() {
        String str = "msdk:" + CollectionsKt___CollectionsKt.k0(this.f31900b, ":", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, b.f31902a, 30, (Object) null);
        com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, f31898f, str + " payload: " + this.f31901c, (Throwable) null, 4, (Object) null);
        return new SNSTrackEvents(str, f31897e.format(new Date()), this.f31901c);
    }

    public n a(Screen screen) {
        this.f31900b.add(Domain.Ui);
        this.f31900b.add(screen);
        return this;
    }

    public a a(Action action) {
        this.f31900b.add(Domain.PrimaryAction);
        this.f31900b.add(action);
        return this;
    }

    public g a(Control control) {
        this.f31900b.add(control);
        return this;
    }

    public l a(Map<String, ? extends Object> map) {
        this.f31901c = MapsKt__MapsKt.o(MapsKt__MapsKt.u(map), com.sumsub.sns.internal.ff.a.f34215a.c());
        return this;
    }

    public l a(Pair<String, ? extends Object>... pairArr) {
        this.f31901c = MapsKt__MapsKt.o(MapsKt__MapsKt.w(pairArr), com.sumsub.sns.internal.ff.a.f34215a.c());
        return this;
    }

    public void a(boolean z11) {
        b.f31873a.a(p(), z11);
    }
}
