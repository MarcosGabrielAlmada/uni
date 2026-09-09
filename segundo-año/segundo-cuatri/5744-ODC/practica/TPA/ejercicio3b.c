#include <stdio.h>

int main() {
	float millas;
	printf("Millas: ");
	scanf("%f", &millas);

	float kilometros;
	kilometros = millas *  1.609344;
	printf("%f m/h son %f k/h", millas, kilometros);

	return 0;
}