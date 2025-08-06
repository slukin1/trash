package com.hbg.module.content.ui.activity.live;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import cn.sharesdk.framework.InnerShareParams;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.module.content.R$string;
import com.hbg.module.huobi.im.group.ui.barrage.LiveListener;
import com.hbg.module.huobi.im.group.ui.barrage.TUIBarrageButton;
import com.hbg.module.huobi.im.group.ui.barrage.TUIBarrageDisplayView;
import com.hbg.module.huobi.im.utils.MessageBusinessID;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import md.a;
import v7.b;

public final class LiveDetailActivity$initData$1$11 extends LiveListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LiveDetailActivity f18553a;

    public LiveDetailActivity$initData$1$11(LiveDetailActivity liveDetailActivity) {
        this.f18553a = liveDetailActivity;
    }

    public void a(TUIBarrageMessage tUIBarrageMessage) {
        super.a(tUIBarrageMessage);
        IMLog.i("hbrecommend", "收到直播结束的通知");
        RequestExtKt.d(b.a().getLiveEndRecommend(this.f18553a.Sj()), new LiveDetailActivity$initData$1$11$onLiveEndListener$1(this.f18553a), LiveDetailActivity$initData$1$11$onLiveEndListener$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public void b(TUIBarrageMessage tUIBarrageMessage) {
        super.b(tUIBarrageMessage);
        this.f18553a.ek();
    }

    public void c(TUIBarrageMessage tUIBarrageMessage) {
        super.c(tUIBarrageMessage);
        try {
            if (TextUtils.equals(MessageBusinessID.MSG_BUSINESS_ID_LIVE_KICK.getValue(), tUIBarrageMessage.businessID)) {
                Map map = (Map) tUIBarrageMessage.data.get(InnerShareParams.EXT_INFO);
                String str = (String) map.get("groupId");
                String str2 = (String) map.get("remove_account");
                LiveDetailBean Hi = this.f18553a.f18466m;
                if (TextUtils.equals(str, Hi != null ? Hi.groupChatInteractive : null) && TextUtils.equals(str2, a.f22950a.i())) {
                    ToastUtil.toastShortMessage(this.f18553a.getString(R$string.n_live_im_kickout));
                    this.f18553a.finish();
                }
            }
        } catch (Exception e11) {
            IMLog.e("LiveDetailBarrage:onReceiveKick", e11.getMessage());
        }
    }

    public void e(TUIBarrageMessage tUIBarrageMessage) {
        super.e(tUIBarrageMessage);
        try {
            Map map = (Map) tUIBarrageMessage.data.get(InnerShareParams.EXT_INFO);
            Object obj = null;
            ArrayList arrayList = (ArrayList) (map != null ? map.get("accounts") : null);
            if (!com.hbg.module.libkt.base.ext.b.w(arrayList)) {
                boolean z11 = true;
                if (arrayList == null || !arrayList.contains(V2TIMManager.getInstance().getLoginUser())) {
                    z11 = false;
                }
                if (!z11) {
                    return;
                }
            }
            try {
                Map map2 = (Map) tUIBarrageMessage.data.get(InnerShareParams.EXT_INFO);
                String str = (String) (map2 != null ? map2.get(RemoteMessageConst.NOTIFICATION) : null);
                Object obj2 = map2 != null ? map2.get("showTime") : null;
                String str2 = (String) (map2 != null ? map2.get("jumpUrl") : null);
                String str3 = (String) (map2 != null ? map2.get("imgUrl") : null);
                if (map2 != null) {
                    obj = map2.get("jumpType");
                }
                this.f18553a.Ul(str, com.hbg.module.libkt.base.ext.b.d(obj2), str2, str3, com.hbg.module.libkt.base.ext.b.d(obj));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public void f(TUIBarrageMessage tUIBarrageMessage) {
        Map map;
        TUIBarrageDisplayView displayView;
        TUIBarrageButton ui2;
        TUIBarrageDisplayView displayView2;
        super.f(tUIBarrageMessage);
        try {
            if (TextUtils.equals(MessageBusinessID.MSG_BUSINESS_ID_LIVE_MSG_DEL.getValue(), tUIBarrageMessage.businessID)) {
                Map map2 = (Map) tUIBarrageMessage.data.get(InnerShareParams.EXT_INFO);
                String str = (String) map2.get("groupId");
                int doubleValue = (int) ((Double) map2.get("msgSeq")).doubleValue();
                LiveDetailBean Hi = this.f18553a.f18466m;
                if (TextUtils.equals(str, Hi != null ? Hi.groupChatInteractive : null) && (ui2 = this.f18553a.V) != null && (displayView2 = ui2.getDisplayView()) != null) {
                    displayView2.n(doubleValue);
                }
            } else if (TextUtils.equals(MessageBusinessID.MSG_BUSINESS_ID_DELETE_USER_MESSAGE.getValue(), tUIBarrageMessage.businessID) && (map = (Map) tUIBarrageMessage.data.get(InnerShareParams.EXT_INFO)) != null) {
                LiveDetailActivity liveDetailActivity = this.f18553a;
                List list = (List) map.get("msgSeqList");
                TUIBarrageButton ui3 = liveDetailActivity.V;
                if (ui3 != null && (displayView = ui3.getDisplayView()) != null) {
                    displayView.o(list);
                }
            }
        } catch (Exception e11) {
            IMLog.e("LiveDetailBarrage:onReceiveMsgDel:", e11.getMessage());
        }
    }
}
