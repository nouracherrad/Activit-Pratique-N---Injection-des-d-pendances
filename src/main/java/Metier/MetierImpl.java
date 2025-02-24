package Metier;

import Dao.DaoImpl;
import Dao.IDao;

public class MetierImpl implements IMetier {
    //couplage faible
    private IDao dao  ;
    @Override
    public double calcul() {
        double t =dao.getData();
        double res =t*23;
        return res;
    }

    public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    //pour injecter dans la variable doa  un objet dune classe qui implemente IDao
    public void setDao(IDao dao) {
        this.dao = dao;
    }

}

