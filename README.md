API-Pandemie 🦠
====================

Une API RESTful développée en Java avec Spring Boot pour suivre les statistiques de pandémies (cas, morts, guérisons) par pays, région et type de maladie. Ce projet permet d'exposer des données temporelles liées aux pandémies pour une visualisation ou exploitation via une application front-end.

🧰 Technologies utilisées
-------------------------
- Java 17
- Spring Boot
- Spring Data JPA
- H2 (base de données en mémoire)
- Maven
- REST API
- Documentation OpenAPI Specification

🚀 Fonctionnalités
------------------
- Récupération des statistiques par pays, région et maladie
- Suivi de l’évolution des cas, morts, et guérisons dans le temps
- Affichage de graphiques dynamiques via Chart.js
- Export des données statistiques en CSV
- Interface utilisateur responsive avec Bootstrap
- Structure des entités : Pays, Région, Maladie, Statistique

📁 Structure du projet
----------------------
API-Pandemie/
├── src/
│   ├── main/
│   │   ├── java/com/api/pandemie/...
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
└── README.txt

📌 Endpoints principaux
-----------------------
Méthode | Endpoint                         | Description
--------|----------------------------------|------------------------------
GET     | /api/pays                        | Liste tous les pays
GET     | /api/regions                     | Liste toutes les régions
GET     | /api/maladies                    | Liste toutes les maladies
GET     | /api/statistiques                | Toutes les statistiques
GET     | /api/statistiques/export         | Export des statistiques en CSV
GET     | /api/statistiques/pays/{id}      | Statistiques par pays
GET     | /api/statistiques/donnees-par-jour   | Statistiques par jours avec maladie et pays en entrée

▶️ Lancer l’application
-----------------------
1. Cloner le projet :
   git clone https://github.com/A2nan/API-Pandemie.git
   cd API-Pandemie

2. Lancer avec Maven :
   ./mvnw spring-boot:run

3. Accéder à l’interface :
   http://localhost:8080
