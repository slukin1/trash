package com.hbg.module.huobi.im.group.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.bean.GroupInfoData;
import com.hbg.lib.network.hbg.core.bean.GroupUserListData;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.event.MessageNoDisturbEvent;
import com.hbg.module.huobi.im.group.base.BaseActivity;
import com.hbg.module.huobi.im.group.bean.MessageNoDisturbStatus;
import com.hbg.module.huobi.im.group.bean.OberverData;
import com.hbg.module.huobi.im.group.ui.adapter.GroupUserInfoAdapter;
import com.hbg.module.huobi.im.observer.ImObserverHelper;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversationManager;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.manager.HbGroupChatManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import org.greenrobot.eventbus.EventBus;
import rd.q;
import rd.s;

public final class GroupChatInfoActivity extends BaseActivity implements View.OnClickListener, Observer {
    public static final a L = new a((r) null);
    public TextView A;
    public RelativeLayout B;
    public TextView C;
    public SwitchCompat D;
    public String E;
    public GroupInfoData F;
    public GroupUserListData G;
    public GroupUserInfoAdapter H = new GroupUserInfoAdapter();
    public ld.f I = new ld.f((ld.e) null);
    public boolean J;
    public Dialog K;

    /* renamed from: d  reason: collision with root package name */
    public LoadingLayout f19890d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19891e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19892f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19893g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19894h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f19895i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f19896j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f19897k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f19898l;

    /* renamed from: m  reason: collision with root package name */
    public RelativeLayout f19899m;

    /* renamed from: n  reason: collision with root package name */
    public FrameLayout f19900n;

    /* renamed from: o  reason: collision with root package name */
    public RelativeLayout f19901o;

    /* renamed from: p  reason: collision with root package name */
    public SwitchCompat f19902p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f19903q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f19904r;

    /* renamed from: s  reason: collision with root package name */
    public RelativeLayout f19905s;

    /* renamed from: t  reason: collision with root package name */
    public SwitchCompat f19906t;

    /* renamed from: u  reason: collision with root package name */
    public View f19907u;

    /* renamed from: v  reason: collision with root package name */
    public View f19908v;

    /* renamed from: w  reason: collision with root package name */
    public LinearLayout f19909w;

    /* renamed from: x  reason: collision with root package name */
    public SwitchCompat f19910x;

    /* renamed from: y  reason: collision with root package name */
    public View f19911y;

    /* renamed from: z  reason: collision with root package name */
    public LinearLayout f19912z;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements dd.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f19913a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupChatInfoActivity f19914b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f19915c;

        public b(boolean z11, GroupChatInfoActivity groupChatInfoActivity, Ref$IntRef ref$IntRef) {
            this.f19913a = z11;
            this.f19914b = groupChatInfoActivity;
            this.f19915c = ref$IntRef;
        }

        public void onFailed(int i11, String str) {
            boolean z11 = true;
            this.f19914b.J = true;
            SwitchCompat Bh = this.f19914b.D;
            if (Bh == null) {
                Bh = null;
            }
            if (this.f19915c.element == 1) {
                z11 = false;
            }
            Bh.setChecked(z11);
            this.f19914b.J = false;
        }

