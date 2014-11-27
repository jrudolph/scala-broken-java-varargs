package example;

public class Test extends VarargClass {
    public static void main(String[] args) {
        SimpleObject.x("a", "b", "c");
        ObjectInheritsImplFromTrait.x("a", "b", "c");
        ObjectInheritsImplFromClass.x("a", "b", "c");
        ObjectOverridesImplFromTrait.x("a", "b", "c"); // underlined red in IDEA
        ObjectOverridesImplFromClass.x("a", "b", "c"); // underlined red in IDEA
        // ObjectImplementsTrait.x("a", "b", "c"); // doesn't compile, bridge missing
        // ObjectImplementsClass.x("a", "b", "c"); // doesn't compile, bridge missing

        // Companions objects:
        // VarargTrait.x(5); // static forwarders missing in companion objects
        // VarargTrait.x("a", "b", "c"); // static forwarders missing in companion objects
        VarargTrait$.MODULE$.x(5);
        VarargTrait$.MODULE$.x("a", "b", "c");
        // VarargClass.x(5); // static forwarders missing in companion objects
        // VarargClass.x("a", "b", "c"); // static forwarders missing in companion objects
        VarargClass$.MODULE$.x(5);
        VarargClass$.MODULE$.x("a", "b", "c");

        new ClassInheritsImplFromTrait().x("a", "b", "c");
        new ClassInheritsImplFromClass().x("a", "b", "c");
        new ClassOverridesImplFromTrait().x("a", "b", "c");
        new ClassOverridesImplFromClass().x("a", "b", "c");
        // new ClassImplementsTrait().x("a", "b", "c"); // doesn't compile, bridge missing
        // new ClassImplementsClass().x("a", "b", "c"); // doesn't compile, bridge missing

        Anonymous.inheritsImplFromTrait().x("a", "b", "c");
        Anonymous.inheritsImplFromClass().x("a", "b", "c");
        Anonymous.overridesImplFromTrait().x("a", "b", "c");
        Anonymous.overridesImplFromClass().x("a", "b", "c");
        // Anonymous.implementsTrait().x("a", "b", "c"); // compiles but fails at runtime with AbstractMethodError (SI-1459)
        // Anonymous.implementsClass().x("a", "b", "c"); // compiles but fails at runtime with AbstractMethodError (SI-1459)

        new JavaClassInheritsImplFromClass().x("a", "b", "c");
        new JavaClassOverridesImplFromClass().x("a", "b", "c");

        new JavaClassInheritsImplFromClass().run();
        new JavaClassOverridesImplFromClass().run();

        new Test().x("a", "b", "c");

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
