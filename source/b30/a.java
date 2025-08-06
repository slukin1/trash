package b30;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;

public final class a {
    public static final String a(String str, String str2) {
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            File file = new File(str2);
            file.createNewFile();
            decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file));
            return file.getPath();
        } catch (Exception unused) {
            return null;
        }
    }
}
