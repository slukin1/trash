package jumio.core;

import com.jumio.commons.log.Log;
import com.jumio.core.models.AuthorizationModel;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.crypto.CipherInputStream;

public final class z1 {

    /* renamed from: a  reason: collision with root package name */
    public final ObjectInputStream f56352a;

    public z1(AuthorizationModel.SessionKey sessionKey, File file) {
        try {
            this.f56352a = new ObjectInputStream(new BufferedInputStream(new CipherInputStream(new FileInputStream(file), sessionKey.getDecryptCipher())));
        } catch (Exception e11) {
            Log.w("PersistenceUtil", "Error initializing restore", (Throwable) e11);
        }
    }

    public final <T> T a() {
        try {
            ObjectInputStream objectInputStream = this.f56352a;
            if (objectInputStream != null) {
                return objectInputStream.readObject();
            }
            return null;
        } catch (Exception e11) {
            Log.w("PersistenceUtil", "Error getting object to restore", (Throwable) e11);
            return null;
        }
    }
}
