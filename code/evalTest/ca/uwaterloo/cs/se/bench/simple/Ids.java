package ca.uwaterloo.cs.se.bench.simple;

public interface Ids {

	public final String Prim_int = "int";
	public final String Prim_int_1d = "int[]";
	public final String Prim_int_2d = "int[][]";

	public final String String = "java.lang.String";
	public final String Collection = "java.util.Collection";
	public final String Collection_String = "java.util.Collection<String>";

	public final String Vector = "java.util.Vector";
	public final String Vector_String = "java.util.Vector<String>";
	public final String Vector_init = "java.util.Vector.<init>()";

	public final String FieldClass = "ca.uwaterloo.cs.se.bench.simple.FieldClass";
	public final String FieldClass_fieldString = "ca.uwaterloo.cs.se.bench.simple.FieldClass.fieldString";
	public final String FieldClass_fieldStringValue = "ca.uwaterloo.cs.se.bench.simple.FieldClass.fieldStringValue";
	public final String FieldClass_fieldStringInit = "ca.uwaterloo.cs.se.bench.simple.FieldClass.fieldStringInit";
	public final String FieldClass_staticFieldVector = "ca.uwaterloo.cs.se.bench.simple.FieldClass.staticFieldVector";
	public final String FieldClass_staticFieldVectorInit = "ca.uwaterloo.cs.se.bench.simple.FieldClass.staticFieldVectorInit";
	public final String FieldClass_staticBlockHashSetInit = "ca.uwaterloo.cs.se.bench.simple.FieldClass.staticBlockHashSetInit";
	public final String FieldClass_init = "ca.uwaterloo.cs.se.bench.simple.FieldClass.<init>()";
	
	
	public final String NestedClass = "ca.uwaterloo.cs.se.bench.simple.NestedClass";
	public final String NestedClass_InnerClass = "ca.uwaterloo.cs.se.bench.simple.NestedClass$InnerClass";
	public final String NestedClass_InnerInnerClass = "ca.uwaterloo.cs.se.bench.simple.NestedClass$InnerClass$InnerInnerClass";
	public final String NestedClass_nestedString = "ca.uwaterloo.cs.se.bench.simple.NestedClass.nestedString";
	public final String NestedClass_nestedVector = "ca.uwaterloo.cs.se.bench.simple.NestedClass.nestedVector";
	public final String NestedClass_nestedStringVector = "ca.uwaterloo.cs.se.bench.simple.NestedClass.nestedStringVector";
	public final String NestedClass_nestedInitializedStringVector = "ca.uwaterloo.cs.se.bench.simple.NestedClass.nestedInitializedStringVector";
	public final String NestedClass_init = "ca.uwaterloo.cs.se.bench.simple.NestedClass.<init>()";
	public final String NestedClass_innerinit = "ca.uwaterloo.cs.se.bench.simple.NestedClass$InnerClass.<init>(ca.uwaterloo.cs.se.bench.simple.NestedClass)";
	public final String NestedClass_innerinnerinit = "ca.uwaterloo.cs.se.bench.simple.NestedClass$InnerClass.<init>(ca.uwaterloo.cs.se.bench.simple.NestedClass)";
	public final String NestedClass_nestedMethodA = "ca.uwaterloo.cs.se.bench.simple.NestedClass.nestedMethodA()";
	public final String NestedClass_nestedMethodB = "ca.uwaterloo.cs.se.bench.simple.NestedClass.nestedMethodB()";
	public final String NestedClass_nestedMethodC = "ca.uwaterloo.cs.se.bench.simple.NestedClass.nestedMethodC()";
	public final String NestedClass_innerMethodA = "ca.uwaterloo.cs.se.bench.simple.NestedClass$InnerClass.innerMethodA()";
	public final String NestedClass_innerMethodB = "ca.uwaterloo.cs.se.bench.simple.NestedClass$InnerClass.innerMethodB()";
	public final String NestedClass_innerMethodC = "ca.uwaterloo.cs.se.bench.simple.NestedClass$InnerClass.innerMethodC()";
	public final String NestedClass_innerinnerMethodA = "ca.uwaterloo.cs.se.bench.simple.NestedClass$InnerClass$InnerInnerClass.innerInnerMethodA()";
	public final String NestedClass_innerinnerMethodB = "ca.uwaterloo.cs.se.bench.simple.NestedClass$InnerClass$InnerInnerClass.innerInnerMethodB()";
	public final String NestedClass_innerinnerMethodC = "ca.uwaterloo.cs.se.bench.simple.NestedClass$InnerClass$InnerInnerClass.innerInnerMethodC()";														
	
