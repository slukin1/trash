package com.huobi.vulcan.utils;

import com.huobi.vulcan.model.ExceptionLogModel;
import iu.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class ExceptionLogUtil {
    public static void a(String str, String str2) {
        List d11 = d();
        if (d11 == null || d11.size() < 100) {
            if (d11 == null) {
                d11 = new ArrayList();
            }
            ExceptionLogModel exceptionLogModel = new ExceptionLogModel();
            exceptionLogModel.setTimestamp(System.currentTimeMillis());
            exceptionLogModel.setError_code(str);
            exceptionLogModel.setError_msg(str2);
            d11.add(exceptionLogModel);
            JSONArray jsonArr = ExceptionLogModel.toJsonArr(d11);
            if (jsonArr != null) {
                LogUtils.d(jsonArr.toString(), c(), false);
            }
        }
    }

    public static boolean b() {
        return FileUtils.c(c(), e());
    }

    public static String c() {
        return f() + "_log_exception";
    }

    public static List<ExceptionLogModel> d() {
        try {
            if (!g()) {
                return ExceptionLogModel.fromJsonArrStr(FileUtils.h(c()));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String e() {
        return f() + "_log_exception_temp";
    }

    public static String f() {
        return a.f().c().getFilesDir().getAbsolutePath() + File.separator;
    }

    public static boolean g() {
        return !FileUtils.e(c()) || FileUtils.f(c()) <= 0;
    }
}
