package com.huobi.feature.util;

import a7.b;
import a7.e;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.feature.bean.FutureTpSlDialogShowBean;
import ej.f;
import i6.d;
import i6.m;
import java.math.BigDecimal;
import us.i;

public class FutureTpSlFuturesHelper {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f45106a;

        /* renamed from: b  reason: collision with root package name */
        public BigDecimal f45107b;

        /* renamed from: c  reason: collision with root package name */
        public String f45108c;

        public a(String str, BigDecimal bigDecimal) {
            this.f45106a = str;
            this.f45107b = bigDecimal;
        }

        public String a() {
            return this.f45108c;
        }

        public void b(String str) {
            this.f45108c = str;
        }
    }

    public static String a(Editable editable) {
        String obj = editable.toString();
        if (obj.lastIndexOf(InstructionFileId.DOT) >= 0) {
            return obj.substring(0, obj.lastIndexOf(InstructionFileId.DOT));
        }
        if (editable.length() <= 0) {
            return null;
        }
        if (obj.startsWith("0")) {
            return "";
        }
        if (Integer.parseInt(obj) > 100) {
            return "100";
        }
        return null;
    }

    public static boolean b(EditText editText, Editable editable, String str, String str2, boolean z11) {
        String str3;
        if (z11) {
            str3 = a(editable);
        } else if (e.E(TradeType.CONTRACT)) {
            str3 = m.b(editable, 10, f.n(str));
        } else if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
            str3 = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
        } else {
            str3 = m.b(editable, 10, f.g(str2));
        }
        if (str3 == null) {
            return false;
        }
        editText.setText(str3);
        editText.setSelection(editText.getText().length());
        return true;
    }

    public static boolean c(EditText editText, Editable editable, String str, String str2, boolean z11) {
        String str3;
        if (z11) {
            str3 = a(editable);
        } else if (e.E(TradeType.LINEAR_SWAP)) {
            str3 = m.b(editable, 10, FuturePrecisionUtil.s(str, str2, (String) null));
        } else if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
            str3 = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
        } else {
            str3 = m.b(editable, 10, FuturePrecisionUtil.s(str, str2, (String) null));
        }
        if (str3 == null) {
            return false;
        }
        editText.setText(str3);
        editText.setSelection(editText.getText().length());
        return true;
    }

    public static boolean d(EditText editText, Editable editable, String str, boolean z11) {
        String str2;
        if (z11) {
            str2 = a(editable);
        } else if (e.E(TradeType.SWAP)) {
            str2 = m.b(editable, 10, i.k(str));
        } else if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
            str2 = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
        } else {
            str2 = m.b(editable, 10, i.k(str));
        }
        if (str2 == null) {
            return false;
        }
        editText.setText(str2);
        editText.setSelection(editText.getText().length());
        return true;
    }

    public static String e(String str, String str2, String str3, String str4, boolean z11, String str5, BigDecimal bigDecimal) {
        BigDecimal bigDecimal2;
        try {
            BigDecimal bigDecimal3 = new BigDecimal(str);
            if (bigDecimal == null) {
                bigDecimal = BigDecimal.ZERO;
            }
            BigDecimal multiply = bigDecimal.multiply(new BigDecimal(str2));
            BigDecimal bigDecimal4 = new BigDecimal(str4);
            BigDecimal bigDecimal5 = new BigDecimal(str3);
            if (z11) {
                bigDecimal2 = BigDecimal.ONE.divide(bigDecimal4, 32, 1).subtract(BigDecimal.ONE.divide(bigDecimal3, 32, 1)).multiply(bigDecimal5).multiply(multiply);
            } else {
                bigDecimal2 = BigDecimal.ONE.divide(bigDecimal3, 32, 1).subtract(BigDecimal.ONE.divide(bigDecimal4, 32, 1)).multiply(bigDecimal5).multiply(multiply);
            }
            return m.m(bigDecimal2.toPlainString(), i.p(str5));
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "--";
        }
    }

    public static String f(String str, String str2, String str3, String str4, boolean z11, BigDecimal bigDecimal) {
        BigDecimal bigDecimal2;
        try {
            BigDecimal bigDecimal3 = new BigDecimal(str);
            if (bigDecimal == null) {
                bigDecimal = BigDecimal.ZERO;
            }
            BigDecimal multiply = bigDecimal.multiply(new BigDecimal(str2));
            BigDecimal bigDecimal4 = new BigDecimal(str4);
            BigDecimal bigDecimal5 = new BigDecimal(str3);
            if (z11) {
                bigDecimal2 = bigDecimal3.subtract(bigDecimal4).multiply(multiply).multiply(bigDecimal5);
            } else {
                bigDecimal2 = bigDecimal4.subtract(bigDecimal3).multiply(multiply).multiply(bigDecimal5);
            }
            return m.m(bigDecimal2.toPlainString(), 4);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "--";
        }
    }

    public static a g(TradeType tradeType, String str, BigDecimal bigDecimal, String str2, BigDecimal bigDecimal2, String str3, int i11) {
        BigDecimal bigDecimal3;
        String str4;
        if (bigDecimal2 == null || bigDecimal2.compareTo(BigDecimal.ZERO) == 0 || bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            return new a(AppUtil.b(bigDecimal2, "%"), BigDecimal.ZERO);
        }
        boolean E = e.E(tradeType);
        boolean G = e.G(tradeType);
        BigDecimal divide = bigDecimal.multiply(bigDecimal2).divide(m.f68179a, 32, 1);
        if (divide.compareTo(BigDecimal.ONE) <= 0) {
            bigDecimal3 = BigDecimal.ONE;
        } else {
            bigDecimal3 = divide.setScale(0, 1);
        }
        if (E) {
            str4 = m.a(FutureUnitUtil.d(bigDecimal3.toPlainString(), str3, str, tradeType)).setScale(i11, 1).toPlainString();
        } else if (G) {
            str4 = m.m(FutureUnitUtil.d(bigDecimal3.toPlainString(), str3, str, TradeType.LINEAR_SWAP), FuturePrecisionUtil.g(str2));
        } else {
            str4 = bigDecimal3.toPlainString();
        }
        if (TextUtils.isEmpty(str4) || m.a(str4).compareTo(BigDecimal.ZERO) == 0) {
            return new a(AppUtil.b(bigDecimal2.toPlainString(), "%"), BigDecimal.ZERO);
        }
        try {
            a aVar = new a(AppUtil.b(bigDecimal2.toPlainString(), "%(≈ ", str4, ")"), bigDecimal3.divide(bigDecimal, 32, 0));
            aVar.b(str4);
            return aVar;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new a(AppUtil.b(bigDecimal2.toPlainString(), "%"), BigDecimal.ZERO);
        }
    }

    public static BigDecimal h(BigDecimal bigDecimal, BigDecimal bigDecimal2, boolean z11, BigDecimal bigDecimal3, BigDecimal bigDecimal4, TradeType tradeType) {
        if (bigDecimal4 == null) {
            return null;
        }
        if (tradeType == TradeType.LINEAR_SWAP) {
            if (z11) {
                return bigDecimal4.divide(bigDecimal2.multiply(bigDecimal), 32, 1).add(bigDecimal3);
            }
            return bigDecimal3.subtract(bigDecimal4.divide(bigDecimal2.multiply(bigDecimal), 32, 1));
        } else if (m.c0(bigDecimal3) || m.c0(bigDecimal4)) {
            return null;
        } else {
            if (z11) {
                return bigDecimal.divide(bigDecimal.divide(bigDecimal3, 32, 1).subtract(bigDecimal4.divide(bigDecimal2, 32, 1)), 32, 1);
            }
            return bigDecimal.divide(bigDecimal.divide(bigDecimal3, 32, 1).add(bigDecimal4.divide(bigDecimal2, 32, 1)), 32, 1);
        }
    }

    public static BigDecimal i(FutureTpSlDialogShowBean futureTpSlDialogShowBean, boolean z11, BigDecimal bigDecimal, int i11, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        if (i11 == 1) {
            if (bigDecimal2 == null) {
                return null;
            }
            if (futureTpSlDialogShowBean.isLinearSwap()) {
                if (z11) {
                    return bigDecimal2.subtract(bigDecimal).multiply(futureTpSlDialogShowBean.getContractFace()).multiply(BigDecimal.valueOf(futureTpSlDialogShowBean.getContVolume().longValue()));
                }
                return bigDecimal.subtract(bigDecimal2).multiply(futureTpSlDialogShowBean.getContractFace()).multiply(BigDecimal.valueOf(futureTpSlDialogShowBean.getContVolume().longValue()));
            } else if (m.c0(bigDecimal) || m.c0(bigDecimal2)) {
                return null;
            } else {
                if (z11) {
                    return futureTpSlDialogShowBean.getContractFace().divide(bigDecimal, 32, 1).subtract(futureTpSlDialogShowBean.getContractFace().divide(bigDecimal2, 32, 1)).multiply(BigDecimal.valueOf(futureTpSlDialogShowBean.getContVolume().longValue()));
                }
                return futureTpSlDialogShowBean.getContractFace().divide(bigDecimal2, 32, 1).subtract(futureTpSlDialogShowBean.getContractFace().divide(bigDecimal, 32, 1)).multiply(BigDecimal.valueOf(futureTpSlDialogShowBean.getContVolume().longValue()));
            }
        } else if (bigDecimal3 == null) {
            return null;
        } else {
            if (futureTpSlDialogShowBean.isLinearSwap()) {
                if (z11) {
                    return bigDecimal3.subtract(bigDecimal).multiply(futureTpSlDialogShowBean.getContractFace()).multiply(BigDecimal.valueOf(futureTpSlDialogShowBean.getContVolume().longValue()));
                }
                return bigDecimal.subtract(bigDecimal3).multiply(futureTpSlDialogShowBean.getContractFace()).multiply(BigDecimal.valueOf(futureTpSlDialogShowBean.getContVolume().longValue()));
            } else if (m.c0(bigDecimal) || m.c0(bigDecimal3)) {
                return null;
            } else {
                if (z11) {
                    return futureTpSlDialogShowBean.getContractFace().divide(bigDecimal, 32, 1).subtract(futureTpSlDialogShowBean.getContractFace().divide(bigDecimal3, 32, 1)).multiply(BigDecimal.valueOf(futureTpSlDialogShowBean.getContVolume().longValue()));
                }
                return futureTpSlDialogShowBean.getContractFace().divide(bigDecimal3, 32, 1).subtract(futureTpSlDialogShowBean.getContractFace().divide(bigDecimal, 32, 1)).multiply(BigDecimal.valueOf(futureTpSlDialogShowBean.getContVolume().longValue()));
            }
        }
    }

    public static String j(String str, int i11, String str2, String str3, boolean z11, boolean z12, TradeType tradeType) {
        String str4;
        if (z11) {
            str4 = b.b(str2, str, str3, "", tradeType);
        } else {
            str4 = b.d(str2, str, str3, "", tradeType);
        }
        String m11 = m.m(str4, i11);
        d.b("rateToPrice--> 输入：" + str + " 最新价：" + str2 + " 杠杆倍数：" + str3 + " 转成触发价：" + m11);
        return m11;
    }

    public static BigDecimal k(String str, int i11, String str2, boolean z11, boolean z12) {
        BigDecimal a11 = m.a(str2);
        BigDecimal divide = m.a(str).divide(m.a("100"), 32, 1);
        BigDecimal multiply = (z11 ? BigDecimal.ONE.add(divide) : BigDecimal.ONE.subtract(divide)).multiply(a11);
        if (multiply.compareTo(BigDecimal.ZERO) < 0) {
            multiply = BigDecimal.ZERO;
        }
        BigDecimal scale = multiply.setScale(i11, 1);
        d.b("risefallToPrice--> 输入：" + str + " 开仓价：" + str2 + " 转成触发价：" + scale.toPlainString());
        return scale;
    }
}
