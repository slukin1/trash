package com.huobi.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import bh.j;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.model.AccountRedDotMgtOpen;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.store.AppConfigManager;
import i6.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.schedulers.Schedulers;

public class AutoUploadLogHelper {

    /* renamed from: a  reason: collision with root package name */
    public boolean f83673a = false;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public final Handler f83674b = new a();

    public class a extends Handler {
        public a() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                AutoUploadLogHelper.this.L((Context) message.obj);
            }
        }
    }

    public class b extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f83676b;

        public b(Context context) {
            this.f83676b = context;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            k.o("uploadUserLog", "删除对应uid成功");
            boolean unused = AutoUploadLogHelper.this.f83673a = false;
            AutoUploadLogHelper.this.J(this.f83676b);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            k.o("uploadUserLog", "删除对应uid失败");
            boolean unused = AutoUploadLogHelper.this.f83673a = false;
            AutoUploadLogHelper.this.J(this.f83676b);
        }
    }

    public class c extends TypeToken<List<String>> {
        public c() {
        }
    }

    public class d extends BaseSubscriber<String> {
        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            k.o("uploadUserLog", "上传信息成功 22");
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            k.o("uploadUserLog", "上传信息成功 33");
        }
    }

    public static /* synthetic */ Observable A(Pair pair) {
        String str = (String) pair.first;
        String str2 = (String) pair.second;
        k.o("uploadUserLog", "上传信息 uid:" + str2 + " id:" + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return Observable.just("");
        }
        String str3 = "auto upload user log uid:" + str2;
        HashMap hashMap = new HashMap(7);
        hashMap.put(ZendeskIdentityStorage.UUID_KEY, PhoneUtils.r());
        hashMap.put("contact", str3);
        hashMap.put("type", 20);
        hashMap.put("remark", str3);
        hashMap.put("uid", str2);
        hashMap.put("version", String.valueOf(105400));
        ArrayList arrayList = new ArrayList(1);
        hashMap.put("urlList", arrayList);
        HashMap hashMap2 = new HashMap(2);
        hashMap2.put("attachmentId", str);
        hashMap2.put("urlType", "1");
        arrayList.add(hashMap2);
        return v7.b.a().uploadUserLogInfo(hashMap).b().flatMap(new o(str2)).onErrorResumeNext(new p(str2));
    }

    public static /* synthetic */ Observable B(String str) {
        k.o("uploadUserLog", "准备删除对应 uid:" + str);
        if (TextUtils.isEmpty(str)) {
            return Observable.just("");
        }
        return v7.b.a().removeLogUserId(f0.b(str)).b();
    }

    public static /* synthetic */ Observable C(String str, ArrayList arrayList) {
        k.o("uploadUserLog", "上传压缩包:" + arrayList + " uid:" + str);
        if (arrayList == null || arrayList.isEmpty()) {
            return Observable.just(Pair.create("", str));
        }
        return Observable.just(Pair.create((String) arrayList.get(0), str));
    }

    public static /* synthetic */ Observable E(Pair pair) {
        String str = (String) pair.first;
        String str2 = (String) pair.second;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                if ((((float) file.length()) / 1024.0f) / 1024.0f > 30.0f) {
                    return Observable.just(Pair.create("", ""));
                }
                return v7.b.a().m0(PhoneUtils.r(), str).b().flatMap(new t(str2)).onErrorResumeNext(new s(str2));
            }
        } else {
            k.o("uploadUserLog", "上传压缩包 path为空 uid:" + str2);
        }
        return Observable.just(Pair.create("", str2));
    }

    public static /* synthetic */ Observable H(Pair pair) {
        String str = (String) pair.first;
        String str2 = (String) pair.second;
        k.o("uploadUserLog", "上传信息 uid:" + str2 + " id:" + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return Observable.just("");
        }
        String str3 = "auto2 upload user log uid:" + str2;
        HashMap hashMap = new HashMap(7);
        hashMap.put(ZendeskIdentityStorage.UUID_KEY, PhoneUtils.r());
        hashMap.put("contact", str3);
        hashMap.put("type", 20);
        hashMap.put("remark", str3);
        hashMap.put("uid", str2);
        hashMap.put("version", String.valueOf(105400));
        ArrayList arrayList = new ArrayList(1);
        hashMap.put("urlList", arrayList);
        HashMap hashMap2 = new HashMap(2);
        hashMap2.put("attachmentId", str);
        hashMap2.put("urlType", "1");
        arrayList.add(hashMap2);
        return v7.b.a().uploadUserLogInfo(hashMap).b().flatMap(new n(str2)).onErrorResumeNext(new q(str2));
    }

    public static /* synthetic */ Pair I(Context context, Pair pair) {
        boolean booleanValue = ((Boolean) pair.first).booleanValue();
        String str = (String) pair.second;
        if (booleanValue) {
            try {
                String l11 = k.l(context);
                File file = new File(l11);
                if (!file.exists()) {
                    k.o("uploadUserLog", "操作本地文件不存在 uid:" + str);
                    return new Pair("", str);
                }
                String str2 = l11 + File.separator + "feedback";
                File file2 = new File(str2);
                if (!file2.exists()) {
                    file2.mkdir();
                }
                FileUtil.c(file2);
                h0.c(file, file2);
                h0.e(file2);
                try {
                    File file3 = new File(j.c().getExternalCacheDir(), "CrashLog");
                    if (file3.exists()) {
                        h0.b(file3, new File(file2, "CrashLog"));
                    }
                } catch (Exception unused) {
                    k.e("feedback Crash log 失败");
                }
                String a11 = f1.a(str2, context.getExternalCacheDir() + File.separator + "feedback");
                k.o("uploadUserLog", "操作本地文件 compressedFile:" + a11 + " uid:" + str);
                return new Pair(a11, str);
            } catch (Exception e11) {
                k.o("uploadUserLog", "操作本地文件异常:" + e11.getMessage());
                return new Pair("", str);
            }
        } else {
            k.o("uploadUserLog", "操作本地文件异常: 未匹配到uid");
            return new Pair("", str);
        }
    }

    public static void M(Context context) {
        if (context != null) {
            k.o("uploadUserLog", "开始启动主动上传日志");
            Observable.just(new Pair(Boolean.TRUE, ConfigPreferences.e("user_config", "config_current_uid", ""))).observeOn(Schedulers.io()).subscribeOn(Schedulers.io()).map(new l(context)).flatMap(j.f83749b).flatMap(g.f83743b).subscribe(new d());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable t(String str) {
        boolean z11;
        String a11 = f0.a(str);
        String str2 = "";
        if (!TextUtils.isEmpty(a11)) {
            List list = (List) GsonHelper.a().fromJson(a11, new c().getType());
            String e11 = ConfigPreferences.e("user_config", "config_current_uid", str2);
            if (!TextUtils.isEmpty(e11) && list != null && !list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (e11.equals((String) it2.next())) {
                            z11 = true;
                            str2 = e11;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        z11 = false;
        k.o("uploadUserLog", "匹配 findUID:" + z11 + " targetUID:" + str2);
        return Observable.just(new Pair(Boolean.valueOf(z11), str2));
    }

    public static /* synthetic */ Pair u(Context context, Pair pair) {
        boolean booleanValue = ((Boolean) pair.first).booleanValue();
        String str = (String) pair.second;
        if (booleanValue) {
            try {
                String l11 = k.l(context);
                File file = new File(l11);
                if (!file.exists()) {
                    k.o("uploadUserLog", "操作本地文件不存在 uid:" + str);
                    return new Pair("", str);
                }
                String str2 = l11 + File.separator + "feedback";
                File file2 = new File(str2);
                if (!file2.exists()) {
                    file2.mkdir();
                }
                FileUtil.c(file2);
                h0.c(file, file2);
                h0.e(file2);
                try {
                    File file3 = new File(j.c().getExternalCacheDir(), "CrashLog");
                    if (file3.exists()) {
                        h0.b(file3, new File(file2, "CrashLog"));
                    }
                } catch (Exception unused) {
                    k.e("feedback Crash log 失败");
                }
                String a11 = f1.a(str2, context.getExternalCacheDir() + File.separator + "feedback");
                k.o("uploadUserLog", "操作本地文件 compressedFile:" + a11 + " uid:" + str);
                return new Pair(a11, str);
            } catch (Exception e11) {
                k.o("uploadUserLog", "操作本地文件异常:" + e11.getMessage());
                return new Pair("", str);
            }
        } else {
            k.o("uploadUserLog", "操作本地文件异常: 未匹配到uid");
            return new Pair("", str);
        }
    }

    public static /* synthetic */ Observable v(String str, ArrayList arrayList) {
        k.o("uploadUserLog", "上传压缩包:" + arrayList + " uid:" + str);
        if (arrayList == null || arrayList.isEmpty()) {
            return Observable.just(Pair.create("", str));
        }
        return Observable.just(Pair.create((String) arrayList.get(0), str));
    }

    public static /* synthetic */ Observable x(Pair pair) {
        String str = (String) pair.first;
        String str2 = (String) pair.second;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                if ((((float) file.length()) / 1024.0f) / 1024.0f > 30.0f) {
                    return Observable.just(Pair.create("", ""));
                }
                return v7.b.a().m0(PhoneUtils.r(), str).b().flatMap(new f(str2)).onErrorResumeNext(new r(str2));
            }
        } else {
            k.o("uploadUserLog", "上传压缩包 path为空 uid:" + str2);
        }
        return Observable.just(Pair.create("", str2));
    }

    public final void J(Context context) {
        int s11 = s();
        if (s11 > 0) {
            Message obtain = Message.obtain();
            obtain.obj = context;
            obtain.what = 1;
            this.f83674b.sendMessageDelayed(obtain, ((long) s11) * 1000);
        }
    }

    public void K() {
        this.f83674b.removeCallbacksAndMessages((Object) null);
    }

    public void L(Context context) {
        if (!this.f83673a && context != null) {
            this.f83673a = true;
            k.o("uploadUserLog", "开始启动上传日志");
            v7.b.a().getLogUserIds().b().retry(3).flatMap(new m(this)).observeOn(Schedulers.io()).subscribeOn(Schedulers.io()).map(new e(context)).flatMap(i.f83748b).flatMap(h.f83747b).flatMap(k.f83750b).subscribe(new b(context));
        }
    }

    public final int s() {
        AccountRedDotMgtOpen accountRedDotMgtOpen = (AccountRedDotMgtOpen) AppConfigManager.c(MgtConfigNumber.ACCOUNT_RED_DOT.number, AccountRedDotMgtOpen.class);
        if (accountRedDotMgtOpen == null) {
            return 0;
        }
        int autoUploadLogTime = accountRedDotMgtOpen.getAutoUploadLogTime();
        k.o("uploadUserLog", "Mgt配置时间：" + autoUploadLogTime + "秒");
        return Math.max(autoUploadLogTime, 0);
    }
}
