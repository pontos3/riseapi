package fr.pontos3.rise.riserest;

import java.util.Locale;

import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class AppConfig {

    
/*    
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
        = new ReloadableResourceBundleMessageSource();
       
      messageSource.setBasename("classpath:ValidationMessages");
      messageSource.setDefaultEncoding("UTF-8");

      return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());

        return bean;
    }
*/
/*
    @Bean 
    public Validator getValidator() {
        Validator bean = Validation.byDefaultProvider()
        .configure()
        .messageInterpolator(
            new ResourceBundleMessageInterpolator(
                new PlatformResourceBundleLocator( "ValidationMessages" )
            )
        ). buildValidatorFactory().getValidator();

        return bean;
    }
*/
}