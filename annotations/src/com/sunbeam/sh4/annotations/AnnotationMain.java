package com.sunbeam.sh4.annotations;

import java.lang.annotation.Annotation;

public class AnnotationMain {
	public static void main(String[] args) {
		//java.lang.Class
			//1. Class cls = Class.forName("pkg.MyClass");
			//2. Class cls = MyClass.class;
			//3. MyClass obj = new MyClass();	Class cls = obj.getClass();

		Class<MyClass> cls = MyClass.class;
		Annotation[] anns = cls.getAnnotations();
		for (Annotation ann : anns) {
			System.out.println(ann.toString());
			if(ann instanceof Readme) {
				Readme rm = (Readme) ann;
				System.out.println("Company : " + rm.company());
				System.out.println("Developer : " + rm.value());
			}
		}
	}
}
