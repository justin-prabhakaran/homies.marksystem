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
}