        public void onSuccess() {
            HashMap hashMap = new HashMap(1);
            if (this.f19913a) {
                hashMap.put("open", 1);
            } else {
                hashMap.put("open", 0);
            }
            q.a("appclick_messagesetting_onegroup", hashMap);
            MessageNoDisturbEvent messageNoDisturbEvent = new MessageNoDisturbEvent();
            String vh2 = this.f19914b.E;
            if (vh2 == null) {
                vh2 = null;
            }
            messageNoDisturbEvent.f19693a = vh2;
            messageNoDisturbEvent.f19694b = 2;
            messageNoDisturbEvent.f19695c = this.f19913a;
            EventBus.d().k(messageNoDisturbEvent);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19916b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19917c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ GroupChatInfoActivity f19918d;

        public c(View view, long j11, GroupChatInfoActivity groupChatInfoActivity) {
            this.f19916b = view;
            this.f19917c = j11;
            this.f19918d = groupChatInfoActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19916b) > this.f19917c || (this.f19916b instanceof Checkable)) {
                sVar.e(this.f19916b, currentTimeMillis);
                TextView textView = (TextView) this.f19916b;
                this.f19918d.Uh(2);
                Dialog uh2 = this.f19918d.K;
                if (uh2 != null) {
                    uh2.dismiss();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d extends BaseSubscriber<GroupInfoData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupChatInfoActivity f19919b;

        public d(GroupChatInfoActivity groupChatInfoActivity) {
            this.f19919b = groupChatInfoActivity;
        }

        /* renamed from: a */
        public void onNext(GroupInfoData groupInfoData) {
            super.onNext(groupInfoData);
            this.f19919b.F = groupInfoData;
            GroupInfoData wh2 = this.f19919b.F;
            if (wh2 != null) {
                GroupChatInfoActivity groupChatInfoActivity = this.f19919b;
                View view = null;
                if (wh2.getShareContract() == -1) {
                    RelativeLayout Ah = groupChatInfoActivity.f19905s;
                    if (Ah == null) {
                        Ah = null;
                    }
                    Ah.setVisibility(8);
                    View Hh = groupChatInfoActivity.f19907u;
                    if (Hh != null) {
                        view = Hh;
                    }
                    view.setVisibility(8);
                } else {
                    RelativeLayout Ah2 = groupChatInfoActivity.f19905s;
                    if (Ah2 == null) {
                        Ah2 = null;
                    }
                    Ah2.setVisibility(0);
                    View Hh2 = groupChatInfoActivity.f19907u;
                    if (Hh2 != null) {
                        view = Hh2;
                    }
                    view.setVisibility(0);
                }
            }
            this.f19919b.Wh();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            LoadingLayout yh2 = this.f19919b.f19890d;
            if (yh2 == null) {
                yh2 = null;
            }
            yh2.k();
        }
    }

    public static final class e implements kd.a<MessageNoDisturbStatus> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupChatInfoActivity f19920a;

        public e(GroupChatInfoActivity groupChatInfoActivity) {
            this.f19920a = groupChatInfoActivity;
        }

        /* renamed from: a */
        public void onSuccess(MessageNoDisturbStatus messageNoDisturbStatus) {
            SwitchCompat Bh = this.f19920a.D;
            if (Bh == null) {
                Bh = null;
            }
            Bh.setChecked("1".equals(messageNoDisturbStatus.status));
        }

        public void onFailed(int i11, String str) {
            SwitchCompat Bh = this.f19920a.D;
            if (Bh == null) {
                Bh = null;
            }
            Bh.setChecked(false);
        }
    }

    public static final class f extends BaseSubscriber<GroupUserListData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupChatInfoActivity f19921b;

        public f(GroupChatInfoActivity groupChatInfoActivity) {
            this.f19921b = groupChatInfoActivity;
        }

        /* renamed from: a */
        public void onNext(GroupUserListData groupUserListData) {
            super.onNext(groupUserListData);
            this.f19921b.G = groupUserListData;
            GroupChatInfoActivity groupChatInfoActivity = this.f19921b;
            if (groupChatInfoActivity.Bf(groupChatInfoActivity)) {
                LoadingLayout yh2 = this.f19921b.f19890d;
                if (yh2 == null) {
                    yh2 = null;
                }
                yh2.g();
                this.f19921b.ci();
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            LoadingLayout yh2 = this.f19921b.f19890d;
            if (yh2 == null) {
                yh2 = null;
            }
            yh2.k();
        }
    }

    public static final class g extends IUIKitCallback<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupChatInfoActivity f19922a;

        public static final class a implements V2TIMCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ GroupChatInfoActivity f19923a;

            public a(GroupChatInfoActivity groupChatInfoActivity) {
                this.f19923a = groupChatInfoActivity;
            }

            public void onError(int i11, String str) {
                ToastUtil.toastLongMessage(this.f19923a.getString(R$string.n_im_quit_group_fail));
            }

