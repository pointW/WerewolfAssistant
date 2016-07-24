package cn.pointw.werewolfassistant;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OnGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_game);
        Intent intent = getIntent();
        CharacterSetting characterSetting = (CharacterSetting) intent.getSerializableExtra("characterSetting");
        final String[] characterString = createCharacterString(characterSetting);
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
                            .setSingleChoiceItems(characterString, 0,
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int j) {
                                            TextView tv = (TextView) OnGameActivity.this.findViewById(button.getId()+100);
                                            setTextView(tv, characterString, j);
                                        }
                                    }).show();
                }
            });
            button.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Dialog dialog = new AlertDialog
                            .Builder(OnGameActivity.this)
                            .setTitle("请选择操作")
                            .setSingleChoiceItems(new String[]{"设置情侣", "设置死亡", "设置存活"}, 0,
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            switch (i){
                                                case 0:
                                                    if (button.getText().toString().contains("情")){
                                                        button.setText(Integer.toString(button.getId()+1));
                                                        button.setTextColor(Color.BLACK);
                                                    }
                                                    else {
                                                        button.setText(Integer.toString(button.getId()+1)+"情");
                                                        button.setTextColor(getResources().getColor(R.color.royalblue));
                                                    }
                                                    break;
                                                case 1:
                                                    button.setTextColor(Color.LTGRAY);
                                                    break;
                                                case 2:
                                                    button.setTextColor(Color.BLACK);
                                                    break;
                                            }
                                        }
                                    }).show();
                    return true;
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
        Button newGameButton = (Button) findViewById(R.id.newGameButton);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new AlertDialog
                        .Builder(OnGameActivity.this)
                        .setTitle("提示")
                        .setMessage("确认开始新游戏?")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                OnGameActivity.this.finish();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //写下你希望按下返回键达到的效果代码，不写则不会有反应
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private String[] createCharacterString(CharacterSetting characterSetting){
        String[] characterString = new String[characterSetting.getGodCharacter().size()+2];
        characterString[0] = "狼人";
        characterString[1] = "平民";
        for(int i = 2; i < characterString.length; i++){
            characterString[i] = Globals.getGodString(characterSetting.getGodCharacter().get(i-2));
        }
        return characterString;
    }

    private void setTextView(TextView textView, String[] characterString, int i){
        textView.setText(characterString[i]);
        switch (characterString[i]){
            case "平民":
                textView.setTextColor(Color.BLACK);
                break;
            case "狼人":
                textView.setTextColor(Color.RED);
                break;
            case "女巫":
                textView.setTextColor(getResources().getColor(R.color.tomato));
                break;
            case "预言家":
                textView.setTextColor(getResources().getColor(R.color.orchid));
                break;
            case "猎人":
                textView.setTextColor(Color.GREEN);
                break;
            case "白痴":
                textView.setTextColor(getResources().getColor(R.color.lightpink));
                break;
            case "长老":
                textView.setTextColor(getResources().getColor(R.color.darkolivegreen));
                break;
            case "丘比特":
                textView.setTextColor(getResources().getColor(R.color.royalblue));
                break;
            case "守卫":
                textView.setTextColor(getResources().getColor(R.color.lightskyblue));
                break;
        }
    }
}
