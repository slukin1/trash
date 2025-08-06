package org.greenrobot.greendao;

import android.database.SQLException;

public class DaoException extends SQLException {
    private static final long serialVersionUID = -5877937327907457779L;

    public DaoException() {
    }

    public void safeInitCause(Throwable th2) {
        try {
            initCause(th2);
        } catch (Throwable th3) {
            DaoLog.e("Could not set initial cause", th3);
            DaoLog.e("Initial cause is:", th2);
        }
    }

    public DaoException(String str) {
        super(str);
    }

    public DaoException(String str, Throwable th2) {
        super(str);
        safeInitCause(th2);
    }

    public DaoException(Throwable th2) {
        safeInitCause(th2);
    }
}
