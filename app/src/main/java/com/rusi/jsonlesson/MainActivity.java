package com.rusi.jsonlesson;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.rusi.jsonlesson.controller.MessageAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		RecyclerView messageRecyclerView = findViewById(R.id.messageRecyclerView);

		JSONObject exercise1 = setJSON();
		JSONArray exercise1JSONArray = getJSONArray(exercise1);

		messageRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
		messageRecyclerView.setHasFixedSize(true);
		messageRecyclerView.setAdapter(new MessageAdapter(convertJSONArrayToList(exercise1JSONArray)));
	}

	@Nullable
	private JSONObject setJSON (){
		JSONObject exercise1 = null;
		try {
			exercise1 = new JSONObject("{\"status\":\"success\",\"message\":[\"affenpinscher\",\"african\",\"airedale\",\"akita\",\"appenzeller\",\"basenji\",\"beagle\",\"bluetick\",\"borzoi\",\"bouvier\",\"boxer\",\"brabancon\",\"briard\",\"bulldog\",\"bullterrier\",\"cairn\",\"chihuahua\",\"chow\",\"clumber\",\"collie\",\"coonhound\",\"corgi\",\"dachshund\",\"dane\",\"deerhound\",\"dhole\",\"dingo\",\"doberman\",\"elkhound\",\"entlebucher\",\"eskimo\",\"germanshepherd\",\"greyhound\",\"groenendael\",\"hound\",\"husky\",\"keeshond\",\"kelpie\",\"komondor\",\"kuvasz\",\"labrador\",\"leonberg\",\"lhasa\",\"malamute\",\"malinois\",\"maltese\",\"mastiff\",\"mexicanhairless\",\"mountain\",\"newfoundland\",\"otterhound\",\"papillon\",\"pekinese\",\"pembroke\",\"pinscher\",\"pointer\",\"pomera" + "nian\",\"poodle\",\"pug\",\"pyrenees\",\"redbone\",\"retriever\",\"ridgeback\",\"rottweiler\",\"saluki\",\"samoyed\",\"schipperke\",\"schnauzer\",\"setter\",\"sheepdog\",\"shiba\",\"shihtzu\",\"spaniel\",\"springer\",\"stbernard\",\"terrier\",\"vizsla\",\"weimaraner\",\"whippet\",\"wolfhound\"]}");
		} catch (JSONException e) {
			Log.d("setJSON: ", e.getMessage());
		}
		return exercise1;
	}

	@Nullable
	private JSONArray getJSONArray (@Nullable JSONObject exercise1) {
		JSONArray messageArray = null;
		try {
			messageArray = exercise1.getJSONArray("message");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return messageArray;
	}

	@NonNull
	private List<String> convertJSONArrayToList (@Nullable JSONArray exercise1JSONArray) {
		List<String> messageList = new ArrayList <>();
		for (int i=0; i < exercise1JSONArray.length(); i++){
			try {
				String oneMessage = String.valueOf(exercise1JSONArray.getString(i));
				messageList.add(oneMessage);
				Log.d("message", oneMessage);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return messageList;
	}

}
