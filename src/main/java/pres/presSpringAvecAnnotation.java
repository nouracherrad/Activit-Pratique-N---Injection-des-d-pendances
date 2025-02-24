package pres;

import Metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class presSpringAvecAnnotation {
    public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("Dao","metier");
    IMetier metier = context.getBean("metier", IMetier.class);
        System.out.println("RESULTAT = " + metier.calcul());
    }    }