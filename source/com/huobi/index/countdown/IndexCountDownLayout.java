package com.huobi.index.countdown;

import android.content.Context;
import android.util.AttributeSet;

public class IndexCountDownLayout extends CountDownLayout {

    /* renamed from: q  reason: collision with root package name */
    public final IndexCountDownManager f73254q = new IndexCountDownManager();

    public IndexCountDownLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private IndexCountDownManager getCountDownManager() {
        return this.f73254q;
    }

    public void g() {
        getCountDownManager().s(this);
    }

    public long getInitTime() {
        return getCountDownManager().j();
    }

    public void h() {
        getCountDownManager().v(this);
    }

    public IndexCountDownLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
