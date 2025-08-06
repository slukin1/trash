package bolts;

import android.content.Intent;
import android.os.Bundle;

public final class AppLinks {
    public static Bundle a(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    public static Bundle b(Intent intent) {
        Bundle a11 = a(intent);
        if (a11 == null) {
            return null;
        }
        return a11.getBundle("extras");
    }
}
