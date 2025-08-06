package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ah;
import com.google.android.play.integrity.internal.ai;
import com.google.android.play.integrity.internal.aj;
import com.google.android.play.integrity.internal.al;

final class s {

    /* renamed from: a  reason: collision with root package name */
    private final s f66848a = this;

    /* renamed from: b  reason: collision with root package name */
    private final al f66849b;

    /* renamed from: c  reason: collision with root package name */
    private final al f66850c;

    /* renamed from: d  reason: collision with root package name */
    private final al f66851d;

    /* renamed from: e  reason: collision with root package name */
    private final al f66852e;

    /* renamed from: f  reason: collision with root package name */
    private final al f66853f;

    public /* synthetic */ s(Context context, r rVar) {
        ai b11 = aj.b(context);
        this.f66849b = b11;
        al b12 = ah.b(an.f66794a);
        this.f66850c = b12;
        al b13 = ah.b(new az(b11, b12));
        this.f66851d = b13;
        al b14 = ah.b(new be(b13));
        this.f66852e = b14;
        this.f66853f = ah.b(new am(b13, b14));
    }

    public final StandardIntegrityManager a() {
        return (StandardIntegrityManager) this.f66853f.a();
    }
}
