package zendesk.belvedere;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;
import androidx.core.content.FileProvider;
import java.util.Arrays;

public class BelvedereFileProvider extends FileProvider {
    public final String[] a(String[] strArr) {
        for (String equals : strArr) {
            if ("_data".equals(equals)) {
                return strArr;
            }
        }
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
        strArr2[strArr.length] = "_data";
        return strArr2;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query = super.query(uri, strArr, str, strArr2, str2);
        if (query == null) {
            Log.w("Belvedere", "Not able to apply workaround, super.query(...) returned null");
            return null;
        }
        String[] columnNames = query.getColumnNames();
        MatrixCursor matrixCursor = new MatrixCursor(a(columnNames), query.getCount());
        query.moveToPosition(-1);
        while (query.moveToNext()) {
            MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
            for (int i11 = 0; i11 < columnNames.length; i11++) {
                newRow.add(query.getString(i11));
            }
        }
        query.close();
        return matrixCursor;
    }
}
