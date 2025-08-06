package com.huobi.finance.bean;

import com.hbg.lib.network.pro.core.bean.ProjectItem;
import com.huobi.finance.viewhandler.ProjectItemViewHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import s9.a;

public class ProjectListItem implements Serializable, a {
    private ProjectItem data;

    public ProjectListItem(ProjectItem projectItem) {
        this.data = projectItem;
    }

    public static List<ProjectListItem> buildList(List<ProjectItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (ProjectItem next : list) {
            if (arrayList.size() < 200) {
                arrayList.add(new ProjectListItem(next));
            }
        }
        return arrayList;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ProjectListItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProjectListItem)) {
            return false;
        }
        ProjectListItem projectListItem = (ProjectListItem) obj;
        if (!projectListItem.canEqual(this)) {
            return false;
        }
        ProjectItem data2 = getData();
        ProjectItem data3 = projectListItem.getData();
        return data2 != null ? data2.equals(data3) : data3 == null;
    }

    public ProjectItem getData() {
        return this.data;
    }

    public String getViewHandlerName() {
        return ProjectItemViewHandler.class.getName();
    }

    public int hashCode() {
        ProjectItem data2 = getData();
        return 59 + (data2 == null ? 43 : data2.hashCode());
    }

    public void setData(ProjectItem projectItem) {
        this.data = projectItem;
    }

    public String toString() {
        return "ProjectListItem(data=" + getData() + ")";
    }
}
