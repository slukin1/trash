package com.huobi.woodpecker.model;

import com.facebook.places.model.PlaceFields;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.base.BaseRecord;
import com.huobi.woodpecker.model.base.IRecord;
import com.huobi.woodpecker.utils.RecordUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class AppNewBehaviorRecord extends BaseRecord<BaseBehavior> {

    public static class BackgroundBehavior extends BaseBehavior {
        public BackgroundBehavior() {
            super("event.background");
        }
    }

    public static abstract class BaseBehavior implements IRecord {
        public String event;

        public BaseBehavior(String str) {
            this.event = str;
        }

        public AppNewBehaviorRecord create() {
            AppNewBehaviorRecord appNewBehaviorRecord = new AppNewBehaviorRecord();
            appNewBehaviorRecord.setData(this);
            RecordUtil.a(appNewBehaviorRecord);
            return appNewBehaviorRecord;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", this.event);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        public String toJsonString() {
            return toJsonObject().toString();
        }
    }

    public static class BlockUiBehavior extends BaseBehavior {
        private final long time;

        public BlockUiBehavior(long j11) {
            super("event.block.ui");
            this.time = j11;
        }

        public JSONObject toJsonObject() {
            JSONObject jsonObject = super.toJsonObject();
            try {
                jsonObject.put(CrashHianalyticsData.TIME, this.time);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            return jsonObject;
        }
    }

    public static class ClickBehavior extends PathBehavior {
        public ClickBehavior(String str) {
            super("event.click", str);
        }
    }

    public static class CrashExitBehavior extends BaseBehavior {
        public CrashExitBehavior() {
            super("event.crash");
        }
    }

    public static class ForegroundBehavior extends BaseBehavior {
        public ForegroundBehavior() {
            super("event.foreground");
        }
    }

    public static abstract class PageBehavior extends BaseBehavior {
        private final String page;

        public PageBehavior(String str, String str2) {
            super(str);
            this.page = str2;
        }

        public JSONObject toJsonObject() {
            JSONObject jsonObject = super.toJsonObject();
            try {
                jsonObject.put(PlaceFields.PAGE, this.page);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            return jsonObject;
        }
    }

    public static class PageEnterBehavior extends PageBehavior {
        public PageEnterBehavior(String str) {
            super("event.page.enter", str);
        }
    }

    public static class PageExitBehavior extends PageBehavior {
        public PageExitBehavior(String str) {
            super("event.page.exit", str);
        }
    }

    public static abstract class PathBehavior extends BaseBehavior {
        private final String path;

        public PathBehavior(String str, String str2) {
            super(str);
            this.path = str2;
        }

        public JSONObject toJsonObject() {
            JSONObject jsonObject = super.toJsonObject();
            try {
                jsonObject.put("path", this.path);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            return jsonObject;
        }
    }

    public static class ScrollEnterBehavior extends PathBehavior {
        public ScrollEnterBehavior(String str) {
            super("event.scroll.enter", str);
        }
    }

    public static class ScrollExitBehavior extends PathBehavior {
        public ScrollExitBehavior(String str) {
            super("event.scroll.exit", str);
        }
    }

    public AppNewBehaviorRecord() {
        setAction(ActionType.APP_CUSTOM_EVENT);
    }
}
