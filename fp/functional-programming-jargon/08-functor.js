// An object that implements a `map` function which adheres to two rules:

// 1. preserves identity
object.map(x => x) === object

// 2. composable
object.map(x = f(g(x))) === object.map(g).map(f)

// Pointed Functor
Array.of(1)
