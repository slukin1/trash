package zendesk.support.guide;

import android.annotation.SuppressLint;
import android.content.Context;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.SdkStartUpProvider;
import zendesk.core.Zendesk;

@SuppressLint({"RestrictedApi"})
public class GuideSdkStartupProvider extends SdkStartUpProvider {
    public ViewArticleActionHandler articleActionHandler;

    public void onStartUp(Context context) {
        ActionHandlerRegistry actionHandlerRegistry = Zendesk.INSTANCE.actionHandlerRegistry();
        ViewArticleActionHandler viewArticleActionHandler = this.articleActionHandler;
        if (viewArticleActionHandler != null) {
            actionHandlerRegistry.remove(viewArticleActionHandler);
        }
        ViewArticleActionHandler viewArticleActionHandler2 = new ViewArticleActionHandler();
        this.articleActionHandler = viewArticleActionHandler2;
        actionHandlerRegistry.add(viewArticleActionHandler2);
    }
}
