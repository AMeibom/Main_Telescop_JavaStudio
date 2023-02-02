package com.example.main_telescop_javastudio;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.TextView;

        import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    // задание полей
    float apartmentPrice = 14_000; // астрономический телескоп
    int account = 1_000; // счёт пользователя
    float wage = 2_500; // степендия в месяц
    //int percentFree = 50; // доля заработной платы на любые траты
    float percent = 5; // годовая процентная ставка за вклад
    float[] monthlyPayments = new float[10]; // создание массива накопления в банке
    float z;

    public float sum() {
        return (account+wage)*percent/100/12+(account+wage);
    }

    public int countMonth() {
        z=sum();
        int count = 0;

        while (z<=apartmentPrice) {
            count++;
            monthlyPayments[count-1] = z;
            z = (z + wage)*percent/100/12 + (z + wage);
            ;
        }
        if (z>apartmentPrice) {
            //monthlyPayments[count-1] = z;
            count++;
        }
        return count;
    }

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView countOut; // поле вывода количества месяцев выплаты ипотеки
    private TextView manyMonthOut; // поле выписки по ежемесячным платежам

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        countOut = findViewById(R.id.countOut); // вывод информации количества месяцев выплаты ипотеки
        manyMonthOut = findViewById(R.id.manyMonthOut); // вывод информации выписки по ежемесячным платежам

        // запонение экрана
        // 1) вывод количества месяцев выплаты ипотеки
        countOut.setText("На телескоп придется копить "+ countMonth() + " месяцев");
        // 2) подготовка выписки
        String monthlyPaymentsList = "";
        for(float list : monthlyPayments) {
            if (list > 0) {
                monthlyPaymentsList = monthlyPaymentsList + Float.toString(list) + " монет; ";
            } else {
                break;
            }
        }
        // 3) вывод выписки ежемесячных выплат по ипотеке
        manyMonthOut.setText(monthlyPaymentsList+  " месяц. Накопленна достаточная сумма для покупки ТЕЛЕСКОПА " +z+ " монет!!!" );
    }
}