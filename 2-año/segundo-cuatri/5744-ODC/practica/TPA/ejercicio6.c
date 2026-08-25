#include <stdio.h>

int main() {
	char hex[100], c;
	int decimal = 0, base = 1, valor_digito, counter;

	printf("Ingrese un numero en notacion binaria: ");
	scanf("%s", hex);

	while (hex[counter] != '\0') {
		c = hex[counter];
 		
		if (c >= '0' && c <= '9') {
			valor_digito = c - '0';
		} else if (c >= 'a' && c <= 'f') {
			valor_digito = c - 'a' + 10;
		} else if (c >= 'A' && c <= 'F') {
			valor_digito = c - 'A' + 10;
		} else {
			printf("Error: crack, esto no es notacion hexadecimal");
			return 0;
		}

		decimal = decimal * 16 + valor_digito;
		counter++;
	}

	printf("%s en decimal es: %d", hex, decimal);

	return 0;
}