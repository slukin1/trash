package com.huobi.otc.persenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearLayoutManager;
import bj.o0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.gson.reflect.TypeToken;
import com.hbg.event.ChatReSendEvent;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.FileUploadSubscriber;
import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.otc.core.bean.BaseSettingBean;
import com.hbg.lib.network.otc.core.bean.OnLineStatusBean;
import com.hbg.lib.network.otc.core.bean.OrderPhone;
import com.hbg.lib.network.otc.core.bean.OtcOrderDetailBean;
import com.hbg.lib.network.otc.core.bean.OtcUploadPicBean;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.otc.core.bean.UserVerifyWaysBean;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.OtcCallEndEvent;
import com.huobi.otc.bean.OtcChatContent;
import com.huobi.otc.bean.OtcChatContentList;
import com.huobi.otc.bean.OtcOrderBean;
import com.huobi.otc.bean.OtcOrderDetailInfo;
import com.huobi.otc.bean.OtherInfoBean;
import com.huobi.otc.bean.VoiceInfo;
import com.huobi.otc.service.OTCService;
import com.huobi.otc.ui.OtcPdfPreviewActivity;
import com.huobi.utils.GsonHelper;
import com.huobi.utils.ImageUtils;
import com.huobi.websocket.protobuf.source.Message$Proto;
import com.huochat.community.base.CommunityConstants;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import up.x;

public class OtcLiteChatPresenter extends ActivityPresenter<s> {
    public boolean A;
    public String B;
    public String C;
    public long D;
    public Runnable E;
    public UserVerifyWaysBean F;
    public Runnable G = new q();
    public Runnable H = new r();
    public Runnable I = new a();
    public long J = 0;
    public boolean K = false;
    public long L = 0;
    public boolean M = false;

    /* renamed from: a  reason: collision with root package name */
    public String f79053a;

    /* renamed from: b  reason: collision with root package name */
    public String f79054b;

    /* renamed from: c  reason: collision with root package name */
    public long f79055c;

    /* renamed from: d  reason: collision with root package name */
    public int f79056d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f79057e;

    /* renamed from: f  reason: collision with root package name */
    public v9.a<OtcChatContent> f79058f;

    /* renamed from: g  reason: collision with root package name */
    public List<OtcChatContent> f79059g;

    /* renamed from: h  reason: collision with root package name */
    public List<OtcChatContent> f79060h;

    /* renamed from: i  reason: collision with root package name */
    public long f79061i = 0;

    /* renamed from: j  reason: collision with root package name */
    public long f79062j = 0;

    /* renamed from: k  reason: collision with root package name */
    public HashSet<Long> f79063k;

    /* renamed from: l  reason: collision with root package name */
    public ArrayList<Long> f79064l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    public boolean f79065m = false;

    /* renamed from: n  reason: collision with root package name */
    public boolean f79066n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f79067o = false;

    /* renamed from: p  reason: collision with root package name */
    public List<Long> f79068p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public boolean f79069q = true;

    /* renamed from: r  reason: collision with root package name */
    public boolean f79070r = false;

    /* renamed from: s  reason: collision with root package name */
    public UserVO f79071s;

    /* renamed from: t  reason: collision with root package name */
    public OrderPhone f79072t = null;

    /* renamed from: u  reason: collision with root package name */
    public Subscription f79073u;

    /* renamed from: v  reason: collision with root package name */
    public Subscription f79074v;

    /* renamed from: w  reason: collision with root package name */
    public x.f f79075w = new j();

    /* renamed from: x  reason: collision with root package name */
    public OtcOrderDetailInfo f79076x;

    /* renamed from: y  reason: collision with root package name */
    public Runnable f79077y;

