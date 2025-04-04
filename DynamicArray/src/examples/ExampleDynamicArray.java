package examples;

import interfaces.IDynamicArray;

public class ExampleDynamicArray implements IDynamicArray {

    private int[] buffer;
    private int capacity;
    private int length;

    public ExampleDynamicArray() {
        this.capacity = 1;
        this.length = 0;
        this.buffer = new int[this.capacity];
    }

    /**
     * grows the internal `this.buffer` to double its current size and updates capacity accordingly
     */
    private void grow() {
        int[] newBuffer = new int[this.capacity * 2];

        // copy all old values into the new buffer
        for (int i = 0; i < this.length; i += 1) {
            newBuffer[i] = this.buffer[i];
        }

        // this copy could also be done by the following code
        // System.arraycopy(this.buffer, 0, newBuffer, 0, this.length);

        // update member variables
        this.buffer = newBuffer;
        this.capacity = capacity * 2;
    }

    /**
     * insert value at the end of the array, grows internal array if needed
     *
     * @param value value to be pushed
     */
    @Override
    public void push(int value) {
        // check if we need to grow internal buffer
        if (this.length >= this.capacity) {
            this.grow();
        }

        // note: if we update this.length correctly this.buffer[this.length] will always be the first unused position
        //       in the buffer
        this.buffer[this.length] = value;
        this.length += 1;
    }

    /**
     * insert value at index, grows internal array if needed
     * <p>
     * if the index is out of bounds: `index < 0 || index >= this.length()` this method should do nothing
     *
     * @param value value to be inserted at index
     * @param index index at which the value should be inserted
     */
    @Override
    public void insert(int value, int index) {
        // check if index is in bounds
        if (index < 0) {
            return;
        }
        if (index >= this.length) {
            return;
        }

        // make sure we have enough space for at least one more value in our array
        if (this.length >= this.capacity) {
            this.grow();
        }

        // copy every value in this.buffer one position to the right
        for (int i = this.length - 1; i >= index; i -= 1) {
            this.buffer[i + 1] = this.buffer[i];
        }

        // note: we copy the values starting with the last value otherwise we would override
        //       every value with the value at index

        // we could replace the copy loop with the following line
        // System.arraycopy(this.buffer, index, this.buffer, index + 1, this.length - index);

        // insert value and update length
        this.buffer[index] = value;
        this.length += 1;
    }

    /**
     * removes the last value in the array and returns it
     *
     * @return returns last value in the array or null if the array is empty
     */
    @Override
    public Integer pop() {
        // check if array is empty
        if (this.length == 0) {
            return null;
        }

        // store last value for later return
        int value = this.buffer[this.length - 1];

        // update length
        this.length -= 1;

        return value;
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
        // check if index is in bounds
        if (index < 0) {
            return null;
        }

        if (index >= this.length) {
            return null;
        }

        // store value for later return
        int value = this.buffer[index];

        // move every element starting from buffer[index + 1] on position to the left
        for (int i = index; i < this.length - 1; i += 1) {
            this.buffer[i] = this.buffer[i + 1];
        }

        // note: this loop could be replaced by the following line
        // System.arraycopy(this.buffer, index + 1, this.buffer, index, this.length - index);

        // update length
        this.length -= 1;

        return value;
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
        // check if index is in bounds
        if (index < 0) {
            return null;
        }
        if (index >= this.length) {
            return null;
        }

        return this.buffer[index];
    }

    /**
     * returns the number of elements present in the array
     *
     * @return the number of elements present in the array
     */
    @Override
    public int length() {
        return this.length;
    }

    /**
     * clear the array
     */
    @Override
    public void clear() {
        // we can just set the length to zero and ignore elements currently stored in buffer

        // note: we could also write a private method which can shrink down the internal buffer to some smaller
        //       size, this method could also be used in remove and pop to save memory if we have too many 'empty'
        //       indices in our buffer
        //
        //      this is left as an exercise to the reader as it would not change the interface
        this.length = 0;
    }
}
