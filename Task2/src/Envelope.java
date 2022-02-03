public class Envelope {
    private double height;
    private double width;

    public void checkBothEnvelopes(Envelope second){
        if(this.passInto(second)){
            System.out.println("First envelope with sides: \"" + this.getHeight() + "\", \"" + this.getWidth() +
                    "\" pass into second envelope with sides: \"" + second.getHeight() + "\", \"" + second.getWidth() +"\"\n");
        }
        else if(second.passInto(this)){
            System.out.println("Second envelope with sides: \"" + second.getHeight() + "\", \"" + second.getWidth() +
                    "\" pass into first envelope with sides: \"" + this.getHeight() + "\", \"" + this.getWidth() + "\"\n");
        }
        else{
            System.out.println("Neither first nor second envelopes can't be putted in each other \n");
        }
    }

    private boolean passInto(Envelope toCompare){
        double a = this.getHeight();
        double b = this.getWidth();
        double c = toCompare.getHeight();
        double d =
        if((a < c &&  < toCompare.getWidth())
                || (this.getHeight() <  && this.getWidth() < toCompare.getHeight())){
            return true;
        }
        return false;
    }
    // getters and setters
    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
