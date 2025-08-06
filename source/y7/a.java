package y7;

import com.hbg.lib.network.hbg.core.bean.C2CSymbolBean;
import com.hbg.lib.network.hbg.db.C2CSymbolBeanDao;
import com.hbg.lib.network.hbg.db.GridSymbolsConfigDao;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class a extends AbstractDaoSession {

    /* renamed from: a  reason: collision with root package name */
    public final DaoConfig f70555a;

    /* renamed from: b  reason: collision with root package name */
    public final DaoConfig f70556b;

    /* renamed from: c  reason: collision with root package name */
    public final C2CSymbolBeanDao f70557c;

    /* renamed from: d  reason: collision with root package name */
    public final GridSymbolsConfigDao f70558d;

    public a(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        DaoConfig clone = map.get(C2CSymbolBeanDao.class).clone();
        this.f70555a = clone;
        clone.initIdentityScope(identityScopeType);
        DaoConfig clone2 = map.get(GridSymbolsConfigDao.class).clone();
        this.f70556b = clone2;
        clone2.initIdentityScope(identityScopeType);
        C2CSymbolBeanDao c2CSymbolBeanDao = new C2CSymbolBeanDao(clone, this);
        this.f70557c = c2CSymbolBeanDao;
        GridSymbolsConfigDao gridSymbolsConfigDao = new GridSymbolsConfigDao(clone2, this);
        this.f70558d = gridSymbolsConfigDao;
        registerDao(C2CSymbolBean.class, c2CSymbolBeanDao);
        registerDao(GridSymbolsConfig.class, gridSymbolsConfigDao);
    }

    public GridSymbolsConfigDao a() {
        return this.f70558d;
    }
}
