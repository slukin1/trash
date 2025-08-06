package androidx.credentials;

import android.os.Bundle;

public class k extends f {
    private final Bundle data;
    private final String type;

    public k(String str, Bundle bundle) {
        super(str, bundle);
        this.type = str;
        this.data = bundle;
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException("type should not be empty".toString());
        }
    }

    public final Bundle getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }
}
