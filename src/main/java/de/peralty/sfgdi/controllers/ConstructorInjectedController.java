package de.peralty.sfgdi.controllers;

import de.peralty.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/***
 * Constructor Injection - preferred method
 */
@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;
    
    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
