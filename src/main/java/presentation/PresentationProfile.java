package presentation;

import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"dao","metier"})
public class PresentationProfile {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        //active le profil "dev
        context.getEnvironment().setActiveProfiles("dev");
       // enregistres ta classe de configuration comme ca new AnnotationConfigApplicationContext(Presentation2.class);
        context.register(PresentationProfile.class);
        //démarre réellement le conteneur
        context.refresh();
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Résultat = " + metier.calcul());
    }
}
