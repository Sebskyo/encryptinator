Encryptinator™:

A really bad implementation of RSA in Java

Disclaimer: it is actually bad due to too low primes


===||===


What this is

-A school project of implementing two different prime generating algorithms, although fuck that I want to implement the whole shebang.

Why its behaviour is shit

-Simply running the program will (in the future) just result in a comparison between the two algorithms, and you'll have to do workarounds to actually generate keys and en/de -crypt.
I will although at some point in late 2015/early 2016 modify the program to make it more intuitive and actually usable by sensible human beings.

How to use

-Every command starts with java -jar encryptinator.jar, after that there are several commands:

-genkey <LIMIT> generates a new set of keys with a list of <LIMIT> primes, and prints the needed values for en/de -cryption

-encrypt <MESSAGE> <MODULO> <EXPONENT> encrypts <MESSAGE> using the modulo <MODULO> and exponent <EXPONENT>, these values are given by a key, see genkey.

-decrypt <CIPHERTEXT> <MODULO> <EXPONENT> decrypts <CIPHERTEXT>, remember to use the opposite exponent than the one used to encrypt it.

-help prints a help message

-If no command is given, the program runs two different prime generating algorithms and compares them.

-On *nix you can run "chmod +x" to be able to dotslash the program instead of writing out the long tedious java thing.
