import java.util.*;

public class SimpleMovingAverage implements MovingAverage {
    private List<Double> listOfTotalSumAtEachIndex;

    SimpleMovingAverage() {
        listOfTotalSumAtEachIndex = new ArrayList<>();
    }
    /**
     * Add a number to the moving average.
     * Runtime: O(1) operation
     *
     * @param num number to add to moving average
     */
    @Override
    public void add(Double num) {
        if (listOfTotalSumAtEachIndex.isEmpty()) {
            listOfTotalSumAtEachIndex.add(num);
        } else {
            // calculate the new total and add to
            Double newTotal = listOfTotalSumAtEachIndex.get(listOfTotalSumAtEachIndex.size() - 1) + num;
            listOfTotalSumAtEachIndex.add(newTotal);
        }
    }

    /**
     * Get the moving average of the last N numbers
     * Runtime: O(1) operation
     *
     * @param n the last N number
     * @return the moving average of the last N numbers
     */
    @Override
    public Double getMovingAverage(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot get the moving average of the last N negative numbers.");
        }

        if (n == 0) {
            throw new IllegalArgumentException("Cannot get the moving average of the last 0 numbers.");
        }

        // Check if list is empty. No need to worry about dividing by 0 as an error will be thrown if list is empty
        if (listOfTotalSumAtEachIndex.isEmpty()) {
            throw new IllegalArgumentException("Cannot get the moving average as the moving average list contains no numbers.");
        }

        Double currTotal = listOfTotalSumAtEachIndex.get(listOfTotalSumAtEachIndex.size() - 1);
        // If n is greater than the list size, return the average of the whole list
        if (n >= listOfTotalSumAtEachIndex.size()) {
            return currTotal / ((double) listOfTotalSumAtEachIndex.size());
        }

        Double previousTotal = listOfTotalSumAtEachIndex.get(listOfTotalSumAtEachIndex.size() - 1 - n);
        // The sum of the N previous numbers is calculated by subtracting the sums (which is stored in listOfTotalSumAtEachIndex)
        // Eg. A[0..i..n]. We can find the sum of the numbers from i..n by sum(0...n) - sum(0...i); Then we can divide
        // by N to find the moving average
        Double movingAvg = (currTotal - previousTotal) / n;

        return movingAvg;
    }

    public static void main(String[] args) {
        SimpleMovingAverage simpleMovingAverage = new SimpleMovingAverage();
        simpleMovingAverage.add(3.0);
        simpleMovingAverage.add(2.5);
        simpleMovingAverage.add(6.5);

        System.out.println(simpleMovingAverage.getMovingAverage(1));
        System.out.println(simpleMovingAverage.getMovingAverage(2));
        System.out.println(simpleMovingAverage.getMovingAverage(3));
    }
}
