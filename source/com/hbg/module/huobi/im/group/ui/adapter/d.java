package com.hbg.module.huobi.im.group.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.bumptech.glide.request.e;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.group.bean.ImGroupChatItemBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine;
import dd.b;
import java.util.List;

public final class d extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public Context f20116a;

    /* renamed from: b  reason: collision with root package name */
    public List<ImGroupChatItemBean> f20117b;

    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final ConstraintLayout f20118a;

        /* renamed from: b  reason: collision with root package name */
        public final ImageView f20119b;

        /* renamed from: c  reason: collision with root package name */
        public final TextView f20120c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f20121d;

        /* renamed from: e  reason: collision with root package name */
        public final TextView f20122e;

        public a(View view) {
            super(view);
            this.f20118a = (ConstraintLayout) view.findViewById(R$id.clItem);
            this.f20119b = (ImageView) view.findViewById(R$id.iv_group_chat_avatar);
            this.f20120c = (TextView) view.findViewById(R$id.tv_group_chat_title);
            this.f20121d = (TextView) view.findViewById(R$id.tv_group_last_msg);
            this.f20122e = (TextView) view.findViewById(R$id.tv_group_chat_goto);
        }

        public final ConstraintLayout e() {
            return this.f20118a;
        }

        public final ImageView f() {
            return this.f20119b;
        }

        public final TextView g() {
            return this.f20121d;
        }

        public final TextView h() {
            return this.f20120c;
        }
    }

    public d(Context context, List<ImGroupChatItemBean> list) {
        this.f20116a = context;
        this.f20117b = list;
    }

    @SensorsDataInstrumented
    public static final void d(d dVar, ImGroupChatItemBean imGroupChatItemBean, View view) {
        if (BaseModuleConfig.a().m0((Activity) dVar.f20116a)) {
            if ((imGroupChatItemBean.getType() == 2 || imGroupChatItemBean.getType() == 3) && imGroupChatItemBean.getHasJion() == 0) {
                Postcard a11 = b2.a.d().a("/webView/index");
                BaseModuleConfig.a a12 = BaseModuleConfig.a();
                a11.withString("url", a12.k("live/community/privateGroup?groupId=" + imGroupChatItemBean.getGroupId())).navigation(dVar.f20116a);
            } else {
                b.k(b.f22740a, dVar.f20116a, imGroupChatItemBean.getGroupId(), imGroupChatItemBean.getTitle(), (String) null, 8, (Object) null);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void onBindViewHolder(a aVar, int i11) {
        ImGroupChatItemBean imGroupChatItemBean = this.f20117b.get(i11);
        GlideEngine.loadCornerImageWithoutPlaceHolder(aVar.f(), imGroupChatItemBean.getAvatar(), (e) null, (float) ScreenUtil.dip2px(16.0f));
        aVar.h().setText(imGroupChatItemBean.getTitle());
        aVar.g().setText(this.f20116a.getString(R$string.n_im_current_users) + "  " + imGroupChatItemBean.getUserCount());
        aVar.e().setOnClickListener(new c(this, imGroupChatItemBean));
    }

    /* renamed from: e */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        View inflate = View.inflate(this.f20116a, R$layout.im_item_group_chat, (ViewGroup) null);
        inflate.setLayoutParams(new ConstraintLayout.LayoutParams(-1, ScreenUtil.dip2px(62.0f)));
        return new a(inflate);
    }

    public int getItemCount() {
        return this.f20117b.size();
    }
}
