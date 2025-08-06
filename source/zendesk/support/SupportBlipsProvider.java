package zendesk.support;

public interface SupportBlipsProvider {
    void requestCreated(String str);

    void requestListViewed();

    void requestUpdated(String str);

    void requestViewed(String str);

    void supportSdkInit();
}
