package zendesk.support.guide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import com.zendesk.logger.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import mz.a;
import zendesk.classic.messaging.EngineListRegistry;
import zendesk.classic.messaging.c;
import zendesk.configurations.Configuration;
import zendesk.configurations.ConfigurationHelper;

public class HelpCenterConfiguration implements Configuration {
    /* access modifiers changed from: private */
    public final List<Long> categoryIds;
    /* access modifiers changed from: private */
    public final boolean collapseCategories;
    private List<Configuration> configurations;
    /* access modifiers changed from: private */
    public final boolean contactUsButtonVisibility;
    /* access modifiers changed from: private */
    public final String engineRegistryId;
    /* access modifiers changed from: private */
    public final String[] labelNames;
    /* access modifiers changed from: private */
    public final List<Long> sectionIds;
    /* access modifiers changed from: private */
    public final boolean showConversationsMenuButton;

    public static class Builder {
        /* access modifiers changed from: private */
        public List<Long> categoryIds = Collections.emptyList();
        /* access modifiers changed from: private */
        public boolean collapseCategories = false;
        /* access modifiers changed from: private */
        public List<Configuration> configurations = new ArrayList();
        /* access modifiers changed from: private */
        public boolean contactUsButtonVisible = true;
        private List<c> engines = Collections.emptyList();
        /* access modifiers changed from: private */
        public String[] labelNames = new String[0];
        /* access modifiers changed from: private */
        public List<Long> sectionIds = Collections.emptyList();
        /* access modifiers changed from: private */
        public boolean showConversationsMenuButton = true;

        private void setConfigurations(List<Configuration> list) {
            this.configurations = list;
            HelpCenterConfiguration helpCenterConfiguration = (HelpCenterConfiguration) ConfigurationHelper.h().e(list, HelpCenterConfiguration.class);
            if (helpCenterConfiguration != null) {
                this.contactUsButtonVisible = helpCenterConfiguration.contactUsButtonVisibility;
                this.categoryIds = helpCenterConfiguration.categoryIds;
                this.sectionIds = helpCenterConfiguration.sectionIds;
                this.collapseCategories = helpCenterConfiguration.collapseCategories;
                this.labelNames = helpCenterConfiguration.labelNames;
                this.engines = EngineListRegistry.INSTANCE.retrieveEngineList(helpCenterConfiguration.engineRegistryId);
                this.showConversationsMenuButton = helpCenterConfiguration.showConversationsMenuButton;
            }
        }

        public Configuration config() {
            return new HelpCenterConfiguration(this, EngineListRegistry.INSTANCE.register(this.engines));
        }

        public Intent intent(Context context, Configuration... configurationArr) {
            return intent(context, (List<Configuration>) Arrays.asList(configurationArr));
        }

        public void show(Context context, Configuration... configurationArr) {
            context.startActivity(intent(context, configurationArr));
        }

        public Builder withArticlesForCategoryIds(Long... lArr) {
            return withArticlesForCategoryIds((List<Long>) Arrays.asList(lArr));
        }

        public Builder withArticlesForSectionIds(Long... lArr) {
            return withArticlesForSectionIds((List<Long>) Arrays.asList(lArr));
        }

        public Builder withCategoriesCollapsed(boolean z11) {
            this.collapseCategories = z11;
            return this;
        }

        public Builder withContactUsButtonVisible(boolean z11) {
            this.contactUsButtonVisible = z11;
            return this;
        }

        public Builder withEngines(List<c> list) {
            this.engines = list;
            return this;
        }

        public Builder withLabelNames(String... strArr) {
            if (a.j(strArr)) {
                this.labelNames = strArr;
            }
            return this;
        }

        public Builder withShowConversationsMenuButton(boolean z11) {
            this.showConversationsMenuButton = z11;
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        public Intent intent(Context context, List<Configuration> list) {
            setConfigurations(list);
            Intent intent = new Intent(context, HelpCenterActivity.class);
            ConfigurationHelper.h().c(intent, config());
            return intent;
        }

        public void show(Context context, List<Configuration> list) {
            context.startActivity(intent(context, list));
        }

        public Builder withArticlesForCategoryIds(List<Long> list) {
            if (this.sectionIds.size() > 0) {
                Logger.l(HelpCenterActivity.LOG_TAG, "Builder: sections have already been specified. Removing section IDs to set category IDs.", new Object[0]);
                this.sectionIds = Collections.emptyList();
            }
            this.categoryIds = a.c(list);
            return this;
        }

        public Builder withArticlesForSectionIds(List<Long> list) {
            if (this.categoryIds.size() > 0) {
                Logger.l(HelpCenterActivity.LOG_TAG, "Builder: categories have already been specified. Removing category IDs to set section IDs.", new Object[0]);
                this.categoryIds = Collections.emptyList();
            }
            this.sectionIds = a.c(list);
            return this;
        }

        public Builder withEngines(c... cVarArr) {
            return withEngines((List<c>) Arrays.asList(cVarArr));
        }

        public Builder withLabelNames(List<String> list) {
            return withLabelNames((String[]) list.toArray(new String[0]));
        }
    }

    public List<Long> getCategoryIds() {
        return this.categoryIds;
    }

    @SuppressLint({"RestrictedApi"})
    public List<Configuration> getConfigurations() {
        return ConfigurationHelper.h().a(this.configurations, this);
    }

    public List<c> getEngines() {
        return EngineListRegistry.INSTANCE.retrieveEngineList(this.engineRegistryId);
    }

    public String[] getLabelNames() {
        return this.labelNames;
    }

    public List<Long> getSectionIds() {
        return this.sectionIds;
    }

    public boolean isCollapseCategories() {
        return this.collapseCategories;
    }

    public boolean isContactUsButtonVisible() {
        return this.contactUsButtonVisibility;
    }

    public boolean isShowConversationsMenuButton() {
        return this.showConversationsMenuButton;
    }

    private HelpCenterConfiguration(Builder builder, String str) {
        this.categoryIds = builder.categoryIds;
        this.sectionIds = builder.sectionIds;
        this.labelNames = builder.labelNames;
        this.contactUsButtonVisibility = builder.contactUsButtonVisible;
        this.collapseCategories = builder.collapseCategories;
        this.showConversationsMenuButton = builder.showConversationsMenuButton;
        this.configurations = builder.configurations;
        this.engineRegistryId = str;
    }
}
