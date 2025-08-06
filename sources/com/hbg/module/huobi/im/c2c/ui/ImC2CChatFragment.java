package com.hbg.module.huobi.im.c2c.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.c2c.C2CChatManager;
import com.hbg.module.huobi.im.event.MessageNoDisturbEvent;
import com.hbg.module.huobi.im.group.bean.HbImageMessageBean;
import com.hbg.module.huobi.im.group.bean.HbSoundMessageBean;
import com.hbg.module.huobi.im.group.bean.HbTextMessageBean;
import com.hbg.module.huobi.im.group.bean.LiveGroupBean;
import com.hbg.module.huobi.im.group.bean.MessageNoDisturbStatus;
import com.hbg.module.huobi.im.group.bean.UserStatusEntity;
import com.hbg.module.huobi.im.group.ui.chat.ChatView;
import com.hbg.module.huobi.im.group.ui.chat.TUIBaseChatFragment;
import com.huobi.framework.im.common.ImManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import rd.q;
import z9.g1;

public class ImC2CChatFragment extends TUIBaseChatFragment implements ld.e {

    /* renamed from: m  reason: collision with root package name */
    public static final String f19656m = ImC2CChatFragment.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public ChatInfo f19657b;

    /* renamed from: c  reason: collision with root package name */
    public C2CChatManager f19658c;

    /* renamed from: d  reason: collision with root package name */
    public ld.f f19659d = new ld.f(this);

    /* renamed from: e  reason: collision with root package name */
    public PersonalCenterInfo f19660e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f19661f;

    /* renamed from: g  reason: collision with root package name */
    public g1 f19662g;

    /* renamed from: h  reason: collision with root package name */
    public V2TIMConversation f19663h;

    /* renamed from: i  reason: collision with root package name */
    public int f19664i;

    /* renamed from: j  reason: collision with root package name */
    public int f19665j;

    /* renamed from: k  reason: collision with root package name */
    public String f19666k;

    /* renamed from: l  reason: collision with root package name */
    public UserStatusEntity f19667l;

