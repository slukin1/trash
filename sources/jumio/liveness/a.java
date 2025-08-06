package jumio.liveness;

import java.util.Locale;

public enum a {
    NEAR,
    FAR,
    TOO_FAR,
    TOO_NEAR;

    public final String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
