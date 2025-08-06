package com.hbg.module.huobi.im.group.ui.barrage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import cn.sharesdk.framework.InnerShareParams;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveServerMsgBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.huobi.im.group.bean.HBTUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.bean.RedpacketSnatchBean;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.active.RewardsAnim;
import com.hbg.module.huobi.im.group.ui.barrage.TUIBarrageButton;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import com.hbg.module.huobi.im.group.view.WrapContentLinearLayoutManager;
import com.hbg.module.huobi.im.utils.MessageBusinessID;
import com.hbg.module.huobi.im.utils.MessageType;
import com.huobi.utils.GsonHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import com.tencent.imsdk.common.IMLog;
import com.tencent.qcloud.tuikit.tuibarrage.R;
import com.tencent.qcloud.tuikit.tuibarrage.core.TUIBarrageExtension;
import com.tencent.qcloud.tuikit.tuibarrage.manager.HbBarrageManager;
import com.tencent.qcloud.tuikit.tuibarrage.manager.TUIBarrageCallBack;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageModel;
import com.tencent.qcloud.tuikit.tuibarrage.view.ITUIBarrageDisplayView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import u6.g;

public class TUIBarrageDisplayView extends FrameLayout implements ITUIBarrageDisplayView {

    /* renamed from: b  reason: collision with root package name */
    public Context f20326b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f20327c;

    /* renamed from: d  reason: collision with root package name */
    public a f20328d;

    /* renamed from: e  reason: collision with root package name */
    public HbBarrageManager f20329e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TUIBarrageMsgEntity> f20330f;

    /* renamed from: g  reason: collision with root package name */
    public String f20331g;

    /* renamed from: h  reason: collision with root package name */
    public int f20332h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20333i;

    /* renamed from: j  reason: collision with root package name */
    public LiveDetailBean f20334j;

    /* renamed from: k  reason: collision with root package name */
    public List<TUIBarrageMsgEntity> f20335k;

    /* renamed from: l  reason: collision with root package name */
    public List<String> f20336l;

    /* renamed from: m  reason: collision with root package name */
    public int f20337m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f20338n;

    /* renamed from: o  reason: collision with root package name */
    public TUIBarrageCallBack f20339o;

    /* renamed from: p  reason: collision with root package name */
    public TUIBarrageButton.f f20340p;

    /* renamed from: q  reason: collision with root package name */
    public Timer f20341q;

    /* renamed from: r  reason: collision with root package name */
    public TimerTask f20342r;

    /* renamed from: s  reason: collision with root package name */
    public Handler f20343s;

    /* renamed from: t  reason: collision with root package name */
    public int f20344t;

    public class a extends TimerTask {

        /* renamed from: com.hbg.module.huobi.im.group.ui.barrage.TUIBarrageDisplayView$a$a  reason: collision with other inner class name */
        public class C0146a implements Runnable {
            public C0146a() {
            }

            public void run() {
                TUIBarrageDisplayView.this.f20328d.notifyDataSetChanged();
                if (TUIBarrageDisplayView.this.f20336l.size() > 0) {
                    TUIBarrageDisplayView.this.f20336l.remove(0);
                }
            }
        }

        public a() {
        }

        public void run() {
            if (TUIBarrageDisplayView.this.f20330f != null && TUIBarrageDisplayView.this.f20328d != null) {
                try {
                    if (TUIBarrageDisplayView.this.f20336l.size() > 0) {
                        String str = (String) TUIBarrageDisplayView.this.f20336l.get(0);
                        if (TUIBarrageDisplayView.this.f20330f.size() > 0) {
                            TUIBarrageMsgEntity tUIBarrageMsgEntity = (TUIBarrageMsgEntity) TUIBarrageDisplayView.this.f20330f.get(TUIBarrageDisplayView.this.f20330f.size() - 1);
                            int i11 = tUIBarrageMsgEntity.type;
                            MessageType messageType = MessageType.MESSAGE_NEW_USER_INTO;
                            if (i11 == messageType.getType()) {
                                tUIBarrageMsgEntity.userName = str;
                            } else {
                                TUIBarrageMsgEntity tUIBarrageMsgEntity2 = new TUIBarrageMsgEntity();
                                tUIBarrageMsgEntity2.type = messageType.getType();
                                tUIBarrageMsgEntity2.userName = str;
                                TUIBarrageDisplayView.this.f20330f.add(tUIBarrageMsgEntity2);
                            }
                            TUIBarrageDisplayView.this.f20343s.post(new C0146a());
                        }
                    }
                } catch (Exception e11) {
                    i6.d.d(e11.getMessage());
                }
            }
        }
    }

