package o3;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class j extends b<InputStream> {
    public j(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    /* renamed from: g */
    public void d(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* renamed from: h */
    public InputStream e(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }
}
