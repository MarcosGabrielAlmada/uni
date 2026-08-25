#include <stdio.h>

int main() {
	long sec;
	printf("Segundos: ");
	scanf("%ld", &sec);

	int mins = sec > 0 ? sec / 60 : 0;
	sec -= mins * 60;

	int hours = mins > 0 ? mins / 60 : 0;
	mins -= hours * 60;

	printf("%d:%d:%d", hours, mins, sec);
	return 0;
}
