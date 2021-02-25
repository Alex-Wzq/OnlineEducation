import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Stack<Integer> num = new Stack<Integer>();
        List<Character> sp = new ArrayList<>();
        List<Integer> num1 = new ArrayList<>();


        String[] test = line.split("\\+|-|\\*|\\/");

        for (String i : test){
            num1.add(Integer.parseInt(i));
        }

        if (num1.size() > 0)
        {
            num.push(num1.get(0));
        }
        int num_index = 1;

        for (int i = 0; i < line.length(); i++){
            if (line.charAt(i) == '*' || line.charAt(i) == '/'){
                int temp = num.peek();
                num.pop();
                if (line.charAt(i) == '*'){
                    num.push(temp * num1.get(num_index++));
                }
                else {
                    num.push(temp / num1.get(num_index++));
                }
            } else if (line.charAt(i) == '+' || line.charAt(i) == '-'){
                sp.add(line.charAt(i));
                num.push(num1.get(num_index++));
            }
        }

        Stack<Integer> num2 = new Stack<Integer>();
        while(!num.empty()){
            num2.push(num.peek());
            num.pop();
        }

        int ans = num2.peek();
        for (Character i : sp){
            if (i == '+'){
                ans += num2.peek();
            }
            else{
                ans -= num2.peek();
            }
            num2.pop();
        }

        System.out.println(ans);
    }

//    public void test() {
//        Scanner in = new Scanner(System.in);
//
//        String row = in.nextLine();
//
//        List<Integer> num = new ArrayList<Integer>();
//        List<Character> sp = new ArrayList<Character>();
//        int num_start = 0;
//        int count = 0;
//
//        Character temp = null;
//        for (int i = 0; i < row.length(); i++){
//            if (temp != null && count == 2){
//                if (temp == '*'){
//                    num.set(num.size() - 1, num.get(num.size() - 1) * Integer.parseInt(row.substring(num_start, i)));
//                }
//                else {
//                    num.set(num.size() - 1, num.get(num.size() - 1) / Integer.parseInt(row.substring(num_start, i)));
//                }
//
//                temp = null;
//                count = 0;
//            }
//
//            if (row.charAt(i) == '*' || row.charAt(i) == '/'){
//                temp = row.charAt(i);
//                num.add(Integer.parseInt(row.substring(num_start, i)));
//                num_start = i + 1;
//                count++;
//            } else if (row.charAt(i) == '+' || row.charAt(i) == '-'){
//                num.add(Integer.parseInt(row.substring(num_start, i)));
//                sp.add(row.charAt(i));
//                num_start = i + 1;
//            }
//        }
//
//        int ans = num.get(0);
//        for (int i = 0; i < sp.size(); i++){
//            if (sp.get(i) == '+'){
//                ans += num.get(i);
//            } else{
//                ans -= num.get(i);
//            }
//        }
//
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nextInt();
//
//        }
}
