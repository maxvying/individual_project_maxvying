


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

    public class sizeyunsuan {

        public static void main(String[] args)throws IOException
        {

            Random rand = new Random();                         //开随机种子，解决复杂性

            System.out.println("请输入需要的题目数量:");

            Scanner a = new Scanner(System.in);
            //从键盘中输入所需要的题目数量num
            int num = a.nextInt();

            //成功产生所需要数目的运算符号
            //打印出所有随机产生的运算式
            int[] im=new int[num+3];

            String[] numInString = new String[num+ 3];          //创建一个数组存所有算出来的答案
            String[] qs_in = new String[num+ 3];                //创建一个数组存所有随机得到的题目
            for (int i = 0; i < num ; i++) {
                int number1 = rand.nextInt(100) + 1;
                int number2 = rand.nextInt(100) + 1;
                int number3 = rand.nextInt(100) + 1;
                int index = rand.nextInt(3);

                //  System.out.println(string);
                if (index == 2) {
                    int index1 = rand.nextInt(2);
                    String string1 = getOp(index1);
                    String  question=(i +1)+ ":" + number1 + string1 + number2 + "=";
                    System.out.println("四则运算题目" +question);
                    int result1 = calculate1(number1, number2, index1);
                    System.out.println("结果" +( i+1) + ":" + result1);
                    im[i] = result1;
                    qs_in[i]=question;
                } else {
                    int index2 = rand.nextInt(2);
                    String string2 = getOp(index2);
                    int index3 = rand.nextInt(2);
                    String string3 = getOp(index3);
                    String  question= (i +1) + ":" + number1 + string2 + number2 + string3 + number3 + "=";
                    System.out.println("四则运算题目" + question);
                    int midresult = calculate1(number1, number2, index2);
                    int result2 = calculate1(midresult, number3, index3);//用运算符号是1的计算方法算
                    System.out.println("结果" +  (i +1) + ":" + result2);
                    im[i] = result2;
                    qs_in[i]=question;
                }
                System.out.println(im[i]);

                numInString[i] = String.valueOf(im[i]);

            }

           //输出题目存到txt文件里
            FileWriter fw2= new FileWriter("D:\\Exercises.txt");
            BufferedWriter bf2= new BufferedWriter(fw2);
            bf2.write("Exercises are:"+"\n");
            for(int i = 0;i<num;i++){
                bf2.write(qs_in[i]);
                bf2.newLine();
                bf2.flush();
            }
            //输出答案存到txt文件里
            FileWriter fw1 = new FileWriter("D:\\Answers.txt");
            BufferedWriter bf1 = new BufferedWriter(fw1);
            bf1.write("Answers are:"+"\n");
            for(int i = 0;i<num;i++){
                bf1.write((i+1)+":"+numInString[i]);
                bf1.newLine();
                bf1.flush();
            }
        }
        private static int calculate1 ( int a, int b, int index1){
            return switch (index1) {
                case 0 -> a + b;
                case 1 -> a - b;
                default -> 0;
            };
            }

            private static String getOp ( int index2){
                return switch (index2) {
                    case 0 -> "+";
                    case 1 -> "-";
                    default -> "";
                };
            }
        }
    

