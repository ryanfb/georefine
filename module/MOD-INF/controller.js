/*

Copyright 2010, Google Inc.
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are
met:

 * Redistributions of source code must retain the above copyright
notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above
copyright notice, this list of conditions and the following disclaimer
in the documentation and/or other materials provided with the
distribution.
 * Neither the name of Google Inc. nor the names of its
contributors may be used to endorse or promote products derived from
this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,           
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY           
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 */

var html = "text/html";
var encoding = "UTF-8";
var ClientSideResourceManager = Packages.com.google.refine.ClientSideResourceManager;

/*
 * Function invoked to initialize the extension.
 */
function init() {
  // Packages.java.lang.System.err.println("Initializing GeoRefine extension");
  // Packages.java.lang.System.err.println(module.getMountPoint());
  Packages.com.google.refine.grel.ControlFunctionRegistry.registerFunction(
    "point", new Packages.io.github.ryanfb.georefine.CreatePoint());
  Packages.com.google.refine.grel.ControlFunctionRegistry.registerFunction(
    "distance", new Packages.io.github.ryanfb.georefine.Distance());
  Packages.com.google.refine.grel.ControlFunctionRegistry.registerFunction(
    "parseGeoJson", new Packages.io.github.ryanfb.georefine.ParseGeoJSON());

	Packages.com.google.refine.grel.ControlFunctionRegistry.registerFunction(
	  "equals", new Packages.io.github.ryanfb.georefine.Equals());
	Packages.com.google.refine.grel.ControlFunctionRegistry.registerFunction(
	  "contains", new Packages.io.github.ryanfb.georefine.Contains());
	Packages.com.google.refine.grel.ControlFunctionRegistry.registerFunction(
	  "within", new Packages.io.github.ryanfb.georefine.Within());
	Packages.com.google.refine.grel.ControlFunctionRegistry.registerFunction(
	  "overlaps", new Packages.io.github.ryanfb.georefine.Overlaps());
	Packages.com.google.refine.grel.ControlFunctionRegistry.registerFunction(
	  "crosses", new Packages.io.github.ryanfb.georefine.Crosses());
	Packages.com.google.refine.grel.ControlFunctionRegistry.registerFunction(
	  "touches", new Packages.io.github.ryanfb.georefine.Touches());
	Packages.com.google.refine.grel.ControlFunctionRegistry.registerFunction(
	  "intersects", new Packages.io.github.ryanfb.georefine.Intersects());
	Packages.com.google.refine.grel.ControlFunctionRegistry.registerFunction(
	  "disjoint", new Packages.io.github.ryanfb.georefine.Disjoint());
	Packages.com.google.refine.grel.ControlFunctionRegistry.registerFunction(
	  "relate", new Packages.io.github.ryanfb.georefine.Relate());
}