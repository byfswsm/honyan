package com.qcby.hongyanredenvelopes.util;

public class CommonUtil {
    public static int openPack(int status, int amount) {
        if (amount == status) {
            return 1;
        }
        if (status == 1) {
            return amount;
        }
        int openMoney = (int) (Math.random() * (amount - status));
        if (openMoney < 1 || openMoney > (amount / status) * 2) {
            openMoney = openPack(status, amount);
        }
        return openMoney;
    }

//
//    public static void main(String[] args) {
//        int[] arr = new int[10];
//        for (int i = 0 ;i<10;i++){
//            arr[i] = openPack(15,20);
//        }
//        int money = openPack(3,20);
//        System.out.println(Arrays.toString(arr));
//    }
//
}
