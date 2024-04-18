package org.homies;

public class Mark {
    private int mark1;
    private int mark2;
    private int mark3;
    private int mark4;
    private int mark5;
    private int mark6;

    Mark(int mark1, int mark2, int mark3, int mark4, int mark5, int mark6) {
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
        this.mark5 = mark5;
        this.mark6 = mark6;
    }

    Mark() {
        this.mark1 = 0;
        this.mark2 = 0;
        this.mark3 = 0;
        this.mark4 = 0;
        this.mark5 = 0;
        this.mark6 = 0;
    }

    /**
     * Return total marks
     * 
     * @return total
     */

    int getTotal() {
        return this.mark1 + this.mark2 + this.mark3 + this.mark4 + this.mark5 + this.mark6;
    }

    public int getMark1() {
        return mark1;
    }
    public String advice(){
        if(getTotal() < 100) return "Study day and n8";
        else if(getTotal() <= 200 ) return "Try Hard";
        else if(getTotal() <= 300 || getTotal() <=400) return "Keep it up";
        else return "very good";
    }

    public int getMark2() {
        return mark2;
    }

    public int getMark3() {
        return mark3;
    }

    public int getMark4() {
        return mark4;
    }

    public int getMark5() {
        return mark5;
    }

    public int getMark6() {
        return mark6;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }

    public void setMark4(int mark4) {
        this.mark4 = mark4;
    }

    public void setMark5(int mark5) {
        this.mark5 = mark5;
    }

    public void setMark6(int mark6) {
        this.mark6 = mark6;
    }
}
