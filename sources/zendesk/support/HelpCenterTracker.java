package zendesk.support;

interface HelpCenterTracker {

    public static class DefaultTracker implements HelpCenterTracker {
        public void helpCenterArticleViewed() {
        }

        public void helpCenterLoaded() {
        }

        public void helpCenterSearched(String str) {
        }
    }

    void helpCenterArticleViewed();

    void helpCenterLoaded();

    void helpCenterSearched(String str);
}
