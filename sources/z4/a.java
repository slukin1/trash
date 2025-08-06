package z4;

import android.database.Cursor;
import android.util.Log;
import com.iproov.sdk.bridge.OptionsBridge;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66723a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f66724b;

    public static final void a(Object obj) {
        String str;
        if (f66724b) {
            if (obj == null || (str = obj.toString()) == null) {
                str = OptionsBridge.NULL_VALUE;
            }
            Log.d("PhotoManager", str);
        }
    }

    public static final void b(Object obj) {
        String str;
        if (f66724b) {
            if (obj == null || (str = obj.toString()) == null) {
                str = OptionsBridge.NULL_VALUE;
            }
            Log.e("PhotoManager", str);
        }
    }

    public static final void c(Object obj, Throwable th2) {
        String str;
        if (f66724b) {
            if (obj == null || (str = obj.toString()) == null) {
                str = OptionsBridge.NULL_VALUE;
            }
            Log.e("PhotoManager", str, th2);
        }
    }

    public static final void d(Object obj) {
        String str;
        if (f66724b) {
            if (obj == null || (str = obj.toString()) == null) {
                str = OptionsBridge.NULL_VALUE;
            }
            Log.i("PhotoManager", str);
        }
    }

    public static final void f(Cursor cursor, String str) {
        String str2;
        if (cursor == null) {
            a("The cursor is null");
            return;
        }
        a("The cursor row: " + cursor.getCount());
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            StringBuilder sb2 = new StringBuilder();
            int columnIndex = cursor.getColumnIndex(str);
            if (columnIndex != -1) {
                String string = cursor.getString(columnIndex);
                sb2.append("\nid: ");
                sb2.append(string);
                sb2.append("\n");
            }
            for (String str3 : cursor.getColumnNames()) {
                int columnIndex2 = cursor.getColumnIndex(str3);
                try {
                    str2 = cursor.getString(columnIndex2);
                } catch (Exception e11) {
                    e11.printStackTrace();
                    byte[] blob = cursor.getBlob(columnIndex2);
                    str2 = "blob(" + blob.length + ')';
                }
                if (!StringsKt__StringsJVMKt.w(str3, str, true)) {
                    sb2.append("|--");
                    sb2.append(str3);
                    sb2.append(" : ");
                    sb2.append(str2);
                    sb2.append("\n");
                }
            }
            a(sb2);
        }
        cursor.moveToPosition(-1);
    }

    public final boolean e() {
        return f66724b;
    }

    public final void g(boolean z11) {
        f66724b = z11;
    }
}
