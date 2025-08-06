package cn.sharesdk.loopshare;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.Serializable;
import java.util.HashMap;

public class Scene implements PublicMemberKeeper, Serializable {
    public HashMap<String, Object> params;
    public String path;

    public HashMap<String, Object> getParams() {
        return this.params;
    }

    public String getPath() {
        return this.path;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.params = hashMap;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
