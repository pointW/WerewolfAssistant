package cn.pointw.werewolfassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class CharacterSettingActivity extends AppCompatActivity {
    private EditText playerNumberText;
    private Button numberConfirmButton;
    private TextView civilianView;
    private Switch hunterSwitch;
    private Switch seerSwitch;
    private Switch witchSwitch;
    private Switch idiotSwitch;
    private Switch elderSwitch;
    private Switch cupidSwitch;
    private Switch guardSwitch;

    private CharacterSetting characterSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_setting);
        characterSetting = new CharacterSetting();

        playerNumberText = (EditText) findViewById(R.id.playerNumber);
        numberConfirmButton = (Button) findViewById(R.id.numberConfirmButton);
        civilianView = (TextView) findViewById(R.id.civilian);
        hunterSwitch = (Switch) findViewById(R.id.hunterSwitch);
        seerSwitch = (Switch) findViewById(R.id.seerSwitch);
        witchSwitch = (Switch) findViewById(R.id.witchSwitch);
        idiotSwitch = (Switch) findViewById(R.id.idiotSwitch);
        elderSwitch = (Switch) findViewById(R.id.elderSwitch);
        cupidSwitch = (Switch) findViewById(R.id.cupidSwitch);
        guardSwitch = (Switch) findViewById(R.id.guardSwitch);


        findViewById(R.id.startGameButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CharacterSettingActivity.this, OnGameActivity.class);
                intent.putExtra("characterSetting", characterSetting);
                startActivity(intent);
            }
        });

        numberConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                characterSetting.setPlayerNumber(Integer.parseInt(playerNumberText.getText().toString()));
                characterSetting.setWerewolfNumber((int)Math.floor(characterSetting.getPlayerNumber()/3));
                adjustCivilianNumber();
            }
        });

        hunterSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                characterSetting.addGod(Globals.God.Hunter,b);
                adjustCivilianNumber();
            }
        });
        seerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                characterSetting.addGod(Globals.God.Seer, b);
                adjustCivilianNumber();
            }
        });
        witchSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                characterSetting.addGod(Globals.God.Witch, b);
                adjustCivilianNumber();
            }
        });
        idiotSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                characterSetting.addGod(Globals.God.Idiot, b);
                adjustCivilianNumber();
            }
        });
        elderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                characterSetting.addGod(Globals.God.Elder, b);
                adjustCivilianNumber();
            }
        });
        cupidSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                characterSetting.addGod(Globals.God.Cupid, b);
                adjustCivilianNumber();
            }
        });
        guardSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                characterSetting.addGod(Globals.God.Guard, b);
                adjustCivilianNumber();
            }
        });
    }

    public void adjustCivilianNumber(){
        characterSetting.setCivilianNumber(
                characterSetting.getPlayerNumber() - characterSetting.getGodNumber() - characterSetting.getWerewolfNumber());
        civilianView.setText(Integer.toString(characterSetting.getCivilianNumber()));
    }
}
