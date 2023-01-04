numero = int(input("Digite un numero"))

if numero > 10:
    print("el numero es mayor que 10")
elif numero == 5:
    print("El numero es 5")
else:
    print("el numero es menor que 10")

#While
# while(){} en java
while numero<20:
    numero+=1
    print(numero)

#for(int i = 0; i < x; i++){} en java
for i in range(0, numero + 1, 1):
    print("paso", i)

#Iterar
lista1 = [1, 2, 3, 4, 5]
for i in lista1:
    print("elemento",i)

#lo mismo que lo anterior pero pasando la lista a una variable
#iter1 = iter(lista1)
#for i in iter1:
#    print("elemento",i)

enum1 = enumerate(lista1)
print(next(enum1))