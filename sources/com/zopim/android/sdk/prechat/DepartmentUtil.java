package com.zopim.android.sdk.prechat;

import com.zopim.android.sdk.model.Department;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mz.f;

final class DepartmentUtil {
    public static List<String> findAvailableDepartments(Collection<Department> collection) {
        ArrayList arrayList = new ArrayList();
        for (Department next : collection) {
            if (Department.Status.ONLINE.equals(next.getStatus()) || Department.Status.AWAY.equals(next.getStatus())) {
                arrayList.add(next.getName());
            }
        }
        return arrayList;
    }

    public static Department findDepartment(Collection<Department> collection, String str) {
        Department department = new Department();
        for (Department next : collection) {
            if (!f.e(next.getName()) && next.getName().equals(str)) {
                return next;
            }
        }
        return department;
    }
}
