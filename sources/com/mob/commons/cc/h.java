package com.mob.commons.cc;

import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.mob.commons.C0891r;

public class h implements t<g> {
    public boolean a(g gVar, Class<g> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (ChainInfo.CHAIN_TYPE_NEW.equals(str) && objArr.length == 2) {
            objArr2[0] = new g(objArr[0], objArr[1].intValue());
        } else if (C0891r.b("009i5cf0hYdk$h;cich;dXdi").equals(str) && objArr.length == 2) {
            gVar.a(objArr[0], objArr[1]);
        } else if (C0891r.b("009?di+ehUdk(h cichWdWdi").equals(str) && objArr.length == 2) {
            objArr2[0] = gVar.b(objArr[0], objArr[1]);
        } else if (C0891r.b("010iMcf1hFeicjcjSfecd").equals(str) && objArr.length == 2 && (objArr[1] instanceof Boolean)) {
            gVar.a(objArr[0], objArr[1].booleanValue());
        } else if (C0891r.b("0105di=ehVeicjcj,fecd").equals(str) && objArr.length == 2 && (objArr[1] instanceof Boolean)) {
            objArr2[0] = Boolean.valueOf(gVar.b(objArr[0], objArr[1].booleanValue()));
        } else if (C0891r.b("007iFcfKhOedcjOd_di").equals(str) && objArr.length == 2 && (objArr[1] instanceof Long)) {
            gVar.a(objArr[0], objArr[1].longValue());
        } else if (C0891r.b("0071di:eh<edcjOd_di").equals(str) && objArr.length == 2 && (objArr[1] instanceof Long)) {
            objArr2[0] = Long.valueOf(gVar.b(objArr[0], objArr[1].longValue()));
        } else if (C0891r.b("006i9cfQh1ddHdh").equals(str) && objArr.length == 2 && (objArr[1] instanceof Integer)) {
            gVar.a(objArr[0], objArr[1].intValue());
        } else if (C0891r.b("006^diLehSddWdh").equals(str) && objArr.length == 2) {
            objArr2[0] = Integer.valueOf(gVar.b(objArr[0], objArr[1].intValue()));
        } else if (C0891r.b("006iQcf?h$fgeegf").equals(str) && objArr.length == 2) {
            gVar.a(objArr[0], objArr[1]);
        } else if (!C0891r.b("006*di5ehWfgeegf").equals(str) || objArr.length != 1) {
            return false;
        } else {
            objArr2[0] = gVar.a(objArr[0]);
        }
        return true;
    }
}
