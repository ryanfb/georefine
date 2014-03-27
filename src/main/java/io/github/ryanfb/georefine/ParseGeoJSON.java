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

import org.geotools.geojson.geom.GeometryJSON;
import java.io.Reader;
import java.io.StringReader;

public class ParseGeoJSON implements Function {

    public Object call(Properties bindings, Object[] args) {
        if(args.length==1){
            GeometryJSON gjson = new GeometryJSON();
            String json = args[0].toString();

            Reader reader = new StringReader(json);
            try {
                return gjson.read(reader);
            }
            catch (java.io.IOException e) {
                return new EvalError(ControlFunctionRegistry.getFunctionName(this) + ": " + e.getMessage());
            }
        }
        return new EvalError(ControlFunctionRegistry.getFunctionName(this) + " expects 1 argument");
    }

    public void write(JSONWriter writer, Properties options)
            throws JSONException {
        writer.object();
        writer.key("description"); writer.value("parses GeoJSON geometry string");
        writer.key("params"); writer.value("GeoJSON string");
        writer.key("returns"); writer.value("geometry object");
        writer.endObject();
    }

}
