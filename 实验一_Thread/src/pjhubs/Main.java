package pjhubs;

import pjhubs.ThreadClass;

public class Main {

    public static void main(String[] args) throws Exception {
        ThreadClass t1 = new ThreadClass("pjThread");
        t1.start();
    }
}
