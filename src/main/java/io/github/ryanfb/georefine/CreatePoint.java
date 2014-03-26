package io.github.ryanfb.georefine;

import java.util.Properties;

import org.json.JSONException;
import org.json.JSONWriter;

import com.google.refine.expr.EvalError;
import com.google.refine.grel.ControlFunctionRegistry;
import com.google.refine.grel.Function;

import org.geotools.geometry.GeometryBuilder;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.geometry.primitive.PrimitiveFactory;

public class CreatePoint implements Function {

    public Object call(Properties bindings, Object[] args) {
        if(args.length==2){
            String lat = args[0].toString();
            String lng = args[1].toString();

            double[] latlng = {
                Double.parseDouble(lat),
                Double.parseDouble(lng)
            };
            
            GeometryBuilder builder = new GeometryBuilder(DefaultGeographicCRS.WGS84);
            // PrimitiveFactory primFF = builder.getPrimitiveFactory();

            return builder.createPoint(latlng);
        }
        return new EvalError(ControlFunctionRegistry.getFunctionName(this) + " expects 2 strings");
    }

    public void write(JSONWriter writer, Properties options)
            throws JSONException {
        writer.object();
        writer.key("description"); writer.value("creates a point from coordinates");
        writer.key("params"); writer.value("latitude, longitude");
        writer.key("returns"); writer.value("primitive");
        writer.endObject();
    }

}
