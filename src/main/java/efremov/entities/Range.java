package efremov.entities;

import com.epam.commons.DataClass;

public class Range extends DataClass {

    public int from;
    public int to;

    public Range(int from, int to){
        this.from = from;
        this.to = to;
    }
}
