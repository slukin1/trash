package o3;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public class f extends b<ParcelFileDescriptor> {
    public f(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    /* renamed from: g */
    public void d(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    /* renamed from: h */
    public ParcelFileDescriptor e(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
