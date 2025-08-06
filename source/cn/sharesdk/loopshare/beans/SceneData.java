package cn.sharesdk.loopshare.beans;

import cn.sharesdk.loopshare.Scene;
import com.mob.tools.proguard.PrivateMemberKeeper;
import java.util.HashMap;

public class SceneData extends ServerData {
    private Res res;

    public static class Res extends Scene implements PrivateMemberKeeper {
        private String action;
        private HashMap<String, Object> browser;
        private String link;

        public String getAction() {
            return this.action;
        }

        public String getLink() {
            return this.link;
        }
    }

    public Res a() {
        return this.res;
    }

    public boolean a_() {
        boolean a_ = super.a_();
        if (!a_) {
            return a_;
        }
        Res a11 = a();
        return (a11 == null || a11.getPath() == null) ? false : true;
    }
}
