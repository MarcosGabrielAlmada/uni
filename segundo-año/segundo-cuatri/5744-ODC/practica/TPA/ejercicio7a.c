#include <stdio.h>

int countDigits(int *num) {
	if (*num <= 9) {
		return 1;
	} else {
		*num /= 10;
		return 1 + countDigits(num);
	}
}

int main () {
	int num;
	printf("Ingrese un numero: ");
	scanf("%d", &num);

	int cant = countDigits(&num);
	printf("La cantidad de digitos es %d", cant);
	return 0;
}

