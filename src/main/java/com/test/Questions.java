package com.test;

import java.util.*;
import java.util.stream.IntStream;

public class Questions {
    public static void main(String[] args) {
        Calculator calc1 = (a,b)-> a*b;

        int[] arr = {762,54,35435,646};
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(nums,
                (o1, o2)->{
                    if(Integer.bitCount(o1)==Integer.bitCount(o2)){
                        return o1-o2;
                    } else{
                        return Integer.bitCount(o1)-Integer.bitCount(o2);
                    }
                });
        Arrays.stream(nums).mapToInt(Integer::intValue).toArray();

        System.out.println("XOR: " + (5^7^2^3^1));

        //System.out.println(calc.calculate(10,20));

        MyNumber myNumber1 = new MyNumber(10l, 20l);
        MyNumber myNumber2 = new MyNumber(10l, 20l);

        System.out.println((myNumber1==myNumber2) + "  " + (myNumber1.equals(myNumber2)));

        List<MyNumber> list = new ArrayList<>();
        list.add(new MyNumber(100l,200l));
        list.add(new MyNumber(300l,200l));
        list.add(new MyNumber(3l,50l));
        list.add(new MyNumber(600l,200l));
        list.add(new MyNumber(40l,2000l));
        list.add(new MyNumber(80l,9l));

        Calculator calc2 = (a,b)-> a+b;

        Calculator calc3 = Utility::addition;

        System.out.println(calc3.calculate(10,20));

        Optional<MyNumber> optionalMyNumber= list.stream().findFirst();
        if(optionalMyNumber.isPresent()){
            System.out.println(optionalMyNumber.get());
        }
        /*String s1= new String("ABC");
        String s2 = new String("ABC");
        s1="ABC";
        s2="ABC";
        System.out.println(s1==s2);*/
    }
}

class MyNumber{
    private Long firstNum;
    private Long secondNum;

    public MyNumber(Long firstNumber, Long secondNumber){
        this.firstNum = firstNumber;
        this.secondNum = secondNumber;
    }

    public Long process(Calculator calculator){
        return calculator.calculate(firstNum, secondNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyNumber myNumber = (MyNumber) o;
        return Objects.equals(firstNum, myNumber.firstNum) && Objects.equals(secondNum, myNumber.secondNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNum, secondNum);
    }

    @Override
    public String toString() {
        return "MyNumber{" +
                "firstNum=" + firstNum +
                ", secondNum=" + secondNum +
                '}';
    }
}
@FunctionalInterface
interface Calculator{
    long calculate(long num1, long num2);
}

class Utility{
    static long multiplication(long a , long b){
        return a * b;
    }

    static long addition(long a , long b){
        return a + b;
    }
}
