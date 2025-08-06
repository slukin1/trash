package com.hbg.module.huobi.im.group.ui.adapter;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.GroupMemberListInfo;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.R$style;
import com.hbg.module.huobi.im.group.ui.GroupMemberListActivity;
import com.hbg.module.huobi.im.view.AvatarView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import java.util.List;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rd.e;

public final class i extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<GroupMemberListInfo.GroupMemberInfo> f20134a;

    /* renamed from: b  reason: collision with root package name */
    public String f20135b;

    /* renamed from: c  reason: collision with root package name */
    public final ld.f f20136c = new ld.f((ld.e) null);

    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final AvatarView f20137a;

        /* renamed from: b  reason: collision with root package name */
        public final AppCompatTextView f20138b;

        /* renamed from: c  reason: collision with root package name */
        public final AppCompatTextView f20139c;

        /* renamed from: d  reason: collision with root package name */
        public final AppCompatTextView f20140d;

        /* renamed from: e  reason: collision with root package name */
        public final AppCompatImageView f20141e;

        /* renamed from: f  reason: collision with root package name */
        public final RelativeLayout f20142f;

        /* renamed from: g  reason: collision with root package name */
        public final AppCompatImageView f20143g;

        /* renamed from: h  reason: collision with root package name */
        public final ImageView f20144h;

        public a(View view) {
            super(view);
            this.f20137a = (AvatarView) view.findViewById(R$id.iv_group_member_avatar);
            this.f20138b = (AppCompatTextView) view.findViewById(R$id.tv_group_member_account);
            this.f20139c = (AppCompatTextView) view.findViewById(R$id.tv_group_member_role);
            this.f20140d = (AppCompatTextView) view.findViewById(R$id.atv_more);
            this.f20141e = (AppCompatImageView) view.findViewById(R$id.aiv_group_silenced);
            this.f20142f = (RelativeLayout) view.findViewById(R$id.fl_more);
            this.f20143g = (AppCompatImageView) view.findViewById(R$id.aiv_more);
            this.f20144h = (ImageView) view.findViewById(R$id.iv_speaker_tag);
        }

        public final AvatarView e() {
            return this.f20137a;
        }

        public final AppCompatImageView f() {
            return this.f20143g;
        }

        public final AppCompatImageView g() {
            return this.f20141e;
        }

        public final ImageView getIvSpeakerTag() {
            return this.f20144h;
        }

        public final AppCompatTextView h() {
            return this.f20138b;
        }

        public final AppCompatTextView i() {
            return this.f20140d;
        }

        public final AppCompatTextView j() {
            return this.f20139c;
        }

        public final RelativeLayout k() {
            return this.f20142f;
        }
    }

    public static final class b implements dd.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f20145a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f20146b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f20147c;

        public b(i iVar, int i11, View view) {
            this.f20145a = iVar;
            this.f20146b = i11;
            this.f20147c = view;
        }

        public void onFailed(int i11, String str) {
            ToastUtil.toastShortMessage(this.f20147c.getContext().getString(R$string.n_im_block_user_failed));
        }

        public void onSuccess() {
            this.f20145a.h().remove(this.f20146b);
            rd.c.b().d();
            ((GroupMemberListActivity) this.f20147c.getContext()).Ih();
            this.f20145a.notifyDataSetChanged();
            ToastUtil.toastShortMessage(this.f20147c.getContext().getString(R$string.n_im_block_user_success));
        }
    }

    public static final class c implements dd.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f20148a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f20149b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f20150c;

        public c(i iVar, int i11, View view) {
            this.f20148a = iVar;
            this.f20149b = i11;
            this.f20150c = view;
        }

        public void onFailed(int i11, String str) {
            ToastUtil.toastShortMessage(this.f20150c.getContext().getString(R$string.n_im_kick_fail));
        }

        public void onSuccess() {
            this.f20148a.h().remove(this.f20149b);
            rd.c.b().d();
            ((GroupMemberListActivity) this.f20150c.getContext()).Ih();
            this.f20148a.notifyDataSetChanged();
            ToastUtil.toastShortMessage(this.f20150c.getContext().getString(R$string.n_im_kick_success));
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20151b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20152c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f20153d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f20154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20155f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f20156g;

        public d(View view, long j11, Ref$ObjectRef ref$ObjectRef, i iVar, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, int i11) {
            this.f20151b = view;
            this.f20152c = j11;
            this.f20153d = ref$ObjectRef;
            this.f20154e = iVar;
            this.f20155f = groupMemberInfo;
            this.f20156g = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20151b) > this.f20152c || (this.f20151b instanceof Checkable)) {
                sVar.e(this.f20151b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f20151b;
                GroupMemberListActivity groupMemberListActivity = (GroupMemberListActivity) this.f20153d.element;
                boolean z11 = true;
                if (groupMemberListActivity == null || !groupMemberListActivity.Gh()) {
                    z11 = false;
                }
                if (z11) {
                    this.f20154e.m(relativeLayout, this.f20155f, this.f20156g);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements rd.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20157a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f20158b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f20159c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f20160d;

        public e(GroupMemberListInfo.GroupMemberInfo groupMemberInfo, i iVar, int i11, a aVar) {
            this.f20157a = groupMemberInfo;
            this.f20158b = iVar;
            this.f20159c = i11;
            this.f20160d = aVar;
        }

        public void a(int i11, String str) {
            e.a.a(this, i11, str);
            this.f20160d.e().w(this.f20157a.getAvatar(), R$drawable.icon_community_user_header);
        }

        public void b(V2TIMUserFullInfo v2TIMUserFullInfo) {
            e.a.c(this, v2TIMUserFullInfo);
        }

        public void c(String str, String str2) {
            e.a.d(this, str, str2);
            GroupMemberListInfo.GroupMemberInfo groupMemberInfo = this.f20157a;
            if (str == null) {
                str = "";
            }
            groupMemberInfo.setAvatar(str);
            this.f20158b.notifyItemChanged(this.f20159c);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20161b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20162c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f20163d;

        public f(View view, long j11, Dialog dialog) {
            this.f20161b = view;
            this.f20162c = j11;
            this.f20163d = dialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20161b) > this.f20162c || (this.f20161b instanceof Checkable)) {
                sVar.e(this.f20161b, currentTimeMillis);
                this.f20163d.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20164b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20165c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f20166d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20167e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f20168f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f20169g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f20170h;

        public g(View view, long j11, Dialog dialog, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, i iVar, View view2, int i11) {
            this.f20164b = view;
            this.f20165c = j11;
            this.f20166d = dialog;
            this.f20167e = groupMemberInfo;
            this.f20168f = iVar;
            this.f20169g = view2;
            this.f20170h = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20164b) > this.f20165c || (this.f20164b instanceof Checkable)) {
                sVar.e(this.f20164b, currentTimeMillis);
                this.f20166d.dismiss();
                if (this.f20167e.getIsForbid() == 1) {
                    this.f20168f.n(this.f20169g, this.f20167e, this.f20170h);
                } else {
                    new nd.b(this.f20169g.getContext()).a().c(true).b(true).j(20.0f).d(this.f20169g.getContext().getString(R$string.n_im_forbin_user_hint)).e(0.75f).h(this.f20169g.getContext().getString(R$string.n_sure), new n(this.f20168f, this.f20169g, this.f20167e, this.f20170h)).g(this.f20169g.getContext().getString(R$string.n_cancel), o.f20210b).k();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class h implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20171b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20172c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f20173d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f20174e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f20175f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20176g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f20177h;

        public h(View view, long j11, Dialog dialog, View view2, i iVar, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, int i11) {
            this.f20171b = view;
            this.f20172c = j11;
            this.f20173d = dialog;
            this.f20174e = view2;
            this.f20175f = iVar;
            this.f20176g = groupMemberInfo;
            this.f20177h = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20171b) > this.f20172c || (this.f20171b instanceof Checkable)) {
                sVar.e(this.f20171b, currentTimeMillis);
                this.f20173d.dismiss();
                new nd.b(this.f20174e.getContext()).a().c(true).b(true).j(20.0f).d(this.f20174e.getContext().getString(R$string.n_im_block_user_hint)).e(0.75f).h(this.f20174e.getContext().getString(R$string.n_sure), new p(this.f20175f, this.f20174e, this.f20176g, this.f20177h)).g(this.f20174e.getContext().getString(R$string.n_cancel), q.f20215b).k();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.hbg.module.huobi.im.group.ui.adapter.i$i  reason: collision with other inner class name */
    public static final class C0144i implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20178b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20179c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f20180d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f20181e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f20182f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20183g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f20184h;

        public C0144i(View view, long j11, Dialog dialog, View view2, i iVar, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, int i11) {
            this.f20178b = view;
            this.f20179c = j11;
            this.f20180d = dialog;
            this.f20181e = view2;
            this.f20182f = iVar;
            this.f20183g = groupMemberInfo;
            this.f20184h = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20178b) > this.f20179c || (this.f20178b instanceof Checkable)) {
                sVar.e(this.f20178b, currentTimeMillis);
                this.f20180d.dismiss();
                new nd.b(this.f20181e.getContext()).a().c(true).b(true).j(20.0f).d(this.f20181e.getContext().getString(R$string.n_im_kick_user_hint)).e(0.75f).h(this.f20181e.getContext().getString(R$string.n_sure), new r(this.f20182f, this.f20183g, this.f20181e, this.f20184h)).g(this.f20181e.getContext().getString(R$string.n_cancel), s.f20224b).k();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class j implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20185b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20186c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f20187d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f20188e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f20189f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20190g;

        public j(View view, long j11, Dialog dialog, View view2, i iVar, GroupMemberListInfo.GroupMemberInfo groupMemberInfo) {
            this.f20185b = view;
            this.f20186c = j11;
            this.f20187d = dialog;
            this.f20188e = view2;
            this.f20189f = iVar;
            this.f20190g = groupMemberInfo;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20185b) > this.f20186c || (this.f20185b instanceof Checkable)) {
                sVar.e(this.f20185b, currentTimeMillis);
                this.f20187d.dismiss();
                new nd.b(this.f20188e.getContext()).a().c(true).b(true).j(20.0f).d(this.f20188e.getContext().getString(R$string.n_im_clear_msg_sure)).e(0.75f).h(this.f20188e.getContext().getString(R$string.n_sure), new t(this.f20189f, this.f20190g)).g(this.f20188e.getContext().getString(R$string.n_cancel), u.f20227b).k();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class k implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20191b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20192c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f20193d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f20194e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f20195f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f20196g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20197h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f20198i;

        public k(View view, long j11, Dialog dialog, Ref$BooleanRef ref$BooleanRef, View view2, i iVar, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, Ref$ObjectRef ref$ObjectRef) {
            this.f20191b = view;
            this.f20192c = j11;
            this.f20193d = dialog;
            this.f20194e = ref$BooleanRef;
            this.f20195f = view2;
            this.f20196g = iVar;
            this.f20197h = groupMemberInfo;
            this.f20198i = ref$ObjectRef;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20191b) > this.f20192c || (this.f20191b instanceof Checkable)) {
                sVar.e(this.f20191b, currentTimeMillis);
                TextView textView = (TextView) this.f20191b;
                this.f20193d.dismiss();
                if (this.f20194e.element) {
                    str = this.f20195f.getContext().getString(R$string.n_im_cancel_manager_sure);
                } else {
                    str = this.f20195f.getContext().getString(R$string.n_im_set_manager_sure);
                }
                new nd.b(this.f20195f.getContext()).a().c(true).b(true).j(20.0f).d(str).e(0.75f).h(this.f20195f.getContext().getString(R$string.n_sure), new v(this.f20196g, this.f20197h, this.f20198i, this.f20195f, this.f20194e)).g(this.f20195f.getContext().getString(R$string.n_cancel), w.f20238b).k();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class l implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20199b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20200c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f20201d;

        public l(View view, long j11, Dialog dialog) {
            this.f20199b = view;
            this.f20200c = j11;
            this.f20201d = dialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20199b) > this.f20200c || (this.f20199b instanceof Checkable)) {
                sVar.e(this.f20199b, currentTimeMillis);
                this.f20201d.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class m implements rd.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20202a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f20203b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f20204c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AvatarView f20205d;

        public m(GroupMemberListInfo.GroupMemberInfo groupMemberInfo, i iVar, int i11, AvatarView avatarView) {
            this.f20202a = groupMemberInfo;
            this.f20203b = iVar;
            this.f20204c = i11;
            this.f20205d = avatarView;
        }

        public void a(int i11, String str) {
            e.a.a(this, i11, str);
            this.f20205d.w(this.f20202a.getAvatar(), R$drawable.icon_community_user_header);
        }

        public void b(V2TIMUserFullInfo v2TIMUserFullInfo) {
            e.a.c(this, v2TIMUserFullInfo);
        }

        public void c(String str, String str2) {
            e.a.d(this, str, str2);
            GroupMemberListInfo.GroupMemberInfo groupMemberInfo = this.f20202a;
            if (str == null) {
                str = "";
            }
            groupMemberInfo.setAvatar(str);
            this.f20203b.notifyItemChanged(this.f20204c);
        }
    }

    public static final class n implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f20206b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f20207c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20208d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20209e;

        public n(i iVar, View view, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, int i11) {
            this.f20206b = iVar;
            this.f20207c = view;
            this.f20208d = groupMemberInfo;
            this.f20209e = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            this.f20206b.n(this.f20207c, this.f20208d, this.f20209e);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class o implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final o f20210b = new o();

        @SensorsDataInstrumented
        public final void onClick(View view) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class p implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f20211b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f20212c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20213d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20214e;

        public p(i iVar, View view, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, int i11) {
            this.f20211b = iVar;
            this.f20212c = view;
            this.f20213d = groupMemberInfo;
            this.f20214e = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            this.f20211b.g(this.f20212c, this.f20213d, this.f20214e);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class q implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final q f20215b = new q();

        @SensorsDataInstrumented
        public final void onClick(View view) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class r implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f20216b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20217c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f20218d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20219e;

        public static final class a implements dd.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ i f20220a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f20221b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20222c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ int f20223d;

            public a(i iVar, View view, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, int i11) {
                this.f20220a = iVar;
                this.f20221b = view;
                this.f20222c = groupMemberInfo;
                this.f20223d = i11;
            }

            public void onFailed(int i11, String str) {
                ToastUtil.toastShortMessage(this.f20221b.getContext().getString(R$string.n_im_kick_fail));
            }

            public void onSuccess() {
                this.f20220a.j(this.f20221b, this.f20222c, this.f20223d);
            }
        }

        public r(i iVar, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, View view, int i11) {
            this.f20216b = iVar;
            this.f20217c = groupMemberInfo;
            this.f20218d = view;
            this.f20219e = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            this.f20216b.f20136c.y(this.f20216b.i(), this.f20217c.getAccount(), new a(this.f20216b, this.f20218d, this.f20217c, this.f20219e));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class s implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final s f20224b = new s();

        @SensorsDataInstrumented
        public final void onClick(View view) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class t implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f20225b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20226c;

        public static final class a implements kd.a<Object> {
            public void onFailed(int i11, String str) {
            }

            public void onSuccess(Object obj) {
            }
        }

        public t(i iVar, GroupMemberListInfo.GroupMemberInfo groupMemberInfo) {
            this.f20225b = iVar;
            this.f20226c = groupMemberInfo;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            this.f20225b.f20136c.x(this.f20225b.i(), this.f20226c.getAccount(), new a());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class u implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final u f20227b = new u();

        @SensorsDataInstrumented
        public final void onClick(View view) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class v implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f20228b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20229c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<String> f20230d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f20231e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f20232f;

        public static final class a implements kd.a<Object> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f20233a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Ref$BooleanRef f20234b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ i f20235c;

            /* renamed from: com.hbg.module.huobi.im.group.ui.adapter.i$v$a$a  reason: collision with other inner class name */
            public static final class C0145a implements Runnable {

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ View f20236b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ i f20237c;

                public C0145a(View view, i iVar) {
                    this.f20236b = view;
                    this.f20237c = iVar;
                }

                public final void run() {
                    if (this.f20236b.getContext() instanceof GroupMemberListActivity) {
                        GroupMemberListActivity groupMemberListActivity = (GroupMemberListActivity) this.f20236b.getContext();
                        if (!groupMemberListActivity.isFinishing()) {
                            groupMemberListActivity.zh(this.f20237c.i(), 1, "", true);
                        }
                    }
                }
            }

            public a(View view, Ref$BooleanRef ref$BooleanRef, i iVar) {
                this.f20233a = view;
                this.f20234b = ref$BooleanRef;
                this.f20235c = iVar;
            }

            public void onFailed(int i11, String str) {
                View view = this.f20233a;
                if (view != null) {
                    ToastUtil.toastShortMessage(view.getContext().getString(R$string.n_im_operation_fail));
                }
            }

            public void onSuccess(Object obj) {
                String str;
                if (this.f20233a != null) {
                    new Handler(Looper.getMainLooper()).postDelayed(new C0145a(this.f20233a, this.f20235c), 500);
                    if (this.f20234b.element) {
                        str = this.f20233a.getContext().getString(R$string.n_im_cancel_manager_success);
                    } else {
                        str = this.f20233a.getContext().getString(R$string.n_im_set_manager_success);
                    }
                    ToastUtil.toastShortMessage(str);
                }
            }
        }

        public v(i iVar, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, Ref$ObjectRef<String> ref$ObjectRef, View view, Ref$BooleanRef ref$BooleanRef) {
            this.f20228b = iVar;
            this.f20229c = groupMemberInfo;
            this.f20230d = ref$ObjectRef;
            this.f20231e = view;
            this.f20232f = ref$BooleanRef;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            this.f20228b.f20136c.B(this.f20228b.i(), this.f20229c.getAccount(), (String) this.f20230d.element, new a(this.f20231e, this.f20232f, this.f20228b));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class w implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final w f20238b = new w();

        @SensorsDataInstrumented
        public final void onClick(View view) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class x implements dd.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListInfo.GroupMemberInfo f20239a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20240b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f20241c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f20242d;

        public x(GroupMemberListInfo.GroupMemberInfo groupMemberInfo, View view, i iVar, int i11) {
            this.f20239a = groupMemberInfo;
            this.f20240b = view;
            this.f20241c = iVar;
            this.f20242d = i11;
        }

        public void onFailed(int i11, String str) {
            ToastUtil.toastShortMessage(this.f20240b.getContext().getString(R$string.n_im_forbin_fail));
        }

        public void onSuccess() {
            if (this.f20239a.getIsForbid() == 1) {
                ToastUtil.toastShortMessage(this.f20240b.getContext().getString(R$string.n_im_forbin_send_canceled));
                this.f20239a.setIsForbid(0);
            } else {
                ToastUtil.toastShortMessage(this.f20240b.getContext().getString(R$string.n_im_forbin_send_success));
                this.f20239a.setIsForbid(1);
            }
            this.f20241c.notifyItemChanged(this.f20242d);
        }
    }

    public i(List<GroupMemberListInfo.GroupMemberInfo> list, String str) {
        this.f20134a = list;
        this.f20135b = str;
    }

    public final void g(View view, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, int i11) {
        this.f20136c.b(this.f20135b, groupMemberInfo.getAccount(), new b(this, i11, view));
    }

    public int getItemCount() {
        return this.f20134a.size();
    }

    public final List<GroupMemberListInfo.GroupMemberInfo> h() {
        return this.f20134a;
    }

    public final String i() {
        return this.f20135b;
    }

    public final void j(View view, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, int i11) {
        this.f20136c.y(this.f20135b, groupMemberInfo.getAccount(), new c(this, i11, view));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c9  */
    @android.annotation.SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(com.hbg.module.huobi.im.group.ui.adapter.i.a r10, int r11) {
        /*
            r9 = this;
            java.util.List<com.hbg.lib.network.hbg.core.bean.GroupMemberListInfo$GroupMemberInfo> r0 = r9.f20134a
            java.lang.Object r0 = r0.get(r11)
            r7 = r0
            com.hbg.lib.network.hbg.core.bean.GroupMemberListInfo$GroupMemberInfo r7 = (com.hbg.lib.network.hbg.core.bean.GroupMemberListInfo.GroupMemberInfo) r7
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            android.view.View r0 = r10.itemView
            android.content.Context r0 = r0.getContext()
            boolean r0 = r0 instanceof com.hbg.module.huobi.im.group.ui.GroupMemberListActivity
            if (r0 == 0) goto L_0x0022
            android.view.View r0 = r10.itemView
            android.content.Context r0 = r0.getContext()
            com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r0 = (com.hbg.module.huobi.im.group.ui.GroupMemberListActivity) r0
            r5.element = r0
        L_0x0022:
            int r0 = r7.getRole()
            r1 = 3
            r2 = 8
            r3 = 0
            if (r0 != r1) goto L_0x0034
            android.widget.ImageView r0 = r10.getIvSpeakerTag()
            r0.setVisibility(r3)
            goto L_0x003b
        L_0x0034:
            android.widget.ImageView r0 = r10.getIvSpeakerTag()
            r0.setVisibility(r2)
        L_0x003b:
            java.lang.String r0 = r7.getAvatar()
            if (r0 != 0) goto L_0x004e
            java.lang.String r0 = r7.getAccount()
            com.hbg.module.huobi.im.group.ui.adapter.i$e r4 = new com.hbg.module.huobi.im.group.ui.adapter.i$e
            r4.<init>(r7, r9, r11, r10)
            rd.f.a(r0, r4)
            goto L_0x005b
        L_0x004e:
            com.hbg.module.huobi.im.view.AvatarView r0 = r10.e()
            java.lang.String r4 = r7.getAvatar()
            int r6 = com.hbg.module.huobi.im.R$drawable.icon_community_user_header
            r0.w(r4, r6)
        L_0x005b:
            androidx.appcompat.widget.AppCompatTextView r0 = r10.h()
            java.lang.String r4 = r7.getNickname()
            r0.setText(r4)
            androidx.appcompat.widget.AppCompatTextView r0 = r10.j()
            int r4 = r7.getRole()
            r6 = 2
            if (r4 == r6) goto L_0x007a
            int r4 = r7.getRole()
            if (r4 != r1) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r4 = r2
            goto L_0x007b
        L_0x007a:
            r4 = r3
        L_0x007b:
            r0.setVisibility(r4)
            androidx.appcompat.widget.AppCompatImageView r0 = r10.g()
            int r4 = r7.getIsForbid()
            r6 = 1
            if (r4 != r6) goto L_0x009c
            T r4 = r5.element
            com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r4 = (com.hbg.module.huobi.im.group.ui.GroupMemberListActivity) r4
            if (r4 == 0) goto L_0x0097
            boolean r4 = r4.Gh()
            if (r4 != r6) goto L_0x0097
            r4 = r6
            goto L_0x0098
        L_0x0097:
            r4 = r3
        L_0x0098:
            if (r4 == 0) goto L_0x009c
            r4 = r3
            goto L_0x009d
        L_0x009c:
            r4 = r2
        L_0x009d:
            r0.setVisibility(r4)
            com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
            java.lang.String r0 = r0.f0()
            java.lang.String r4 = r7.getAccount()
            boolean r0 = kotlin.jvm.internal.x.b(r0, r4)
            if (r0 == 0) goto L_0x00c9
            androidx.appcompat.widget.AppCompatTextView r11 = r10.i()
            r11.setVisibility(r3)
            androidx.appcompat.widget.AppCompatImageView r11 = r10.f()
            r11.setVisibility(r2)
            android.widget.RelativeLayout r10 = r10.k()
            r11 = 0
            r10.setOnClickListener(r11)
            goto L_0x0109
        L_0x00c9:
            androidx.appcompat.widget.AppCompatTextView r0 = r10.i()
            r0.setVisibility(r2)
            T r0 = r5.element
            com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r0 = (com.hbg.module.huobi.im.group.ui.GroupMemberListActivity) r0
            if (r0 == 0) goto L_0x00dd
            boolean r0 = r0.Gh()
            if (r0 != r6) goto L_0x00dd
            goto L_0x00de
        L_0x00dd:
            r6 = r3
        L_0x00de:
            if (r6 == 0) goto L_0x00ee
            int r0 = r7.getRole()
            if (r0 == r1) goto L_0x00ee
            androidx.appcompat.widget.AppCompatImageView r0 = r10.f()
            r0.setVisibility(r3)
            goto L_0x00f5
        L_0x00ee:
            androidx.appcompat.widget.AppCompatImageView r0 = r10.f()
            r0.setVisibility(r2)
        L_0x00f5:
            rd.s r0 = rd.s.f23381a
            android.widget.RelativeLayout r10 = r10.k()
            r3 = 800(0x320, double:3.953E-321)
            com.hbg.module.huobi.im.group.ui.adapter.i$d r0 = new com.hbg.module.huobi.im.group.ui.adapter.i$d
            r1 = r0
            r2 = r10
            r6 = r9
            r8 = r11
            r1.<init>(r2, r3, r5, r6, r7, r8)
            r10.setOnClickListener(r0)
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.adapter.i.onBindViewHolder(com.hbg.module.huobi.im.group.ui.adapter.i$a, int):void");
    }

    /* renamed from: l */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(View.inflate(viewGroup.getContext(), R$layout.im_item_group_member, (ViewGroup) null));
    }

    public final void m(View view, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, int i11) {
        String str;
        String str2;
        if (!kotlin.jvm.internal.x.b(BaseModuleConfig.a().f0(), groupMemberInfo.getAccount())) {
            Dialog dialog = new Dialog(view.getContext(), R$style.BottomDialog);
            View inflate = View.inflate(view.getContext(), R$layout.group_member_list_dialog, (ViewGroup) null);
            AvatarView avatarView = (AvatarView) inflate.findViewById(R$id.aiv_member_icon);
            if (groupMemberInfo.getAvatar() == null) {
                rd.f.a(groupMemberInfo.getAccount(), new m(groupMemberInfo, this, i11, avatarView));
            } else {
                GroupMemberListInfo.GroupMemberInfo groupMemberInfo2 = groupMemberInfo;
                int i12 = i11;
                avatarView.w(groupMemberInfo.getAvatar(), R$drawable.icon_community_user_header);
            }
            dialog.setContentView(inflate);
            Window window = dialog.getWindow();
            window.setGravity(80);
            window.setWindowAnimations(R$style.BottomDialog_Animation);
            window.setLayout(-1, -2);
            dialog.show();
            ((AppCompatTextView) dialog.findViewById(R$id.atv_nickName)).setText(groupMemberInfo.getNickname());
            rd.s sVar = rd.s.f23381a;
            View findViewById = dialog.findViewById(R$id.atv_dialog_cancel);
            findViewById.setOnClickListener(new f(findViewById, 800, dialog));
            int i13 = R$id.tv_member_mute;
            TextView textView = (TextView) dialog.findViewById(i13);
            if (groupMemberInfo.getIsForbid() == 1) {
                str = inflate.getContext().getString(R$string.n_im_forbin_send_cancel);
            } else {
                str = inflate.getContext().getString(R$string.n_im_forbin_send);
            }
            textView.setText(str);
            View findViewById2 = dialog.findViewById(i13);
            Dialog dialog2 = dialog;
            g gVar = r1;
            int i14 = i11;
            g gVar2 = new g(findViewById2, 800, dialog2, groupMemberInfo, this, inflate, i14);
            findViewById2.setOnClickListener(gVar);
            View findViewById3 = dialog.findViewById(R$id.tv_member_block);
            View view2 = inflate;
            GroupMemberListInfo.GroupMemberInfo groupMemberInfo3 = groupMemberInfo;
            findViewById3.setOnClickListener(new h(findViewById3, 800, dialog2, view2, this, groupMemberInfo3, i14));
            View findViewById4 = dialog.findViewById(R$id.tv_member_kick);
            findViewById4.setOnClickListener(new C0144i(findViewById4, 800, dialog2, view2, this, groupMemberInfo3, i14));
            View findViewById5 = dialog.findViewById(R$id.tv_member_clear_message);
            findViewById5.setOnClickListener(new j(findViewById5, 800, dialog2, view2, this, groupMemberInfo3));
            TextView textView2 = (TextView) dialog.findViewById(R$id.tv_member_set_manager);
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            boolean z11 = groupMemberInfo.getRole() == 2 || groupMemberInfo.getRole() == 3;
            ref$BooleanRef.element = z11;
            if (z11) {
                str2 = textView2.getContext().getString(R$string.n_im_cancel_manager);
            } else {
                str2 = textView2.getContext().getString(R$string.n_im_set_manager);
            }
            textView2.setText(str2);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = ref$BooleanRef.element ? "0" : "1";
            textView2.setOnClickListener(new k(textView2, 800, dialog, ref$BooleanRef, inflate, this, groupMemberInfo, ref$ObjectRef));
            View findViewById6 = dialog.findViewById(R$id.tv_cancel);
            findViewById6.setOnClickListener(new l(findViewById6, 800, dialog));
        }
    }

    public final void n(View view, GroupMemberListInfo.GroupMemberInfo groupMemberInfo, int i11) {
        ld.f fVar = this.f20136c;
        String str = this.f20135b;
        String account = groupMemberInfo.getAccount();
        boolean z11 = true;
        if (groupMemberInfo.getIsForbid() != 1) {
            z11 = false;
        }
        fVar.f(str, account, z11, new x(groupMemberInfo, view, this, i11));
    }
}
