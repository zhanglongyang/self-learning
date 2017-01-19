package example

import scala.reflect.macros.blackbox

object Macros {
  def hello: Unit = macro helloImpl

  def helloImpl(c: blackbox.Context): c.Expr[Unit] = {

  }

}
