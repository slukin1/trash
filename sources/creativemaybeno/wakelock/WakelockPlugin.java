package creativemaybeno.wakelock;

import android.app.Activity;
import creativemaybeno.wakelock.Messages;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import nz.c;

public final class WakelockPlugin implements FlutterPlugin, Messages.a, ActivityAware {

    /* renamed from: b  reason: collision with root package name */
    public Wakelock f53469b;

    public void a(Messages.ToggleMessage toggleMessage) {
        this.f53469b.d(toggleMessage);
    }

    public Messages.IsEnabledMessage isEnabled() {
        return this.f53469b.b();
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Wakelock wakelock = this.f53469b;
        if (wakelock != null) {
            wakelock.c(activityPluginBinding.getActivity());
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        c.f(flutterPluginBinding.getBinaryMessenger(), this);
        this.f53469b = new Wakelock();
    }

    public void onDetachedFromActivity() {
        Wakelock wakelock = this.f53469b;
        if (wakelock != null) {
            wakelock.c((Activity) null);
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        c.f(flutterPluginBinding.getBinaryMessenger(), (Messages.a) null);
        this.f53469b = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
