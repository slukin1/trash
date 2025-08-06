package jumio.dui;

import android.os.Build;
import android.os.Bundle;
import java.io.Serializable;

public final class d {
    public static final Serializable a(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 33) {
            return bundle.getSerializable(str, cls);
        }
        Serializable serializable = bundle.getSerializable(str);
        if (serializable instanceof Serializable) {
            return serializable;
        }
        return null;
    }
}
