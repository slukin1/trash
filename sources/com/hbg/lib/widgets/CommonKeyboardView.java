package com.hbg.lib.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class CommonKeyboardView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f71143b;

    /* renamed from: c  reason: collision with root package name */
    public a f71144c;

    public interface a {
        void j(String str);

        void k();

        void l();
    }

    public CommonKeyboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d(String str, View view) {
        if (TextUtils.equals(str, "clear")) {
            a aVar = this.f71144c;
            if (aVar != null) {
                aVar.k();
            }
        } else {
            a aVar2 = this.f71144c;
            if (aVar2 != null) {
                aVar2.j(str);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean e(View view) {
        a aVar = this.f71144c;
        if (aVar == null) {
            return false;
        }
        aVar.l();
        return false;
    }

    private void setKeyClickListener(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof String) {
                String str = (String) tag;
                view.setOnClickListener(new q(this, str));
                if (TextUtils.equals(str, "clear")) {
                    view.setOnLongClickListener(new r(this));
                }
            }
        }
    }

    public final void c() {
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.common_keyboard_layout, this, false);
        addView(inflate);
        this.f71143b = (LinearLayout) inflate.findViewById(R$id.root_view);
        for (int i11 = 0; i11 < this.f71143b.getChildCount(); i11++) {
            if (this.f71143b.getChildAt(i11) instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) this.f71143b.getChildAt(i11);
                for (int i12 = 0; i12 < linearLayout.getChildCount(); i12++) {
                    setKeyClickListener(linearLayout.getChildAt(i12));
                }
            }
        }
    }

    public void setItemClickListener(a aVar) {
        this.f71144c = aVar;
    }

    public CommonKeyboardView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c();
    }
}
