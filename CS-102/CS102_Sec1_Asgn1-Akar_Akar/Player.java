public class Player {
    private int queue;
    private String symbol;
    private int place;
    private int diceNum;
    private int totalMoves;
    private int totalTraps;
    private int widthCor;
    private int heightCor;
    private int corInBox;


    public Player(String symbol){
        this.symbol = symbol;
        
        setPlace(0);
        setDiceNum(0);
        this.totalMoves = 0;
        this.totalTraps = 0;
        heightCor = 1;
        widthCor = 1;
        
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getDiceNum() {
        return diceNum;
    }

    public void setDiceNum(int diceNum) {
        this.diceNum = diceNum;
    }
    
    public int compareDice(Player p){
        if(this.diceNum == p.diceNum){
            return 1;
        }
        return 0;
    }

    public int getTotalMoves() {
        return totalMoves;
    }

    public void incrementTotalMoves() {
        this.totalMoves += 1;
    }

    public int getTotalTraps() {
        return totalTraps;
    }

    public void incrementTotalTraps() {
        this.totalTraps += 1;
    }

    public int getWidthCor() {
        return widthCor;
    }

    public void setWidthCor(int widthCor) {
        this.widthCor = widthCor;
    }

    public int getHeightCor() {
        return heightCor;
    }

    public void setHeightCor(int heightCor) {
        this.heightCor = heightCor;
    }
    public void updateCorInBox(int n){
        corInBox = n;
    }
    public int getCorInBox(){
        return corInBox;
    }
    
}
