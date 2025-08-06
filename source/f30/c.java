package f30;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import zendesk.belvedere.MediaResult;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f60254a;

    /* renamed from: b  reason: collision with root package name */
    public final a f60255b;

    public c(Context context) {
        this.f60254a = context.getApplicationContext();
        this.f60255b = new a(context, Build.VERSION.SDK_INT);
    }

    public boolean a(String str) {
        return i.c(str, this.f60254a);
    }

    public List<MediaResult> b(int i11) {
        int lastIndexOf;
        ArrayList arrayList = new ArrayList();
        Cursor a11 = this.f60255b.a(i11);
        if (a11 != null) {
            while (a11.moveToNext()) {
                try {
                    Uri contentUri = MediaStore.Files.getContentUri("external", a11.getLong(a11.getColumnIndex("_id")));
                    long j11 = a11.getLong(a11.getColumnIndex("_size"));
                    long j12 = a11.getLong(a11.getColumnIndex("width"));
                    long j13 = a11.getLong(a11.getColumnIndex("height"));
                    String string = a11.getString(a11.getColumnIndex("_display_name"));
                    String str = "image/jpeg";
                    if (!TextUtils.isEmpty(string) && (lastIndexOf = string.lastIndexOf(InstructionFileId.DOT)) != -1) {
                        str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(string.substring(lastIndexOf + 1));
                    }
                    arrayList.add(new MediaResult((File) null, contentUri, contentUri, string, str, j11, j12, j13));
                } catch (Throwable th2) {
                    a11.close();
                    throw th2;
                }
            }
        }
        if (a11 != null) {
            a11.close();
        }
        return arrayList;
    }
}
