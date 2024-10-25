package telran.interview;


//all methods must have complexity O[1]
public class MyArray<T> {

	private T[] array;
    private T defaultValue; 
    private boolean isSetAll = false;

    public void setAll(T value) {
        defaultValue = value;
        isSetAll = true; 
    }

    public void set(int index, T value) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = value;
        isSetAll = false; 
    }
	
    public T get(int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return isSetAll ? defaultValue : array[index];
    }
	
    @SuppressWarnings("unchecked")
    public MyArray(int size) {
        array = (T[]) new Object[size]; 
    }
}