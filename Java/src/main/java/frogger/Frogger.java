package frogger;

/**
 * Refactor Task 1 & 2: Frogger
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22), Duan Liang (F23)
 */
public class Frogger {

    // Field for task 1.
    // private final Road road;
    private int position;
    
    // Field for task 2. Anything to add/change?
    private final Records records;
    private FroggerID froggerID;

    public Frogger(Records records, FroggerID fID, int position) {
        // this.road = road;
        this.position = position;
        this.records = records;
        this.froggerID = fID;
    }

    /**
     * Moves Frogger.
     *
     * @param forward true is move forward, else false.
     * @return true if move successful, else false.
     */
    public boolean move(boolean forward, Road road) {
        int nextPosition = this.position + (forward ? 1 : -1);
        if (!isValid(nextPosition, road) || isOccupied(nextPosition, road)) {
            return false;
        }
        this.position = nextPosition;
        return true;
    }

    // TODO: Do you notice any issues here?
    public boolean isOccupied(int position, Road road) {
        return road.isOccupied(position);
    }
    
    public boolean isValid(int position, Road road) {
        if (position < 0) return false;
        return position < road.getSize();
    }

    /**
     * Records Frogger to the list of records.
     * 
     * @return true if record successful, else false.
     */
    public boolean recordMyself() {
      boolean success = records.addRecord(this.froggerID);
      return success;
    }

}
