package com.hbg.module.huobi.im.group.ui;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.R$style;
import com.hbg.module.huobi.im.group.base.BaseActivity;
import com.hbg.module.huobi.im.group.bean.GroupNoticeItemEntity;
import com.hbg.module.huobi.im.group.bean.GroupNoticeUserInfoEntity;
import com.hbg.module.huobi.im.group.bean.OberverData;
import com.hbg.module.huobi.im.observer.ImObserverHelper;
import com.hbg.module.huobi.im.utils.LinkMovementMethodInterceptor;
import com.hbg.module.huobi.im.view.AvatarView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;
import rd.s;
import rd.u;

public final class GroupChatNoticeActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: u  reason: collision with root package name */
    public static final a f19962u = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public String f19963d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19964e;

    /* renamed from: f  reason: collision with root package name */
    public String f19965f;

    /* renamed from: g  reason: collision with root package name */
    public AppCompatTextView f19966g;

    /* renamed from: h  reason: collision with root package name */
    public AppCompatEditText f19967h;

    /* renamed from: i  reason: collision with root package name */
    public AppCompatImageView f19968i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f19969j;

    /* renamed from: k  reason: collision with root package name */
    public AvatarView f19970k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f19971l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f19972m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f19973n;

    /* renamed from: o  reason: collision with root package name */
    public View f19974o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f19975p;

    /* renamed from: q  reason: collision with root package name */
    public GroupNoticeItemEntity f19976q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f19977r;

    /* renamed from: s  reason: collision with root package name */
    public ld.f f19978s;

    /* renamed from: t  reason: collision with root package name */
    public SimpleDateFormat f19979t;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements kd.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupChatNoticeActivity f19980a;

        public b(GroupChatNoticeActivity groupChatNoticeActivity) {
            this.f19980a = groupChatNoticeActivity;
        }

        public void onFailed(int i11, String str) {
            HuobiToastUtil.j(R$string.n_im_operation_fail);
        }

        public void onSuccess(Object obj) {
            HuobiToastUtil.j(R$string.n_im_delete_notice_success);
            ImObserverHelper.b().a(new OberverData(1, (Object) null));
            this.f19980a.finish();
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupChatNoticeActivity f19981b;

        public c(GroupChatNoticeActivity groupChatNoticeActivity) {
            this.f19981b = groupChatNoticeActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
            r3 = r3.toString();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void afterTextChanged(android.text.Editable r3) {
            /*
                r2 = this;
                com.hbg.module.huobi.im.group.ui.GroupChatNoticeActivity r3 = r2.f19981b
                androidx.appcompat.widget.AppCompatEditText r3 = r3.f19967h
                r0 = 0
                if (r3 != 0) goto L_0x000a
                r3 = r0
            L_0x000a:
                android.text.Editable r3 = r3.getText()
                if (r3 == 0) goto L_0x001f
                java.lang.String r3 = r3.toString()
                if (r3 == 0) goto L_0x001f
                java.lang.CharSequence r3 = kotlin.text.StringsKt__StringsKt.i1(r3)
                java.lang.String r3 = r3.toString()
                goto L_0x0020
            L_0x001f:
                r3 = r0
            L_0x0020:
                if (r3 == 0) goto L_0x004c
                int r3 = r3.length()
                if (r3 != 0) goto L_0x0029
                goto L_0x004c
            L_0x0029:
                com.hbg.module.huobi.im.group.ui.GroupChatNoticeActivity r3 = r2.f19981b
                int r1 = com.hbg.module.huobi.im.R$color.color_12B298
                int r3 = androidx.core.content.ContextCompat.getColor(r3, r1)
                com.hbg.module.huobi.im.group.ui.GroupChatNoticeActivity r1 = r2.f19981b
                androidx.appcompat.widget.AppCompatTextView r1 = r1.f19966g
                if (r1 != 0) goto L_0x003a
                r1 = r0
            L_0x003a:
                r1.setTextColor(r3)
                com.hbg.module.huobi.im.group.ui.GroupChatNoticeActivity r3 = r2.f19981b
                androidx.appcompat.widget.AppCompatTextView r3 = r3.f19966g
                if (r3 != 0) goto L_0x0046
                goto L_0x0047
            L_0x0046:
                r0 = r3
            L_0x0047:
                r3 = 1
                r0.setClickable(r3)
                goto L_0x006e
            L_0x004c:
                com.hbg.module.huobi.im.group.ui.GroupChatNoticeActivity r3 = r2.f19981b
                int r1 = com.hbg.module.huobi.im.R$color.color_909090
                int r3 = androidx.core.content.ContextCompat.getColor(r3, r1)
                com.hbg.module.huobi.im.group.ui.GroupChatNoticeActivity r1 = r2.f19981b
                androidx.appcompat.widget.AppCompatTextView r1 = r1.f19966g
                if (r1 != 0) goto L_0x005d
                r1 = r0
            L_0x005d:
                r1.setTextColor(r3)
                com.hbg.module.huobi.im.group.ui.GroupChatNoticeActivity r3 = r2.f19981b
                androidx.appcompat.widget.AppCompatTextView r3 = r3.f19966g
                if (r3 != 0) goto L_0x0069
                goto L_0x006a
            L_0x0069:
                r0 = r3
            L_0x006a:
                r3 = 0
                r0.setClickable(r3)
            L_0x006e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.GroupChatNoticeActivity.c.afterTextChanged(android.text.Editable):void");
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public static final class d extends BaseSubscriber<HbgIntCodeResponse<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupChatNoticeActivity f19982b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f19983c;

        public d(GroupChatNoticeActivity groupChatNoticeActivity, String str) {
            this.f19982b = groupChatNoticeActivity;
            this.f19983c = str;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<String> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            this.f19982b.dismissProgressDialog();
            int code = hbgIntCodeResponse.getCode();
            if (code == 200) {
                this.f19982b.getIntent().putExtra("noticeText", this.f19983c);
                GroupChatNoticeActivity groupChatNoticeActivity = this.f19982b;
                groupChatNoticeActivity.setResult(-1, groupChatNoticeActivity.getIntent());
                ImObserverHelper.b().a(new OberverData(1, (Object) null));
                this.f19982b.finish();
            } else if (code != 2002) {
                ToastUtil.toastShortMessage(hbgIntCodeResponse.getMessage());
            } else {
                ToastUtil.toastShortMessage(this.f19982b.getResources().getString(R$string.n_im_group_notice_limited));
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f19982b.dismissProgressDialog();
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19984b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19985c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f19986d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f19987e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GroupChatNoticeActivity f19988f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f19989g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f19990h;

        public e(View view, long j11, Dialog dialog, GroupNoticeItemEntity groupNoticeItemEntity, GroupChatNoticeActivity groupChatNoticeActivity, Ref$ObjectRef ref$ObjectRef, Ref$BooleanRef ref$BooleanRef) {
            this.f19984b = view;
            this.f19985c = j11;
            this.f19986d = dialog;
            this.f19987e = groupNoticeItemEntity;
            this.f19988f = groupChatNoticeActivity;
            this.f19989g = ref$ObjectRef;
            this.f19990h = ref$BooleanRef;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            ld.f Qg;
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19984b) > this.f19985c || (this.f19984b instanceof Checkable)) {
                sVar.e(this.f19984b, currentTimeMillis);
                TextView textView = (TextView) this.f19984b;
                this.f19986d.dismiss();
                String groupId = this.f19987e.getGroupId();
                if (!(groupId == null || (Qg = this.f19988f.f19978s) == null)) {
                    Qg.t(groupId, String.valueOf(this.f19987e.getId()), (String) this.f19989g.element, new h(this.f19990h, this.f19988f, this.f19987e));
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19991b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19992c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f19993d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f19994e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GroupChatNoticeActivity f19995f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f19996g;

        public f(View view, long j11, Dialog dialog, View view2, GroupChatNoticeActivity groupChatNoticeActivity, GroupNoticeItemEntity groupNoticeItemEntity) {
            this.f19991b = view;
            this.f19992c = j11;
            this.f19993d = dialog;
            this.f19994e = view2;
            this.f19995f = groupChatNoticeActivity;
            this.f19996g = groupNoticeItemEntity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19991b) > this.f19992c || (this.f19991b instanceof Checkable)) {
                sVar.e(this.f19991b, currentTimeMillis);
                TextView textView = (TextView) this.f19991b;
                this.f19993d.dismiss();
                new nd.b(this.f19994e.getContext()).a().c(true).b(true).j(20.0f).d(this.f19994e.getContext().getString(R$string.n_im_delete_notice_hint)).e(0.75f).h(this.f19994e.getContext().getString(R$string.n_sure), new i(this.f19995f, this.f19996g)).g(this.f19994e.getContext().getString(R$string.n_cancel), j.f20005b).k();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19997b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19998c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f19999d;

        public g(View view, long j11, Dialog dialog) {
            this.f19997b = view;
            this.f19998c = j11;
            this.f19999d = dialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19997b) > this.f19998c || (this.f19997b instanceof Checkable)) {
                sVar.e(this.f19997b, currentTimeMillis);
                this.f19999d.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class h implements kd.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f20000a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupChatNoticeActivity f20001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f20002c;

        public h(Ref$BooleanRef ref$BooleanRef, GroupChatNoticeActivity groupChatNoticeActivity, GroupNoticeItemEntity groupNoticeItemEntity) {
            this.f20000a = ref$BooleanRef;
            this.f20001b = groupChatNoticeActivity;
            this.f20002c = groupNoticeItemEntity;
        }

        public void onFailed(int i11, String str) {
            HuobiToastUtil.j(R$string.n_im_operation_fail);
        }

        public void onSuccess(Object obj) {
            if (this.f20000a.element) {
                TextView ph2 = this.f20001b.f19973n;
                if (ph2 == null) {
                    ph2 = null;
                }
                ph2.setVisibility(8);
                HuobiToastUtil.j(R$string.n_im_cancel_notice_top_success);
                this.f20002c.setRecommend("0");
            } else {
                this.f20002c.setRecommend("1");
                TextView ph3 = this.f20001b.f19973n;
                if (ph3 == null) {
                    ph3 = null;
                }
                ph3.setVisibility(0);
                HuobiToastUtil.j(R$string.n_im_setting_notice_top_success);
            }
            ImObserverHelper.b().a(new OberverData(1, (Object) null));
        }
    }

    public static final class i implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupChatNoticeActivity f20003b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f20004c;

        public i(GroupChatNoticeActivity groupChatNoticeActivity, GroupNoticeItemEntity groupNoticeItemEntity) {
            this.f20003b = groupChatNoticeActivity;
            this.f20004c = groupNoticeItemEntity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            this.f20003b.qh(this.f20004c);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class j implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final j f20005b = new j();

        @SensorsDataInstrumented
        public final void onClick(View view) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final void rh(GroupChatNoticeActivity groupChatNoticeActivity, String str) {
        TUIChatLog.i("GroupChatNoticeActivity", "onClickUrl: url:" + str);
        HBBaseWebActivity.showWebView(groupChatNoticeActivity, str, "", "", false);
    }

    public static final void xh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
    }

    public static final void yh(GroupChatNoticeActivity groupChatNoticeActivity, String str, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        groupChatNoticeActivity.th(str);
    }

    public final void Ah() {
        AppCompatEditText appCompatEditText = this.f19967h;
        CharSequence charSequence = null;
        if (appCompatEditText == null) {
            appCompatEditText = null;
        }
        Editable text = appCompatEditText.getText();
        if (text != null) {
            charSequence = StringsKt__StringsKt.i1(text);
        }
        wh(String.valueOf(charSequence));
    }

    public final void initData() {
        TextView textView = null;
        if (this.f19977r) {
            zh();
            AppCompatEditText appCompatEditText = this.f19967h;
            if (appCompatEditText == null) {
                appCompatEditText = null;
            }
            appCompatEditText.setHint(R$string.n_im_input_notice_content);
            AppCompatTextView appCompatTextView = this.f19966g;
            if (appCompatTextView == null) {
                appCompatTextView = null;
            }
            appCompatTextView.setVisibility(0);
            ImageView imageView = this.f19969j;
            if (imageView == null) {
                imageView = null;
            }
            imageView.setVisibility(8);
            View view = this.f19974o;
            if (view == null) {
                view = null;
            }
            view.setVisibility(8);
            TextView textView2 = this.f19975p;
            if (textView2 != null) {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.f19975p;
        if (textView3 == null) {
            textView3 = null;
        }
        textView3.setVisibility(0);
        AppCompatEditText appCompatEditText2 = this.f19967h;
        if (appCompatEditText2 == null) {
            appCompatEditText2 = null;
        }
        appCompatEditText2.setVisibility(8);
        AppCompatTextView appCompatTextView2 = this.f19966g;
        if (appCompatTextView2 == null) {
            appCompatTextView2 = null;
        }
        appCompatTextView2.setVisibility(8);
        if (this.f19964e) {
            ImageView imageView2 = this.f19969j;
            if (imageView2 == null) {
                imageView2 = null;
            }
            imageView2.setVisibility(0);
        } else {
            ImageView imageView3 = this.f19969j;
            if (imageView3 == null) {
                imageView3 = null;
            }
            imageView3.setVisibility(8);
        }
        View view2 = this.f19974o;
        if (view2 == null) {
            view2 = null;
        }
        view2.setVisibility(0);
        uh();
        GroupNoticeItemEntity groupNoticeItemEntity = this.f19976q;
        if (groupNoticeItemEntity != null) {
            TextView textView4 = this.f19975p;
            if (textView4 == null) {
                textView4 = null;
            }
            textView4.setText(groupNoticeItemEntity.getNotification());
        }
        LinkMovementMethodInterceptor linkMovementMethodInterceptor = new LinkMovementMethodInterceptor();
        u a11 = u.a(this);
        TextView textView5 = this.f19975p;
        if (textView5 == null) {
            textView5 = null;
        }
        a11.c(textView5);
        linkMovementMethodInterceptor.a(new u(this));
        TextView textView6 = this.f19975p;
        if (textView6 != null) {
            textView = textView6;
        }
        textView.setMovementMethod(linkMovementMethodInterceptor);
    }

    public final void initExtra() {
        String stringExtra = getIntent().getStringExtra("noticeText");
        String str = "";
        if (stringExtra == null) {
            stringExtra = str;
        }
        this.f19963d = stringExtra;
        this.f19964e = getIntent().getBooleanExtra("isAdmin", false);
        String stringExtra2 = getIntent().getStringExtra("groupId");
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        this.f19965f = str;
        this.f19976q = (GroupNoticeItemEntity) getIntent().getSerializableExtra("noticeItemData");
        this.f19977r = getIntent().getBooleanExtra("noticeEditMode", false);
    }

    public final void initView() {
        this.f19968i = (AppCompatImageView) findViewById(R$id.iv_back);
        this.f19966g = (AppCompatTextView) findViewById(R$id.tv_action_right);
        this.f19967h = (AppCompatEditText) findViewById(R$id.aet_public_notice);
        this.f19969j = (ImageView) findViewById(R$id.iv_more);
        this.f19970k = (AvatarView) findViewById(R$id.iv_user_icon);
        this.f19971l = (TextView) findViewById(R$id.tv_name);
        this.f19972m = (TextView) findViewById(R$id.tv_time);
        this.f19973n = (TextView) findViewById(R$id.tv_top_tag);
        this.f19974o = findViewById(R$id.v_user_info);
        this.f19975p = (TextView) findViewById(R$id.tv_notice_content);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        GroupNoticeItemEntity groupNoticeItemEntity;
        int id2 = view.getId();
        if (id2 == R$id.iv_back) {
            finish();
        } else if (id2 == R$id.tv_action_right) {
            Ah();
        } else if (id2 == R$id.iv_more && (groupNoticeItemEntity = this.f19976q) != null) {
            vh(groupNoticeItemEntity);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R$color.baseColorDeepestBackground));
            getWindow().setNavigationBarColor(getResources().getColor(R$color.white_day_black_night_color));
            Xf(this, !NightHelper.e().g());
        }
        setContentView(R$layout.activity_public_notice);
        this.f19978s = new ld.f((ld.e) null);
        this.f19979t = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        initExtra();
        initView();
        sh();
        initData();
    }

    public final void qh(GroupNoticeItemEntity groupNoticeItemEntity) {
        ld.f fVar;
        String groupId = groupNoticeItemEntity.getGroupId();
        if (groupId != null && (fVar = this.f19978s) != null) {
            fVar.s(groupId, String.valueOf(groupNoticeItemEntity.getId()), new b(this));
        }
    }

    public final void sh() {
        s sVar = s.f23381a;
        AppCompatImageView appCompatImageView = this.f19968i;
        AppCompatEditText appCompatEditText = null;
        s.l(sVar, appCompatImageView == null ? null : appCompatImageView, this, 0, 2, (Object) null);
        AppCompatTextView appCompatTextView = this.f19966g;
        s.l(sVar, appCompatTextView == null ? null : appCompatTextView, this, 0, 2, (Object) null);
        ImageView imageView = this.f19969j;
        s.l(sVar, imageView == null ? null : imageView, this, 0, 2, (Object) null);
        AppCompatEditText appCompatEditText2 = this.f19967h;
        if (appCompatEditText2 != null) {
            appCompatEditText = appCompatEditText2;
        }
        appCompatEditText.addTextChangedListener(new c(this));
    }

    public final void th(String str) {
        showProgressDialog();
        IHbgApi a11 = v7.b.a();
        String str2 = this.f19965f;
        if (str2 == null) {
            str2 = null;
        }
        a11.x0(str2, str).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new d(this, str));
    }

    public final void uh() {
        GroupNoticeItemEntity groupNoticeItemEntity = this.f19976q;
        if (groupNoticeItemEntity != null) {
            GroupNoticeUserInfoEntity userInfo = groupNoticeItemEntity.getUserInfo();
            int i11 = 0;
            String str = null;
            if (userInfo != null) {
                AvatarView avatarView = this.f19970k;
                if (avatarView == null) {
                    avatarView = null;
                }
                AvatarView.x(avatarView, userInfo.getAvatar(), 0, 2, (Object) null);
                TextView textView = this.f19971l;
                if (textView == null) {
                    textView = null;
                }
                textView.setText(userInfo.getNickname());
            }
            boolean equals = TextUtils.equals(groupNoticeItemEntity.getRecommend(), "1");
            TextView textView2 = this.f19973n;
            if (textView2 == null) {
                textView2 = null;
            }
            if (!equals) {
                i11 = 8;
            }
            textView2.setVisibility(i11);
            Long createTime = groupNoticeItemEntity.getCreateTime();
            Date date = createTime != null ? new Date(createTime.longValue()) : null;
            TextView textView3 = this.f19972m;
            if (textView3 == null) {
                textView3 = null;
            }
            SimpleDateFormat simpleDateFormat = this.f19979t;
            if (simpleDateFormat != null) {
                str = simpleDateFormat.format(date);
            }
            textView3.setText(str);
        }
    }

    public final void vh(GroupNoticeItemEntity groupNoticeItemEntity) {
        String str;
        Dialog dialog = new Dialog(this, R$style.BottomDialog);
        View inflate = View.inflate(this, R$layout.dialog_group_notice_item, (ViewGroup) null);
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
            str = getString(R$string.n_content_live_un_pin);
        } else {
            str = getString(R$string.n_im_setting_notice_top);
        }
        textView.setText(str);
        s sVar = s.f23381a;
        Dialog dialog2 = dialog;
        textView.setOnClickListener(new e(textView, 800, dialog2, groupNoticeItemEntity, this, ref$ObjectRef, ref$BooleanRef));
        TextView textView2 = (TextView) dialog.findViewById(R$id.tv_delete_notice);
        textView2.setOnClickListener(new f(textView2, 800, dialog2, inflate, this, groupNoticeItemEntity));
        View findViewById = dialog.findViewById(R$id.tv_cancel);
        findViewById.setOnClickListener(new g(findViewById, 800, dialog));
    }

    public final void wh(String str) {
        if (TextUtils.isEmpty(str)) {
            ToastUtil.toastShortMessage(getResources().getString(R$string.n_im_group_notice_content_push));
            return;
        }
        DialogUtils.c0(this, getString(R$string.n_im_group_noti_publish), (String) null, getString(R$string.n_cancel), getString(R$string.n_confirm), t.f20494a, new s(this, str));
    }

    public final void zh() {
        AppCompatEditText appCompatEditText = this.f19967h;
        AppCompatEditText appCompatEditText2 = null;
        if (appCompatEditText == null) {
            appCompatEditText = null;
        }
        appCompatEditText.setEnabled(true);
        AppCompatEditText appCompatEditText3 = this.f19967h;
        if (appCompatEditText3 == null) {
            appCompatEditText3 = null;
        }
        appCompatEditText3.setFocusable(true);
        AppCompatEditText appCompatEditText4 = this.f19967h;
        if (appCompatEditText4 == null) {
            appCompatEditText4 = null;
        }
        appCompatEditText4.setFocusableInTouchMode(true);
        AppCompatEditText appCompatEditText5 = this.f19967h;
        if (appCompatEditText5 != null) {
            appCompatEditText2 = appCompatEditText5;
        }
        appCompatEditText2.requestFocus();
    }
}
