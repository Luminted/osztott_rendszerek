import java.util.*;

class Gyakorlas{
    public static void main(String args[]){
        int s = 0;
        //Arrays.sort(args);
        for(int i = args.length - 1; i >= 0; i--){
            //s+= Integer.parseInt(args[i]);
            System.out.print(args[i] + " ");
        }
        //System.out.print("Összeg: " + s);
        //System.out.print(Fibonacci(Integer.parseInt(args[0])));
        //Oszto(Integer.parseInt(args[0]));
        System.out.print(Lengyel(args));
    }

    public static int Fibonacci(int n){

        if(n == 1){
            return 1;
        }
        return Fibonacci(n-2) + Fibonacci(n-1);
    }

    public static void Oszto (int n){
        for(int i = 1; i <= (n/2); i++){
            if(n % i == 0){
                System.out.print(i + " ");
            }
        }
    }

    public static int Lengyel(String args[]){
        Stack<Integer> operands  = new Stack<>();
        Stack<String> operators = new Stack<>();
        int sum = 0;

        for(String arg : args){
            try{
                int n = Integer.parseInt(arg);
                operands.push(n);
            }catch(NumberFormatException e){
                operators.push(arg);
            }
        }

        sum = operands.pop();
        while(!operators.empty()){
            if(operators.pop() == "+"){
                sum += operands.pop();
                break;
            }else if(operators.pop() == "-"){
                sum -= operands.pop();
                break;
            }else if(operators.pop() == "*"){
                sum *= operands.pop();
                break;
            }else if(operators.pop() == "/"){
                sum /= operands.pop();
                break;
            };
        }
        return sum;
    }


}