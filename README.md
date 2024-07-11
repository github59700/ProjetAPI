exo 1 : le get permet d'afficher tous les utilisateurs en BDD
exo 2 : Si le numero fidelité dans le POST correspond à un numéro fidélité en BDD dans la table USER alors un document est créé dans la table loyalty sinon message d'erreur
exo 3 : En entrant l'ID d'un client présent en BDD dans la table USER on peut modifier(patch) son statut (champs libre en string).

exo 1 :
URL : http://localhost:8080/api/clients
Méthode : GET
Headers
Body

exo 2 :
URL : http://localhost:8080/api/loyalty
Méthode : POST
Headers
Body : {
  "clientId": "8",
  "loyaltyNumber": "234",
  "points": 8000,
  "expirationDate": "2023-12-31",
  "status": "active"
}

exo 3 :
URL : http://localhost:8080/api/clients/6687d7728f85e883800efca9/status
Méthode : PATCH
Headers
Body : {
    "status": "actif"
}

