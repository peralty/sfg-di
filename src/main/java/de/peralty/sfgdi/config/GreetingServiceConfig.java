package de.peralty.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import de.peralty.sfgdi.repositories.EnglishGreetingRepository;
import de.peralty.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import de.peralty.sfgdi.services.*;
import org.springframework.context.annotation.*;

/***
 * Java based Configuration für das Spring Framework
 */
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Bean
    @Profile("EN")
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {   // Bean verwendet den Methodennamen als Bean-Namen
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Bean("i18nService")    // Bean kann auch hier den Namen überschreiben
    @Profile({"DE", "default"})
    I18nGermanGreetingService i18nGermanGreetingService() {
        return new I18nGermanGreetingService();
    }

    @Bean
    @Primary
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

//    @Bean
//    ConstructorGreetingService constructorGreetingService() {
//        return new ConstructorGreetingService();
//    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

}
