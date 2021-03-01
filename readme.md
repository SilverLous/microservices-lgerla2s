ServerApplication in server startet den Eureka Gateway Server
ServiceFactory startet die Gateway/User/Dice-Applications 
UserApplication ist eine Postgresql Datenbank die erreichbar ist unter 8083/user Datenbank ist nicht mit inbegriffen
DiceApplication ist eine kleine Würfel Api die unter 8083/AnzahlWürfel"d"AugenzahlWürfel eine Liste des Ergebnisses zurück gibt 
GatewayApplication routet den Verkehr über sich weiter
Ein Unit befindet sich bei dice/src/test/java/com/services/dice/DiceApplicationTests.java

Beispiel Requests an die Services sind unter server/src/main/java/com/server/test/Requests.http zu finden


Sources: https://dzone.com/articles/spring-cloud-amp-spring-bootimplementing-eureka-se
https://www.youtube.com/watch?v=9SGDpanrc8U
https://www.tutorialspoint.com/spring_boot/spring_boot_rest_controller_unit_test.htm