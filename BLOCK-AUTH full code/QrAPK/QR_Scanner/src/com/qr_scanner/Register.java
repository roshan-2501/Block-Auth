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
import android.widget.EditText;

public class Register extends Activity implements Server_Interface{
private EditText Userid,Password,Number,Email,Addr;
private Button Register;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		Userid = (EditText)findViewById(R.id.user_name);
		Password = (EditText)findViewById(R.id.reg_pass);
		Number = (EditText)findViewById(R.id.number);
		Email = (EditText)findViewById(R.id.email);
		Addr = (EditText)findViewById(R.id.address);
		Register = (Button)findViewById(R.id.register);
		Register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(Userid.getText().toString().equalsIgnoreCase("")){
					Userid.setError("enter userid");
					Userid.requestFocus();
				}else if(Password.getText().toString().equalsIgnoreCase("")){
					Password.setError("enter password");
					Password.requestFocus();
				}else if(Number.getText().toString().equalsIgnoreCase("")){
					Number.setError("enter mobile no");
					Number.requestFocus();
				}else if(Number.getText().toString().length()<9){
					Number.setError("enter Valid no");
					Number.requestFocus();
				}else if(Email.getText().toString().equalsIgnoreCase("")){
					Email.setError("enter email");
					Email.requestFocus();
				}else if(Addr.getText().toString().equalsIgnoreCase("")){
					Addr.setError("enter address");
					Addr.requestFocus();
				}else{
					
					 ServerCall callPost = new ServerCall(Register.this, Register.this);

					 HashMap<String, Object> parameter = new HashMap<String, Object>();
						parameter.put("name", Userid.getText().toString().trim());
						parameter.put("pass", Password.getText().toString().trim());
						parameter.put("email",Email.getText().toString().trim());
						parameter.put("mobile",Number.getText().toString().trim());
						parameter.put("address",Number.getText().toString().trim());
						
						callPost.setMethod(ServerCall.POST); // URL PARAMETER TO CALL GET OR POST
						callPost.setParameter(parameter);   //PASS THE PARAMETER
						callPost.execute(Connection.REGISTER);
						
				
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
			Intent it=new Intent(Register.this,Login.class);
			startActivity(it);
		}
	}
	
}
