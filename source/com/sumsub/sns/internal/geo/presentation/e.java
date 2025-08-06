package com.sumsub.sns.internal.geo.presentation;

import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import java.util.List;
import kotlin.jvm.internal.r;

public abstract class e implements a.l {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f34847a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f34848b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f34849c;

    /* renamed from: d  reason: collision with root package name */
    public final CharSequence f34850d;

    public static final class a extends e {

        /* renamed from: e  reason: collision with root package name */
        public final g.a f34851e;

        public a(CharSequence charSequence, CharSequence charSequence2, g.a aVar, CharSequence charSequence3, CharSequence charSequence4) {
            super(charSequence, charSequence2, charSequence3, charSequence4, (r) null);
            this.f34851e = aVar;
        }

        public final g.a e() {
            return this.f34851e;
        }
    }

    public static final class b extends e {

        /* renamed from: e  reason: collision with root package name */
        public final String f34852e;

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f34853f;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(CharSequence charSequence, CharSequence charSequence2, String str, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, int i11, r rVar) {
            this(charSequence, charSequence2, str, charSequence3, (i11 & 16) != 0 ? null : charSequence4, (i11 & 32) != 0 ? null : charSequence5);
        }

        public final CharSequence e() {
            return this.f34853f;
        }

        public final String f() {
            return this.f34852e;
        }

        public b(CharSequence charSequence, CharSequence charSequence2, String str, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
            super(charSequence, charSequence2, charSequence4, charSequence5, (r) null);
            this.f34852e = str;
            this.f34853f = charSequence3;
        }
    }

    public static final class c extends e {

        /* renamed from: e  reason: collision with root package name */
        public static final c f34854e = new c();

        public c() {
            super((CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, 15, (r) null);
        }
    }

    public static final class d extends e {

        /* renamed from: e  reason: collision with root package name */
        public final List<FormItem> f34855e;

        /* renamed from: f  reason: collision with root package name */
        public final String f34856f;

        /* renamed from: g  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.model.e f34857g;

        public d(CharSequence charSequence, CharSequence charSequence2, List<? extends FormItem> list, String str, com.sumsub.sns.internal.core.data.model.e eVar, CharSequence charSequence3, CharSequence charSequence4) {
            super(charSequence, charSequence2, charSequence3, charSequence4, (r) null);
            this.f34855e = list;
            this.f34856f = str;
            this.f34857g = eVar;
        }

        public static /* synthetic */ void h() {
        }

        public final com.sumsub.sns.internal.core.data.model.e e() {
            return this.f34857g;
        }

        public final String f() {
            return this.f34856f;
        }

        public final List<FormItem> g() {
            return this.f34855e;
        }
    }

    /* renamed from: com.sumsub.sns.internal.geo.presentation.e$e  reason: collision with other inner class name */
    public static final class C0400e extends e {

        /* renamed from: e  reason: collision with root package name */
        public static final C0400e f34858e = new C0400e();

        public C0400e() {
            super((CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (r) null);
        }
    }

    public static final class f extends e {

        /* renamed from: e  reason: collision with root package name */
        public final String f34859e;

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f34860f;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ f(CharSequence charSequence, CharSequence charSequence2, String str, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, int i11, r rVar) {
            this(charSequence, charSequence2, str, charSequence3, (i11 & 16) != 0 ? null : charSequence4, (i11 & 32) != 0 ? null : charSequence5);
        }

        public final CharSequence e() {
            return this.f34860f;
        }

        public final String f() {
            return this.f34859e;
        }

        public f(CharSequence charSequence, CharSequence charSequence2, String str, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
            super(charSequence, charSequence2, charSequence4, charSequence5, (r) null);
            this.f34859e = str;
            this.f34860f = charSequence3;
        }
    }

    public static final class g extends e {

        /* renamed from: e  reason: collision with root package name */
        public final String f34861e;

        public g(CharSequence charSequence, CharSequence charSequence2, String str, CharSequence charSequence3, CharSequence charSequence4) {
            super(charSequence, charSequence2, charSequence3, charSequence4, (r) null);
            this.f34861e = str;
        }

        public final String e() {
            return this.f34861e;
        }
    }

    public /* synthetic */ e(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, r rVar) {
        this(charSequence, charSequence2, charSequence3, charSequence4);
    }

    public final CharSequence a() {
        return this.f34849c;
    }

    public final CharSequence b() {
        return this.f34850d;
    }

    public final CharSequence c() {
        return this.f34848b;
    }

    public final CharSequence d() {
        return this.f34847a;
    }

    public e(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        this.f34847a = charSequence;
        this.f34848b = charSequence2;
        this.f34849c = charSequence3;
        this.f34850d = charSequence4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? null : charSequence3, (i11 & 8) != 0 ? null : charSequence4, (r) null);
    }
}
