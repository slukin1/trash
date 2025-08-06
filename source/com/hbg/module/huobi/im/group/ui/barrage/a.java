package com.hbg.module.huobi.im.group.ui.barrage;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.lib.network.hbg.core.bean.TranslateBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.R$style;
import com.hbg.module.huobi.im.group.bean.HBTUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.bean.UserStatusEntity;
import com.hbg.module.huobi.im.group.ui.active.RewardsAnim;
import com.hbg.module.huobi.im.group.ui.barrage.TUIBarrageButton;
import com.hbg.module.huobi.im.utils.ClickableForegroundColorSpan;
import com.hbg.module.huobi.im.utils.ClickableMovementMethod;
import com.hbg.module.huobi.im.utils.MessageType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageModel;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ChatPopMenuAction;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.tencent.qcloud.tuikit.tuichat.component.popmenu.ChatPopMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import md.t;
import md.u;
import md.v;
import md.w;
import md.x;
import md.y;

public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final List<TUIBarrageMsgEntity> f20352a;

    /* renamed from: b  reason: collision with root package name */
    public final p f20353b;

    /* renamed from: c  reason: collision with root package name */
    public TUIBarrageButton.f f20354c;

    /* renamed from: d  reason: collision with root package name */
    public final int f20355d = 1;

    /* renamed from: e  reason: collision with root package name */
    public final Context f20356e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20357f = false;

    /* renamed from: g  reason: collision with root package name */
    public LiveDetailBean f20358g;

    /* renamed from: h  reason: collision with root package name */
    public final ld.f f20359h = new ld.f((ld.e) null);

    /* renamed from: i  reason: collision with root package name */
    public final Handler f20360i;

    /* renamed from: com.hbg.module.huobi.im.group.ui.barrage.a$a  reason: collision with other inner class name */
    public class C0147a implements View.OnClickListener {
        public C0147a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUIBarrageModel f20362b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f20363c;

        /* renamed from: com.hbg.module.huobi.im.group.ui.barrage.a$b$a  reason: collision with other inner class name */
        public class C0148a implements kd.a<Object> {
            public C0148a() {
            }

            public void onFailed(int i11, String str) {
                ToastUtil.toastShortMessage(a.this.f20356e.getString(R$string.n_im_operation_fail));
            }

            public void onSuccess(Object obj) {
                String str;
                if ((a.this.f20356e instanceof Activity) && !((Activity) a.this.f20356e).isFinishing()) {
                    LiveSpeaker liveSpeaker = new LiveSpeaker();
                    b bVar = b.this;
                    TUIBarrageModel tUIBarrageModel = bVar.f20362b;
                    liveSpeaker.avatar = tUIBarrageModel.faceUrl;
                    liveSpeaker.nickname = tUIBarrageModel.nickName;
                    liveSpeaker.showId = tUIBarrageModel.sender;
                    a.this.w(liveSpeaker, !bVar.f20363c);
                    b bVar2 = b.this;
                    if (bVar2.f20363c) {
                        str = a.this.f20356e.getString(R$string.n_im_cancel_manager_success);
                    } else {
                        str = a.this.f20356e.getString(R$string.n_im_set_manager_success);
                    }
                    ToastUtil.toastShortMessage(str);
                    a.this.notifyDataSetChanged();
                }
            }
        }

        public b(TUIBarrageModel tUIBarrageModel, boolean z11) {
            this.f20362b = tUIBarrageModel;
            this.f20363c = z11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ld.f m11 = a.this.f20359h;
            TUIBarrageModel tUIBarrageModel = this.f20362b;
            m11.B(tUIBarrageModel.groupId, tUIBarrageModel.sender, this.f20363c ? "0" : "1", new C0148a());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f20366b;

        public c(Dialog dialog) {
            this.f20366b = dialog;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f20366b.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements dd.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f20368a;

        public d(boolean z11) {
            this.f20368a = z11;
        }

        public void onFailed(int i11, String str) {
            ToastUtil.toastShortMessage(a.this.f20356e.getString(R$string.n_im_forbin_fail));
        }

        public void onSuccess() {
            if (this.f20368a) {
                ToastUtil.toastShortMessage(a.this.f20356e.getString(R$string.n_im_forbin_send_canceled));
            } else {
                ToastUtil.toastShortMessage(a.this.f20356e.getString(R$string.n_im_forbin_send_success));
            }
        }
    }

    public class e implements kd.a<TranslateBean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HBTUIBarrageMsgEntity f20370a;

        public e(HBTUIBarrageMsgEntity hBTUIBarrageMsgEntity) {
            this.f20370a = hBTUIBarrageMsgEntity;
        }

        /* renamed from: a */
        public void onSuccess(TranslateBean translateBean) {
            if ((a.this.f20356e instanceof Activity) && !((Activity) a.this.f20356e).isFinishing()) {
                this.f20370a.translateText = translateBean.getContent();
                a.this.notifyDataSetChanged();
            }
        }

        public void onFailed(int i11, String str) {
        }
    }

    public class f implements kd.a<PersonalCenterInfo> {
        public f() {
        }

        /* renamed from: a */
        public void onSuccess(PersonalCenterInfo personalCenterInfo) {
            b2.a.d().a("/content/PersonalCenter").withString("uidUnique", personalCenterInfo.getUidUnique()).navigation();
        }

        public void onFailed(int i11, String str) {
            if (i11 != 2011) {
                HuobiToastUtil.g(R$string.n_service_error);
            }
        }
    }

    public class g implements kd.a<UserStatusEntity> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUIBarrageMsgEntity f20373a;

        public g(TUIBarrageMsgEntity tUIBarrageMsgEntity) {
            this.f20373a = tUIBarrageMsgEntity;
        }

        /* renamed from: a */
        public void onSuccess(UserStatusEntity userStatusEntity) {
            if (userStatusEntity != null) {
                a aVar = a.this;
                aVar.R(aVar.B(), this.f20373a, userStatusEntity);
            }
        }

        public void onFailed(int i11, String str) {
            IMLog.i("TUIBarrageMsgListAdapter", "onFailed: code:" + i11 + " message:" + str);
        }
    }

    public class h implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f20375b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f20376c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f20377d;

        public h(Dialog dialog, String str, String str2) {
            this.f20375b = dialog;
            this.f20376c = str;
            this.f20377d = str2;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f20375b.dismiss();
            if (a.this.f20354c != null) {
                a.this.f20354c.a(this.f20376c, this.f20377d);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class i implements kd.a<TranslateBean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HBTUIBarrageMsgEntity f20379a;

        public i(HBTUIBarrageMsgEntity hBTUIBarrageMsgEntity) {
            this.f20379a = hBTUIBarrageMsgEntity;
        }

        /* renamed from: a */
        public void onSuccess(TranslateBean translateBean) {
            if ((a.this.f20356e instanceof Activity) && !((Activity) a.this.f20356e).isFinishing()) {
                this.f20379a.translateText = translateBean.getContent();
                a.this.notifyDataSetChanged();
            }
        }

        public void onFailed(int i11, String str) {
        }
    }

    public class j implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f20381b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UserStatusEntity f20382c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TUIBarrageModel f20383d;

        /* renamed from: com.hbg.module.huobi.im.group.ui.barrage.a$j$a  reason: collision with other inner class name */
        public class C0149a implements View.OnClickListener {
            public C0149a() {
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public class b implements View.OnClickListener {
            public b() {
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                j jVar = j.this;
                a aVar = a.this;
                TUIBarrageModel tUIBarrageModel = jVar.f20383d;
                aVar.A(tUIBarrageModel.groupId, tUIBarrageModel.sender, false);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public j(Dialog dialog, UserStatusEntity userStatusEntity, TUIBarrageModel tUIBarrageModel) {
            this.f20381b = dialog;
            this.f20382c = userStatusEntity;
            this.f20383d = tUIBarrageModel;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f20381b.dismiss();
            if (this.f20382c.getForbid().intValue() == 1) {
                a aVar = a.this;
                TUIBarrageModel tUIBarrageModel = this.f20383d;
                aVar.A(tUIBarrageModel.groupId, tUIBarrageModel.sender, true);
            } else {
                new nd.b(a.this.B()).a().c(true).b(true).j(20.0f).d(a.this.f20356e.getString(R$string.n_im_forbin_user_hint)).e(0.75f).h(a.this.f20356e.getString(R$string.n_sure), new b()).g(a.this.f20356e.getString(R$string.n_cancel), new C0149a()).k();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class k implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f20387b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TUIBarrageModel f20388c;

        /* renamed from: com.hbg.module.huobi.im.group.ui.barrage.a$k$a  reason: collision with other inner class name */
        public class C0150a implements View.OnClickListener {
            public C0150a() {
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public class b implements View.OnClickListener {

            /* renamed from: com.hbg.module.huobi.im.group.ui.barrage.a$k$b$a  reason: collision with other inner class name */
            public class C0151a implements dd.a {
                public C0151a() {
                }

                public void onFailed(int i11, String str) {
                    ToastUtil.toastShortMessage(a.this.f20356e.getString(R$string.n_im_block_user_failed));
                }

                public void onSuccess() {
                    ToastUtil.toastShortMessage(a.this.f20356e.getString(R$string.n_im_block_user_success));
                }
            }

            public b() {
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                ld.f m11 = a.this.f20359h;
                TUIBarrageModel tUIBarrageModel = k.this.f20388c;
                m11.b(tUIBarrageModel.groupId, tUIBarrageModel.sender, new C0151a());
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public k(Dialog dialog, TUIBarrageModel tUIBarrageModel) {
            this.f20387b = dialog;
            this.f20388c = tUIBarrageModel;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f20387b.dismiss();
            new nd.b(a.this.B()).a().c(true).b(true).j(20.0f).d(a.this.f20356e.getString(R$string.n_im_block_user_hint)).e(0.75f).h(a.this.f20356e.getString(R$string.n_sure), new b()).g(a.this.f20356e.getString(R$string.n_cancel), new C0150a()).k();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class l implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f20393b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TUIBarrageModel f20394c;

        /* renamed from: com.hbg.module.huobi.im.group.ui.barrage.a$l$a  reason: collision with other inner class name */
        public class C0152a implements View.OnClickListener {
            public C0152a() {
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public class b implements View.OnClickListener {

            /* renamed from: com.hbg.module.huobi.im.group.ui.barrage.a$l$b$a  reason: collision with other inner class name */
            public class C0153a implements dd.a {
                public C0153a() {
                }

                public void onFailed(int i11, String str) {
                    ToastUtil.toastShortMessage(a.this.f20356e.getString(R$string.n_im_kick_fail));
                }

                public void onSuccess() {
                    ToastUtil.toastShortMessage(a.this.f20356e.getString(R$string.n_im_kick_success));
                }
            }

            public b() {
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                ld.f m11 = a.this.f20359h;
                TUIBarrageModel tUIBarrageModel = l.this.f20394c;
                m11.y(tUIBarrageModel.groupId, tUIBarrageModel.sender, new C0153a());
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public l(Dialog dialog, TUIBarrageModel tUIBarrageModel) {
            this.f20393b = dialog;
            this.f20394c = tUIBarrageModel;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f20393b.dismiss();
            new nd.b(a.this.B()).a().c(true).b(true).j(20.0f).d(a.this.f20356e.getString(R$string.n_im_kick_user_hint)).e(0.75f).h(a.this.f20356e.getString(R$string.n_sure), new b()).g(a.this.f20356e.getString(R$string.n_cancel), new C0152a()).k();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class n implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUIBarrageModel f20400b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TUIBarrageMsgEntity f20401c;

        /* renamed from: com.hbg.module.huobi.im.group.ui.barrage.a$n$a  reason: collision with other inner class name */
        public class C0154a implements kd.a<Object> {
            public C0154a() {
            }

            public void onFailed(int i11, String str) {
            }

            public void onSuccess(Object obj) {
                TUIBarrageModel tUIBarrageModel;
                String str;
                if ((a.this.f20356e instanceof Activity) && !((Activity) a.this.f20356e).isFinishing()) {
                    Iterator it2 = a.this.f20352a.iterator();
                    while (it2.hasNext()) {
                        TUIBarrageMsgEntity tUIBarrageMsgEntity = (TUIBarrageMsgEntity) it2.next();
                        if (!(tUIBarrageMsgEntity == null || (tUIBarrageModel = tUIBarrageMsgEntity.model) == null || (str = tUIBarrageModel.sender) == null || !TextUtils.equals(str, n.this.f20401c.model.sender))) {
                            it2.remove();
                        }
                    }
                    a.this.notifyDataSetChanged();
                }
            }
        }

        public n(TUIBarrageModel tUIBarrageModel, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
            this.f20400b = tUIBarrageModel;
            this.f20401c = tUIBarrageMsgEntity;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ld.f m11 = a.this.f20359h;
            TUIBarrageModel tUIBarrageModel = this.f20400b;
            m11.x(tUIBarrageModel.groupId, tUIBarrageModel.sender, new C0154a());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class o extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f20404a;

        public o(View view) {
            super(view);
            this.f20404a = (TextView) view.findViewById(R$id.tv_new_user_msg);
        }

        public void a(TUIBarrageMsgEntity tUIBarrageMsgEntity, p pVar, int i11) {
            if (tUIBarrageMsgEntity != null) {
                String str = TextUtils.isEmpty(tUIBarrageMsgEntity.userName) ? tUIBarrageMsgEntity.userId : tUIBarrageMsgEntity.userName;
                if (!TextUtils.isEmpty(str)) {
                    String string = a.this.f20356e.getString(R$string.n_live_new_user_into_group_hint);
                    String format = String.format(string, new Object[]{" " + str + " "});
                    ClickableForegroundColorSpan clickableForegroundColorSpan = new ClickableForegroundColorSpan(a.this.f20356e.getResources().getColor(R$color.color_12B298));
                    int indexOf = format.indexOf(str);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
                    if (indexOf != -1) {
                        spannableStringBuilder.setSpan(clickableForegroundColorSpan, indexOf, str.length() + indexOf, 33);
                    }
                    this.f20404a.setText(spannableStringBuilder);
                }
            }
        }
    }

    public interface p {
        void onRetry();
    }

    public class q extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f20406a;

        public q(View view) {
            super(view);
            this.f20406a = (TextView) view.findViewById(R$id.tv_msg_content);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i(int i11) {
            a.this.notifyItemChanged(i11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(TUIBarrageMsgEntity tUIBarrageMsgEntity, int i11, Bitmap bitmap) {
            if (bitmap != null) {
                tUIBarrageMsgEntity.avatarBitmap = bitmap;
                if (a.this.f20360i != null) {
                    a.this.f20360i.post(new md.l(this, i11));
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(String str, TUIBarrageMsgEntity tUIBarrageMsgEntity, View view) {
            IMLog.e("TUIBarrageMsgListAdapter", "管理员图标被点击了");
            if (!str.equals(V2TIMManager.getInstance().getLoginUser())) {
                a aVar = a.this;
                aVar.D(aVar.B(), tUIBarrageMsgEntity);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(int i11) {
            a.this.notifyItemChanged(i11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(TUIBarrageMsgEntity tUIBarrageMsgEntity, int i11, Bitmap bitmap) {
            if (bitmap != null) {
                tUIBarrageMsgEntity.giftBitmap = bitmap;
                if (a.this.f20360i != null) {
                    a.this.f20360i.post(new md.m(this, i11));
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(String str, TUIBarrageMsgEntity tUIBarrageMsgEntity, View view) {
            IMLog.e("TUIBarrageMsgListAdapter", "头像被点击了");
            if (!str.equals(V2TIMManager.getInstance().getLoginUser())) {
                a aVar = a.this;
                aVar.D(aVar.B(), tUIBarrageMsgEntity);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void o(String str, TUIBarrageMsgEntity tUIBarrageMsgEntity, View view) {
            IMLog.e("TUIBarrageMsgListAdapter", "昵称被点击了");
            if (!str.equals(V2TIMManager.getInstance().getLoginUser())) {
                a aVar = a.this;
                aVar.D(aVar.B(), tUIBarrageMsgEntity);
            }
        }

        public void h(TUIBarrageMsgEntity tUIBarrageMsgEntity, p pVar, int i11) {
            RewardsAnim rewardsAnim;
            rd.b bVar;
            TUIBarrageMsgEntity tUIBarrageMsgEntity2 = tUIBarrageMsgEntity;
            int i12 = i11;
            if (tUIBarrageMsgEntity2 != null && (rewardsAnim = tUIBarrageMsgEntity2.anim) != null) {
                String nickname = com.hbg.module.libkt.base.ext.b.x(rewardsAnim.getNickname()) ? "User" : rewardsAnim.getNickname();
                String str = "avatar" + " " + "tag";
                String valueOf = rewardsAnim.isSelfReward() ? "1" : String.valueOf(rewardsAnim.getGiftNum());
                String str2 = str + " " + nickname + " " + String.format(this.f20406a.getContext().getResources().getString(R$string.n_content_live_send_gift_with_count), new Object[]{valueOf, rewardsAnim.getGiftName()}) + "  ";
                int color = this.f20406a.getContext().getResources().getColor(R$color.color_FE8731);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                ClickableForegroundColorSpan clickableForegroundColorSpan = new ClickableForegroundColorSpan(color);
                spannableStringBuilder.setSpan(clickableForegroundColorSpan, str.length(), nickname.length() + str.length() + 1, 33);
                String str3 = !com.hbg.module.libkt.base.ext.b.w(rewardsAnim.getAccounts()) ? rewardsAnim.getAccounts().get(0) : "";
                if (tUIBarrageMsgEntity2.avatarBitmap == null) {
                    rd.f.c(a.this.f20356e, rewardsAnim.getAvatar(), R$drawable.icon_community_user_header, new md.o(this, tUIBarrageMsgEntity2, i12));
                    bVar = new rd.b(a.this.f20356e, md.a.f22950a.f(a.this.f20356e));
                } else {
                    bVar = new rd.b(a.this.f20356e, tUIBarrageMsgEntity2.avatarBitmap);
                }
                rd.b bVar2 = bVar;
                if (a.this.z(str3)) {
                    bVar2.c(ContextCompat.getDrawable(a.this.f20356e, R$drawable.icon_speaker_tag));
                } else {
                    bVar2.c((Drawable) null);
                }
                try {
                    if (a.this.y(str3)) {
                        spannableStringBuilder.setSpan(bVar2, 0, 6, 33);
                        rd.b bVar3 = new rd.b(a.this.f20356e, BitmapFactory.decodeResource(a.this.f20356e.getResources(), R$drawable.icon_group_manager_tag));
                        spannableStringBuilder.setSpan(bVar3, 7, str.length(), 33);
                        bVar3.b(new md.p(this, str3, tUIBarrageMsgEntity2));
                    } else {
                        spannableStringBuilder.setSpan(bVar2, 0, str.length(), 33);
                    }
                } catch (Exception e11) {
                    IMLog.e("TUIBarrageMsgListAdapter", e11.getMessage());
                }
                if (tUIBarrageMsgEntity2.giftBitmap == null) {
                    rd.f.b(a.this.f20356e, rewardsAnim.getPngUrl(), 0, 20.0f, 20.0f, new md.n(this, tUIBarrageMsgEntity2, i12));
                } else {
                    spannableStringBuilder.setSpan(new rd.b(a.this.f20356e, tUIBarrageMsgEntity2.giftBitmap), str2.length() - 1, str2.length(), 33);
                }
                bVar2.b(new md.r(this, str3, tUIBarrageMsgEntity2));
                clickableForegroundColorSpan.setOnClickListener(new md.q(this, str3, tUIBarrageMsgEntity2));
                this.f20406a.setText(spannableStringBuilder);
                this.f20406a.setMovementMethod(new ClickableMovementMethod());
            }
        }
    }

    public class r extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f20408a;

        public r(View view) {
            super(view);
            this.f20408a = (TextView) view.findViewById(R$id.tv_msg_content);
        }

        public void a(TUIBarrageMsgEntity tUIBarrageMsgEntity, p pVar, int i11) {
            if (tUIBarrageMsgEntity != null) {
                String string = a.this.f20356e.getString(R$string.n_redpacket_snatch);
                this.f20408a.setText(String.format(string, new Object[]{tUIBarrageMsgEntity.snatch.nickName, tUIBarrageMsgEntity.snatch.amount + " " + tUIBarrageMsgEntity.snatch.currency}));
            }
        }
    }

    public class s extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f20410a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f20411b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f20412c;

        /* renamed from: d  reason: collision with root package name */
        public View f20413d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f20414e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f20415f;

        public s(View view) {
            super(view);
            initView(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void i(p pVar, View view) {
            a.this.f20352a.remove(1);
            a.this.notifyDataSetChanged();
            pVar.onRetry();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(int i11) {
            a.this.notifyItemChanged(i11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(TUIBarrageMsgEntity tUIBarrageMsgEntity, int i11, Bitmap bitmap) {
            if (bitmap != null) {
                tUIBarrageMsgEntity.avatarBitmap = bitmap;
                if (a.this.f20360i != null) {
                    a.this.f20360i.post(new u(this, i11));
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(String str, TUIBarrageMsgEntity tUIBarrageMsgEntity, View view) {
            IMLog.e("TUIBarrageMsgListAdapter", "管理员图标被点击了");
            if (!str.equals(V2TIMManager.getInstance().getLoginUser())) {
                a aVar = a.this;
                aVar.D(aVar.B(), tUIBarrageMsgEntity);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(String str, TUIBarrageMsgEntity tUIBarrageMsgEntity, View view) {
            IMLog.e("TUIBarrageMsgListAdapter", "头像被点击了");
            if (!str.equals(V2TIMManager.getInstance().getLoginUser())) {
                a aVar = a.this;
                aVar.D(aVar.B(), tUIBarrageMsgEntity);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(String str, TUIBarrageMsgEntity tUIBarrageMsgEntity, View view) {
            IMLog.e("TUIBarrageMsgListAdapter", "昵称被点击了");
            if (!str.equals(V2TIMManager.getInstance().getLoginUser())) {
                a aVar = a.this;
                aVar.D(aVar.B(), tUIBarrageMsgEntity);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean o(TUIBarrageMsgEntity tUIBarrageMsgEntity, int i11, View view) {
            if (((this.f20410a.getTag() instanceof Boolean) && ((Boolean) this.f20410a.getTag()).booleanValue()) || !BaseModuleConfig.a().a()) {
                return false;
            }
            a.this.C(tUIBarrageMsgEntity, i11, this.f20410a);
            return false;
        }

        public void h(TUIBarrageMsgEntity tUIBarrageMsgEntity, p pVar, int i11) {
            String str;
            int i12;
            int i13;
            rd.b bVar;
            String str2;
            if (tUIBarrageMsgEntity.isRetry) {
                this.f20414e.setVisibility(8);
                this.f20415f.setVisibility(0);
                this.f20414e.setOnClickListener(new md.s(this, pVar));
                return;
            }
            this.f20414e.setVisibility(0);
            this.f20415f.setVisibility(8);
            String str3 = TextUtils.isEmpty(tUIBarrageMsgEntity.userName) ? tUIBarrageMsgEntity.userId : tUIBarrageMsgEntity.userName;
            String str4 = "avatar" + " " + "tag";
            if (i11 == 0) {
                str = str3;
            } else {
                str = str4 + " " + str3 + "：" + tUIBarrageMsgEntity.content;
            }
            String str5 = "";
            if (TextUtils.isEmpty(str3)) {
                str3 = str5;
            }
            if (TextUtils.isEmpty(tUIBarrageMsgEntity.content)) {
                tUIBarrageMsgEntity.content = str5;
            }
            int color = this.f20410a.getContext().getResources().getColor(R$color.color_12B298);
            if (i11 == 0) {
                i12 = 0;
            } else {
                i12 = str4.length();
            }
            if (i11 == 0) {
                i13 = str3.length();
            } else {
                i13 = str3.length() + 1 + str4.length() + 1;
            }
            if (i11 != 0 && tUIBarrageMsgEntity.type == MessageType.MESSAGE_GIFT_WINNING.getType()) {
                str = str4 + " " + tUIBarrageMsgEntity.content;
                color = this.f20410a.getContext().getResources().getColor(R$color.tuibarrage_color_msg_7);
                i13 = str4.length() + 1 + tUIBarrageMsgEntity.content.length();
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            ClickableForegroundColorSpan clickableForegroundColorSpan = new ClickableForegroundColorSpan(color);
            spannableStringBuilder.setSpan(clickableForegroundColorSpan, i12, i13, 33);
            TUIBarrageModel tUIBarrageModel = tUIBarrageMsgEntity.model;
            if (!(tUIBarrageModel == null || (str2 = tUIBarrageModel.sender) == null)) {
                str5 = str2;
            }
            if (i11 != 0) {
                if (tUIBarrageMsgEntity.avatarBitmap == null) {
                    rd.f.c(a.this.f20356e, tUIBarrageMsgEntity.model.faceUrl, R$drawable.icon_community_user_header, new v(this, tUIBarrageMsgEntity, i11));
                    bVar = new rd.b(a.this.f20356e, md.a.f22950a.f(a.this.f20356e));
                    if (a.this.z(str5)) {
                        bVar.c(ContextCompat.getDrawable(a.this.f20356e, R$drawable.icon_speaker_tag));
                    } else {
                        bVar.c((Drawable) null);
                    }
                } else {
                    bVar = new rd.b(a.this.f20356e, tUIBarrageMsgEntity.avatarBitmap);
                    if (a.this.z(str5)) {
                        bVar.c(ContextCompat.getDrawable(a.this.f20356e, R$drawable.icon_speaker_tag));
                    } else {
                        bVar.c((Drawable) null);
                    }
                }
                try {
                    if (a.this.y(str5)) {
                        spannableStringBuilder.setSpan(bVar, 0, 6, 33);
                        rd.b bVar2 = new rd.b(a.this.f20356e, BitmapFactory.decodeResource(a.this.f20356e.getResources(), R$drawable.icon_group_manager_tag));
                        spannableStringBuilder.setSpan(bVar2, 7, str4.length(), 33);
                        bVar2.b(new x(this, str5, tUIBarrageMsgEntity));
                    } else {
                        spannableStringBuilder.setSpan(bVar, 0, str4.length(), 33);
                    }
                } catch (Exception e11) {
                    IMLog.e("TUIBarrageMsgListAdapter", e11.getMessage());
                }
                bVar.b(new w(this, str5, tUIBarrageMsgEntity));
                clickableForegroundColorSpan.setOnClickListener(new y(this, str5, tUIBarrageMsgEntity));
            } else {
                clickableForegroundColorSpan.setOnClickListener((rd.o) null);
            }
            if (i11 != 0 && tUIBarrageMsgEntity.type == MessageType.MESSAGE_GIFT_WINNING.getType()) {
                clickableForegroundColorSpan.setOnClickListener((rd.o) null);
            }
            this.f20410a.setText(spannableStringBuilder);
            this.f20410a.setMovementMethod(new ClickableMovementMethod());
            if (tUIBarrageMsgEntity instanceof HBTUIBarrageMsgEntity) {
                HBTUIBarrageMsgEntity hBTUIBarrageMsgEntity = (HBTUIBarrageMsgEntity) tUIBarrageMsgEntity;
                if (!TextUtils.isEmpty(hBTUIBarrageMsgEntity.translateText)) {
                    this.f20413d.setVisibility(0);
                    this.f20412c.setVisibility(0);
                    this.f20412c.setText(hBTUIBarrageMsgEntity.translateText);
                } else {
                    this.f20413d.setVisibility(8);
                    this.f20412c.setVisibility(8);
                }
            } else {
                this.f20413d.setVisibility(8);
                this.f20412c.setVisibility(8);
            }
            this.f20410a.setBackgroundResource(R$drawable.tuibarrage_bg_msg_item);
            this.f20410a.setOnLongClickListener(new t(this, tUIBarrageMsgEntity, i11));
        }

        public final void initView(View view) {
            this.f20410a = (TextView) view.findViewById(R$id.tv_msg_content);
            this.f20411b = (TextView) view.findViewById(R$id.btn_msg_agree);
            this.f20412c = (TextView) view.findViewById(R$id.tv_translate);
            this.f20413d = view.findViewById(R$id.v_line);
            this.f20414e = (LinearLayout) view.findViewById(R$id.llMsg);
            this.f20415f = (LinearLayout) view.findViewById(R$id.llRetry);
        }
    }

    public a(Context context, List<TUIBarrageMsgEntity> list, p pVar) {
        this.f20356e = context;
        this.f20352a = list;
        this.f20353b = pVar;
        this.f20360i = new Handler(context.getMainLooper());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        TUIBarrageModel tUIBarrageModel;
        String str;
        if (this.f20357f) {
            ld.f fVar = this.f20359h;
            String str2 = tUIBarrageMsgEntity.model.groupId;
            fVar.w(str2, "" + tUIBarrageMsgEntity.model.msgSeq);
            return;
        }
        Iterator<TUIBarrageMsgEntity> it2 = this.f20352a.iterator();
        while (it2.hasNext()) {
            TUIBarrageMsgEntity next = it2.next();
            if (next != null && (tUIBarrageModel = next.model) != null && (str = tUIBarrageModel.msgId) != null && TextUtils.equals(str, tUIBarrageMsgEntity.model.msgId)) {
                it2.remove();
                notifyDataSetChanged();
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        x(tUIBarrageMsgEntity.content);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        ld.f fVar = this.f20359h;
        String str = tUIBarrageMsgEntity.model.groupId;
        fVar.w(str, "" + tUIBarrageMsgEntity.model.msgSeq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(TUIBarrageMsgEntity tUIBarrageMsgEntity, HBTUIBarrageMsgEntity hBTUIBarrageMsgEntity) {
        ld.f fVar = this.f20359h;
        if (fVar != null) {
            fVar.o(tUIBarrageMsgEntity.content, new e(hBTUIBarrageMsgEntity));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void J(Dialog dialog, TUIBarrageMsgEntity tUIBarrageMsgEntity, View view) {
        dialog.dismiss();
        x(tUIBarrageMsgEntity.content);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void K(Dialog dialog, TUIBarrageModel tUIBarrageModel, TUIBarrageMsgEntity tUIBarrageMsgEntity, View view) {
        TUIBarrageModel tUIBarrageModel2;
        String str;
        dialog.dismiss();
        if (!this.f20357f) {
            Iterator<TUIBarrageMsgEntity> it2 = this.f20352a.iterator();
            while (true) {
                if (it2.hasNext()) {
                    TUIBarrageMsgEntity next = it2.next();
                    if (next != null && (tUIBarrageModel2 = next.model) != null && (str = tUIBarrageModel2.msgId) != null && TextUtils.equals(str, tUIBarrageMsgEntity.model.msgId)) {
                        it2.remove();
                        notifyDataSetChanged();
                        break;
                    }
                } else {
                    break;
                }
            }
        } else {
            ld.f fVar = this.f20359h;
            String str2 = tUIBarrageModel.groupId;
            fVar.w(str2, "" + tUIBarrageModel.msgSeq);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void L(Dialog dialog, TUIBarrageMsgEntity tUIBarrageMsgEntity, View view) {
        ld.f fVar;
        dialog.dismiss();
        if (tUIBarrageMsgEntity instanceof HBTUIBarrageMsgEntity) {
            HBTUIBarrageMsgEntity hBTUIBarrageMsgEntity = (HBTUIBarrageMsgEntity) tUIBarrageMsgEntity;
            if (TextUtils.isEmpty(hBTUIBarrageMsgEntity.translateText) && (fVar = this.f20359h) != null) {
                fVar.o(tUIBarrageMsgEntity.content, new i(hBTUIBarrageMsgEntity));
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void M(Dialog dialog, TUIBarrageModel tUIBarrageModel, TUIBarrageMsgEntity tUIBarrageMsgEntity, View view) {
        dialog.dismiss();
        new nd.b(B()).a().c(true).b(true).j(20.0f).d(this.f20356e.getString(R$string.n_im_clear_msg_sure)).e(0.75f).h(this.f20356e.getString(R$string.n_sure), new n(tUIBarrageModel, tUIBarrageMsgEntity)).g(this.f20356e.getString(R$string.n_cancel), new m()).k();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void N(Dialog dialog, boolean z11, TUIBarrageModel tUIBarrageModel, View view) {
        String str;
        dialog.dismiss();
        nd.b j11 = new nd.b(B()).a().c(true).b(true).j(20.0f);
        if (z11) {
            str = this.f20356e.getString(R$string.n_im_cancel_manager_sure);
        } else {
            str = this.f20356e.getString(R$string.n_im_set_manager_sure);
        }
        j11.d(str).e(0.75f).h(this.f20356e.getString(R$string.n_sure), new b(tUIBarrageModel, z11)).g(this.f20356e.getString(R$string.n_cancel), new C0147a()).k();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void A(String str, String str2, boolean z11) {
        this.f20359h.f(str, str2, z11, new d(z11));
    }

    public Context B() {
        Context e11 = md.a.f22950a.e();
        return e11 == null ? this.f20356e : e11;
    }

    public final void C(TUIBarrageMsgEntity tUIBarrageMsgEntity, int i11, View view) {
        TUIBarrageModel tUIBarrageModel;
        String str;
        String str2;
        if (tUIBarrageMsgEntity != null && (tUIBarrageModel = tUIBarrageMsgEntity.model) != null && (str = tUIBarrageModel.sender) != null && (str2 = tUIBarrageModel.groupId) != null) {
            if (!this.f20357f) {
                S(i11, view);
            } else if (tUIBarrageModel.isSelf) {
                S(i11, view);
            } else {
                this.f20359h.p(str2, str, "1", new g(tUIBarrageMsgEntity));
            }
        }
    }

    public final void D(Context context, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        TUIBarrageModel tUIBarrageModel;
        String str;
        if (tUIBarrageMsgEntity != null && (tUIBarrageModel = tUIBarrageMsgEntity.model) != null && (str = tUIBarrageModel.sender) != null && (context instanceof FragmentActivity)) {
            this.f20359h.n(str, new f());
        }
    }

    public ArrayList<ChatPopMenuAction> E(TUIBarrageMsgEntity tUIBarrageMsgEntity, int i11) {
        ArrayList<ChatPopMenuAction> arrayList = new ArrayList<>();
        if (tUIBarrageMsgEntity.model.status != 3) {
            ChatPopMenuAction chatPopMenuAction = new ChatPopMenuAction();
            chatPopMenuAction.setActionName(this.f20356e.getString(R$string.n_login_delete));
            chatPopMenuAction.setActionIcon(R$drawable.im_icon_pop_delete_live);
            int i12 = R$color.white;
            chatPopMenuAction.textColor = i12;
            chatPopMenuAction.setActionClickListener(new md.h(this, tUIBarrageMsgEntity));
            arrayList.add(chatPopMenuAction);
            ChatPopMenuAction chatPopMenuAction2 = new ChatPopMenuAction();
            chatPopMenuAction2.setActionName(this.f20356e.getString(R$string.n_im_msg_copy));
            chatPopMenuAction2.setActionIcon(R$drawable.im_icon_pop_copy_live);
            chatPopMenuAction2.textColor = i12;
            chatPopMenuAction2.setActionClickListener(new md.j(this, tUIBarrageMsgEntity));
            arrayList.add(chatPopMenuAction2);
            if (tUIBarrageMsgEntity.model.isSelf && (System.currentTimeMillis() / 1000) - tUIBarrageMsgEntity.model.timestamp <= ((long) dd.b.f22740a.c())) {
                ChatPopMenuAction chatPopMenuAction3 = new ChatPopMenuAction();
                chatPopMenuAction3.setActionName(this.f20356e.getString(R$string.n_im_msg_back));
                chatPopMenuAction3.setActionIcon(R$drawable.im_icon_pop_revoke_live);
                chatPopMenuAction3.textColor = i12;
                chatPopMenuAction3.setActionClickListener(new md.i(this, tUIBarrageMsgEntity));
                arrayList.add(chatPopMenuAction3);
            }
            if (!tUIBarrageMsgEntity.model.isSelf && (tUIBarrageMsgEntity instanceof HBTUIBarrageMsgEntity)) {
                HBTUIBarrageMsgEntity hBTUIBarrageMsgEntity = (HBTUIBarrageMsgEntity) tUIBarrageMsgEntity;
                if (TextUtils.isEmpty(hBTUIBarrageMsgEntity.translateText)) {
                    ChatPopMenuAction chatPopMenuAction4 = new ChatPopMenuAction();
                    chatPopMenuAction4.setActionName(this.f20356e.getString(R$string.n_content_translate));
                    chatPopMenuAction4.setActionIcon(R$drawable.im_icon_text_translate_live);
                    chatPopMenuAction4.textColor = i12;
                    chatPopMenuAction4.setActionClickListener(new md.k(this, tUIBarrageMsgEntity, hBTUIBarrageMsgEntity));
                    arrayList.add(chatPopMenuAction4);
                }
            }
        }
        return arrayList;
    }

    public void O(TUIBarrageButton.f fVar) {
        this.f20354c = fVar;
    }

    public void P(boolean z11) {
        this.f20357f = z11;
        notifyDataSetChanged();
    }

    public void Q(LiveDetailBean liveDetailBean) {
        this.f20358g = liveDetailBean;
        notifyDataSetChanged();
    }

    public final void R(Context context, TUIBarrageMsgEntity tUIBarrageMsgEntity, UserStatusEntity userStatusEntity) {
        TUIBarrageModel tUIBarrageModel;
        String str;
        String str2;
        if (tUIBarrageMsgEntity != null && (tUIBarrageModel = tUIBarrageMsgEntity.model) != null && tUIBarrageModel.sender != null && tUIBarrageModel.nickName != null && tUIBarrageModel.groupId != null) {
            Dialog dialog = new Dialog(context, R$style.BottomDialog);
            dialog.setContentView(View.inflate(context, R$layout.live_member_restrict_dialog, (ViewGroup) null));
            Window window = dialog.getWindow();
            window.setGravity(80);
            window.setWindowAnimations(R$style.BottomDialog_Animation);
            window.setLayout(-1, -2);
            dialog.show();
            TextView textView = (TextView) dialog.findViewById(R$id.tv_at_user);
            String str3 = tUIBarrageModel.sender;
            String str4 = tUIBarrageModel.nickName;
            textView.setText(TIMMentionEditText.TIM_MENTION_TAG + str3);
            textView.setOnClickListener(new h(dialog, str3, str4));
            ((TextView) dialog.findViewById(R$id.tv_copy)).setOnClickListener(new md.d(this, dialog, tUIBarrageMsgEntity));
            if (userStatusEntity.getSpeaker().intValue() == 0) {
                ((TextView) dialog.findViewById(R$id.tv_delete)).setOnClickListener(new md.e(this, dialog, tUIBarrageModel, tUIBarrageMsgEntity));
            } else {
                ((TextView) dialog.findViewById(R$id.tv_delete)).setVisibility(8);
                dialog.findViewById(R$id.v_delete).setVisibility(8);
            }
            TextView textView2 = (TextView) dialog.findViewById(R$id.tv_translate);
            textView2.setText(this.f20356e.getString(R$string.n_content_translate));
            textView2.setOnClickListener(new md.c(this, dialog, tUIBarrageMsgEntity));
            if (userStatusEntity.getSpeaker().intValue() == 0) {
                TextView textView3 = (TextView) dialog.findViewById(R$id.tv_member_mute);
                boolean z11 = true;
                if (userStatusEntity.getForbid().intValue() == 1) {
                    str = this.f20356e.getString(R$string.n_im_forbin_send_cancel);
                } else {
                    str = this.f20356e.getString(R$string.n_im_forbin_send);
                }
                textView3.setText(str);
                textView3.setOnClickListener(new j(dialog, userStatusEntity, tUIBarrageModel));
                dialog.findViewById(R$id.tv_member_block).setOnClickListener(new k(dialog, tUIBarrageModel));
                dialog.findViewById(R$id.tv_member_kick).setOnClickListener(new l(dialog, tUIBarrageModel));
                ((TextView) dialog.findViewById(R$id.tv_member_clear_message)).setOnClickListener(new md.f(this, dialog, tUIBarrageModel, tUIBarrageMsgEntity));
                TextView textView4 = (TextView) dialog.findViewById(R$id.tv_member_set_manager);
                if (userStatusEntity.getManager().intValue() != 1) {
                    z11 = false;
                }
                if (z11) {
                    str2 = this.f20356e.getString(R$string.n_im_cancel_manager);
                } else {
                    str2 = this.f20356e.getString(R$string.n_im_set_manager);
                }
                textView4.setText(str2);
                textView4.setOnClickListener(new md.g(this, dialog, z11, tUIBarrageModel));
            } else {
                dialog.findViewById(R$id.tv_member_mute).setVisibility(8);
                dialog.findViewById(R$id.v_member_mute).setVisibility(8);
                dialog.findViewById(R$id.tv_member_block).setVisibility(8);
                dialog.findViewById(R$id.v_member_block).setVisibility(8);
                dialog.findViewById(R$id.tv_member_kick).setVisibility(8);
                dialog.findViewById(R$id.v_member_kick).setVisibility(8);
                dialog.findViewById(R$id.tv_member_clear_message).setVisibility(8);
                dialog.findViewById(R$id.v_member_clear_message).setVisibility(8);
                dialog.findViewById(R$id.tv_member_set_manager).setVisibility(8);
            }
            dialog.findViewById(R$id.tv_cancel).setOnClickListener(new c(dialog));
        }
    }

    public void S(int i11, View view) {
        try {
            IMLog.e("TUIBarrageMsgListAdapter", "弹出菜单：开始");
            ArrayList<ChatPopMenuAction> E = E(this.f20352a.get(i11), i11);
            ChatPopMenu chatPopMenu = new ChatPopMenu(this.f20356e, E);
            chatPopMenu.backGroundColor = R$color.color_14181F;
            chatPopMenu.setShadowWidth(10);
            chatPopMenu.shadowColor = R$color.im_color_live_pop_shadow;
            chatPopMenu.setChatPopMenuActionList(E);
            chatPopMenu.show(view, 0);
            IMLog.e("TUIBarrageMsgListAdapter", "弹出菜单：结束");
        } catch (Exception e11) {
            IMLog.e("TUIBarrageMsgListAdapter", e11.getMessage());
        }
    }

    public int getItemCount() {
        return this.f20352a.size();
    }

    public int getItemViewType(int i11) {
        TUIBarrageMsgEntity tUIBarrageMsgEntity = this.f20352a.get(i11);
        if (tUIBarrageMsgEntity != null) {
            int i12 = tUIBarrageMsgEntity.type;
            MessageType messageType = MessageType.MESSAGE_NEW_USER_INTO;
            if (i12 == messageType.getType()) {
                return messageType.getType();
            }
            int i13 = tUIBarrageMsgEntity.type;
            MessageType messageType2 = MessageType.MESSAGE_GIFT_ANIM;
            if (i13 == messageType2.getType()) {
                return messageType2.getType();
            }
            int i14 = tUIBarrageMsgEntity.type;
            MessageType messageType3 = MessageType.MESSAGE_REDPACKET_SNATCH;
            if (i14 == messageType3.getType()) {
                return messageType3.getType();
            }
        }
        return super.getItemViewType(i11);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        TUIBarrageMsgEntity tUIBarrageMsgEntity = this.f20352a.get(i11);
        if (viewHolder instanceof s) {
            ((s) viewHolder).h(tUIBarrageMsgEntity, this.f20353b, i11);
        } else if (viewHolder instanceof q) {
            ((q) viewHolder).h(tUIBarrageMsgEntity, this.f20353b, i11);
        } else if (viewHolder instanceof o) {
            ((o) viewHolder).a(tUIBarrageMsgEntity, this.f20353b, i11);
        } else if (viewHolder instanceof r) {
            ((r) viewHolder).a(tUIBarrageMsgEntity, this.f20353b, i11);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 == MessageType.MESSAGE_NEW_USER_INTO.getType()) {
            return new o(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.new_tuibarrage_item_new_user_msg, viewGroup, false));
        }
        if (i11 == MessageType.MESSAGE_GIFT_ANIM.getType()) {
            return new q(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.recive_gift_msg, viewGroup, false));
        }
        if (i11 == MessageType.MESSAGE_REDPACKET_SNATCH.getType()) {
            return new r(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.redpacket_snatch_msg, viewGroup, false));
        }
        return new s(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.new_tuibarrage_item_msg, viewGroup, false));
    }

    public final void w(LiveSpeaker liveSpeaker, boolean z11) {
        LiveDetailBean liveDetailBean;
        LiveDetailBean liveDetailBean2;
        List<LiveSpeaker> list;
        if (liveSpeaker != null) {
            if (z11) {
                if (!y(liveSpeaker.showId) && (liveDetailBean2 = this.f20358g) != null && (list = liveDetailBean2.presenterList) != null) {
                    list.add(liveSpeaker);
                }
            } else if (y(liveSpeaker.showId) && (liveDetailBean = this.f20358g) != null) {
                Iterator<LiveSpeaker> it2 = liveDetailBean.presenterList.iterator();
                List<LiveSpeaker> list2 = this.f20358g.presenterList;
                if (list2 != null && list2.size() > 0) {
                    while (it2.hasNext()) {
                        LiveSpeaker next = it2.next();
                        if (next != null && TextUtils.equals(next.showId, liveSpeaker.showId)) {
                            it2.remove();
                        }
                    }
                }
                Iterator<LiveSpeaker> it3 = this.f20358g.speakerList.iterator();
                List<LiveSpeaker> list3 = this.f20358g.speakerList;
                if (list3 != null && list3.size() > 0) {
                    while (it3.hasNext()) {
                        LiveSpeaker next2 = it3.next();
                        if (next2 != null && TextUtils.equals(next2.showId, liveSpeaker.showId)) {
                            it3.remove();
                        }
                    }
                }
            }
        }
    }

    public final void x(String str) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f20356e.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("message", str));
            ToastUtil.toastShortMessage(this.f20356e.getResources().getString(R$string.copy_success_tip));
        }
    }

    public final boolean y(String str) {
        LiveDetailBean liveDetailBean;
        IMLog.i("TUIBarrageMsgListAdapter", "findUserIsAdminByUserId  userId:" + str);
        boolean z11 = false;
        if (str == null || (liveDetailBean = this.f20358g) == null) {
            return false;
        }
        List<LiveSpeaker> list = liveDetailBean.presenterList;
        if (list != null && list.size() > 0) {
            Iterator<LiveSpeaker> it2 = this.f20358g.presenterList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (TextUtils.equals(str, it2.next().showId)) {
                        z11 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        List<LiveSpeaker> list2 = this.f20358g.speakerList;
        if (list2 == null || list2.size() <= 0) {
            return z11;
        }
        for (LiveSpeaker liveSpeaker : this.f20358g.speakerList) {
            if (TextUtils.equals(str, liveSpeaker.showId)) {
                return true;
            }
        }
        return z11;
    }

    public final boolean z(String str) {
        LiveDetailBean liveDetailBean;
        List<LiveSpeaker> list;
        IMLog.i("TUIBarrageMsgListAdapter", "findUserIsAdminByUserId  userId:" + str);
        if (TextUtils.isEmpty(str) || (liveDetailBean = this.f20358g) == null || (list = liveDetailBean.speakerList) == null || list.size() <= 0) {
            return false;
        }
        for (LiveSpeaker liveSpeaker : this.f20358g.speakerList) {
            if (TextUtils.equals(str, liveSpeaker.showId)) {
                return true;
            }
        }
        return false;
    }
}
