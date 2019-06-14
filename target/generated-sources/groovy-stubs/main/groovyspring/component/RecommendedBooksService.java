package groovyspring.component;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.stereotype.Component() public class RecommendedBooksService
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
@groovy.transform.Memoized() public  java.util.List<groovyspring.model.GBook> getBooks(java.lang.String Genre) { return (java.util.List<groovyspring.model.GBook>)null;}
@groovy.transform.Memoized() public  java.util.List<groovyspring.model.GBook> getBasedOnFeedbackBooks(java.lang.String feedback) { return (java.util.List<groovyspring.model.GBook>)null;}
@groovy.transform.Memoized() public  java.util.List<java.lang.String> getGenre() { return (java.util.List<java.lang.String>)null;}
}
