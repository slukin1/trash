package com.huobi.message.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.ChatSessionRemove;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.IMConversationHelper;
import com.hbg.module.huobi.im.group.bean.ImGroupChatBean;
import com.hbg.module.huobi.im.group.bean.ImGroupChatItemBean;
import com.hbg.module.huobi.im.group.ui.adapter.GroupChatListMyAdapter;
import com.hbg.module.huobi.im.group.view.SlideRecyclerView;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.huobi.framework.im.common.ImCommonCallback;
import com.huobi.framework.im.common.ImManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMConversationResult;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.r;
import ky.j;
import pro.huobi.R;
import z9.g1;

public final class GroupChatListFragment extends Fragment implements ld.d, ny.d {

    /* renamed from: m  reason: collision with root package name */
    public static final a f77964m = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public SmartRefreshLayout f77965b;

    /* renamed from: c  reason: collision with root package name */
    public SlideRecyclerView f77966c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f77967d;

    /* renamed from: e  reason: collision with root package name */
    public Group f77968e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<V2TIMConversation> f77969f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public GroupChatListMyAdapter f77970g;

    /* renamed from: h  reason: collision with root package name */
    public final ld.b f77971h = new ld.b(this);

    /* renamed from: i  reason: collision with root package name */
    public long f77972i;

    /* renamed from: j  reason: collision with root package name */
    public ChatSessionRemove f77973j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f77974k;

