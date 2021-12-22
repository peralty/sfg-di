package de.peralty.sfgdi.services;

import de.peralty.sfgdi.repositories.EnglishGreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class I18nEnglishGreetingService implements GreetingService {

    // Constructor Injection mit Lombok
    private final EnglishGreetingRepository englishGreetingRepository;

    @Override
    public String sayGreeting() {
        return englishGreetingRepository.getGreeting();
    }
}
