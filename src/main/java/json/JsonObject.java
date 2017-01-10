package json;

import java.util.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    HashMap<String, Json> object  = new HashMap<>();
    public JsonObject(JsonPair... jsonPairs) {
        int counter = 0;
        for (JsonPair jsonPair: jsonPairs) {
            object.put(jsonPair.key, jsonPair.value);
            }
        }

    @Override
    public String toJson() {
        if (object.size() == 0){

            return "{}";
        }
        String string = "{";
//        for (int i = 0; i < object.size(); i++){
//            Map.Entry<String,Json> entry = object.entrySet().iterator().next();
//            String key = entry.getKey();
//            string += key + "" + " : {";
//            string += "'" + object.get(key) + "'";
//            string += "}";
//        }
        Set<String> keys = object.keySet();
//        HashMap<String, String> distinct = new HashMap<>();
        int counter = 0;
        for (String key: keys) {
//            if (distinct.containsKey(key)){
//                String same_value = distinct.get(key);
//                string += "{" + key + ":" + same_value + "}";
//            }
//            else
            string += key +  ":" +  object.get(key).toString() +  ",";
        }
        string = string.substring(0, string.length() -1);
        string += "}";
//            distinct.put(key, object.get(key).toString());

//        }
//        System.out.println(object.keySet());
//        for (String key: keys)
//            string += "'" + key + "'" + object.get(key);
//        string += "}";
//        for (int i = 0; i < object.keySet().size(); i++){
//            if ()
//            string += object.get(object.keySet().iterator().next());
//        }
//        for (Set keys: object.keySet())
        return string;
    }

    public void add(JsonPair jsonPair) {
        object.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        return object.get(name);
    }

    public JsonObject projection(String... names) {
        JsonObject jsonObject = new JsonObject();
        for (String name:names
             ) {
            if (object.get(name) != null){
                jsonObject.add(new JsonPair(name, object.get(name)));
            }
        }
        return jsonObject;
    }
    boolean contains(String name){
        if (object.containsKey(name))
            return true;
        return false;
    }
}
