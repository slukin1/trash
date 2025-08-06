package zendesk.support.request;

import java.io.Serializable;
import zendesk.support.SupportSdkSettings;

class StateSettings implements Serializable {
    private final boolean attachmentsEnabled;
    private final boolean conversationsEnabled;
    private final boolean hasIdentityEmailAddress;
    private final boolean hasIdentityName;
    private final long maxAttachmentSize;
    private final boolean neverRequestEmail;
    private final String referrerUrl;
    private final boolean settingsLoaded;
    private final boolean showZendeskLogo;
    private final String systemMessage;

    public StateSettings(boolean z11, boolean z12, long j11, boolean z13, boolean z14, boolean z15, boolean z16, String str, String str2) {
        this.settingsLoaded = true;
        this.conversationsEnabled = z11;
        this.attachmentsEnabled = z12;
        this.maxAttachmentSize = j11;
        this.neverRequestEmail = z13;
        this.hasIdentityEmailAddress = z14;
        this.hasIdentityName = z15;
        this.showZendeskLogo = z16;
        this.referrerUrl = str;
        this.systemMessage = str2;
    }

    public static StateSettings fromSupportSettings(SupportSdkSettings supportSdkSettings, boolean z11, boolean z12) {
        return new StateSettings(supportSdkSettings.isConversationsEnabled(), supportSdkSettings.isAttachmentsEnabled(), supportSdkSettings.getMaxAttachmentSize(), supportSdkSettings.isNeverAskForEmailEnabled(), z11, z12, supportSdkSettings.isShowReferrerLogoEnabled(), supportSdkSettings.getReferrerUrl(), supportSdkSettings.getRequestSystemMessage());
    }

    public long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    public String getReferrerUrl() {
        return this.referrerUrl;
    }

    public String getSystemMessage() {
        return this.systemMessage;
    }

    public boolean hasIdentityEmailAddress() {
        return this.hasIdentityEmailAddress;
    }

    public boolean hasIdentityName() {
        return this.hasIdentityName;
    }

    public boolean hasSettings() {
        return this.settingsLoaded;
    }

    public boolean isAttachmentsEnabled() {
        return this.attachmentsEnabled;
    }

    public boolean isConversationsEnabled() {
        return this.conversationsEnabled;
    }

    public boolean isNeverRequestEmailOn() {
        return this.neverRequestEmail;
    }

    public boolean isShowZendeskLogo() {
        return this.showZendeskLogo;
    }

    public String toString() {
        return "Settings{settingsLoaded=" + this.settingsLoaded + ", conversationsEnabled=" + this.conversationsEnabled + ", attachmentsEnabled=" + this.attachmentsEnabled + ", maxAttachmentSize=" + this.maxAttachmentSize + ", neverRequestEmail=" + this.neverRequestEmail + ", hasIdentityEmailAddress=" + this.hasIdentityEmailAddress + ", hasIdentityName=" + this.hasIdentityName + ", referrerUrl=" + this.referrerUrl + ", systemMessage=" + this.systemMessage + '}';
    }

    public StateSettings() {
        this.settingsLoaded = false;
        this.conversationsEnabled = false;
        this.attachmentsEnabled = false;
        this.maxAttachmentSize = -1;
        this.neverRequestEmail = true;
        this.hasIdentityEmailAddress = false;
        this.hasIdentityName = false;
        this.showZendeskLogo = true;
        this.referrerUrl = "";
        this.systemMessage = "";
    }
}
