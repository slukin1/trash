package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.RelativeLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

abstract class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f69338a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f69339b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69340c = false;

    public a(Activity activity) {
        super(activity, i.a(activity));
        this.f69339b = activity;
        SizeUtil.init(activity);
    }

    private RelativeLayout g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f69339b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setLayoutParams(layoutParams);
        return relativeLayout;
    }

    private RelativeLayout h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f69339b);
        relativeLayout.setId(View.generateViewId());
        relativeLayout.setLayoutParams(b());
        i.a(relativeLayout, 0, !d());
        a(relativeLayout);
        return relativeLayout;
    }

    public void a() {
        this.f69338a = g();
        RelativeLayout h11 = h();
        this.f69338a.addView(h11);
        if (c()) {
            this.f69338a.addView(a((View) h11));
        }
        RelativeLayout relativeLayout = this.f69338a;
        setContentView(relativeLayout, relativeLayout.getLayoutParams());
        this.f69338a.setAnimation(i.a(350));
        e();
    }

    public abstract void a(RelativeLayout relativeLayout);

    public abstract RelativeLayout.LayoutParams b();

    public abstract boolean c();

    public void cancel() {
        if (!this.f69340c) {
            this.f69340c = true;
            f();
        }
    }

    public abstract boolean d();

    public abstract void e();

    public void f() {
        super.cancel();
    }

    private e a(View view) {
        e eVar = new e(this.f69339b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (d()) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            int i11 = SizeUtil.dp5;
            layoutParams.setMargins(0, i11, i11, 0);
        } else {
            layoutParams.addRule(6, view.getId());
            layoutParams.addRule(7, view.getId());
            int i12 = SizeUtil.dp7;
            layoutParams.setMargins(0, -i12, -i12, 0);
        }
        eVar.setLayoutParams(layoutParams);
        eVar.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                a.this.cancel();
                a.this.f69339b.finish();
                a.this.f69339b.overridePendingTransition(0, 0);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        return eVar;
    }
}
