package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.hbg.core.bean.LiveHotTalkItemData;
import java.util.List;

public class LiveSpeaker extends LiveSquareBaseData {
    public String avatar;
    public int focusStatus;
    public String groupId;
    public int hasJion;
    public String introduction;
    public String nickname;
    public String showId;
    public String title;
    public int type;
    public String uidUnique;
    public int userCount;
    public List<LiveHotTalkItemData.UserInfo> userList;
}