    public class b extends TUIBarrageCallBack {
        public b() {
        }

        public void onCustomCallback(int i11, TUIBarrageMessage tUIBarrageMessage) {
            if (TUIBarrageDisplayView.this.f20330f.size() > 1 && ((TUIBarrageMsgEntity) TUIBarrageDisplayView.this.f20330f.get(1)).isRetry) {
                TUIBarrageDisplayView.this.f20330f.remove(1);
            }
            TUIBarrageDisplayView.this.l(tUIBarrageMessage);
        }

        public void onFailed(int i11, String str) {
            if (TUIBarrageDisplayView.this.f20330f.size() == 1) {
                TUIBarrageMsgEntity tUIBarrageMsgEntity = new TUIBarrageMsgEntity();
                tUIBarrageMsgEntity.isRetry = true;
                TUIBarrageDisplayView.this.f20330f.add(tUIBarrageMsgEntity);
                TUIBarrageDisplayView.this.f20328d.notifyDataSetChanged();
            }
        }

        public void onTextCallback(int i11, TUIBarrageMessage tUIBarrageMessage) {
            if (TUIBarrageDisplayView.this.f20330f.size() > 1 && ((TUIBarrageMsgEntity) TUIBarrageDisplayView.this.f20330f.get(1)).isRetry) {
                TUIBarrageDisplayView.this.f20330f.remove(1);
            }
            TUIBarrageDisplayView.this.receiveBarrage(tUIBarrageMessage);
        }
    }

    public class c implements a.p {
        public c() {
        }

        public void onRetry() {
            if (TUIBarrageDisplayView.this.f20329e != null) {
                TUIBarrageDisplayView.this.f20329e.init(TUIBarrageDisplayView.this.f20331g);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TUIBarrageDisplayView.this.f20327c.smoothScrollToPosition(TUIBarrageDisplayView.this.f20328d.getItemCount());
            TUIBarrageDisplayView.this.f20338n.setVisibility(8);
            int unused = TUIBarrageDisplayView.this.f20337m = 0;
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e extends RecyclerView.OnScrollListener {
        public e() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) TUIBarrageDisplayView.this.f20327c.getLayoutManager();
            if (i11 == 0 && linearLayoutManager.findLastCompletelyVisibleItemPosition() == TUIBarrageDisplayView.this.f20328d.getItemCount() - 1) {
                TUIBarrageDisplayView.this.f20338n.setVisibility(8);
                int unused = TUIBarrageDisplayView.this.f20337m = 0;
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
        }
    }

    public class f extends BaseSubscriber<List<LiveServerMsgBean>> {
        public f() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }

        public void onNext(List<LiveServerMsgBean> list) {
            super.onNext(list);
            if (list != null && list.size() > 0) {
                for (LiveServerMsgBean next : list) {
                    HBTUIBarrageMsgEntity hBTUIBarrageMsgEntity = new HBTUIBarrageMsgEntity();
                    TUIBarrageModel tUIBarrageModel = new TUIBarrageModel();
                    tUIBarrageModel.msgId = null;
                    tUIBarrageModel.timestamp = next.getMsgTimestamp();
                    tUIBarrageModel.groupId = TUIBarrageDisplayView.this.f20331g;
                    boolean z11 = true;
                    if (next.getIsSelf() != 1) {
                        z11 = false;
                    }
                    tUIBarrageModel.isSelf = z11;
                    tUIBarrageModel.sender = next.getFromAccount();
                    tUIBarrageModel.msgSeq = next.getMsgSeq();
                    tUIBarrageModel.nickName = next.getNickname();
                    tUIBarrageModel.faceUrl = next.getAvatar();
                    hBTUIBarrageMsgEntity.userId = next.getFromAccount();
                    hBTUIBarrageMsgEntity.userName = next.getNickname();
                    hBTUIBarrageMsgEntity.content = next.getText();
                    hBTUIBarrageMsgEntity.model = tUIBarrageModel;
                    TUIBarrageDisplayView.this.f20330f.add(hBTUIBarrageMsgEntity);
                }
                TUIBarrageDisplayView.this.f20328d.notifyDataSetChanged();
            }
        }
    }

    public TUIBarrageDisplayView(Context context) {
        super(context);
        this.f20332h = 0;
        this.f20333i = false;
        this.f20335k = new ArrayList();
        this.f20336l = new ArrayList();
        this.f20337m = 0;
        this.f20344t = 0;
    }

