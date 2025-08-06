package androidx.camera.video;

import android.net.Uri;
import androidx.core.util.h;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class OutputResults {
    public static OutputResults b(Uri uri) {
        h.h(uri, "OutputUri cannot be null.");
        return new h(uri);
    }

    public abstract Uri a();
}
