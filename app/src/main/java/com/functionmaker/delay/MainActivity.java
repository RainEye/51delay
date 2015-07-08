package com.functionmaker.delay;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private EditText firstLoop, secondLoop, thirdLoop;
    private Button calcButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstLoop = (EditText) findViewById(R.id.firstLoop);
        secondLoop = (EditText) findViewById(R.id.secondLoop);
        thirdLoop = (EditText) findViewById(R.id.thirdLoop);
        calcButton = (Button) findViewById(R.id.calcButton);
        resultTextView = (TextView) findViewById(R.id.result);
        calcButton.setOnClickListener(new MyOnClickListener());
    }

    public int convertToInt(String info) {
        if (info == null || info.equals("")) {
            return -1;
        } else {
            return Integer.parseInt(info);
        }
    }

    public long calculate(int firstLoopNum, int secondLoopNum, int thirdLoopNum) {
        if (firstLoopNum == -1 && secondLoopNum != -1&&thirdLoopNum!=-1) {//第一层循环为空,第二层循环不为空，第三层循环不为空
            return ((thirdLoopNum * 2) + 3) * secondLoopNum + 5;
        } else if (secondLoopNum == -1 && firstLoopNum == -1&&thirdLoopNum!=-1) {//第一层循环为空，第二层循环为空,第三层循环不为空
            return thirdLoopNum * 2 + 5;
        } else if (firstLoopNum != -1 && secondLoopNum != -1 && thirdLoopNum != -1) {
            return ((((thirdLoopNum * 2) + 3) * secondLoopNum) + 3) * firstLoopNum + 5;
        } else {
            return -1;
        }
    }

    public void showInfo(long resultNum) {
        if (resultNum == -1) {
            resultTextView.setText("格式不正确");
        } else if (resultNum > 1000000) {
            resultTextView.setText("" + resultNum / 1000000.0 + "s");
        } else if (resultNum > 1000) {
            resultTextView.setText("" + resultNum / 1000.0 + "ms");
        } else {
            resultTextView.setText("" + resultNum + "us");
        }
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int firstLoopNum = convertToInt(firstLoop.getText().toString());
            int secondLoopNum = convertToInt(secondLoop.getText().toString());
            int thirdLoopNum = convertToInt(thirdLoop.getText().toString());
            long resultNum = calculate(firstLoopNum, secondLoopNum, thirdLoopNum);
            showInfo(resultNum);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            this.finish();
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
