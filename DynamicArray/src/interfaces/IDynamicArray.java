package interfaces;

public interface IDynamicArray {
    /**
     * insert value at the end of the array, grows internal array if needed
     * @param value value to be pushed
     */
    void push(int value);

    /**
     * insert value at index, grows interal array if needed
     *
     * if the index is out of bounds: `index < 0 || index >= this.length()` this method should do nothing
     *
     * @param value value to be inserted at index
     * @param index index at which the value should be inserted
     */
    void insert(int value, int index);

    /**
     * removes the last value in the array and returns it
     * @return returns last value in the array or null if the array is empty
     */
    Integer pop();

    /**
     * removes the value at index and returns it
     * @param index index of value which should be removed
     * @return      value at index or null if
     *              - index < 0 or
     *              - index >= this.length()
     *
     */
    Integer remove(int index);

    /**
     * get the value stored at index
     * @param index index of the value
     * @return      value stored at index or null if
     *              - index < 0 or
     *              - index >= this.length()
     */
    Integer get(int index);

    /**
     * returns the number of elements present in the array
     * @return the number of elements present in the array
     */
    int length();

    /**
     * clear the array
     */
    void clear();
}
