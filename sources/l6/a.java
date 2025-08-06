package l6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.webview.HBBaseWebActivity;

public class a {

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f69011a = new a();
    }

    public static a a() {
        return b.f69011a;
    }

    public void b(Exception exc, Object... objArr) {
        if (!GlobalAppConfig.e()) {
            StringBuilder sb2 = new StringBuilder(exc.getMessage());
            if (objArr != null && objArr.length > 0) {
                for (HBBaseWebActivity hBBaseWebActivity : objArr) {
                    sb2.append(10);
                    sb2.append(9);
                    sb2.append(',');
                    if (hBBaseWebActivity instanceof HBBaseWebActivity) {
                        sb2.append("class=");
                        sb2.append(hBBaseWebActivity.getClass().getName());
                        HBBaseWebActivity hBBaseWebActivity2 = hBBaseWebActivity;
                        Intent intent = hBBaseWebActivity2.getIntent();
                        if (intent != null) {
                            sb2.append(10);
                            sb2.append(9);
                            sb2.append(',');
                            sb2.append("intent=");
                            sb2.append(intent);
                            if (intent.getExtras() != null) {
                                sb2.append(10);
                                sb2.append(9);
                                sb2.append(',');
                                sb2.append("Extras=");
                                sb2.append(intent.getExtras());
                            }
                        }
                        sb2.append(10);
                        sb2.append(9);
                        sb2.append(',');
                        sb2.append("url=");
                        sb2.append(hBBaseWebActivity2.getWebView().getUrl());
                    } else if (hBBaseWebActivity instanceof BaseActivity) {
                        sb2.append("class=");
                        sb2.append(hBBaseWebActivity.getClass().getName());
                        Intent intent2 = hBBaseWebActivity.getIntent();
                        if (intent2 != null) {
                            sb2.append(10);
                            sb2.append(9);
                            sb2.append(',');
                            sb2.append("intent=");
                            sb2.append(intent2);
                            if (intent2.getExtras() != null) {
                                sb2.append(10);
                                sb2.append(9);
                                sb2.append(',');
                                sb2.append("Extras=");
                                sb2.append(intent2.getExtras());
                            }
                        }
                    } else if (hBBaseWebActivity instanceof BaseFragment) {
                        sb2.append("class=");
                        sb2.append(hBBaseWebActivity.getClass().getName());
                        Bundle arguments = ((BaseFragment) hBBaseWebActivity).getArguments();
                        if (arguments != null) {
                            sb2.append(10);
                            sb2.append(9);
                            sb2.append(',');
                            sb2.append("Extras=");
                            sb2.append(arguments);
                        }
                    } else {
                        sb2.append(hBBaseWebActivity);
                    }
                }
            }
            Throwable th2 = new Throwable(exc.getMessage() + sb2.toString(), exc);
            Log.e("LogReport", "report.Exception() called with:  message = [" + exc.getMessage() + sb2.toString() + "]", th2);
            FirebaseCrashlytics.getInstance().recordException(th2);
        }
    }

    public a() {
    }
}
