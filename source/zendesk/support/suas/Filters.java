package zendesk.support.suas;

public class Filters {
    public static final Filter DEFAULT = new DefaultFilter();
    public static final Filter EQUALS = new EqualsFilter();

    public static class DefaultFilter implements Filter {
        private DefaultFilter() {
        }

        public boolean filter(Object obj, Object obj2) {
            return true;
        }
    }

    public static class EqualsFilter implements Filter {
        private EqualsFilter() {
        }

        public boolean filter(Object obj, Object obj2) {
            return !obj.equals(obj2);
        }
    }

    private Filters() {
    }
}
