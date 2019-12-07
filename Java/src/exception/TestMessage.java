package exception;

public class TestMessage {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        try{
            System.out.println(arr[3]);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("=======================");
            System.out.println(e.toString());
            System.out.println("=======================");
            e.printStackTrace();
        }
    }
}
