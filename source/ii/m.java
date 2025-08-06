package ii;

import com.huobi.assetrecord.AssetRecordActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class m implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetRecordActivity f55091b;

    public /* synthetic */ m(AssetRecordActivity assetRecordActivity) {
        this.f55091b = assetRecordActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f55091b.Oi(methodCall, result);
    }
}
