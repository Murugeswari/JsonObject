package com.example.json;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Json extends Activity {

String urllink = "http://api.androidhive.info/contacts/";
ListView list;
ArrayList<String> arrlist = new ArrayList<String>();

final String customJSON = "{\"id\":12,\"name\":\"Saranya\",\"status\":\"Going to get good job soon\",\"volumes\":[{\"id\":17592,\"name\":\"Saranya\",\"status\":\"ok\"},{\"id\":17592,\"name\":\"Ambika\",\"status\":\"ok\"},{\"id\":17592,\"name\":\"ShreeMidhun\",\"status\":\"ok\"},{\"id\":17592,\"name\":\"Suganya\",\"status\":\"ok\"},{\"id\":17592,\"name\":\"Raj Kumar\",\"status\":\"ok\"},{\"id\":17592,\"name\":\"Ruban Raj\",\"status\":\"ok\"}]}";

@Override
protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
list = (ListView) findViewById(list);
try {
JSONObject jsonobj = new JSONObject(customJSON);
JSONArray jsonarr = new JSONArray();

jsonarr = jsonobj.getJSONArray("volumes");

System.out.println(jsonarr);
int id = jsonobj.getInt("id");

System.out.println(id);

String state = jsonobj.getString("name");

System.out.println(state);

String stat = jsonobj.getString("status");

System.out.println(stat);

for (int i = 0; i < jsonarr.length(); i++) {
arrlist.add(jsonarr.getJSONObject(i).getString("name"));

ArrayAdapter<String> ad = new ArrayAdapter<String>(
	getApplicationContext(),
		android.R.layout.simple_list_item_1,
			android.R.id.text1, arrlist);
				// ArrayAdapter<String> adapter=new
					// ArrayAdapter<String>(this,android.R.layout.activity_list_item,
						// android.R.id.text1,arrlist);
							list.setAdapter(ad);
							System.out.println(jsonarr.getJSONObject(i).getString("name"));

							}
							} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							}
							}
							private ListView findViewById(ListView list2) {
							// TODO Auto-generated method stub
							return null;
							}

							@Override
							public boolean onCreateOptionsMenu(Menu menu) {
							// Inflate the menu; this adds items to the action bar if it is present.
							getMenuInflater().inflate(R.menu.main, menu);
							return true;
							}

							@Override
							public boolean onOptionsItemSelected(MenuItem item) {
							// Handle action bar item clicks here. The action bar will
							// automatically handle clicks on the Home/Up button, so long
							// as you specify a parent activity in AndroidManifest.xml.
							int id = item.getItemId();
							if (id == R.id.action_settings) {
							return true;
							}
							return super.onOptionsItemSelected(item);
							}

							@Override
							public boolean onOptionsItemSelected(MenuItem item) {
							// Handle action bar item clicks here. The action bar will
							// automatically handle clicks on the Home/Up button, so long
							// as you specify a parent activity in AndroidManifest.xml.
							int id = item.getItemId();
							if (id == R.id.action_settings) {
							return true;
							}
							return super.onOptionsItemSelected(item);
							}

							public class Operation extends AsyncTask<Void, Void, String>
							{

							ProgressDialog dialog;
							DefaultHttpClient client;
							HttpResponse res;
							HttpEntity entity;
							String URL;
							JSONObject obj;

							public Operation(String urllink) {
							URL = urllink;

							}
							@Override
							protected void onPreExecute() {
							// TODO Auto-generated method stub
							super.onPreExecute();

							// dialog = new ProgressDialog(Json.this);
							}

							@Override
							protected String doInBackground(Void... params) {
							// TODO Auto-generated method stub

							client = new DefaultHttpClient();
							HttpGet data = new HttpGet(URL);
							try {
							res = client.execute(data);
							entity = res.getEntity();
							String res = EntityUtils.toString(entity);
							obj = new JSONObject(res);
							} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							}

							return null;
							}
							@Override
							protected void onPostExecute(String result) {
							// TODO Auto-generated method stub
							super.onPostExecute(result);
							}
							}
							}

