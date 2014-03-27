package io.github.ryanfb.georefine;

import java.util.Properties;

import org.json.JSONException;
import org.json.JSONWriter;

import com.google.refine.expr.EvalError;
import com.google.refine.grel.ControlFunctionRegistry;
import com.google.refine.grel.Function;

import com.vividsolutions.jts.geom.Geometry;

public class Disjoint implements Function {

    public Object call(Properties bindings, Object[] args) {
        if(args.length==2){
            Geometry a = (Geometry)args[0];
            Geometry b = (Geometry)args[1];

            return a.disjoint(b);
        }
        return new EvalError(ControlFunctionRegistry.getFunctionName(this) + " expects 2 arguments");
    }

    public void write(JSONWriter writer, Properties options)
            throws JSONException {
        writer.object();
        writer.key("description"); writer.value("first geometry has no points in common with second geometry");
        writer.key("params"); writer.value("Geometry a, Geometry b");
        writer.key("returns"); writer.value("true/false");
        writer.endObject();
    }

}
