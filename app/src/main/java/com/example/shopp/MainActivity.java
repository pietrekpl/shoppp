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





    }
}

