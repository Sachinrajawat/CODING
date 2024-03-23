//print the max value of the array

//f(arr,idx,n) = max(arr[idx],f(arr,idx+1,n))
#include<iostream>
#include<algorithm>
using namespace std;

int f(int *arr, int idx, int n) {
    // base case
    if(idx == n-1) return arr[idx]; // we only have one element left, so it is the maximum
    return max(arr[idx], f(arr, idx+1, n));
}

int main() {
    int n = 5;
    int arr[] = {3, 10, 30, 2, 5};
    cout << f(arr, 0, n);
    return 0;
}