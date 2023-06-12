/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/

/*-----------------------------------------------------------⭐⭐SOLUTION-01⭐⭐---------------------------------------------------------------*/
class jobComparator implements Comparator<Job>{
    @Override
    public int compare(Job o1, Job o2){
        if(o1.profit < o2.profit)
            return 1;
        else if(o1.profit > o2.profit)
            return -1;
        else
            return 0;
    }
}

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        ArrayList<Job> jl = new ArrayList<>(); //O(3N) SPACE
        for(int i = 0; i < n; ++i){
            jl.add(new Job(arr[i].id, arr[i].deadline, arr[i].profit));
        }
        jobComparator jc = new jobComparator();
        Collections.sort(jl, jc); //O(NlogN) TC
        
        int maxDeadline = 0;
        for(int i = 0; i <  n; ++i){
            maxDeadline = Math.max(arr[i].deadline , maxDeadline);
        }
        int[] result = new int[maxDeadline+1];  //O(N) SPACE
        Arrays.fill(result,-1);
        int countJob = 0, maxProfit = 0;
        for(int i = 0; i < n; ++i){                          //O(N) TC
            for(int j = jl.get(i).deadline; j > 0; --j){     //O(M) TC
                if(result[j] == -1){
                    result[j] = jl.get(i).profit;
                    countJob++;
                    maxProfit += result[j];
                    break;
                }
            }
        }
        result[0] = countJob;
        result[1] = maxProfit;
        return result;
    }
}
// TC: O(NlogN) + O(N*M)
// SC: O(3N) + O(N)


/*-----------------------------------------------------------⭐⭐SOLUTION-02⭐⭐---------------------------------------------------------------*/
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a,b)-> (b.profit - a.profit)); //O(NlogN) TC
        
        int maxDeadline = 0;
        for(int i = 0; i <  n; ++i){
            maxDeadline = Math.max(arr[i].deadline , maxDeadline);
        }
        int[] result = new int[maxDeadline+1];  //O(N) SPACE
        Arrays.fill(result,-1);
        int countJob = 0, maxProfit = 0;
        for(int i = 0; i < n; ++i){                          //O(N) TC
            for(int j = jl.get(i).deadline; j > 0; --j){     //O(M) TC
                if(result[j] == -1){
                    result[j] = jl.get(i).profit;
                    countJob++;
                    maxProfit += result[j];
                    break;
                }
            }
        }
        result[0] = countJob;
        result[1] = maxProfit;
        return result;
    }
}
// TC: O(NlogN) + O(N*M)
// SC: O(N)
