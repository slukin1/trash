package com.hbg.module.huobi.im.group.ui.adapter;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.expandable.ExpandableTextView;
import com.hbg.lib.widgets.expandable.StatusType;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.R$style;
import com.hbg.module.huobi.im.group.bean.GroupNoticeItemEntity;
import com.hbg.module.huobi.im.group.bean.GroupNoticeListEntity;
import com.hbg.module.huobi.im.group.bean.GroupNoticeUserInfoEntity;
import com.hbg.module.huobi.im.group.bean.OberverData;
import com.hbg.module.huobi.im.group.ui.GroupNoticeListActivity;
import com.hbg.module.huobi.im.observer.ImObserverHelper;
import com.hbg.module.huobi.im.utils.LinkMovementMethodInterceptor;
import com.hbg.module.huobi.im.view.AvatarView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rd.s;
import rd.u;

public final class m extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public Context f20249a;

    /* renamed from: b  reason: collision with root package name */
    public GroupNoticeListEntity f20250b;

    /* renamed from: c  reason: collision with root package name */
    public SimpleDateFormat f20251c = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /* renamed from: d  reason: collision with root package name */
    public LinkMovementMethodInterceptor f20252d = new LinkMovementMethodInterceptor();

    /* renamed from: e  reason: collision with root package name */
    public boolean f20253e;

    /* renamed from: f  reason: collision with root package name */
    public ld.f f20254f = new ld.f((ld.e) null);

    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final AvatarView f20255a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f20256b;

        /* renamed from: c  reason: collision with root package name */
        public final TextView f20257c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f20258d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f20259e;

        /* renamed from: f  reason: collision with root package name */
        public final ExpandableTextView f20260f;

        public a(View view) {
            super(view);
            this.f20255a = (AvatarView) view.findViewById(R$id.iv_user_icon);
            this.f20256b = (TextView) view.findViewById(R$id.tv_name);
            this.f20257c = (TextView) view.findViewById(R$id.tv_time);
            this.f20258d = (TextView) view.findViewById(R$id.tv_top_tag);
            this.f20259e = (ImageView) view.findViewById(R$id.iv_more);
            this.f20260f = (ExpandableTextView) view.findViewById(R$id.tv_notice_content);
        }

        public final ImageView e() {
            return this.f20259e;
        }

        public final AvatarView f() {
            return this.f20255a;
        }

        public final TextView g() {
            return this.f20256b;
        }

        public final ExpandableTextView h() {
            return this.f20260f;
        }

        public final TextView i() {
            return this.f20257c;
        }

        public final TextView j() {
            return this.f20258d;
        }
    }

    public static final class b implements kd.a<Object> {
        public void onFailed(int i11, String str) {
            HuobiToastUtil.j(R$string.n_im_operation_fail);
        }

        public void onSuccess(Object obj) {
            HuobiToastUtil.j(R$string.n_im_delete_notice_success);
            ImObserverHelper.b().a(new OberverData(1, (Object) null));
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20261b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20262c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ m f20263d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f20264e;

        public c(View view, long j11, m mVar, GroupNoticeItemEntity groupNoticeItemEntity) {
            this.f20261b = view;
            this.f20262c = j11;
            this.f20263d = mVar;
            this.f20264e = groupNoticeItemEntity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20261b) > this.f20262c || (this.f20261b instanceof Checkable)) {
                sVar.e(this.f20261b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f20261b;
                this.f20263d.o(this.f20264e);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20265b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20266c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ m f20267d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f20268e;

        public d(View view, long j11, m mVar, GroupNoticeItemEntity groupNoticeItemEntity) {
            this.f20265b = view;
            this.f20266c = j11;
            this.f20267d = mVar;
            this.f20268e = groupNoticeItemEntity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20265b) > this.f20266c || (this.f20265b instanceof Checkable)) {
                sVar.e(this.f20265b, currentTimeMillis);
                ExpandableTextView expandableTextView = (ExpandableTextView) this.f20265b;
                if (this.f20267d.f() instanceof GroupNoticeListActivity) {
                    ((GroupNoticeListActivity) this.f20267d.f()).Pg(this.f20268e);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20269b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20270c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ m f20271d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f20272e;

        public e(View view, long j11, m mVar, GroupNoticeItemEntity groupNoticeItemEntity) {
            this.f20269b = view;
            this.f20270c = j11;
            this.f20271d = mVar;
            this.f20272e = groupNoticeItemEntity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20269b) > this.f20270c || (this.f20269b instanceof Checkable)) {
                sVar.e(this.f20269b, currentTimeMillis);
                if (this.f20271d.f() instanceof GroupNoticeListActivity) {
                    ((GroupNoticeListActivity) this.f20271d.f()).Pg(this.f20272e);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20273b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20274c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f20275d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f20276e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f20277f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f20278g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f20279h;

        public f(View view, long j11, Dialog dialog, GroupNoticeItemEntity groupNoticeItemEntity, m mVar, Ref$ObjectRef ref$ObjectRef, Ref$BooleanRef ref$BooleanRef) {
            this.f20273b = view;
            this.f20274c = j11;
            this.f20275d = dialog;
            this.f20276e = groupNoticeItemEntity;
            this.f20277f = mVar;
            this.f20278g = ref$ObjectRef;
            this.f20279h = ref$BooleanRef;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20273b) > this.f20274c || (this.f20273b instanceof Checkable)) {
                sVar.e(this.f20273b, currentTimeMillis);
                TextView textView = (TextView) this.f20273b;
                this.f20275d.dismiss();
                String groupId = this.f20276e.getGroupId();
                if (groupId != null) {
                    this.f20277f.g().t(groupId, String.valueOf(this.f20276e.getId()), (String) this.f20278g.element, new i(this.f20279h, this.f20276e, this.f20277f));
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20280b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20281c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f20282d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f20283e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f20284f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f20285g;

        public g(View view, long j11, Dialog dialog, View view2, m mVar, GroupNoticeItemEntity groupNoticeItemEntity) {
            this.f20280b = view;
            this.f20281c = j11;
            this.f20282d = dialog;
            this.f20283e = view2;
            this.f20284f = mVar;
            this.f20285g = groupNoticeItemEntity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20280b) > this.f20281c || (this.f20280b instanceof Checkable)) {
                sVar.e(this.f20280b, currentTimeMillis);
                TextView textView = (TextView) this.f20280b;
                this.f20282d.dismiss();
                new nd.b(this.f20283e.getContext()).a().c(true).b(true).j(20.0f).d(this.f20283e.getContext().getString(R$string.n_im_delete_notice_hint)).e(0.75f).h(this.f20283e.getContext().getString(R$string.n_sure), new j(this.f20284f, this.f20285g)).g(this.f20283e.getContext().getString(R$string.n_cancel), k.f20294b).k();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class h implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20286b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20287c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f20288d;

        public h(View view, long j11, Dialog dialog) {
            this.f20286b = view;
            this.f20287c = j11;
            this.f20288d = dialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20286b) > this.f20287c || (this.f20286b instanceof Checkable)) {
                sVar.e(this.f20286b, currentTimeMillis);
                this.f20288d.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class i implements kd.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f20289a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f20290b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m f20291c;

        public i(Ref$BooleanRef ref$BooleanRef, GroupNoticeItemEntity groupNoticeItemEntity, m mVar) {
            this.f20289a = ref$BooleanRef;
            this.f20290b = groupNoticeItemEntity;
            this.f20291c = mVar;
        }

        public void onFailed(int i11, String str) {
            HuobiToastUtil.j(R$string.n_im_operation_fail);
        }

        public void onSuccess(Object obj) {
            if (this.f20289a.element) {
                this.f20290b.setRecommend("0");
                HuobiToastUtil.j(R$string.n_im_cancel_notice_top_success);
            } else {
                this.f20290b.setRecommend("1");
                HuobiToastUtil.j(R$string.n_im_setting_notice_top_success);
            }
            if (this.f20291c.f() instanceof GroupNoticeListActivity) {
                ((GroupNoticeListActivity) this.f20291c.f()).qh();
            }
        }
    }

    public static final class j implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f20292b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f20293c;

        public j(m mVar, GroupNoticeItemEntity groupNoticeItemEntity) {
            this.f20292b = mVar;
            this.f20293c = groupNoticeItemEntity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            this.f20292b.e(this.f20293c);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class k implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final k f20294b = new k();

        @SensorsDataInstrumented
        public final void onClick(View view) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public m(Context context) {
        this.f20249a = context;
    }

    @SensorsDataInstrumented
    public static final void i(m mVar, GroupNoticeItemEntity groupNoticeItemEntity, View view) {
        Context context = mVar.f20249a;
        if (context instanceof GroupNoticeListActivity) {
            ((GroupNoticeListActivity) context).Pg(groupNoticeItemEntity);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void j(m mVar, GroupNoticeItemEntity groupNoticeItemEntity, StatusType statusType) {
        Context context = mVar.f20249a;
        if (context instanceof GroupNoticeListActivity) {
            ((GroupNoticeListActivity) context).Pg(groupNoticeItemEntity);
        }
    }

    public static final void k(m mVar, a aVar) {
        u.a(mVar.f20249a).c(aVar.h());
        aVar.h().setMovementMethod(mVar.f20252d);
    }

    public final void e(GroupNoticeItemEntity groupNoticeItemEntity) {
        String groupId = groupNoticeItemEntity.getGroupId();
        if (groupId != null) {
            this.f20254f.s(groupId, String.valueOf(groupNoticeItemEntity.getId()), new b());
        }
    }

    public final Context f() {
        return this.f20249a;
    }

    public final ld.f g() {
        return this.f20254f;
    }

    public int getItemCount() {
        List<GroupNoticeItemEntity> listData;
        GroupNoticeListEntity groupNoticeListEntity = this.f20250b;
        if (groupNoticeListEntity == null || (listData = groupNoticeListEntity.getListData()) == null) {
            return 0;
        }
        return listData.size();
    }

    /* renamed from: h */
    public void onBindViewHolder(a aVar, int i11) {
        List<GroupNoticeItemEntity> listData;
        Long createTime;
        GroupNoticeListEntity groupNoticeListEntity = this.f20250b;
        if (groupNoticeListEntity != null && (listData = groupNoticeListEntity.getListData()) != null) {
            GroupNoticeItemEntity groupNoticeItemEntity = listData.get(i11);
            GroupNoticeUserInfoEntity userInfo = groupNoticeItemEntity != null ? groupNoticeItemEntity.getUserInfo() : null;
            AvatarView.x(aVar.f(), userInfo != null ? userInfo.getAvatar() : null, 0, 2, (Object) null);
            aVar.g().setText(userInfo != null ? userInfo.getNickname() : null);
            aVar.i().setText(this.f20251c.format((groupNoticeItemEntity == null || (createTime = groupNoticeItemEntity.getCreateTime()) == null) ? null : new Date(createTime.longValue())));
            s sVar = s.f23381a;
            ImageView e11 = aVar.e();
            e11.setOnClickListener(new c(e11, 800, this, groupNoticeItemEntity));
            aVar.j().setVisibility(TextUtils.equals(groupNoticeItemEntity.getRecommend(), "1") ? 0 : 8);
            if (this.f20253e) {
                aVar.e().setVisibility(0);
            } else {
                aVar.e().setVisibility(8);
            }
            ExpandableTextView h11 = aVar.h();
            GroupNoticeItemEntity groupNoticeItemEntity2 = groupNoticeItemEntity;
            h11.setOnClickListener(new d(h11, 800, this, groupNoticeItemEntity2));
            View view = aVar.itemView;
            view.setOnClickListener(new e(view, 800, this, groupNoticeItemEntity2));
            aVar.h().J(groupNoticeItemEntity.getNotification(), (StatusType) null);
            aVar.h().setOnClickListener(new j(this, groupNoticeItemEntity));
            aVar.h().K(new k(this, groupNoticeItemEntity), false);
            aVar.h().post(new l(this, aVar));
        }
    }

    /* renamed from: l */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(View.inflate(this.f20249a, R$layout.item_group_notice_list, (ViewGroup) null));
    }

    public final void m(boolean z11) {
        this.f20253e = z11;
    }

    public final void n(GroupNoticeListEntity groupNoticeListEntity) {
        this.f20250b = groupNoticeListEntity;
        notifyDataSetChanged();
    }

    public final void o(GroupNoticeItemEntity groupNoticeItemEntity) {
        String str;
        Dialog dialog = new Dialog(this.f20249a, R$style.BottomDialog);
        View inflate = View.inflate(this.f20249a, R$layout.dialog_group_notice_item, (ViewGroup) null);
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        window.setGravity(80);
        window.setWindowAnimations(R$style.BottomDialog_Animation);
        window.setLayout(-1, -2);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R$id.tv_setting_top);
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        T t11 = "1";
        ref$BooleanRef.element = TextUtils.equals(groupNoticeItemEntity.getRecommend(), t11);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        boolean z11 = ref$BooleanRef.element;
        if (z11) {
            t11 = "0";
        }
        ref$ObjectRef.element = t11;
        if (z11) {
            str = this.f20249a.getString(R$string.n_content_live_un_pin);
        } else {
            str = this.f20249a.getString(R$string.n_im_setting_notice_top);
        }
        textView.setText(str);
        s sVar = s.f23381a;
        Dialog dialog2 = dialog;
        textView.setOnClickListener(new f(textView, 800, dialog2, groupNoticeItemEntity, this, ref$ObjectRef, ref$BooleanRef));
        TextView textView2 = (TextView) dialog.findViewById(R$id.tv_delete_notice);
        textView2.setOnClickListener(new g(textView2, 800, dialog2, inflate, this, groupNoticeItemEntity));
        View findViewById = dialog.findViewById(R$id.tv_cancel);
        findViewById.setOnClickListener(new h(findViewById, 800, dialog));
    }
}
