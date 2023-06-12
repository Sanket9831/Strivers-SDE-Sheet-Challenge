class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);  // TC: O(nlog(n))
        Arrays.sort(dep);  // TC: O(nlog(n))
        int a = 1, d = 0;
        int platformNeeded = 1, result = 1;
        while(a < n && d < n){ // TC: O(N)
            if(arr[a] <= dep[d]){
                platformNeeded++;
                a++;
            }else if(arr[a] > dep[d]){
                platformNeeded--;
                d++;
            }
            result = Math.max(result, platformNeeded);
        }
        return result;
    }
}

// TC: O(2 X nlog(n)) + O(N)
/*
Sort both arrival and departure time in ascending order.

NOTE: As per the constraints, there would be atleast 1 train in a day.

Once sorted there is 3 scenario:
1. When arrival time of next is less than derparture of previous more platfrom required
2. Even when both is same more platform required
3. Only when arrival of next train is greater that departure of next train, one platfrom would get empty and coming train can adjust there.
*/
