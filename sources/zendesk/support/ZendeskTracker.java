package zendesk.support;

interface ZendeskTracker {

    public static class DefaultTracker implements ZendeskTracker {
        public void requestCreated() {
        }

        public void requestUpdated() {
        }
    }

    void requestCreated();

    void requestUpdated();
}
