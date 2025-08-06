package com.hbg.module.content.widgets.ad;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.module.content.R$styleable;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.properties.b;
import kotlin.properties.d;
import kotlin.reflect.l;

public final class AdItemView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f18955d = {Reflection.e(new MutablePropertyReference1Impl(AdItemView.class, "adType", "getAdType()I", 0))};

    /* renamed from: b  reason: collision with root package name */
    public a f18956b;

    /* renamed from: c  reason: collision with root package name */
    public final d f18957c;

    public static final class a extends b<Integer> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdItemView f18958b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f18959c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Object obj, AdItemView adItemView, Context context) {
            super(obj);
            this.f18958b = adItemView;
            this.f18959c = context;
        }

        public void c(l<?> lVar, Integer num, Integer num2) {
            int intValue = num2.intValue();
            if (num.intValue() != intValue) {
                this.f18958b.setAdDelegate(intValue == 1 ? new NewsAdView() : null);
                a adDelegate = this.f18958b.getAdDelegate();
                if (adDelegate != null) {
                    adDelegate.b(this.f18959c, this.f18958b);
                }
            }
        }
    }

    public AdItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdItemView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final a getAdDelegate() {
        return this.f18956b;
    }

    public final int getAdType() {
        return ((Number) this.f18957c.a(this, f18955d[0])).intValue();
    }

    public final void h() {
        setVisibility(8);
    }

    public final void i() {
        setVisibility(0);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f18956b;
        if (aVar != null) {
            aVar.d();
        }
    }

    public final void setAdDelegate(a aVar) {
        this.f18956b = aVar;
    }

    public final void setAdType(int i11) {
        this.f18957c.b(this, f18955d[0], Integer.valueOf(i11));
    }

    public AdItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        kotlin.properties.a aVar = kotlin.properties.a.f56811a;
        this.f18957c = new a(-1, this, context);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AdItemView);
            setAdType(obtainStyledAttributes.getInteger(R$styleable.AdItemView_adType, 1));
            obtainStyledAttributes.recycle();
        }
    }
}
