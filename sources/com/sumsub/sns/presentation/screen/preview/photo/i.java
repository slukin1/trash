package com.sumsub.sns.presentation.screen.preview.photo;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

public final /* synthetic */ class i implements ViewPager2.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40007a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f40008b;

    public /* synthetic */ i(int i11, int i12) {
        this.f40007a = i11;
        this.f40008b = i12;
    }

    public final void transformPage(View view, float f11) {
        f.a(this.f40007a, this.f40008b, view, f11);
    }
}
