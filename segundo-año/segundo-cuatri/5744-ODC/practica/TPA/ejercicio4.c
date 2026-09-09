#include <stdio.h>

int main() {
    int cant;
    printf("Cantidad de numeros: ");
    scanf("%d", &cant);

    if (cant >= 2) {
        float nums[cant];
        float mayor, menor, prom = 0;

        printf("Ingrese: ");
        scanf("%f", &nums[0]);
        
        mayor = nums[0];
        menor = nums[0];
        prom = nums[0];

        for (int i = 1; i < cant; i++) {
            printf("Ingrese: ");
            scanf("%f", &nums[i]);
            
            prom += nums[i];
            
            if (nums[i] > mayor) {
                mayor = nums[i];
            }
            if (nums[i] < menor) {
                menor = nums[i];
            }
        }

        prom /= cant;
        printf("\nMayor: %f\nMenor: %f\nPromedio: %.f\n", mayor, menor, prom);

    } else {
        printf("Media pila gato\n");
    }

    return 0;
}