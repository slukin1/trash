package com.huobi.login.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pn.g;
import pn.h;
import pro.huobi.R;

public class RegisterBottomTipsLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f75574b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f75575c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f75576d;

    /* renamed from: e  reason: collision with root package name */
    public b f75577e;

    public class a implements tx.a {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(Bitmap bitmap) {
            if (RegisterBottomTipsLayout.this.f75576d != null) {
                RegisterBottomTipsLayout.this.f75576d.setImageBitmap(bitmap);
            }
            RegisterBottomTipsLayout.this.setVisibility(0);
        }

        public void a(String str, View view) {
        }

        public void b(String str, View view, FailReason failReason) {
        }

        public void c(String str, View view, Bitmap bitmap) {
            RegisterBottomTipsLayout.this.post(new h(this, bitmap));
        }

        public void d(String str, View view) {
        }
    }

    public interface b {
        void a();
    }

    public RegisterBottomTipsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d(View view) {
        b bVar = this.f75577e;
        if (bVar != null) {
            bVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void c(Context context) {
        FrameLayout.inflate(context, R.layout.layout_register_bottom_tips, this);
        this.f75574b = (TextView) findViewById(R.id.id_register_bottom_tips_title_tv);
        this.f75575c = (TextView) findViewById(R.id.id_register_bottom_tips_desc_tv);
        this.f75576d = (ImageView) findViewById(R.id.id_register_bottom_tips_image);
        findViewById(R.id.id_register_bottom_tips_close_btn).setOnClickListener(new g(this));
    }

    public void setCallback(b bVar) {
        this.f75577e = bVar;
    }

    public void setDesc(String str) {
        TextView textView = this.f75575c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setImageUrl(String str) {
        g6.b.c().m(str, new a());
    }

    public void setTitle(String str) {
        TextView textView = this.f75574b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public RegisterBottomTipsLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context);
    }
}
