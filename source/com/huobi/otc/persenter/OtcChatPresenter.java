package com.huobi.otc.persenter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.OtcChatOnlineCheck;
import com.hbg.lib.network.otc.core.bean.OtcOrderDetailBean;
import com.hbg.lib.network.otc.core.bean.OtcUploadPicBean;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.OtcChatContent;
import com.huobi.otc.bean.OtcChatContentList;
import com.huobi.otc.bean.OtcOrderBean;
import com.huobi.otc.bean.OtcOrderDetailInfo;
import com.huobi.otc.service.OTCService;
import com.huobi.utils.ImageUtils;
import com.huochat.community.base.CommunityConstants;
import com.luck.picture.lib.permissions.PermissionConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jp.l;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OtcChatPresenter extends ActivityPresenter<i> implements EasyPermissions.PermissionCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public String f79016b;

    /* renamed from: c  reason: collision with root package name */
    public String f79017c;

    /* renamed from: d  reason: collision with root package name */
    public long f79018d;

    /* renamed from: e  reason: collision with root package name */
    public int f79019e;

    /* renamed from: f  reason: collision with root package name */
    public v9.a<OtcChatContent> f79020f;

    /* renamed from: g  reason: collision with root package name */
    public List<OtcChatContent> f79021g;

    /* renamed from: h  reason: collision with root package name */
    public List<OtcChatContent> f79022h;

    /* renamed from: i  reason: collision with root package name */
    public File f79023i;

    /* renamed from: j  reason: collision with root package name */
    public long f79024j = 0;

    /* renamed from: k  reason: collision with root package name */
    public long f79025k = 0;

    /* renamed from: l  reason: collision with root package name */
    public HashSet<Long> f79026l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f79027m = false;

    /* renamed from: n  reason: collision with root package name */
    public Runnable f79028n = new a();

    /* renamed from: o  reason: collision with root package name */
    public Runnable f79029o = new b();

    /* renamed from: p  reason: collision with root package name */
    public Runnable f79030p = new c();

    /* renamed from: q  reason: collision with root package name */
    public long f79031q = 0;

    /* renamed from: r  reason: collision with root package name */
    public boolean f79032r = false;

    /* renamed from: s  reason: collision with root package name */
    public long f79033s = 0;

    /* renamed from: t  reason: collision with root package name */
    public boolean f79034t = false;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            OtcChatPresenter.this.f0();
            OtcChatPresenter otcChatPresenter = OtcChatPresenter.this;
            otcChatPresenter.d0(otcChatPresenter.f79018d);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            OtcChatPresenter.this.q0();
            i6.i.b().g(OtcChatPresenter.this.f79029o, 5000);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            ((i) OtcChatPresenter.this.getUI()).Q2(true);
        }
    }

    public class d extends EasySubscriber<OtcChatContentList> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(OtcChatContentList otcChatContentList) {
            super.onNext(otcChatContentList);
            OtcChatPresenter.this.g0(otcChatContentList);
            ((i) OtcChatPresenter.this.getUI()).f6().g();
            OtcChatPresenter otcChatPresenter = OtcChatPresenter.this;
            otcChatPresenter.i0(otcChatPresenter.f79033s);
        }

        public void onError2(Throwable th2) {
            OtcChatPresenter.this.k0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            OtcChatPresenter.this.k0();
        }
    }

    public class e extends EasySubscriber<Object> {
        public e() {
        }

        public void onError2(Throwable th2) {
            OtcChatPresenter.this.l0(true);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            OtcChatPresenter.this.l0(true);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            OtcChatPresenter.this.l0(false);
        }
    }

    public class f implements pa.a {

        public class a extends EasySubscriber<Object> {
            public a() {
            }

            public void onError2(Throwable th2) {
                OtcChatPresenter.this.l0(true);
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                OtcChatPresenter.this.l0(true);
            }

            public void onNext(Object obj) {
                super.onNext(obj);
                OtcChatPresenter.this.l0(false);
            }
        }

        public f() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ File g(Uri uri, Integer num) {
            OtcChatPresenter otcChatPresenter = OtcChatPresenter.this;
            File unused = otcChatPresenter.f79023i = ImageUtils.f(otcChatPresenter.getActivity(), uri.getPath(), 1.0d);
            return OtcChatPresenter.this.f79023i;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Observable i(boolean z11, Response response) {
            return s8.a.a().saveChatContent(OtcChatPresenter.this.f79017c, response.body() == null ? response.raw().message() : ((OtcUploadPicBean) response.body()).getData(), (z11 ? OtcChatContent.ChatType.Image : OtcChatContent.ChatType.Video).value).b();
        }

        public void a(Uri uri, String str, boolean z11) {
            Observable.just(0).map(new qp.d(this, uri)).observeOn(Schedulers.io()).flatMap(qp.f.f60077b).flatMap(new qp.e(this, z11)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
        }

        public void b(String str) {
        }

        public void c(LinkedHashMap<String, Boolean> linkedHashMap, String[] strArr) {
        }

        public void onCancel() {
        }
    }

    public class g extends EasySubscriber<List<OtcChatOnlineCheck>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f79042b;

        public g(long j11) {
            this.f79042b = j11;
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onNext(List<OtcChatOnlineCheck> list) {
            super.onNext(list);
            boolean z11 = false;
            for (OtcChatOnlineCheck next : list) {
                if (next.getUserId() == this.f79042b && next.isStatus()) {
                    z11 = true;
                }
            }
            if (z11) {
                ((i) OtcChatPresenter.this.getUI()).F4(true);
            } else {
                ((i) OtcChatPresenter.this.getUI()).F4(false);
            }
        }
    }

    public class h extends EasySubscriber<OtcOrderDetailBean> {
        public h() {
        }

        /* renamed from: a */
        public void onNext(OtcOrderDetailBean otcOrderDetailBean) {
            super.onNext(otcOrderDetailBean);
            OtcOrderDetailInfo coverData = OtcOrderDetailInfo.coverData(otcOrderDetailBean);
            ((i) OtcChatPresenter.this.getUI()).Rd(coverData.getOtcOrder());
            if (coverData.getOtcOrder() != null) {
                int status = coverData.getOtcOrder().getStatus();
                if (status == 2 || status == 3) {
                    i6.i.b().h(OtcChatPresenter.this.f79029o);
                }
            }
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public interface i extends SmartRefreshPageSplitter.d {
        void F4(boolean z11);

        void H3(String str, OtcOrderDetailInfo otcOrderDetailInfo, int i11);

        void Q2(boolean z11);

        void Rd(OtcOrderBean otcOrderBean);

        void W2();

        void X0();
    }

    @AfterPermissionGranted(123)
    public void c0() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        if (EasyPermissions.hasPermissions(getActivity(), strArr)) {
            i6.i.b().h(this.f79028n);
            pa.d.o().B(false).q(getActivity());
            ((i) getUI()).W2();
            return;
        }
        EasyPermissions.requestPermissions(getActivity(), 123, strArr);
    }

    public final void d0(long j11) {
        s8.a.a().chatOnlineCheck(j11).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g(j11));
    }

    public final synchronized void f0() {
        Map<String, Object> map;
        if (this.f79025k == 0 && this.f79024j == 0 && this.f79033s == 0) {
            ((i) getUI()).f6().p();
            this.f79034t = true;
        }
        this.f79033s = System.currentTimeMillis();
        if (this.f79025k != 0) {
            if (!this.f79032r) {
                map = MapParamsBuilder.c().a(CommunityConstants.LAST_ID, Long.valueOf(this.f79025k)).b();
                ((OTCService) OtcRetrofit.request(OTCService.class)).getChatList(this.f79017c, map).compose(OtcRetrofit.o()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
            }
        }
        if (this.f79024j != 0) {
            map = MapParamsBuilder.c().a("firstId", Long.valueOf(this.f79024j)).b();
        } else {
            map = MapParamsBuilder.c().b();
        }
        ((OTCService) OtcRetrofit.request(OTCService.class)).getChatList(this.f79017c, map).compose(OtcRetrofit.o()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
    }

    public final void g0(OtcChatContentList otcChatContentList) {
        if (this.f79024j == 0) {
            this.f79021g.clear();
            this.f79026l.clear();
        }
        this.f79022h.clear();
        if (otcChatContentList.getList() != null && otcChatContentList.getList().size() > 0) {
            int size = otcChatContentList.getList().size();
            int i11 = 0;
            for (OtcChatContentList.OtcChatDetailContent next : otcChatContentList.getList()) {
                i11++;
                if (i11 == 1) {
                    long id2 = next.getId();
                    long j11 = this.f79024j;
                    if (j11 > id2 || j11 == 0) {
                        this.f79024j = id2;
                    }
                }
                if (i11 == size) {
                    long id3 = next.getId();
                    if (this.f79025k < id3) {
                        this.f79025k = id3;
                    }
                }
                OtcChatContent otcChatContent = new OtcChatContent();
                otcChatContent.setOtcChatContent(next);
                otcChatContent.setCurrentUser(!TextUtils.equals(next.getSendUid(), String.valueOf(this.f79018d)));
                if (this.f79031q == 0 || next.getGmtCreate() - this.f79031q <= 300000) {
                    otcChatContent.setEnoughInterval(false);
                } else {
                    otcChatContent.setEnoughInterval(true);
                }
                this.f79031q = next.getGmtCreate();
                if (!this.f79026l.contains(Long.valueOf(next.getId()))) {
                    this.f79026l.add(Long.valueOf(next.getId()));
                    if (this.f79032r) {
                        this.f79022h.add(otcChatContent);
                    } else {
                        this.f79021g.add(otcChatContent);
                    }
                }
            }
            if (this.f79022h.size() > 0) {
                this.f79021g.addAll(0, this.f79022h);
            }
            this.f79020f.notifyDataSetChanged();
            if (this.f79032r) {
                this.f79032r = false;
                ((i) getUI()).X0();
                return;
            }
            j0();
        } else if (this.f79032r) {
            ((i) getUI()).X0();
            this.f79032r = false;
        }
    }

    public final void h0() {
        i6.i.b().h(this.f79028n);
        i6.i.b().f(this.f79028n);
        if (this.f79027m) {
            i6.i.b().h(this.f79029o);
            i6.i.b().f(this.f79029o);
        }
    }

    public final void i0(long j11) {
        long currentTimeMillis = System.currentTimeMillis() - j11;
        i6.i.b().h(this.f79028n);
        if (currentTimeMillis < com.sumsub.sns.internal.ml.autocapture.a.f34923p) {
            i6.i.b().g(this.f79028n, 1500);
        } else {
            i6.i.b().f(this.f79028n);
        }
    }

    public void j0() {
        v9.a<OtcChatContent> aVar = this.f79020f;
        if (aVar != null && aVar.getItemCount() >= 1) {
            ((i) getUI()).Y0().smoothScrollToPosition(this.f79020f.getItemCount() - 1);
        }
    }

    public final void k0() {
        if (this.f79034t) {
            this.f79033s = 0;
            this.f79034t = false;
            ((i) getUI()).f6().k();
            return;
        }
        ((i) getUI()).f6().g();
    }

    public final void l0(boolean z11) {
        i6.i.b().h(this.f79030p);
        ((i) getUI()).Q2(false);
        i6.i.b().f(this.f79028n);
        if (z11) {
            HuobiToastUtil.k(BaseApplication.b(), R$string.server_error);
        }
    }

    /* renamed from: m0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, i iVar) {
        super.onUIReady(baseCoreActivity, iVar);
        EventBus.d().p(this);
        Intent intent = getActivity().getIntent();
        if (!(intent == null || intent.getExtras() == null)) {
            this.f79019e = intent.getIntExtra("merchantLevel", 0);
            OtcOrderDetailInfo otcOrderDetailInfo = (OtcOrderDetailInfo) intent.getSerializableExtra("otcOrder");
            if (otcOrderDetailInfo != null) {
                OtcOrderBean otcOrder = otcOrderDetailInfo.getOtcOrder();
                this.f79016b = otcOrder.getTradeUserName();
                this.f79018d = otcOrder.getTradeUid();
                this.f79017c = otcOrder.getId();
                ((i) getUI()).H3(this.f79016b, otcOrderDetailInfo, this.f79019e);
                int status = otcOrder.getStatus();
                if (status == 2 || status == 3) {
                    this.f79027m = false;
                } else {
                    this.f79027m = true;
                }
            }
        }
        this.f79021g = new ArrayList();
        this.f79022h = new ArrayList();
        this.f79026l = new HashSet<>();
        this.f79020f = new v9.a<>(this.f79021g);
        ((i) getUI()).Y0().setAdapter(this.f79020f);
        h0();
    }

    @AfterPermissionGranted(124)
    public void n0() {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.WRITE_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(getActivity(), str)) {
            i6.i.b().h(this.f79028n);
            pa.d.o().B(false).t(getActivity());
            ((i) getUI()).W2();
            return;
        }
        EasyPermissions.requestPermissions(getActivity(), 124, str);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 != -1) {
            i6.i.b().f(this.f79028n);
            return;
        }
        i6.i.b().g(this.f79030p, 500);
        pa.d.o().C(new f()).x(getActivity(), i11, i12, intent);
    }

    public void onDestroy() {
        super.onDestroy();
        i6.i.b().h(this.f79028n);
        i6.i.b().h(this.f79029o);
        i6.i.b().h(this.f79030p);
        EventBus.d().r(this);
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(getActivity(), list)) {
            ((i) getUI()).W2();
            new AppSettingsDialog.Builder((Activity) getActivity(), getString(R$string.permission_camera_write_external_storage_apply)).setTitle(getString(R$string.permission_apply)).setPositiveButton(getString(R$string.go_to_settings)).setNegativeButton(getString(R$string.global_string_cancel), (DialogInterface.OnClickListener) null).setRequestCode(125).build().show();
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        i6.i.b().h(this.f79028n);
        if (i11 == 123) {
            pa.d.o().B(false).q(getActivity());
            ((i) getUI()).W2();
        } else if (i11 == 124) {
            pa.d.o().B(false).t(getActivity());
            ((i) getUI()).W2();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        getActivity().startActivity(OtcModuleConfig.a().u(getActivity()));
        getActivity().finish();
    }

    public void p0(boolean z11) {
        this.f79032r = z11;
        i6.i.b().h(this.f79028n);
        f0();
    }

    public void q0() {
        l.m(this.f79017c).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new h());
    }

    public final void r0(String str) {
        s8.a.a().saveChatContent(this.f79017c, str, OtcChatContent.ChatType.Text.value).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
    }

    public void s0(String str) {
        i6.i.b().h(this.f79028n);
        r0(str);
        i6.i.b().g(this.f79030p, 500);
    }
}
