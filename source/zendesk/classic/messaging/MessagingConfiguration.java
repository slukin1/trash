package zendesk.classic.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;
import mz.f;
import zendesk.configurations.Configuration;
import zendesk.configurations.ConfigurationHelper;

public class MessagingConfiguration implements Configuration {
    private static final String DEFAULT_AGENT_ID = "ANSWER_BOT";
    private AgentDetails botAgentDetails;
    private final int botAvatarDrawable;
    private final String botLabelString;
    private final int botLabelStringRes;
    private final List<Configuration> configurations;
    private final String engineRegistryKey;
    private final boolean multilineResponseOptionsEnabled;
    private final String toolbarTitle;
    private final int toolbarTitleRes;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public List<Configuration> f62366a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<c> f62367b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public int f62368c = R$string.zui_toolbar_title;

        /* renamed from: d  reason: collision with root package name */
        public String f62369d;

        /* renamed from: e  reason: collision with root package name */
        public int f62370e = R$string.zui_default_bot_name;

        /* renamed from: f  reason: collision with root package name */
        public String f62371f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f62372g = false;

        /* renamed from: h  reason: collision with root package name */
        public int f62373h = R$drawable.zui_avatar_bot_default;

        public Configuration h(Context context) {
            return new MessagingConfiguration(this, EngineListRegistry.INSTANCE.register(this.f62367b));
        }

        @SuppressLint({"RestrictedApi"})
        public Intent i(Context context, List<Configuration> list) {
            this.f62366a = list;
            Configuration h11 = h(context);
            Intent intent = new Intent(context, MessagingActivity.class);
            ConfigurationHelper.h().c(intent, h11);
            return intent;
        }

        public void j(Context context, List<Configuration> list) {
            context.startActivity(i(context, list));
        }

        public Builder k(List<c> list) {
            this.f62367b = list;
            return this;
        }
    }

    private String getBotLabelString(Resources resources) {
        return f.c(this.botLabelString) ? this.botLabelString : resources.getString(this.botLabelStringRes);
    }

    public AgentDetails getBotAgentDetails(Resources resources) {
        if (this.botAgentDetails == null) {
            this.botAgentDetails = new AgentDetails(getBotLabelString(resources), DEFAULT_AGENT_ID, true, Integer.valueOf(this.botAvatarDrawable));
        }
        return this.botAgentDetails;
    }

    public int getBotAvatarDrawable() {
        return this.botAvatarDrawable;
    }

    public List<Configuration> getConfigurations() {
        return ConfigurationHelper.h().a(this.configurations, this);
    }

    public List<c> getEngines() {
        return EngineListRegistry.INSTANCE.retrieveEngineList(this.engineRegistryKey);
    }

    public String getToolbarTitle(Resources resources) {
        return f.c(this.toolbarTitle) ? this.toolbarTitle : resources.getString(this.toolbarTitleRes);
    }

    public boolean isMultilineResponseOptionsEnabled() {
        return this.multilineResponseOptionsEnabled;
    }

    private MessagingConfiguration(Builder builder, String str) {
        this.configurations = builder.f62366a;
        this.engineRegistryKey = str;
        this.toolbarTitle = builder.f62369d;
        this.toolbarTitleRes = builder.f62368c;
        this.botLabelString = builder.f62371f;
        this.botLabelStringRes = builder.f62370e;
        this.botAvatarDrawable = builder.f62373h;
        this.multilineResponseOptionsEnabled = builder.f62372g;
    }
}
