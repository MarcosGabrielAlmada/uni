#include <stdio.h>

int main () {
	char word[100];
	printf("Ingrese una palabra: ");
	scanf("%99s", word);

	int counter1 = 0;
	while (word[counter1] != '\0') { // sizeof
		counter1++;
	}

	counter1--;
	int counter2 = 0;
	while (counter1 > counter2) {
		if (word[counter1] == word[counter2]) {
			counter1--;
			counter2++;
		} else {
			printf("%s NO es palindroma", word);
			return 0;
		}
	}

	printf("%s ES palindroma", word);
	return 0;
}
