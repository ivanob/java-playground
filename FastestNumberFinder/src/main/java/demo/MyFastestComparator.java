package demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyFastestComparator implements NumberFinder{

    public class SharedResult{
        private boolean found;
        public SharedResult(){ found=false; }
        public void setResultTrue(){
            this.found = true;
        }
        public boolean getResult(){
            return found;
        }
    }

    public boolean contains(int valueToFind, List<CustomNumberEntity> list) {
        SharedResult result = new SharedResult();
        for(CustomNumberEntity number : list){
            Runnable r = new ComparatorWorkerThread(valueToFind, number, result);
            r.run();
        }
        return result.getResult();
    }

    private CustomNumberEntity buildCustomNumberEntity(String n){
        final Constructor<CustomNumberEntity> constructor;
        CustomNumberEntity cne = null;
        try {
            constructor = CustomNumberEntity.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            cne = constructor.newInstance(n);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return cne;
    }

    public List<CustomNumberEntity> readFromFile(String filePath) {
        JSONParser parser = new JSONParser();
        List<CustomNumberEntity> list = new ArrayList<CustomNumberEntity>();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONArray jsonArray = (JSONArray) obj;
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonNumber = (JSONObject)iterator.next();
                String str = (String)jsonNumber.get("number");
                try {
                    Integer.parseInt(str);
                    CustomNumberEntity n = buildCustomNumberEntity(str);
                    list.add(n);
                }catch(NumberFormatException e){
                    //In this case, the data read from the file is not numeric
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }
}