    /* renamed from: z  reason: collision with root package name */
    public long f79078z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ((s) OtcLiteChatPresenter.this.getUI()).Q2(true);
        }
    }

    public class b extends EasySubscriber<OtcChatContentList> {

        public class a implements x.g {

            /* renamed from: a  reason: collision with root package name */
            public boolean f79081a = false;

            public a() {
            }

            public void a() {
                this.f79081a = false;
                i6.i.b().h(OtcLiteChatPresenter.this.G);
            }

            public void b() {
                if (!this.f79081a) {
                    this.f79081a = true;
                    OtcLiteChatPresenter.this.Q0();
                }
            }
        }

        public b() {
        }

        /* renamed from: a */
        public void onNext(OtcChatContentList otcChatContentList) {
            super.onNext(otcChatContentList);
            boolean unused = OtcLiteChatPresenter.this.f79067o = true;
            boolean unused2 = OtcLiteChatPresenter.this.f79066n = true;
            OtcLiteChatPresenter.this.M0(otcChatContentList);
            ((s) OtcLiteChatPresenter.this.getUI()).f6().g();
        }

        public void onAfter() {
            super.onAfter();
            BaseSettingBean g11 = qu.d.i().g();
            if (!OtcLiteChatPresenter.this.f79066n || OtcLiteChatPresenter.this.getActivity() == null || OtcLiteChatPresenter.this.getActivity().isFinishing() || g11 == null || !"1".equals(g11.getChatWsSwitch())) {
                OtcLiteChatPresenter.this.Q0();
                return;
            }
            x.j().p(OtcLiteChatPresenter.this.f79054b, OtcLiteChatPresenter.this.f79075w, new a());
            if (!x.j().l()) {
                OtcLiteChatPresenter.this.Q0();
            }
        }

        public void onError2(Throwable th2) {
            boolean unused = OtcLiteChatPresenter.this.f79066n = false;
            OtcLiteChatPresenter.this.Z0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            boolean unused = OtcLiteChatPresenter.this.f79066n = false;
            OtcLiteChatPresenter.this.Z0();
        }
    }

    public class c extends EasySubscriber<OTCStatusResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f79083b;

        public c(List list) {
            this.f79083b = list;
        }

        /* renamed from: a */
        public void onNext(OTCStatusResponse<Object> oTCStatusResponse) {
            super.onNext(oTCStatusResponse);
            if (OtcLiteChatPresenter.this.getUI() == null) {
                return;
            }
            if (oTCStatusResponse == null || !oTCStatusResponse.isSuccess()) {
                ((s) OtcLiteChatPresenter.this.getUI()).zb();
                return;
            }
            ((s) OtcLiteChatPresenter.this.getUI()).L9(this.f79083b);
            i6.d.j("sdfsdfsdfdsf", "isSuccess>" + this.f79083b.get(0));
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (OtcLiteChatPresenter.this.getUI() != null) {
                ((s) OtcLiteChatPresenter.this.getUI()).zb();
            }
        }
    }

    public class d extends EasySubscriber<Object> {
        public d() {
        }

        public void onError2(Throwable th2) {
            OtcLiteChatPresenter.this.a1(true);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (aPIStatusErrorException != null) {
                OtcLiteChatPresenter.this.a1(false);
                HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
                return;
            }
            OtcLiteChatPresenter.this.a1(true);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            OtcLiteChatPresenter.this.a1(false);
        }
    }

    public class e implements pa.a {
        public e() {
        }

        public void a(Uri uri, String str, boolean z11) {
            OtcLiteChatPresenter.this.w1(uri.toString(), (OtcChatContent) null, str, z11);
        }

        public void b(String str) {
        }

        public void c(LinkedHashMap<String, Boolean> linkedHashMap, String[] strArr) {
        }

        public void onCancel() {
        }
    }

    public class f extends FileUploadSubscriber<Response<Object>> {

        /* renamed from: c  reason: collision with root package name */
        public OtcChatContent f79087c = null;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ OtcChatContent f79088d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f79089e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f79090f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f79091g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f79092h;

        public f(OtcChatContent otcChatContent, String str, boolean z11, boolean z12, String str2) {
            this.f79088d = otcChatContent;
            this.f79089e = str;
            this.f79090f = z11;
            this.f79091g = z12;
            this.f79092h = str2;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(int i11) {
            OtcChatContent otcChatContent = this.f79087c;
            if (otcChatContent != null) {
                if (i11 >= 100) {
                    i11 = 99;
                }
                otcChatContent.setProgress(i11);
            }
            if (OtcLiteChatPresenter.this.f79059g.indexOf(this.f79087c) >= 0) {
                OtcLiteChatPresenter.this.f79058f.notifyItemChanged(OtcLiteChatPresenter.this.f79059g.indexOf(this.f79087c));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(Throwable th2) {
            OtcChatContent otcChatContent = this.f79087c;
            if (otcChatContent != null) {
                otcChatContent.setSendStatus(OtcChatContent.ChatImageSendSendStatus.SendFail);
                this.f79087c.setProgress(0);
                if (OtcLiteChatPresenter.this.f79059g.indexOf(this.f79087c) >= 0) {
                    OtcLiteChatPresenter.this.f79058f.notifyItemChanged(OtcLiteChatPresenter.this.f79059g.indexOf(this.f79087c));
                }
            }
            ((s) OtcLiteChatPresenter.this.getUI()).x5();
            if (th2 != null && (th2 instanceof APIStatusErrorException)) {
                APIStatusErrorException aPIStatusErrorException = (APIStatusErrorException) th2;
                if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                    HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
                    return;
                }
            }
            HuobiToastUtil.k(BaseApplication.b(), R$string.server_error);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m() {
            OtcChatContent otcChatContent = this.f79087c;
            if (otcChatContent != null) {
                otcChatContent.setProgress(100);
                this.f79087c.setSendStatus(OtcChatContent.ChatImageSendSendStatus.SendSuccess);
                if (OtcLiteChatPresenter.this.f79059g.indexOf(this.f79087c) >= 0) {
                    OtcLiteChatPresenter.this.f79058f.notifyItemChanged(OtcLiteChatPresenter.this.f79059g.indexOf(this.f79087c));
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n() {
            OtcLiteChatPresenter.this.K0(this.f79087c);
            i6.i.b().f(OtcLiteChatPresenter.this.G);
        }

        public void a(int i11) {
            i6.i.b().d(new qp.q(this, i11));
        }

        public void c(Throwable th2, File file) {
            if (this.f79090f) {
                OtcLiteChatPresenter.this.v1(this.f79087c);
            }
            i6.i.b().d(new qp.r(this, th2));
        }

        public void d(File file) {
            OtcChatContent.ChatType chatType;
            if (file != null) {
                OtcChatContent otcChatContent = this.f79088d;
                if (otcChatContent != null) {
                    this.f79087c = otcChatContent;
                }
                boolean z11 = true;
                if (this.f79087c == null) {
                    OtcChatContent otcChatContent2 = new OtcChatContent();
                    this.f79087c = otcChatContent2;
                    otcChatContent2.setOtcDetailData(OtcLiteChatPresenter.this.f79076x);
                    this.f79087c.setFirstSendTime(System.currentTimeMillis());
                    this.f79087c.setLocal(true);
                    this.f79087c.setUri(this.f79089e);
                    OtcLiteChatPresenter.this.f79059g.add(this.f79087c);
                    OtcChatContent otcChatContent3 = this.f79087c;
                    if (this.f79090f) {
                        chatType = OtcChatContent.ChatType.Image;
                    } else {
                        chatType = this.f79091g ? OtcChatContent.ChatType.Pdf : OtcChatContent.ChatType.Video;
                    }
                    otcChatContent3.setLocalChatContentType(chatType);
                    ((s) OtcLiteChatPresenter.this.getUI()).x5();
                    OtcLiteChatPresenter.this.Y0();
                    this.f79087c.setLocalFilePath(file.getPath());
                    this.f79087c.setLocalFileName(this.f79092h);
                }
                this.f79087c.setProgress(0);
                this.f79087c.setSendStatus(OtcChatContent.ChatImageSendSendStatus.Sending);
                OtcChatContent otcChatContent4 = this.f79087c;
                if (OtcLiteChatPresenter.this.J == 0 || System.currentTimeMillis() - OtcLiteChatPresenter.this.J <= 300000) {
                    z11 = false;
                }
                otcChatContent4.setEnoughInterval(z11);
                OtcLiteChatPresenter.this.f79058f.notifyDataSetChanged();
            }
        }

        /* renamed from: o */
        public void e(Response<Object> response, File file) {
            i6.i.b().d(new qp.o(this));
            i6.i.b().g(new qp.p(this), 300);
        }
    }

    public class g extends TypeToken<List<OtcChatContent>> {
        public g() {
        }
    }

    public class h extends EasySubscriber<OtcOrderDetailBean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f79095b;

        public h(boolean z11) {
            this.f79095b = z11;
        }

        /* renamed from: a */
        public void onNext(OtcOrderDetailBean otcOrderDetailBean) {
            super.onNext(otcOrderDetailBean);
            OtcOrderDetailInfo coverData = OtcOrderDetailInfo.coverData(otcOrderDetailBean);
            if (this.f79095b) {
                OtcLiteChatPresenter.this.z1(coverData);
                OtcLiteChatPresenter.this.O0();
            }
            ((s) OtcLiteChatPresenter.this.getUI()).cg(coverData);
            if (!coverData.isTaker()) {
                OtcLiteChatPresenter otcLiteChatPresenter = OtcLiteChatPresenter.this;
                if (otcLiteChatPresenter.f79071s == null) {
                    otcLiteChatPresenter.W0(coverData);
                }
            }
            OtcLiteChatPresenter.this.E1();
            if (coverData.getOtcOrder() != null) {
                int status = coverData.getOtcOrder().getStatus();
                if (status == 2 || status == 3) {
                    i6.i.b().h(OtcLiteChatPresenter.this.H);
                }
            }
        }

        public void onAfter() {
            boolean unused = OtcLiteChatPresenter.this.f79070r = false;
            OtcLiteChatPresenter.this.J0();
        }

        public void onError2(Throwable th2) {
            if (this.f79095b && OtcLiteChatPresenter.this.getUI() != null) {
                ((s) OtcLiteChatPresenter.this.getUI()).f6().k();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (this.f79095b && OtcLiteChatPresenter.this.getUI() != null) {
                ((s) OtcLiteChatPresenter.this.getUI()).f6().k();
            }
        }

        public void onStart() {
            super.onStart();
            boolean unused = OtcLiteChatPresenter.this.f79070r = true;
            if (this.f79095b && OtcLiteChatPresenter.this.getUI() != null) {
                ((s) OtcLiteChatPresenter.this.getUI()).f6().p();
            }
        }
    }

    public class i extends EasySubscriber<UserVO> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcOrderDetailInfo f79097b;

        public i(OtcOrderDetailInfo otcOrderDetailInfo) {
            this.f79097b = otcOrderDetailInfo;
        }

        /* renamed from: a */
        public void onNext(UserVO userVO) {
            super.onNext(userVO);
            OtcLiteChatPresenter otcLiteChatPresenter = OtcLiteChatPresenter.this;
            otcLiteChatPresenter.f79071s = userVO;
            ((s) otcLiteChatPresenter.getUI()).cg(this.f79097b);
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onStart() {
            super.onStart();
        }
    }

    public class j implements x.f {
        public j() {
        }

        public void a(boolean z11, String str, Message$Proto message$Proto) {
            i6.d.j("WebSocketPollingUtil", "PSocketMsgDispatcher OtcLiteChatPresenter  callBack " + message$Proto);
            if (OtcLiteChatPresenter.this.getUI() != null && ((s) OtcLiteChatPresenter.this.getUI()).isAlive() && !TextUtils.equals(str, OtcLiteChatPresenter.this.f79054b)) {
                return;
            }
            if (z11) {
                OtcLiteChatPresenter.this.k1(message$Proto);
            } else {
                OtcLiteChatPresenter.this.l1(message$Proto);
            }
        }
    }

    public class k extends EasySubscriber<VoiceInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f79100b;

        public k(boolean z11) {
            this.f79100b = z11;
        }

        /* renamed from: a */
        public void onNext(VoiceInfo voiceInfo) {
            super.onNext(voiceInfo);
            ((s) OtcLiteChatPresenter.this.getUI()).g5(voiceInfo, this.f79100b);
        }

        public void onError2(Throwable th2) {
            ((s) OtcLiteChatPresenter.this.getUI()).g5((VoiceInfo) null, false);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((s) OtcLiteChatPresenter.this.getUI()).g5((VoiceInfo) null, false);
        }
    }

    public class l extends EasySubscriber<Boolean> {
        public l() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
        }
    }

    public class m extends EasySubscriber<Boolean> {
        public m() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            OtcLiteChatPresenter.this.L0();
        }

        public void onAfter() {
            super.onAfter();
            ((s) OtcLiteChatPresenter.this.getUI()).dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            HuobiToastUtil.j(R$string.n_check_network);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
    }

    public class n extends q6.b<UserVerifyWaysBean> {
        public n(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: a */
        public void onRequestSuccess(UserVerifyWaysBean userVerifyWaysBean) {
            super.onRequestSuccess(userVerifyWaysBean);
            if (userVerifyWaysBean != null) {
                UserVerifyWaysBean unused = OtcLiteChatPresenter.this.F = userVerifyWaysBean;
                s sVar = (s) OtcLiteChatPresenter.this.getUI();
                boolean z11 = true;
                if (userVerifyWaysBean.getUcPhoneStatus() == 1) {
                    z11 = false;
                }
                sVar.Jg(z11);
            }
        }
    }

    public class o implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f79105b;

        public o(String str) {
            this.f79105b = str;
        }

        public void run() {
            OtcLiteChatPresenter.this.R0(this.f79105b);
        }
    }

    public class p extends q6.a<OTCStatusResponse<OnLineStatusBean>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f79107a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(u6.g gVar, String str) {
            super(gVar);
            this.f79107a = str;
        }

        /* renamed from: a */
        public void onRequestSuccess(OTCStatusResponse<OnLineStatusBean> oTCStatusResponse) {
            OtcChatContent otcChatContent;
            if (oTCStatusResponse.isSuccess()) {
                ((s) OtcLiteChatPresenter.this.getUI()).Ae(oTCStatusResponse.getData().isOnline());
                long serverTime = oTCStatusResponse.getData().getServerTime();
                if (!(CollectionsUtils.b(OtcLiteChatPresenter.this.f79059g) || (otcChatContent = (OtcChatContent) OtcLiteChatPresenter.this.f79059g.get(OtcLiteChatPresenter.this.f79059g.size() - 1)) == null || otcChatContent.getOtcChatContent() == null)) {
                    OtcChatContentList.OtcChatDetailContent otcChatContent2 = otcChatContent.getOtcChatContent();
                    if (TextUtils.equals(OtcModuleConfig.a().getUid(), String.valueOf(otcChatContent2.getSendUid())) && serverTime - otcChatContent2.getGmtCreate() > 300000) {
                        boolean unused = OtcLiteChatPresenter.this.A = true;
                        ((s) OtcLiteChatPresenter.this.getUI()).R9(otcChatContent2);
                    }
                }
                if (((s) OtcLiteChatPresenter.this.getUI()).isAlive()) {
                    OtcLiteChatPresenter.this.C1(this.f79107a, true);
                }
            }
        }

        public void onRequestFailure(Throwable th2) {
            OtcLiteChatPresenter.this.C1(this.f79107a, true);
        }
    }

    public class q implements Runnable {
        public q() {
        }

        public void run() {
            OtcLiteChatPresenter.this.L0();
        }
    }

    public class r implements Runnable {
        public r() {
        }

        public void run() {
            if (OtcLiteChatPresenter.this.f79065m) {
                OtcLiteChatPresenter otcLiteChatPresenter = OtcLiteChatPresenter.this;
                otcLiteChatPresenter.r1(otcLiteChatPresenter.f79076x == null);
            }
        }
    }

    public interface s extends SmartRefreshPageSplitter.d {
        void Ae(boolean z11);

        void H3(String str, OtcOrderDetailInfo otcOrderDetailInfo, int i11);

        void Jg(boolean z11);

        void L9(List<Long> list);

        void Q2(boolean z11);

        void R9(OtcChatContentList.OtcChatDetailContent otcChatDetailContent);

        void W2();

        void X0();

        void cg(OtcOrderDetailInfo otcOrderDetailInfo);

        void f8(boolean z11);

        void g5(VoiceInfo voiceInfo, boolean z11);

        void tg(String str);

        void x5();

        void zb();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e1() {
        v9.a<OtcChatContent> aVar;
        if (((s) getUI()).isAlive() && (aVar = this.f79058f) != null && aVar.getItemCount() >= 1) {
            ((s) getUI()).Y0().smoothScrollToPosition(this.f79058f.getItemCount() - 1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f1(HBDialogFragment hBDialogFragment) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getActivity().getPackageName(), (String) null));
        getActivity().startActivity(intent);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ File g1(String str, boolean z11, String str2, boolean z12, Integer num) {
        Uri parse = Uri.parse(str);
        if (z11) {
            File k11 = pa.d.o().k(getActivity(), str2);
            pa.d.o().i(getActivity(), parse, k11);
            return k11;
        }
        if (!z12) {
            pa.d.o().i(getActivity(), parse, pa.d.o().j(getActivity(), str2));
        } else if (!"file".equals(parse.getScheme())) {
            pa.d.o().i(getActivity(), parse, pa.d.o().j(getActivity(), str2));
        }
        if (!z12) {
            return new File(Uri.fromFile(pa.d.o().j(getActivity(), str2)).getPath());
        }
        if (!"file".equals(parse.getScheme())) {
            return ImageUtils.f(getActivity(), Uri.fromFile(pa.d.o().j(getActivity(), str2)).getPath(), 1.0d);
        }
        return ImageUtils.f(getActivity(), Uri.fromFile(new File(parse.getPath())).getPath(), 1.0d);
    }

    public static /* synthetic */ File h1(FileUploadSubscriber fileUploadSubscriber, File file) {
        fileUploadSubscriber.f(file);
        fileUploadSubscriber.d(file);
        return file;
    }

    public final void A1(boolean z11) {
        String str;
        if (z11) {
            OtcOrderDetailInfo otcOrderDetailInfo = this.f79076x;
            str = (otcOrderDetailInfo == null || !otcOrderDetailInfo.getOrder().isSeller()) ? getString(R$string.n_otc_buyer_asap_pay) : getString(R$string.n_otc_wait_buyer_paying);
        } else {
            str = "";
        }
        ((s) getUI()).tg(str);
    }

    public void B1(String str) {
        i6.i.b().h(this.G);
        u1(str);
        i6.i.b().g(this.I, 500);
    }

    public final void C1(String str, boolean z11) {
        if (this.f79077y == null) {
            this.f79077y = new o(str);
        }
        i6.i.b().h(this.f79077y);
        if (!z11) {
            i6.i.b().f(this.f79077y);
        } else {
            i6.i.b().g(this.f79077y, 45000);
        }
    }

    public final void D1() {
        if (this.f79076x != null) {
            O0();
        }
    }

    public void E0() {
        OtcChatContentList.OtcChatDetailContent otcChatContent;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) ((s) getUI()).Y0().getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition == -1 && findLastVisibleItemPosition == -1 && !CollectionsUtils.b(this.f79058f.c())) {
            findFirstVisibleItemPosition = this.f79058f.c().size() - 1;
            findLastVisibleItemPosition = this.f79058f.c().size() - 1;
        }
        if (findFirstVisibleItemPosition >= 0 && this.f79058f != null) {
            for (int i11 = findFirstVisibleItemPosition; i11 <= findLastVisibleItemPosition; i11++) {
                OtcChatContent d11 = this.f79058f.d(i11);
                if ((d11 instanceof OtcChatContent) && (otcChatContent = d11.getOtcChatContent()) != null && !b1(otcChatContent) && otcChatContent.getReadState() == 0 && !this.f79068p.contains(Long.valueOf(otcChatContent.getId()))) {
                    this.f79068p.add(Long.valueOf(otcChatContent.getId()));
                    i6.d.j("sdfsdfsdfdsf", "onScrolled-firstCompletelyVIPos->" + findFirstVisibleItemPosition + "  last->" + findLastVisibleItemPosition + " id->" + otcChatContent.getId());
                }
            }
        }
    }

    public final void E1() {
        OtcOrderDetailInfo otcOrderDetailInfo = this.f79076x;
        if (otcOrderDetailInfo == null || otcOrderDetailInfo.getOrder().getStatus() != 0) {
            A1(false);
        } else {
            A1(true);
        }
    }

    public void F0() {
        if (this.F == null) {
            s8.a.a().userVerifyWays().d(new n((u6.g) getUI()));
        }
    }

    public void G0() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{PermissionConfig.READ_MEDIA_IMAGES, "android.permission.CAMERA"};
        } else {
            strArr = new String[]{PermissionConfig.READ_EXTERNAL_STORAGE, "android.permission.CAMERA"};
        }
        if (EasyPermissions.hasPermissions(getActivity(), strArr)) {
            i6.i.b().h(this.G);
            pa.d.o().B(false).q(getActivity());
            ((s) getUI()).W2();
            return;
        }
        if (!EasyPermissions.hasPermissions(getActivity(), strArr[0])) {
            EasyPermissions.requestPermissions(getActivity(), 123, strArr);
            return;
        }
        EasyPermissions.requestPermissions(getActivity(), 123, strArr[1]);
    }

    public void H0(boolean z11) {
        jp.l.f(this.f79054b, z11).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new l());
    }

    public void I0() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f79068p);
        String N0 = N0();
        if (!TextUtils.isEmpty(N0)) {
            HashMap hashMap = new HashMap();
            hashMap.put("orderId", this.f79054b);
            hashMap.put("idList", N0);
            s8.a.a().chatRead(hashMap).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c(arrayList));
        }
    }

    public final void J0() {
        if (this.f79065m) {
            i6.i.b().h(this.H);
            i6.i.b().g(this.H, this.f79076x == null ? 0 : 5000);
        }
    }

    public final synchronized void K0(OtcChatContent otcChatContent) {
        if (otcChatContent != null) {
            try {
                List<OtcChatContent> V0 = V0();
                if (!CollectionsUtils.b(V0) && V0.contains(otcChatContent)) {
                    V0.remove(otcChatContent);
                }
                ConfigPreferences.m("otc_config", "otc_chat_image_uri_new" + this.f79054b + OtcModuleConfig.a().getUid(), GsonHelper.a().toJson((Object) V0));
                File file = new File(otcChatContent.getLocalFilePath());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } else {
            return;
        }
        return;
    }

    public final synchronized void L0() {
        Map<String, Object> map;
        if (this.f79062j == 0 && this.f79061i == 0 && this.L == 0) {
            ((s) getUI()).f6().p();
            this.M = true;
        }
        this.L = System.currentTimeMillis();
        if (this.f79062j != 0) {
            if (!this.K) {
                map = MapParamsBuilder.c().a(CommunityConstants.LAST_ID, Long.valueOf(this.f79062j)).b();
                Subscription subscription = this.f79073u;
                if (subscription != null && subscription.isUnsubscribed()) {
                    this.f79073u.unsubscribe();
                    this.f79073u = null;
                }
                this.f79073u = ((OTCService) OtcRetrofit.request(OTCService.class)).getChatList(this.f79054b, map).compose(OtcRetrofit.o()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new b());
            }
        }
        if (this.f79061i != 0) {
            map = MapParamsBuilder.c().a("firstId", Long.valueOf(this.f79061i)).b();
        } else {
            map = MapParamsBuilder.c().b();
        }
        Subscription subscription2 = this.f79073u;
        this.f79073u.unsubscribe();
        this.f79073u = null;
        this.f79073u = ((OTCService) OtcRetrofit.request(OTCService.class)).getChatList(this.f79054b, map).compose(OtcRetrofit.o()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new b());
    }

    public final synchronized void M0(OtcChatContentList otcChatContentList) {
        List<OtcChatContentList.OtcChatDetailContent> list;
        if (this.f79061i == 0) {
            this.f79059g.clear();
            this.f79063k.clear();
        }
        List<OtcChatContent> list2 = this.f79059g;
        if (list2 != null && list2.size() > 0 && (list = otcChatContentList.getList()) != null && list.size() > 0) {
            Iterator<OtcChatContentList.OtcChatDetailContent> it2 = list.iterator();
            while (it2.hasNext()) {
                if (this.f79064l.contains(Long.valueOf(it2.next().getId()))) {
                    it2.remove();
                }
            }
        }
        this.f79060h.clear();
        if (otcChatContentList.getList() != null && otcChatContentList.getList().size() > 0) {
            this.M = false;
            int size = otcChatContentList.getList().size();
            int i11 = 0;
            for (OtcChatContentList.OtcChatDetailContent next : otcChatContentList.getList()) {
                this.f79064l.add(Long.valueOf(next.getId()));
                i11++;
                if (i11 == 1) {
                    long id2 = next.getId();
                    long j11 = this.f79061i;
                    if (j11 > id2 || j11 == 0) {
                        this.f79061i = id2;
                    }
                }
                if (i11 == size) {
                    long id3 = next.getId();
                    if (this.f79062j < id3) {
                        this.f79062j = id3;
                    }
                }
                OtcChatContent otcChatContent = new OtcChatContent();
                otcChatContent.setOtcChatContent(next);
                otcChatContent.setOtcDetailData(this.f79076x);
                otcChatContent.setCurrentUser(b1(next));
                if (this.J == 0 || next.getGmtCreate() - this.J <= 300000) {
                    otcChatContent.setEnoughInterval(false);
                } else {
                    otcChatContent.setEnoughInterval(true);
                }
                this.J = next.getGmtCreate();
                if (!this.f79063k.contains(Long.valueOf(next.getId()))) {
                    this.f79063k.add(Long.valueOf(next.getId()));
                    if (this.K) {
                        this.f79060h.add(otcChatContent);
                    } else {
                        this.f79059g.add(otcChatContent);
                    }
                }
            }
            if (this.f79060h.size() > 0) {
                this.f79059g.addAll(0, this.f79060h);
            }
            if (!CollectionsUtils.b(this.f79059g)) {
                int i12 = 0;
                while (i12 < this.f79059g.size()) {
                    OtcChatContent otcChatContent2 = this.f79059g.get(i12);
                    if (otcChatContent2 == null || otcChatContent2.getSendStatus() != OtcChatContent.ChatImageSendSendStatus.SendSuccess) {
                        i12++;
                    } else {
                        this.f79059g.remove(i12);
                    }
                }
            }
            if (this.f79069q) {
                this.f79069q = false;
                List<OtcChatContent> V0 = V0();
                if (!CollectionsUtils.b(V0)) {
                    for (int i13 = 0; i13 < V0.size(); i13++) {
                        OtcChatContent otcChatContent3 = V0.get(i13);
                        if (otcChatContent3 != null) {
                            otcChatContent3.setOtcDetailData(this.f79076x);
                            this.f79059g.add(otcChatContent3);
                            otcChatContent3.setProgress(0);
                            otcChatContent3.setSendStatus(OtcChatContent.ChatImageSendSendStatus.SendFail);
                            otcChatContent3.setEnoughInterval(this.J != 0 && System.currentTimeMillis() - this.J > 300000);
                        }
                    }
                }
            }
            E1();
            this.f79058f.notifyDataSetChanged();
            if (this.K) {
                this.K = false;
                ((s) getUI()).X0();
            } else {
                Y0();
            }
            if (this.f79077y == null) {
                C1(String.valueOf(this.f79078z), false);
            }
        } else if (this.K) {
            ((s) getUI()).X0();
            this.K = false;
        }
    }

    public final String N0() {
        if (this.f79068p.isEmpty()) {
            return null;
        }
        int size = this.f79068p.size();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < size; i11++) {
            sb2.append(this.f79068p.get(i11));
            if (i11 < size - 1) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        this.f79068p.clear();
        i6.d.j("sdfsdfsdfdsf", "stringBuilder.toString()->" + sb2.toString());
        return sb2.toString();
    }

    public final void O0() {
        i6.i.b().h(this.G);
        i6.i.b().f(this.G);
    }

    public String P0(Context context, Uri uri) {
        i1.a a11;
        if (context == null || uri == null || (a11 = i1.a.a(context, uri)) == null) {
            return null;
        }
        return a11.b();
    }

    public final void Q0() {
        i6.i.b().h(this.G);
        i6.i.b().g(this.G, 1500);
    }

    public final void R0(String str) {
        s8.a.a().getOnLineStatus(str).d(new p((u6.g) getUI(), str));
    }

    public String S0() {
        return this.f79054b;
    }

    public String T0() {
        OtcOrderDetailInfo otcOrderDetailInfo = this.f79076x;
        return otcOrderDetailInfo != null ? otcOrderDetailInfo.getOtherInfo().getUserName() : "";
    }

    public final String U0(Response<OtcUploadPicBean> response) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (response.body() != null) {
                jSONObject.put("fileName", response.body().getFileName());
                jSONObject.put("url", response.body().getData());
                jSONObject.put("fileSize", response.body().getFileSize());
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject.toString();
    }

    public final synchronized List<OtcChatContent> V0() {
        List<OtcChatContent> list;
        list = null;
        String d11 = ConfigPreferences.d("otc_config", "otc_chat_image_uri_new" + this.f79054b + OtcModuleConfig.a().getUid());
        if (!TextUtils.isEmpty(d11)) {
            try {
                list = (List) GsonHelper.a().fromJson(d11, new g().getType());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return list;
    }

    public final void W0(OtcOrderDetailInfo otcOrderDetailInfo) {
        s8.a.a().getUser().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new i(otcOrderDetailInfo));
    }

    public void X0(boolean z11) {
        jp.l.s(OtcModuleConfig.a().getUid(), this.f79054b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new k(z11));
    }

    public void Y0() {
        if (this.E == null) {
            this.E = new qp.j(this);
        }
        ((s) getUI()).Y0().removeCallbacks(this.E);
        ((s) getUI()).Y0().postDelayed(this.E, 100);
    }

    public final void Z0() {
        if (this.M) {
            this.L = 0;
            this.M = false;
            ((s) getUI()).f6().k();
            return;
        }
        ((s) getUI()).f6().g();
    }

    public final void a1(boolean z11) {
        i6.i.b().h(this.I);
        ((s) getUI()).Q2(false);
        i6.i.b().f(this.G);
        if (z11) {
            HuobiToastUtil.k(BaseApplication.b(), R$string.server_error);
        }
    }

    public boolean b1(OtcChatContentList.OtcChatDetailContent otcChatDetailContent) {
        return !TextUtils.equals(otcChatDetailContent.getSendUid(), String.valueOf(this.f79055c));
    }

    public boolean c1() {
        return this.A;
    }

    public boolean d1() {
        return this.f79057e;
    }

    public final void k1(Message$Proto message$Proto) {
        OtcChatContent.ChatType chatType;
        OtcChatContentList otcChatContentList = new OtcChatContentList();
        try {
            OtcChatContentList.OtcChatDetailContent otcChatDetailContent = (OtcChatContentList.OtcChatDetailContent) GsonHelper.a().fromJson(message$Proto.getExtra(), OtcChatContentList.OtcChatDetailContent.class);
            if (otcChatDetailContent != null) {
                int format = message$Proto.getFormat();
                if (1 == format) {
                    chatType = OtcChatContent.ChatType.Image;
                } else if (2 == format) {
                    chatType = OtcChatContent.ChatType.Video;
                } else {
                    chatType = 3 == format ? OtcChatContent.ChatType.Pdf : OtcChatContent.ChatType.Text;
                }
                otcChatDetailContent.setChatContentType(chatType);
                otcChatDetailContent.setChatContent(message$Proto.getContent());
                otcChatDetailContent.setGmtCreate(message$Proto.getTimestamp());
                otcChatDetailContent.setChatType(message$Proto.getAction());
                otcChatDetailContent.setSendUid(message$Proto.getFromId() + "");
                ArrayList arrayList = new ArrayList();
                arrayList.add(otcChatDetailContent);
                otcChatContentList.setList(arrayList);
                M0(otcChatContentList);
                ((s) getUI()).f6().g();
                i6.d.j("WebSocketPollingUtil", "PSocketMsgDispatcher ChatMessageCallBack  callBack " + otcChatDetailContent.getId() + " " + otcChatDetailContent.getChatContent());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            i6.d.j("WebSocketPollingUtil", "PSocketMsgDispatcher ChatMessageCallBack  Exception " + e11.getMessage());
        }
    }

    public final void l1(Message$Proto message$Proto) {
        String[] split;
        List<OtcChatContent> list = this.f79059g;
        if (list != null && !list.isEmpty()) {
            String content = message$Proto.getContent();
            if (!TextUtils.isEmpty(content) && (split = content.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length != 0) {
                for (int i11 = 0; i11 < this.f79059g.size(); i11++) {
                    OtcChatContent otcChatContent = this.f79059g.get(i11);
                    OtcChatContentList.OtcChatDetailContent otcChatContent2 = otcChatContent.getOtcChatContent();
                    if (otcChatContent2 != null) {
                        int length = split.length;
                        int i12 = 0;
                        while (true) {
                            if (i12 >= length) {
                                break;
                            }
                            if (TextUtils.equals(String.valueOf(otcChatContent2.getId()), split[i12])) {
                                otcChatContent2.setReadState(1);
                                this.f79058f.notifyItemChanged(i11, otcChatContent);
                                break;
                            }
                            i12++;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: m1 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, s sVar) {
        super.onUIReady(baseCoreActivity, sVar);
        EventBus.d().p(this);
        Intent intent = getActivity().getIntent();
        if (!(intent == null || intent.getExtras() == null)) {
            this.f79056d = intent.getIntExtra("merchantLevel", 0);
            this.f79057e = intent.getBooleanExtra("needBackToDetailPage", false);
            OtcOrderDetailInfo otcOrderDetailInfo = (OtcOrderDetailInfo) intent.getSerializableExtra("otcOrder");
            this.f79076x = otcOrderDetailInfo;
            if (otcOrderDetailInfo != null) {
                z1(otcOrderDetailInfo);
            } else {
                String stringExtra = intent.getStringExtra("orderId");
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.f79054b = stringExtra;
                }
            }
        }
        this.f79059g = new ArrayList();
        this.f79060h = new ArrayList();
        this.f79063k = new HashSet<>();
        this.f79058f = new v9.a<>(this.f79059g);
        ((s) getUI()).Y0().setAdapter(this.f79058f);
    }

    public void n1(String str, String str2, long j11) {
        String[] strArr = Build.VERSION.SDK_INT >= 33 ? new String[]{PermissionConfig.READ_MEDIA_IMAGES} : new String[]{PermissionConfig.WRITE_EXTERNAL_STORAGE, PermissionConfig.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(getActivity(), strArr)) {
            OtcPdfPreviewActivity.vh(getActivity(), str, str2, j11);
            return;
        }
        this.B = str;
        this.C = str2;
        this.D = j11;
        EasyPermissions.requestPermissions(getActivity(), 132, strArr);
    }

    public void o1() {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.READ_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(getActivity(), str)) {
            i6.i.b().h(this.G);
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("application/pdf");
            Intent createChooser = Intent.createChooser(intent, "");
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                getActivity().startActivityForResult(createChooser, 131);
            }
            ((s) getUI()).W2();
            return;
        }
        EasyPermissions.requestPermissions(getActivity(), 131, str);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        Uri data;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 131) {
            if (intent != null && intent.getData() != null && (data = intent.getData()) != null) {
                String P0 = P0(getActivity(), data);
                if (TextUtils.isEmpty(P0) || P0.lastIndexOf(InstructionFileId.DOT) < 0) {
                    HuobiToastUtil.j(R$string.n_not_support);
                } else if ("pdf".equalsIgnoreCase(P0.substring(P0.lastIndexOf(InstructionFileId.DOT) + 1))) {
                    x1(data.toString(), (OtcChatContent) null, P0, false, true);
                } else {
                    HuobiToastUtil.j(R$string.n_not_support);
                }
            }
        } else if (i12 != -1) {
            i6.i.b().f(this.G);
        } else {
            pa.d.o().C(new e()).x(getActivity(), i11, i12, intent);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onCallEnd(OtcCallEndEvent otcCallEndEvent) {
        i6.d.c("sdfsdfsdf", "OtcCallEndEvent --->" + otcCallEndEvent.orderId);
        if (getUI() != null && ((s) getUI()).isAlive() && TextUtils.equals(otcCallEndEvent.orderId, S0())) {
            X0(false);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        x.j().r(this.f79054b, this.f79075w);
        i6.i.b().h(this.G);
        i6.i.b().h(this.H);
        i6.i.b().h(this.I);
        i6.i.b().h(this.f79077y);
        Subscription subscription = this.f79073u;
        if (subscription != null && subscription.isUnsubscribed()) {
            this.f79073u.unsubscribe();
            this.f79073u = null;
        }
        Subscription subscription2 = this.f79074v;
        if (subscription2 != null && subscription2.isUnsubscribed()) {
            this.f79074v.unsubscribe();
            this.f79074v = null;
        }
        EventBus.d().r(this);
    }

    public void onPause() {
        super.onPause();
        i6.i.b().h(this.G);
        i6.i.b().h(this.H);
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(getActivity(), list)) {
            ((s) getUI()).W2();
            DialogUtils.c0(getActivity(), getActivity().getResources().getString((i11 == 124 || i11 == 131 || i11 == 132) ? R$string.n_permission_alert_storage : com.hbg.lib.widgets.R$string.n_permission_alert_camera), (String) null, getActivity().getResources().getString(com.hbg.lib.widgets.R$string.n_cancel), getActivity().getResources().getString(com.hbg.lib.widgets.R$string.staring_remind_to_open), o0.f12469a, new qp.i(this));
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        String[] strArr;
        i6.i.b().h(this.G);
        if (i11 == 123) {
            if (Build.VERSION.SDK_INT >= 33) {
                strArr = new String[]{PermissionConfig.READ_MEDIA_IMAGES, "android.permission.CAMERA"};
            } else {
                strArr = new String[]{PermissionConfig.READ_EXTERNAL_STORAGE, "android.permission.CAMERA"};
            }
            if (EasyPermissions.hasPermissions(getActivity(), strArr)) {
                G0();
                ((s) getUI()).W2();
            }
        } else if (i11 == 124) {
            p1();
            ((s) getUI()).W2();
        } else if (i11 == 131) {
            o1();
            ((s) getUI()).W2();
        } else if (i11 == 132) {
            n1(this.B, this.C, this.D);
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.f79067o) {
            this.f79065m = true;
            D1();
        } else {
            this.f79067o = false;
        }
        J0();
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && ((s) getUI()).isAlive()) {
            Intent M2 = OtcModuleConfig.a().M(getActivity());
            OtcModuleConfig.a().l(getActivity(), M2, M2);
        }
    }

    public void p1() {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.READ_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(getActivity(), str)) {
            i6.i.b().h(this.G);
            pa.d.o().B(false).v(getActivity(), 10);
            ((s) getUI()).W2();
            return;
        }
        EasyPermissions.requestPermissions(getActivity(), 124, str);
    }

    public void q1(boolean z11) {
        this.K = z11;
        i6.i.b().h(this.G);
        L0();
    }

    public void r1(boolean z11) {
        if (!this.f79070r) {
            Subscription subscription = this.f79074v;
            if (subscription != null && subscription.isUnsubscribed()) {
                this.f79074v.unsubscribe();
                this.f79074v = null;
            }
            this.f79074v = jp.l.m(this.f79054b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new h(z11));
        }
    }

    @k20.h
    @Keep
    public void reSendImage(ChatReSendEvent chatReSendEvent) {
        if (chatReSendEvent != null && ((s) getUI()).isAlive()) {
            String uri = chatReSendEvent.getOtcChatContent().getUri();
            OtcChatContent otcChatContent = chatReSendEvent.getOtcChatContent();
            String localFileName = chatReSendEvent.getOtcChatContent().getLocalFileName();
            boolean z11 = false;
            boolean z12 = chatReSendEvent.getOtcChatContent().getLocalChatContentType() == OtcChatContent.ChatType.Image;
            if (chatReSendEvent.getOtcChatContent().getLocalChatContentType() == OtcChatContent.ChatType.Pdf) {
                z11 = true;
            }
            x1(uri, otcChatContent, localFileName, z12, z11);
        }
    }

    public void s1() {
        ((s) getUI()).showProgressDialog();
        jp.l.H(this.f79054b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new m());
    }

    /* renamed from: t1 */
    public final Observable<Response<Object>> j1(boolean z11, boolean z12, Response<OtcUploadPicBean> response) {
        String str;
        String str2;
        String str3;
        if (response == null || !response.isSuccessful()) {
            if (response == null || response.message() == null) {
                str = BaseApplication.b().getResources().getString(R$string.server_error);
            } else {
                str = response.message();
            }
            throw new IllegalStateException(str);
        }
        s8.b a11 = s8.a.a();
        String valueOf = String.valueOf(this.f79054b);
        if (z12) {
            str2 = U0(response);
        } else if (response.body() == null) {
            str2 = response.raw().message();
        } else {
            str2 = response.body().getData();
        }
        if (z11) {
            str3 = OtcChatContent.ChatType.Image.value;
        } else {
            str3 = (z12 ? OtcChatContent.ChatType.Pdf : OtcChatContent.ChatType.Video).value;
        }
        return a11.saveChatContent(valueOf, str2, str3).b();
    }

    public final void u1(String str) {
        s8.a.a().saveChatContent(this.f79054b, str, OtcChatContent.ChatType.Text.value).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
    }

    public final synchronized void v1(OtcChatContent otcChatContent) {
        if (otcChatContent != null) {
            List V0 = V0();
            if (V0 == null) {
                V0 = new ArrayList();
            }
            if (!V0.contains(otcChatContent)) {
                V0.add(otcChatContent);
                ConfigPreferences.m("otc_config", "otc_chat_image_uri_new" + this.f79054b + OtcModuleConfig.a().getUid(), GsonHelper.a().toJson((Object) V0));
            }
        }
    }

    public final synchronized void w1(String str, OtcChatContent otcChatContent, String str2, boolean z11) {
        x1(str, otcChatContent, str2, z11, false);
    }

    public final synchronized void x1(String str, OtcChatContent otcChatContent, String str2, boolean z11, boolean z12) {
        if (str != null) {
            f fVar = new f(otcChatContent, str, z11, z12, str2);
            Observable.just(0).subscribeOn(Schedulers.io()).map(new qp.m(this, str, z12, str2, z11)).observeOn(AndroidSchedulers.mainThread()).map(new qp.k(fVar)).observeOn(Schedulers.io()).concatMap(new qp.l(fVar, z11, z12)).concatMap(new qp.n(this, z11, z12)).observeOn(AndroidSchedulers.mainThread()).subscribe(fVar);
        }
    }

    public void y1(boolean z11) {
        this.A = z11;
    }

    public final void z1(OtcOrderDetailInfo otcOrderDetailInfo) {
        this.f79076x = otcOrderDetailInfo;
        OtcOrderBean otcOrder = otcOrderDetailInfo.getOtcOrder();
        this.f79053a = otcOrder.getTradeUserName();
        this.f79055c = otcOrder.getTradeUid();
        this.f79054b = otcOrder.getId();
        OtherInfoBean otherInfo = otcOrderDetailInfo.getOtherInfo();
        this.f79056d = otherInfo.getMerchantLevel();
        this.f79078z = otherInfo.getUid();
        ((s) getUI()).H3(this.f79053a, otcOrderDetailInfo, this.f79056d);
        int status = otcOrder.getStatus();
        if (status == 2 || status == 3) {
            this.f79065m = false;
        } else {
            this.f79065m = true;
        }
    }
}
