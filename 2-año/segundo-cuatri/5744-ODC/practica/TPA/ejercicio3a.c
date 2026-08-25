#include <stdio.h>

int main() {
	float celsius;
	printf("Grados: ");
	scanf("%f", &celsius);

	float farenheit;
	farenheit = celsius * 33.8;
	printf("%f celsius son %f farenheit", celsius, farenheit);

	return 0;
}