package com.hbg.module.content.utls;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.badge.BadgeDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import kotlin.jvm.internal.Ref$ObjectRef;
import lc.w6;
import rd.s;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f18923a = new o();

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18924b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18925c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18926d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f18927e;

        public a(View view, long j11, Ref$ObjectRef ref$ObjectRef, m mVar) {
            this.f18924b = view;
            this.f18925c = j11;
            this.f18926d = ref$ObjectRef;
            this.f18927e = mVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18924b) > this.f18925c || (this.f18924b instanceof Checkable)) {
                sVar.e(this.f18924b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f18924b;
                PopupWindow popupWindow = (PopupWindow) this.f18926d.element;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                m mVar = this.f18927e;
                if (mVar != null) {
                    mVar.d();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18928b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18929c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18930d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f18931e;

        public b(View view, long j11, Ref$ObjectRef ref$ObjectRef, m mVar) {
            this.f18928b = view;
            this.f18929c = j11;
            this.f18930d = ref$ObjectRef;
            this.f18931e = mVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18928b) > this.f18929c || (this.f18928b instanceof Checkable)) {
                sVar.e(this.f18928b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f18928b;
                PopupWindow popupWindow = (PopupWindow) this.f18930d.element;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                m mVar = this.f18931e;
                if (mVar != null) {
                    mVar.e();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18932b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18933c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18934d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f18935e;

        public c(View view, long j11, Ref$ObjectRef ref$ObjectRef, m mVar) {
            this.f18932b = view;
            this.f18933c = j11;
            this.f18934d = ref$ObjectRef;
            this.f18935e = mVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18932b) > this.f18933c || (this.f18932b instanceof Checkable)) {
                sVar.e(this.f18932b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f18932b;
                PopupWindow popupWindow = (PopupWindow) this.f18934d.element;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                m mVar = this.f18935e;
                if (mVar != null) {
                    mVar.a();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18936b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18937c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18938d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f18939e;

        public d(View view, long j11, Ref$ObjectRef ref$ObjectRef, m mVar) {
            this.f18936b = view;
            this.f18937c = j11;
            this.f18938d = ref$ObjectRef;
            this.f18939e = mVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18936b) > this.f18937c || (this.f18936b instanceof Checkable)) {
                sVar.e(this.f18936b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f18936b;
                PopupWindow popupWindow = (PopupWindow) this.f18938d.element;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                m mVar = this.f18939e;
                if (mVar != null) {
                    mVar.c(1);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18940b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18941c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18942d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f18943e;

        public e(View view, long j11, Ref$ObjectRef ref$ObjectRef, m mVar) {
            this.f18940b = view;
            this.f18941c = j11;
            this.f18942d = ref$ObjectRef;
            this.f18943e = mVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18940b) > this.f18941c || (this.f18940b instanceof Checkable)) {
                sVar.e(this.f18940b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f18940b;
                PopupWindow popupWindow = (PopupWindow) this.f18942d.element;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                m mVar = this.f18943e;
                if (mVar != null) {
                    mVar.c(0);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18944b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18945c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18946d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f18947e;

        public f(View view, long j11, Ref$ObjectRef ref$ObjectRef, m mVar) {
            this.f18944b = view;
            this.f18945c = j11;
            this.f18946d = ref$ObjectRef;
            this.f18947e = mVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18944b) > this.f18945c || (this.f18944b instanceof Checkable)) {
                sVar.e(this.f18944b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f18944b;
                PopupWindow popupWindow = (PopupWindow) this.f18946d.element;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                m mVar = this.f18947e;
                if (mVar != null) {
                    mVar.b();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static /* synthetic */ void f(o oVar, FragmentActivity fragmentActivity, View view, m mVar, boolean z11, boolean z12, boolean z13, boolean z14, int i11, Object obj) {
        oVar.e(fragmentActivity, view, mVar, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? false : z12, (i11 & 32) != 0 ? false : z13, (i11 & 64) != 0 ? false : z14);
    }

    public static final void g(FragmentActivity fragmentActivity) {
        f18923a.b(fragmentActivity, 1.0f);
    }

    public final void b(FragmentActivity fragmentActivity, float f11) {
        WindowManager.LayoutParams attributes = fragmentActivity.getWindow().getAttributes();
        attributes.alpha = f11;
        fragmentActivity.getWindow().setAttributes(attributes);
    }

    public final int[] c(View view, w6 w6Var) {
        View root = w6Var.getRoot();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int b11 = com.hbg.module.libkt.base.ext.c.b();
        int c11 = com.hbg.module.libkt.base.ext.c.c();
        root.measure(0, 0);
        int measuredHeight = root.getMeasuredHeight();
        int measuredWidth = root.getMeasuredWidth();
        boolean z11 = (b11 - iArr2[1]) - height < measuredHeight;
        iArr[0] = c11 - measuredWidth;
        if (z11) {
            iArr[1] = iArr2[1] - measuredHeight;
        } else {
            iArr[1] = iArr2[1] + height;
        }
        return iArr;
    }

    public final w6 d(Context context, m mVar, boolean z11, boolean z12, boolean z13, boolean z14) {
        w6 K = w6.K(LayoutInflater.from(context));
        K.H.setVisibility(z11 ? 0 : 8);
        K.D.setVisibility(z12 ? 0 : 8);
        K.G.setVisibility(z13 ? 0 : 8);
        if (z14) {
            K.E.setVisibility(0);
            K.F.setVisibility(0);
            K.I.setVisibility(0);
        } else {
            K.E.setVisibility(8);
            K.F.setVisibility(8);
            K.I.setVisibility(8);
        }
        return K;
    }

    public final void e(FragmentActivity fragmentActivity, View view, m mVar, boolean z11, boolean z12, boolean z13, boolean z14) {
        FragmentActivity fragmentActivity2 = fragmentActivity;
        View view2 = view;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        w6 d11 = d(fragmentActivity, mVar, z11, z12, z13, z14);
        s sVar = s.f23381a;
        LinearLayout linearLayout = d11.H;
        Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
        m mVar2 = mVar;
        linearLayout.setOnClickListener(new a(linearLayout, 800, ref$ObjectRef2, mVar2));
        LinearLayout linearLayout2 = d11.D;
        linearLayout2.setOnClickListener(new b(linearLayout2, 800, ref$ObjectRef2, mVar2));
        LinearLayout linearLayout3 = d11.G;
        linearLayout3.setOnClickListener(new c(linearLayout3, 800, ref$ObjectRef2, mVar2));
        LinearLayout linearLayout4 = d11.E;
        linearLayout4.setOnClickListener(new d(linearLayout4, 800, ref$ObjectRef2, mVar2));
        LinearLayout linearLayout5 = d11.F;
        linearLayout5.setOnClickListener(new e(linearLayout5, 800, ref$ObjectRef2, mVar2));
        LinearLayout linearLayout6 = d11.I;
        linearLayout6.setOnClickListener(new f(linearLayout6, 800, ref$ObjectRef2, mVar2));
        T popupWindow = new PopupWindow(d11.getRoot(), -2, -2, true);
        ref$ObjectRef.element = popupWindow;
        PopupWindow popupWindow2 = (PopupWindow) popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        int[] c11 = c(view, d11);
        c11[0] = c11[0] - 20;
        ((PopupWindow) ref$ObjectRef.element).showAtLocation(view, BadgeDrawable.TOP_START, c11[0], c11[1]);
        b(fragmentActivity, 0.5f);
        ((PopupWindow) ref$ObjectRef.element).setOnDismissListener(new n(fragmentActivity));
    }
}
