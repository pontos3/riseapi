package fr.pontos3.rise.riserest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("beforeCreateCountryHistoryValidator")
public class BeforeCreateCountryHistoryValidator implements Validator {

    @Autowired 
    Validator mainValidator;

    @Autowired
    CountryHistoryRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {

        return CountryHistory.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        CountryHistory countryHistory = (CountryHistory) target;

        log.info(mainValidator.getClass().getName());

        mainValidator.validate(countryHistory, errors);

        //Check countryHistoryUnicity
        /**
         * @TODO("refactor this check")
         * */
        //CountryHistory otherCountryHistory = repository.findByIso2(countryHistory.getIso2());

        /*if(otherCountryHistory != null) {
            errors.rejectValue("iso2", "countryhistory.allready.exist");
        }*/

        log.info("[i] Validating CountryHistory: {}", target);
        
    }

    
}