#include <stdio.h>
#include <string.h>
#define LEN_INPUT 10

int main(void) {
    char s1[LEN_INPUT];
    scanf("%s", s1);

    int s1_len = strlen(s1);
    for (int i = 0; i < s1_len; i++) {
        if ('a' <= s1[i] && s1[i] <= 'z') {
            s1[i] -= 32;
        } else if ('A' <= s1[i] && s1[i] <= 'Z') {
            s1[i] += 32;
        }
    }
    
    printf("%s", s1);
    return 0;
}
