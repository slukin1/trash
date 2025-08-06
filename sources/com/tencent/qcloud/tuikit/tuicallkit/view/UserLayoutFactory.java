package com.tencent.qcloud.tuikit.tuicallkit.view;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qcloud.tuikit.tuicallkit.base.CallingUserModel;
import com.tencent.qcloud.tuikit.tuicallkit.base.UserLayout;
import com.tencent.qcloud.tuikit.tuicallkit.base.UserLayoutEntity;
import java.util.Iterator;
import java.util.LinkedList;

public class UserLayoutFactory {
    private Context mContext;
    public LinkedList<UserLayoutEntity> mLayoutEntityList = new LinkedList<>();

    public UserLayoutFactory(Context context) {
        this.mContext = context;
    }

    public UserLayout allocUserLayout(CallingUserModel callingUserModel) {
        if (callingUserModel == null || TextUtils.isEmpty(callingUserModel.userId)) {
            return null;
        }
        UserLayout findUserLayout = findUserLayout(callingUserModel.userId);
        if (findUserLayout != null) {
            return findUserLayout;
        }
        UserLayoutEntity userLayoutEntity = new UserLayoutEntity();
        userLayoutEntity.userId = callingUserModel.userId;
        userLayoutEntity.userModel = callingUserModel;
        UserLayout userLayout = new UserLayout(this.mContext);
        userLayoutEntity.layout = userLayout;
        userLayout.setVisibility(0);
        this.mLayoutEntityList.add(userLayoutEntity);
        return userLayoutEntity.layout;
    }

    public UserLayout findUserLayout(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator it2 = this.mLayoutEntityList.iterator();
        while (it2.hasNext()) {
            UserLayoutEntity userLayoutEntity = (UserLayoutEntity) it2.next();
            if (str.equals(userLayoutEntity.userId)) {
                return userLayoutEntity.layout;
            }
        }
        return null;
    }
}
