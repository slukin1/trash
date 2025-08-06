package xy;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f40657a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40658b;

    /* renamed from: c  reason: collision with root package name */
    public final int f40659c;

    /* renamed from: d  reason: collision with root package name */
    public final int f40660d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteDatabase f40661e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40662f;

    /* renamed from: xy.a$a  reason: collision with other inner class name */
    public class C0552a implements DatabaseErrorHandler {
        public C0552a() {
        }

        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        }
    }

    public a(String str, int i11, boolean z11, int i12) {
        this.f40658b = str;
        this.f40657a = z11;
        this.f40659c = i11;
        this.f40660d = i12;
    }

    public static void b(String str) {
        SQLiteDatabase.deleteDatabase(new File(str));
    }

    public void a() {
        this.f40661e.close();
    }

    public SQLiteDatabase c() {
        return this.f40661e;
    }

    public String d() {
        return "[" + e() + "] ";
    }

    public String e() {
        Thread currentThread = Thread.currentThread();
        return "" + this.f40659c + Constants.ACCEPT_TIME_SEPARATOR_SP + currentThread.getName() + "(" + currentThread.getId() + ")";
    }

    public SQLiteDatabase f() {
        return this.f40661e;
    }

    public void g() {
        this.f40661e = SQLiteDatabase.openDatabase(this.f40658b, (SQLiteDatabase.CursorFactory) null, 268435456);
    }

    public void h() {
        this.f40661e = SQLiteDatabase.openDatabase(this.f40658b, (SQLiteDatabase.CursorFactory) null, 1, new C0552a());
    }
}
