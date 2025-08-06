package pj;

import com.huobi.dynamiclangs.data.DynamicStringsBean;
import com.huobi.dynamiclangs.db.DynamicStringsBeanDao;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class a extends AbstractDaoSession {

    /* renamed from: a  reason: collision with root package name */
    public final DaoConfig f47717a;

    /* renamed from: b  reason: collision with root package name */
    public final DynamicStringsBeanDao f47718b;

    public a(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        DaoConfig clone = map.get(DynamicStringsBeanDao.class).clone();
        this.f47717a = clone;
        clone.initIdentityScope(identityScopeType);
        DynamicStringsBeanDao dynamicStringsBeanDao = new DynamicStringsBeanDao(clone, this);
        this.f47718b = dynamicStringsBeanDao;
        registerDao(DynamicStringsBean.class, dynamicStringsBeanDao);
    }
}
