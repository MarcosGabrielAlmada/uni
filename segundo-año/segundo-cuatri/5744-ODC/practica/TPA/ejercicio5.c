#include <stdio.h>

int main() {
    int binario, temp;
    int decimal = 0, base = 1, resto, notacion = 2;

    printf("Ingrese un numero en notacion binaria: ");
    scanf("%d", &binario);

    temp = binario;

    while (temp > 0) {
        resto = temp % 10;
        
        if (resto != 0 && resto != 1) {
            printf("Error: crack, esto no es notacion binaria");
            return 0;
        }

        decimal += resto * base;
        base *= notacion;
        temp /= 10;
    }

    printf("%d en decimal es: %d", binario, decimal);

    return 0;
}