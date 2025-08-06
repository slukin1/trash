package com.huobi.sharev2.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.google.zxing.WriterException;
import com.hbg.lib.common.utils.PackageManagerUtil;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.sharev2.bean.ShareInfo;
import com.huobi.sharev2.fragment.NewCommonShareFragment;
import com.huobi.sharev2.manager.CallBack;
import com.huobi.social.share.HBShareHelper;
import com.huobi.utils.ImageUtils;
import com.huobi.utils.x;
import com.iproov.sdk.bridge.OptionsBridge;
import i6.k;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import pro.huobi.R;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import sr.g;
import sr.h;

public class NewShareHelper {

    /* renamed from: a  reason: collision with root package name */
    public NewCommonShareFragment f81131a;

    public static class ShareHelperHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final NewShareHelper f81132a = new NewShareHelper((a) null);
    }

    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            Log.d("NewShareHelper", "share dialog dismiss");
        }
    }

    public class b implements Observer<ArrayList<Bitmap>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallBack f81134b;

        public b(CallBack callBack) {
            this.f81134b = callBack;
        }

        /* renamed from: a */
        public void onNext(ArrayList<Bitmap> arrayList) {
            CallBack callBack = this.f81134b;
            if (callBack != null) {
                callBack.result(arrayList);
            }
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            this.f81134b.result(null);
        }
    }

    public class c implements Action1<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f81135b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f81136c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f81137d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f81138e;

        public c(String str, Context context, List list, CountDownLatch countDownLatch) {
            this.f81135b = str;
            this.f81136c = context;
            this.f81137d = list;
            this.f81138e = countDownLatch;
        }

        /* renamed from: a */
        public void call(String str) {
            CountDownLatch countDownLatch;
            try {
                Bitmap b11 = com.huobi.sharev2.createimage.create.c.f81058a.b(this.f81135b, this.f81136c, -1, -1);
                if (b11 != null) {
                    synchronized (this) {
                        this.f81137d.add(b11);
                    }
                }
                countDownLatch = this.f81138e;
                if (countDownLatch == null) {
                    return;
                }
            } catch (Exception unused) {
                countDownLatch = this.f81138e;
                if (countDownLatch == null) {
                    return;
                }
            } catch (Throwable th2) {
                CountDownLatch countDownLatch2 = this.f81138e;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                throw th2;
            }
            countDownLatch.countDown();
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f81139a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.social.share.HBShareHelper$HbPlatform[] r0 = com.huobi.social.share.HBShareHelper.HbPlatform.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f81139a = r0
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_FACEBOOK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f81139a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_INSTAGRAM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f81139a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_TELEGRAM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f81139a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_TWITTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f81139a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_KA_KAO     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f81139a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_LINE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f81139a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_WHATSAPP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f81139a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_COMMUNITY     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f81139a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_GROUP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.sharev2.helper.NewShareHelper.d.<clinit>():void");
        }
    }

    public /* synthetic */ NewShareHelper(a aVar) {
        this();
    }

    public static void c(List list, String str, CountDownLatch countDownLatch, Context context) {
        Observable.just(str).subscribeOn(Schedulers.io()).subscribe(new c(str, context, list, countDownLatch));
    }

    public static void g(ArrayList<String> arrayList, Context context, CallBack<ArrayList<Bitmap>> callBack) {
        if (arrayList != null && context != null) {
            Observable.just(arrayList).map(new h(context)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(callBack));
        } else if (callBack != null) {
            callBack.result(null);
        }
    }

    public static NewShareHelper j() {
        return ShareHelperHolder.f81132a;
    }

    public static String k(String str) {
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

    public static double l(String str) {
        double d11 = 0.0d;
        int i11 = 0;
        while (i11 < str.length()) {
            int i12 = i11 + 1;
            d11 += str.substring(i11, i12).matches("[一-龥]") ? 1.0d : 0.5d;
            i11 = i12;
        }
        return Math.ceil(d11);
    }

    public static String n() {
        return "https://www.huobi.com/en-us/v/register-1";
    }

    public static boolean o(boolean z11, HBShareHelper.HbPlatform hbPlatform) {
        switch (d.f81139a[hbPlatform.ordinal()]) {
            case 1:
                String[] strArr = {"com.facebook.orca", "com.facebook.katana", "com.example.facebook", "com.facebook.android"};
                boolean z12 = false;
                for (int i11 = 0; i11 < 4; i11++) {
                    z12 = PackageManagerUtil.b(new String[]{strArr[i11]});
                    if (z12) {
                        return z12;
                    }
                }
                return z12;
            case 2:
                if (!z11) {
                    return false;
                }
                String[] strArr2 = {"com.instagram.android"};
                boolean z13 = false;
                for (int i12 = 0; i12 < 1; i12++) {
                    z13 = PackageManagerUtil.b(new String[]{strArr2[i12]});
                    if (z13) {
                        return z13;
                    }
                }
                return z13;
            case 3:
                String[] strArr3 = {"org.telegram.messenger", "org.telegramkr.messenger", "org.telegram.messenger.web"};
                boolean z14 = false;
                for (int i13 = 0; i13 < 3; i13++) {
                    z14 = PackageManagerUtil.b(new String[]{strArr3[i13]});
                    if (z14) {
                        return z14;
                    }
                }
                return z14;
            case 4:
                String[] strArr4 = {SSOAuthHandler.TWITTER_PACKAGE_NAME};
                boolean z15 = false;
                for (int i14 = 0; i14 < 1; i14++) {
                    z15 = PackageManagerUtil.b(new String[]{strArr4[i14]});
                    if (z15) {
                        return z15;
                    }
                }
                return z15;
            case 5:
                String[] strArr5 = {"com.kakao.talk"};
                boolean z16 = false;
                for (int i15 = 0; i15 < 1; i15++) {
                    z16 = PackageManagerUtil.b(new String[]{strArr5[i15]});
                    if (z16) {
                        return z16;
                    }
                }
                return z16;
            case 6:
                String[] strArr6 = {"jp.naver.line.android"};
                boolean z17 = false;
                for (int i16 = 0; i16 < 1; i16++) {
                    z17 = PackageManagerUtil.b(new String[]{strArr6[i16]});
                    if (z17) {
                        return z17;
                    }
                }
                return z17;
            case 7:
                String[] strArr7 = {"com.whatsapp"};
                boolean z18 = false;
                for (int i17 = 0; i17 < 1; i17++) {
                    z18 = PackageManagerUtil.b(new String[]{strArr7[i17]});
                    if (z18) {
                        return z18;
                    }
                }
                return z18;
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean p(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence) || charSequence.equals(OptionsBridge.NULL_VALUE) || charSequence.equals("NULL");
    }

    public static /* synthetic */ ArrayList q(Context context, ArrayList arrayList) {
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i11 = 0; i11 < size; i11++) {
            c(arrayList2, (String) arrayList.get(i11), countDownLatch, context);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e11) {
            e11.printStackTrace();
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(DialogInterface dialogInterface) {
        this.f81131a = null;
    }

    public Bitmap d(Context context, String str) {
        try {
            return ImageUtils.c(m(str), (int) context.getResources().getDimension(R.dimen.dimen_67));
        } catch (WriterException e11) {
            k.f("generateQrBitmap", e11.getMessage());
            return null;
        }
    }

    public Bitmap e(Context context, String str, int i11) {
        try {
            return ImageUtils.c(m(str), i11);
        } catch (WriterException e11) {
            k.f("generateQrBitmap", e11.getMessage());
            return null;
        }
    }

    public Bitmap f(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    public byte[] h(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public int i(String str) {
        return SPUtil.a(str, 0);
    }

    public String m(String str) {
        return TextUtils.isEmpty(str) ? n() : str;
    }

    public void s(String str) {
        SPUtil.l(str, SPUtil.a(str, 0) + 1);
    }

    public void t(FragmentActivity fragmentActivity, ShareInfo shareInfo) {
        if (shareInfo == null || shareInfo.getShareType() == ShareInfo.ShareType.SHARE_DEFAULT_NONE) {
            Log.e("NewShareHelper", "分享参数ShareInfo为null or 分享类型未设置");
            return;
        }
        NewCommonShareFragment newCommonShareFragment = this.f81131a;
        if (newCommonShareFragment == null || !newCommonShareFragment.isVisible()) {
            ShareInfo.ShareType shareType = shareInfo.getShareType();
            String base64Image = shareInfo.getBase64Image();
            List<Bitmap> imageBitmaps = shareInfo.getImageBitmaps();
            String pageId = shareInfo.getPageId();
            if (shareType != ShareInfo.ShareType.SHARE_IMAGE_WITH_BASE64 || !TextUtils.isEmpty(base64Image)) {
                if (shareType == ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS && (imageBitmaps == null || imageBitmaps.size() <= 0)) {
                    if (!TextUtils.isEmpty(pageId)) {
                        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_URLS);
                    } else {
                        shareInfo.setShareType(ShareInfo.ShareType.SHARE_CONTENT);
                    }
                }
            } else if (!TextUtils.isEmpty(pageId)) {
                shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_URLS);
            } else {
                shareInfo.setShareType(ShareInfo.ShareType.SHARE_CONTENT);
            }
            NewCommonShareFragment newCommonShareFragment2 = new NewCommonShareFragment();
            this.f81131a = newCommonShareFragment2;
            newCommonShareFragment2.mi(shareInfo);
            this.f81131a.ji(new g(this));
            this.f81131a.show(fragmentActivity.getSupportFragmentManager(), "invite_poster_share[17]");
            String shareInfo2 = shareInfo.toString();
            Log.d("NewShareHelper", "ShareInfo:" + shareInfo2);
            this.f81131a.ji(new a());
        }
    }

    public NewShareHelper() {
    }
}
