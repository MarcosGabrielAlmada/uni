#include <stdio.h>

int checkAscProlijo(long *num) {
	if (*num == 0) {
		return 1;
	}
	long dig = *num % 10;
	*num /= 10;
	if (*num % 10 > dig) {
		return checkAscProlijo(num);
	} else {
		return 0;
	}
}

int checkDesProlijo(long *num) {
	if (*num == 0) {
		return 1;
	}
	long dig = *num % 10;
	*num /= 10;
	if (*num % 10 < dig) {
		return checkDesProlijo(num);
	} else {
		return 0;
	}
}

int checkProlijo(long *num) {
	if (*num <= 9) {
		return 1;
	} else {
		long dig = *num % 10;
		*num /= 10;
		if (*num % 10 > dig) {
			return checkAscProlijo(num);
		} else if (*num % 10 < dig) {
			return checkDesProlijo(num);
		} else {
			return 0;
		}
	}
}

int main () {
	long num;
	printf("Ingrese un numero: ");
	scanf("%ld", &num);

	if (num < 0) {
		num *= -1;
	}

	int checker = checkProlijo(&num);
	printf("Resultado(1 o 0): %d", checker);
	return 0;
}
