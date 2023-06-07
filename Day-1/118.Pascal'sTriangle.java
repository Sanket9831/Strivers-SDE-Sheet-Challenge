class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        // base list when number of row is just 1 in  Pascal's triangle.
        List<Integer> bList = new ArrayList<>();
        bList.add(1);
        result.add(bList);
        // handling 2nd to nth rows of  Pascal's triangle.
        for(int currRow = 2; currRow <= numRows; ++currRow){ 
            List<Integer> list = new ArrayList<>();
            for(int j = 1; j <= currRow; ++j){
                // First and last number in  Pascal's triangle is always 1
                if(j == 1 || j == currRow) 
                    list.add(1);
                // each number is the sum of the two numbers directly above it,
                // So relation b/w current number = 1st previous direct num + 2nd previous direct num
                // First we need to get prevoius list from "result", which would be at (current row - 2) 
                // for this prevoius list:
                //          1st previous direct num index = j - 2;
                //          2nd previous direct num index = j - 1;
                //Hence, Current Number = perviousList[j-2] + previousList[j-1]
                else{
                    int pd1 = result.get(currRow-2).get(j-2);
                    int pd2 = result.get(currRow-2).get(j-1);
                    int currNum = pd1 + pd2;
                    list.add(currNum);
                }
            }
            result.add(list);
        }
        return result;
    }
}
