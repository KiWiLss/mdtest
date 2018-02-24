package com.magicsoft.qiuitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.magicsoft.qiuitest.bank.BankInfo;
import com.magicsoft.qiuitest.bank.BankInfoBean;

public class MainActivity extends AppCompatActivity {

    private TextView mTvOne;
    private EditText etBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTvOne = (TextView) findViewById(R.id.tv_main_one);
        etBank = (EditText) findViewById(R.id.et_main_bank);


    }

    /**校验过程：
     1、从卡号最后一位数字开始，逆向将奇数位(1、3、5等等)相加。
     2、从卡号最后一位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，将个位十位数字相加，即将其减去9），再求和。
     3、将奇数位总和加上偶数位总和，结果应该可以被10整除。
     * 校验银行卡卡号
     */
    public  boolean checkBankCard(String bankCard) {
        if(bankCard.length() < 15 || bankCard.length() > 19) {
            return false;
        }
        char bit = getBankCardCheckCode(bankCard.substring(0, bankCard.length() - 1));
        if(bit == 'N'){
            return false;
        }
        return bankCard.charAt(bankCard.length() - 1) == bit;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhn 校验算法获得校验位
     * @param nonCheckCodeBankCard
     * @return
     */
    public  char getBankCardCheckCode(String nonCheckCodeBankCard){
        if(nonCheckCodeBankCard == null || nonCheckCodeBankCard.trim().length() == 0
                || !nonCheckCodeBankCard.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeBankCard.trim().toCharArray();
        int luhmSum = 0;
        for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if(j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');
    }

    public void second(View view) {
        //卡号
        char[] cardNumber = {'6', '2', '2', '8', '4', '8', '0'};

        //获取银行卡的信息
        String nameOfBank = BankInfo.getNameOfBank(cardNumber, 0);
        Log.e("MMM", "second: "+nameOfBank );

        String bank = etBank.getText().toString();
        if (bank!=null&&checkBankCard(bank)) {
            BankInfoBean bankinfobean = new BankInfoBean(bank);

            Log.e("MMM", "second: "+bankinfobean.getBankName()+"||"+bankinfobean.getCardType() );
        }else {
            Log.e("MMM", "second: "+bank);
        }


    }
}