	public final String SimpleClass = "ca.uwaterloo.cs.se.bench.simple.SimpleClass";
	public final String SimpleClass_fieldA = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.fieldA";
	public final String SimpleClass_init = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.<init>()";
	public final String SimpleClass_a1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.a1()";
	public final String SimpleClass_a2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.a2()";
	public final String SimpleClass_b1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.b1()";
	public final String SimpleClass_b2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.b2()";
	public final String SimpleClass_c1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.c1()";
	public final String SimpleClass_c2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.c2(java.lang.String)";
	public final String SimpleClass_d1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.d1()";
	public final String SimpleClass_d2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.d2(java.lang.String, int[], int[][])";
	public final String SimpleClass_e1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.e1()";
	public final String SimpleClass_e2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.e2(java.util.Vector)";
	public final String SimpleClass_f1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.f1()";
	public final String SimpleClass_f2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.f2(java.util.Collection)";
	public final String SimpleClass_g1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.g1()";
	public final String SimpleClass_g2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.g2(java.util.Collection)";
	public final String SimpleClass_h1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.h1()";
	public final String SimpleClass_h2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.h2()";
	public final String SimpleClass_i1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.i1()";
	public final String SimpleClass_i2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.i2()";
	public final String SimpleClass_j1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.j1()";
	public final String SimpleClass_j2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.j2()";
	public final String SimpleClass_k1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.k1()";
	public final String SimpleClass_k2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.k2(java.util.Vector)";
	public final String SimpleClass_l1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.l1()";
	public final String SimpleClass_l2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.l2(java.util.Collection)";
	public final String SimpleClass_m1 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.m1()";
	public final String SimpleClass_m2 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.m2(java.lang.String, int)";
	public final String SimpleClass_n0 = "ca.uwaterloo.cs.se.bench.simple.SimpleClass.n0()";

	public final String InhInterface = "ca.uwaterloo.cs.se.bench.simple.InhInterface";
	public final String InhInterface_init = "ca.uwaterloo.cs.se.bench.simple.InhInterface.<init>()";
	public final String InhInterface_interfaceMethodA = "ca.uwaterloo.cs.se.bench.simple.InhInterface.interfaceMethodA()";
	public final String InhInterface_interfaceMethodB = "ca.uwaterloo.cs.se.bench.simple.InhInterface.interfaceMethodB()";
	public final String InhInterface_interfaceMethodC = "ca.uwaterloo.cs.se.bench.simple.InhInterface.interfaceMethodC()";

	public final String InhClassA = "ca.uwaterloo.cs.se.bench.simple.InhClassA";
	public final String InhClassA_init = "ca.uwaterloo.cs.se.bench.simple.InhClassA.<init>()";
	public final String InhClassA_interfaceMethodA = "ca.uwaterloo.cs.se.bench.simple.InhClassA.interfaceMethodA()";
	public final String InhClassA_interfaceMethodB = "ca.uwaterloo.cs.se.bench.simple.InhClassA.interfaceMethodB()";
	public final String InhClassA_abstractMethodA = "ca.uwaterloo.cs.se.bench.simple.InhClassA.abstractMethodA()";

	
	public final String InhAbstractClass = "ca.uwaterloo.cs.se.bench.simple.InhAbstractClass";
	public final String InhAbstractClass_init = "ca.uwaterloo.cs.se.bench.simple.InhAbstractClass.<init>()";
	public final String InhAbstractClass_interfaceMethodA = "ca.uwaterloo.cs.se.bench.simple.InhAbstractClass.interfaceMethodA()";
	public final String InhAbstractClass_interfaceMethodC = "ca.uwaterloo.cs.se.bench.simple.InhAbstractClass.interfaceMethodC()";
	public final String InhAbstractClass_abstractMethodA = "ca.uwaterloo.cs.se.bench.simple.InhAbstractClass.abstractMethodA()";	
	public final String InhAbstractClass_abstractMethodB = "ca.uwaterloo.cs.se.bench.simple.InhAbstractClass.abstractMethodB()";	

	
	public final String AnonClass = "ca.uwaterloo.cs.se.bench.simple.AnonClass";
	public final String AnonClass_simpleAnonymous = "ca.uwaterloo.cs.se.bench.simple.AnonClass.simpleAnonymous()";
	public final String AnonClass_genericAnonymous = "ca.uwaterloo.cs.se.bench.simple.AnonClass.genericAnonymous()";
	public final String AnonClass_simpleAnonymous_compare = "ca.uwaterloo.cs.se.bench.simple.AnonClass.simpleAnonymous().compare()";
	public final String AnonClass_genericAnonymous_compare = "ca.uwaterloo.cs.se.bench.simple.AnonClass.genericAnonymous().compare()";
	
	public final String Prim_void = "void";
	public final String Prim_bool = "boolean";

	// ca.uwaterloo.cs.se.bench.simple.AnonClass$2.compare(java.lang.String, java.lang.String)

}
