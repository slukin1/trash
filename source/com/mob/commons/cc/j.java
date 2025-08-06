package com.mob.commons.cc;

public class j implements t<j> {
    public boolean a(j jVar, Class<j> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (!"andOperation".equals(str) || objArr.length != 2) {
            if (!"orOperation".equals(str) || objArr.length != 2) {
                if (!"rMoveOperation".equals(str) || objArr.length != 2) {
                    if (!"rrrMoveOperation".equals(str) || objArr.length != 2) {
                        if (!"lMoveOperation".equals(str) || objArr.length != 2) {
                            if (!"xOperation".equals(str) || objArr.length != 1) {
                                if (!"xorOperation".equals(str) || objArr.length != 2) {
                                    return false;
                                }
                                if (objArr[0] != null && (objArr[0] instanceof Integer) && objArr[1] != null && (objArr[1] instanceof Integer)) {
                                    objArr2[0] = Integer.valueOf(objArr[0].intValue() ^ objArr[1].intValue());
                                } else if (objArr[0] != null && (objArr[0] instanceof Long) && objArr[1] != null && (objArr[1] instanceof Long)) {
                                    objArr2[0] = Long.valueOf(objArr[0].longValue() ^ objArr[1].longValue());
                                }
                            } else if (objArr[0] != null && (objArr[0] instanceof Integer)) {
                                objArr2[0] = Integer.valueOf(~objArr[0].intValue());
                            } else if (objArr[0] != null && (objArr[0] instanceof Long)) {
                                objArr2[0] = Long.valueOf(~objArr[0].longValue());
                            }
                        } else if (objArr[0] != null && (objArr[0] instanceof Integer) && objArr[1] != null && (objArr[1] instanceof Integer)) {
                            objArr2[0] = Integer.valueOf(objArr[0].intValue() << objArr[1].intValue());
                        } else if (objArr[0] != null && (objArr[0] instanceof Long) && objArr[1] != null && (objArr[1] instanceof Long)) {
                            objArr2[0] = Long.valueOf(objArr[0].longValue() << ((int) objArr[1].longValue()));
                        }
                    } else if (objArr[0] != null && (objArr[0] instanceof Integer) && objArr[1] != null && (objArr[1] instanceof Integer)) {
                        objArr2[0] = Integer.valueOf(objArr[0].intValue() >>> objArr[1].intValue());
                    } else if (objArr[0] != null && (objArr[0] instanceof Long) && objArr[1] != null && (objArr[1] instanceof Long)) {
                        objArr2[0] = Long.valueOf(objArr[0].longValue() >>> ((int) objArr[1].longValue()));
                    }
                } else if (objArr[0] != null && (objArr[0] instanceof Integer) && objArr[1] != null && (objArr[1] instanceof Integer)) {
                    objArr2[0] = Integer.valueOf(objArr[0].intValue() >> objArr[1].intValue());
                } else if (objArr[0] != null && (objArr[0] instanceof Long) && objArr[1] != null && (objArr[1] instanceof Long)) {
                    objArr2[0] = Long.valueOf(objArr[0].longValue() >> ((int) objArr[1].longValue()));
                }
            } else if (objArr[0] != null && (objArr[0] instanceof Integer) && objArr[1] != null && (objArr[1] instanceof Integer)) {
                objArr2[0] = Integer.valueOf(objArr[0].intValue() | objArr[1].intValue());
            } else if (objArr[0] != null && (objArr[0] instanceof Long) && objArr[1] != null && (objArr[1] instanceof Long)) {
                objArr2[0] = Long.valueOf(objArr[0].longValue() | objArr[1].longValue());
            }
        } else if (objArr[0] != null && (objArr[0] instanceof Integer) && objArr[1] != null && (objArr[1] instanceof Integer)) {
            objArr2[0] = Integer.valueOf(objArr[0].intValue() & objArr[1].intValue());
        } else if (objArr[0] != null && (objArr[0] instanceof Long) && objArr[1] != null && (objArr[1] instanceof Long)) {
            objArr2[0] = Long.valueOf(objArr[0].longValue() & objArr[1].longValue());
        }
        return true;
    }
}
