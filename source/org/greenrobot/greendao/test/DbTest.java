package org.greenrobot.greendao.test;

import android.app.Application;
import android.app.Instrumentation;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import java.util.Random;
import junit.framework.TestCase;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.DbUtils;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.StandardDatabase;

public abstract class DbTest extends AndroidTestCase {
    public static final String DB_NAME = "greendao-unittest-db.temp";
    private Application application;

    /* renamed from: db  reason: collision with root package name */
    public Database f70136db;
    public final boolean inMemory;
    public final Random random;

    public DbTest() {
        this(true);
    }

    public <T extends Application> T createApplication(Class<T> cls) {
        TestCase.assertNull("Application already created", this.application);
        try {
            T newApplication = Instrumentation.newApplication(cls, getContext());
            newApplication.onCreate();
            this.application = newApplication;
            return newApplication;
        } catch (Exception e11) {
            throw new RuntimeException("Could not create application " + cls, e11);
        }
    }

    public Database createDatabase() {
        SQLiteDatabase sQLiteDatabase;
        if (this.inMemory) {
            sQLiteDatabase = SQLiteDatabase.create((SQLiteDatabase.CursorFactory) null);
        } else {
            getContext().deleteDatabase(DB_NAME);
            sQLiteDatabase = getContext().openOrCreateDatabase(DB_NAME, 0, (SQLiteDatabase.CursorFactory) null);
        }
        return new StandardDatabase(sQLiteDatabase);
    }

    public <T extends Application> T getApplication() {
        TestCase.assertNotNull("Application not yet created", this.application);
        return this.application;
    }

    public void logTableDump(String str) {
        Database database = this.f70136db;
        if (database instanceof StandardDatabase) {
            DbUtils.logTableDump(((StandardDatabase) database).getSQLiteDatabase(), str);
            return;
        }
        DaoLog.w("Table dump unsupported for " + this.f70136db);
    }

    public void setUp() throws Exception {
        DbTest.super.setUp();
        this.f70136db = createDatabase();
    }

    public void tearDown() throws Exception {
        if (this.application != null) {
            terminateApplication();
        }
        this.f70136db.close();
        if (!this.inMemory) {
            getContext().deleteDatabase(DB_NAME);
        }
        DbTest.super.tearDown();
    }

    public void terminateApplication() {
        TestCase.assertNotNull("Application not yet created", this.application);
        this.application.onTerminate();
        this.application = null;
    }

    public DbTest(boolean z11) {
        this.inMemory = z11;
        this.random = new Random();
    }
}
