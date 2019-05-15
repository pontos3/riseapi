# riseapi
country state address REST api

Sample with httpie:

```bash
http -v --json POST localhost:8081/countries usualName="France" officialName="France" shortName="France" iso2="fr" iso3="fra" longitude=2.21 latitude=46.22

http -v --json POST localhost:8081/countries usualName="Espagne" officialName="Espagne" shortName="Espagne" iso2="es" iso3="esp" longitude=-3.74 latitude=40.46

http -v --json GET localhost:8081/countries

http -v --json POST localhost:8081/GeographicalAreas label="Europe" code="EU" countries:="{'id'=1, 'id'=2 }"
http -v --json POST localhost:8081/GeographicalAreas label="Afrique" code="AF" countries:="{'id'=1, 'id'=2 }"
http -v --json POST localhost:8081/GeographicalAreas label="Afrique du nord / Moyen-Orient" code="AFN"
http -v --json POST localhost:8081/GeographicalAreas label="Amérique" code="AM"
http -v --json POST localhost:8081/GeographicalAreas label="Asie / Océanie" code="AS"
http -v --json POST localhost:8081/GeographicalAreas label="Antarctique" code="AN"

http -v --json GET localhost:8081/GeographicalAreas

```
Référentiel au format REST des Implantations et Services à l’Etranger
