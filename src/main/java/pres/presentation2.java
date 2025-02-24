package pres;

import Dao.IDao;
import Metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class presentation2 {
        public static void main(String[] args) {
            try {
                Scanner scanner = new Scanner(new File("config.txt"));
                String doaClassename = scanner.nextLine();
                System.out.println(doaClassename);
                Class cdao = Class.forName(doaClassename);
                //DaoImplV2 d= new DaoImplV2();
                //INstancier un objet dune manierte dynamique
                IDao dao = (IDao) cdao.getConstructor().newInstance();
                // MetierImpl metier=new MetierImpl(d);//injection via le constructeur
                String metierClassename=scanner.nextLine();
                Class  cMetier=Class.forName(metierClassename);
                IMetier metier=(IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
                System.out.println("res"+metier.calcul());
                System.out.println(dao.getData());
                //pour instancier via le stter
                Method setDao=cMetier.getMethod("setDao",IDao.class);
                setDao.invoke(metier,dao);
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }

        }}

