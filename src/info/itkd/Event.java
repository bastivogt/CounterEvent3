package info.itkd;

public class Event<T> {

    private T src;

    public Event(T src) {
        this.src = src;
    }

    public T getSrc() {
        return src;
    }
}
