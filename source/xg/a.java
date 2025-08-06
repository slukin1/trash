package xg;

import c6.d;
import com.huobi.activity.ApiManagerActivity;
import com.huobi.setting.bean.FlutterSettingConfig;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;

public final /* synthetic */ class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ApiManagerActivity f61541a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterSettingConfig f61542b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f61543c;

    public /* synthetic */ a(ApiManagerActivity apiManagerActivity, FlutterSettingConfig flutterSettingConfig, MethodChannel.Result result) {
        this.f61541a = apiManagerActivity;
        this.f61542b = flutterSettingConfig;
        this.f61543c = result;
    }

    public final void a(Object obj, Object obj2, Object obj3, Object obj4) {
        this.f61541a.Ri(this.f61542b, this.f61543c, (String) obj, (Boolean) obj2, (List) obj3, (Integer) obj4);
    }
}
