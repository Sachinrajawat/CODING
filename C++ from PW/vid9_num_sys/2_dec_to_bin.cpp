

#include<iostream>
using namespace std;
int main(){
    int n;
    cout<<"Enter n: ";
    cin>>n;
    int ans=0;
    int power=1;
    while(n>0){
        int paritydigit = n%2;
        ans += paritydigit*power;
        power*=10;
        n/=10;

    }
    cout<<ans;


    return 0;
}