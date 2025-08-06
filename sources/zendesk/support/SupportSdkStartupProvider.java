package zendesk.support;

import android.annotation.SuppressLint;
import android.content.Context;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.SdkStartUpProvider;
import zendesk.core.Zendesk;

@SuppressLint({"RestrictedApi"})
public final class SupportSdkStartupProvider extends SdkStartUpProvider {
    private CreateRequestActionHandler createRequestActionHandler;
    private RequestListActionHandler requestListActionHandler;

    public void onStartUp(Context context) {
        ActionHandlerRegistry actionHandlerRegistry = Zendesk.INSTANCE.actionHandlerRegistry();
        CreateRequestActionHandler createRequestActionHandler2 = this.createRequestActionHandler;
        if (createRequestActionHandler2 != null) {
            actionHandlerRegistry.remove(createRequestActionHandler2);
        }
        RequestListActionHandler requestListActionHandler2 = this.requestListActionHandler;
        if (requestListActionHandler2 != null) {
            actionHandlerRegistry.remove(requestListActionHandler2);
        }
        this.createRequestActionHandler = new CreateRequestActionHandler(context);
        this.requestListActionHandler = new RequestListActionHandler();
        actionHandlerRegistry.add(this.createRequestActionHandler);
        actionHandlerRegistry.add(this.requestListActionHandler);
    }
}