    private void getMsgFromServer() {
        v7.b.a().P0(this.f20331g, this.f20344t, 1).b().compose(RxJavaHelper.t((g) null)).subscribe(new f());
    }

    public final void j() {
        HbBarrageManager instance = HbBarrageManager.getInstance();
        this.f20329e = instance;
        instance.init(this.f20331g);
        this.f20341q = new Timer();
        a aVar = new a();
        this.f20342r = aVar;
        this.f20341q.schedule(aVar, 1000, 1000);
        if (this.f20332h == 0) {
            b bVar = new b();
            this.f20339o = bVar;
            this.f20329e.addBarrageCallBack(bVar);
            return;
        }
        getMsgFromServer();
    }

    public final void k(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tuibarrage_view_display, this);
        this.f20327c = (RecyclerView) findViewById(R.id.rv_msg);
        ArrayList<TUIBarrageMsgEntity> arrayList = new ArrayList<>();
        this.f20330f = arrayList;
        this.f20328d = new a(context, arrayList, new c());
        this.f20327c.setLayoutManager(new WrapContentLinearLayoutManager(context));
        h hVar = new h(context, 1);
        hVar.setDrawable(getResources().getDrawable(R.drawable.tuibarrage_item_decoration));
        this.f20327c.addItemDecoration(hVar);
        this.f20327c.setAdapter(this.f20328d);
        this.f20330f.clear();
        TUIBarrageMsgEntity tUIBarrageMsgEntity = new TUIBarrageMsgEntity();
        tUIBarrageMsgEntity.userName = context.getResources().getString(R.string.n_live_message_alert_title);
        tUIBarrageMsgEntity.content = "";
        this.f20330f.add(tUIBarrageMsgEntity);
        this.f20328d.notifyDataSetChanged();
        TextView textView = (TextView) findViewById(R.id.tv_new_msg_tips);
        this.f20338n = textView;
        textView.setOnClickListener(new d());
        this.f20327c.addOnScrollListener(new e());
    }

