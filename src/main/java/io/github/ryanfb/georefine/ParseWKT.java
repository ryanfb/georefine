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

import org.geotools.geometry.jts.JTSFactoryFinder;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.geom.GeometryFactory;

public class ParseWKT implements Function {

    public Object call(Properties bindings, Object[] args) {
        if(args.length==1){
            GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
            WKTReader reader = new WKTReader(geometryFactory);
            try {
                return reader.read(args[0].toString());
            }
            catch (com.vividsolutions.jts.io.ParseException e) {
                return new EvalError(ControlFunctionRegistry.getFunctionName(this) + ": " + e.getMessage());
            }
        }
        return new EvalError(ControlFunctionRegistry.getFunctionName(this) + " expects 1 argument");
    }

    public void write(JSONWriter writer, Properties options)
            throws JSONException {
        writer.object();
        writer.key("description"); writer.value("parses WKT geometry string");
        writer.key("params"); writer.value("WKT string");
        writer.key("returns"); writer.value("geometry object");
        writer.endObject();
    }

}
