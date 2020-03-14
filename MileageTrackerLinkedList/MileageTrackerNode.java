

package MileageTrackerLinkedList;

public class MileageTrackerNode {
    private double miles;         // Node data
    private String date;          // Node data
    private MileageTrackerNode nextNodeRef; // Reference to the next node

    public MileageTrackerNode() {
        miles = 0.0;
        date = "";
        nextNodeRef = null;
    }

    // Constructor
    public MileageTrackerNode(double milesInit, String dateInit) {
        this.miles = milesInit;
        this.date = dateInit;
        this.nextNodeRef = null;
    }

    // Constructor
    public MileageTrackerNode(double milesInit, String dateInit, MileageTrackerNode nextLoc) {
        this.miles = milesInit;
        this.date = dateInit;
        this.nextNodeRef = nextLoc;
    }

    /* Insert node after this node.
    Before: this -- next
    After:  this -- node -- next
    */
    public void insertAfter(MileageTrackerNode nodeLoc) {
        MileageTrackerNode tmpNext;

        tmpNext = this.nextNodeRef;
        this.nextNodeRef = nodeLoc;
        nodeLoc.nextNodeRef = tmpNext;
    }

    // Get location pointed by nextNodeRef
    public MileageTrackerNode getNext() {
        return this.nextNodeRef;
    }

    public void printNodeData() {
        System.out.println(this.miles + ", " + this.date);
    }
}
