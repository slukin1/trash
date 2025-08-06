package jumio.core;

import android.os.ParcelFileDescriptor;
import com.jumio.sdk.views.JumioFileAttacher;
import java.io.File;

public interface j1 {
    void a(ParcelFileDescriptor parcelFileDescriptor);

    void a(File file);

    JumioFileAttacher.JumioFileRequirements b();
}
