package h7;

import android.webkit.JavascriptInterface;
import com.hbg.lib.imsdk.HbgDialogWebView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import i6.d;
import i6.k;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HbgDialogWebView f70079a;

    /* renamed from: b  reason: collision with root package name */
    public final a f70080b;

    public interface a {
        void a(String str, int i11);

        void onShow();
    }

    public b(HbgDialogWebView hbgDialogWebView, a aVar) {
        this.f70079a = hbgDialogWebView;
        this.f70080b = aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("method");
            String optString2 = jSONObject.optString(RemoteMessageConst.MessageBody.PARAM);
            int i11 = 0;
            if (jSONObject.has("clickedH5Close")) {
                i11 = jSONObject.optBoolean("clickedH5Close") ? 1 : 2;
            }
            k.o("ImInterface", "GlobalFloatData_WEB_callApi :  method:" + optString + " param:" + optString2);
            if ("show".equals(optString)) {
                d.c("ImInterface", "showHbgDialog_H5 H5加载完成，调用show方法，");
                this.f70079a.setAlpha(1.0f);
                a aVar = this.f70080b;
                if (aVar != null) {
                    aVar.onShow();
                }
            } else if ("close".equals(optString)) {
                d.c("ImInterface", "showHbgDialog_H5 用户点击，调用close方法，");
                if (!str2.equals(optString2)) {
                    str2 = new JSONObject(optString2).optString("jumpUrl");
                }
                a aVar2 = this.f70080b;
                if (aVar2 != null) {
                    aVar2.a(str2, i11);
                }
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    @JavascriptInterface
    public void callApi(String str) {
        d.b("ImInterface-->callJava-->data:" + str);
        this.f70079a.post(new a(this, str));
    }
}
