package zendesk.support.guide;

import java.util.List;
import zendesk.classic.messaging.c;
import zendesk.core.RetryAction;

public interface HelpCenterMvp$Presenter {
    void init(HelpCenterConfiguration helpCenterConfiguration, List<c> list);

    void onErrorWithRetry(HelpCenterMvp$ErrorType helpCenterMvp$ErrorType, RetryAction retryAction);

    void onLoad();

    void onPause();

    void onResume(HelpCenterMvp$View helpCenterMvp$View);

    void onSearchSubmit(String str);

    boolean shouldShowConversationsMenuItem();

    boolean shouldShowSearchMenuItem();
}
