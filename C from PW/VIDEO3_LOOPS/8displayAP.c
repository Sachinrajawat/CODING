// display this AP 4,7,10,13,16... upto n
#include<stdio.h>

int main(){
    int n;
    printf("Enter a number : ");
    scanf("%d",&n);
    for(int i=4;i<=3*n+1;i++){// nth term = a+(n-1)d
        printf("%d",i);
    }
    return 0;
}