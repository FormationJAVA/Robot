# Robot
Ce projet à pour objectif de :
<li> Aider l'étudiant à concevoire un ensemble de classe util à résoudre le problème de géométrique inverse en 2D</li>
<li> Developper les capacités de l'étudiant à traiter des problèmes nouveaux (Aucun des étudiants n'a reçu de formation en robotique)</li>

# Notions de base
Durant les dernières années, la robotique a connu un intêret grandissant dans plusieurs domaines (indutrie, medecine, etc) pour les nombreux avantages comme reduction des cout de production, reduction des erreur medicales en chiruregie, assitance dans des environnement hostiles, etc.

### Modelisation en 2D
Un robot est constitué de plusieurs tiges, appelées liens, séparées par des articulations. Il existe deux types d'articulations :
<li> Prismatique : ce type d'articulation effectue un deplacement le long du lien lié à elle, ce qui influancera ça longeur</li>
<li> Rotationnelle :  dans ce type l'articulation peux effectuer une rotation sur l'axe perpendiculaire au plan 2D </li>
En d'autre termes, chaque robot peut être modélisé sous la forme d'un ensemble de positions de ces articulations, et un ensemble de longueurs de ces liens. La dernière articulation est appelée l'effecteur (la main du robot).

### Problèmatique
Soit une cible t dans un plan 2D.
Quel est la position de toutes les articulations pour que l'effecteur atteint la cible t.

### Modèle géométrique inverse (en anglais, inverse kinematics)
Ce problème est très connu dans la litérature, il existe plusieurs algorithmes pour le résoudre. 
l'objet de ce projet est d'implementer l'algorithme FABRIK (Forward And Backward Reaching Inverse Kinematics) décrit par A. Aristidou dans [1]. 
Le résultat est affiché dans une fenêtre.

## References
[1] A. Aristidou, J. Lasenby,"FABRIK: A fast, iterative solver for the Inverse Kinematics problem", Graphical Models, Volume 73, Issue 5, 2011,  243-260.
