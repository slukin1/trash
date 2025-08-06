package zendesk.support.guide;

import zendesk.configurations.ConfigurationHelper;
import zendesk.core.ActionHandler;

class GuideSdkModule {
    public static ActionHandler viewArticleActionHandler() {
        return new ViewArticleActionHandler();
    }

    public ConfigurationHelper configurationHelper() {
        return new ConfigurationHelper();
    }
}
