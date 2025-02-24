package pres;

import Dao.DaoImpl;
import Metier.MetierImpl;
import ext.DaoImplV2;

public class presentation1 {
    public static void main(String[] args) {
        //injection des dependances par injection statique
        DaoImpl d= new DaoImpl();
        MetierImpl metier=new MetierImpl(d);//injection via le constructeur
        // metier.setDao(d);//injection via le setter
        System.out.println(metier.calcul());
    }
}
