package p5;

import com.hbg.component.kline.db.KlineDrawLineBeanDao;
import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class a extends AbstractDaoSession {

    /* renamed from: a  reason: collision with root package name */
    public final DaoConfig f68295a;

    /* renamed from: b  reason: collision with root package name */
    public final KlineDrawLineBeanDao f68296b;

    public a(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        DaoConfig clone = map.get(KlineDrawLineBeanDao.class).clone();
        this.f68295a = clone;
        clone.initIdentityScope(identityScopeType);
        KlineDrawLineBeanDao klineDrawLineBeanDao = new KlineDrawLineBeanDao(clone, this);
        this.f68296b = klineDrawLineBeanDao;
        registerDao(KlineDrawLineBean.class, klineDrawLineBeanDao);
    }
}
