package jp;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.network.otc.core.FileUploadSubscriber;
import com.hbg.lib.network.otc.core.OTCPageListExtendResponse;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.otc.core.OTCStatusStringExtendResponse;
import com.hbg.lib.network.otc.core.bean.FaceVerifyPortalBean;
import com.hbg.lib.network.otc.core.bean.MktRuleBean;
import com.hbg.lib.network.otc.core.bean.OssSignBean;
import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import com.hbg.lib.network.otc.core.bean.OtcOrderDetailBean;
import com.hbg.lib.network.otc.core.bean.OtcUploadPicBean;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.module.otc.OtcModuleConfig;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.account.entity.OTCKycInfo;
import com.huobi.coupon.bean.Coupon;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.bean.OtcAdvertLabelBean;
import com.huobi.otc.bean.ReminderData;
import com.huobi.otc.bean.VoiceInfo;
import com.huobi.otc.bean.VoiceSignInfo;
import com.huobi.otc.service.OTCService;
import com.jumio.sdk.reject.JumioRejectReason;
import i6.d;
import i6.m;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static NumberFormat f84343a = NumberFormat.getNumberInstance(Locale.CHINA);

    /* renamed from: b  reason: collision with root package name */
    public static final NumberFormat f84344b = NumberFormat.getNumberInstance(Locale.CHINA);

    /* renamed from: c  reason: collision with root package name */
    public static UserVO f84345c;

    /* renamed from: d  reason: collision with root package name */
    public static OTCKycInfo f84346d;

    /* renamed from: e  reason: collision with root package name */
    public static MktRuleBean f84347e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f84348f;

    public class a implements Func1<OssSignBean, Observable<Response<OtcUploadPicBean>>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f84349b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f84350c;

        /* renamed from: jp.l$a$a  reason: collision with other inner class name */
        public class C0871a implements Func1<Response<OtcUploadPicBean>, Observable<Response<OtcUploadPicBean>>> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ OssSignBean f84351b;

            public C0871a(OssSignBean ossSignBean) {
                this.f84351b = ossSignBean;
            }

            /* renamed from: a */
            public Observable<Response<OtcUploadPicBean>> call(Response<OtcUploadPicBean> response) {
                if (response.body() != null || !"s3".equals(this.f84351b.getBucketType())) {
                    return Observable.just(response);
                }
                return Observable.just(Response.success(null, new Response.Builder().code(200).body(ResponseBody.create((MediaType) null, this.f84351b.getPreviewUrl())).message(this.f84351b.getPreviewUrl()).protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build()));
            }
        }

        public a(File file, String str) {
            this.f84349b = file;
            this.f84350c = str;
        }

        /* renamed from: a */
        public Observable<retrofit2.Response<OtcUploadPicBean>> call(OssSignBean ossSignBean) {
            s8.b a11 = s8.a.a();
            String url = ossSignBean.getUrl();
            HashMap<String, RequestBody> partMap = ossSignBean.toPartMap(ossSignBean);
            String mediaFileKey = ossSignBean.getMediaFileKey();
            String name = this.f84349b.getName();
            return a11.ossUploadPicture(url, partMap, MultipartBody.Part.createFormData(mediaFileKey, name, RequestBody.create(MediaType.parse("image/" + this.f84350c), this.f84349b))).b().flatMap(new C0871a(ossSignBean));
        }
    }

    public class b implements Func1<OssSignBean, Observable<retrofit2.Response<OtcUploadPicBean>>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f84353b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f84354c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f84355d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f84356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FileUploadSubscriber f84357f;

        public class a implements Func1<retrofit2.Response<OtcUploadPicBean>, Observable<retrofit2.Response<OtcUploadPicBean>>> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ OssSignBean f84358b;

            public a(OssSignBean ossSignBean) {
                this.f84358b = ossSignBean;
            }

            /* renamed from: a */
            public Observable<retrofit2.Response<OtcUploadPicBean>> call(retrofit2.Response<OtcUploadPicBean> response) {
                if (response == null || !response.isSuccessful() || response.body() != null || !"s3".equals(this.f84358b.getBucketType())) {
                    return Observable.just(response);
                }
                OtcUploadPicBean otcUploadPicBean = new OtcUploadPicBean();
                otcUploadPicBean.setCode(JumioRejectReason.NOT_READABLE);
                otcUploadPicBean.setData(this.f84358b.getPreviewUrl());
                return Observable.just(retrofit2.Response.success(otcUploadPicBean, new Response.Builder().code(200).body((ResponseBody) null).message(this.f84358b.getPreviewUrl()).protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build()));
            }
        }

        public b(File file, boolean z11, String str, boolean z12, FileUploadSubscriber fileUploadSubscriber) {
            this.f84353b = file;
            this.f84354c = z11;
            this.f84355d = str;
            this.f84356e = z12;
            this.f84357f = fileUploadSubscriber;
        }

        /* renamed from: a */
        public Observable<retrofit2.Response<OtcUploadPicBean>> call(OssSignBean ossSignBean) {
            String str;
            String str2;
            StringBuilder sb2;
            s8.b a11 = s8.a.a();
            String url = ossSignBean.getUrl();
            HashMap<String, RequestBody> partMap = ossSignBean.toPartMap(ossSignBean);
            String mediaFileKey = ossSignBean.getMediaFileKey();
            String encode = URLEncoder.encode(this.f84353b.getName());
            if (this.f84354c) {
                str = "image/" + this.f84355d;
            } else {
                if (this.f84356e) {
                    sb2 = new StringBuilder();
                    str2 = "application/";
                } else {
                    sb2 = new StringBuilder();
                    str2 = "video/";
                }
                sb2.append(str2);
                sb2.append(this.f84355d);
                str = sb2.toString();
            }
            return a11.ossUploadPicture(url, partMap, MultipartBody.Part.createFormData(mediaFileKey, encode, new t8.c(RequestBody.create(MediaType.parse(str), this.f84353b), this.f84357f))).b().concatMap(new a(ossSignBean));
        }
    }

    public interface c {
        void a();
    }

    public static /* synthetic */ Boolean B(UserVO userVO) {
        return Boolean.valueOf(userVO != null);
    }

    public static /* synthetic */ retrofit2.Response C(boolean z11, File file, retrofit2.Response response) {
        OtcUploadPicBean otcUploadPicBean;
        if (!(!z11 || response == null || (otcUploadPicBean = (OtcUploadPicBean) response.body()) == null)) {
            otcUploadPicBean.setFilePath(file.getPath());
            otcUploadPicBean.setFileSize(Long.valueOf(file.length()));
            otcUploadPicBean.setFileName(file.getName());
        }
        return response;
    }

    public static d9.a<FaceVerifyPortalBean> D(String str, String str2, String str3) {
        return s8.a.a().loadVerifyPortal(str, str2, str3);
    }

    public static Observable<String> E() {
        return s8.a.a().authPull().b();
    }

    public static Observable<retrofit2.Response<OtcUploadPicBean>> F(File file, String str, String str2) {
        return s8.a.a().g(file.getName(), str, str2).b().concatMap(new a(file, k(file.getPath())));
    }

    public static Observable<StringStatusResponse<String>> G(Map<String, Object> map) {
        if (map == null) {
            return Observable.just(null);
        }
        return OtcModuleConfig.b().F(map);
    }

    public static Observable<Boolean> H(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", str);
        return ((OTCService) OtcRetrofit.request(OTCService.class)).requestC2cOrderTransConfirm(hashMap).compose(OtcRetrofit.o());
    }

    public static void I(MktRuleBean mktRuleBean) {
        f84347e = mktRuleBean;
    }

    public static Observable<retrofit2.Response<OtcUploadPicBean>> J(File file, String str, String str2, FileUploadSubscriber<retrofit2.Response<Object>> fileUploadSubscriber, boolean z11, boolean z12) {
        return s8.a.a().g(file.getName(), str, str2).b().concatMap(new b(file, z11, k(file.getPath()), z12, fileUploadSubscriber)).map(new i(z12, file));
    }

    public static Observable<Boolean> K(Map<String, Object> map) {
        return s8.a.a().updateTradePass(map).b();
    }

    public static Observable<Boolean> L(Map<String, Object> map) {
        return s8.a.a().updateUser(map).b();
    }

    public static boolean M() {
        UserVO userVO = f84345c;
        if (userVO == null || userVO.getRealBind() != 1) {
            return false;
        }
        return true;
    }

    public static Observable<Boolean> N(String str, long j11, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("voiceStatus", str);
        hashMap.put("voiceDuration", Long.valueOf(j11));
        hashMap.put("orderId", str2);
        return ((OTCService) OtcRetrofit.request(OTCService.class)).voiceCallBack(hashMap).compose(OtcRetrofit.o());
    }

    public static Observable<Boolean> f(String str, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", str);
        hashMap.put("isNegotiation", Boolean.valueOf(z11));
        return ((OTCService) OtcRetrofit.request(OTCService.class)).cancelConfirm(hashMap).compose(OtcRetrofit.o());
    }

    public static String g(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        return str.replaceAll("(" + str2 + "=[^&]*)", str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3);
    }

    public static void h() {
        f84345c = null;
        f84346d = null;
    }

    public static void i(View view, EditText... editTextArr) {
        if (view != null && editTextArr != null && editTextArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (EditText a11 : editTextArr) {
                arrayList.add(ew.a.a(a11));
            }
            Observable.combineLatest(arrayList, k.f56033b).subscribe(new g(view));
        }
    }

    public static String j(String str, int i11) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.CHINA);
        numberInstance.setRoundingMode(RoundingMode.FLOOR);
        if (i11 >= 0) {
            numberInstance.setMaximumFractionDigits(i11);
            numberInstance.setMinimumFractionDigits(i11);
        }
        return numberInstance.format(m.a(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        r0 = r1.lastIndexOf(46);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String k(java.lang.String r1) {
        /*
            r0 = 47
            int r0 = r1.lastIndexOf(r0)
            if (r0 < 0) goto L_0x000e
            int r0 = r0 + 1
            java.lang.String r1 = r1.substring(r0)
        L_0x000e:
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x0023
            r0 = 46
            int r0 = r1.lastIndexOf(r0)
            if (r0 < 0) goto L_0x0023
            int r0 = r0 + 1
            java.lang.String r1 = r1.substring(r0)
            return r1
        L_0x0023:
            java.lang.String r1 = "png"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.l.k(java.lang.String):java.lang.String");
    }

    public static Observable<OTCPageListExtendResponse<List<Ads>, List<OtcAdvertLabelBean>>> l(int i11, String str, Map<String, String> map) {
        return ((OTCService) OtcRetrofit.request(OTCService.class)).getPublicAds(i11, str, map).compose(OtcRetrofit.n());
    }

    public static Observable<OtcOrderDetailBean> m(String str) {
        return s8.a.a().m(str).b();
    }

    public static Observable<OTCStatusResponse<ReminderData>> n() {
        return ((OTCService) OtcRetrofit.request(OTCService.class)).getOrderFloatInfo();
    }

    public static Observable<OTCStatusExtendResponse<OtcAdTicket>> o(String str, Boolean bool, String str2) {
        return s8.a.a().requestFreeQuote(str, bool, str2).b();
    }

    public static String p() {
        String t11 = OtcModuleConfig.a().t();
        String g11 = OtcModuleConfig.a().g();
        if (TextUtils.equals(g11, "/zh-hk/")) {
            g11 = "/zh-tw/";
        }
        if (!b1.h().i().contains(g11)) {
            g11 = "/en-us/";
        }
        String str = t11 + g11;
        d.e("getOtcH5Host--url-->", str);
        return str;
    }

    public static Observable<UserVO> q(boolean z11) {
        Observable<UserVO> doOnNext = s8.a.a().getUser().b().doOnNext(h.f56020b);
        return z11 ? Observable.concat(Observable.just(f84345c), doOnNext).takeFirst(j.f56030b) : doOnNext;
    }

    public static UserVO r() {
        return f84345c;
    }

    public static Observable<VoiceInfo> s(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", str);
        hashMap.put("orderId", str2);
        return ((OTCService) OtcRetrofit.request(OTCService.class)).getVoiceInfo(hashMap).compose(OtcRetrofit.o());
    }

    public static Observable<VoiceSignInfo> t(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(ZendeskIdentityStorage.UUID_KEY, str);
        return ((OTCService) OtcRetrofit.request(OTCService.class)).getVoiceSign(hashMap).compose(OtcRetrofit.o());
    }

    public static Observable<OTCStatusStringExtendResponse<Ads>> u(String str) {
        return ((OTCService) OtcRetrofit.request(OTCService.class)).getWordAd(str);
    }

    public static boolean v(Coupon coupon, String str, String str2) {
        if (coupon == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || TextUtils.isEmpty(coupon.getBaseCurrency())) {
            return false;
        }
        List asList = Arrays.asList(coupon.getBaseCurrency().split("/"));
        if ((asList.contains(str2.toUpperCase()) || asList.contains(str2.toLowerCase())) && coupon.getQuoteCurrency().toUpperCase().equalsIgnoreCase(str.toUpperCase())) {
            return x(coupon);
        }
        return false;
    }

    public static boolean w(Coupon coupon, String str) {
        if (coupon == null || TextUtils.isEmpty(coupon.getMeetCondition())) {
            return false;
        }
        BigDecimal a11 = m.a(str);
        if (a11.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        BigDecimal a12 = m.a(coupon.getMeetCondition());
        if (a12.compareTo(BigDecimal.ZERO) > 0 && a11.compareTo(a12) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean x(Coupon coupon) {
        if (coupon == null || coupon.getState() != 0) {
            return false;
        }
        if (coupon.getType() != 1 && coupon.getType() != 4) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= coupon.getBeginTime() && currentTimeMillis <= coupon.getEndTime()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ Boolean y(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return Boolean.TRUE;
        }
        boolean z11 = true;
        for (CharSequence charSequence : objArr) {
            if ((charSequence instanceof CharSequence) && charSequence.length() <= 0) {
                z11 = false;
            }
        }
        return Boolean.valueOf(z11);
    }
}
