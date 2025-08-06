package com.hbg.module.content.custom;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$style;
import com.hbg.module.content.adapter.v;
import com.hbg.module.content.custom.LiveRecommendReasonDialog;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import kotlin.jvm.internal.r;
import ky.j;
import lc.m0;
import rd.s;

public final class LiveTraderDialog extends DialogFragment {

    /* renamed from: h  reason: collision with root package name */
    public static final a f18061h = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public FragmentManager f18062b;

    /* renamed from: c  reason: collision with root package name */
    public m0 f18063c;

    /* renamed from: d  reason: collision with root package name */
    public String f18064d;

    /* renamed from: e  reason: collision with root package name */
    public int f18065e = 1;

    /* renamed from: f  reason: collision with root package name */
    public v f18066f;

    /* renamed from: g  reason: collision with root package name */
    public String f18067g;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final LiveTraderDialog a(FragmentManager fragmentManager, String str) {
            Fragment fragment;
            if (fragmentManager == null) {
                return null;
            }
            try {
                FragmentTransaction q11 = fragmentManager.q();
                try {
                    fragment = fragmentManager.m0("LiveTraderDialog");
                } catch (NullPointerException e11) {
                    e11.printStackTrace();
                    fragment = null;
                }
                if (fragment != null) {
                    q11.s(fragment);
                }
                LiveTraderDialog liveTraderDialog = new LiveTraderDialog();
                liveTraderDialog.Bh(fragmentManager);
                Bundle bundle = new Bundle();
                bundle.putString("liveId", str);
                liveTraderDialog.setArguments(bundle);
                q11.e(liveTraderDialog, "LiveTraderDialog");
                q11.k();
                return liveTraderDialog;
            } catch (Exception e12) {
                e12.printStackTrace();
                return null;
            }
        }
    }

    public static final class b implements ny.d {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveTraderDialog f18068b;

        public b(LiveTraderDialog liveTraderDialog) {
            this.f18068b = liveTraderDialog;
        }

        public void P8(j jVar) {
            this.f18068b.xh();
        }

        public void bf(j jVar) {
            m0 uh2 = this.f18068b.uh();
            SmartRefreshLayout smartRefreshLayout = uh2 != null ? uh2.G : null;
            if (smartRefreshLayout != null) {
                smartRefreshLayout.g(true);
            }
            this.f18068b.Ch(1);
            this.f18068b.xh();
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveTraderDialog f18069b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Handler f18070c;

        public c(LiveTraderDialog liveTraderDialog, Handler handler) {
            this.f18069b = liveTraderDialog;
            this.f18070c = handler;
        }

        public void afterTextChanged(Editable editable) {
            EditText editText;
            boolean z11 = false;
            if (editable != null && StringsKt__StringsKt.R0(editable, " ", false, 2, (Object) null)) {
                z11 = true;
            }
            if (z11) {
                m0 uh2 = this.f18069b.uh();
                if (uh2 != null && (editText = uh2.B) != null) {
                    editText.setText(editable.toString().substring(1));
                    return;
                }
                return;
            }
            this.f18070c.removeMessages(1);
            this.f18070c.sendEmptyMessageDelayed(1, 500);
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18071b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18072c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveTraderDialog f18073d;

        public d(View view, long j11, LiveTraderDialog liveTraderDialog) {
            this.f18071b = view;
            this.f18072c = j11;
            this.f18073d = liveTraderDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18071b) > this.f18072c || (this.f18071b instanceof Checkable)) {
                sVar.e(this.f18071b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18071b;
                this.f18073d.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18074b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18075c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveTraderDialog f18076d;

        public e(View view, long j11, LiveTraderDialog liveTraderDialog) {
            this.f18074b = view;
            this.f18075c = j11;
            this.f18076d = liveTraderDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18074b) > this.f18075c || (this.f18074b instanceof Checkable)) {
                sVar.e(this.f18074b, currentTimeMillis);
                TextView textView = (TextView) this.f18074b;
                this.f18076d.dismiss();
                LiveRecommendReasonDialog.a aVar = LiveRecommendReasonDialog.f18051d;
                FragmentManager vh2 = this.f18076d.vh();
                String th2 = this.f18076d.th();
                v sh2 = this.f18076d.sh();
                aVar.a(vh2, th2, sh2 != null ? sh2.l() : null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r4 = r4.B;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean Ah(com.hbg.module.content.custom.LiveTraderDialog r3, android.os.Message r4) {
        /*
            lc.m0 r4 = r3.f18063c
            r0 = 0
            if (r4 == 0) goto L_0x000e
            android.widget.EditText r4 = r4.B
            if (r4 == 0) goto L_0x000e
            android.text.Editable r4 = r4.getText()
            goto L_0x000f
        L_0x000e:
            r4 = r0
        L_0x000f:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r1 = r3.f18067g
            boolean r1 = kotlin.jvm.internal.x.b(r4, r1)
            r2 = 0
            if (r1 == 0) goto L_0x001d
            return r2
        L_0x001d:
            lc.m0 r1 = r3.f18063c
            if (r1 == 0) goto L_0x0023
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r1.G
        L_0x0023:
            r1 = 1
            if (r0 != 0) goto L_0x0027
            goto L_0x002a
        L_0x0027:
            r0.g(r1)
        L_0x002a:
            r3.f18067g = r4
            r3.f18065e = r1
            r3.xh()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.custom.LiveTraderDialog.Ah(com.hbg.module.content.custom.LiveTraderDialog, android.os.Message):boolean");
    }

    @SensorsDataInstrumented
    public static final void zh(LiveTraderDialog liveTraderDialog, View view) {
        liveTraderDialog.xh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Bh(FragmentManager fragmentManager) {
        this.f18062b = fragmentManager;
    }

    public final void Ch(int i11) {
        this.f18065e = i11;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        TextView textView;
        EditText editText;
        LoadingLayout loadingLayout;
        LoadingLayout loadingLayout2;
        ImageView imageView;
        View decorView;
        this.f18063c = m0.K(LayoutInflater.from(getActivity()));
        Dialog dialog = new Dialog(requireActivity());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.requestWindowFeature(1);
        m0 m0Var = this.f18063c;
        WindowManager.LayoutParams layoutParams = null;
        dialog.setContentView(m0Var != null ? m0Var.getRoot() : null);
        Window window = dialog.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setPadding(0, 0, 0, 0);
        }
        if (window != null) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        if (layoutParams != null) {
            layoutParams.width = -1;
        }
        if (window != null) {
            window.setAttributes(layoutParams);
        }
        if (window != null) {
            window.setBackgroundDrawableResource(R$color.transparent);
        }
        if (window != null) {
            window.setWindowAnimations(R$style.bottom_dialog_animation);
        }
        m0 m0Var2 = this.f18063c;
        if (!(m0Var2 == null || (imageView = m0Var2.C) == null)) {
            s sVar = s.f23381a;
            imageView.setOnClickListener(new d(imageView, 800, this));
        }
        m0 m0Var3 = this.f18063c;
        if (!(m0Var3 == null || (loadingLayout2 = m0Var3.D) == null)) {
            loadingLayout2.p();
        }
        m0 m0Var4 = this.f18063c;
        if (!(m0Var4 == null || (loadingLayout = m0Var4.D) == null)) {
            loadingLayout.setOnRetryClickListener(new j(this));
        }
        Handler handler = new Handler(new i(this));
        m0 m0Var5 = this.f18063c;
        if (!(m0Var5 == null || (editText = m0Var5.B) == null)) {
            editText.addTextChangedListener(new c(this, handler));
        }
        m0 m0Var6 = this.f18063c;
        if (!(m0Var6 == null || (textView = m0Var6.H) == null)) {
            s sVar2 = s.f23381a;
            textView.setOnClickListener(new e(textView, 800, this));
        }
        yh();
        return dialog;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        this.f18064d = bundle != null ? bundle.getString("liveId") : null;
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final v sh() {
        return this.f18066f;
    }

    public final String th() {
        return this.f18064d;
    }

    public final m0 uh() {
        return this.f18063c;
    }

    public final FragmentManager vh() {
        return this.f18062b;
    }

    public final int wh() {
        return this.f18065e;
    }

    public final void xh() {
        v vVar = this.f18066f;
        if (vVar != null) {
            vVar.p(!com.hbg.module.libkt.base.ext.b.x(this.f18067g));
        }
        RequestExtKt.d(v7.b.a().requestCopyTradingRank(this.f18067g, 1, this.f18065e, 20), new LiveTraderDialog$getTraderRank$1(this), new LiveTraderDialog$getTraderRank$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public final void yh() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        m0 m0Var = this.f18063c;
        if (!(m0Var == null || (smartRefreshLayout3 = m0Var.G) == null)) {
            smartRefreshLayout3.j0(new SmartRefreshHeader(requireActivity()));
        }
        m0 m0Var2 = this.f18063c;
        if (!(m0Var2 == null || (smartRefreshLayout2 = m0Var2.G) == null)) {
            smartRefreshLayout2.h0(new SmartRefreshFooter(requireActivity()));
        }
        m0 m0Var3 = this.f18063c;
        if (!(m0Var3 == null || (smartRefreshLayout = m0Var3.G) == null)) {
            smartRefreshLayout.e0(new b(this));
        }
        this.f18066f = new v(requireActivity());
        m0 m0Var4 = this.f18063c;
        RecyclerView recyclerView3 = null;
        RecyclerView recyclerView4 = m0Var4 != null ? m0Var4.F : null;
        if (recyclerView4 != null) {
            recyclerView4.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(getActivity()));
        }
        m0 m0Var5 = this.f18063c;
        if (!(m0Var5 == null || (recyclerView2 = m0Var5.F) == null)) {
            recyclerView2.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(requireActivity(), R$color.transparent), com.hbg.module.libkt.base.ext.c.d(Float.valueOf(16.0f)), false));
        }
        v vVar = this.f18066f;
        if (vVar != null) {
            vVar.setHasStableIds(true);
        }
        m0 m0Var6 = this.f18063c;
        if (!(m0Var6 == null || (recyclerView = m0Var6.F) == null)) {
            com.hbg.module.libkt.base.ext.b.f(recyclerView);
        }
        m0 m0Var7 = this.f18063c;
        if (m0Var7 != null) {
            recyclerView3 = m0Var7.F;
        }
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.f18066f);
        }
        xh();
    }
}
