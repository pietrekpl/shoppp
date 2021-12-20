package com.example.shopp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> arrayList;
    ListView listView;

    String jsonParse = "[\n" +
            "   {\n" +
            "      \"name\":\"Kowalski\",\n" +
            "      \"image\":\"https://e7.pngegg.com/pngimages/805/916/png-clipart-the-penguins-of-madagascar-dr-blowhole-returns-again-kowalski-skipper-madagascar-operation-penguin-penguin-animals-vertebrate.png\",\n" +
            "      \"cost\":12.99,\n" +
            "      \"description\":\"Maskotka pingwina z Kowalskiego z kulą. Najmądrzejszy pingwin w oddziale Skippera. Jest on debiutującą postacią w filmie Madagaskar, która gra niewielką rolę wraz ze Skipperem, Rico i Szeregowym, oraz postacią drugoplanową w Madagaskarze 2, i Madagaskarze 3. Również jest jedną z głównych postaci serialu Pingwiny z Madagaskaru, oraz filmu z 2014 roku o tej samej nazwie. W oddziale jest on strategiem tworzącym raporty oraz wynalazcą oraz najwyższym z pingwinów.\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Szeregowy\",\n" +
            "      \"image\":\"https://e7.pngegg.com/pngimages/801/417/png-clipart-emperor-penguin-madagascar-penguins-image-file-formats-animals.png\",\n" +
            "      \"cost\":14.99,\n" +
            "      \"description\":\"Szeregowy – najmłodszy, najniższy, najpulchniejszy i najbardziej niedoświadczony pingwin w oddziale Skippera. \"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Rico\",\n" +
            "      \"image\":\"https://data2.cupsell.pl/upload/generator/44099/640x420/1056767_print-trimmed-1.png?resize=max_sizes&key=55f9a22768eed085006592c1174c0235.png\",\n" +
            "      \"cost\":21.99,\n" +
            "      \"description\":\"Samiec pingwina białobrewego. Jest członekiem oddziału Skippera. Jest specjalistą od materiałów wybuchowych.\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Skipper\",\n" +
            "      \"image\":\"https://e7.pngegg.com/pngimages/911/77/png-clipart-skipper-kowalski-youtube-penguin-madagascar-youtube.png\",\n" +
            "      \"cost\":15.05,\n" +
            "      \"description\":\"Skipper - samiec pingwina białobrewego i lider Oddziału Pingwinów. Jest drugim, najpulchniejszym i najniższym pingwinem w grupie.\"\n" +
            "   }\n" +
            "] ";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJson().execute(jsonParse);
            }
        });

    }

    class ReadJson extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                return readURL(params[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return params[0];

        }

        @Override
        protected void onPostExecute(String contnent) {
            try {


                JSONObject jsonObject = new JSONObject(contnent);
                JSONArray jsonArray = jsonObject.getJSONArray("");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject productObject = jsonArray.getJSONObject(i);
                    arrayList.add(new Product(
                            productObject.getString("image"),
                            productObject.getString("price"),
                            productObject.getString("name")
                    ));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            CustomListAdapter adapter = new CustomListAdapter(
                    getApplicationContext(),R.layout.custom_list_layout,arrayList
            );
            listView.setAdapter(adapter);
        }
    }

    public static String readURL(String url) throws Exception {
        try {
            URL website = new URL(url);
            URLConnection connection = website.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);

            in.close();

            return response.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return url;
    }
}

