package example

import scala.annotation.varargs

object SimpleObject {
  def x(i: Int): Int = i
  @varargs
  def x(els: String*): Int = els.length
}

trait VarargTrait {
  def x(i: Int): Int = i
  @varargs
  def x(els: String*): Int = els.length
}
object VarargTrait extends VarargTrait
object ObjectInheritsImplFromTrait extends VarargTrait
class ClassInheritsImplFromTrait extends VarargTrait

abstract class VarargClass {
  def x(i: Int): Int = i
  @varargs
  def x(els: String*): Int = els.length
}
object VarargClass extends VarargClass
object ObjectInheritsImplFromClass extends VarargClass
class ClassInheritsImplFromClass extends VarargClass

object ObjectOverridesImplFromTrait extends VarargTrait {
  override def x(els: String*): Int = 0
}
class ClassOverridesImplFromTrait extends VarargTrait {
  override def x(els: String*): Int = 0
}

object ObjectOverridesImplFromClass extends VarargClass {
  override def x(els: String*): Int = 0
}
class ClassOverridesImplFromClass extends VarargClass {
  override def x(els: String*): Int = 0
}

trait VarargAbstractTrait {
  def x(i: Int): Int = i
  @varargs
  def x(els: String*): Int
}
object ObjectImplementsTrait extends VarargAbstractTrait {
  override def x(els: String*): Int = els.length
}
class ClassImplementsTrait extends VarargAbstractTrait {
  override def x(els: String*): Int = els.length
}

abstract class VarargAbstractClass {
  def x(i: Int): Int = i
  @varargs
  def x(els: String*): Int
}
object ObjectImplementsClass extends VarargAbstractClass {
  override def x(els: String*): Int = els.length
}
class ClassImplementsClass extends VarargAbstractClass {
  override def x(els: String*): Int = els.length
}

object Anonymous {
  def inheritsImplFromTrait() = new VarargTrait {}
  def inheritsImplFromClass() = new VarargClass {}
  def overridesImplFromTrait() = new VarargTrait {
    override def x(els: String*): Int = 0
  }
  def overridesImplFromClass() = new VarargClass {
    override def x(els: String*): Int = 0
  }
  def implementsTrait = new VarargAbstractTrait {
    def x(els: String*): Int = els.length
  }
  def implementsClass = new VarargAbstractClass {
    def x(els: String*): Int = els.length
  }
}

trait TraitInheritsFromTrait extends VarargTrait
abstract class ClassInheritsFromTraitInheritsFromTrait extends TraitInheritsFromTrait

object ObjectImplementsJavaInterface extends JavaInterface {
  def x(els: String*): Int = els.length
}
class ClassImplementsJavaInterface extends JavaInterface {
  def x(els: String*): Int = els.length
}

object ObjectImplementsJavaAbstractClass extends JavaAbstractClass {
  def x(els: String*): Int = els.length
}
class ClassImplementsJavaAbstractClass extends JavaAbstractClass {
  def x(els: String*): Int = els.length
}

object ObjectInheritsFromJavaClass extends JavaClass
class ClassInheritsFromJavaClass extends JavaClass