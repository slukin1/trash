package com.huobi.account.entity;

import com.huobi.entity.HomeActivityEntity;
import java.io.Serializable;
import java.util.List;

public class HomeActivityEntityResponse implements Serializable {
    private static final long serialVersionUID = 7062027135907769936L;
    public List<HomeActivityEntity> adList;
    public int showSize;
}
