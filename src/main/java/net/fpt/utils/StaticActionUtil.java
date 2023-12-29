package net.fpt.utils;

public class StaticActionUtil {
    /** Hàm chờ cố định khi
     * author: minhlh5
     * @param milliseconds
     * */
    public static void sleepTo(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
