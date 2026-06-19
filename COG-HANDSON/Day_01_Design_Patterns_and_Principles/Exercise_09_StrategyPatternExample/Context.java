package day01.exercise09;

public class Context {
    private Strategy strategy;
    public Context(Strategy strategy) { this.strategy = strategy; }
    public void setStrategy(Strategy s) { this.strategy = s; }
    public int executeStrategy(int a,int b) { return strategy.execute(a,b); }
}
