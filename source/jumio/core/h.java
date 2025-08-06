package jumio.core;

import android.content.Context;
import com.jumio.core.network.TrustManagerInterface;
import com.jumio.core.persistence.DataManager;

public interface h {
    Context getContext();

    DataManager getDataManager();

    d1 getEncryptionProvider();

    String getHost();

    TrustManagerInterface getTrustManager();

    String getUserAgent();
}
