import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.IOException;
import java.lang.Integer;
import java.util.ArrayList;

/**
 * Created by David on 31/05/2017.
 */
public class Test_Parser {
    public static void main(String[] args) throws IOException{
        Document doc = Jsoup.connect("https://www.openanswers.co.uk/careers/join-us").get();
        String sum = doc.getElementsByClass("main_text").text();
        System.out.println(sum);
        String[] sumSplit = sum.split("\\s");
        sumSplit[7] = null;

        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < sumSplit.length; i+=2){
            int num = Integer.parseInt(sumSplit[i]);
            nums.add(num);
        }

        int total = 0;
        if(sumSplit[1].equals("*") && sumSplit[3].equals("*") && sumSplit[5].equals("*")){
            total = nums.get(0)*nums.get(1)*nums.get(2)*nums.get(3);
            System.out.println(total);
        }
        else if(sumSplit[1].equals("*") && !(sumSplit[3].equals("*") && sumSplit[5].equals("*"))) {
            total = nums.get(0) * nums.get(1);
            if (sumSplit[3].equals("+") && sumSplit[5].equals("+")) {
                total = total + nums.get(2) + nums.get(3);
                System.out.println(total);
            } else if (sumSplit[3].equals("+") && sumSplit[5].equals("-")) {
                total = total + nums.get(2) - nums.get(3);
                System.out.println(total);
            } else if (sumSplit[3].equals("-") && sumSplit[5].equals("+")) {
                total = total - nums.get(2) + nums.get(3);
                System.out.println(total);
            } else if (sumSplit[3].equals("-") && sumSplit[5].equals("-")) {
                total = total - nums.get(2) - nums.get(3);
                System.out.println(total);
            }
        }
        else if(sumSplit[1].equals("*") && sumSplit[3].equals("*") && !(sumSplit[5].equals("*"))){
            total = nums.get(0) * nums.get(1) * nums.get(2);
            if(sumSplit[5].equals("+")){
                total = total + nums.get(3);
                System.out.println(total);
            } else if(sumSplit[5].equals("-")){
                total = total - nums.get(3);
                System.out.println(total);
            }
        }
        else if(!(sumSplit[1].equals("*")) && sumSplit[3].equals("*") && !(sumSplit[5].equals("*"))){
            if(sumSplit[1].equals("+") && sumSplit[5].equals("+")){
                total = nums.get(0) + nums.get(1) * nums.get(2) + nums.get(3);
                System.out.println(total);
            }
            else if(sumSplit[1].equals("+") && sumSplit[5].equals("-")){
                total = nums.get(0) + nums.get(1) * nums.get(2) - nums.get(3);
                System.out.println(total);
            }
            else if(sumSplit[1].equals("-") && sumSplit[5].equals("-")){
                total = nums.get(0) - nums.get(1) * nums.get(2) - nums.get(3);
                System.out.println(total);
            } else if(sumSplit[1].equals("-") && sumSplit[5].equals("+")){
                total = nums.get(0) - nums.get(1) * nums.get(2) + nums.get(3);
                System.out.println(total);
            }
        }
        else if(!(sumSplit[1].equals("*")) && sumSplit[3].equals("*") && sumSplit[5].equals("*")){
            if(sumSplit[1].equals("+")){
                total = nums.get(0) + nums.get(1) * nums.get(2) * nums.get(3);
                System.out.println(total);
            }
            else if(sumSplit[1].equals("-")){
                total = nums.get(0) - nums.get(1) * nums.get(2) * nums.get(3);
                System.out.println(total);
            }
        }
        else if(!(sumSplit[1].equals("*") && sumSplit[3].equals("*") && sumSplit[5].equals("*"))){
            if(sumSplit[1].equals("+") && sumSplit[3].equals("+") && sumSplit[5].equals("+")){
                total = nums.get(0) + nums.get(1) + nums.get(2) + nums.get(3);
                System.out.println(total);
            }
            else if(sumSplit[1].equals("+") && sumSplit[3].equals("-") && sumSplit[5].equals("-")){
                total = nums.get(0) + nums.get(1) - nums.get(2) - nums.get(3);
                System.out.println(total);
            }
            else if(sumSplit[1].equals("+") && sumSplit[3].equals("+") && sumSplit[5].equals("-")){
                total = nums.get(0) + nums.get(1) + nums.get(2) - nums.get(3);
                System.out.println(total);
            }
            else if(sumSplit[1].equals("+") && sumSplit[3].equals("-") && sumSplit[5].equals("+")){
                total = nums.get(0) + nums.get(1) - nums.get(2) + nums.get(3);
                System.out.println(total);
            }
            else if(sumSplit[1].equals("-") && sumSplit[3].equals("-") && sumSplit[5].equals("-")){
                total = nums.get(0) - nums.get(1) - nums.get(2) - nums.get(3);
                System.out.println(total);
            }
            else if(sumSplit[1].equals("-") && sumSplit[3].equals("+") && sumSplit[5].equals("+")){
                total = nums.get(0) - nums.get(1) + nums.get(2) + nums.get(3);
                System.out.println(total);
            }
            else if(sumSplit[1].equals("-") && sumSplit[3].equals("-") && sumSplit[5].equals("+")){
                total = nums.get(0) - nums.get(1) - nums.get(2) + nums.get(3);
                System.out.println(total);
            }
            else if(sumSplit[1].equals("-") && sumSplit[3].equals("+") && sumSplit[5].equals("-")){
                total = nums.get(0) - nums.get(1) + nums.get(2) - nums.get(3);
                System.out.println(total);
            }
        }
    }
}
