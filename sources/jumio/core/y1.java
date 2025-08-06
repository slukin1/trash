package jumio.core;

import com.jumio.commons.log.Log;
import com.jumio.core.models.AuthorizationModel;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.crypto.CipherOutputStream;

public final class y1 {

    /* renamed from: a  reason: collision with root package name */
    public final ObjectOutputStream f56348a;

    public y1(AuthorizationModel.SessionKey sessionKey, File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
            this.f56348a = new ObjectOutputStream(new BufferedOutputStream(new CipherOutputStream(new FileOutputStream(file), sessionKey.getEncryptCipher())));
        } catch (Exception e11) {
            Log.w("PersistenceUtil", "Error initializing persistence", (Throwable) e11);
        }
    }

    public final void a(Serializable serializable) {
        try {
            ObjectOutputStream objectOutputStream = this.f56348a;
            if (objectOutputStream != null) {
                objectOutputStream.writeObject(serializable);
            }
        } catch (Exception e11) {
            Log.w("PersistenceUtil", "Error adding data to persist", (Throwable) e11);
        }
    }
}
