package fr.pontos3.rise.riserest;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    private Country france = new Country("fr", "fra", "France", "France", "France", 2.21, 46.22);
    private Country spain = new Country("es", "esp", "Espagne", "Espagne", "Espagne", -3.74, 40.46);

    private List<Country> countryList = new ArrayList<Country>();

  @Bean
  CommandLineRunner initDatabaseCountry(CountryRepository countryRepository, GeographicalAreaRepository repository) {
    return args -> {
      log.info("Preloading " + countryRepository.save(france));
      log.info("Preloading " + countryRepository.save(spain));

      this.countryList.add(france);
      this.countryList.add(spain);

      log.info("Preloading " + repository.save(new GeographicalArea("EU", "Europe", this.countryList)));
    };
  }
}