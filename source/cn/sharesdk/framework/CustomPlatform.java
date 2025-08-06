package cn.sharesdk.framework;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.a.b.f;
import java.util.HashMap;

public abstract class CustomPlatform extends Platform {
    public abstract boolean checkAuthorize(int i11, Object obj);

    public void doAuthorize(String[] strArr) {
    }

    public void doCustomerProtocol(String str, String str2, int i11, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
    }

    public void doShare(Platform.ShareParams shareParams) {
    }

    public HashMap<String, Object> filterFriendshipInfo(int i11, HashMap<String, Object> hashMap) {
        return null;
    }

    public final f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        return null;
    }

    public void follow(String str) {
    }

    public HashMap<String, Object> getBilaterals(int i11, int i12, String str) {
        return null;
    }

    public int getCustomPlatformId() {
        return 1;
    }

    public HashMap<String, Object> getFollowers(int i11, int i12, String str) {
        return null;
    }

    public HashMap<String, Object> getFollowings(int i11, int i12, String str) {
        return null;
    }

    public void getFriendList(int i11, int i12, String str) {
    }

    public abstract String getName();

    public final int getPlatformId() {
        return -Math.abs(getCustomPlatformId());
    }

    public int getVersion() {
        return 0;
    }

    public boolean hasShareCallback() {
        return false;
    }

    public final void initDevInfo(String str) {
    }

    public final void setNetworkDevinfo() {
    }

    public void timeline(int i11, int i12, String str) {
    }

    public void userInfor(String str) {
    }
}
