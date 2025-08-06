package com.huobi.account.ui;

import bh.j;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.dianping.logan.SendLogRunnable;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.utils.f1;
import com.huobi.utils.h0;
import i6.k;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import pro.huobi.R;

public class FeedbackActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public boolean f41176k;

    public class a extends SendLogRunnable {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f41177d;

        public a(MethodChannel.Result result) {
            this.f41177d = result;
        }

        public void b(File file) {
            try {
                a();
                String l11 = k.l(FeedbackActivity.this);
                File file2 = new File(l11);
                if (!file2.exists()) {
                    FeedbackActivity.this.runOnUiThread(new s(this.f41177d));
                    return;
                }
                String str = l11 + File.separator + "feedback";
                File file3 = new File(str);
                if (!file3.exists()) {
                    file3.mkdir();
                }
                FileUtil.c(file3);
                FeedbackActivity.this.Ji(file2, file3);
                FeedbackActivity.this.Oi(file3);
                try {
                    File file4 = new File(j.c().getExternalCacheDir(), "CrashLog");
                    if (file4.exists()) {
                        h0.b(file4, new File(file3, "CrashLog"));
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    k.e("feedback Crash log 失败");
                }
                FeedbackActivity.this.runOnUiThread(new t(this.f41177d, f1.a(str, FeedbackActivity.this.getExternalCacheDir() + File.separator + "feedback")));
            } catch (Exception e12) {
                this.f41177d.error("getLogZipPath", e12.getMessage(), e12);
                e12.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Li(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        this.f41176k = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mi(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        this.f41176k = false;
        finish();
    }

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
        if (!this.f41176k) {
            this.f41176k = true;
            DialogUtils.c0(this, (String) methodCall.argument("content"), "", (String) methodCall.argument("cancelTitle"), getString(R.string.string_confirm), new p(this), new q(this));
            result.success((Object) null);
        }
    }

    public final void Ji(File file, File file2) {
        if (file.isDirectory()) {
            for (File file3 : file.listFiles()) {
                if (file3.exists() && file3.isFile()) {
                    if (file3.getName().endsWith(".copy")) {
                        file3.delete();
                    } else if (!file3.getName().contains(InstructionFileId.DOT)) {
                        FileUtil.d(file3, new File(file2.getAbsolutePath() + File.separator + file3.getName() + ".log"));
                    }
                }
            }
        }
    }

    public final void Ki(MethodChannel.Result result) {
        k.r(new a(result));
    }

    public String Nh() {
        return "report";
    }

    public final void Oi(File file) {
        if (file.isDirectory()) {
            List asList = Arrays.asList(file.listFiles());
            Collections.sort(asList, r.f41798b);
            long j11 = 0;
            for (int i11 = 0; i11 < asList.size(); i11++) {
                File file2 = (File) asList.get(i11);
                j11 += file2.length();
                if (j11 > 31457280) {
                    file2.delete();
                }
            }
        }
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("getLogZipPath".equals(str)) {
                Ki(result);
            } else if ("platformBackAsk".equals(str)) {
                Ii(methodCall, result);
            } else {
                super.onMethodCall(methodCall, result);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }
}
