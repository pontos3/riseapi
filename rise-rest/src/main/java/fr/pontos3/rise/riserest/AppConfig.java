package fr.pontos3.rise.riserest;

import org.springframework.context.annotation.Configuration;


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