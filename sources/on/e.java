package on;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.login.bean.TelegramResponse;
import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.data.source.bean.ThirdData;
import com.huobi.login.v2.ui.ThirdLoginWebActivity;
import com.huochat.community.network.domain.DomainTool;
import i6.k;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import u6.g;

public class e implements d<TelegramResponse.User> {

    /* renamed from: e  reason: collision with root package name */
    public static String f76413e = "oauth.telegram.org";

    /* renamed from: f  reason: collision with root package name */
    public static String f76414f = "";

    /* renamed from: g  reason: collision with root package name */
    public static String f76415g = "";

    /* renamed from: a  reason: collision with root package name */
    public Activity f76416a;

    /* renamed from: b  reason: collision with root package name */
    public String f76417b;

    /* renamed from: c  reason: collision with root package name */
    public final f f76418c;

    /* renamed from: d  reason: collision with root package name */
    public g f76419d;

    public class a implements Callback {
        public a() {
        }

        public void onFailure(Call call, IOException iOException) {
            if (e.this.f76419d != null) {
                e.this.f76419d.dismissProgressDialog();
            }
            HuobiToastUtil.m(iOException.getMessage());
        }

        public void onResponse(Call call, Response response) throws IOException {
            if (e.this.f76419d != null) {
                e.this.f76419d.dismissProgressDialog();
            }
            if (response.isSuccessful()) {
                String string = response.body().string();
                k.o("TelegramLogin", "onActivityResult usrInfoJson=" + string);
                e.this.d(((TelegramResponse) new Gson().fromJson(string, TelegramResponse.class)).getUser());
            }
        }
    }

    public e(Activity activity, f fVar) {
        this.f76416a = activity;
        this.f76418c = fVar;
        if (activity instanceof g) {
            this.f76419d = (g) activity;
        }
    }

    public final String b(URI uri, String str) {
        String[] split;
        String str2 = "";
        try {
            String query = uri.getQuery();
            if (!(query == null || (split = query.split(ContainerUtils.FIELD_DELIMITER)) == null || split.length <= 0)) {
                for (String split2 : split) {
                    String[] split3 = split2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split3 != null && split3.length == 2 && str.equals(split3[0])) {
                        str2 = split3[1];
                    }
                }
            }
        } catch (Throwable th2) {
            k.j("TelegramLogin", th2);
        }
        return str2;
    }

    public void c(String str) {
        this.f76417b = str;
    }

    public void d(TelegramResponse.User user) {
        if (user == null) {
            this.f76418c.onError(new NullPointerException("Telegram user info is NULL."));
            return;
        }
        ThirdData thirdData = new ThirdData();
        thirdData.f75671a = LoginPresenter.f75470v;
        HashMap hashMap = new HashMap();
        hashMap.put("id", Long.valueOf(user.getId()));
        hashMap.put("first_name", user.getFirstName());
        hashMap.put("last_name", user.getLastName());
        hashMap.put("auth_date", user.getAuthDate());
        hashMap.put("hash", user.getHash());
        hashMap.put("username", user.getUsername());
        hashMap.put("photo_url", user.getPhotoUrl());
        thirdData.f75676f = hashMap;
        this.f76418c.x(thirdData);
    }

    public void login() {
        if (!TextUtils.isEmpty(this.f76417b)) {
            try {
                URI uri = new URI(this.f76417b);
                f76413e = uri.getHost();
                f76414f = b(uri, "bot_id");
                f76415g = b(uri, "origin");
                k.o("TelegramLogin", "parse ThirdAuthUrl sTelegramHost=" + f76413e + " sBotId=" + f76414f + " sBotDomain=" + f76415g);
            } catch (URISyntaxException e11) {
                e11.printStackTrace();
            }
            Intent intent = new Intent(this.f76416a, ThirdLoginWebActivity.class);
            intent.putExtra("url", this.f76417b);
            intent.putExtra("param_telegram_auth_url", this.f76417b);
            this.f76416a.startActivityForResult(intent, 10002);
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        if (i11 == 10002 && intent != null) {
            String stringExtra = intent.getStringExtra("param_telegram_cookie");
            if (!TextUtils.isEmpty(stringExtra)) {
                OkHttpClient okHttpClient = new OkHttpClient();
                FormBody build = new FormBody.Builder().add("bot_id", f76414f).add("origin", f76415g).add("embed", "1").add("request_access", "write").build();
                Request.Builder builder = new Request.Builder();
                Request build2 = builder.url(DomainTool.DOMAIN_PREFIX + f76413e + "/auth/get?bot_id=" + f76414f + "&origin=" + f76415g + "&embed=1&request_access=write").header("cookie", stringExtra).header("x-requested-with", "XMLHttpRequest").post(build).build();
                g gVar = this.f76419d;
                if (gVar != null) {
                    gVar.showProgressDialog();
                }
                okHttpClient.newCall(build2).enqueue(new a());
            }
        }
    }
}
