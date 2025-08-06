package y8;

import com.hbg.lib.network.pro.core.bean.SymbolBean;

public final class a {
    public static int a(SymbolBean symbolBean, SymbolBean symbolBean2) {
        Integer num;
        int i11 = 0;
        try {
            num = Integer.valueOf(symbolBean2.getWeight());
            try {
                i11 = Integer.valueOf(symbolBean.getWeight());
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return num.compareTo(i11);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            num = 0;
            e.printStackTrace();
            return num.compareTo(i11);
        }
        return num.compareTo(i11);
    }
}
