package zendesk.core;

import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mz.f;

public class ZendeskLocaleConverter {
    private static final Map<String, String> forwardLookupMap;

    static {
        HashMap hashMap = new HashMap();
        forwardLookupMap = hashMap;
        hashMap.put("iw", "he");
        hashMap.put("nb", "no");
        hashMap.put("in", "id");
        hashMap.put("ji", "yi");
    }

    public String toHelpCenterLocaleString(Locale locale) {
        if (!(locale != null && f.c(locale.getLanguage()))) {
            locale = Locale.getDefault();
        }
        String str = forwardLookupMap.get(locale.getLanguage());
        if (!f.c(str)) {
            str = locale.getLanguage();
        }
        StringBuilder sb2 = new StringBuilder(str);
        if (f.c(locale.getCountry())) {
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb2.append(locale.getCountry());
        }
        return sb2.toString().toLowerCase();
    }
}
