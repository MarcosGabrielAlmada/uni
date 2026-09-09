#include <stdio.h>

int main() {
	float litros;
	printf("Litros: ");
	scanf("%f", &litros);

	double galones;
	galones = litros *  0.264172052;
	printf("%f litros son %lf galones", litros, galones);

	return 0;
}