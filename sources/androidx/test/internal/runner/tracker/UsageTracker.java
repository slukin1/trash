package androidx.test.internal.runner.tracker;

public interface UsageTracker {

    public static class NoOpUsageTracker implements UsageTracker {
        public void a() {
        }

        public void b(String str, String str2) {
        }
    }

    void a();

    void b(String str, String str2);
}