    /* renamed from: l  reason: collision with root package name */
    public g1 f77975l;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final GroupChatListFragment a() {
            GroupChatListFragment groupChatListFragment = new GroupChatListFragment();
            groupChatListFragment.setArguments(new Bundle());
            return groupChatListFragment;
        }
    }

    public static final class b extends BaseSubscriber<ChatSessionRemove> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupChatListFragment f77976b;

        public b(GroupChatListFragment groupChatListFragment) {
            this.f77976b = groupChatListFragment;
        }

        /* renamed from: a */
        public void onNext(ChatSessionRemove chatSessionRemove) {
            super.onNext(chatSessionRemove);
            this.f77976b.f77973j = chatSessionRemove;
            this.f77976b.Fh();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                HuobiToastUtil.i(((APIStatusErrorException) th2).getErrMsg());
            } else {
                HuobiToastUtil.g(R.string.n_service_error);
            }
            this.f77976b.Fh();
        }
    }

    public static final class c implements V2TIMValueCallback<V2TIMConversationResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupChatListFragment f77977a;

        public c(GroupChatListFragment groupChatListFragment) {
            this.f77977a = groupChatListFragment;
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
                com.huobi.message.ui.GroupChatListFragment r0 = r9.f77977a
                r0.Ah()
                com.huobi.message.ui.GroupChatListFragment r0 = r9.f77977a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r0.f77965b
                r1 = 0
                if (r0 != 0) goto L_0x000f
                r0 = r1
            L_0x000f:
                r0.finishRefresh()
                com.huobi.message.ui.GroupChatListFragment r0 = r9.f77977a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r0.f77965b
                if (r0 != 0) goto L_0x001b
                r0 = r1
            L_0x001b:
                r0.w()
                com.huobi.message.ui.GroupChatListFragment r0 = r9.f77977a
                long r2 = r0.f77972i
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 != 0) goto L_0x0033
                com.huobi.message.ui.GroupChatListFragment r0 = r9.f77977a
                java.util.ArrayList r0 = r0.Eh()
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
                if (r0 == 0) goto L_0x0090
                com.huobi.message.ui.GroupChatListFragment r10 = r9.f77977a
                long r7 = r10.f77972i
                int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
                if (r10 != 0) goto L_0x0082
                com.huobi.message.ui.GroupChatListFragment r10 = r9.f77977a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r10 = r10.f77965b
                if (r10 != 0) goto L_0x0060
                r10 = r1
            L_0x0060:
                r10.setVisibility(r6)
                com.huobi.message.ui.GroupChatListFragment r10 = r9.f77977a
                androidx.constraintlayout.widget.Group r10 = r10.f77968e
                if (r10 != 0) goto L_0x006c
                goto L_0x006d
            L_0x006c:
                r1 = r10
            L_0x006d:
                r1.setVisibility(r3)
                com.huobi.message.ui.GroupChatListFragment r10 = r9.f77977a
                ld.b r10 = r10.f77971h
                com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
                java.lang.String r0 = r0.getUid()
                r10.a(r0)
                goto L_0x008f
            L_0x0082:
                com.huobi.message.ui.GroupChatListFragment r10 = r9.f77977a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r10 = r10.f77965b
                if (r10 != 0) goto L_0x008b
                goto L_0x008c
            L_0x008b:
                r1 = r10
            L_0x008c:
                r1.e()
            L_0x008f:
                return
            L_0x0090:
                com.huobi.message.ui.GroupChatListFragment r0 = r9.f77977a
                if (r10 == 0) goto L_0x0098
                long r4 = r10.getNextSeq()
            L_0x0098:
                r0.f77972i = r4
                if (r10 == 0) goto L_0x00eb
                java.util.List r10 = r10.getConversationList()
                if (r10 == 0) goto L_0x00eb
                com.huobi.message.ui.GroupChatListFragment r0 = r9.f77977a
                java.util.Iterator r10 = r10.iterator()
                r4 = r3
            L_0x00aa:
                boolean r5 = r10.hasNext()
                if (r5 == 0) goto L_0x00ec
                java.lang.Object r5 = r10.next()
                com.tencent.imsdk.v2.V2TIMConversation r5 = (com.tencent.imsdk.v2.V2TIMConversation) r5
                int r7 = r5.getType()
                if (r7 != r2) goto L_0x00c1
                java.lang.String r7 = r5.getUserID()
                goto L_0x00c5
            L_0x00c1:
                java.lang.String r7 = r5.getGroupID()
            L_0x00c5:
                com.hbg.lib.network.hbg.core.bean.ChatSessionRemove r8 = r0.f77973j
                if (r8 == 0) goto L_0x00d3
                boolean r7 = r8.hasRemove(r7)
                if (r7 != 0) goto L_0x00d3
                r7 = r2
                goto L_0x00d4
            L_0x00d3:
                r7 = r3
            L_0x00d4:
                if (r7 == 0) goto L_0x00aa
                java.util.List r7 = r5.getGroupAtInfoList()
                int r7 = r7.size()
                if (r7 > 0) goto L_0x00e2
                if (r4 <= 0) goto L_0x00e3
            L_0x00e2:
                r4 = r2
            L_0x00e3:
                java.util.ArrayList r7 = r0.Eh()
                r7.add(r5)
                goto L_0x00aa
            L_0x00eb:
                r4 = r3
            L_0x00ec:
                com.huobi.message.ui.GroupChatListFragment r10 = r9.f77977a
                java.util.ArrayList r10 = r10.Eh()
                boolean r10 = com.hbg.module.libkt.base.ext.b.w(r10)
                if (r10 != 0) goto L_0x013f
                r10 = 2
                kotlin.Pair[] r10 = new kotlin.Pair[r10]
                java.lang.String r0 = "business_category"
                java.lang.String r5 = "chatlist"
                kotlin.Pair r0 = kotlin.l.a(r0, r5)
                r10[r3] = r0
                java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
                java.lang.String r4 = "exist_mention"
                kotlin.Pair r0 = kotlin.l.a(r4, r0)
                r10[r2] = r0
                java.util.HashMap r10 = kotlin.collections.MapsKt__MapsKt.j(r10)
                java.lang.String r0 = "pageview_app_activity"
                com.hbg.module.libkt.helper.SensorsDataHelper.track(r0, r10)
                com.huobi.message.ui.GroupChatListFragment r10 = r9.f77977a
                com.hbg.module.huobi.im.group.ui.adapter.GroupChatListMyAdapter r10 = r10.f77970g
                if (r10 == 0) goto L_0x0125
                r10.notifyDataSetChanged()
            L_0x0125:
                com.huobi.message.ui.GroupChatListFragment r10 = r9.f77977a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r10 = r10.f77965b
                if (r10 != 0) goto L_0x012e
                r10 = r1
            L_0x012e:
                r10.setVisibility(r3)
                com.huobi.message.ui.GroupChatListFragment r10 = r9.f77977a
                androidx.constraintlayout.widget.Group r10 = r10.f77968e
                if (r10 != 0) goto L_0x013a
                goto L_0x013b
            L_0x013a:
                r1 = r10
            L_0x013b:
                r1.setVisibility(r6)
                goto L_0x0169
            L_0x013f:
                com.huobi.message.ui.GroupChatListFragment r10 = r9.f77977a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r10 = r10.f77965b
                if (r10 != 0) goto L_0x0148
                r10 = r1
            L_0x0148:
                r10.setVisibility(r6)
                com.huobi.message.ui.GroupChatListFragment r10 = r9.f77977a
                androidx.constraintlayout.widget.Group r10 = r10.f77968e
                if (r10 != 0) goto L_0x0154
                goto L_0x0155
            L_0x0154:
                r1 = r10
            L_0x0155:
                r1.setVisibility(r3)
                com.huobi.message.ui.GroupChatListFragment r10 = r9.f77977a
                ld.b r10 = r10.f77971h
                com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
                java.lang.String r0 = r0.getUid()
                r10.a(r0)
            L_0x0169:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.message.ui.GroupChatListFragment.c.onSuccess(com.tencent.imsdk.v2.V2TIMConversationResult):void");
        }

        public void onError(int i11, String str) {
            this.f77977a.Ah();
            SmartRefreshLayout vh2 = this.f77977a.f77965b;
            Group group = null;
            if (vh2 == null) {
                vh2 = null;
            }
            vh2.finishRefresh();
            SmartRefreshLayout vh3 = this.f77977a.f77965b;
            if (vh3 == null) {
                vh3 = null;
            }
            vh3.w();
            SmartRefreshLayout vh4 = this.f77977a.f77965b;
            if (vh4 == null) {
                vh4 = null;
            }
            vh4.setVisibility(8);
            Group wh2 = this.f77977a.f77968e;
            if (wh2 != null) {
                group = wh2;
            }
            group.setVisibility(0);
            this.f77977a.f77971h.a(BaseModuleConfig.a().getUid());
        }
    }

    public static final class d implements ImCommonCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupChatListFragment f77978a;

        public d(GroupChatListFragment groupChatListFragment) {
            this.f77978a = groupChatListFragment;
        }

        public void onFailed(int i11, String str) {
        }

        public void onSuccess() {
            if (this.f77978a.getActivity() != null) {
                FragmentActivity activity = this.f77978a.getActivity();
                boolean z11 = false;
                if (activity != null && !activity.isFinishing()) {
                    z11 = true;
                }
                if (z11 && this.f77978a.f77965b != null) {
                    SmartRefreshLayout unused = this.f77978a.f77965b;
                    SmartRefreshLayout vh2 = this.f77978a.f77965b;
                    if (vh2 == null) {
                        vh2 = null;
                    }
                    vh2.t();
                }
            }
        }
    }

    public static final void Bh(GroupChatListFragment groupChatListFragment) {
        g1 g1Var;
        FragmentActivity activity = groupChatListFragment.getActivity();
        boolean z11 = true;
        if (activity != null && !activity.isFinishing()) {
            g1 g1Var2 = groupChatListFragment.f77975l;
            if (g1Var2 == null || !g1Var2.isShowing()) {
                z11 = false;
            }
            if (z11 && (g1Var = groupChatListFragment.f77975l) != null) {
                g1Var.dismiss();
            }
        }
    }

    public static final GroupChatListFragment Dh() {
        return f77964m.a();
    }

    public static /* synthetic */ void Ih(GroupChatListFragment groupChatListFragment, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        groupChatListFragment.Hh(z11);
    }

    public static final void Jh(GroupChatListFragment groupChatListFragment, boolean z11) {
        FragmentActivity activity = groupChatListFragment.getActivity();
        if (activity != null && !activity.isFinishing()) {
            if (groupChatListFragment.f77975l == null) {
                Context context = groupChatListFragment.getContext();
                groupChatListFragment.f77975l = context != null ? new g1(context) : null;
            }
            g1 g1Var = groupChatListFragment.f77975l;
            if (g1Var != null) {
                g1Var.show();
            }
            g1 g1Var2 = groupChatListFragment.f77975l;
            if (g1Var2 != null) {
                g1Var2.setCanceledOnTouchOutside(z11);
            }
            g1 g1Var3 = groupChatListFragment.f77975l;
            if (g1Var3 != null) {
                g1Var3.setCancelable(z11);
            }
        }
    }

    public final void Ah() {
        Handler handler = this.f77974k;
        if (handler != null) {
            handler.post(new ko.a(this));
        }
    }

    public final void Ch() {
        Ih(this, false, 1, (Object) null);
        v7.b.a().getChatSessionRemove().b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new b(this));
    }

    public final ArrayList<V2TIMConversation> Eh() {
        return this.f77969f;
    }

    public final void Fh() {
        ImManager.INSTANCE.getConversationList(this.f77972i, 100, new c(this));
    }

    public final void Gh() {
        ImManager.INSTANCE.markAllMessageAsRead(new d(this));
    }

    public final void Hh(boolean z11) {
        Handler handler = this.f77974k;
        if (handler != null) {
            handler.post(new ko.b(this, z11));
        }
    }

    public void P8(j jVar) {
        Fh();
    }

    public void bf(j jVar) {
        SmartRefreshLayout smartRefreshLayout = this.f77965b;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.g(true);
        this.f77972i = 0;
        Ch();
        SensorsDataHelper.track("messageCenter_view", new HashMap());
    }

    public void l9(ImGroupChatBean imGroupChatBean) {
        List<ImGroupChatItemBean> listData = imGroupChatBean.getListData();
        if (!(listData == null || listData.isEmpty()) && getContext() != null) {
            RecyclerView recyclerView = this.f77967d;
            if (recyclerView == null) {
                recyclerView = null;
            }
            recyclerView.setAdapter(new com.hbg.module.huobi.im.group.ui.adapter.d(getContext(), imGroupChatBean.getListData()));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_group_chat_list, viewGroup, false);
        this.f77965b = (SmartRefreshLayout) inflate.findViewById(R.id.sflChatList);
        this.f77966c = (SlideRecyclerView) inflate.findViewById(R.id.rv_group_chat_list);
        this.f77967d = (RecyclerView) inflate.findViewById(R.id.rv_group_chat_list_all);
        this.f77968e = (Group) inflate.findViewById(R.id.vChatEmptyGroup);
        return inflate;
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
        IMConversationHelper.o().l();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.getMainLooper();
     */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r5, android.os.Bundle r6) {
        /*
            r4 = this;
            super.onViewCreated(r5, r6)
            android.content.Context r0 = r4.getContext()
            r1 = 0
            if (r0 == 0) goto L_0x0016
            android.os.Looper r0 = r0.getMainLooper()
            if (r0 == 0) goto L_0x0016
            android.os.Handler r2 = new android.os.Handler
            r2.<init>(r0)
            goto L_0x0017
        L_0x0016:
            r2 = r1
        L_0x0017:
            r4.f77974k = r2
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r4.f77965b
            if (r0 != 0) goto L_0x001e
            r0 = r1
        L_0x001e:
            com.hbg.lib.core.page.SmartRefreshHeader r2 = new com.hbg.lib.core.page.SmartRefreshHeader
            android.content.Context r3 = r4.getContext()
            r2.<init>(r3)
            r0.j0(r2)
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r4.f77965b
            if (r0 != 0) goto L_0x002f
            r0 = r1
        L_0x002f:
            com.hbg.lib.core.page.SmartRefreshFooter r2 = new com.hbg.lib.core.page.SmartRefreshFooter
            android.content.Context r3 = r4.getContext()
            r2.<init>(r3)
            r0.h0(r2)
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r4.f77965b
            if (r0 != 0) goto L_0x0040
            r0 = r1
        L_0x0040:
            r0.e0(r4)
            android.content.Context r0 = r4.getContext()
            if (r0 == 0) goto L_0x0051
            com.hbg.module.huobi.im.group.ui.adapter.GroupChatListMyAdapter r2 = new com.hbg.module.huobi.im.group.ui.adapter.GroupChatListMyAdapter
            java.util.ArrayList<com.tencent.imsdk.v2.V2TIMConversation> r3 = r4.f77969f
            r2.<init>(r0, r3)
            goto L_0x0052
        L_0x0051:
            r2 = r1
        L_0x0052:
            r4.f77970g = r2
            com.hbg.module.huobi.im.group.view.SlideRecyclerView r0 = r4.f77966c
            if (r0 != 0) goto L_0x0059
            r0 = r1
        L_0x0059:
            com.hbg.module.huobi.im.group.ui.adapter.GroupChatListMyAdapter r2 = r4.f77970g
            r0.setAdapter(r2)
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r4.f77965b
            if (r0 != 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r1 = r0
        L_0x0064:
            r0 = 1
            r1.g(r0)
            r0 = 0
            r4.f77972i = r0
            r4.Ch()
            com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.message.ui.GroupChatListFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
