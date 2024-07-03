package com.qr_scanner;

import java.util.HashMap;

import com.connection.Connection;
import com.connection.ServerCall;
import com.connection.Server_Interface;
import com.example.qr_scanner.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements Server_Interface {
	public static final int MODE_PRIVATE = 0;
	public static final int RESULT_OK = -1;
	public static final int RESULT_CANCELED = 0;
	private Button Clickbtn;
	private Button Sendbtn;
	String getcode, contents, format;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Clickbtn = (Button) findViewById(R.id.click_btn);
		Sendbtn = (Button) findViewById(R.id.send_btn);
		Clickbtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(
						"com.google.zxing.client.android.SCAN");
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);
			}
		});
		Sendbtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				getcode = contents;
				Toast.makeText(getApplicationContext(), contents,
						Toast.LENGTH_LONG).show();
				ServerCall callPost = new ServerCall(MainActivity.this,
						MainActivity.this);

				HashMap<String, Object> parameter = new HashMap<String, Object>();
				parameter.put("otp", contents.toString().trim());

				callPost.setMethod(ServerCall.GET);
				callPost.setParameter(parameter);
				callPost.execute(Connection.OTP);

			}
		});
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		try {
			String dates = "";
			String time = "";
			if (requestCode == 0) {
				if (resultCode == RESULT_OK) {
					contents = intent.getStringExtra("SCAN_RESULT");
					format = intent.getStringExtra("SCAN_RESULT_FORMAT");
					// Handle successful scan

					// Toast toast = Toast.makeText(this, "Content:" + contents
					// + " Format:" + format , Toast.LENGTH_LONG);
					// toast.setGravity(Gravity.TOP, 25, 400);
					// toast.show();
					String url = contents;
					// Toast.makeText(getActivity(), "status"+url,
					// Toast.LENGTH_LONG).show();

				} else if (resultCode == RESULT_CANCELED) {
					// Handle cancel
					Toast.makeText(getApplicationContext(),
							"Sorry Scan cancelled", Toast.LENGTH_LONG).show();

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onCancel(String chek) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(String result) {
		// TODO Auto-generated method stub
		if (result.equalsIgnoreCase("Ok")) {
			Toast.makeText(getApplicationContext(), "Sent successfully",
					Toast.LENGTH_LONG).show();
		}
	}

}
