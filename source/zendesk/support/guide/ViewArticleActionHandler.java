package zendesk.support.guide;

import android.content.Context;
import com.google.gson.JsonElement;
import com.zendesk.logger.Logger;
import h30.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mz.f;
import okhttp3.HttpUrl;
import zendesk.configurations.Configuration;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;

class ViewArticleActionHandler implements ActionHandler {
    private static final String HC_PATH_ELEMENT_ARTICLE = "articles";
    private static final String HC_PATH_ELEMENT_HC = "hc";
    private static final String HC_PATH_ELEMENT_NAME_SEPARATOR = "-";
    private static final String HELP_CENTER_ARTICLE_ID = "help_center_article_id";
    private static final String HELP_CENTER_ARTICLE_TITLE = "help_center_article_title";
    public static final String HELP_CENTER_VIEW_ARTICLE = "help_center_view_article";
    private static final String LOG_TAG = "ViewArticleActionHandle";

    public static class ActionPayload {
        private final String action;
        /* access modifiers changed from: private */
        public final Map<String, Object> payload;

        private ActionPayload(String str, Map<String, Object> map) {
            this.action = str;
            this.payload = map;
        }

        public static ActionPayload invalid(String str) {
            return new ActionPayload(str, (Map<String, Object>) null);
        }

        public static ActionPayload valid(String str, Map<String, Object> map) {
            return new ActionPayload(str, map);
        }

        public String getAction() {
            return this.action;
        }

        public Map<String, Object> getPayload() {
            return this.payload;
        }

        public boolean isValid() {
            return f.c(this.action) && this.payload != null;
        }
    }

    public static Map<String, Object> data(long j11, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(HELP_CENTER_ARTICLE_ID, Long.valueOf(j11));
        hashMap.put(HELP_CENTER_ARTICLE_TITLE, str);
        return hashMap;
    }

    public boolean canHandle(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (parse == null) {
            return false;
        }
        return parse(parse).isValid();
    }

    public ActionDescription getActionDescription() {
        return null;
    }

    public int getPriority() {
        return 0;
    }

    public void handle(Map<String, Object> map, Context context) {
        HttpUrl parse;
        List<Configuration> list;
        if (map == null) {
            Logger.l(LOG_TAG, "Property map is null, cannot open article.", new Object[0]);
            return;
        }
        String str = (String) map.get(HELP_CENTER_VIEW_ARTICLE);
        if (!f.e(str) && (parse = HttpUrl.parse(str)) != null) {
            ActionPayload parse2 = parse(parse);
            if (parse2.isValid() && parse2.payload.containsKey(HELP_CENTER_ARTICLE_ID)) {
                long longValue = ((Long) parse2.payload.get(HELP_CENTER_ARTICLE_ID)).longValue();
                Configuration f11 = a.f(map, Configuration.class);
                if (f11 != null) {
                    list = f11.getConfigurations();
                } else {
                    list = Collections.emptyList();
                }
                ViewArticleActivity.builder(longValue).show(context, list);
            }
        }
    }

    public ActionPayload parse(HttpUrl httpUrl) {
        String str;
        List<String> pathSegments = httpUrl.pathSegments();
        if (pathSegments.size() < 3 || pathSegments.size() > 4) {
            return ActionPayload.invalid(HELP_CENTER_VIEW_ARTICLE);
        }
        int indexOf = pathSegments.indexOf(HC_PATH_ELEMENT_ARTICLE);
        if (HC_PATH_ELEMENT_HC.equals(pathSegments.get(0))) {
            if (indexOf == 1 || indexOf == 2) {
                if (indexOf + 2 != pathSegments.size()) {
                    return ActionPayload.invalid(HELP_CENTER_VIEW_ARTICLE);
                }
                String str2 = pathSegments.get(indexOf + 1);
                String[] split = str2.split("-");
                if (mz.a.h(split)) {
                    return ActionPayload.invalid(HELP_CENTER_VIEW_ARTICLE);
                }
                try {
                    Long valueOf = Long.valueOf(Long.parseLong(split[0]));
                    StringBuilder sb2 = new StringBuilder(str2.length());
                    if (split.length > 1) {
                        int length = split.length;
                        for (int i11 = 1; i11 < length; i11++) {
                            sb2.append(split[i11]);
                            sb2.append(' ');
                        }
                        str = sb2.toString().trim();
                    } else {
                        str = "";
                    }
                    return ActionPayload.valid(HELP_CENTER_VIEW_ARTICLE, data(valueOf.longValue(), str));
                } catch (NumberFormatException unused) {
                    return ActionPayload.invalid(HELP_CENTER_VIEW_ARTICLE);
                }
            }
        }
        return ActionPayload.invalid(HELP_CENTER_VIEW_ARTICLE);
    }

    public void updateSettings(Map<String, JsonElement> map) {
    }
}
