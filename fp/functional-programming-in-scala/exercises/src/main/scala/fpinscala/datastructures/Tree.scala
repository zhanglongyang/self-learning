package fpinscala.datastructures

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]


object Tree {
  def size[A](t: Tree[A]): Int = {
    t match {
      case Leaf(v) => 1
      case Branch(l, r) => size(l) + size(r)
    }
  }

  def fold[A](t: Tree[A], m: A)(f: (A, A) => A): A = {
    t match {
      case Leaf(v) => f(m, v)
      case Branch(l, r) => f(fold(l, m)(f), fold(r, m)(f))
    }
  }

  def maximum(t: Tree[Int]): Int = {
    fold(t, 0)((x, y) => x max y)
  }

  def depth[A](t: Tree[A]): Int = {
    t match {
      case Leaf(_) => 0
      case Branch(l, r) => 1 + (depth(l) max depth(r))
    }
  }

  def map[A, B](t: Tree[A])(f: A => B): Tree[B] = {
    t match {
      case Leaf(v) => Leaf(f(v))
      case Branch(l, r) => Branch(map(l)(f), map(r)(f))
    }
  }
}