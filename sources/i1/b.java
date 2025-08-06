package i1;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class b {
    public static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static String b(Context context, Uri uri) {
        return c(context, uri, "_display_name", (String) null);
    }

    public static String c(Context context, Uri uri, String str, String str2) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, (String) null, (String[]) null, (String) null);
            if (cursor.moveToFirst() && !cursor.isNull(0)) {
                return cursor.getString(0);
            }
            a(cursor);
            return str2;
        } catch (Exception e11) {
            Log.w("DocumentFile", "Failed query: " + e11);
            return str2;
        } finally {
            a(cursor);
        }
    }
}
