package cn.pointw.werewolfassistant;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class OnGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_game);
        Intent intent = getIntent();
        CharacterSetting characterSetting = (CharacterSetting) intent.getSerializableExtra("characterSetting");
        GridLayout layout = (GridLayout) findViewById(R.id.playerLayout);

        int row = 0;
        int col = 0;
        for (int i = 0; i<characterSetting.getPlayerNumber(); i++){
            final Button button = new Button(this);
            button.setText(Integer.toString(i+1));
            button.setId(i);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Dialog dialog = new AlertDialog
                            .Builder(OnGameActivity.this)
                            .setTitle("请选择该玩家的身份")
                            .setSingleChoiceItems(new String[]{"狼人", "平民", "女巫", "预言家", "猎人", "白痴"}, 0,
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int j) {
                                            TextView tv = (TextView) OnGameActivity.this.findViewById(button.getId()+100);
                                            switch (j){
                                                case 0:
                                                    tv.setText("狼人");
                                                    tv.setTextColor(Color.RED);
                                                    break;
                                                case 1:
                                                    tv.setText("平民");
                                                    tv.setTextColor(Color.YELLOW);
                                                    break;
                                                case 2:
                                                    tv.setText("女巫");
                                                    tv.setTextColor(getResources().getColor(R.color.tomato));
                                                    break;
                                                case 3:
                                                    tv.setText("预言家");
                                                    tv.setTextColor(getResources().getColor(R.color.orchid));
                                                    break;
                                                case 4:
                                                    tv.setText("猎人");
                                                    tv.setTextColor(Color.GREEN);
                                                    break;
                                                case 5:
                                                    tv.setText("白痴");
                                                    tv.setTextColor(getResources().getColor(R.color.lightpink));
                                                    break;
                                            }
                                        }
                                    }).setNegativeButton("取消", null).show();
                }
            });
            GridLayout.LayoutParams bParam = new GridLayout.LayoutParams();
            bParam.rowSpec = GridLayout.spec(row);
            bParam.columnSpec = GridLayout.spec(col);
            layout.addView(button, bParam);

            TextView textView = new TextView(this);
            textView.setText("未知");
            textView.setId(100+i);
            GridLayout.LayoutParams tParam = new GridLayout.LayoutParams();
            tParam.rowSpec = GridLayout.spec(row+1);
            tParam.columnSpec = GridLayout.spec(col);
            layout.addView(textView, tParam);

            col++;
            if (col >= layout.getColumnCount()){
                col = 0;
                row += 2;
            }
        }
    }
}
