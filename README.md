# Recommendation-system
Un système de recommandation de documentation

Un site web marchand propose de la documentation thématique pour ses clients (jardinage, informatique,...).
Le fichier log du site joint en annexe (log_clients_themes.txt) nous permet d'identifier le type de documentation
qu'a téléchargé chauqe utilisateur.
>exemple:
5 ; Achraf ; Jardinage   : signifie que le 5 eme enregistrement indique que Achraf a téléchargé une information sur le jardinage. 

### partie 1 : Analayse de comportement des clients 

la première partie consiste à écrire un code java peremettant de construire la matrice MUT(matrice de relation entre usagers et thèmes),
l'idée et de retrouver la relation qui lie chaque usager au nombre de thèmes qu'il a consulté.


### partie 2 : Recommandations

Danc cette partie nous avons extraire 5 matrices depuis une MUT founrnie pour avoir une liste de recommandation .
Voici les différentes étapes : 
* MUT-binaire  : une transformation binaire de MUT
* Mtt : matrice de distance entre thèmes
* Mtt-binaire : une transformation binaire de Mtt
* MutR : matrice contenant les thèmes recommandés aux usagers


### Résultats

la liste de recommandation est : Justine 6 -> bricolage

