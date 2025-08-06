package uk.co.senab.photoview.log;

import android.util.Log;
import d30.a;

public class LoggerDefault implements a {
    public int d(String str, String str2) {
        return Log.d(str, str2);
    }

    public int i(String str, String str2) {
        return Log.i(str, str2);
    }
}
