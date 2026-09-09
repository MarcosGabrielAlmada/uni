#include <stdio.h>

long calcMediano(long *num) {
	long counter = 0;
	while (*num > 0) {
		counter += *num % 10;
		*num /= 10;

		if (*num > 0) {
			counter -= *num % 10;
			*num /= 10;
		}
	}
	return counter;
}

int main () {
	long num;
	printf("Ingrese un numero: ");
	scanf("%ld", &num);

	long counter = calcMediano(&num);
	printf("El numero mediano es %ld", counter);
	return 0;
}
