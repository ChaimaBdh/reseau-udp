# Compte rendu TP2


<!-- ## Protocole UDP

On récupère la collection d'octets qui encode la chaîne de caractères passée en paramètre par la méthode getBytes().
On envoie cette collection d'octets (datagrammes sont construits ainsi).
-->

## Multicast UDP


Pour émettre et recevoir un paquet UDP multicast sur le réseau local :  
Il faut d'abord récupérer l'adresse et le port du destinataire. Comme vu dans le TP1, l’envoi d’un datagramme à une machine est identifié par le port de communication et l’adresse IP de la machine distante.

Le multicast permet à un groupe de machines de communiquer de telle sorte que chaque message envoyé soit reçu par l'ensemble des membres du groupe. Le groupe utilise une adresse IP virtuelle (ici 224.0.0.1), qui doit être comprise entre 224.0.0.0 et 239.255.255.255.
On choisit également un numéro de port compris entre 1024 et 65535 qui sera le numéro de port sur lequel les messages seront attendus.

 Pour recevoir le messages de la source, il faut disposer d'une socket reliée au port. Il faut également que cette socket joigne le groupe, avec la méthode joinGroup(), en indiquant l'adresse IP virtuelle du groupe. Après cela, il suffit d'attendre des datagrammes par la socket.

 Pour envoyer le message au groupe, il faut construire un datagramme en indiquant l'adresse IP virtuelle et en spécifiant le port de réception.

Le multicast envoie des paquets uniquement aux consommateurs intéressés. Il est basé sur un concept d'appartenance à un groupe, où une adresse de multicast (ici 224.0.0.1) représente chaque groupe.



