package cn.sharesdk.onekeyshare.themes.classic;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.mob.tools.gui.PullToRequestListAdapter;
import com.mob.tools.gui.PullToRequestView;
import com.mob.tools.utils.UIHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FriendAdapter extends PullToRequestListAdapter implements PlatformActionListener {
    /* access modifiers changed from: private */
    public FriendListPage activity;
    /* access modifiers changed from: private */
    public int curPage;
    /* access modifiers changed from: private */
    public ArrayList<Following> follows;
    private boolean hasNext;
    private PRTHeader llHeader;
    private HashMap<String, Boolean> map;
    private final int pageCount = 15;
    private Platform platform;
    private float ratio;

    public static class FollowersResult {
        public boolean hasNextPage;
        public ArrayList<Following> list;

        private FollowersResult() {
            this.hasNextPage = false;
        }
    }

    public static class Following {
        public String atName;
        public boolean checked;
        public String description;
        public String icon;
        public String screenName;
        public String uid;
    }

    public FriendAdapter(FriendListPage friendListPage, PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        this.activity = friendListPage;
        this.curPage = -1;
        this.hasNext = true;
        this.map = new HashMap<>();
        this.follows = new ArrayList<>();
        getListView().setDivider(new ColorDrawable(-1381654));
    }

    private void next() {
        if (this.hasNext) {
            this.platform.listFriend(15, this.curPage + 1, (String) null);
        }
    }

    private FollowersResult parseFollowers(String str, HashMap<String, Object> hashMap, HashMap<String, Boolean> hashMap2) {
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        ArrayList<Following> arrayList = new ArrayList<>();
        boolean z11 = true;
        boolean z12 = false;
        if ("SinaWeibo".equals(str)) {
            Iterator it2 = ((ArrayList) hashMap.get("users")).iterator();
            while (it2.hasNext()) {
                HashMap hashMap3 = (HashMap) it2.next();
                String valueOf = String.valueOf(hashMap3.get("id"));
                if (!hashMap2.containsKey(valueOf)) {
                    Following following = new Following();
                    following.uid = valueOf;
                    following.screenName = String.valueOf(hashMap3.get("name"));
                    following.description = String.valueOf(hashMap3.get("description"));
                    following.icon = String.valueOf(hashMap3.get("profile_image_url"));
                    following.atName = following.screenName;
                    hashMap2.put(following.uid, Boolean.TRUE);
                    arrayList.add(following);
                }
            }
            if (((Integer) hashMap.get("total_number")).intValue() <= hashMap2.size()) {
                z11 = false;
            }
        } else if ("TencentWeibo".equals(str)) {
            if (((Integer) hashMap.get("hasnext")).intValue() != 0) {
                z11 = false;
            }
            Iterator it3 = ((ArrayList) hashMap.get("info")).iterator();
            while (it3.hasNext()) {
                HashMap hashMap4 = (HashMap) it3.next();
                String valueOf2 = String.valueOf(hashMap4.get("name"));
                if (!hashMap2.containsKey(valueOf2)) {
                    Following following2 = new Following();
                    following2.screenName = String.valueOf(hashMap4.get("nick"));
                    following2.uid = valueOf2;
                    following2.atName = valueOf2;
                    Iterator it4 = ((ArrayList) hashMap4.get("tweet")).iterator();
                    if (it4.hasNext()) {
                        following2.description = String.valueOf(((HashMap) it4.next()).get("text"));
                    }
                    following2.icon = String.valueOf(hashMap4.get(TtmlNode.TAG_HEAD)) + "/100";
                    hashMap2.put(following2.uid, Boolean.TRUE);
                    arrayList.add(following2);
                }
            }
        } else {
            if ("Facebook".equals(str)) {
                Iterator it5 = ((ArrayList) hashMap.get("data")).iterator();
                while (it5.hasNext()) {
                    HashMap hashMap5 = (HashMap) it5.next();
                    String valueOf3 = String.valueOf(hashMap5.get("id"));
                    if (!hashMap2.containsKey(valueOf3)) {
                        Following following3 = new Following();
                        following3.uid = valueOf3;
                        following3.atName = "[" + valueOf3 + "]";
                        following3.screenName = String.valueOf(hashMap5.get("name"));
                        HashMap hashMap6 = (HashMap) hashMap5.get("picture");
                        if (hashMap6 != null) {
                            following3.icon = String.valueOf(((HashMap) hashMap6.get("data")).get("url"));
                        }
                        hashMap2.put(following3.uid, Boolean.TRUE);
                        arrayList.add(following3);
                    }
                }
                z12 = ((HashMap) hashMap.get("paging")).containsKey("next");
            } else if ("Twitter".equals(str)) {
                Iterator it6 = ((ArrayList) hashMap.get("users")).iterator();
                while (it6.hasNext()) {
                    HashMap hashMap7 = (HashMap) it6.next();
                    String valueOf4 = String.valueOf(hashMap7.get("screen_name"));
                    if (!hashMap2.containsKey(valueOf4)) {
                        Following following4 = new Following();
                        following4.uid = valueOf4;
                        following4.atName = valueOf4;
                        following4.screenName = String.valueOf(hashMap7.get("name"));
                        following4.description = String.valueOf(hashMap7.get("description"));
                        following4.icon = String.valueOf(hashMap7.get("profile_image_url"));
                        hashMap2.put(following4.uid, Boolean.TRUE);
                        arrayList.add(following4);
                    }
                }
            }
            FollowersResult followersResult = new FollowersResult();
            followersResult.list = arrayList;
            followersResult.hasNextPage = z12;
            return followersResult;
        }
        z12 = z11;
        FollowersResult followersResult2 = new FollowersResult();
        followersResult2.list = arrayList;
        followersResult2.hasNextPage = z12;
        return followersResult2;
    }

    public int getCount() {
        ArrayList<Following> arrayList = this.follows;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public View getFooterView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setMinimumHeight(10);
        return linearLayout;
    }

    public View getHeaderView() {
        if (this.llHeader == null) {
            this.llHeader = new PRTHeader(getContext());
        }
        return this.llHeader;
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new FriendListItem(viewGroup.getContext(), this.ratio);
        }
        ((FriendListItem) view).update(getItem(i11), isFling());
        if (i11 == getCount() - 1) {
            next();
        }
        return view;
    }

    public void onCancel(Platform platform2, int i11) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() {
            public boolean handleMessage(Message message) {
                FriendAdapter.this.activity.finish();
                return false;
            }
        });
    }

    public void onComplete(Platform platform2, int i11, HashMap<String, Object> hashMap) {
        final FollowersResult parseFollowers = parseFollowers(this.platform.getName(), hashMap, this.map);
        if (parseFollowers == null) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                public boolean handleMessage(Message message) {
                    FriendAdapter.this.notifyDataSetChanged();
                    return false;
                }
            });
            return;
        }
        this.hasNext = parseFollowers.hasNextPage;
        ArrayList<Following> arrayList = parseFollowers.list;
        if (arrayList != null && arrayList.size() > 0) {
            this.curPage++;
            Message message = new Message();
            message.what = 1;
            message.obj = parseFollowers.list;
            UIHandler.sendMessage(message, new Handler.Callback() {
                public boolean handleMessage(Message message) {
                    if (FriendAdapter.this.curPage <= 0) {
                        FriendAdapter.this.follows.clear();
                    }
                    FriendAdapter.this.follows.addAll(parseFollowers.list);
                    FriendAdapter.this.notifyDataSetChanged();
                    return false;
                }
            });
        }
    }

    public void onError(Platform platform2, int i11, Throwable th2) {
        th2.printStackTrace();
    }

    public void onPullDown(int i11) {
        this.llHeader.onPullDown(i11);
    }

    public void onRefresh() {
        this.llHeader.onRequest();
        this.curPage = -1;
        this.hasNext = true;
        this.map.clear();
        next();
    }

    public void onReversed() {
        this.llHeader.reverse();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        getListView().setOnItemClickListener(onItemClickListener);
    }

    public void setPlatform(Platform platform2) {
        this.platform = platform2;
        platform2.setPlatformActionListener(this);
    }

    public void setRatio(float f11) {
        this.ratio = f11;
        ListView listView = getListView();
        if (f11 < 1.0f) {
            f11 = 1.0f;
        }
        listView.setDividerHeight((int) f11);
    }

    public Following getItem(int i11) {
        return this.follows.get(i11);
    }
}
