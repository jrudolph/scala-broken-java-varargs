package example;

public class Test extends VarargClass {
    public static void main(String[] args) {
        SimpleObject.x("a", "b", "c");
        ObjectInheritsImplFromTrait.x("a", "b", "c");
        ObjectInheritsImplFromClass.x("a", "b", "c");
        ObjectOverridesImplFromTrait.x("a", "b", "c"); // underlined red in IDEA
        ObjectOverridesImplFromClass.x("a", "b", "c"); // underlined red in IDEA
        // ObjectImplementsTrait.x("a", "b", "c"); // doesn't compile
        // ObjectImplementsClass.x("a", "b", "c"); // doesn't compile

        // Companions objects:
        // VarargTrait.x(5); // static forwarders missing in companion objects (name conflict with inherited instance methods)
        // VarargTrait.x("a", "b", "c"); // static forwarders missing in companion objects (name conflict with inherited instance methods)
        VarargTrait$.MODULE$.x(5);
        VarargTrait$.MODULE$.x("a", "b", "c");
        // VarargClass.x(5); // static forwarders missing in companion objects (name conflict with inherited instance methods)
        // VarargClass.x("a", "b", "c"); // static forwarders missing in companion objects (name conflict with inherited instance methods)
        VarargClass$.MODULE$.x(5);
        VarargClass$.MODULE$.x("a", "b", "c");

        new ClassInheritsImplFromTrait().x("a", "b", "c");
        new ClassInheritsImplFromClass().x("a", "b", "c");
        new ClassOverridesImplFromTrait().x("a", "b", "c");
        new ClassOverridesImplFromClass().x("a", "b", "c");
        // new ClassImplementsTrait().x("a", "b", "c"); // doesn't compile
        // new ClassImplementsClass().x("a", "b", "c"); // compiles but fails at runtime with AbstractMethodError

        // trying to change the calling convention
        ((VarargTrait) new ClassInheritsImplFromTrait()).x("a", "b", "c");
        ((VarargClass) new ClassInheritsImplFromClass()).x("a", "b", "c");
        ((VarargTrait) new ClassOverridesImplFromTrait()).x("a", "b", "c");
        ((VarargClass)new ClassOverridesImplFromClass()).x("a", "b", "c");
        // ((VarargAbstractTrait) new ClassImplementsTrait()).x("a", "b", "c"); // compiles but fails at runtime with AbstractMethodError
        // ((VarargAbstractClass) new ClassImplementsClass()).x("a", "b", "c"); // compiles but fails at runtime with AbstractMethodError

        Anonymous.inheritsImplFromTrait().x("a", "b", "c");
        Anonymous.inheritsImplFromClass().x("a", "b", "c");
        Anonymous.overridesImplFromTrait().x("a", "b", "c");
        Anonymous.overridesImplFromClass().x("a", "b", "c");
        // Anonymous.implementsTrait().x("a", "b", "c"); // compiles but fails at runtime with AbstractMethodError (SI-1459)
        // Anonymous.implementsClass().x("a", "b", "c"); // compiles but fails at runtime with AbstractMethodError (SI-1459)

        // Java interface implemented from Java

        // ObjectImplementsJavaInterface.x("a", "b", "c"); // doesn't compile, javac finds only Seq<String> method
        // new ClassImplementsJavaInterface().x("a", "b", "c"); // doesn't compile, javac finds only Seq<String> method

        // ObjectImplementsJavaInterface$.MODULE$.x("a", "b", "c"); // doesn't compile, javac finds only Seq<String> method
        ((JavaInterface) ObjectImplementsJavaInterface$.MODULE$).x("a", "b", "c");
        // new ClassImplementsJavaInterface().x("a", "b", "c"); // doesn't compile, javac finds only Seq<String> method
        ((JavaInterface) new ClassImplementsJavaInterface()).x("a", "b", "c");

        // ObjectImplementsJavaAbstractClass.x("a", "b", "c"); // doesn't compile, javac finds only Seq<String> method
        new ClassImplementsJavaAbstractClass().x("a", "b", "c");

        // ObjectInheritsFromJavaClass.x("a", "b", "c"); // doesn't compile, javac finds only String[] method
        new ClassInheritsFromJavaClass().x("a", "b", "c");

        ((JavaInterface) new ClassImplementsJavaInterface()).x("a", "b", "c");
        ((JavaAbstractClass) new ClassImplementsJavaAbstractClass()).x("a", "b", "c");
        ((JavaClass) new ClassInheritsFromJavaClass()).x("a", "b", "c");

        // Java classes implementing Scala traits/classes with @varargs methods
        new JavaClassInheritsImplFromClass().x("a", "b", "c");
        new JavaClassOverridesImplFromClass().x("a", "b", "c");

        ((VarargClass) new JavaClassInheritsImplFromClass()).x("a", "b", "c");
        ((VarargClass) new JavaClassOverridesImplFromClass()).x("a", "b", "c");

        new JavaClassInheritsImplFromClass().run();
        new JavaClassOverridesImplFromClass().run();

        new Test().test();

        new JavaClassInheritsFromClassMixingInTrait().run();
    }
    public void test() {
        x("a", "b", "c");
    }

    static class JavaClassInheritsImplFromClass extends VarargClass {
        public void run() {
            x("a", "b", "c");
        }
    }
    static class JavaClassOverridesImplFromClass extends VarargClass {
        public void run() {
            x("a", "b", "c");
        }
        @Override
        public int x(String... els) {
            return 0;
        }
    }
    static class JavaClassInheritsFromClassMixingInTrait extends ClassInheritsFromTraitInheritsFromTrait {
        public void run() {
            x("a", "b", "c");
        }
    }
}
