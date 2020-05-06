package fr.pontos3.rise.riserest;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("beforeSaveCountryHistoryValidator")
public class BeforeSaveCountryHistoryValidator implements Validator {

    @Autowired
    MessageSource messageSource;

    @Override
    public boolean supports(Class<?> clazz) {

        return CountryHistory.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        String test = messageSource.getMessage("countryhistory.iso2", null, Locale.GERMAN);
        
        CountryHistory countryHistory = (CountryHistory) target;

        log.info("[i] Validating CountryHistory: {}", target);

        //errors.rejectValue("listName", "listName.empty");
        
    }

    
}