package cn.sharesdk.onekeyshare.themes.classic.port;

import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.FriendListPage;
import com.mob.tools.utils.ResHelper;

public class FriendListPagePort extends FriendListPage {
    private static final int DESIGN_SCREEN_WIDTH = 720;
    private static final int DESIGN_TITLE_HEIGHT = 96;

    public FriendListPagePort(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    public int getDesignTitleHeight() {
        return 96;
    }

    public float getRatio() {
        return ((float) ResHelper.getScreenWidth(this.activity)) / 720.0f;
    }
}
