# Ghost Net Fishing – IPWA02-01

Webbasierte Anwendung zur Verwaltung und Bergung von Geisternetzen.  
Fallstudie im Kurs IPWA02-01 – Programmierung von industriellen Informationssystemen mit Java EE.

# Beschreibung

Die Anwendung ermöglicht das Melden, Verwalten und Bergen von herrenlosen Fischernetzen (Geisternetzen). Meldende Personen können Fundorte mit GPS-Koordinaten erfassen, bergende Personen können sich für die Bergung eintragen und den Status der Netze aktualisieren.

# Technologie-Stack

- **JSF 2.3** mit **PrimeFaces 11** (Benutzeroberfläche)
- **CDI/Weld 3.1** (Dependency Injection)
- **JPA/Hibernate 5.6** (Persistenz)
- **H2-Datenbank** im In-Memory-Modus
- **Maven** (Build-Management)

# Voraussetzungen

- Java 21
- Maven
- Java-EE-fähiger Application Server (z. B. Apache Tomcat 9+)

# Installation und Start

1. Repository klonen:
git clone https://github.com/markusgradel-code/IPWA02-01-Ghost-Net-Fishing.git
2. In das Projektverzeichnis wechseln:
cd IPWA02-01-Ghost-Net-Fishing/ghost-net-fishing
3. Projekt bauen:
mvn clean package
4. Die erzeugte WAR-Datei (`target/ghost-net-fishing-0.0.1-SNAPSHOT.war`) auf einem Application Server deployen.

5. Anwendung im Browser aufrufen:
http://localhost:8080/ghost-net-fishing/index.xhtml

# Projektstruktur
ghost-net-fishing/
├── src/main/java/
│   ├── model/          (GhostNet, Person, GhostNetStatus)
│   ├── dao/            (GhostNetDAO)
│   └── controller/     (GhostNetController)
├── src/main/resources/
│   └── META-INF/       (persistence.xml)
├── src/main/webapp/
│   ├── WEB-INF/        (web.xml, beans.xml)
│   └── index.xhtml
└── pom.xml

# Autor

Markus Gradel – IU Internationale Hochschule
