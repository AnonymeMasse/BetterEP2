import interfaces.IDynamicArray;

public class DynamicArray implements IDynamicArray {
    /**
     * insert value at the end of the array, grows internal array if needed
     *
     * @param value value to be pushed
     */
    @Override
    public void push(int value) {
        // TODO: implement method
    }

    /**
     * insert value at index, grows interal array if needed
     * <p>
     * if the index is out of bounds: `index < 0 || index >= this.length()` this method should do nothing
     *
     * @param value value to be inserted at index
     * @param index index at which the value should be inserted
     */
    @Override
    public void insert(int value, int index) {
        // TODO: implement method
    }

    /**
     * removes the last value in the array and returns it
     *
     * @return returns last value in the array or null if the array is empty
     */
    @Override
    public Integer pop() {
        // TODO: implement
        return 0;
    }

    /**
     * removes the value at index and returns it
     *
     * @param index index of value which should be removed
     * @return value at index or null if
     * - index < 0 or
     * - index >= this.length()
     */
    @Override
    public Integer remove(int index) {
        // TODO: implement
        return 0;
    }

    /**
     * get the value stored at index
     *
     * @param index index of the value
     * @return value stored at index or null if
     * - index < 0 or
     * - index >= this.length()
     */
    @Override
    public Integer get(int index) {
        // TODO: implement method
        return 0;
    }

    /**
     * returns the number of elements present in the array
     *
     * @return the number of elements present in the array
     */
    @Override
    public int length() {
        // TODO: implement method
        return 0;
    }

    /**
     * clear the array
     */
    @Override
    public void clear() {
        // TODO: implement method
    }
}
