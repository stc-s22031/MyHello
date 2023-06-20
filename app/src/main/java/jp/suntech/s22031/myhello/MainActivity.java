package jp.suntech.s22031.myhello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン・オブジェクトの用意
        Button btClick=findViewById(R.id.btClick);
        //リスナ・オブジェクトの用意
        HelloListener listener=new HelloListener();
        //ボタンにリスナを設定
        btClick.setOnClickListener(listener);
        //クリアボタンであるButtonオブジェクトを取得
        Button btClear=findViewById(R.id.btClear);
        //クリアボタンにリスナを設定
        btClear.setOnClickListener(listener);
    }

    //ボタンをクリックした時のリスナクラス
    private class HelloListener implements View.OnClickListener{


        @Override
        public void onClick(View view) {
            //名前入力欄にあるEditTextオブジェクトを取得
            EditText input=findViewById(R.id.etName);
            //メッセージを表示するTextViewオブジェクトを取得
            TextView output=findViewById(R.id.tvOutput);

            //タップされた画面部分のIdのR値を取得
            int id =view.getId();
            //IDのR値に応じて処理を分岐
            switch (id){
                //表示ボタンの場合
                case R.id.btClick:
                    //入力された名前の文字列を取得
                    String inputStr=input.getText().toString();
                    //メッセージを表示
                    output.setText(inputStr+"さん、こんにちは！");
                    break;
                    //クリアボタンの場合
                case R.id.btClear:
                    //名前入力欄を空文字に設定
                    input.setText("");
                    //メッセージ表示ランを空文字に設定
                    output.setText("");
                    break;
            }



            /*
            TextView output=findViewById(R.id.tvOutput);
            String inputStr=input.getText().toString();
            output.setText(inputStr+"さん、こんにちは！");*/
        }
    }
}