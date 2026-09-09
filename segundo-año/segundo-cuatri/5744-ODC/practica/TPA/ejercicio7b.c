#include <stdio.h>

int calcMediano(int *num, int dig) {
	if (*num <= 9) {
		return (*num % 10 == dig);
	} else {
		int esta = *num % 10 == dig;
		*num /= 10;
		return esta + calcMediano(num, dig);
	}
}

int main () {
	int num;
	printf("Ingrese un numero: ");
	scanf("%d", &num);
	
	int dig;
	printf("Ingrese un digito: ");
	scanf("%d", &dig);

	int cant = calcMediano(&num, dig);
	printf("%d aparece %d veces", dig, cant);
	return 0;
}

