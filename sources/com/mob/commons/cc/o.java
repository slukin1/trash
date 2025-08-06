package com.mob.commons.cc;

import com.mob.commons.s;
import com.mob.tools.utils.h;
import fv.g;

public class o implements t<o> {
    public boolean a(o oVar, Class<o> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (objArr == null) {
            return false;
        }
        if (s.a("002jHfi").equals(str)) {
            if (objArr.length == 2) {
                h.a().a(objArr[0], objArr[1]);
            } else if (objArr.length == 3) {
                h.a().a(objArr[0], objArr[1], objArr[2].longValue());
            }
        } else if ("pbl".equals(str)) {
            if (objArr.length == 2) {
                h.a().a(objArr[0], objArr[1]);
            } else if (objArr.length == 3) {
                h.a().a(objArr[0], objArr[1], objArr[2].longValue());
            }
        } else if (s.a("002jg").equals(str)) {
            if (objArr.length == 2) {
                h.a().a(objArr[0], objArr[1]);
            } else if (objArr.length == 3) {
                h.a().a(objArr[0], objArr[1], objArr[2].longValue());
            }
        } else if ("pin".equals(str)) {
            if (objArr.length == 2) {
                h.a().a(objArr[0], objArr[1]);
            } else if (objArr.length == 3) {
                h.a().a(objArr[0], objArr[1], objArr[2].longValue());
            }
        } else if ("pdou".equals(str)) {
            if (objArr.length == 2) {
                h.a().a(objArr[0], objArr[1]);
            } else if (objArr.length == 3) {
                h.a().a(objArr[0], objArr[1], objArr[2].longValue());
            }
        } else if ("pparm".equals(str)) {
            if (objArr.length == 2) {
                h.a().a(objArr[0], objArr[1]);
            } else if (objArr.length == 3) {
                h.a().a(objArr[0], objArr[1], objArr[2].longValue());
            }
        } else if ("ppar".equals(str)) {
            if (objArr.length == 2) {
                h.a().a(objArr[0], objArr[1]);
            } else if (objArr.length == 3) {
                h.a().a(objArr[0], objArr[1], objArr[2].longValue());
            }
        } else if ("pparl".equals(str)) {
            if (objArr.length == 2) {
                h.a().a(objArr[0], objArr[1]);
            } else if (objArr.length == 3) {
                h.a().a(objArr[0], objArr[1], objArr[2].longValue());
            }
        } else if ("ppararr".equals(str)) {
            if (objArr.length == 2) {
                h.a().a(objArr[0], (T[]) objArr[1]);
            } else if (objArr.length == 3) {
                h.a().a(objArr[0], (T[]) objArr[1], objArr[2].longValue());
            }
        } else if (TtmlNode.TAG_P.equals(str)) {
            if (objArr.length == 2) {
                h.a().a(objArr[0], objArr[1]);
            } else if (objArr.length == 3) {
                h.a().a(objArr[0], objArr[1], objArr[2].longValue());
            }
        } else if (g.f22793a.equals(str)) {
            try {
                if (objArr.length == 1) {
                    objArr2[0] = h.a().g(objArr[0]);
                } else if (objArr.length == 2) {
                    objArr2[0] = h.a().b(objArr[0], objArr[1]);
                }
            } catch (Throwable th2) {
                thArr[0] = th2;
            }
        } else if ("gs".equals(str)) {
            try {
                if (objArr.length == 1) {
                    objArr2[0] = h.a().a(objArr[0]);
                } else if (objArr.length == 2) {
                    objArr2[0] = h.a().b(objArr[0], objArr[1]);
                }
            } catch (Throwable th3) {
                thArr[0] = th3;
            }
        } else if ("gbl".equals(str)) {
            try {
                if (objArr.length == 1) {
                    objArr2[0] = Boolean.valueOf(h.a().b(objArr[0]));
                } else if (objArr.length == 2) {
                    objArr2[0] = Boolean.valueOf(h.a().a(objArr[0], objArr[1].booleanValue()));
                }
            } catch (Throwable th4) {
                thArr[0] = th4;
            }
        } else if ("gl".equals(str)) {
            try {
                if (objArr.length == 1) {
                    objArr2[0] = Long.valueOf(h.a().d(objArr[0]));
                } else if (objArr.length == 2) {
                    objArr2[0] = Long.valueOf(h.a().a(objArr[0], objArr[1].longValue()));
                }
            } catch (Throwable th5) {
                thArr[0] = th5;
            }
        } else if ("gin".equals(str)) {
            try {
                if (objArr.length == 1) {
                    objArr2[0] = Integer.valueOf(h.a().e(objArr[0]));
                } else if (objArr.length == 2) {
                    objArr2[0] = Integer.valueOf(h.a().a(objArr[0], objArr[1].intValue()));
                }
            } catch (Throwable th6) {
                thArr[0] = th6;
            }
        } else if ("gdou".equals(str)) {
            try {
                if (objArr.length == 1) {
                    objArr2[0] = Double.valueOf(h.a().f(objArr[0]));
                } else if (objArr.length == 2) {
                    objArr2[0] = Double.valueOf(h.a().a(objArr[0], objArr[1].doubleValue()));
                }
            } catch (Throwable th7) {
                thArr[0] = th7;
            }
        } else if ("gpar".equals(str)) {
            try {
                if (objArr.length == 2) {
                    objArr2[0] = h.a().a(objArr[0], objArr[1]);
                } else if (objArr.length == 3) {
                    objArr2[0] = h.a().a(objArr[0], objArr[1], objArr[2]);
                }
            } catch (Throwable th8) {
                thArr[0] = th8;
            }
        } else if ("gparm".equals(str)) {
            try {
                if (objArr.length == 2) {
                    objArr2[0] = h.a().b(objArr[0], objArr[1]);
                } else if (objArr.length == 3) {
                    objArr2[0] = h.a().a(objArr[0], objArr[1], objArr[2]);
                }
            } catch (Throwable th9) {
                thArr[0] = th9;
            }
        } else if ("gparl".equals(str)) {
            try {
                if (objArr.length == 2) {
                    objArr2[0] = h.a().c(objArr[0], objArr[1]);
                } else if (objArr.length == 3) {
                    objArr2[0] = h.a().a(objArr[0], objArr[1], objArr[2]);
                }
            } catch (Throwable th10) {
                thArr[0] = th10;
            }
        } else if ("gpararr".equals(str)) {
            try {
                if (objArr.length == 2) {
                    objArr2[0] = h.a().d(objArr[0], objArr[1]);
                } else if (objArr.length == 3) {
                    objArr2[0] = h.a().a(objArr[0], objArr[1], (T[]) objArr[2]);
                }
            } catch (Throwable th11) {
                thArr[0] = th11;
            }
        } else if (!"rv".equals(str) || objArr.length != 1) {
            thArr[0] = new IllegalArgumentException("wrp");
        } else {
            h.a().h(objArr[0]);
        }
        return true;
    }
}
