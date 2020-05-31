# Ford Weather Report
### Description
  This program was written to automate a report utilized by a Manager at Lanter Trucking who must regularly manually generate a weather report to be delievered to Ford Motor Company's Shipping Division. The report generates weather conditions for 181 ford car dealerships. It uses the dealership Zip Code to request weather data from [ClimaCell](https://www.climacell.co/) Rest API and based on that information it produces an excel report.

Example Human Written Report:
[Weather Impact Report](https://github.com/Gcolon021/FordWeatherReport/blob/master/Excel/WEATHER%20IMPACT%2001-17-2019.xlsx)

Example of Generated Report:
[Ford Weather Report](https://github.com/Gcolon021/FordWeatherReport/blob/master/Excel/Ford%20Weather%20Report.xls)

### Technologies Used

Languages/Libraries:
- Java 11
- [Apache POI](https://poi.apache.org/)
- [Moshi](https://github.com/square/moshi/)
- [Okhttp](https://square.github.io/okhttp/)
- [Apache Commons](https://commons.apache.org/)
- [Lombok](https://projectlombok.org/)

### Pre-Code Review Notes:
 - Use Lombok Library for handling getters, setters, equals, hashcode. 
 - Use web address for resource files. Potentially a shared google drive file or something similar.
 - When utilizing git use git-flow or some better approach to using version control.
 - Use CSV library instead of writing a regular expression to parse data. "My friend had a problem, so he fixed it with a regular expression. Now my friend has two problems." - some wise program
 - This project had 1311 lines of java code pre-refactor
 
### Refactor - Post Code Review:
 - Migrated project to use @Data and @Builder reducing clutter and lines of code by 329. The biggest benefit of this change is reduce clutter and improve readability making future maintenance easier.
- 