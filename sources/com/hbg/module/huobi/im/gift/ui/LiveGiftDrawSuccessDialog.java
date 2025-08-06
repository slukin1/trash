package com.hbg.module.huobi.im.gift.ui;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.huobi.im.R$anim;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.gift.bean.JackpotBean;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import id.k;
import id.l;
import id.m;
import id.n;
import java.util.List;

public final class LiveGiftDrawSuccessDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19781b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f19782c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19783d;

    /* renamed from: e  reason: collision with root package name */
    public View f19784e;

    /* renamed from: f  reason: collision with root package name */
    public View f19785f;

    /* renamed from: g  reason: collision with root package name */
    public View f19786g;

    /* renamed from: h  reason: collision with root package name */
    public List<JackpotBean> f19787h;

    /* renamed from: i  reason: collision with root package name */
    public a f19788i;

    public interface a {
        void a();

        void onHide();
    }

    @SensorsDataInstrumented
    public static final void vh(LiveGiftDrawSuccessDialog liveGiftDrawSuccessDialog, View view) {
        liveGiftDrawSuccessDialog.dismiss();
        a aVar = liveGiftDrawSuccessDialog.f19788i;
        if (aVar != null) {
            aVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void wh(LiveGiftDrawSuccessDialog liveGiftDrawSuccessDialog, View view) {
        liveGiftDrawSuccessDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void xh(LiveGiftDrawSuccessDialog liveGiftDrawSuccessDialog) {
        a aVar = liveGiftDrawSuccessDialog.f19788i;
        if (aVar != null) {
            aVar.onHide();
        }
        super.dismiss();
    }

    public void addEvent(r rVar) {
        ImageView imageView = this.f19781b;
        if (imageView != null) {
            imageView.setOnClickListener(new m(this));
        }
        TextView textView = this.f19783d;
        if (textView != null) {
            textView.setOnClickListener(new l(this));
        }
    }

    public void afterInit() {
    }

    public void dismiss() {
        View view = this.f19786g;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = this.f19781b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.im_anim_gift_close_bottom);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R$anim.im_anim_gift_close_bottom_alpha);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(loadAnimation);
        animationSet.addAnimation(loadAnimation2);
        View view2 = this.f19784e;
        if (view2 != null) {
            view2.startAnimation(animationSet);
        }
        View view3 = this.f19784e;
        if (view3 != null) {
            view3.postDelayed(new n(this), loadAnimation.getDuration());
        }
    }

    public int getContentViewResId() {
        return R$layout.layout_live_gift_box_open;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        RecyclerView recyclerView;
        Bundle arguments = getArguments();
        View view = null;
        this.f19787h = arguments != null ? arguments.getParcelableArrayList("live_gift_jackpot_list") : null;
        this.f19781b = rVar != null ? (ImageView) rVar.b(R$id.ivLiveGiftBoxOpenedClose) : null;
        this.f19782c = rVar != null ? (RecyclerView) rVar.b(R$id.rvLiveGiftBoxSucc) : null;
        this.f19783d = rVar != null ? (TextView) rVar.b(R$id.tvLiveGiftBoxSuccBtn) : null;
        this.f19784e = rVar != null ? rVar.b(R$id.layoutGiftDialogRoot) : null;
        this.f19785f = rVar != null ? rVar.b(R$id.layoutLiveGiftBoxOpened) : null;
        if (rVar != null) {
            view = rVar.b(R$id.vLiveGiftBoxOpenedBg);
        }
        this.f19786g = view;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView2 = this.f19782c;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView3 = this.f19782c;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new VerticalDividerItemDecoration(getContext(), R$drawable.im_bg_translate_parent, i6.n.a(getContext(), 10.0f)));
        }
        if (!(this.f19787h == null || (recyclerView = this.f19782c) == null)) {
            recyclerView.setAdapter(new k(requireContext(), this.f19787h));
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R$anim.im_anim_gift_succ_open);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getActivity(), R$anim.im_anim_gift_succ_open_alpha);
        View view2 = this.f19785f;
        if (view2 != null) {
            view2.startAnimation(loadAnimation);
        }
        View view3 = this.f19786g;
        if (view3 != null) {
            view3.startAnimation(loadAnimation2);
        }
        setCancelable(false);
    }

    public boolean isTransparent() {
        return true;
    }

    public final void yh(a aVar) {
        this.f19788i = aVar;
    }
}
