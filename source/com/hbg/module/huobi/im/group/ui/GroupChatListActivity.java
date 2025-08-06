package com.hbg.module.huobi.im.group.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.network.hbg.core.bean.ChatSessionRemove;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.group.bean.ImGroupChatBean;
import com.hbg.module.huobi.im.group.bean.ImGroupChatItemBean;
import com.hbg.module.huobi.im.group.ui.adapter.GroupChatListMyAdapter;
import com.hbg.module.huobi.im.group.view.ChatListMoreDialog;
import com.hbg.module.huobi.im.group.view.SlideRecyclerView;
import com.huobi.framework.im.common.ImCommonCallback;
import com.huobi.framework.im.common.ImManager;
import com.huobi.utils.StatusBarUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMConversationResult;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import java.util.ArrayList;
import java.util.List;
import ky.j;
import rd.s;
import z9.g1;

public final class GroupChatListActivity extends AppCompatActivity implements ld.d, ny.d {

    /* renamed from: b  reason: collision with root package name */
    public SmartRefreshLayout f19934b;

    /* renamed from: c  reason: collision with root package name */
    public SlideRecyclerView f19935c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f19936d;

    /* renamed from: e  reason: collision with root package name */
    public Group f19937e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19938f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19939g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f19940h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<V2TIMConversation> f19941i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    public GroupChatListMyAdapter f19942j;

    /* renamed from: k  reason: collision with root package name */
    public final ld.b f19943k = new ld.b(this);

    /* renamed from: l  reason: collision with root package name */
    public long f19944l;

    /* renamed from: m  reason: collision with root package name */
    public ChatSessionRemove f19945m;

    /* renamed from: n  reason: collision with root package name */
    public Handler f19946n;

    /* renamed from: o  reason: collision with root package name */
    public g1 f19947o;

    public static final class a extends BaseSubscriber<ChatSessionRemove> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupChatListActivity f19948b;

        public a(GroupChatListActivity groupChatListActivity) {
            this.f19948b = groupChatListActivity;
        }

