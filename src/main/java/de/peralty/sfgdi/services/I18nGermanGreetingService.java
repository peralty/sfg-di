package de.peralty.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"DE", "default"})
@Service("i18nService")
public class I18nGermanGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hallo Welt - DE";
    }
}
