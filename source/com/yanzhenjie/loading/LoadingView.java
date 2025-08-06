package com.yanzhenjie.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import cz.a;
import cz.b;

public class LoadingView extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    public b f52628b;

    /* renamed from: c  reason: collision with root package name */
    public a f52629c;

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f52629c = new a(context);
        b bVar = new b(this.f52629c);
        this.f52628b = bVar;
        setImageDrawable(bVar);
    }

    public void a(int i11, int i12, int i13) {
        this.f52629c.w(i11, i12, i13);
    }

    public final void b() {
        b bVar = this.f52628b;
        if (bVar != null) {
            bVar.start();
        }
    }

    public final void c() {
        b bVar = this.f52628b;
        if (bVar != null) {
            bVar.stop();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 == 0) {
            b();
        } else {
            c();
        }
    }
}
