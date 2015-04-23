import org.junit.Test;

/**
 * Created by Jerry on 23-04-2015.
 */
public class FBIAgentTest {

    @Test(expected = Exception.class)
    public void checkIfAgentHasNoName() throws Exception {
        FBIAgent fbiAgent = new FBIAgent(null);

    }

}