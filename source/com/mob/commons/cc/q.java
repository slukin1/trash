package com.mob.commons.cc;

public class q implements t<p> {
    public boolean a(p pVar, Class<p> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (!"setHandler".equals(str) || objArr.length != 1 || objArr[0] == null || !(objArr[0] instanceof m)) {
            return false;
        }
        pVar.a(objArr[0]);
        return true;
    }
}
