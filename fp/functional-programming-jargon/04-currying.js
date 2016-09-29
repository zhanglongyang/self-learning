const sum = (a, b) => a + b

const curriedSum = (a) => (b) => a + b
curriedSum(2)(39)

const add2 = curriedSum(2)
add2(10)

const add = (x, y) => x + y

const curriedAdd = _.curry(add)
curriedAdd(1, 2)
curriedAdd(1)
curriedAdd(1)(2)
