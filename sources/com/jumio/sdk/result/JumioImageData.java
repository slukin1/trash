package com.jumio.sdk.result;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.utils.FileUtil;
import com.jumio.core.environment.Environment;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.sdk.enums.JumioCredentialPart;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.d0;

public final class JumioImageData implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final AuthorizationModel.SessionKey f25004a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<JumioCredentialPart, String> f25005b = new HashMap<>();

    public JumioImageData(AuthorizationModel authorizationModel) {
        AuthorizationModel.SessionKey sessionKey = new AuthorizationModel.SessionKey();
        this.f25004a = sessionKey;
        sessionKey.generate();
    }

    public final void addImage$jumio_core_release(Context context, byte[] bArr, JumioCredentialPart jumioCredentialPart) {
        File dataDirectory = Environment.INSTANCE.getDataDirectory(context);
        d0 d0Var = d0.f56774a;
        Locale locale = Locale.ENGLISH;
        File file = new File(dataDirectory, String.format(locale, "%d_%s.bin", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis()), jumioCredentialPart.name().toLowerCase(locale)}, 2)));
        FileUtil.INSTANCE.saveToFile(bArr, file, this.f25004a);
        this.f25005b.put(jumioCredentialPart, file.getAbsolutePath());
    }

    public final void clear() {
        this.f25004a.clear();
        for (Map.Entry<JumioCredentialPart, String> value : this.f25005b.entrySet()) {
            String str = (String) value.getValue();
            if (str != null) {
                File file = new File(str);
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
        this.f25005b.clear();
    }

    public final Bitmap getBitmap(JumioCredentialPart jumioCredentialPart) {
        try {
            if (!this.f25005b.containsKey(jumioCredentialPart)) {
                return null;
            }
            return CameraUtils.readBitmap$default(CameraUtils.INSTANCE, this.f25005b.get(jumioCredentialPart), this.f25004a, (BitmapFactory.Options) null, 4, (Object) null);
        } catch (Exception unused) {
        }
    }

    public final byte[] getByteArray(JumioCredentialPart jumioCredentialPart) {
        try {
            String str = this.f25005b.get(jumioCredentialPart);
            if (str != null) {
                return FileUtil.INSTANCE.readFile(str, this.f25004a);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final boolean hasPart(JumioCredentialPart jumioCredentialPart) {
        return this.f25005b.containsKey(jumioCredentialPart);
    }
}
