public interface MovingAverage {
    /**
     * Add a number to the moving average
     * @param num number to add to moving average
     */
    public void add(Double num);

    /**
     * Get the moving average of the last N numbers
     * @param n the last N number
     * @return the moving average of the last N numbers
     */
    public Double getMovingAverage(int n);
}
