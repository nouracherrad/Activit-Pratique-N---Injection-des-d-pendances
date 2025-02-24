package ext;

import Dao.IDao;
import org.springframework.stereotype.Component;

import Dao.IDao;
@Component("dao2")
public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("version web service");
        double t=11;
        return t;
    }
}

