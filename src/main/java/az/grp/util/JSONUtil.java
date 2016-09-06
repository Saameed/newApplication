package az.grp.util;

import az.grp.model.dao.IEntity;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Seymur on 9/4/2014.
 */

public class JSONUtil {

    private static Logger logger = Logger.getLogger(JSONUtil.class);

    public static String convertObjectToJSON(Object object){

        ObjectMapper objectMapper = new ObjectMapper();
        final DateFormat df = new SimpleDateFormat("yyyy/MM/dd' 'HH:mm:ss");
        objectMapper.setDateFormat(df);
        String json = null;

        try {
            json = objectMapper.writeValueAsString(object);
        }catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        return json;
    }

    public static <T extends IEntity> String convertArrayToJSON(List<T> list) {
        return tryConverting(list);
    }

    private static String tryConverting(List list) {

        String json = null;
        ObjectMapper mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);

        final DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        mapper.setDateFormat(df);

        try {
            json = mapper.writeValueAsString(list);
        } catch (IOException ioEx) {
            logger.error(ioEx.getMessage());
        }

        return json;
    }

    /**
     *
     * @param json json string to be converted to the map
     * @return converted json as map
     */
    public static Map<String,String> jsonToMap(String json) {

        Map<String,String> map = new HashMap<String,String>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            map = mapper.readValue(json, new TypeReference<HashMap>(){});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
