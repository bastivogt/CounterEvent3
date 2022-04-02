package info.itkd;

public class Counter {

    private int start, finish, step, count;

    private ICounterHandler counterStartHandler = null;
    private ICounterHandler counterChangeHandler = null;
    private ICounterHandler counterFinishHandler = null;

    public Counter(int start, int finish, int step) {
        this.reset(start, finish, step);
    }

    public Counter(int start, int finish) {
        this(start, finish, 1);
    }

    public Counter(int start) {
        this(start, 10, 1);
    }

    public Counter() {
        this(0, 10, 1);
    }


    public int getCount() {
        return this.count;
    }

    public void setCounterStartHandler(ICounterHandler counterStartHandler) {
        this.counterStartHandler = counterStartHandler;
    }

    public void setCounterChangeHandler(ICounterHandler counterChangeHandler) {
        this.counterChangeHandler = counterChangeHandler;
    }

    public void setCounterFinishHandler(ICounterHandler counterFinishHandler) {
        this.counterFinishHandler = counterFinishHandler;
    }



    public void removeCounterStartHandler() {
        this.counterStartHandler = null;
    }

    public void removeCounterChangeHandler() {
        this.counterChangeHandler = null;
    }

    public void removeCounterFinishHandler() {
        this.counterFinishHandler = null;
    }



    public void fireCounterStartEvent(Event<Counter> evt) {
        if(this.counterStartHandler != null) {
            this.counterStartHandler.handle(evt);
        }
    }

    public void fireCounterChangeEvent(Event<Counter> evt) {
        if(this.counterChangeHandler != null) {
            this.counterChangeHandler.handle(evt);
        }
    }

    public void fireCounterFinishEvent(Event<Counter> evt) {
        if(this.counterFinishHandler != null) {
            this.counterFinishHandler.handle(evt);
        }
    }

    public void run() {
        this.count = this.start;
        this.fireCounterStartEvent(new Event<Counter>(this));
        for(; this.count < this.finish; this.count += this.step) {
            this.fireCounterChangeEvent(new Event<Counter>(this));
        }
        this.fireCounterFinishEvent(new Event<Counter>(this));
    }

    public void reset(int start, int finish, int step) {
        this.start = start;
        this.finish = finish;
        this.step = step;
        this.count = this.start;
    }


}
