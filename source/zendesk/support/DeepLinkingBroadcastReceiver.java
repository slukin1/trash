package zendesk.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.zendesk.logger.Logger;
import java.util.ArrayList;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;

public class DeepLinkingBroadcastReceiver extends BroadcastReceiver {
    public static final String EXTRA_BACK_STACK_ACTIVITIES = "extra_follow_up_activities";
    public static final String EXTRA_REQUEST_INTENT = "extra_request_intent";
    private static final String LOG_TAG = "DeepLinkingBroadcastReceiver";
    public ActionHandlerRegistry registry;

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        SdkDependencyProvider sdkDependencyProvider = SdkDependencyProvider.INSTANCE;
        if (!sdkDependencyProvider.isInitialized()) {
            Logger.d(LOG_TAG, "Cannot use Support SDK without initializing Zendesk. Call Zendesk.INSTANCE.init(...) and Support.INSTANCE.init(Zendesk)", new Object[0]);
            return;
        }
        sdkDependencyProvider.provideSupportSdkComponent().inject(this);
        Intent intent2 = (Intent) intent.getParcelableExtra(EXTRA_REQUEST_INTENT);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(EXTRA_BACK_STACK_ACTIVITIES);
        ActionHandler handlerByAction = this.registry.handlerByAction(DeepLinkToRequestActionHandler.REQUEST_VIEW_CONVERSATION);
        if (handlerByAction != null) {
            handlerByAction.handle(DeepLinkToRequestActionHandler.data(intent2, parcelableArrayListExtra), context);
        }
    }
}
