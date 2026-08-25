#include <stdio.h>

int main() {
	int day, mounth, year;
	printf("Dia: ");
	scanf("%d", &day);
	printf("Mes: ");
	scanf("%d", &mounth);
	printf("Año: ");
	scanf("%d", &year);
	
	if (mounth < 1 || mounth > 12 || day < 1 || day > 31) {
		printf("Fecha invalida.");

	} else if (mounth == 2) {
		if (day <= 28) {
			printf("Fecha valida");
		} else {
			printf("Fecha invalida");
		}

	} else if (mounth == 1 || mounth == 3 || mounth == 5 || mounth == 5 || mounth == 7 || mounth == 8 || mounth == 10 || mounth == 12) {
		printf("Fecha valida");

	} else {
		if (day <= 30) {
			printf("Fecha valida");
		} else {
			printf("Fecha invalida");
		}
	}

	return 0;
}