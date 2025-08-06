package com.huobi.invite.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.invite.bean.InvitePosterItem;
import com.huobi.invite.bean.InviteRecordList;
import com.huobi.invite.bean.InviteRecordListItem;
import com.huobi.invite.bean.InviteReturnRank;
import com.huobi.invite.bean.InviteReturnRecordList;
import com.huobi.invite.bean.InviteReturnRecordListItem;
import com.huobi.invite.bean.InviteReturnSum;
import com.huobi.invite.bean.InviterInfo;
import com.huobi.invite.helper.InviteReturnHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.c1;
import com.huobi.utils.d1;
import com.huobi.utils.k0;
import com.huobi.utils.x;
import com.tencent.android.tpush.common.Constants;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StringCodec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;

@Route(path = "/account/invite")
public class InviteActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public InviteReturnRank f74545k;

    /* renamed from: l  reason: collision with root package name */
    public String f74546l;

    /* renamed from: m  reason: collision with root package name */
    public InviterInfo f74547m;

    /* renamed from: n  reason: collision with root package name */
    public InviteReturnSum f74548n;

    /* renamed from: o  reason: collision with root package name */
    public ArrayList<InvitePosterItem> f74549o;

    /* renamed from: p  reason: collision with root package name */
    public InviteShareFragment f74550p;

    /* renamed from: q  reason: collision with root package name */
    public BasicMessageChannel<String> f74551q;

    public class a extends EasySubscriber<ArrayList<InvitePosterItem>> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(ArrayList<InvitePosterItem> arrayList) {
            super.onNext(arrayList);
            ArrayList unused = InviteActivity.this.f74549o = arrayList;
        }
    }

    public class b implements MethodChannel.MethodCallHandler {
        public b() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            InviteActivity.this.Ui(methodCall, result);
        }
    }

    public class c implements MethodChannel.MethodCallHandler {
        public c() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            InviteActivity.this.Ui(methodCall, result);
        }
    }

    public class d implements MethodChannel.MethodCallHandler {
        public d() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            InviteActivity.this.Ui(methodCall, result);
        }
    }

    public class e extends EasySubscriber<InviteReturnRank> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f74556b;

        public e(MethodChannel.Result result) {
            this.f74556b = result;
        }

        /* renamed from: a */
        public void onNext(InviteReturnRank inviteReturnRank) {
            super.onNext(inviteReturnRank);
            if (this.f74556b != null) {
                String json = new Gson().toJson((Object) inviteReturnRank);
                Log.i("flutter", "requestRank json = " + json);
                this.f74556b.success(json);
            }
            if (inviteReturnRank != null) {
                InviteReturnRank unused = InviteActivity.this.f74545k = inviteReturnRank;
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            MethodChannel.Result result = this.f74556b;
            if (result != null) {
                result.notImplemented();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            MethodChannel.Result result = this.f74556b;
            if (result != null) {
                result.notImplemented();
            }
        }
    }

    public class f extends q6.d<InviteReturnRank> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f74558e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(u6.g gVar, MethodChannel.Result result) {
            super(gVar);
            this.f74558e = result;
        }

        /* renamed from: f */
        public void onNext(InviteReturnRank inviteReturnRank) {
            super.onNext(inviteReturnRank);
            String json = new Gson().toJson((Object) inviteReturnRank);
            MethodChannel.Result result = this.f74558e;
            if (result != null) {
                result.success(json);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            MethodChannel.Result result = this.f74558e;
            if (result != null) {
                result.notImplemented();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            MethodChannel.Result result = this.f74558e;
            if (result != null) {
                result.notImplemented();
            }
        }
    }

    public class g extends EasySubscriber<InviterInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f74560b;

        public g(MethodChannel.Result result) {
            this.f74560b = result;
        }

        /* renamed from: a */
        public void onNext(InviterInfo inviterInfo) {
            super.onNext(inviterInfo);
            if (this.f74560b != null) {
                inviterInfo.setShareUrl(InviteActivity.this.Si(inviterInfo.getInviteCode()));
                String json = new Gson().toJson((Object) inviterInfo);
                Log.i("flutter", "requestInviteGet json = " + json);
                this.f74560b.success(json);
            }
            if (inviterInfo != null) {
                String unused = InviteActivity.this.f74546l = inviterInfo.getInviteCode();
                InviterInfo unused2 = InviteActivity.this.f74547m = inviterInfo;
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            MethodChannel.Result result = this.f74560b;
            if (result != null) {
                result.notImplemented();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            MethodChannel.Result result = this.f74560b;
            if (result != null) {
                result.notImplemented();
            }
        }
    }

    public class h extends EasySubscriber<InviteReturnSum> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f74562b;

        public h(MethodChannel.Result result) {
            this.f74562b = result;
        }

        /* renamed from: a */
        public void onNext(InviteReturnSum inviteReturnSum) {
            super.onNext(inviteReturnSum);
            if (this.f74562b != null) {
                String json = new Gson().toJson((Object) inviteReturnSum);
                Log.i("flutter", "requestInviteReturnSum json = " + json);
                this.f74562b.success(json);
            }
            if (inviteReturnSum != null) {
                InviteReturnSum unused = InviteActivity.this.f74548n = inviteReturnSum;
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            MethodChannel.Result result = this.f74562b;
            if (result != null) {
                result.notImplemented();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            MethodChannel.Result result = this.f74562b;
            if (result != null) {
                result.notImplemented();
            }
        }
    }

    public class i extends q6.d<List<InviteRecordListItem>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f74564e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(u6.g gVar, MethodChannel.Result result) {
            super(gVar);
            this.f74564e = result;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
            MethodChannel.Result result = this.f74564e;
            if (result != null) {
                result.notImplemented();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            MethodChannel.Result result = this.f74564e;
            if (result != null) {
                result.notImplemented();
            }
        }

        public void onNext(List<InviteRecordListItem> list) {
            super.onNext(list);
            InviteRecordList inviteRecordList = new InviteRecordList();
            inviteRecordList.setRecord(list);
            String json = new Gson().toJson((Object) inviteRecordList);
            MethodChannel.Result result = this.f74564e;
            if (result != null) {
                result.success(json);
            }
        }
    }

    public class j extends q6.d<List<InviteReturnRecordListItem>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f74566e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(u6.g gVar, MethodChannel.Result result) {
            super(gVar);
            this.f74566e = result;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
            MethodChannel.Result result = this.f74566e;
            if (result != null) {
                result.notImplemented();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            aPIStatusErrorException.printStackTrace();
            MethodChannel.Result result = this.f74566e;
            if (result != null) {
                result.notImplemented();
            }
        }

        public void onNext(List<InviteReturnRecordListItem> list) {
            super.onNext(list);
            InviteReturnRecordList inviteReturnRecordList = new InviteReturnRecordList();
            inviteReturnRecordList.setRecord(list);
            String json = new Gson().toJson((Object) inviteReturnRecordList);
            MethodChannel.Result result = this.f74566e;
            if (result != null) {
                result.success(json);
            }
        }
    }

    public static /* synthetic */ void Ti(String str) {
        Log.i("flutter", "addFirstFrameListener reply = " + str);
        boolean equals = "init finish".equals(str);
        Log.i("flutter", "isInviteFlutterInitSuccess = " + equals);
    }

    public final void Ki() {
        String str = this.f74546l;
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str));
        HuobiToastUtil.t(this, R.string.currency_detail_notice_dialog_toast);
    }

    public final void Li() {
        String Ri = Ri();
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(Ri, Ri));
        HuobiToastUtil.t(this, R.string.currency_detail_notice_dialog_toast);
    }

    public void Mi(MethodChannel.Result result) {
        InviteReturnHelper.e().compose(RxJavaHelper.t((u6.g) null)).subscribe(new g(result));
    }

    public String Nh() {
        return "invite";
    }

    public final void Ni() {
        InviteReturnHelper.a().compose(RxJavaHelper.t((u6.g) null)).subscribe(new a());
    }

    public void Oi(MethodChannel.Result result) {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        HashMap hashMap = new HashMap();
        hashMap.put("end-date", format);
        hashMap.put("size", "3");
        InviteReturnHelper.c(hashMap).compose(RxJavaHelper.t((u6.g) null)).subscribe(new e(result));
    }

    public void Pi(String str, String str2, MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        hashMap.put("end-date", str);
        hashMap.put("size", str2);
        InviteReturnHelper.c(hashMap).compose(RxJavaHelper.t((u6.g) null)).subscribe(new f((u6.g) null, result));
    }

    public void Qi(MethodChannel.Result result) {
        InviteReturnHelper.d().compose(RxJavaHelper.t((u6.g) null)).subscribe(new h(result));
    }

    public final String Ri() {
        String str;
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            if (x.d()) {
                str = DomainSwitcher.C();
            } else {
                str = DomainSwitcher.E();
            }
        } else if (x.d()) {
            str = DomainSwitcher.D();
        } else {
            str = DomainSwitcher.F();
        }
        return str + this.f74546l;
    }

    public final String Si(String str) {
        String str2;
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            if (x.d()) {
                str2 = DomainSwitcher.C();
            } else {
                str2 = DomainSwitcher.E();
            }
        } else if (x.d()) {
            str2 = DomainSwitcher.D();
        } else {
            str2 = DomainSwitcher.F();
        }
        return str2 + str;
    }

    public void Ui(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("requestRank".equals(str)) {
                String str2 = (String) methodCall.argument("size");
                String str3 = (String) methodCall.argument(FirebaseAnalytics.Param.END_DATE);
                if (TextUtils.isEmpty(str2)) {
                    Oi(result);
                } else {
                    Pi(str3, str2, result);
                }
            } else if ("requestInviteGet".equals(str)) {
                Mi(result);
            } else if ("requestInviteReturnSum".equals(str)) {
                Qi(result);
            } else if ("requestInviteRecord".equals(str)) {
                String str4 = (String) methodCall.argument("limit");
                String str5 = (String) methodCall.argument("version");
                Wi(result, (String) methodCall.argument("state"), (String) methodCall.argument(Constants.FLAG_TAG_OFFSET));
            } else if ("requestRebateRecord".equals(str)) {
                Xi(result, (String) methodCall.argument("startDate"), (String) methodCall.argument("endDate"), Integer.parseInt((String) methodCall.argument("from")));
            } else if ("showSharePosterDialog".equals(str)) {
                Yi((String) methodCall.argument("share_url"));
            } else if ("openRule".equals(str)) {
                Vi();
            } else if ("copyInviteUrl".equals(str)) {
                Li();
            } else if ("copyInviteCode".equals(str)) {
                Ki();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void Vi() {
        HBBaseWebActivity.showWebView(this, c1.d().replace("{language}", d1.h()), getResources().getString(R.string.invite_return_rule), getResources().getString(R.string.head_return), false);
    }

    public void Wi(MethodChannel.Result result, String str, String str2) {
        Map<String, Object> map;
        if (Integer.parseInt(str) == -1) {
            map = MapParamsBuilder.c().a(Constants.FLAG_TAG_OFFSET, str2).a("limit", 20).a("version", 2).b();
        } else {
            map = MapParamsBuilder.c().a("state", str).a(Constants.FLAG_TAG_OFFSET, str2).a("limit", 20).a("version", 2).b();
        }
        InviteReturnHelper.b(map).compose(RxJavaHelper.t((u6.g) null)).subscribe(new i((u6.g) null, result));
    }

    public void Xi(MethodChannel.Result result, String str, String str2, int i11) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("start-date", str);
        hashMap.put("end-date", str2);
        if (i11 != 0) {
            hashMap.put("from", Integer.valueOf(i11));
        }
        hashMap.put("size", "21");
        InviteReturnHelper.f(hashMap).compose(RxJavaHelper.t((u6.g) null)).subscribe(new j((u6.g) null, result));
    }

    public final void Yi(String str) {
        if (!NetworkStatus.c(getApplicationContext())) {
            HuobiToastUtil.j(R.string.server_error);
        } else if (!x.e(this.f74549o)) {
            InviteShareFragment inviteShareFragment = this.f74550p;
            if (inviteShareFragment == null || !inviteShareFragment.isVisible()) {
                this.f74550p = new InviteShareFragment();
                if (TextUtils.isEmpty(str)) {
                    str = Ri();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("noNeedPic", false);
                this.f74550p.setArguments(bundle);
                this.f74550p.ei(this.f74546l);
                this.f74550p.fi(str);
                this.f74550p.gi(true);
                this.f74550p.hi(this.f74549o);
                this.f74550p.show(getSupportFragmentManager(), "invite_poster_share[17]");
            }
        } else {
            HuobiToastUtil.g(R.string.invite_share_poster_none);
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "invite_data_channel").setMethodCallHandler(new b());
        new MethodChannel(flutterEngine.getDartExecutor(), "invite_method").setMethodCallHandler(new c());
        new MethodChannel(flutterEngine.getDartExecutor(), Constants.MessageTypes.SEND_EVENT).setMethodCallHandler(new d());
        this.f74551q = new BasicMessageChannel<>(flutterEngine.getDartExecutor(), "invite_init", StringCodec.INSTANCE);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.d().p(this);
        if (!InviteReturnHelper.g()) {
            InviteReturnHelper.h(true);
        }
        Qi((MethodChannel.Result) null);
        Oi((MethodChannel.Result) null);
        Ni();
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    public void onPostResume() {
        super.onPostResume();
        this.f74551q.send("onFirstFrame", e.f74633a);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(this, new JumpTarget(k0.h(this), k0.h(this)));
    }
}
