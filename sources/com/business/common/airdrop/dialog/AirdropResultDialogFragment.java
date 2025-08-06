package com.business.common.airdrop.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.common.R$layout;
import com.business.common.R$raw;
import com.business.common.R$string;
import com.business.common.R$style;
import com.business.common.airdrop.AirdropManager;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.AirdropDetailBean;
import com.hbg.lib.network.hbg.core.bean.AirdropDrawDetailBean;
import com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean;
import com.hbg.lib.network.hbg.core.bean.AirdropResultBean;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.hbg.module.libkt.utils.m;
import com.hbg.module.libkt.utils.r;
import com.huobi.view.roundview.RoundTextView;
import com.huochat.community.base.CommunityConstants;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import i4.c;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class AirdropResultDialogFragment extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public final AirdropDetailBean f64286b;

    /* renamed from: c  reason: collision with root package name */
    public final AirdropResultBean f64287c;

    /* renamed from: d  reason: collision with root package name */
    public final int f64288d;

    /* renamed from: e  reason: collision with root package name */
    public final String f64289e;

    /* renamed from: f  reason: collision with root package name */
    public c f64290f;

    /* renamed from: g  reason: collision with root package name */
    public HbgBaseShareProvider f64291g;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f64292b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f64293c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AirdropResultDialogFragment f64294d;

        public a(View view, long j11, AirdropResultDialogFragment airdropResultDialogFragment) {
            this.f64292b = view;
            this.f64293c = j11;
            this.f64294d = airdropResultDialogFragment;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f64292b) > this.f64293c || (this.f64292b instanceof Checkable)) {
                rVar.e(this.f64292b, currentTimeMillis);
                RoundTextView roundTextView = (RoundTextView) this.f64292b;
                HashMap hashMap = new HashMap();
                int uh2 = this.f64294d.f64288d;
                if (uh2 == 4) {
                    hashMap.put("location", "app_community_dynamic_details_sideways");
                    hashMap.put(CommunityConstants.TOPIC_ID, this.f64294d.f64289e);
                } else if (uh2 == 20) {
                    hashMap.put("location", "app_community_homepage_find_sideways");
                } else if (uh2 == 24) {
                    hashMap.put("location", "app_community_square_sideways");
                } else if (uh2 == 28) {
                    hashMap.put("location", "app_community_k_line_comment_sideways");
                    hashMap.put(CommunityConstants.TOPIC_ID, this.f64294d.f64289e);
                }
                hashMap.put("button_name", "share_button");
                vf.a.a("app_community_award_open_pop_up_click", hashMap);
                FragmentActivity activity = this.f64294d.getActivity();
                if (activity != null) {
                    n1 unused = i.d(v.a(activity), (CoroutineContext) null, (CoroutineStart) null, new AirdropResultDialogFragment$onCreateView$1$4$1$1(activity.getLayoutInflater().inflate(R$layout.view_share_airdrop, (ViewGroup) null, false), this.f64294d, activity, (kotlin.coroutines.c<? super AirdropResultDialogFragment$onCreateView$1$4$1$1>) null), 3, (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f64295b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f64296c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AirdropResultDialogFragment f64297d;

        public b(View view, long j11, AirdropResultDialogFragment airdropResultDialogFragment) {
            this.f64295b = view;
            this.f64296c = j11;
            this.f64297d = airdropResultDialogFragment;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f64295b) > this.f64296c || (this.f64295b instanceof Checkable)) {
                rVar.e(this.f64295b, currentTimeMillis);
                RoundTextView roundTextView = (RoundTextView) this.f64295b;
                HashMap hashMap = new HashMap();
                int uh2 = this.f64297d.f64288d;
                if (uh2 == 4) {
                    hashMap.put("location", "app_community_dynamic_details_sideways");
                    hashMap.put(CommunityConstants.TOPIC_ID, this.f64297d.f64289e);
                } else if (uh2 == 20) {
                    hashMap.put("location", "app_community_homepage_find_sideways");
                } else if (uh2 == 24) {
                    hashMap.put("location", "app_community_square_sideways");
                } else if (uh2 == 28) {
                    hashMap.put("location", "app_community_k_line_comment_sideways");
                    hashMap.put(CommunityConstants.TOPIC_ID, this.f64297d.f64289e);
                }
                hashMap.put("button_name", "continue_to_lead_button");
                vf.a.a("app_community_award_open_pop_up_click", hashMap);
                BaseModuleConfig.a().k0(this.f64297d.f64287c.getNextUrl());
                this.f64297d.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public AirdropResultDialogFragment(AirdropDetailBean airdropDetailBean, AirdropResultBean airdropResultBean, int i11, String str) {
        this.f64286b = airdropDetailBean;
        this.f64287c = airdropResultBean;
        this.f64288d = i11;
        this.f64289e = str;
    }

    public static final void wh(Throwable th2) {
    }

    @SensorsDataInstrumented
    public static final void xh(AirdropResultDialogFragment airdropResultDialogFragment, View view) {
        airdropResultDialogFragment.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
        setStyle(1, R$style.CenterDialogFragmentStyle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        String showImageUrl;
        this.f64290f = c.K(layoutInflater);
        this.f64291g = (HbgBaseShareProvider) b2.a.d().a("/provider/share/h5").navigation();
        c cVar = this.f64290f;
        c cVar2 = null;
        if (cVar == null) {
            cVar = null;
        }
        List<AirdropDrawDetailBean> drawDetailList = this.f64287c.getDrawDetailList();
        if (drawDetailList == null) {
            drawDetailList = CollectionsKt__CollectionsKt.k();
        }
        if (drawDetailList.size() > 3) {
            RecyclerView recyclerView = cVar.G;
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams.height = m.a(196);
            recyclerView.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cVar.K.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, m.a(16), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
        } else {
            ViewGroup.LayoutParams layoutParams3 = cVar.K.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, m.a(8), marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
            }
        }
        h4.b bVar = new h4.b(this.f64288d, this.f64289e, drawDetailList);
        AppCompatTextView appCompatTextView = cVar.L;
        AirdropMaterialBean material = this.f64286b.getMaterial();
        String str3 = "";
        if (material == null || (str = material.getTitle()) == null) {
            str = str3;
        }
        appCompatTextView.setText(str);
        AppCompatTextView appCompatTextView2 = cVar.J;
        AirdropMaterialBean material2 = this.f64286b.getMaterial();
        if (material2 == null || (str2 = material2.getSubtitle()) == null) {
            str2 = str3;
        }
        appCompatTextView2.setText(str2);
        AirdropMaterialBean material3 = this.f64286b.getMaterial();
        if (!(material3 == null || (showImageUrl = material3.getShowImageUrl()) == null)) {
            str3 = showImageUrl;
        }
        cVar.D.setFailureListener(g.f64304a);
        if ((str3.length() == 0) || !StringsKt__StringsJVMKt.v(str3, ".json", false, 2, (Object) null)) {
            cVar.D.setAnimation(R$raw.airdrop_animation_result);
        } else {
            AirdropManager.f64272a.n(cVar.D, str3);
        }
        cVar.G.setLayoutManager(new LinearLayoutManager(getContext()));
        cVar.G.setAdapter(bVar);
        cVar.K.setText(new SpannableStringBuilder(requireContext().getString(R$string.n_airdrop_reward_tips)));
        cVar.E.setOnClickListener(new f(this));
        AirdropMaterialBean material4 = this.f64286b.getMaterial();
        if (!com.hbg.module.libkt.base.ext.b.x(material4 != null ? material4.getShareUrl() : null)) {
            r rVar = r.f24939a;
            RoundTextView roundTextView = cVar.I;
            roundTextView.setOnClickListener(new a(roundTextView, 800, this));
        }
        if (com.hbg.module.libkt.base.ext.b.x(this.f64287c.getNextUrl())) {
            cVar.H.setVisibility(8);
        } else {
            r rVar2 = r.f24939a;
            RoundTextView roundTextView2 = cVar.H;
            roundTextView2.setOnClickListener(new b(roundTextView2, 800, this));
        }
        c cVar3 = this.f64290f;
        if (cVar3 != null) {
            cVar2 = cVar3;
        }
        return cVar2.getRoot();
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

    public void onStart() {
        Window window;
        Window window2;
        Window window3;
        Window window4;
        super.onStart();
        Dialog dialog = getDialog();
        if (!(dialog == null || (window4 = dialog.getWindow()) == null)) {
            window4.setGravity(17);
        }
        Dialog dialog2 = getDialog();
        if (!(dialog2 == null || (window3 = dialog2.getWindow()) == null)) {
            window3.setLayout(-1, -2);
        }
        Dialog dialog3 = getDialog();
        if (!(dialog3 == null || (window2 = dialog3.getWindow()) == null)) {
            window2.addFlags(2);
        }
        Dialog dialog4 = getDialog();
        if (!(dialog4 == null || (window = dialog4.getWindow()) == null)) {
            window.setDimAmount(0.8f);
        }
        HashMap hashMap = new HashMap();
        int i11 = this.f64288d;
        if (i11 == 4) {
            hashMap.put("location", "app_community_dynamic_details_sideways");
            hashMap.put(CommunityConstants.TOPIC_ID, this.f64289e);
        } else if (i11 == 20) {
            hashMap.put("location", "app_community_homepage_find_sideways");
        } else if (i11 == 24) {
            hashMap.put("location", "app_community_square_sideways");
        } else if (i11 == 28) {
            hashMap.put("location", "app_community_k_line_comment_sideways");
            hashMap.put(CommunityConstants.TOPIC_ID, this.f64289e);
        }
        if (!com.hbg.module.libkt.base.ext.b.x(this.f64287c.getNextUrl())) {
            hashMap.put("button_show", "continue_to_lead");
        }
        vf.a.a("app_community_award_open_pop_up_show", hashMap);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final HbgBaseShareProvider vh() {
        return this.f64291g;
    }

    public final void yh(FragmentManager fragmentManager) {
        show(fragmentManager, "AirdropResultDialogFragment");
    }
}
