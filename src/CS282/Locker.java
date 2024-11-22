package CS282;

public class Locker<T> {
    private T element;
    public void setValue(T element)
    {
        this.element = element;
    }

    public T getValue(){
        return element;
    }

    public static void main(String[] args) {
        Locker<String> string = new Locker<>();
        string.setValue("Hi There!");
        System.out.println(string.getValue());
    }
}
