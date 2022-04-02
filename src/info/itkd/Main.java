package info.itkd;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();

        counter.setCounterStartHandler((Event<Counter> evt) -> {
            System.out.println("COUNTER_START: " + evt.getSrc().getCount());
        });

        counter.setCounterChangeHandler((Event<Counter> evt) -> {
            System.out.println("COUNTER_CHANGE: " + evt.getSrc().getCount());
        });

        /*counter.setCounterFinishHandler((Event<Counter> evt) -> {
            System.out.println("COUNTER_Finish: " + evt.getSrc().getCount();
        });*/

        counter.setCounterFinishHandler(new ICounterHandler() {
            @Override
            public void handle(Event<Counter> evt) {
                System.out.println("COUNTER_FINISH (Anonymous Class): " + evt.getSrc().getCount());
            }
        });

        counter.run();
    }
}
