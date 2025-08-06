package fq;

import com.huobi.points.activity.AbsPointsNewActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsPointsNewActivity f54735b;

    public /* synthetic */ a(AbsPointsNewActivity absPointsNewActivity) {
        this.f54735b = absPointsNewActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f54735b.Hi(methodCall, result);
    }
}
