import java.util.ArrayList;

public class DataManager {
    public ArrayList<State> getStates() {
        return states;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }

    public DataManager(ArrayList<State> states) {

        this.states = states;
    }

    private ArrayList<State> states;
}
