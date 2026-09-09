#include <stdio.h>

// asumo posicion impar como 1, 100, 10000, etc

int calcMediano(int *num) {
	if (*num <= 9) {
		return !((*num % 10) % 2); // es par 1; es impar 0
	} else {
		int par = !((*num % 10) % 2); // es par 1; es impar 0
		*num /= 100; // avanzamos por las posiciones impares
		return par + calcMediano(num);
	}
}

int main () {
	int num;
	printf("Ingrese un numero: ");
	scanf("%d", &num);

	int cant = calcMediano(&num);
	printf("Hay %d digitos pares en posiciones impares", cant);
	return 0;
}

