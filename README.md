# riseapi
country state address REST api

Sample with httpie:

```bash
http -v --json POST localhost:8081/GeographicalAreas label="Afrique", code="AF"
http -v --json POST localhost:8081/GeographicalAreas label="Afrique du nord / Moyen-Orient", code="AFN"
http -v --json POST localhost:8081/GeographicalAreas label="Amérique", code="AM"
http -v --json POST localhost:8081/GeographicalAreas label="Asie / Océanie", code="AS"
http -v --json POST localhost:8081/GeographicalAreas label="Europe", code="EU"
http -v --json POST localhost:8081/GeographicalAreas label="Antarctique", code="AN"

http -v --json GET localhost:8081/GeographicalAreas
```
Référentiel au format REST des Implantations et Services à l’Etranger
