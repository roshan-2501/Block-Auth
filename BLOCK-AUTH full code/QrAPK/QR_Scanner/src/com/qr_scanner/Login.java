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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements Server_Interface{

	private EditText User,Pass;
	private Button Login;
	private TextView Regbtn;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		User =  (EditText) findViewById(R.id.userid);
		Pass= (EditText) findViewById(R.id.password);
		Regbtn = (TextView)findViewById(R.id.btn_register);
		Regbtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(Login.this,Register.class);
				startActivity(it);
			}
		});
		Login= (Button) findViewById(R.id.btn_login);
		Login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(User.getText().toString().equalsIgnoreCase("")){
					User.setError("enter userid");
					User.requestFocus();
				}else if(Pass.getText().toString().equalsIgnoreCase("")){
					Pass.setError("enter password");
					Pass.requestFocus();
				}else{
					ServerCall callPost = new ServerCall(Login.this,Login.this);

					HashMap<String, Object> parameter = new HashMap<String, Object>();
					parameter.put("name",User.getText().toString()
							.trim());
					parameter.put("pass",Pass.getText().toString()
							.trim());

					callPost.setMethod(ServerCall.POST); // URL PARAMETER TO
															// CALL GET OR
															// POST
					callPost.setParameter(parameter); // PASS THE PARAMETER
					callPost.execute(Connection.LOGIN);
					
				}
			}
		});
		
	}

	@Override
	public void onCancel(String chek) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(String result) {
		// TODO Auto-generated method stub
		if(result.equalsIgnoreCase("Ok")){
			Intent it=new Intent(Login.this,MainActivity.class);
			startActivity(it);
		}
		Toast.makeText(getApplicationContext(), "Result->"+result, Toast.LENGTH_SHORT).show();
	}
}