        /* renamed from: a */
        public void onNext(ChatSessionRemove chatSessionRemove) {
            super.onNext(chatSessionRemove);
            this.f19948b.f19945m = chatSessionRemove;
            this.f19948b.yh();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                HuobiToastUtil.i(((APIStatusErrorException) th2).getErrMsg());
            } else {
                HuobiToastUtil.g(R$string.n_service_error);
            }
            this.f19948b.yh();
        }
    }

    public static final class b implements V2TIMValueCallback<V2TIMConversationResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupChatListActivity f19949a;

        public b(GroupChatListActivity groupChatListActivity) {
            this.f19949a = groupChatListActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.constraintlayout.widget.Group} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.constraintlayout.widget.Group} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: androidx.constraintlayout.widget.Group} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v2 */
        /* JADX WARNING: type inference failed for: r1v4 */
        /* JADX WARNING: type inference failed for: r1v5, types: [com.scwang.smartrefresh.layout.SmartRefreshLayout] */
        /* JADX WARNING: type inference failed for: r1v6 */
        /* JADX WARNING: type inference failed for: r1v8 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSuccess(com.tencent.imsdk.v2.V2TIMConversationResult r10) {
            /*
                r9 = this;
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r0 = r9.f19949a
                r0.sh()
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r0 = r9.f19949a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r0.f19934b
                r1 = 0
                if (r0 != 0) goto L_0x000f
                r0 = r1
            L_0x000f:
                r0.finishRefresh()
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r0 = r9.f19949a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r0.f19934b
                if (r0 != 0) goto L_0x001b
                r0 = r1
            L_0x001b:
                r0.w()
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r0 = r9.f19949a
                long r2 = r0.f19944l
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 != 0) goto L_0x0033
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r0 = r9.f19949a
                java.util.ArrayList r0 = r0.xh()
                r0.clear()
            L_0x0033:
                if (r10 == 0) goto L_0x003a
                java.util.List r0 = r10.getConversationList()
                goto L_0x003b
            L_0x003a:
                r0 = r1
            L_0x003b:
                r2 = 1
                r3 = 0
                if (r0 == 0) goto L_0x0048
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x0046
                goto L_0x0048
            L_0x0046:
                r0 = r3
                goto L_0x0049
            L_0x0048:
                r0 = r2
            L_0x0049:
                r6 = 8
                if (r0 == 0) goto L_0x009c
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                long r7 = r10.f19944l
                int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
                if (r10 != 0) goto L_0x008e
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                android.widget.ImageView r10 = r10.f19938f
                if (r10 != 0) goto L_0x0060
                r10 = r1
            L_0x0060:
                r10.setVisibility(r6)
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r10 = r10.f19934b
                if (r10 != 0) goto L_0x006c
                r10 = r1
            L_0x006c:
                r10.setVisibility(r6)
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                androidx.constraintlayout.widget.Group r10 = r10.f19937e
                if (r10 != 0) goto L_0x0078
                goto L_0x0079
            L_0x0078:
                r1 = r10
            L_0x0079:
                r1.setVisibility(r3)
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                ld.b r10 = r10.f19943k
                com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
                java.lang.String r0 = r0.getUid()
                r10.a(r0)
                goto L_0x009b
            L_0x008e:
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r10 = r10.f19934b
                if (r10 != 0) goto L_0x0097
                goto L_0x0098
            L_0x0097:
                r1 = r10
            L_0x0098:
                r1.e()
            L_0x009b:
                return
            L_0x009c:
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r0 = r9.f19949a
                if (r10 == 0) goto L_0x00a4
                long r4 = r10.getNextSeq()
            L_0x00a4:
                r0.f19944l = r4
                if (r10 == 0) goto L_0x00e9
                java.util.List r10 = r10.getConversationList()
                if (r10 == 0) goto L_0x00e9
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r0 = r9.f19949a
                java.util.Iterator r10 = r10.iterator()
            L_0x00b5:
                boolean r4 = r10.hasNext()
                if (r4 == 0) goto L_0x00e9
                java.lang.Object r4 = r10.next()
                com.tencent.imsdk.v2.V2TIMConversation r4 = (com.tencent.imsdk.v2.V2TIMConversation) r4
                int r5 = r4.getType()
                if (r5 != r2) goto L_0x00cc
                java.lang.String r5 = r4.getUserID()
                goto L_0x00d0
            L_0x00cc:
                java.lang.String r5 = r4.getGroupID()
            L_0x00d0:
                com.hbg.lib.network.hbg.core.bean.ChatSessionRemove r7 = r0.f19945m
                if (r7 == 0) goto L_0x00de
                boolean r5 = r7.hasRemove(r5)
                if (r5 != 0) goto L_0x00de
                r5 = r2
                goto L_0x00df
            L_0x00de:
                r5 = r3
            L_0x00df:
                if (r5 == 0) goto L_0x00b5
                java.util.ArrayList r5 = r0.xh()
                r5.add(r4)
                goto L_0x00b5
            L_0x00e9:
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                java.util.ArrayList r10 = r10.xh()
                if (r10 == 0) goto L_0x00f9
                boolean r10 = r10.isEmpty()
                if (r10 == 0) goto L_0x00f8
                goto L_0x00f9
            L_0x00f8:
                r2 = r3
            L_0x00f9:
                if (r2 != 0) goto L_0x012c
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                com.hbg.module.huobi.im.group.ui.adapter.GroupChatListMyAdapter r10 = r10.f19942j
                if (r10 == 0) goto L_0x0106
                r10.notifyDataSetChanged()
            L_0x0106:
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r10 = r10.f19934b
                if (r10 != 0) goto L_0x010f
                r10 = r1
            L_0x010f:
                r10.setVisibility(r3)
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                android.widget.ImageView r10 = r10.f19938f
                if (r10 != 0) goto L_0x011b
                r10 = r1
            L_0x011b:
                r10.setVisibility(r3)
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                androidx.constraintlayout.widget.Group r10 = r10.f19937e
                if (r10 != 0) goto L_0x0127
                goto L_0x0128
            L_0x0127:
                r1 = r10
            L_0x0128:
                r1.setVisibility(r6)
                goto L_0x0162
            L_0x012c:
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                android.widget.ImageView r10 = r10.f19938f
                if (r10 != 0) goto L_0x0135
                r10 = r1
            L_0x0135:
                r10.setVisibility(r6)
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r10 = r10.f19934b
                if (r10 != 0) goto L_0x0141
                r10 = r1
            L_0x0141:
                r10.setVisibility(r6)
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                androidx.constraintlayout.widget.Group r10 = r10.f19937e
                if (r10 != 0) goto L_0x014d
                goto L_0x014e
            L_0x014d:
                r1 = r10
            L_0x014e:
                r1.setVisibility(r3)
                com.hbg.module.huobi.im.group.ui.GroupChatListActivity r10 = r9.f19949a
                ld.b r10 = r10.f19943k
                com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
                java.lang.String r0 = r0.getUid()
                r10.a(r0)
            L_0x0162:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.GroupChatListActivity.b.onSuccess(com.tencent.imsdk.v2.V2TIMConversationResult):void");
        }

        public void onError(int i11, String str) {
            this.f19949a.sh();
            SmartRefreshLayout Pg = this.f19949a.f19934b;
            Group group = null;
            if (Pg == null) {
                Pg = null;
            }
            Pg.finishRefresh();
            SmartRefreshLayout Pg2 = this.f19949a.f19934b;
            if (Pg2 == null) {
                Pg2 = null;
            }
            Pg2.w();
            ImageView Qg = this.f19949a.f19938f;
            if (Qg == null) {
                Qg = null;
            }
            Qg.setVisibility(8);
            SmartRefreshLayout Pg3 = this.f19949a.f19934b;
            if (Pg3 == null) {
                Pg3 = null;
            }
            Pg3.setVisibility(8);
            Group oh2 = this.f19949a.f19937e;
            if (oh2 != null) {
                group = oh2;
            }
            group.setVisibility(0);
            this.f19949a.f19943k.a(BaseModuleConfig.a().getUid());
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19950b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19951c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ GroupChatListActivity f19952d;

        public c(View view, long j11, GroupChatListActivity groupChatListActivity) {
            this.f19950b = view;
            this.f19951c = j11;
            this.f19952d = groupChatListActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19950b) > this.f19951c || (this.f19950b instanceof Checkable)) {
                sVar.e(this.f19950b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f19950b;
                this.f19952d.Ih();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements ImCommonCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupChatListActivity f19953a;

        public d(GroupChatListActivity groupChatListActivity) {
            this.f19953a = groupChatListActivity;
        }

        public void onFailed(int i11, String str) {
            ToastUtil.toastShortMessage(str);
        }

        public void onSuccess() {
            GroupChatListMyAdapter fg2 = this.f19953a.f19942j;
            if (fg2 != null) {
                fg2.notifyDataSetChanged();
            }
        }
    }

    @SensorsDataInstrumented
    public static final void Ah(GroupChatListActivity groupChatListActivity, View view) {
        new nd.b(groupChatListActivity).a().c(true).b(true).d(groupChatListActivity.getString(R$string.n_im_affirm_all_read)).e(0.9f).h(groupChatListActivity.getString(R$string.n_sure), new n(groupChatListActivity)).g(groupChatListActivity.getString(R$string.n_cancel), o.f20487b).k();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Bh(GroupChatListActivity groupChatListActivity, View view) {
        ImManager.INSTANCE.markAllMessageAsRead(new d(groupChatListActivity));
    }

    public static final void Ch(View view) {
    }

    public static /* synthetic */ void Gh(GroupChatListActivity groupChatListActivity, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        groupChatListActivity.Fh(z11);
    }

    public static final void Hh(GroupChatListActivity groupChatListActivity, boolean z11) {
        if (!groupChatListActivity.isFinishing()) {
            if (groupChatListActivity.f19947o == null) {
                groupChatListActivity.f19947o = new g1(groupChatListActivity);
            }
            g1 g1Var = groupChatListActivity.f19947o;
            if (g1Var != null) {
                g1Var.show();
            }
            g1 g1Var2 = groupChatListActivity.f19947o;
            if (g1Var2 != null) {
                g1Var2.setCanceledOnTouchOutside(z11);
            }
            g1 g1Var3 = groupChatListActivity.f19947o;
            if (g1Var3 != null) {
                g1Var3.setCancelable(z11);
            }
        }
    }

    public static final void th(GroupChatListActivity groupChatListActivity) {
        g1 g1Var;
        if (!groupChatListActivity.isFinishing()) {
            g1 g1Var2 = groupChatListActivity.f19947o;
            boolean z11 = true;
            if (g1Var2 == null || !g1Var2.isShowing()) {
                z11 = false;
            }
            if (z11 && (g1Var = groupChatListActivity.f19947o) != null) {
                g1Var.dismiss();
            }
        }
    }

    @SensorsDataInstrumented
    public static final void zh(GroupChatListActivity groupChatListActivity, View view) {
        groupChatListActivity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Dh(ImageView imageView) {
        this.f19939g = imageView;
    }

    public final void Eh(ImageView imageView) {
        this.f19940h = imageView;
    }

    public final void Fh(boolean z11) {
        Handler handler = this.f19946n;
        if (handler != null) {
            handler.post(new q(this, z11));
        }
    }

    public final void Ih() {
        new ChatListMoreDialog().show(getSupportFragmentManager(), "");
    }

    public void P8(j jVar) {
        yh();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(AppLanguageHelper.getInstance().attachBaseContext(context));
    }

    public void bf(j jVar) {
        SmartRefreshLayout smartRefreshLayout = this.f19934b;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.g(true);
        this.f19944l = 0;
        uh();
    }

    public void l9(ImGroupChatBean imGroupChatBean) {
        List<ImGroupChatItemBean> listData = imGroupChatBean.getListData();
        if (!(listData == null || listData.isEmpty())) {
            RecyclerView recyclerView = this.f19936d;
            if (recyclerView == null) {
                recyclerView = null;
            }
            recyclerView.setAdapter(new com.hbg.module.huobi.im.group.ui.adapter.d(this, imGroupChatBean.getListData()));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19946n = new Handler(getMainLooper());
        s.f23381a.n(getWindow(), false);
        getWindow().getDecorView().setSystemUiVisibility(9216);
        setContentView(R$layout.activity_goup_chat_list);
        ((ConstraintLayout.LayoutParams) ((RelativeLayout) findViewById(R$id.titleBar)).getLayoutParams()).setMargins(0, StatusBarUtils.a(this), 0, 0);
        Dh((ImageView) findViewById(R$id.iv_group_list_back));
        Eh((ImageView) findViewById(R$id.iv_more));
        this.f19938f = (ImageView) findViewById(R$id.all_read);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById(R$id.sflChatList);
        this.f19934b = smartRefreshLayout;
        ImageView imageView = null;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.j0(new SmartRefreshHeader(this));
        SmartRefreshLayout smartRefreshLayout2 = this.f19934b;
        if (smartRefreshLayout2 == null) {
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.h0(new SmartRefreshFooter(this));
        SmartRefreshLayout smartRefreshLayout3 = this.f19934b;
        if (smartRefreshLayout3 == null) {
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.e0(this);
        this.f19935c = (SlideRecyclerView) findViewById(R$id.rv_group_chat_list);
        this.f19942j = new GroupChatListMyAdapter(this, this.f19941i);
        SlideRecyclerView slideRecyclerView = this.f19935c;
        if (slideRecyclerView == null) {
            slideRecyclerView = null;
        }
        slideRecyclerView.setAdapter(this.f19942j);
        vh().setOnClickListener(new m(this));
        ImageView wh2 = wh();
        wh2.setOnClickListener(new c(wh2, 800, this));
        ImageView imageView2 = this.f19938f;
        if (imageView2 != null) {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new l(this));
        this.f19936d = (RecyclerView) findViewById(R$id.rv_group_chat_list_all);
        this.f19937e = (Group) findViewById(R$id.vChatEmptyGroup);
    }

    public void onResume() {
        super.onResume();
        SmartRefreshLayout smartRefreshLayout = this.f19934b;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.g(true);
        this.f19944l = 0;
        uh();
    }

    public void onStart() {
        super.onStart();
    }

    public final void sh() {
        Handler handler = this.f19946n;
        if (handler != null) {
            handler.post(new p(this));
        }
    }

    public final void uh() {
        Gh(this, false, 1, (Object) null);
        v7.b.a().getChatSessionRemove().b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new a(this));
    }

    public final ImageView vh() {
        ImageView imageView = this.f19939g;
        if (imageView != null) {
            return imageView;
        }
        return null;
    }

    public final ImageView wh() {
        ImageView imageView = this.f19940h;
        if (imageView != null) {
            return imageView;
        }
        return null;
    }

    public final ArrayList<V2TIMConversation> xh() {
        return this.f19941i;
    }

    public final void yh() {
        ImManager.INSTANCE.getConversationList(this.f19944l, 100, new b(this));
    }
}
