package com.practice.robolectric;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.practice.atf.R;
import com.practice.atf.StartUpActivity;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class StartUpActivityTest {
    private StartUpActivity activity;
    private Button pressMeButton;
    private EditText firstField;
    private EditText secondField;
    private TextView resultView;

    @Before
    public void setUp() throws Exception {
        activity = new StartUpActivity();
        activity.onCreate(null);

        firstField = (EditText) activity.findViewById(R.id.EditText01);
        secondField = (EditText) activity.findViewById(R.id.EditText02);
        pressMeButton = (Button) activity.findViewById(R.id.Button01);
        resultView = (TextView) activity.findViewById(R.id.TextView01);
    }

    @Test
    public void shouldUpdateResultsWhenButtonIsClicked() throws Exception {
        firstField.setText("10");
        secondField.setText("20");
        pressMeButton.performClick();

        String resultsText = resultView.getText().toString();
        assertThat(resultsText, equalTo("200.0"));
    }
}