package fr.pontos3.rise.riserest;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(CountryRepository countryRepository, CountryHistoryRepository countryHistoryRepository) {
    return args -> {

      HashMap<String, HashMap<String, String>> resultMap_allCountry = new HashMap<String, HashMap<String, String>>();
      try 
      {
          //Load csv file for gps coordinate
          File csvFile_gps = new File("src/main/resources/countryList_gps.csv");
          File csvFile_country = new File("src/main/resources/countryList_country.csv");

          CsvMapper csvMapper = new CsvMapper();
          csvMapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);

          String[][] resultCsv_gps = csvMapper.readValue(csvFile_gps, String[][].class);
          String[][] resultCsv_country = csvMapper.readValue(csvFile_country, String[][].class);

          HashMap<String, String> values;

          for (String[] item : resultCsv_gps) {

            if(!item[1].equalsIgnoreCase("Alpha-2 code")) {
              values = new HashMap<String, String>();

              values.put("iso2", item[1].toLowerCase());
              values.put("iso3", item[2].toLowerCase());
              values.put("isoNum", item[3]);
              values.put("lat", item[4]);
              values.put("lon", item[5]);
              resultMap_allCountry.put(
                item[1], 
                values
                );
            }
          }

          for (String[] item : resultCsv_country) {

            if(resultMap_allCountry.containsKey(item[0])) {
              values = resultMap_allCountry.get(item[0]);
            }
            else {
              values = new HashMap<String, String>();
            }

            values.put("iso2", item[0].toLowerCase());
            values.put("iso3", item[1].toLowerCase());
            values.put("isoNum", item[2]);
            values.put("shortName", item[3]);
            values.put("longName", item[4]);
            resultMap_allCountry.put(
              item[0], 
              values
              );
          }

          log.info(resultMap_allCountry.toString());

      } catch (Exception e) {
        log.error("Error occurred while loading object list from file ", e);
      }

      /**
       * Due to method-level protections on {@link example.company.ItemRepository}, the security context must be loaded
       * with an authentication token containing the necessary privileges.
       */
      SecurityUtils.runAs("system", "system", "ROLE_ADMIN");

      for(Map.Entry<String, HashMap<String,String>> mapentry : resultMap_allCountry.entrySet()) {

        HashMap<String,String> mapValue = mapentry.getValue();
        
        log.info("mapValue =>" + mapValue.toString());

        if(mapValue.get("shortName") != null) {

          Country country = new Country(
            Double.valueOf(mapValue.get("lat")!=null?mapValue.get("lat"):"0.0"),
            Double.valueOf(mapValue.get("lon")!=null?mapValue.get("lat"):"0.0")
            ); 
    
          Country savedCountry = countryRepository.save(country);
          log.info("saveCountry =>" + savedCountry);


          CountryHistory countryHistory = new CountryHistory(savedCountry, 
            mapValue.get("iso2") == "" ? null: mapValue.get("iso2"),
            mapValue.get("iso3") == "" ? null: mapValue.get("iso3"),
            mapValue.get("shortName"),
            mapValue.get("longName"),
            mapValue.get("shortName"));
    
          log.info("saveCountryHistory =>" + countryHistory);
          CountryHistory savedCountryHistory = countryHistoryRepository.save(countryHistory);
          log.info("saveCountryHistory =>" + savedCountryHistory);
        }
      }

      SecurityContextHolder.clearContext();


      //Create objectMapper instance
/*      ObjectMapper objectMapper = new ObjectMapper();

      JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/countryList.json"));

      Iterator<JsonNode> jsonSrcIterator  = rootv.get("countries").elements();

      while(jsonSrcIterator.hasNext()) {

        JsonNode node = jsonSrcIterator.next();

        log.info("shortCountryNam =>" + v.get("capital/lat").asLong());

        Country country = new Country(
          v.get("capital.lat").path("lat").asLong(),
          v.get("capital.lon").path("lon").asLong()
          ); 

        Country savedCountry = countryRepository.save(country);
        log.info("saveCountry =>" + savedCountry);

        CountryHistory countryHistory = new CountryHistory(savedCountry, 
          v.get("iso2") == "" ? null: v.get("iso2"),
          v.get("iso3") == "" ? null: v.get("iso3"),
          v.get("shortCountryName"),
          v.get("longCountryName"),
          v.get("shortCountryName"));

        log.info("saveCountryHistory =>" + countryHistory);

        CountryHistory savedCountryHistory = countryHistoryRepository.save(countryHistory);
        log.info("saveCountryHistory =>" + savedCountryHistory);
      }*/
    };
  }
}