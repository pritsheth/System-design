import observers.FBIAgenetObserver;

public class FBIAgent implements FBIAgenetObserver {

    private final String name;
    public FBIAgent(String name) throws Exception {
        if(name==null) {
        throw new Exception("FBIAgent With NO Name");
        }
        this.name=name;
    }

    @Override
    public void updateWhenSpaceIs80PercentFull() {

    }
}
