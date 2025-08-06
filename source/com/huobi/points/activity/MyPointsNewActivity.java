package com.huobi.points.activity;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/point/index")
public class MyPointsNewActivity extends AbsPointsNewActivity {
    public String Nh() {
        return "point";
    }
}
