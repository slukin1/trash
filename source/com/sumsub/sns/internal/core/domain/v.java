package com.sumsub.sns.internal.core.domain;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.google.android.gms.tasks.OnSuccessListener;
import d10.l;
import java.util.List;

public final /* synthetic */ class v implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f33691a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bitmap f33692b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f33693c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RectF f33694d;

    public /* synthetic */ v(l lVar, Bitmap bitmap, l lVar2, RectF rectF) {
        this.f33691a = lVar;
        this.f33692b = bitmap;
        this.f33693c = lVar2;
        this.f33694d = rectF;
    }

    public final void onSuccess(Object obj) {
        l.a(this.f33691a, this.f33692b, this.f33693c, this.f33694d, (List) obj);
    }
}