    public class a extends BaseSubscriber<Boolean> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            int i11;
            super.onNext(bool);
            ImC2CChatFragment.this.dismissLoading();
            if (bool.booleanValue()) {
                ImC2CChatFragment.this.f19660e.setFocusStatus(ImC2CChatFragment.this.f19660e.getFocusStatus() == 0 ? 1 : 0);
                if (ImC2CChatFragment.this.f19660e.getFocusStatus() == 1) {
                    i11 = R$string.n_content_communityList_attention_succ;
                } else {
                    i11 = R$string.n_content_live_unfollow;
                }
                HuobiToastUtil.j(i11);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ImC2CChatFragment.this.dismissLoading();
            if (th2 instanceof APIStatusErrorException) {
                HuobiToastUtil.i(((APIStatusErrorException) th2).getErrCode());
            } else {
                HuobiToastUtil.i(ImC2CChatFragment.this.requireContext().getResources().getString(R$string.n_service_error));
            }
        }
    }

    public class b implements V2TIMCallback {
        public b() {
        }

        public void onError(int i11, String str) {
            String Oh = ImC2CChatFragment.f19656m;
            TUIChatLog.e(Oh, "markC2CMessageAsRead__Error " + str);
        }

        public void onSuccess() {
            TUIChatLog.e(ImC2CChatFragment.f19656m, "markC2CMessageAsRead__Success");
        }
    }

    public class c implements kd.a<MessageNoDisturbStatus> {
        public c() {
        }

        /* renamed from: a */
        public void onSuccess(MessageNoDisturbStatus messageNoDisturbStatus) {
            if (messageNoDisturbStatus != null) {
                ImC2CChatFragment.this.f19667l.setNoDisturbStatus(Integer.valueOf("1".equals(messageNoDisturbStatus.status) ? 1 : 0));
                ImC2CChatFragment imC2CChatFragment = ImC2CChatFragment.this;
                imC2CChatFragment.hi(imC2CChatFragment.f19667l);
            }
        }

        public void onFailed(int i11, String str) {
            ImC2CChatFragment.this.f19667l.setNoDisturbStatus(0);
            ImC2CChatFragment imC2CChatFragment = ImC2CChatFragment.this;
            imC2CChatFragment.hi(imC2CChatFragment.f19667l);
        }
    }

    public class d extends OnItemClickListener {
        public d() {
        }

        public void onMessageLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
            ImC2CChatFragment.this.chatView.showItemPopMenu(view, i11, tUIMessageBean);
        }

        public void onReEditRevokeMessage(View view, int i11, TUIMessageBean tUIMessageBean) {
            if (tUIMessageBean != null) {
                int msgType = tUIMessageBean.getMsgType();
                if (msgType != 1 || ImC2CChatFragment.this.chatView == null) {
                    String Oh = ImC2CChatFragment.f19656m;
                    TUIChatLog.e(Oh, "error type: " + msgType);
                    return;
                }
                ImC2CChatFragment.this.chatView.getInputLayout().appendText(tUIMessageBean.getV2TIMMessage().getTextElem().getText());
            }
        }

        public void onRecallClick(View view, int i11, TUIMessageBean tUIMessageBean) {
        }

        public void onTextSelected(View view, int i11, TUIMessageBean tUIMessageBean) {
            if (tUIMessageBean instanceof TextMessageBean) {
                String Oh = ImC2CChatFragment.f19656m;
                TUIChatLog.d(Oh, "chatfragment onTextSelected selectedText = " + ((TextMessageBean) tUIMessageBean).getSelectText());
            }
            ImC2CChatFragment.this.chatView.getMessageLayout().setSelectedPosition(i11);
            ImC2CChatFragment.this.chatView.showItemPopMenu(view, i11, tUIMessageBean);
        }

        public void onUserIconClick(View view, int i11, TUIMessageBean tUIMessageBean) {
            if (tUIMessageBean.isSelf()) {
                b2.a.d().a("/content/PersonalCenter").withString(Constants.FLAG_ACCOUNT, V2TIMManager.getInstance().getLoginUser()).navigation();
            } else if (ImC2CChatFragment.this.f19667l != null && ImC2CChatFragment.this.f19667l.getCustomer() != null && ImC2CChatFragment.this.f19667l.getCustomer().intValue() == 1 && !tUIMessageBean.isSelf()) {
                b2.a.d().a("/im/accountManager").withString(Constants.FLAG_ACCOUNT, ImC2CChatFragment.this.f19657b.getId()).navigation();
            } else if (ImC2CChatFragment.this.f19660e != null && ImC2CChatFragment.this.f19657b != null) {
                b2.a.d().a("/content/PersonalCenter").withString("uidUnique", ImC2CChatFragment.this.f19660e.getUidUnique()).withString(Constants.FLAG_ACCOUNT, ImC2CChatFragment.this.f19657b.getId()).navigation();
            }
        }

        public void onUserIconLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
        }
    }

    public class e implements kd.a<PersonalCenterInfo> {
        public e() {
        }

        /* renamed from: a */
        public void onSuccess(PersonalCenterInfo personalCenterInfo) {
            PersonalCenterInfo unused = ImC2CChatFragment.this.f19660e = personalCenterInfo;
            if (personalCenterInfo != null) {
                String nickname = personalCenterInfo.getNickname();
                if (ImC2CChatFragment.this.f19657b != null) {
                    ImC2CChatFragment.this.f19657b.setChatName(nickname);
                }
                if (ImC2CChatFragment.this.chatView != null && ImC2CChatFragment.this.f19657b != null) {
                    ImC2CChatFragment.this.chatView.setChatInfo(ImC2CChatFragment.this.f19657b);
                }
            }
        }

        public void onFailed(int i11, String str) {
            HuobiToastUtil.i(ImC2CChatFragment.this.requireContext().getResources().getString(R$string.n_service_error));
        }
    }

    public class f implements kd.a<UserStatusEntity> {
        public f() {
        }

        /* renamed from: a */
        public void onSuccess(UserStatusEntity userStatusEntity) {
            if (userStatusEntity != null) {
                UserStatusEntity unused = ImC2CChatFragment.this.f19667l = userStatusEntity;
            }
        }

        public void onFailed(int i11, String str) {
        }
    }

    public class g implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f19674a;

        public g(boolean z11) {
            this.f19674a = z11;
        }

        public void onError(int i11, String str) {
            ImC2CChatFragment.this.dismissLoading();
            HuobiToastUtil.g(R$string.n_service_error);
        }

        public void onSuccess() {
            int i11;
            ImC2CChatFragment.this.dismissLoading();
            if (this.f19674a) {
                i11 = R$string.n_content_live_now_un_pinned;
            } else {
                i11 = R$string.n_content_topping_success;
            }
            HuobiToastUtil.j(i11);
            ImC2CChatFragment.this.Wh();
        }
    }

    public class h implements dd.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserStatusEntity f19676a;

        public h(UserStatusEntity userStatusEntity) {
            this.f19676a = userStatusEntity;
        }

        public void onFailed(int i11, String str) {
            ImC2CChatFragment.this.dismissLoading();
        }

        public void onSuccess() {
            ImC2CChatFragment.this.dismissLoading();
            boolean z11 = true;
            HashMap hashMap = new HashMap(1);
            if (this.f19676a.getNoDisturbStatus().intValue() == 0) {
                hashMap.put("open", 1);
            } else {
                hashMap.put("open", 0);
            }
            q.a("appclick_messagesetting_onechat", hashMap);
            MessageNoDisturbEvent messageNoDisturbEvent = new MessageNoDisturbEvent();
            messageNoDisturbEvent.f19693a = ImC2CChatFragment.this.f19663h.getUserID();
            messageNoDisturbEvent.f19694b = 1;
            if (this.f19676a.getNoDisturbStatus().intValue() != 0) {
                z11 = false;
            }
            messageNoDisturbEvent.f19695c = z11;
            EventBus.d().k(messageNoDisturbEvent);
        }
    }

    public class i implements dd.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f19678a;

        public i(boolean z11) {
            this.f19678a = z11;
        }

        public void onFailed(int i11, String str) {
            ImC2CChatFragment.this.dismissLoading();
            if (this.f19678a) {
                HuobiToastUtil.g(R$string.n_im_operation_fail);
            } else {
                HuobiToastUtil.g(R$string.n_im_block_user_failed);
            }
        }

        public void onSuccess() {
            ImC2CChatFragment.this.dismissLoading();
            if (this.f19678a) {
                HuobiToastUtil.j(R$string.n_im_black_cancel);
            } else {
                HuobiToastUtil.j(R$string.n_im_block_user_success);
            }
        }
    }

    public class j implements V2TIMValueCallback<V2TIMConversation> {
        public j() {
        }

        /* renamed from: a */
        public void onSuccess(V2TIMConversation v2TIMConversation) {
            V2TIMConversation unused = ImC2CChatFragment.this.f19663h = v2TIMConversation;
        }

        public void onError(int i11, String str) {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Yh(View view) {
        Th(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ai() {
        g1 g1Var;
        if (getActivity() != null && !getActivity().isFinishing() && (g1Var = this.f19662g) != null && g1Var.isShowing()) {
            this.f19662g.dismiss();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void bi(View view) {
        V2TIMConversation v2TIMConversation;
        if (!(this.f19660e == null || (v2TIMConversation = this.f19663h) == null)) {
            this.f19659d.m(1, v2TIMConversation.getUserID(), new c());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ci() {
        if (this.f19662g == null) {
            this.f19662g = new g1(requireContext());
        }
        this.f19662g.show();
        this.f19662g.setCanceledOnTouchOutside(true);
        this.f19662g.setCancelable(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void di(boolean z11) {
        if (z11) {
            Th(z11);
        } else {
            Sh();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ei() {
        showLoading();
        boolean isPinned = this.f19663h.isPinned();
        ImManager.INSTANCE.pinConversation(this.f19657b.getId(), false, !isPinned, new g(isPinned));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fi(UserStatusEntity userStatusEntity) {
        showLoading();
        this.f19659d.D(1, this.f19663h.getUserID(), userStatusEntity.getNoDisturbStatus().intValue() == 1 ? 0 : 1, new h(userStatusEntity));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        V2TIMManager.getMessageManager().markC2CMessageAsRead(this.f19666k, new b());
    }

    public final void Sh() {
        new nd.b(getContext()).a().c(true).b(true).j(20.0f).d(getString(R$string.n_im_block_user_hint)).e(0.75f).h(getContext().getString(R$string.n_sure), new a(this)).g(getContext().getString(R$string.n_cancel), c.f19683b).k();
    }

    public final void Th(boolean z11) {
        int i11 = z11 ? 3 : 2;
        showLoading();
        this.f19659d.E(this.f19657b.getId(), i11, new i(z11));
    }

    public final void Uh() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.f19660e.getFocusStatus() == 0 ? 1 : 0));
        hashMap.put("uidUnique", this.f19660e.getUidUnique());
        showLoading();
        v7.b.a().requestCommunityAttention(hashMap).b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new a());
    }

    /* renamed from: Vh */
    public C2CChatManager getChatManager() {
        return this.f19658c;
    }

    public final void Wh() {
        ImManager.INSTANCE.getConversation(this.f19657b.getId(), false, new j());
    }

    public final void Xh() {
        this.f19659d.q(this.f19666k, "2", new f());
    }

    public final void dismissLoading() {
        this.f19661f.post(new i(this));
    }

    public ChatInfo getChatInfo() {
        return this.f19657b;
    }

    public void gi(C2CChatManager c2CChatManager) {
        this.f19658c = c2CChatManager;
    }

    public final void hi(UserStatusEntity userStatusEntity) {
        boolean z11 = userStatusEntity.getInblackList().intValue() == 1;
        boolean z12 = userStatusEntity.getNoDisturbStatus().intValue() == 1;
        if (this.f19660e != null && this.f19663h != null) {
            DialogUtils.f0(getActivity(), this.f19660e.getFocusStatus(), this.f19663h.isPinned(), z11, z12, new e(this), new g(this, z11), new d(this), new f(this, userStatusEntity));
        }
    }

    public void initView() {
        super.initView();
        Xh();
        this.chatView.setOnUpdateAdapterListener(new h(this));
        this.titleBar.setOnRightClickListener(new b(this));
        if (this.chatView == null || this.f19658c == null) {
            ToastUtil.toastShortMessage("init chat failed.");
            if (getActivity() != null && !getActivity().isFinishing()) {
                getActivity().finish();
                return;
            }
            return;
        }
        Wh();
        this.chatView.setChatManager(this.f19658c);
        this.f19658c.setChatInfo(this.f19657b);
        this.chatView.setChatInfo(this.f19657b);
        this.chatView.getMessageLayout().setOnItemClickListener(new d());
        if (this.f19657b.getId() != null) {
            this.f19659d.n(this.f19657b.getId(), new e());
        }
    }

    public void onChatSessionRemoveChange() {
        ChatInfo chatInfo;
        ChatView chatView = this.chatView;
        if (chatView != null && (chatInfo = this.f19657b) != null) {
            chatView.setChatInfo(chatInfo);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = f19656m;
        TUIChatLog.i(str, "oncreate view " + this);
        this.f19664i = PixelUtils.a(16.0f);
        this.f19665j = PixelUtils.a(2.0f);
        this.baseView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return this.baseView;
        }
        this.f19657b = (ChatInfo) arguments.getSerializable(TUIChatConstants.CHAT_INFO);
        this.f19666k = arguments.getString("chatId");
        if (this.f19657b == null) {
            return this.baseView;
        }
        initView();
        ChatMessageParser.putCustomMessageType(1, HbTextMessageBean.class);
        ChatMessageParser.putCustomMessageType(3, HbImageMessageBean.class);
        ChatMessageParser.putCustomMessageType(4, HbSoundMessageBean.class);
        return this.baseView;
    }

    public void showGroupLiveFloatView(LiveGroupBean liveGroupBean) {
    }

    public final void showLoading() {
        if (this.f19661f == null) {
            this.f19661f = new Handler(Looper.getMainLooper());
        }
        this.f19661f.post(new j(this));
    }

    public void updateCancelLiveAppointment() {
    }

    public void updateLiveAppointment() {
    }
}
