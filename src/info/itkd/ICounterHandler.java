package info.itkd;

@FunctionalInterface
public interface ICounterHandler {
    void handle(Event<Counter> evt);
}
