package cn.sharesdk.onekeyshare.themes.classic.land;

import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.FriendListPage;
import com.mob.tools.utils.ResHelper;

public class FriendListPageLand extends FriendListPage {
    private static final int DESIGN_SCREEN_WIDTH = 1280;
    private static final int DESIGN_TITLE_HEIGHT = 70;

    public FriendListPageLand(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    public int getDesignTitleHeight() {
        return 70;
    }

    public float getRatio() {
        return ((float) ResHelper.getScreenWidth(this.activity)) / 1280.0f;
    }
}
