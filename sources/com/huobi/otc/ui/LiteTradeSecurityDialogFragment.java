package com.huobi.otc.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.LiteSecurityMakerInfoBean;
import com.huobi.otc.bean.OtcOrderDetailInfo;
import com.huobi.otc.bean.OtherInfoBean;
import com.huobi.view.rv.GridDividerItemDecoration;
import i6.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import nb.c;
import s9.a;
import sp.s;
import va.b;

public class LiteTradeSecurityDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f79247b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f79248c;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintLayout f79249d;

    /* renamed from: e  reason: collision with root package name */
    public EasyRecyclerView<a> f79250e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f79251f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f79252g;

    /* renamed from: h  reason: collision with root package name */
    public List<a> f79253h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public OtcOrderDetailInfo f79254i;

    /* renamed from: j  reason: collision with root package name */
    public DialogInterface.OnDismissListener f79255j = null;

    public static List<LiteSecurityMakerInfoBean> vh(Context context, OtcOrderDetailInfo otcOrderDetailInfo, boolean z11) {
        ArrayList arrayList = new ArrayList();
        if (!(otcOrderDetailInfo == null || otcOrderDetailInfo.getOrder() == null)) {
            OtherInfoBean otherInfo = otcOrderDetailInfo.getOtherInfo();
            if (otherInfo != null) {
                if (otherInfo.isSeniorAuth()) {
                    String string = context.getString(R$string.lite_security_face);
                    if (z11) {
                        string = context.getString(R$string.lite_security_face_out_side);
                    }
                    String string2 = context.getString(R$string.lite_security_certification);
                    if (z11) {
                        string2 = context.getString(R$string.lite_security_certification_out_side);
                    }
                    arrayList.add(new LiteSecurityMakerInfoBean(R$drawable.lite_security_icon_face, string, otcOrderDetailInfo.getOrder().getAreaType()));
                    arrayList.add(new LiteSecurityMakerInfoBean(R$drawable.lite_security_icon_certification, string2, otcOrderDetailInfo.getOrder().getAreaType()));
                }
                if (otherInfo.getMarginAmount() != null) {
                    String d11 = c.d(otherInfo.getMarginAmount().toPlainString(), 0);
                    if (!TextUtils.isEmpty(d11) && !"0".equals(d11)) {
                        String string3 = context.getString(R$string.lite_security_margin);
                        if (z11) {
                            string3 = context.getString(R$string.lite_security_margin_out_side);
                        }
                        arrayList.add(new LiteSecurityMakerInfoBean(R$drawable.lite_security_icon_margin, String.format(string3, new Object[]{d11, b.g(otherInfo.getMarginCoinId())}), otcOrderDetailInfo.getOrder().getAreaType()));
                    }
                }
            }
            String string4 = context.getString(R$string.n_otc_lite_security_background);
            if (z11) {
                string4 = context.getString(R$string.lite_security_background_out_side);
            }
            arrayList.add(new LiteSecurityMakerInfoBean(R$drawable.lite_security_icon_background, string4, otcOrderDetailInfo.getOrder().getAreaType()));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wh(Void voidR) {
        dismiss();
    }

    public void addEvent(r rVar) {
        dw.a.a(this.f79252g).throttleFirst(1, TimeUnit.SECONDS).subscribe(new s(this));
        this.f79248c.setOnClickListener(sp.r.f26079b);
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.fragment_lite_trade_security_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f79247b = (RelativeLayout) rVar.b(R$id.root_container);
        this.f79248c = (LinearLayout) rVar.b(R$id.content_ll);
        this.f79250e = (EasyRecyclerView) rVar.b(R$id.check_maker_card_rl);
        this.f79251f = (TextView) rVar.b(R$id.maker_info_more_tv);
        this.f79252g = (TextView) rVar.b(R$id.close_tv);
        this.f79249d = (ConstraintLayout) rVar.b(R$id.security_blue_card_cl);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f79248c.getLayoutParams();
        layoutParams.height = Math.min(PixelUtils.a(590.0f), PixelUtils.f() - PixelUtils.a(50.0f));
        this.f79248c.setLayoutParams(layoutParams);
        if (getContext() != null) {
            this.f79250e.addItemDecoration(new GridDividerItemDecoration(ContextCompat.getDrawable(getContext(), R$color.global_item_bg), PixelUtils.a(10.0f)));
            this.f79250e.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            uh();
        }
        OtcOrderDetailInfo otcOrderDetailInfo = this.f79254i;
        if (otcOrderDetailInfo != null && otcOrderDetailInfo.getOrder() != null) {
            this.f79249d.setBackgroundResource(R$drawable.bg_lite_security_top_shape);
        }
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return true;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f79255j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public final void uh() {
        this.f79253h.clear();
        this.f79253h.addAll(vh(getContext(), this.f79254i, false));
        this.f79250e.setData(this.f79253h);
    }

    public boolean useWindowBg() {
        return false;
    }
}
