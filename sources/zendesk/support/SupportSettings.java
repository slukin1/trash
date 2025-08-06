package zendesk.support;

import zendesk.core.Settings;

class SupportSettings implements Settings {
    private static SupportSettings DEFAULT = new SupportSettings(ConversationsSettings.defaultSettings(), ContactUsSettings.defaultSettings(), AttachmentSettings.defaultSettings(), TicketFormSettings.defaultSettings(), true, true, false, "", "");
    private final AttachmentSettings attachments;
    private final ContactUsSettings contactUs;
    private final ConversationsSettings conversations;
    private final boolean neverRequestEmail;
    private final String referrerUrl;
    private final boolean showClosedRequests;
    private final boolean showReferrerLogo;
    private final String systemMessage;
    private final TicketFormSettings ticketForms;

    public SupportSettings(ConversationsSettings conversationsSettings, ContactUsSettings contactUsSettings, AttachmentSettings attachmentSettings, TicketFormSettings ticketFormSettings, boolean z11, boolean z12, boolean z13, String str, String str2) {
        this.conversations = conversationsSettings;
        this.contactUs = contactUsSettings;
        this.attachments = attachmentSettings;
        this.ticketForms = ticketFormSettings;
        this.neverRequestEmail = z11;
        this.showClosedRequests = z12;
        this.showReferrerLogo = z13;
        this.referrerUrl = str;
        this.systemMessage = str2;
    }

    public static SupportSettings defaultSettings() {
        return DEFAULT;
    }

    public AttachmentSettings getAttachments() {
        return this.attachments;
    }

    public ContactUsSettings getContactUs() {
        return this.contactUs;
    }

    public ConversationsSettings getConversations() {
        return this.conversations;
    }

    public String getReferrerUrl() {
        return this.referrerUrl;
    }

    public String getSystemMessage() {
        return this.systemMessage;
    }

    public TicketFormSettings getTicketForms() {
        return this.ticketForms;
    }

    public boolean isNeverRequestEmailOn() {
        return this.neverRequestEmail;
    }

    public boolean isShowClosedRequests() {
        return this.showClosedRequests;
    }

    public boolean isShowReferrerLogo() {
        return this.showReferrerLogo;
    }
}
