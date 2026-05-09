

/*
 *  Count Elements Greater Than Previous Average
    Given an array of positive integers, return the number of elements that are strictly greater than the average of all previous elements. Skip the first element.

    responseTimes = [100, 200, 150,300] --> Output = 2

    - Day 0: 100 (no previous days, skip) 
    - Day 1: 200 > average(100) = 100 → count = 1 
    - Day 2: 150 vs average(100, 200) = 150 → not greater → count = 1 
    - Day 3: 300 > average(100, 200, 150) = 150 → count = 2 Return 2.

    4
    100
    200
    150
    300
    here 4 is the length of array, followed by the elements of array on each line.

 */

public class CountTimeRegressions {
    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        if(responseTimes.size() <= 1) return 0; 
        int listLength = responseTimes.size();
        int resultCount = 0;
        long sum = responseTimes.get(0);
        
        for(int i = 1; i < listLength; i++) {
            long average = sum / i;
            if(responseTimes.get(i) > average) {
                resultCount++;
            }
            sum += responseTimes.get(i);
        }
        return resultCount;
    }
    
}
