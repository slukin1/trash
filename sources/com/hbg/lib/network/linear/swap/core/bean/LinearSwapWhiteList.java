package com.hbg.lib.network.linear.swap.core.bean;

import java.io.Serializable;

public class LinearSwapWhiteList implements Serializable {
    private boolean is_hit;
    private String scene;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapWhiteList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapWhiteList)) {
            return false;
        }
        LinearSwapWhiteList linearSwapWhiteList = (LinearSwapWhiteList) obj;
        if (!linearSwapWhiteList.canEqual(this) || is_hit() != linearSwapWhiteList.is_hit()) {
            return false;
        }
        String scene2 = getScene();
        String scene3 = linearSwapWhiteList.getScene();
        return scene2 != null ? scene2.equals(scene3) : scene3 == null;
    }

    public String getScene() {
        return this.scene;
    }

    public int hashCode() {
        int i11 = is_hit() ? 79 : 97;
        String scene2 = getScene();
        return ((i11 + 59) * 59) + (scene2 == null ? 43 : scene2.hashCode());
    }

    public boolean is_hit() {
        return this.is_hit;
    }

    public void setScene(String str) {
        this.scene = str;
    }

    public void set_hit(boolean z11) {
        this.is_hit = z11;
    }

    public String toString() {
        return "LinearSwapWhiteList(is_hit=" + is_hit() + ", scene=" + getScene() + ")";
    }
}