    public void l(TUIBarrageMessage tUIBarrageMessage) {
        Object obj;
        Object obj2;
        Log.e(TUIBarrageExtension.KEY_DISPLAY_VIEW, tUIBarrageMessage.businessID + ":message--" + GsonHelper.a().toJson((Object) tUIBarrageMessage));
        if (MessageBusinessID.MSG_BUSINESS_ID_GIFT_DRAW.getValue().equals(tUIBarrageMessage.businessID)) {
            TUIBarrageMsgEntity tUIBarrageMsgEntity = new TUIBarrageMsgEntity();
            Map<String, Object> map = tUIBarrageMessage.data;
            if (map != null && (obj2 = map.get(InnerShareParams.EXT_INFO)) != null) {
                Map map2 = (Map) obj2;
                String str = (String) map2.get(Constants.FLAG_ACCOUNT);
                tUIBarrageMsgEntity.userName = (String) map2.get("nickname");
                tUIBarrageMsgEntity.content = (String) map2.get("text");
                tUIBarrageMsgEntity.userId = tUIBarrageMessage.sender;
                TUIBarrageModel tUIBarrageModel = new TUIBarrageModel();
                tUIBarrageModel.msgId = tUIBarrageMessage.v2TIMMessage.getMsgID();
                tUIBarrageModel.timestamp = tUIBarrageMessage.v2TIMMessage.getTimestamp();
                tUIBarrageModel.groupId = tUIBarrageMessage.v2TIMMessage.getGroupID();
                tUIBarrageModel.isSelf = tUIBarrageMessage.v2TIMMessage.isSelf();
                tUIBarrageModel.sender = tUIBarrageMessage.v2TIMMessage.getSender();
                tUIBarrageModel.msgSeq = tUIBarrageMessage.v2TIMMessage.getSeq();
                tUIBarrageModel.nickName = tUIBarrageMessage.v2TIMMessage.getNickName();
                tUIBarrageModel.faceUrl = tUIBarrageMessage.v2TIMMessage.getFaceUrl();
                tUIBarrageModel.status = tUIBarrageMessage.v2TIMMessage.getStatus();
                tUIBarrageModel.message = tUIBarrageMessage.message;
                tUIBarrageMsgEntity.model = tUIBarrageModel;
                tUIBarrageMsgEntity.type = MessageType.MESSAGE_GIFT_WINNING.getType();
                this.f20330f.add(tUIBarrageMsgEntity);
                this.f20328d.notifyDataSetChanged();
            }
        } else if (MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_IN.getValue().equals(tUIBarrageMessage.businessID)) {
            Map<String, Object> map3 = tUIBarrageMessage.data;
            if (map3 != null) {
                Object obj3 = map3.get(InnerShareParams.EXT_INFO);
                if (obj3 instanceof Map) {
                    this.f20336l.add((String) ((Map) obj3).get("nickname"));
                }
            }
        } else if (MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_RED_PACKET_SNATCH.getValue().equals(tUIBarrageMessage.businessID)) {
            TUIBarrageMsgEntity tUIBarrageMsgEntity2 = new TUIBarrageMsgEntity();
            Map<String, Object> map4 = tUIBarrageMessage.data;
            if (map4 != null && (obj = map4.get(InnerShareParams.EXT_INFO)) != null) {
                Map map5 = (Map) obj;
                RedpacketSnatchBean redpacketSnatchBean = new RedpacketSnatchBean();
                try {
                    Object obj4 = map5.get("nickname");
                    Objects.requireNonNull(obj4);
                    redpacketSnatchBean.nickName = obj4.toString();
                    Object obj5 = map5.get(FirebaseAnalytics.Param.CURRENCY);
                    Objects.requireNonNull(obj5);
                    redpacketSnatchBean.currency = obj5.toString();
                    Object obj6 = map5.get("amount");
                    Objects.requireNonNull(obj6);
                    redpacketSnatchBean.amount = Double.parseDouble(obj6.toString());
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                tUIBarrageMsgEntity2.type = MessageType.MESSAGE_REDPACKET_SNATCH.getType();
                tUIBarrageMsgEntity2.snatch = redpacketSnatchBean;
                this.f20330f.add(tUIBarrageMsgEntity2);
                this.f20328d.notifyDataSetChanged();
            }
        }
    }

    public void m(RewardsAnim rewardsAnim) {
        TUIBarrageMsgEntity tUIBarrageMsgEntity = new TUIBarrageMsgEntity();
        tUIBarrageMsgEntity.type = MessageType.MESSAGE_GIFT_ANIM.getType();
        tUIBarrageMsgEntity.anim = rewardsAnim;
        this.f20330f.add(tUIBarrageMsgEntity);
        this.f20328d.notifyDataSetChanged();
        if (System.currentTimeMillis() / 1000 < md.a.f22950a.g()) {
            this.f20338n.setVisibility(8);
            this.f20337m = 0;
            this.f20327c.smoothScrollToPosition(this.f20328d.getItemCount());
        } else if (((LinearLayoutManager) this.f20327c.getLayoutManager()).findLastVisibleItemPosition() == this.f20328d.getItemCount() - 2) {
            this.f20338n.setVisibility(8);
            this.f20337m = 0;
            this.f20327c.smoothScrollToPosition(this.f20328d.getItemCount());
        } else {
            this.f20338n.setVisibility(0);
            this.f20337m++;
            this.f20338n.setText(String.format(getContext().getString(R.string.n_im_new_msg_tips), new Object[]{Integer.valueOf(this.f20337m)}));
        }
    }

    public void n(int i11) {
        TUIBarrageModel tUIBarrageModel;
        ArrayList<TUIBarrageMsgEntity> arrayList = this.f20330f;
        if (arrayList != null) {
            Iterator<TUIBarrageMsgEntity> it2 = arrayList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    TUIBarrageMsgEntity next = it2.next();
                    if (next != null && (tUIBarrageModel = next.model) != null && tUIBarrageModel.msgSeq == ((long) i11)) {
                        it2.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f20328d.notifyDataSetChanged();
        }
    }

    public void o(List<Double> list) {
        if (this.f20330f != null) {
            if (list != null && list.size() > 0) {
                for (int i11 = 0; i11 < list.size(); i11++) {
                    try {
                        n(list.get(i11).intValue());
                    } catch (Exception e11) {
                        IMLog.e(TUIBarrageExtension.KEY_DISPLAY_VIEW, e11.getMessage());
                    }
                }
            }
            this.f20328d.notifyDataSetChanged();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            RecyclerView recyclerView = this.f20327c;
            if (recyclerView != null) {
                recyclerView.smoothScrollToPosition(this.f20328d.getItemCount());
            }
        } catch (Exception e11) {
            IMLog.e(TUIBarrageExtension.KEY_DISPLAY_VIEW, e11.getMessage());
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Timer timer = this.f20341q;
        if (timer != null) {
            timer.cancel();
            this.f20341q = null;
        }
        TimerTask timerTask = this.f20342r;
        if (timerTask != null) {
            timerTask.cancel();
            this.f20342r = null;
        }
    }

    @SuppressLint({"StringFormatMatches"})
    public void receiveBarrage(TUIBarrageMessage tUIBarrageMessage) {
        if (tUIBarrageMessage == null) {
            Log.d(TUIBarrageExtension.KEY_DISPLAY_VIEW, "receiveBarrage model is empty");
            return;
        }
        Log.d(TUIBarrageExtension.KEY_DISPLAY_VIEW, "barrageDis hashcode = " + hashCode());
        Log.d(TUIBarrageExtension.KEY_DISPLAY_VIEW, "receiveBarrage message = " + tUIBarrageMessage);
        if (tUIBarrageMessage.message.length() == 0) {
            Log.d(TUIBarrageExtension.KEY_DISPLAY_VIEW, "receiveBarrage message is empty");
            return;
        }
        HBTUIBarrageMsgEntity hBTUIBarrageMsgEntity = new HBTUIBarrageMsgEntity();
        hBTUIBarrageMsgEntity.userId = tUIBarrageMessage.sender;
        hBTUIBarrageMsgEntity.userName = tUIBarrageMessage.v2TIMMessage.getNickName();
        hBTUIBarrageMsgEntity.content = tUIBarrageMessage.message;
        TUIBarrageModel tUIBarrageModel = new TUIBarrageModel();
        tUIBarrageModel.msgId = tUIBarrageMessage.v2TIMMessage.getMsgID();
        tUIBarrageModel.timestamp = tUIBarrageMessage.v2TIMMessage.getTimestamp();
        tUIBarrageModel.groupId = tUIBarrageMessage.v2TIMMessage.getGroupID();
        tUIBarrageModel.isSelf = tUIBarrageMessage.v2TIMMessage.isSelf();
        tUIBarrageModel.sender = tUIBarrageMessage.v2TIMMessage.getSender();
        tUIBarrageModel.msgSeq = tUIBarrageMessage.v2TIMMessage.getSeq();
        tUIBarrageModel.nickName = tUIBarrageMessage.v2TIMMessage.getNickName();
        tUIBarrageModel.faceUrl = tUIBarrageMessage.v2TIMMessage.getFaceUrl();
        tUIBarrageModel.status = tUIBarrageMessage.v2TIMMessage.getStatus();
        tUIBarrageModel.message = tUIBarrageMessage.message;
        hBTUIBarrageMsgEntity.model = tUIBarrageModel;
        this.f20330f.add(hBTUIBarrageMsgEntity);
        this.f20328d.notifyDataSetChanged();
        if (tUIBarrageMessage.sendTime < md.a.f22950a.g()) {
            this.f20338n.setVisibility(8);
            this.f20337m = 0;
            this.f20327c.smoothScrollToPosition(this.f20328d.getItemCount());
        } else if (((LinearLayoutManager) this.f20327c.getLayoutManager()).findLastVisibleItemPosition() == this.f20328d.getItemCount() - 2) {
            this.f20338n.setVisibility(8);
            this.f20337m = 0;
            this.f20327c.smoothScrollToPosition(this.f20328d.getItemCount());
        } else {
            this.f20338n.setVisibility(0);
            this.f20337m++;
            this.f20338n.setText(String.format(getContext().getString(R.string.n_im_new_msg_tips), new Object[]{Integer.valueOf(this.f20337m)}));
        }
    }

    public void setAtSomeoneListener(TUIBarrageButton.f fVar) {
        this.f20340p = fVar;
        a aVar = this.f20328d;
        if (aVar != null) {
            aVar.O(fVar);
        }
    }

    public void setCurrUserManager(boolean z11) {
        this.f20333i = z11;
        a aVar = this.f20328d;
        if (aVar != null) {
            aVar.P(z11);
        }
    }

    public void setLiveDetailBean(LiveDetailBean liveDetailBean) {
        this.f20334j = liveDetailBean;
        a aVar = this.f20328d;
        if (aVar != null) {
            aVar.Q(liveDetailBean);
        }
    }

    public TUIBarrageDisplayView(Context context, String str, int i11) {
        this(context);
        this.f20326b = context;
        this.f20331g = str;
        this.f20332h = i11;
        k(context);
        this.f20343s = new Handler(Looper.getMainLooper());
        j();
    }
}
