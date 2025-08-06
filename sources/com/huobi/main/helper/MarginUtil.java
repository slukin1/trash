package com.huobi.main.helper;

import android.net.Uri;
import zn.a;

public class MarginUtil {
    public static void a(String str) {
        a d11 = a.d();
        d11.v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=margin&rootName=home&navConfig=&type=1&marginType=1&currency=" + str)).a().c();
    }

    public static void b(String str) {
        a d11 = a.d();
        d11.v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=margin&rootName=home&navConfig=&type=2&marginType=1&currency=" + str)).a().c();
    }

    public static void c(String str) {
        a d11 = a.d();
        d11.v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=margin&rootName=home&navConfig=&type=1&marginType=2&symbol=" + str)).a().c();
    }

    public static void d(String str) {
        a d11 = a.d();
        d11.v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=margin&rootName=home&navConfig=&type=2&marginType=2&symbol=" + str)).a().c();
    }
}
