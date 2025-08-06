package jumio.liveness;

import java.util.Locale;

public enum t {
    INITIAL,
    NEAR,
    TRANSITION,
    FAR;

    public final String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
