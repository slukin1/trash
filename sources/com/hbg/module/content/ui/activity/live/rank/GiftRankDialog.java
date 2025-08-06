package com.hbg.module.content.ui.activity.live.rank;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$font;
import com.hbg.module.content.R$string;
import com.hbg.module.content.R$style;
import com.hbg.module.content.ui.activity.live.GroupUserFragment;
import com.hbg.module.content.ui.activity.live.rank.GiftRankFragment;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import lc.i0;
import rd.s;

public final class GiftRankDialog extends DialogFragment {

    /* renamed from: e  reason: collision with root package name */
    public static final a f18674e = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public String f18675b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f18676c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f18677d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final GiftRankDialog a(FragmentManager fragmentManager, String str, String str2, int i11) {
            FragmentTransaction q11;
            Fragment fragment;
            if (fragmentManager == null) {
                return null;
            }
            try {
                q11 = fragmentManager.q();
                fragment = fragmentManager.m0("GiftRankDialog");
            } catch (NullPointerException e11) {
                e11.printStackTrace();
                fragment = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
            if (fragment != null) {
                q11.s(fragment);
            }
            GiftRankDialog giftRankDialog = new GiftRankDialog();
            Bundle bundle = new Bundle();
            bundle.putString("liveId", str);
            bundle.putString("groupId", str2);
            bundle.putInt("currentUserRole", i11);
            giftRankDialog.setArguments(bundle);
            q11.e(giftRankDialog, "GiftRankDialog");
            q11.k();
            return giftRankDialog;
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18678b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18679c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f18680d;

        public b(View view, long j11, Dialog dialog) {
            this.f18678b = view;
            this.f18679c = j11;
            this.f18680d = dialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18678b) > this.f18679c || (this.f18678b instanceof Checkable)) {
                sVar.e(this.f18678b, currentTimeMillis);
                if (this.f18680d.isShowing()) {
                    this.f18680d.dismiss();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18681b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18682c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i0 f18683d;

        public c(View view, long j11, i0 i0Var) {
            this.f18681b = view;
            this.f18682c = j11;
            this.f18683d = i0Var;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18681b) > this.f18682c || (this.f18681b instanceof Checkable)) {
                sVar.e(this.f18681b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18681b;
                this.f18683d.F.setOnClickListener(e.f18687b);
                this.f18683d.F.setVisibility(0);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18684b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18685c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i0 f18686d;

        public d(View view, long j11, i0 i0Var) {
            this.f18684b = view;
            this.f18685c = j11;
            this.f18686d = i0Var;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18684b) > this.f18685c || (this.f18684b instanceof Checkable)) {
                sVar.e(this.f18684b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18684b;
                this.f18686d.F.setVisibility(8);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final e f18687b = new e();

        @SensorsDataInstrumented
        public final void onClick(View view) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final void qh(Dialog dialog, Object obj) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View decorView;
        i0 K = i0.K(LayoutInflater.from(getActivity()));
        Dialog dialog = new Dialog(requireActivity());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.requestWindowFeature(1);
        dialog.setContentView(K.getRoot());
        Window window = dialog.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setPadding(0, 0, 0, 0);
        }
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.height = -1;
        }
        if (attributes != null) {
            attributes.width = -1;
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
        if (window != null) {
            window.setBackgroundDrawableResource(R$color.transparent);
        }
        if (window != null) {
            window.setWindowAnimations(R$style.bottom_dialog_animation);
        }
        s sVar = s.f23381a;
        View view = K.I;
        view.setOnClickListener(new b(view, 800, dialog));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TabData(getResources().getString(R$string.n_live_manage_online_users), 0, 1, 2, (r) null));
        Resources resources = getResources();
        int i11 = R$string.n_live_user_list;
        arrayList.add(new TabData(resources.getString(i11), 0, 2, 2, (r) null));
        Resources resources2 = getResources();
        int i12 = R$string.n_live_anchor_list;
        arrayList.add(new TabData(resources2.getString(i12), 0, 3, 2, (r) null));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(GroupUserFragment.f18391x.a(this.f18676c, this.f18677d));
        GiftRankFragment.a aVar = GiftRankFragment.f18688s;
        arrayList2.add(GiftRankFragment.a.b(aVar, this.f18675b, 0, 2, (Object) null));
        arrayList2.add(aVar.a(this.f18675b, 2));
        he.a aVar2 = new he.a((Fragment) this);
        aVar2.a(arrayList2);
        K.J.setAdapter(aVar2);
        int i13 = i12;
        ne.b.o(requireContext(), arrayList, K.B, K.J, 0.0f, R$color.live_color_primary_text, R$color.live_color_gray_text, Float.valueOf(18.0f), Integer.valueOf(R$font.roboto_regular), Integer.valueOf(R$font.roboto_medium), false, 1040, (Object) null);
        K.B.setPadding(0, 0, com.hbg.module.libkt.base.ext.c.a(16.0f), 0);
        ImageView imageView = K.D;
        imageView.setOnClickListener(new c(imageView, 800, K));
        K.H.setText(getResources().getString(i11));
        K.H.append(l.f34627b);
        K.H.append(getResources().getString(R$string.n_live_user_list_desc));
        K.G.setText(getResources().getString(i13));
        K.G.append(l.f34627b);
        K.G.append(getResources().getString(R$string.n_list_anchor_list_desc));
        ImageView imageView2 = K.C;
        imageView2.setOnClickListener(new d(imageView2, 800, K));
        we.c.i(this, new a(dialog));
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
        String string;
        String string2;
        super.setArguments(bundle);
        if (!(bundle == null || (string2 = bundle.getString("liveId")) == null)) {
            this.f18675b = string2;
        }
        if (!(bundle == null || (string = bundle.getString("groupId")) == null)) {
            this.f18676c = string;
        }
        if (bundle != null) {
            this.f18677d = bundle.getInt("currentUserRole");
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
