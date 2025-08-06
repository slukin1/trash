package com.huobi.webview2.ui;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.jumio.defaultui.JumioActivity;
import com.jumio.sdk.error.JumioError;
import com.jumio.sdk.result.JumioResult;
import d10.l;
import i6.k;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.r;

public final class JumioKycHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20896a = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public static final i<JumioKycHelper> f20897b = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.SYNCHRONIZED, JumioKycHelper$Companion$instance$2.INSTANCE);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final JumioKycHelper a() {
            return (JumioKycHelper) JumioKycHelper.f20897b.getValue();
        }
    }

    public JumioKycHelper() {
    }

    public /* synthetic */ JumioKycHelper(r rVar) {
        this();
    }

    public static final void d(JumioKycHelper jumioKycHelper, l lVar, ActivityResult activityResult) {
        Intent data = activityResult.getData();
        JumioResult jumioResult = (JumioResult) (data != null ? data.getSerializableExtra(JumioActivity.EXTRA_RESULT) : null);
        if (jumioResult.isSuccess()) {
            jumioKycHelper.e("success");
            lVar.invoke("");
            return;
        }
        JumioError error = jumioResult.getError();
        if (error != null) {
            lVar.invoke(error.getMessage());
            jumioKycHelper.e(error.getMessage());
        }
    }

    public final void c(String str, l<? super String, Unit> lVar) {
        Activity c11 = com.blankj.utilcode.util.a.c();
        Intent intent = new Intent(c11, JumioActivity.class);
        intent.putExtra(JumioActivity.EXTRA_TOKEN, str);
        intent.putExtra(JumioActivity.EXTRA_DATACENTER, "SG");
        e("launchKyc");
        if (c11 instanceof HBBaseWebActivity) {
            ((HBBaseWebActivity) c11).getResultLauncher(new a(this, lVar)).a(intent);
        } else {
            lVar.invoke("unKnow error");
        }
    }

    public final void e(Object obj) {
        k.d("JumioKycHelper", String.valueOf(obj));
    }
}