            public void onSuccess() {
                ToastUtil.toastLongMessage(this.f19923a.getString(R$string.n_im_quit_group_success));
            }
        }

        public g(GroupChatInfoActivity groupChatInfoActivity) {
            this.f19922a = groupChatInfoActivity;
        }

        public static final void b(GroupChatInfoActivity groupChatInfoActivity) {
            groupChatInfoActivity.setResult(-1);
            groupChatInfoActivity.finish();
        }

        public void onError(String str, int i11, String str2) {
            ToastUtil.toastLongMessage(this.f19922a.getString(R$string.n_im_quit_group_fail));
        }

        public void onSuccess(Void voidR) {
            View decorView;
            Window window = this.f19922a.getWindow();
            if (!(window == null || (decorView = window.getDecorView()) == null)) {
                decorView.postDelayed(new k(this.f19922a), 1000);
            }
            V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
            d0 d0Var = d0.f56774a;
            Object[] objArr = new Object[1];
            String vh2 = this.f19922a.E;
            if (vh2 == null) {
                vh2 = null;
            }
            objArr[0] = vh2;
            conversationManager.deleteConversation(String.format("group_%s", Arrays.copyOf(objArr, 1)), new a(this.f19922a));
        }
    }

    public static final class h implements kd.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupChatInfoActivity f19924a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f19925b;

        public h(GroupChatInfoActivity groupChatInfoActivity, boolean z11) {
            this.f19924a = groupChatInfoActivity;
            this.f19925b = z11;
        }

        public void onFailed(int i11, String str) {
            ToastUtil.toastShortMessage(this.f19924a.getString(R$string.n_im_operation_fail));
        }

        public void onSuccess(Object obj) {
            if (this.f19925b) {
                ToastUtil.toastShortMessage(this.f19924a.getString(R$string.n_im_forbin_send_success));
            } else {
                ToastUtil.toastShortMessage(this.f19924a.getString(R$string.n_im_forbin_send_canceled));
            }
        }
    }

    public static final class i implements kd.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupChatInfoActivity f19926a;

        public i(GroupChatInfoActivity groupChatInfoActivity) {
            this.f19926a = groupChatInfoActivity;
        }

        public void onFailed(int i11, String str) {
            ToastUtil.toastShortMessage(this.f19926a.getString(R$string.n_im_operation_fail));
            SwitchCompat Ch = this.f19926a.f19906t;
            SwitchCompat switchCompat = null;
            if (Ch == null) {
                Ch = null;
            }
            SwitchCompat Ch2 = this.f19926a.f19906t;
            if (Ch2 != null) {
                switchCompat = Ch2;
            }
            Ch.setChecked(!switchCompat.isChecked());
        }

        public void onSuccess(Object obj) {
        }
    }

    public static final class j implements kd.a<GroupInfoData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupChatInfoActivity f19927a;

        public j(GroupChatInfoActivity groupChatInfoActivity) {
            this.f19927a = groupChatInfoActivity;
        }

        /* renamed from: a */
        public void onSuccess(GroupInfoData groupInfoData) {
            if (groupInfoData != null) {
                TextView Eh = this.f19927a.f19891e;
                TextView textView = null;
                if (Eh == null) {
                    Eh = null;
                }
                Eh.setText(groupInfoData.getTitle());
                TextView Fh = this.f19927a.f19898l;
                if (Fh == null) {
                    Fh = null;
                }
                Fh.setVisibility(0);
                TextView Fh2 = this.f19927a.f19898l;
                if (Fh2 != null) {
                    textView = Fh2;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append('(');
                sb2.append(groupInfoData.getUserCount());
                sb2.append(')');
                textView.setText(sb2.toString());
            }
        }

        public void onFailed(int i11, String str) {
            if (this.f19927a.F != null) {
                TextView Eh = this.f19927a.f19891e;
                TextView textView = null;
                if (Eh == null) {
                    Eh = null;
                }
                Eh.setText(this.f19927a.F.getTitle());
                TextView Fh = this.f19927a.f19898l;
                if (Fh == null) {
                    Fh = null;
                }
                Fh.setVisibility(0);
                TextView Fh2 = this.f19927a.f19898l;
                if (Fh2 != null) {
                    textView = Fh2;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append('(');
                sb2.append(this.f19927a.F.getUserCount());
                sb2.append(')');
                textView.setText(sb2.toString());
            }
        }
    }

    public static final class k implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19928b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19929c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ GroupChatInfoActivity f19930d;

        public k(View view, long j11, GroupChatInfoActivity groupChatInfoActivity) {
            this.f19928b = view;
            this.f19929c = j11;
            this.f19930d = groupChatInfoActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19928b) > this.f19929c || (this.f19928b instanceof Checkable)) {
                sVar.e(this.f19928b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f19928b;
                this.f19930d.Sh();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class l implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19931b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19932c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ GroupChatInfoActivity f19933d;

        public l(View view, long j11, GroupChatInfoActivity groupChatInfoActivity) {
            this.f19931b = view;
            this.f19932c = j11;
            this.f19933d = groupChatInfoActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19931b) > this.f19932c || (this.f19931b instanceof Checkable)) {
                sVar.e(this.f19931b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f19931b;
                Postcard a11 = b2.a.d().a("/im/applylist");
                String vh2 = this.f19933d.E;
                if (vh2 == null) {
                    vh2 = null;
                }
                a11.withString("groupId", vh2).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    @SensorsDataInstrumented
    public static final void Qh(GroupChatInfoActivity groupChatInfoActivity, View view) {
        groupChatInfoActivity.Vh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void Rh(GroupChatInfoActivity groupChatInfoActivity, CompoundButton compoundButton, boolean z11) {
        if (compoundButton.isPressed() && !groupChatInfoActivity.J) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            if (z11) {
                ref$IntRef.element = 1;
            }
            ld.f fVar = groupChatInfoActivity.I;
            String str = groupChatInfoActivity.E;
            if (str == null) {
                str = null;
            }
            fVar.D(2, str, ref$IntRef.element, new b(z11, groupChatInfoActivity, ref$IntRef));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    @SensorsDataInstrumented
    public static final void Th(GroupChatInfoActivity groupChatInfoActivity, View view) {
        Dialog dialog = groupChatInfoActivity.K;
        if (dialog != null) {
            dialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Xh(HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    public static final void Yh(GroupChatInfoActivity groupChatInfoActivity, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        HbGroupChatManager instance = HbGroupChatManager.getInstance();
        String str = groupChatInfoActivity.E;
        if (str == null) {
            str = null;
        }
        instance.quitGroup(str, new g(groupChatInfoActivity));
    }

    @SensorsDataInstrumented
    public static final void di(GroupChatInfoActivity groupChatInfoActivity, CompoundButton compoundButton, boolean z11) {
        if (compoundButton.isPressed()) {
            groupChatInfoActivity.ai(z11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    @SensorsDataInstrumented
    public static final void ei(GroupChatInfoActivity groupChatInfoActivity, CompoundButton compoundButton, boolean z11) {
        if (compoundButton.isPressed()) {
            if (z11) {
                new nd.b(groupChatInfoActivity).a().c(true).b(true).j(20.0f).d(groupChatInfoActivity.getString(R$string.n_im_forbid_all_hint)).e(0.75f).h(groupChatInfoActivity.getString(R$string.n_sure), new d(groupChatInfoActivity, z11)).g(groupChatInfoActivity.getString(R$string.n_cancel), new c(groupChatInfoActivity)).k();
            } else {
                groupChatInfoActivity.Zh(z11);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    public static final void fi(GroupChatInfoActivity groupChatInfoActivity, boolean z11, View view) {
        groupChatInfoActivity.Zh(z11);
    }

    public static final void gi(GroupChatInfoActivity groupChatInfoActivity, View view) {
        SwitchCompat switchCompat = groupChatInfoActivity.f19902p;
        if (switchCompat == null) {
            switchCompat = null;
        }
        switchCompat.setChecked(false);
    }

    @SensorsDataInstrumented
    public static final void hi(GroupChatInfoActivity groupChatInfoActivity, CompoundButton compoundButton, boolean z11) {
        if (compoundButton.isPressed()) {
            groupChatInfoActivity.Uh(z11 ? 2 : 1);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    public final void Ph() {
        LoadingLayout loadingLayout = this.f19890d;
        SwitchCompat switchCompat = null;
        if (loadingLayout == null) {
            loadingLayout = null;
        }
        loadingLayout.setOnRetryClickListener(new b(this));
        s sVar = s.f23381a;
        TextView textView = this.f19897k;
        s.l(sVar, textView == null ? null : textView, this, 0, 2, (Object) null);
        TextView textView2 = this.f19894h;
        s.l(sVar, textView2 == null ? null : textView2, this, 0, 2, (Object) null);
        TextView textView3 = this.f19896j;
        s.l(sVar, textView3 == null ? null : textView3, this, 0, 2, (Object) null);
        RelativeLayout relativeLayout = this.f19899m;
        s.l(sVar, relativeLayout == null ? null : relativeLayout, this, 0, 2, (Object) null);
        FrameLayout frameLayout = this.f19900n;
        s.l(sVar, frameLayout == null ? null : frameLayout, this, 0, 2, (Object) null);
        TextView textView4 = this.f19903q;
        s.l(sVar, textView4 == null ? null : textView4, this, 0, 2, (Object) null);
        SwitchCompat switchCompat2 = this.D;
        if (switchCompat2 != null) {
            switchCompat = switchCompat2;
        }
        switchCompat.setOnCheckedChangeListener(new g(this));
    }

    public final void Sh() {
        View decorView;
        Window window;
        Window window2;
        TextView textView = null;
        boolean z11 = false;
        if (this.K == null) {
            AlertDialog create = new AlertDialog.Builder(this).setView(LayoutInflater.from(this).inflate(R$layout.dialog_change_group_type, (ViewGroup) null)).create();
            this.K = create;
            if (!(create == null || (window2 = create.getWindow()) == null)) {
                window2.setBackgroundDrawable(new ColorDrawable(0));
            }
            Dialog dialog = this.K;
            if (!(dialog == null || (window = dialog.getWindow()) == null)) {
                window.setGravity(80);
            }
            Dialog dialog2 = this.K;
            Window window3 = dialog2 != null ? dialog2.getWindow() : null;
            if (!(window3 == null || (decorView = window3.getDecorView()) == null)) {
                decorView.setPadding(0, 0, 0, 0);
            }
            WindowManager.LayoutParams attributes = window3 != null ? window3.getAttributes() : null;
            if (attributes != null) {
                attributes.width = -1;
            }
            if (attributes != null) {
                attributes.horizontalMargin = 0.0f;
            }
            if (window3 != null) {
                window3.setAttributes(attributes);
            }
        }
        Dialog dialog3 = this.K;
        if (dialog3 != null) {
            dialog3.show();
        }
        Dialog dialog4 = this.K;
        TextView textView2 = dialog4 != null ? (TextView) dialog4.findViewById(R$id.tvAdminVerify) : null;
        Dialog dialog5 = this.K;
        if (dialog5 != null) {
            textView = (TextView) dialog5.findViewById(R$id.tvCancel);
        }
        GroupInfoData groupInfoData = this.F;
        if (!(groupInfoData != null && groupInfoData.getType() == 2)) {
            GroupInfoData groupInfoData2 = this.F;
            if (groupInfoData2 != null && groupInfoData2.getType() == 3) {
                z11 = true;
            }
            if (z11 && textView2 != null) {
                textView2.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
            }
        } else if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
        }
        if (textView != null) {
            textView.setOnClickListener(new a(this));
        }
        if (textView2 != null) {
            s sVar = s.f23381a;
            textView2.setOnClickListener(new c(textView2, 800, this));
        }
    }

    public final void Uh(int i11) {
        IHbgApi a11 = v7.b.a();
        String str = this.E;
        if (str == null) {
            str = null;
        }
        RequestExtKt.d(a11.F(str, i11), new GroupChatInfoActivity$joinFuncChange$1(this, i11), new GroupChatInfoActivity$joinFuncChange$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public final void Vh() {
        LoadingLayout loadingLayout = this.f19890d;
        String str = null;
        if (loadingLayout == null) {
            loadingLayout = null;
        }
        loadingLayout.p();
        IHbgApi a11 = v7.b.a();
        String str2 = this.E;
        if (str2 == null) {
            str2 = null;
        }
        a11.getGroupInfoData(str2).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new d(this));
        ld.f fVar = this.I;
        String str3 = this.E;
        if (str3 != null) {
            str = str3;
        }
        fVar.m(2, str, new e(this));
    }

    public final void Wh() {
        IHbgApi a11 = v7.b.a();
        String str = this.E;
        if (str == null) {
            str = null;
        }
        a11.getGroupUserListData(str, 1, 15, "").b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new f(this));
    }

    public final void Zh(boolean z11) {
        ld.f fVar = this.I;
        String str = this.E;
        if (str == null) {
            str = null;
        }
        fVar.A(str, z11 ? 1 : 0, new h(this, z11));
    }

    public final void ai(boolean z11) {
        ld.f fVar = this.I;
        String str = this.E;
        if (str == null) {
            str = null;
        }
        fVar.C(str, z11 ? 1 : 0, new i(this));
    }

    public final void bi() {
        rd.c.b().c(new j(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ci() {
        /*
            r13 = this;
            com.hbg.lib.network.hbg.core.bean.GroupUserListData r0 = r13.G
            r1 = 8
            r2 = 1
            r3 = 0
            r4 = 0
            if (r0 == 0) goto L_0x0174
            com.hbg.module.huobi.im.group.ui.adapter.GroupUserInfoAdapter r5 = r13.H
            java.util.List r0 = r0.getListData()
            r5.d(r0)
            com.hbg.lib.network.hbg.core.bean.GroupInfoData r0 = r13.F
            if (r0 == 0) goto L_0x001e
            int r0 = r0.getIsPresenter()
            if (r0 != r2) goto L_0x001e
            r0 = r2
            goto L_0x001f
        L_0x001e:
            r0 = r3
        L_0x001f:
            if (r0 == 0) goto L_0x0154
            android.widget.RelativeLayout r0 = r13.f19901o
            if (r0 != 0) goto L_0x0026
            r0 = r4
        L_0x0026:
            r0.setVisibility(r3)
            android.view.View r0 = r13.f19908v
            if (r0 != 0) goto L_0x002e
            r0 = r4
        L_0x002e:
            r0.setVisibility(r3)
            androidx.appcompat.widget.SwitchCompat r0 = r13.f19902p
            if (r0 != 0) goto L_0x0036
            r0 = r4
        L_0x0036:
            com.hbg.lib.network.hbg.core.bean.GroupUserListData r5 = r13.G
            int r5 = r5.getForbidAll()
            if (r5 != r2) goto L_0x0040
            r5 = r2
            goto L_0x0041
        L_0x0040:
            r5 = r3
        L_0x0041:
            r0.setChecked(r5)
            androidx.appcompat.widget.SwitchCompat r0 = r13.f19902p
            if (r0 != 0) goto L_0x0049
            r0 = r4
        L_0x0049:
            com.hbg.module.huobi.im.group.ui.f r5 = new com.hbg.module.huobi.im.group.ui.f
            r5.<init>(r13)
            r0.setOnCheckedChangeListener(r5)
            android.widget.LinearLayout r0 = r13.f19909w
            if (r0 != 0) goto L_0x0056
            r0 = r4
        L_0x0056:
            r0.setVisibility(r3)
            com.hbg.lib.network.hbg.core.bean.GroupInfoData r0 = r13.F
            r5 = 2
            if (r0 == 0) goto L_0x0066
            int r0 = r0.getType()
            if (r0 != r5) goto L_0x0066
            r0 = r2
            goto L_0x0067
        L_0x0066:
            r0 = r3
        L_0x0067:
            r6 = 3
            if (r0 != 0) goto L_0x007c
            com.hbg.lib.network.hbg.core.bean.GroupInfoData r0 = r13.F
            if (r0 == 0) goto L_0x0076
            int r0 = r0.getType()
            if (r0 != r6) goto L_0x0076
            r0 = r2
            goto L_0x0077
        L_0x0076:
            r0 = r3
        L_0x0077:
            if (r0 == 0) goto L_0x007a
            goto L_0x007c
        L_0x007a:
            r0 = r3
            goto L_0x007d
        L_0x007c:
            r0 = r2
        L_0x007d:
            androidx.appcompat.widget.SwitchCompat r7 = r13.f19910x
            if (r7 != 0) goto L_0x0082
            r7 = r4
        L_0x0082:
            r7.setChecked(r0)
            rd.s r7 = rd.s.f23381a
            android.widget.LinearLayout r7 = r13.f19912z
            if (r7 != 0) goto L_0x008c
            r7 = r4
        L_0x008c:
            com.hbg.module.huobi.im.group.ui.GroupChatInfoActivity$k r8 = new com.hbg.module.huobi.im.group.ui.GroupChatInfoActivity$k
            r9 = 800(0x320, double:3.953E-321)
            r8.<init>(r7, r9, r13)
            r7.setOnClickListener(r8)
            android.widget.LinearLayout r7 = r13.f19912z
            if (r7 != 0) goto L_0x009b
            r7 = r4
        L_0x009b:
            java.lang.String r8 = ""
            if (r0 == 0) goto L_0x00e8
            android.widget.TextView r0 = r13.A
            if (r0 != 0) goto L_0x00a4
            r0 = r4
        L_0x00a4:
            com.hbg.lib.network.hbg.core.bean.GroupInfoData r11 = r13.F
            if (r11 == 0) goto L_0x00b1
            int r11 = r11.getType()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x00b2
        L_0x00b1:
            r11 = r4
        L_0x00b2:
            if (r11 != 0) goto L_0x00b5
            goto L_0x00c6
        L_0x00b5:
            int r12 = r11.intValue()
            if (r12 != r5) goto L_0x00c6
            android.content.res.Resources r6 = r13.getResources()
            int r11 = com.hbg.module.huobi.im.R$string.n_live_group_admin_verify_join
            java.lang.String r6 = r6.getString(r11)
            goto L_0x00db
        L_0x00c6:
            if (r11 != 0) goto L_0x00c9
            goto L_0x00da
        L_0x00c9:
            int r11 = r11.intValue()
            if (r11 != r6) goto L_0x00da
            android.content.res.Resources r6 = r13.getResources()
            int r11 = com.hbg.module.huobi.im.R$string.n_live_group_pay_join
            java.lang.String r6 = r6.getString(r11)
            goto L_0x00db
        L_0x00da:
            r6 = r8
        L_0x00db:
            r0.setText(r6)
            android.view.View r0 = r13.f19911y
            if (r0 != 0) goto L_0x00e3
            r0 = r4
        L_0x00e3:
            r0.setVisibility(r3)
            r0 = r3
            goto L_0x00f1
        L_0x00e8:
            android.view.View r0 = r13.f19911y
            if (r0 != 0) goto L_0x00ed
            r0 = r4
        L_0x00ed:
            r0.setVisibility(r1)
            r0 = r1
        L_0x00f1:
            r7.setVisibility(r0)
            androidx.appcompat.widget.SwitchCompat r0 = r13.f19910x
            if (r0 != 0) goto L_0x00f9
            r0 = r4
        L_0x00f9:
            com.hbg.module.huobi.im.group.ui.e r6 = new com.hbg.module.huobi.im.group.ui.e
            r6.<init>(r13)
            r0.setOnCheckedChangeListener(r6)
            android.widget.RelativeLayout r0 = r13.B
            if (r0 != 0) goto L_0x0106
            r0 = r4
        L_0x0106:
            com.hbg.module.huobi.im.group.ui.GroupChatInfoActivity$l r6 = new com.hbg.module.huobi.im.group.ui.GroupChatInfoActivity$l
            r6.<init>(r0, r9, r13)
            r0.setOnClickListener(r6)
            android.widget.RelativeLayout r0 = r13.B
            if (r0 != 0) goto L_0x0113
            r0 = r4
        L_0x0113:
            com.hbg.lib.network.hbg.core.bean.GroupInfoData r6 = r13.F
            if (r6 == 0) goto L_0x011f
            int r6 = r6.getType()
            if (r6 != r5) goto L_0x011f
            r5 = r2
            goto L_0x0120
        L_0x011f:
            r5 = r3
        L_0x0120:
            if (r5 == 0) goto L_0x014f
            com.hbg.lib.network.hbg.core.bean.GroupInfoData r5 = r13.F
            if (r5 == 0) goto L_0x012b
            int r5 = r5.getApplyCount()
            goto L_0x012c
        L_0x012b:
            r5 = r3
        L_0x012c:
            if (r5 <= 0) goto L_0x0145
            android.widget.TextView r5 = r13.C
            if (r5 != 0) goto L_0x0133
            r5 = r4
        L_0x0133:
            com.hbg.lib.network.hbg.core.bean.GroupInfoData r6 = r13.F
            if (r6 == 0) goto L_0x013c
            int r6 = r6.getApplyCount()
            goto L_0x013d
        L_0x013c:
            r6 = r3
        L_0x013d:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r5.setText(r6)
            goto L_0x014d
        L_0x0145:
            android.widget.TextView r5 = r13.C
            if (r5 != 0) goto L_0x014a
            r5 = r4
        L_0x014a:
            r5.setText(r8)
        L_0x014d:
            r5 = r3
            goto L_0x0150
        L_0x014f:
            r5 = r1
        L_0x0150:
            r0.setVisibility(r5)
            goto L_0x0174
        L_0x0154:
            android.view.View r0 = r13.f19911y
            if (r0 != 0) goto L_0x0159
            r0 = r4
        L_0x0159:
            r0.setVisibility(r1)
            android.widget.LinearLayout r0 = r13.f19912z
            if (r0 != 0) goto L_0x0161
            r0 = r4
        L_0x0161:
            r0.setVisibility(r1)
            android.widget.RelativeLayout r0 = r13.f19901o
            if (r0 != 0) goto L_0x0169
            r0 = r4
        L_0x0169:
            r0.setVisibility(r1)
            android.view.View r0 = r13.f19908v
            if (r0 != 0) goto L_0x0171
            r0 = r4
        L_0x0171:
            r0.setVisibility(r1)
        L_0x0174:
            com.hbg.lib.network.hbg.core.bean.GroupInfoData r0 = r13.F
            if (r0 == 0) goto L_0x01ed
            java.lang.String r5 = r0.getNotification2()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x019b
            android.widget.TextView r5 = r13.f19903q
            if (r5 != 0) goto L_0x0187
            r5 = r4
        L_0x0187:
            r5.setVisibility(r3)
            android.widget.TextView r5 = r13.f19897k
            if (r5 != 0) goto L_0x018f
            r5 = r4
        L_0x018f:
            r5.setVisibility(r1)
            android.widget.TextView r5 = r13.f19904r
            if (r5 != 0) goto L_0x0197
            r5 = r4
        L_0x0197:
            r5.setVisibility(r1)
            goto L_0x01cf
        L_0x019b:
            android.widget.TextView r5 = r13.f19903q
            if (r5 != 0) goto L_0x01a0
            r5 = r4
        L_0x01a0:
            r5.setVisibility(r1)
            android.widget.TextView r1 = r13.f19897k
            if (r1 != 0) goto L_0x01a8
            r1 = r4
        L_0x01a8:
            r1.setVisibility(r3)
            android.widget.TextView r1 = r13.f19904r
            if (r1 != 0) goto L_0x01b0
            r1 = r4
        L_0x01b0:
            r1.setVisibility(r3)
            android.widget.TextView r1 = r13.f19897k
            if (r1 != 0) goto L_0x01b8
            r1 = r4
        L_0x01b8:
            java.lang.String r5 = r0.getNotification2()
            r1.setText(r5)
            android.widget.TextView r1 = r13.f19904r
            if (r1 != 0) goto L_0x01c4
            r1 = r4
        L_0x01c4:
            int r5 = r0.getNotification2Count()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r1.setText(r5)
        L_0x01cf:
            int r0 = r0.getShareContract()
            if (r0 != r2) goto L_0x01d6
            goto L_0x01d7
        L_0x01d6:
            r2 = r3
        L_0x01d7:
            androidx.appcompat.widget.SwitchCompat r0 = r13.f19906t
            if (r0 != 0) goto L_0x01dc
            r0 = r4
        L_0x01dc:
            r0.setChecked(r2)
            androidx.appcompat.widget.SwitchCompat r0 = r13.f19906t
            if (r0 != 0) goto L_0x01e4
            goto L_0x01e5
        L_0x01e4:
            r4 = r0
        L_0x01e5:
            com.hbg.module.huobi.im.group.ui.h r0 = new com.hbg.module.huobi.im.group.ui.h
            r0.<init>(r13)
            r4.setOnCheckedChangeListener(r0)
        L_0x01ed:
            r13.bi()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.GroupChatInfoActivity.ci():void");
    }

    public final void initExtra() {
        if (getIntent() != null) {
            this.E = String.valueOf(getIntent().getStringExtra("group_id"));
        }
    }

    public final void initView() {
        this.f19891e = (TextView) findViewById(R$id.tv_title);
        this.f19898l = (TextView) findViewById(R$id.tv_title_extra);
        this.f19892f = (ImageView) findViewById(R$id.iv_back);
        this.f19894h = (TextView) findViewById(R$id.tv_user_info);
        this.f19895i = (RecyclerView) findViewById(R$id.rv_user_list);
        this.f19896j = (TextView) findViewById(R$id.tv_exit_group);
        this.f19890d = (LoadingLayout) findViewById(R$id.loading_layout);
        this.f19897k = (TextView) findViewById(R$id.tv_notice);
        this.f19893g = (ImageView) findViewById(R$id.iv_notice_hint);
        this.f19899m = (RelativeLayout) findViewById(R$id.rl_notice);
        this.f19900n = (FrameLayout) findViewById(R$id.fl_back);
        this.f19901o = (RelativeLayout) findViewById(R$id.rl_all_forbid);
        this.f19902p = (SwitchCompat) findViewById(R$id.sc_all_forbid);
        this.f19903q = (TextView) findViewById(R$id.tv_no_notice);
        this.f19904r = (TextView) findViewById(R$id.tv_notice_count);
        this.f19905s = (RelativeLayout) findViewById(R$id.rl_share_contract);
        this.f19906t = (SwitchCompat) findViewById(R$id.sc_share_contract);
        this.f19907u = findViewById(R$id.v_share_contract_line);
        this.f19908v = findViewById(R$id.v_all_forbid_line);
        this.f19909w = (LinearLayout) findViewById(R$id.llVerify);
        this.f19910x = (SwitchCompat) findViewById(R$id.sc_verify);
        this.f19911y = findViewById(R$id.vVerifyLine);
        this.f19912z = (LinearLayout) findViewById(R$id.llVerifyFunc);
        this.A = (TextView) findViewById(R$id.tvVerifyFunc);
        this.B = (RelativeLayout) findViewById(R$id.rlJoinAdmin);
        this.C = (TextView) findViewById(R$id.tvJoinAdmin);
        this.D = (SwitchCompat) findViewById(R$id.sc_no_disturb);
        RecyclerView recyclerView = this.f19895i;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        RecyclerView recyclerView3 = this.f19895i;
        if (recyclerView3 != null) {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(this.H);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (1009 == i11) {
            Vh();
        }
        if (i12 == -1 && i11 == 1008) {
            finish();
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R$id.fl_back) {
            finish();
        } else {
            String str = null;
            if (view.getId() == R$id.tv_user_info) {
                Intent intent = new Intent(this, GroupMemberListActivity.class);
                String str2 = this.E;
                if (str2 != null) {
                    str = str2;
                }
                intent.putExtra("groupId", str);
                intent.putExtra("groupTitle", this.F.getTitle());
                startActivityForResult(intent, 1009);
            } else if (view.getId() == R$id.rl_notice || view.getId() == R$id.tv_notice || view.getId() == R$id.tv_no_notice) {
                Intent intent2 = new Intent(this, GroupNoticeListActivity.class);
                String str3 = this.E;
                if (str3 != null) {
                    str = str3;
                }
                intent2.putExtra("group_id", str);
                startActivityForResult(intent2, 1008);
            } else if (view.getId() == R$id.tv_exit_group) {
                DialogUtils.c0(this, getString(R$string.n_im_confirm_delete_and_out), (String) null, getString(R$string.n_cancel), getString(R$string.n_confirm), j.f20482a, new i(this));
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(getResources().getColor(R$color.baseColorContentBackground));
            }
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setNavigationBarColor(getResources().getColor(R$color.transparent));
            }
            Xf(this, !NightHelper.e().g());
        }
        setContentView(R$layout.activity_group_chat_info);
        initExtra();
        initView();
        Ph();
        Vh();
    }

    public void onDestroy() {
        super.onDestroy();
        ImObserverHelper.b().deleteObserver(this);
    }

    public void onResume() {
        super.onResume();
        bi();
    }

    public void onStart() {
        super.onStart();
        ImObserverHelper.b().addObserver(this);
    }

    public void update(Observable observable, Object obj) {
        if ((obj instanceof OberverData) && ((OberverData) obj).getType() == 1 && Bf(this)) {
            i6.d.j("GroupNoticeListActivity", "oberver 刷新数据");
            Vh();
        }
    }
}
