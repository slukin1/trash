package gs;

import com.appsflyer.AppsFlyerLib;
import com.blankj.utilcode.util.Utils;
import com.google.gson.annotations.SerializedName;
import com.huobi.bugsdk.FirebaseHelper;
import com.huobi.utils.c;

public class a {
    @SerializedName("af_app_id")

    /* renamed from: a  reason: collision with root package name */
    public String f84176a = "pro.huobi";
    @SerializedName("af_device_id")

    /* renamed from: b  reason: collision with root package name */
    public String f84177b = c.a();
    @SerializedName("af_device_id_type")

    /* renamed from: c  reason: collision with root package name */
    public String f84178c = c.b();
    @SerializedName("af_id")

    /* renamed from: d  reason: collision with root package name */
    public String f84179d = AppsFlyerLib.getInstance().getAppsFlyerUID(Utils.a());
    @SerializedName("app_instance_id")

    /* renamed from: e  reason: collision with root package name */
    public String f84180e = FirebaseHelper.c();

    public static a a() {
        return new a();
    }

    public String toString() {
        return "AfInfo{appId='" + this.f84176a + '\'' + ", deviceId='" + this.f84177b + '\'' + ", deviceIdType='" + this.f84178c + '\'' + ", afId='" + this.f84179d + '\'' + ", appInstanceId='" + this.f84180e + '\'' + '}';
    }
}
