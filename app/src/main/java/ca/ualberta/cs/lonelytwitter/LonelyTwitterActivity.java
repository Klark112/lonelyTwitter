package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The main activity for a small, personal Twitter app to capture,notes and comments
 * <p>It save the <pre>input tweets</pre>in the json files.</p>
 * A sample code is as:<br>
 *     <code>
 *         for(int i=0;i<10;i++)
 *             for (int j=0; j<1; j++)
 *                 doSomething();
 *     </code>
 *The list of important activities in this class are as follows:
 * <ul>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 *     <li>item 4</li>
 * </ul>
 * @since 1.2.1
 * @see LonelyTwitterActivity for more information
 * @author klark
 * @version 2.3
 * @deprecated
 *
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * This arrayList is for keeping the tweets and their date of posting. <br>
	 *     THis is blah blah.
	 *     @see #loadFromFile()
	 */
	public ArrayList<String> listOfItems;
	static final String GENERAL_FILE_NAME="fileName.json";

	/**
	 * This method should return the <code>number of characters </code>used in a tweet
	 * @return
	 */
	private int calculateTweetSize(){
		//
		return -1;
	}

	/**
	 * This function should remove specific Specific strings of text.
	 * @param text
	 * @return
	 */
	private String removeStopWords(String text){
		//
		return "";
	}

	/**
	 * This starts the next activity which is blah blah.
	 * @param intent This is the intent to be run immediately after hitting "start" button.
	 *
	 */
	private void startSecondActivity(Intent intent){}

	/**
	 * This method does something!
	 * @param s
	 * @return the value that is used for some job!
	 * @throws ...
	 * @deprecated
	 */
	public String someMethod(String s){
		return "";
	}

	/**
	 * this method is meant to evaulate whether or not the secondactivity works
	 *
	 * @exception Exception creates an exception e when the try fails
	 * @param intent
	 * @return
	 */
	public boolean evaluateSecondActivity(Intent intent){
		int count =0;
		String s="";
		String expression1 = "" , expression2 = "" , expression3 = "" , expression4= "";

		//This is a call to intent to do ...(something)
		Intent intent1 =new Intent();
		startSecondActivity(intent1);
		String S = someMethod( expression1 + expression2 + expression3 +
							expression4);
		someMethod(expression1 + expression2 + expression3 +
				expression4);
		for(int i=0;i<10;i++){}
		try {
			int a=1,b=2;
			if(a<2){
				someMethod("first choice");
			} else{
				someMethod("second choice");
			}
			while (1 < 2) {
				int j = 0;
			}
		}
		catch(Exception e){}
		return true;
	}


	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created.
	 *	initializes the two main interactive buttons of the application
	 *<ul>
	 *     <li>saveButton</li>
	 *     <li>clearButton</li>
	 *</ul>
	 *  @param savedInstanceState
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		/**
		 * this method details the functionality of the save button
		 * it takes an entire function as an argument so it knows
		 * what to listen for. It saves entered tweets to a
		 * permanent file
		 * @see #saveInFile()
		 */
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet latestTweet = new NormalTweet(text);
				ImportantTweet latestImportantTweet = new ImportantTweet(text);
				// latestTweet.setMessage(latestTweet.getMessage() + "!");
				tweets.add(latestTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});
		/**
		 * clears the screen of tweets and <code>deletes the file </code>
		 * that stored the tweets
		 * @see #saveInFile()
		 */
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				tweets.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});

	}

	/**
	 * at the boot up of the application it creates and array of Tweets which
	 * a single adapter oversees and loads  the old tweet list into the new one
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * loads information from FILENAME
	 * @exception FileNotFoundException throws an exception when there is no file to read
	 * @exception  IOException throws an exception when there is an error with the IO
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();

			// Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-19 2016
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * commits change made by the interactive buttons saveButton and clearButton
	 * @exception FileNotFoundException throws an exception when there is no file to read
	 * @exception  IOException throws an exception when there is an error with the IO
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweets, out);
			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}