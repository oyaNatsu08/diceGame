package tangenkadai2;

import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        System.out.println("------------------------------");
        System.out.println("サイコロゲームを開始します。");
        System.out.println("------------------------------");
        System.out.println("サイコロを振る回数を指定してください。");

        Scanner sc = new Scanner(System.in);
        //サイコロを振る回数を受け取る
        var num = sc.nextInt();

        //結果を表示するメソッドの呼び出し
        resultGame(num, 1);

        sc.close();
    }

    //ゲームの結果を表示するメソッド
    //引数：num→ダイスを振る回数を値受け渡し count→何回目のゲームかをカウント win→勝利数 lose→敗北数 draw→引き分け数
    public static void resultGame(int num, int count) {
        //各戦歴の初期値を設定
        var win = 0;
        var lose = 0;
        var draw = 0;

        //ゲームを続けるかどうかを判別する変数
        boolean judge = true;

        while (judge) {
            System.out.println("------------------------------");
            System.out.println(count + "回目のゲーム");

            //ダイスを振って合計値を返すメソッドの呼び出し
            System.out.print("あなたの出た目：");
            var mySum = diceRoll(num);
            System.out.print("コンピュータの出た目：");
            var yourSum = diceRoll(num);

            //合計値を比較して勝敗を判定
            if (mySum > yourSum) {
                System.out.println("結果：あなたの勝ちです。");
                win++;
            } else if (mySum == yourSum) {
                System.out.println("結果：引き分けです。");
                draw++;
            } else {
                System.out.println("結果：あなたの負けです。");
                lose++;
            }

            //戦歴を出力
            System.out.println("戦歴：" + win + "勝" + lose + "敗" + draw + "分");
            System.out.println("------------------------------");

            //ゲームを続けるかどうか判定
            judge = checkContinue();
            count++;
        }

        System.out.println("サイコロゲームを終了します。");
    }

    //ダイスを振って合計値を返すメソッド
    public static int diceRoll(int num) {
        var sum = 0;
        for(int i = 1; i <= num; i++) {
            //１～６までのランダムな値を返す
            var dice = Math.round(Math.random() * 5 + 1);
            System.out.print(dice);

            //num未満まで「,」を出力
            if (i != num) {
                System.out.print(",");
            }
            sum += dice;
        }
        System.out.println();
        System.out.println("合計値：" + sum);
        return sum;
    }
    //ゲームを続けるかどうかをチェックするメソッド
    public static boolean checkContinue() {
        System.out.println("ゲームを続けますか？(y/n)");
        Scanner sc = new Scanner(System.in);
        var judge = sc.nextLine();
        if ("n".equals(judge)) {
            return false;
        } else if ("y".equals(judge)) {
            return true;
        } else {
            System.out.println("yまたはnを入力してください。");
            return checkContinue();
        }
    }
}




