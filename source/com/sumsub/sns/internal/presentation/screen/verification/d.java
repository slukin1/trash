package com.sumsub.sns.internal.presentation.screen.verification;

import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.presentation.base.adapter.f;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

public abstract class d implements a.l {

    /* renamed from: f  reason: collision with root package name */
    public static final a f36418f = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f36419a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f36420b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f36421c;

    /* renamed from: d  reason: collision with root package name */
    public List<? extends com.sumsub.sns.internal.core.presentation.base.adapter.a> f36422d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f36423e;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final d a() {
            return new c();
        }

        public a() {
        }
    }

    public static final class b extends d {
        public b(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, List<? extends com.sumsub.sns.internal.core.presentation.base.adapter.a> list, CharSequence charSequence4) {
            super(charSequence, charSequence2, charSequence3, list, charSequence4, (r) null);
        }
    }

    public static final class c extends d {
        public c() {
            super((CharSequence) null, (CharSequence) null, (CharSequence) null, CollectionsKt__CollectionsKt.k(), (CharSequence) null, (r) null);
        }
    }

    /* renamed from: com.sumsub.sns.internal.presentation.screen.verification.d$d  reason: collision with other inner class name */
    public static final class C0487d extends d {
        public C0487d(f fVar, CharSequence charSequence) {
            super((CharSequence) null, (CharSequence) null, charSequence, CollectionsKt__CollectionsJVMKt.e(fVar), (CharSequence) null, (r) null);
        }
    }

    public static final class e extends d {

        /* renamed from: g  reason: collision with root package name */
        public final Map<String, Object> f36424g;

        /* renamed from: h  reason: collision with root package name */
        public final a f36425h;

        public e(Map<String, ? extends Object> map, CharSequence charSequence, CharSequence charSequence2, a aVar) {
            super((CharSequence) null, (CharSequence) null, charSequence, CollectionsKt__CollectionsKt.k(), charSequence2, (r) null);
            this.f36424g = map;
            this.f36425h = aVar;
        }

        public final Map<String, Object> f() {
            return this.f36424g;
        }

        public final a g() {
            return this.f36425h;
        }
    }

    public /* synthetic */ d(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, List list, CharSequence charSequence4, r rVar) {
        this(charSequence, charSequence2, charSequence3, list, charSequence4);
    }

    public final void a(List<? extends com.sumsub.sns.internal.core.presentation.base.adapter.a> list) {
        this.f36422d = list;
    }

    public final void b(CharSequence charSequence) {
        this.f36421c = charSequence;
    }

    public final void c(CharSequence charSequence) {
        this.f36420b = charSequence;
    }

    public final void d(CharSequence charSequence) {
        this.f36419a = charSequence;
    }

    public final CharSequence e() {
        return this.f36419a;
    }

    public d(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, List<? extends com.sumsub.sns.internal.core.presentation.base.adapter.a> list, CharSequence charSequence4) {
        this.f36419a = charSequence;
        this.f36420b = charSequence2;
        this.f36421c = charSequence3;
        this.f36422d = list;
        this.f36423e = charSequence4;
    }

    public final CharSequence a() {
        return this.f36423e;
    }

    public final List<com.sumsub.sns.internal.core.presentation.base.adapter.a> b() {
        return this.f36422d;
    }

    public final CharSequence c() {
        return this.f36421c;
    }

    public final CharSequence d() {
        return this.f36420b;
    }

    public final void a(CharSequence charSequence) {
        this.f36423e = charSequence;
    }
}
