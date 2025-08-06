package com.xiaomi.clientreport.data;

import com.xiaomi.channel.commonutils.logger.b;
import org.json.JSONException;
import org.json.JSONObject;

public class PerfClientReport extends a {
    private static final long DEFAULT_VALUE = -1;
    public int code;
    public long perfCounts = -1;
    public long perfLatencies = -1;

    public static PerfClientReport getBlankInstance() {
        return new PerfClientReport();
    }

    public JSONObject toJson() {
        try {
            JSONObject json = super.toJson();
            if (json == null) {
                return null;
            }
            json.put("code", this.code);
            json.put("perfCounts", this.perfCounts);
            json.put("perfLatencies", this.perfLatencies);
            return json;
        } catch (JSONException e11) {
            b.a((Throwable) e11);
            return null;
        }
    }

    public String toJsonString() {
        return super.toJsonString();
    }
}
