public class Envelope {
    private double height;
    private double width;
    public Envelope(double height, double width){
        this.height = height;
        this.width = width;
    }
    private boolean passInto(Envelope toCompare){
        if(toCompare.getHeight() > this.getHeight()){
            if(toCompare.getWidth() > this.getWidth()){
                return true;
            }
        }
        else{
            if(toCompare.getHeight() > this.getWidth()){
                if(toCompare.getWidth() > this.getHeight()){
                    return true;
                }
            }
        }
        return false;
    }

    public void checkBothEnvelopes(Envelope second){
        if(this.passInto(second)){
            System.out.println("First envelope with sides: \"" + this.getHeight() + "\", \"" + this.getWidth() +
            "\" pass into second envelope with sides: \"" + second.getHeight() + "\", \"" + second.getWidth() +"\"");
            System.out.println();
        }
        else if(second.passInto(this)){
            System.out.println("Second envelope with sides: \"" + second.getHeight() + "\", \""
                    + second.getWidth() + "\"" +
                    " pass into first envelope with sides: \"" + this.getHeight() + "\", \"" + this.getWidth() + "\"");
            System.out.println();
        }
        else{
            System.out.println("Neither first nor second envelopes can't be putted in each other");
            System.out.println();
        }
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
