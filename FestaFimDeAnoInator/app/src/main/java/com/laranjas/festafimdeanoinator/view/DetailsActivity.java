package com.laranjas.festafimdeanoinator.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.laranjas.festafimdeanoinator.R;
import com.laranjas.festafimdeanoinator.constants.FimDeAnoConstant;
import com.laranjas.festafimdeanoinator.data.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);

        loadDataFromActivity();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.check_participate){
            if(mViewHolder.checkParticipate.isChecked()) {
                mSecurityPreferences.storageString(FimDeAnoConstant.PRESENCE_KEY, FimDeAnoConstant.CONFIRMATION_YES);
                Toast.makeText(this, "CONFIRMADO", Toast.LENGTH_SHORT).show();
            } else {
                mSecurityPreferences.storageString(FimDeAnoConstant.PRESENCE_KEY, FimDeAnoConstant.CONFIRMATION_NO);
                Toast.makeText(this, "NÃO CONFIRMADO", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void loadDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String presence = extras.getString(FimDeAnoConstant.PRESENCE_KEY);
            if(presence != null && presence.equals(FimDeAnoConstant.CONFIRMATION_YES)) {
                this.mViewHolder.checkParticipate.setChecked(true);
            } else {
                this.mViewHolder.checkParticipate.setChecked(false);
            }
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}
